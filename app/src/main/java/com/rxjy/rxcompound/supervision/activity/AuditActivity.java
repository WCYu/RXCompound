package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.AuditAdapter;
import com.rxjy.rxcompound.supervision.entity.AuditListInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.AuditContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.AuditPresenter;
import com.rxjy.rxcompound.widget.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuditActivity extends BaseActivity<AuditPresenter> implements AuditContract.View, XListView.IXListViewListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_header)
    TextView tvHeader;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_audit)
    XListView lvAudit;

    public static final String TITLE = "审计清单";

    private List<AuditListInfo.AuditList.AuditInfo> auditList;

    private AuditAdapter mAdapter;

    private ProjectListInfo.Project proInfo;

    private int pageIndex = 1;

    private int pageSize = 10;

    @Override
    public int getLayout() {
        return R.layout.activity_audit;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initAudit();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_AUDIT_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
        tvHeader.setText("项目清单");
    }

    private void initAudit() {

        auditList = new ArrayList<>();

        mAdapter = new AuditAdapter(this, auditList);

        lvAudit.setAdapter(mAdapter);

        lvAudit.setPullLoadEnable(false);

        lvAudit.setXListViewListener(this);

        mPresenter.getAuditList(proInfo.getOrderNo(), pageIndex, pageSize);

    }

    @Override
    protected AuditPresenter onCreatePresenter() {
        return new AuditPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        //刷新审计列表
        mPresenter.getAuditList(proInfo.getOrderNo(), pageIndex, pageSize);
    }

    @Override
    public void onLoadMore() {
        pageIndex++;
        //加载更多审计列表
        mPresenter.getAuditListLoadMore(proInfo.getOrderNo(), pageIndex, pageSize);
    }

    //停止刷新
    private void onLoad() {
        lvAudit.stopRefresh();
        lvAudit.stopLoadMore();
        lvAudit.setRefreshTime("刚刚");
    }

    //是否显示加载更多
    private void isShowLoad(int size) {
        if (size < pageSize) {
            lvAudit.setPullLoadEnable(false);
        } else {
            lvAudit.setPullLoadEnable(true);
        }
    }

    @Override
    public void responseAuditListData(List<AuditListInfo.AuditList.AuditInfo> dataList) {
        auditList.clear();
        auditList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        isShowLoad(dataList.size());
        onLoad();
    }

    @Override
    public void responseAuditListDataError(String msg) {
        showToast(msg);
        isShowLoad(0);
        onLoad();
    }

    @Override
    public void responseAuditListLoadMoreData(List<AuditListInfo.AuditList.AuditInfo> dataList) {
        auditList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        isShowLoad(dataList.size());
        onLoad();
    }

    @Override
    public void responseAuditListLoadMoreDataError(String msg) {
        showToast(msg);
        isShowLoad(0);
        onLoad();
    }

    @OnClick({R.id.iv_back, R.id.tv_header})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_header:
                Intent intent = new Intent(this, ProListActivity.class);
                intent.putExtra(Constants.ACTION_TO_PRO_LIST_PRO_INFO, proInfo);
                startActivity(intent);
                break;
        }
    }
}