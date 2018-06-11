package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.MsgNumBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/20.
 */

public class ImageShowActivity extends BaseActivity<BaseInformPresenter> implements BaseInformContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.iv_img)
    ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_imgshow;
    }

    String type, cardno;

    @Override
    public void initData() {

        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        cardno = sp.getString("rxdy_cardno", null);
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
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }


    @Override
    public void responsegetMessage(String s, PersonBean data) {

    }

    @Override
    public void responsegetMessageError(String msg) {

    }

    @Override
    public void responseUpdateMessage(PersonBean data) {

    }

    @Override
    public void responseUpdateMessageError(String msg) {

    }

    @Override
    public void responseUpdateMessagebank(PersonBean data) {

    }

    @Override
    public void responseUpdateMessagebankError(String msg) {

    }

    @Override
    public void responseBankList(BankBean data) {

    }

    @Override
    public void responseBankListError(String msg) {

    }

    @Override
    public void responseImg(ImgBean data) {
        //显示
        Glide.with(this).load(imgone.get(0)).into(ivImg);
        //修改上一页面图片
        if (type.equals("4") || type.equals("13")||type.equals("17")) {
            IdentityInfoNewActivity.instance.change = 1;
//            if(type.equals("17")){
//                BaseInformationActivity.aboutsend.iconischange="1";
//                MainFragment.aboutsends.iconischange="1";
//            }
        } else {
//            EnterJobActivity.instance.change = 1;
            ZThreeActivity.instance.change = 1;
        }
    }

    @Override
    public void responseImgError(String msg) {

    }

    @Override
    public void responseIcon(IconBean data) {

    }

    @Override
    public void responseIconError(String msg) {

    }

    @Override
    public void responseUserStatus(UserStatusBean data) {

    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void responseMsgStatus(MsgNumBean data) {

    }

    @Override
    public void responseMsgError(String msg) {

    }

    @Override
    public void responseDesMessage(DesBaseInfoBean data) {

    }

    @Override
    public void responseDesMessageError(String msg) {

    }

    @Override
    public void responseIsConsent(ResultBean data) {

    }

    @Override
    public void responseIsConsentError(String msg) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
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
//                Album.album(this)
//                        .requestCode(666)
//                        .toolBarColor(Color.BLACK)
//                        .statusBarColor(Color.BLACK)
//                        .navigationBarColor(Color.BLACK)
//                        .title("选择图片")
//                        .selectCount(1)
//                        .columnCount(2)
//                        .camera(true)
//                        .start();
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
//                    imgone = Album.parseResult(data);
                    mPresenter.upLoadImg(cardno, type, imgone);
                }
                break;
        }
    }
}
