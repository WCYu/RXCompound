package com.rxjy.rxcompound.des.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/23.
 */

public class OnTrialHomeFragment extends BaseFragment {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.matters)
    LinearLayout matters;
    @Bind(R.id.finance)
    LinearLayout finance;
    @Bind(R.id.capital)
    LinearLayout capital;
    @Bind(R.id.affairs)
    LinearLayout affairs;
    @Bind(R.id.main_case)
    LinearLayout mainCase;
    @Bind(R.id.engineering)
    LinearLayout engineering;
    @Bind(R.id.company)
    LinearLayout company;
    @Bind(R.id.Material_dealer)
    LinearLayout MaterialDealer;
    @Bind(R.id.project_Manager)
    LinearLayout projectManager;

    @Override
    protected int getFragmentLayout() {
        return R.layout.personnel_morefragment;
    }

    @Override
    protected void FragmentInitData() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText("瑞祥联盟");
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {

    }
}
