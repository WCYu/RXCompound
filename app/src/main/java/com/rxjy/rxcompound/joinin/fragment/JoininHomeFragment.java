package com.rxjy.rxcompound.joinin.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/21.
 */

public class JoininHomeFragment extends BaseFragment {
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int getFragmentLayout() {
        return R.layout.joinin_homefragment;
    }

    @Override
    protected void FragmentInitData() {
        tvTitle.setText("首页");
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
