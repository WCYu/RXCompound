package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.ImageAdapter;
import com.rxjy.rxcompound.supervision.adapter.RoutingMarkAdapter;
import com.rxjy.rxcompound.supervision.entity.ProblemInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.NewRoutingSubContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.NewRoutingSubPresenter;
import com.rxjy.rxcompound.widget.CustomListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewRoutingSubActivity extends BaseActivity<NewRoutingSubPresenter> implements NewRoutingSubContract.View, RoutingMarkAdapter.OnRoutingSubClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_new_routing_sub)
    CustomListView lvNewRoutingSub;
    @Bind(R.id.btn_new_routing_sub)
    Button btnNewRoutingSub;

    public static final String TITLE = "巡检";

    private List<ProblemInfo.Problem> proList;

    private RoutingMarkAdapter mAdapter;

    private ProblemInfo.Problem currentPro;

    private double xjX;

    private double xjY;

    private String city = "";

    private ProjectListInfo.Project proInfo;

    private int xjID;
    private List<Map<String, Object>> datas;


    @Override
    public int getLayout() {
        return R.layout.activity_new_routing_sub;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initRoutingSub();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_SUB_PRO_INFO);
        xjID = getIntent().getIntExtra(Constants.ACTION_TO_ROUTING_SUB_XJ_ID, -1);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initRoutingSub() {

        proList = new ArrayList<>();

        mAdapter = new RoutingMarkAdapter(this, proList);

        mAdapter.setOnRoutingSubClickListener(this);

        lvNewRoutingSub.setAdapter(mAdapter);

        mPresenter.getProblemList();

    }

    @Override
    protected NewRoutingSubPresenter onCreatePresenter() {
        return new NewRoutingSubPresenter(this);
    }



    @OnClick({R.id.iv_back, R.id.btn_new_routing_sub})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_new_routing_sub:
                boolean flag = false;
                for (ProblemInfo.Problem proInfo : proList) {
                    if (proInfo.getRemark() != null)
                        flag = true;
                }
                if (!flag) {
                    showToast("请输入至少一项内容");
                    return;
                }

                mPresenter.subXJProblem(xjID, proInfo.getOrderNo(), "", 1 + "", xjX, xjY, city, 0, proList);
                break;
        }
    }

    @Override
    public void responseRoutingSubData() {
        finish();
    }

    @Override
    public void responseRoutingSubDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseProblemListData(List<ProblemInfo.Problem> dataList) {
        proList.clear();
        proList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseProblemListDataError(String msg) {
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
    public void onRoutingSubClickListener(int position, ProblemInfo.Problem data,List<Map<String, Object>> datas) {
        currentPro = data;

        this.datas=datas;
        if (position == 0) {
            // 进入相册 以下是例子：用不到的api可以不写
            PictureSelector.create(this)
                    .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .imageSpanCount(3)// 每行显示个数 int
                    .maxSelectNum(10)// 最大图片选择数量 int
                    .minSelectNum(1)// 最小选择数量 int
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .compress(true)// 是否压缩 true or fals
                    .cropCompressQuality(80)// 裁剪压缩质量 默认 90 int
                    .isCamera(true)// 是否显示拍照按钮 true or false
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
        } else {
            PictureSelector.create(this).externalPicturePreview((position - 1), data.getPhotoList());
        }
      //  ImageAdapter
    }

    @Override
    public void onRemarkClickListener(int position , ProblemInfo.Problem data) {
        currentPro = data;
        Intent intent = new Intent(this, SubjoinActivity.class);
        intent.putExtra("position",position);
        startActivityForResult(intent, Constants.REQUEST_CODE_REMARK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> photoList;
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    if(currentPro.getPhotoList()==null){
                        photoList=new ArrayList<>() ;
                    }else {
                        photoList=currentPro.getPhotoList();
                    }
                    photoList.addAll(localMedias);
                    currentPro.setPhotoList(photoList);
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        } else if (requestCode == Constants.REQUEST_CODE_REMARK) {
            if (resultCode == Constants.REQUEST_CODE_REMARK) {
                String remark = data.getStringExtra(Constants.BACK_TO_ROUTING_SUB_REMARK);
                currentPro.setRemark(remark);
                mAdapter.notifyDataSetChanged();
            }
        }
    }

}
