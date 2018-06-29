package com.rxjy.rxcompound.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/21.
 */

public class activityImage extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.picture_image)
    ImageView pictureImage;

    @Override
    public int getLayout() {
        return R.layout.activity_image;
    }

    @Override
    public void initData() {
        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
        switch (title) {
            case "财务":
                pictureImage.setImageResource(R.mipmap.yuecaiwu);
                break;
            case "资金":
                pictureImage.setImageResource(R.mipmap.yuezijin);
                break;
            case "商务":
                pictureImage.setImageResource(R.mipmap.shangwu);
                break;
            case "主案":
                pictureImage.setImageResource(R.mipmap.zhuan);
                break;
            case "工程":
                pictureImage.setImageResource(R.mipmap.gongchengyue);
                break;
            case "公司":
                pictureImage.setImageResource(R.mipmap.gongsi);
                break;
        }
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
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
}
