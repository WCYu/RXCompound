package com.rxjy.rxcompound.activity.more;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/*
* 财务
* */

public class CaiWuActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_cai_wu;
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
