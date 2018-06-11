package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.ImagesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.mvp.contract.ImagesShowContract;
import com.rxjy.rxcompound.mvp.presenter.ImagesShowPresenter;
import com.rxjy.rxcompound.widget.PinchImageView;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/25.
 */

public class ImagesShowActivity extends BaseActivity<ImagesShowPresenter> implements ImagesShowContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.vp_imgs)
    ViewPager vpImgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_imgsshow;
    }

    String cardno, type;

    @Override
    public void initData() {
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        cardno = sp.getString("rxdy_cardno", null);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        type = intent.getStringExtra("type");
        tvTitle.setText(title);
        tvRight.setVisibility(View.VISIBLE);
        mPresenter.getImgsData(cardno, type);
    }

    MyPagerAdapter myPagerAdapter;
    ArrayList<View> views = new ArrayList<>();

    @Override
    public void responseImgsData(ImagesBean data) {
        views = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            if (!StringUtils.isEmpty(data.getBody().get(i).getImg_url())) {
                PinchImageView piv = new PinchImageView(this);
//                piv.setScaleType(ImageView.ScaleType.CENTER);
                piv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                Glide.with(this).load(data.getBody().get(i).getImg_url()).into(piv);
                views.add(piv);
            }
        }
        myPagerAdapter = new MyPagerAdapter(views);
        vpImgs.setAdapter(myPagerAdapter);
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

    @Override
    protected ImagesShowPresenter onCreatePresenter() {
        return new ImagesShowPresenter(this);
    }


    @Override
    public void responseImgsDataError(String msg) {

    }

    @Override
    public void responseupImages(ImgBean data) {
        views = new ArrayList<>();
        for (int i = 0; i < imgslist.size(); i++) {
            PinchImageView piv = new PinchImageView(this);
            piv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(this).load(imgslist.get(i)).into(piv);
            views.add(piv);
        }
        myPagerAdapter = new MyPagerAdapter(views);
        vpImgs.setAdapter(myPagerAdapter);
        if (type.equals("4") || type.equals("13")) {
//            IdentityInfoActivity.instance.change = 1;
        } else {
            ZThreeActivity.instance.change = 1;
        }
    }

    @Override
    public void responseupImagesError(String msg) {
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


    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right://修改上传图片
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                        .forResult(668);//结果回调onActivityResult code 
//                Album.album(this)
//                        .requestCode(668)
//                        .toolBarColor(Color.BLACK)
//                        .statusBarColor(Color.BLACK)
//                        .navigationBarColor(Color.BLACK)
//                        .title("选择图片")
//                        .selectCount(10)
//                        .columnCount(2)
//                        .camera(true)
//                        .start();
                break;
        }
    }


    ArrayList<String> imgslist = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 668:
                imgslist = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgslist.add(localMedias.get(i).getCutPath());
                    }
//                    imgslist = Album.parseResult(data);
                    //上传
                    mPresenter.upImages(cardno, type, imgslist);
                }
                break;
        }
    }

}
