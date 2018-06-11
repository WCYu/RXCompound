package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.MoneyAZaResultAdapter;
import com.rxjy.rxcompound.adapter.MoneyDZaAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.MoneyDZaProcessBean;
import com.rxjy.rxcompound.entity.MoneyDZaResultBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDZaContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyDZaPresenter;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDetailsZaActivity extends BaseActivity<MoneyDZaPresenter> implements MoneyDZaContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_za)
    ListView lvZa;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.ll_money)
    LinearLayout llMoney;

    @Override
    public int getLayout() {
        return R.layout.activity_zamoneydetails;
    }

    int year, month;
    String cardno;

    @Override
    public void initData() {
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String money=intent.getStringExtra("money");
        tvMoney.setText(money);
        cardno = App.cardNo;
        Calendar c = Calendar.getInstance();
//        year = 2017;
        year = c.get(Calendar.YEAR);
//        month = 12;
        month = c.get(Calendar.MONTH) + 1;

        switch (type) {
            case "2":
                tvTitle.setText("过程");
                mPresenter.getzaprocessdata(year + "", month + "", cardno);
                break;
            case "3":
                tvTitle.setText("结果");
                mPresenter.getzaprocessdata(year + "", month + "", cardno);
//                mPresenter.getzaresultdata(year + "", month + "", cardno);
                break;
        }
    }

    @Override
    protected MoneyDZaPresenter onCreatePresenter() {
        return new MoneyDZaPresenter(this);
    }

    MoneyDZaAdapter moneyDZaAdapter;

    @Override
    public void responsezaprocessdata(MoneyDZaProcessBean data) {
        moneyDZaAdapter = new MoneyDZaAdapter(this, data.getBody());
        lvZa.setAdapter(moneyDZaAdapter);
    }

    @Override
    public void responsezaprocessdataError(String msg) {
        showToast(msg);
    }

    MoneyAZaResultAdapter moneyAZaResultAdapter;

    @Override
    public void responsezaresultdata(MoneyDZaProcessBean data) {
        moneyDZaAdapter = new MoneyDZaAdapter(this, data.getBody());
        lvZa.setAdapter(moneyDZaAdapter);
//        moneyAZaResultAdapter = new MoneyAZaResultAdapter(this, data.getBody());
//        lvZa.setAdapter(moneyAZaResultAdapter);
    }

    @Override
    public void responsezaresultdataError(String msg) {
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
