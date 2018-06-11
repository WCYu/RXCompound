package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.mvp.contract.ImageShowDesContract;
import com.rxjy.rxcompound.mvp.presenter.ImageShowDesPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/21.
 */

public class ImageShowDesActivity extends BaseActivity<ImageShowDesPresenter> implements ImageShowDesContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.iv_img)
    ImageView ivImg;

    @Override
    public int getLayout() {
        return R.layout.activity_imgshow;
    }

    String type, cardno;

    @Override
    public void initData() {
        cardno = App.cardNo;
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        type = intent.getStringExtra("type");
        Log.e("TYPE==cardno===", type + "..." + cardno);
        //：3学位证，4身份证，5银行卡，6离职证明，7证件照，8体检报告(健康证明) 13身份证反面)
        // 1入职申请表，2简历表，3学位证，4身份证，5银行卡，6离职证明，7证件照，8体检报告，
        // 9劳动合同，10背景调查，11保密协议，13身份证反面,17个人形象照
        String img = intent.getStringExtra("img");
        tvRight.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
        Glide.with(this).load(img).into(ivImg);

    }

    @Override
    protected ImageShowDesPresenter onCreatePresenter() {
        return new ImageShowDesPresenter(this);
    }


    @Override
    public void responseDesIdenImgMessage(ImageDesBean data) {
        //显示
        Log.e("数据：：：",data.getBody().toString());
        Glide.with(this).load(imgone.get(0)).into(ivImg);
        Log.e("type"+type,"caocaocao");
        //修改上一页面图片
        if(type.equals("4")||type.equals("13")||type.equals("17")){
            DesIdentityInfoActivity.instent.changetype=type;
            switch (type){
                case "4":
                    DesIdentityInfoActivity.instent.backidcardone=data.getBody().getUrl();
                    break;
                case "13":
                    DesIdentityInfoActivity.instent.backidcardtwo=data.getBody().getUrl();
                    break;
                case "17":
                    DesIdentityInfoActivity.instent.backxingxiang=data.getBody().getUrl();
                    break;
            }
        }else if(type.equals("5")||type.equals("39")||type.equals("40")||type.equals("41")){
            Log.e("type"+type,"进来没？？");
            DesEnterJobActivity.instent.changetype=type;
            Log.e("type"+type,"。。。。。。");
            switch (type){
                case "5":
                    Log.e("1111","22222");
                    DesEnterJobActivity.instent.backbankimg=data.getBody().getUrl();
                    break;
                case "39":
                    DesEnterJobActivity.instent.backdehelpimg=data.getBody().getUrl();
                    break;
                case "40":
                    DesEnterJobActivity.instent.backdemiddleimg=data.getBody().getUrl();
                    break;
                case "41":
                    DesEnterJobActivity.instent.backdehightimg=data.getBody().getUrl();
                    break;
            }
        }
    }

    @Override
    public void responseDesIdenImgMessageError(String msg) {
        showToast("上传图片失败");
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                        .forResult(666);//结果回调onActivityResult code 
                break;
        }
    }

    ArrayList<String> imgone = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                imgone = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgone.add(localMedias.get(i).getCutPath());
                    }
                    mPresenter.upLoadDesIdentityImg(cardno, type, imgone);
                }
                break;
        }
    }

}
