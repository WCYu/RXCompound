package com.rxjy.rxcompound.supervision.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.activity.ProDetailActivity;
import com.rxjy.rxcompound.supervision.adapter.ProjectAdapter;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.HomeContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/2/1.
 */

public class ProjectFragment extends BaseFragment<HomePresenter> implements HomeContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_home)
    ListView lvHome;

    public static final String TITLE = "项目监理";

    private List<ProjectListInfo.Project> proList;

    private ProjectAdapter mAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_project;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
        initPro();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
        ivBack.setImageResource(R.mipmap.service_gray_icon);
    }

    private void initPro() {

        proList = new ArrayList<>();

        mAdapter = new ProjectAdapter(getActivity(), proList);

        lvHome.setAdapter(mAdapter);

        lvHome.setOnItemClickListener(this);

    }

    @Override
    protected HomePresenter onCreatePresenter() {
        return new HomePresenter(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("App.cardNo",App.cardNo);
        mPresenter.getProList(App.cardNo);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "15313699627"));
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ProjectListInfo.Project info = proList.get(position);
        Intent intent = new Intent(getActivity(), ProDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO, info);
        startActivity(intent);
    }

    @Override
    public void responseProListData(List<ProjectListInfo.Project> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void responseProListDataError(String msg) {
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

}
