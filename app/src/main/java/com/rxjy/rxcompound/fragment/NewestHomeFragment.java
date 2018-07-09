package com.rxjy.rxcompound.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.home.HomeAdapter;
import com.rxjy.rxcompound.adapter.home.HomeListAdapter;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewestHomeFragment extends BaseFragment {

//    @Bind(R.id.home_recycle)
//    RecyclerView homeRecycle;
    @Bind(R.id.home_lsit)
    ListView home_lsit;

    @Bind(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;

    private HomeAdapter homeAdapter;
    private ArrayList arrayList;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_newest_home;
    }

    @Override
    protected void FragmentInitData() {
        arrayList = new ArrayList();
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_home_header, null);
        home_lsit.addHeaderView(headerView);
        HomeListAdapter homeListAdapter = new HomeListAdapter(getActivity(),arrayList);

        home_lsit.setAdapter(homeListAdapter);

//        new HomeAdapter(getActivity(),arrayList);
//        homeRecycle.setAdapter(homeAdapter);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
