package com.rxjy.rxcompound.supervision.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.supervision.activity.PushElectronicActivity;
import com.rxjy.rxcompound.supervision.adapter.ElectronicAdapter;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.ElectronicContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.ElectronicPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/12/21.
 */

public class ElectronicFragment extends BaseFragment<ElectronicPresenter> implements ElectronicContract.View, AdapterView.OnItemClickListener {
    @Bind(R.id.lv_electronic)
    ListView lvElectronic;

    private List<DatumListInfo.DatumInfo.Datum> datumList;

    private ElectronicAdapter mAdapter;

    private ProjectListInfo.Project proInfo;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_electronic;
    }

    @Override
    protected void FragmentInitData() {
        initIntent();
        initElectronic();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getArguments().getSerializable(Constants.ACTION_TO_ELECTRONIC_PRO_INFO);
    }

    private void initElectronic() {

        datumList = new ArrayList<>();

        mAdapter = new ElectronicAdapter(getActivity(), datumList);

        lvElectronic.setAdapter(mAdapter);

        lvElectronic.setOnItemClickListener(this);

    }

    @Override
    protected ElectronicPresenter onCreatePresenter() {
        return new ElectronicPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getPaperInfo(proInfo.getOrderNo());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void responsePaperData(DatumListInfo.DatumInfo data) {
        datumList.clear();
        datumList.addAll(data.getAgoInfo());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responsePaperDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DatumListInfo.DatumInfo.Datum info = datumList.get(position);
        Intent intent = new Intent(getActivity(), PushElectronicActivity.class);
        intent.putExtra(Constants.ACTION_TO_ELECTRONIC_DATUM_INFO, info);
        startActivity(intent);
    }
}
