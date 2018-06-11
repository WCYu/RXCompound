package com.rxjy.rxcompound.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.ComplantAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.GlideRoundTransform;
import com.rxjy.rxcompound.entity.ArticleBean;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.mvp.contract.PubLishContract;
import com.rxjy.rxcompound.mvp.presenter.PublishPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/15.
 */

public class PublishActivity extends BaseActivity<PublishPresenter> implements PubLishContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.btn_submit)
    TextView btnSubmit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.publish_content)
    EditText publishContent;
    @Bind(R.id.complant_grid)
    ImageView complantGrid;
    ComplantAdapter complantAdapter;
    @Bind(R.id.delete_image)
    ImageView deleteImage;
    @Bind(R.id.article_title)
    EditText articleTitle;
    private int CAMERA_INFO_IDENTIFICATION_PHOTO = 1000;
    private String icCardUpUrl = "";
    RequestOptions options;
    private int flag;
    ArrayList<String> list_imguplode;
    private String title;
    private String content;

    @Override
    public int getLayout() {
        return R.layout.activity_publish;
    }

    @Override
    public void initData() {
        list_imguplode = new ArrayList<>();
        options = new RequestOptions();
        options.centerCrop().transform(new GlideRoundTransform(this, 6));
        tvTitle.setText("撰写");

        complantGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                if (flag == 0) {
                    PictureSelector.create(PublishActivity.this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(CAMERA_INFO_IDENTIFICATION_PHOTO);//结果回调onActivityResult code 
                }
            }
        });
    }

    @Override
    protected PublishPresenter onCreatePresenter() {
        return new PublishPresenter(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                closeKeyboard();
                finish();
                break;
            case R.id.btn_submit:
                closeKeyboard();
                //article_title
                if(!articleTitle.getText().toString().equals("")&&!publishContent.getText().toString().equals("")&&flag==1){
                    title = articleTitle.getText().toString();
                    content = publishContent.getText().toString();
                    list_imguplode.clear();
                    list_imguplode.add(icCardUpUrl);
                    mPresenter.upLoadImg(list_imguplode);
                }else {
                    showToast("资料不全");
                }

                break;
        }
    }


    @OnClick(R.id.delete_image)
    public void onViewClicked() {
        deleteImage.setVisibility(View.GONE);
        flag = 0;
        Glide.with(this).load(R.mipmap.addpictures).apply(options).into(complantGrid);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_INFO_IDENTIFICATION_PHOTO) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            icCardUpUrl = localMedias.get(0).getCompressPath();
            Glide.with(this).load(icCardUpUrl).apply(options).into(complantGrid);
            deleteImage.setVisibility(View.VISIBLE);
            flag = 1;
        }

    }

    @Override
    public void responseArticleData(ArticleBean.BodyBean body) {
        finish();
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
    public void showMessage(String msg) {
        showToast(msg);
    }
    private String upimgstr = "";
    @Override
    public void responseImg(FigureImgBean data) {

        for (int i = 0; i < data.getBody().size(); i++) {
            upimgstr = upimgstr + data.getBody().get(i) + ";";
        }
        upimgstr = upimgstr.substring(0, upimgstr.length() - 1);
        Log.e("tag",title+"====="+App.cardNo+"======"+App.name+"========"+upimgstr+" ========="+content+"0");
        mPresenter.psetArticleData(title, App.cardNo,App.name,upimgstr,content,"0");
    }

    @Override
    public void responseImgError(String msg) {

    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
