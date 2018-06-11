package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/16.
 */
public class TextDetailsActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.textView25)
    TextView textView25;

    @Override
    public int getLayout() {
        return R.layout.activity_txtdetails;
    }

    @Override
    public void initData() {
        tvTitle.setText("内容详情");
        Intent intent=getIntent();
        String str=intent.getStringExtra("txt");
        textView25.setText(str);
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