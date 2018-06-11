package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.TimeUtil;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.ProcessAdapter;
import com.rxjy.rxcompound.supervision.entity.PrepareInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PrepareContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.PreparePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrepareActivity extends BaseActivity<PreparePresenter> implements PrepareContract.View, ExpandableListView.OnChildClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_prepare_tip)
    TextView tvTip;
    @Bind(R.id.tv_prepare_pro_name)
    TextView tvProName;
    @Bind(R.id.tv_prepare_address)
    TextView tvAddress;
    @Bind(R.id.tv_prepare_time)
    TextView tvTime;
    @Bind(R.id.elv_prepare)
    ExpandableListView elvPrepare;

    public static final String TITLE = "开工前准备";

    private List<PrepareInfo.PrepareGroup> processList;

    private ProcessAdapter mAdapter;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_prepare;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPro();
        initPrepare();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PREPARE_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPro() {
        tvProName.setText(proInfo.getProName());
        tvAddress.setText(proInfo.getProAddr());
        tvTime.setText(TimeUtil.getNormalTime(proInfo.getBeginTime()) + "-" + TimeUtil.getNormalTime(proInfo.getEndTime()));
    }

    private void initPrepare() {

        processList = new ArrayList<>();

        mAdapter = new ProcessAdapter(this, processList);

        elvPrepare.setAdapter(mAdapter);

        elvPrepare.setOnChildClickListener(this);

    }

    @Override
    protected PreparePresenter onCreatePresenter() {
        return new PreparePresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getProjectProcess(proInfo.getOrderNo());
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        PrepareInfo.PrepareGroup.PrepareChild info = processList.get(groupPosition).getList().get(childPosition);
        Intent intent = new Intent(this, PrepareDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_PREPARE_DETAIL_PROCESS_ID, info.getProcess_id());
        startActivity(intent);
        return false;
    }

    @Override
    public void responsePrepareData(List<PrepareInfo.PrepareGroup> dataList) {
        processList.clear();
        processList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responsePrepareDataError(String msg) {
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
