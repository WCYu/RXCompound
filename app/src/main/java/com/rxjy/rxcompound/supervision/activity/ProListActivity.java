package com.rxjy.rxcompound.supervision.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.ProListAdapter;
import com.rxjy.rxcompound.supervision.entity.ProListInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.ProListContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.ProListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProListActivity extends BaseActivity<ProListPresenter> implements ProListContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_pro_list)
    ListView lvProList;

    public static final String TITLE = "项目清单";

    private List<ProListInfo.ProList> proList;

    private ProListAdapter mAdapter;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_pro_list;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initProList();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_LIST_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initProList() {

        proList = new ArrayList<>();

        mAdapter = new ProListAdapter(this, proList);

        lvProList.setAdapter(mAdapter);

        mPresenter.getProList(proInfo.getOrderNo());

    }

    @Override
    protected ProListPresenter onCreatePresenter() {
        return new ProListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseProListData(List<ProListInfo.ProList> dataList) {
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
