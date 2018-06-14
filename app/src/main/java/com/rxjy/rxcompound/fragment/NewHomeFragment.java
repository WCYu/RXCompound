package com.rxjy.rxcompound.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewHomeFragment extends BaseFragment {


    public NewHomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_home;
    }

    @Override
    protected void FragmentInitData() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

}
