package com.rxjy.rxcompound.activity.more;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/*
* 博文
* */
public class BoWenActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_bo_wen;
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
