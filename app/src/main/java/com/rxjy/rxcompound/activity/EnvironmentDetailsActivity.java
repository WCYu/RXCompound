package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.ImageAddAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.EnvirImgBean;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.mvp.contract.EnvirDetailsContract;
import com.rxjy.rxcompound.mvp.presenter.EnvirDetailsPresenter;
import com.rxjy.rxcompound.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/25.
 */

public class EnvironmentDetailsActivity extends BaseActivity<EnvirDetailsPresenter> implements EnvirDetailsContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.gv_top)
    RelativeLayout gvTop;
    @Bind(R.id.ed_idea)
    EditText edIdea;
    @Bind(R.id.gv_img)
    MyGridView gvImg;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.iv_picexample)
    ImageView ivPicexample;

    @Override
    public int getLayout() {
        return R.layout.activity_figuredetails;
    }

    String getid, getcontentid, getareaname;

    @Override
    public void initData() {
        Intent intent = getIntent();
        getid = intent.getStringExtra("getid");
        getcontentid = intent.getStringExtra("getcontentid");
        getareaname = intent.getStringExtra("getareaname");
        Log.e("getid" + getid, "getcontentid" + getcontentid);
        tvTitle.setText(getareaname);
        tvSubmit.setText("提交");
        gvTop.setVisibility(View.GONE);
        mPresenter.getImg(getid);
        list_img = new ArrayList<>();
        list_imguplode = new ArrayList<>();
        list_img.add("");
        list_lm = new ArrayList<>();
        ShowImageAdd();
    }

    @Override
    protected EnvirDetailsPresenter onCreatePresenter() {
        return new EnvirDetailsPresenter(this);
    }




    String idea;

    @OnClick({R.id.iv_back, R.id.tv_submit,R.id.iv_picexample})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                idea = edIdea.getText().toString();
                if (StringUtils.isEmpty(idea)) {
                    showToast("请输入这一刻的想法！");
                    return;
                }
                if (list_imguplode.size() <= 0) {
                    showToast("请选择图片！");
                    return;
                }
                if (list_imguplode.size() <2 ) {
                    showToast("请至少上传两张图片！");
                    return;
                }
                tvSubmit.setEnabled(false);
                mPresenter.upLoadImg(list_imguplode);
                break;
            case R.id.iv_picexample://放大
                if(watchimglist!=null&&watchimglist.size()>0){
                    App.titletopcolor=1;
                    watchLargerImage2("",watchimglist,0);
                }
                break;
        }
    }


    ArrayList<String> list_img;
    ArrayList<String> list_imguplode;
    List<LocalMedia> list_lm;
    ImageAddAdapter imageAddAdapter;
    private void ShowImageAdd() {
        imageAddAdapter = new ImageAddAdapter(this, list_img);
        gvImg.setAdapter(imageAddAdapter);
        gvImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == list_img.size() - 1) {//点击添加图片
                    PictureSelector.create(EnvironmentDetailsActivity.this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .minSelectNum(0)
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(false)//是否剪裁
                            .compress(true)
                            .selectionMedia(list_lm)
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(666);//结果回调onActivityResult code 
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                list_img.clear();
                list_imguplode.clear();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    list_lm = localMedias;
                    for (int i = 0; i < localMedias.size(); i++) {
                        list_img.add(localMedias.get(i).getCompressPath());
                        list_imguplode.add(localMedias.get(i).getCompressPath());
                    }
                }
                list_img.add(null);
                imageAddAdapter.notifyDataSetChanged();
                break;
        }
    }

    private String upimgstr = "";
    @Override
    public void responseImg(FigureImgBean data) {
        for (int i = 0; i < data.getBody().size(); i++) {
            upimgstr = upimgstr + data.getBody().get(i) + ";";
        }
        upimgstr = upimgstr.substring(0, upimgstr.length() - 1);
        mPresenter.upLoadData(idea, upimgstr, getid, getcontentid, App.cardNo, App.name, "2", App.regionid, getareaname);
    }

    @Override
    public void responseImgError(String msg) {
        tvSubmit.setEnabled(true);
        showToast(msg);
    }

    @Override
    public void responseData() {
        showToast("提交成功！");
        finish();
    }

    @Override
    public void responseDataError(String msg) {
        tvSubmit.setEnabled(true);
        showToast(msg);
    }

    ArrayList<String> watchimglist;
    @Override
    public void responsegetImg(EnvirImgBean data) {
        if(data.getBody()!=null&&data.getBody().size()>0){
            watchimglist=new ArrayList<>();
            watchimglist.add(data.getBody().get(0).getImgUrl());
            Glide.with(this).load(data.getBody().get(0).getImgUrl()).into(ivPicexample);
        }
    }

    @Override
    public void responsegetImgError(String msg) {
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
