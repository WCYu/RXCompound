package com.rxjy.rxcompound.supervision.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.MatListAdapter;
import com.rxjy.rxcompound.supervision.entity.MatListInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.MatListContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.MatListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatListActivity extends BaseActivity<MatListPresenter> implements MatListContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_mat_list)
    ListView lvMatList;

    private static final String TITLE = "材料清单";

    private List<MatListInfo.MatInfo> matList;

    private MatListAdapter mAdapter;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_mat_list;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initMatList();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_MAT_LIST_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initMatList() {

        matList = new ArrayList<>();

        mAdapter = new MatListAdapter(this, matList);

        lvMatList.setAdapter(mAdapter);

        mPresenter.getMatList(proInfo.getOrderNo());

    }

    @Override
    protected MatListPresenter onCreatePresenter() {
        return new MatListPresenter(this);
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
    public void responseMatListData(List<MatListInfo.MatInfo> dataList) {
        matList.clear();
        matList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMatListDataError(String msg) {
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
