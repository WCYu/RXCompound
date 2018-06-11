package com.rxjy.rxcompound.supervision.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.supervision.adapter.RoutingDetailAdapter;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.entity.RoutingDetailInfo;
import com.rxjy.rxcompound.supervision.entity.RoutingListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.RoutingDetailContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.RoutingDetailPresenter;
import com.rxjy.rxcompound.widget.CustomListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewRoutingDetailActivity extends BaseActivity<RoutingDetailPresenter> implements RoutingDetailContract.View, RoutingDetailAdapter.OnRoutingDetailClickListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_new_routing_detail)
    CustomListView lvNewRoutingDetail;

    public static final String TITLE = "巡检详情";

    private RoutingDetailAdapter mAdapter;

    private List<RoutingDetailInfo.RoutingMarkInfo> routList;

    private ProjectListInfo.Project proInfo;

    private RoutingListInfo.RoutingInfo routInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_new_routing_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initRoutingDetail();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_DETAIL_PRO_INFO);
        routInfo = (RoutingListInfo.RoutingInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_DETAIL_ROUTING_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initRoutingDetail() {

        routList = new ArrayList<>();

        mAdapter = new RoutingDetailAdapter(this, routList);

        mAdapter.setOnRoutingSubClickListener(this);

        lvNewRoutingDetail.setAdapter(mAdapter);

        mPresenter.getRoutingDetail(proInfo.getOrderNo(), routInfo.getXj_id());

    }

    @Override
    protected RoutingDetailPresenter onCreatePresenter() {
        return new RoutingDetailPresenter(this);
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
    public void responseRoutingDetail(List<RoutingDetailInfo.RoutingMarkInfo> dataList) {
        routList.clear();
        routList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseRoutingDetailError(String msg) {
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
    public void onRoutingDetailClickListener(int position, RoutingDetailInfo.RoutingMarkInfo data) {
        List<LocalMedia> photoList = new ArrayList<>();
        photoList.clear();
        for (String url : data.getXj_photoUrl()) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(url);
            photoList.add(localMedia);
        }
        if (photoList.size() == 0) {
            showToast("暂无上传图片...");
        } else {
            PictureSelector.create(this).externalPicturePreview(position, photoList);
        }
    }
}
