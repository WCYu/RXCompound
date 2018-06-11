package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.supervision.adapter.ProcessDetailAdapter;
import com.rxjy.rxcompound.supervision.entity.ProcessDetailInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PrepareDetailContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.PrepareDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrepareDetailActivity extends BaseActivity<PrepareDetailPresenter> implements PrepareDetailContract.View, ProcessDetailAdapter.OnProcessDetailClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_process_detail)
    ListView lvProcessDetail;

    public static final String TITLE = "准备详情";

    private int processID;

    private List<ProcessDetailInfo.ProcessDetail> proList;

    private ProcessDetailAdapter mAdapter;

    //记录是第几个item中点击的上传照片
    private int photoPosition = 0;
    //记录返回照片的路径
    private String photoUrl = "";
    //item中的数据
    private ProcessDetailInfo.ProcessDetail proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_prepare_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPrepare();
    }

    private void initIntent() {
        processID = getIntent().getIntExtra(Constants.ACTION_TO_PREPARE_DETAIL_PROCESS_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPrepare() {

        proList = new ArrayList<>();

        mAdapter = new ProcessDetailAdapter(this, proList);

        mAdapter.setListener(this);

        lvProcessDetail.setAdapter(mAdapter);

        mPresenter.getProcessDetail(processID);

    }

    @Override
    protected PrepareDetailPresenter onCreatePresenter() {
        return new PrepareDetailPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    photoUrl = localMedias.get(0).getCompressPath();
                    mPresenter.subProcessDetailPhoto(proInfo.getStepId(), processID, proInfo.getStepPhotoID(), photoUrl);
                    break;
            }
        }
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseSubProcessPhotoData() {
        showToast("上传成功");
        mPresenter.getProcessDetail(processID);
    }

    @Override
    public void responseSubProcessPhotoDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseProcessDetailData(List<ProcessDetailInfo.ProcessDetail> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseProcessDetailDataError(String msg) {
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
    public void largePhoto(String url) {
        photoPreview(url);
    }

    @Override
    public void subProcessPhoto(ProcessDetailInfo.ProcessDetail data, int position) {
        photoPosition = position;
        proInfo = data;
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .imageSpanCount(3)// 每行显示个数 int
                .maxSelectNum(1)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .compress(true)// 是否压缩 true or fals
                .isCamera(true)// 是否显示拍照按钮 true or false
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
    }
}
