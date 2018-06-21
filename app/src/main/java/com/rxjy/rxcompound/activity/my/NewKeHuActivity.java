package com.rxjy.rxcompound.activity.my;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.fragment.CustomerNewFragment;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewKeHuActivity extends BaseActivity {

    @Bind(R.id.newkehu_fragment)
    FrameLayout newkehuFragment;

    @Override
    public int getLayout() {
        return R.layout.activity_new_ke_hu;
    }

    @Override
    public void initData() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.newkehu_fragment,new CustomerNewFragment());
        fragmentTransaction.commit();
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
}
