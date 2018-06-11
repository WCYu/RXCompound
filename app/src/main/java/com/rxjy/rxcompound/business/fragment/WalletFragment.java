package com.rxjy.rxcompound.business.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.adapter.WalletAdapter;
import com.rxjy.rxcompound.business.entity.WalletBean;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.des.mvp.contract.WalletContract;
import com.rxjy.rxcompound.des.mvp.presenter.WalletPresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/23.
 */

public class WalletFragment  extends BaseFragment<WalletPresenter> implements WalletContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_daymoney)
    TextView tvDaymoney;
    @Bind(R.id.v_day)
    View vDay;
    @Bind(R.id.tv_monthmoney)
    TextView tvMonthmoney;
    @Bind(R.id.v_month)
    View vMonth;
    @Bind(R.id.lv_day)
    ListView lvDay;
    @Bind(R.id.lv_month)
    ListView lvMonth;
    @Bind(R.id.rl_day)
    RelativeLayout rlDay;
    @Bind(R.id.rl_month)
    RelativeLayout rlMonth;
    String cardno,identity;
    int type,isloadmonth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_wallet;
    }

    @Override
    protected void FragmentInitData() {
        tvTitle.setText("项目信息");
        ivBack.setVisibility(View.GONE);
//        SharedPreferences sp = getActivity().getSharedPreferences("rxsw_userdatas", Activity.MODE_PRIVATE);
//        cardno = sp.getString("rxsw_cardno", null);
//        identity = sp.getString("rxsw_identity", null);
        cardno= App.cardNo;
        type=0;
        mPresenter.getWalletdata(cardno,identity,type+"");
    }

    @Override
    protected WalletPresenter onCreatePresenter() {
        return new WalletPresenter(this);
    }


    @Override
    public void responsegetWalletdata(WalletBean data) {
        if(data.getBody().getPackageType()!=null&&data.getBody().getPackageType().size()>0){
            tvDaymoney.setText(data.getBody().getPackageType().get(0).getJinRiRxb()+"");
            tvMonthmoney.setText(data.getBody().getPackageType().get(0).getDyRxb()+"");
        }
        switch (type){
            case 0://今日
                ShowData(data.getBody().getPackageType());
                break;
            case 1://本月
                isloadmonth=1;
                lvMonth.setVisibility(View.VISIBLE);
                lvDay.setVisibility(View.GONE);
                ShowMonthData(data.getBody().getPackageType());
                break;
        }
    }

    WalletAdapter walletAdapter;
    private void ShowData(ArrayList<WalletBean.ListBean> list){
        walletAdapter=new WalletAdapter(getActivity(),list);
        lvDay.setAdapter(walletAdapter);
    }

    private void ShowMonthData(ArrayList<WalletBean.ListBean> list){
        walletAdapter=new WalletAdapter(getActivity(),list);
        lvMonth.setAdapter(walletAdapter);
    }

    @Override
    public void responsegetWalletdataError(String msg) {
        showToast(msg);

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_day, R.id.rl_month})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_day:
                lvDay.setVisibility(View.VISIBLE);
                lvMonth.setVisibility(View.GONE);
                vDay.setVisibility(View.VISIBLE);
                vMonth.setVisibility(View.GONE);
                break;
            case R.id.rl_month:
                vDay.setVisibility(View.GONE);
                vMonth.setVisibility(View.VISIBLE);
                if(isloadmonth!=1){
                    type=1;
                    mPresenter.getWalletdata(cardno,identity,type+"");
                }else{
                    lvDay.setVisibility(View.GONE);
                    lvMonth.setVisibility(View.VISIBLE);
                }
                break;
        }
    }


}

