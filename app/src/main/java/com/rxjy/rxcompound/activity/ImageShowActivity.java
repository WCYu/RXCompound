package com.rxjy.rxcompound.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.widget.PinchImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hjh on 2017/11/20.
 */

public class ImageShowActivity extends BaseActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvText;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.vp_imgs)
    ViewPager vpImgs;

    private String aid, uid, mid;
    private String[] split;
    private String path;
    private String imgUrl;
    private String imgName;
    private StringBuffer urlBuffer;
    private StringBuffer imgBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_imgshow;
    }

    String title;

    @Override
    public void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tvTitle.setText(title);
        urlBuffer = new StringBuffer();
        imgBuffer = new StringBuffer();
        tvText.setText("修改");
        String image = getIntent().getStringExtra("img");
        split = image.split(";");
        views = new ArrayList<>();
        initVpData(0);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    int positions = 0;

    private void initVpData(int nowitem) {
        tvTitle.setText(title + "(" + (nowitem + 1) + "/" + split.length + ")");
        views.clear();
        for (int i = 0; i < split.length; i++) {
            PinchImageView piv = new PinchImageView(this);
//                piv.setScaleType(ImageView.ScaleType.CENTER);
            piv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(this).load(split[i]).into(piv);
            views.add(piv);
        }
        myPagerAdapter = new MyPagerAdapter(views);
        vpImgs.setAdapter(myPagerAdapter);
        vpImgs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvTitle.setText(title + "(" + (position + 1) + "/" + split.length + ")");
                positions = position;
//                if (imglist.get(position).getCheckState() == 2 || imglist.get(position).getCheckState() == 0) {//显示重新上传
//                    tvText.setVisibility(View.VISIBLE);
//                } else {
//                    tvText.setVisibility(View.INVISIBLE);
//                }
//                aid = imglist.get(position).getAttrId();
//                mid = imglist.get(position).getModelId() + "";
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setImg(int code) {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .enableCrop(true)// 是否裁剪 true or false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                .forResult(code);//结果回调onActivityResult code 

        if (code == 106) {
            PictureSelector.create(this)
                    .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .imageSpanCount(3)// 每行显示个数 int
                    .maxSelectNum(9)// 最大图片选择数量 int
                    .minSelectNum(0)// 最小选择数量 int
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .compress(true)// 是否压缩 true or fals
                    .isCamera(true)// 是否显示拍照按钮 true or false
                    .forResult(code);//结果回调onActivityResult code 
        }
    }

    MyPagerAdapter myPagerAdapter;
    ArrayList<View> views = new ArrayList<>();


    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:

                break;
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        private ArrayList<View> viewslists;

        private int size;

        public MyPagerAdapter(ArrayList<View> viewslists) {
            this.viewslists = viewslists;
            size = viewslists == null ? 0 : viewslists.size();
        }

        public void setViewslists(ArrayList<View> viewslists) {
            this.viewslists = viewslists;
            size = viewslists == null ? 0 : viewslists.size();
        }

        public void finishUpdate(View arg0) {
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewslists.get(position % size));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewslists.get(position % size), 0);
            return viewslists.get(position % size);
        }
    }
}
