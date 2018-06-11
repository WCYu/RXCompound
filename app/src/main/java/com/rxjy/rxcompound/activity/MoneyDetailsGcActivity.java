package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.MoneyDGcJixiaoAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.MoneyDGcJixiaoBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDGcContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyDGcPresenter;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/19.
 */

public class MoneyDetailsGcActivity extends BaseActivity<MoneyDGcPresenter> implements MoneyDGcContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_data)
    ListView lvData;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.ll_money)
    LinearLayout llMoney;

    @Override
    public int getLayout() {
        return R.layout.activity_gcmoneydetails;
    }

    int year, month;
    String cardno;

    @Override
    public void initData() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        cardno = App.cardNo;
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String money = intent.getStringExtra("money");
        tvMoney.setText(money);
        switch (type) {
            case "2":
                tvTitle.setText("绩效");
                mPresenter.getgcjixiaodata(year + "", month + "", cardno);
                break;
            case "4":
                tvTitle.setText("创收");
                mPresenter.getgcchuangshoudata(year + "", month + "", cardno);
                break;
        }
    }

    @Override
    protected MoneyDGcPresenter onCreatePresenter() {
        return new MoneyDGcPresenter(this);
    }

    MoneyDGcJixiaoAdapter moneyDGcJixiaoAdapter;

    @Override
    public void responsegcjixiaodata(MoneyDGcJixiaoBean data) {
        moneyDGcJixiaoAdapter = new MoneyDGcJixiaoAdapter(this, data.getBody());
        lvData.setAdapter(moneyDGcJixiaoAdapter);
    }

    @Override
    public void responsegcjixiaodataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegcchuangshoudata(MoneyDGcJixiaoBean data) {
        moneyDGcJixiaoAdapter = new MoneyDGcJixiaoAdapter(this, data.getBody());
        lvData.setAdapter(moneyDGcJixiaoAdapter);
    }

    @Override
    public void responsegcchuangshoudataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                break;
        }
    }
}
