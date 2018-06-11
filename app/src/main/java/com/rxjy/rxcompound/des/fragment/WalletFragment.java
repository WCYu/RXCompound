package com.rxjy.rxcompound.des.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.des.activity.JiaoChengListActivity;
import com.rxjy.rxcompound.des.activity.QianBaoActivity;
import com.rxjy.rxcompound.des.mvp.presenter.WalletPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/26.
 */

public class WalletFragment extends BaseFragment {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_jiaocheng)
    LinearLayout ll_jiaocheng;
    @Bind(R.id.ll_qianbao)
    LinearLayout ll_qianbao;
    public static final String TITLE = "更多";


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_des_wallet;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
        onclick();
    }

    private void onclick() {
        ll_jiaocheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JiaoChengListActivity.class));
            }
        });
        ll_qianbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), QianBaoActivity.class));
            }
        });
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }


    @Override
    protected WalletPresenter onCreatePresenter() {
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
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
