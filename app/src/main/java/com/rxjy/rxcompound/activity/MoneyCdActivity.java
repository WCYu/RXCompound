package com.rxjy.rxcompound.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.widget.MoneyView;
import com.rxjy.rxcompound.widget.moneytext.RiseNumberTextView;

import butterknife.Bind;

/**
 * Created by asus on 2018/6/4.
 */

public class MoneyCdActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.tv_money)
    RiseNumberTextView tvMoney;
    @Bind(R.id.mv_one)
    MoneyView mvOne;
    @Bind(R.id.mv_two)
    MoneyView mvTwo;
    @Bind(R.id.mv_three)
    MoneyView mvThree;
    @Bind(R.id.mv_four)
    MoneyView mvFour;
    @Bind(R.id.mv_five)
    MoneyView mvFive;
    @Bind(R.id.mv_six)
    MoneyView mvSix;
    @Bind(R.id.mv_seven)
    MoneyView mvSeven;

    @Override
    public int getLayout() {
        return R.layout.activity_wallet;
    }

    @Override
    public void initData() {
        tvTitle.setText("钱包");
        tvRight.setText("历史");
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
