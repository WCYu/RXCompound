package com.rxjy.rxcompound.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.des.adapter.WpsImageViewPagerAdapter;
import com.rxjy.rxcompound.widget.HackyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WpsImageActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.hvp_image)
    HackyViewPager hvpImage;
    @Bind(R.id.tv_image_num)
    TextView tvNum;
   private int position;
    private WpsImageViewPagerAdapter adapter;
    private String baseurl;
    private ArrayList<String> imgUrls;
    private List<String> imgQUrl;
    @Override
    public int getLayout() {
        return R.layout.activity_wps_image;
    }

    @Override
    public void initData() {
        baseurl=getIntent().getStringExtra("BaseUrl");
        imgUrls = getIntent().getStringArrayListExtra(Constants.IMAGE_URL_LIST);
        position=getIntent().getIntExtra("camera_position",-1);
        imgQUrl=new ArrayList<>();

        int size=imgUrls.size();
        for (int i=0;i<size-1;i++){
            imgQUrl.add(baseurl+imgUrls.get(i));
        }

        adapter = new WpsImageViewPagerAdapter(getSupportFragmentManager(),imgQUrl);

        hvpImage.setAdapter(adapter);

        tvNum.setText(position+1 + " / " +imgQUrl.size());
        hvpImage.setCurrentItem(position);
        hvpImage.setOnPageChangeListener(this);

        //设置标题
        tvTitle.setText("图片查看");
        //显示控件
        ivBack.setVisibility(View.VISIBLE);
        //设置点击事件
        ivBack.setOnClickListener(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tvNum.setText(position + 1 + " / " + imgQUrl.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
