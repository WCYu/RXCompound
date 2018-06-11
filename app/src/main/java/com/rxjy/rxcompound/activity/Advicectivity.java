package com.rxjy.rxcompound.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/1/25.
 */

public class Advicectivity extends BaseActivity{

    @Bind(R.id.iv_back)
    ImageView iv_back;


    @Override
    public int getLayout() {
        return R.layout.activity_suggest;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.iv_back})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }



    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
