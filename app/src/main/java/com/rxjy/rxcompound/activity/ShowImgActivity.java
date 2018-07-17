package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowImgActivity extends BaseActivity {

    @Bind(R.id.showimg)
    ImageView showimg;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.rl_back)
    RelativeLayout rlBack;

    @Override
    public int getLayout() {
        return R.layout.activity_show_img;
    }

    @Override
    public void initData() {
        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
        rlBack.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDes));
        switch (title) {
            case "加盟":
                showimg.setBackgroundResource(R.drawable.jiamengimg);
                break;
            case "店铺":
                showimg.setBackgroundResource(R.drawable.dainpu);
                break;
            case "案例":
                showimg.setBackgroundResource(R.drawable.anliimg);
                tvRight.setVisibility(View.VISIBLE);
                tvRight.setText("上传");
                tvRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ShowImgActivity.this, ShowImgActivity.class);
                        intent.putExtra("title", "上传");
                        startActivity(intent);
                        finish();
                    }
                });
                break;
            case "施工":
                showimg.setBackgroundResource(R.drawable.shigongimg);
                break;
            case "财务":
                showimg.setBackgroundResource(R.drawable.caiwuimg);
                break;
            case "项目":
                showimg.setBackgroundResource(R.drawable.xiangmuimg);
                break;
            case "交流":
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int widthPixels = dm.widthPixels;
                int heightPixels = dm.heightPixels;
                ViewGroup.LayoutParams layoutParams = showimg.getLayoutParams();
                LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(layoutParams);
                layoutParams1.width = widthPixels;
                layoutParams.height = heightPixels;
                showimg.setLayoutParams(layoutParams1);
                showimg.setBackgroundResource(R.drawable.jiaoliuimg);
                break;
            case "服务":
                showimg.setBackgroundResource(R.drawable.piangjiimg);
                break;
            case "上传":
                showimg.setBackgroundResource(R.drawable.shangchaunimg);
                break;
            default:
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
