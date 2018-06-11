package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.MoneyDBusjfAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyDBusJFBean;
import com.rxjy.rxcompound.entity.MoneyDBusJFKQMoreBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDBusjfContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyDBusjfPresenter;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/11.
 */
public class MoneyDetailsBusjfActivity extends BaseActivity<MoneyDBusjfPresenter> implements MoneyDBusjfContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.ll_money)
    LinearLayout llMoney;
    @Bind(R.id.tv_daynum)
    TextView tvDaynum;
    @Bind(R.id.tv_formula)
    TextView tvFormula;
    @Bind(R.id.tv_moneykq)
    TextView tvMoneykq;
    @Bind(R.id.lv_one)
    ListView lvOne;

    @Override
    public int getLayout() {
        return R.layout.activity_moneybusjf;
    }

    int year, month;
    String cardno;
    @Override
    public void initData() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        cardno = App.cardNo;
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        String money=intent.getStringExtra("money");
        tvTitle.setText(title);
        tvMoney.setText(money);
        mPresenter.getbuskqdata(year + "", month + "", cardno);
        mPresenter.getbuskqmoredata(year + "", month + "", cardno);
    }

    @Override
    protected MoneyDBusjfPresenter onCreatePresenter() {
        return new MoneyDBusjfPresenter(this);
    }


    @Override
    public void responsebuskqdata(MoneyDBusJFBean data) {
        tvDaynum.setText(data.getBody().getQueQinDay()+"");
        int money= data.getBody().getQueQinMoney().intValue();
        if(money>=0){
            tvMoneykq.setTextColor(getResources().getColor(R.color.textgreen));
        }else{
            tvMoneykq.setTextColor(getResources().getColor(R.color.textred));
        }
        tvFormula.setText(StringUtils.getPrettyNumber(data.getBody().getSubsidymoney()+"")+"/22*"+data.getBody().getQueQinDay());
        tvMoneykq.setText(StringUtils.getPrettyNumber(data.getBody().getSubsidymoney()+""));

    }

    @Override
    public void responsebuskqdataError(String msg) {
        showToast(msg);
    }

    MoneyDBusjfAdapter moneyDBusjfAdapter;
    @Override
    public void responsebuskqmoredata(MoneyDBusJFKQMoreBean data) {
        moneyDBusjfAdapter=new MoneyDBusjfAdapter(this,data.getBody());
        lvOne.setAdapter(moneyDBusjfAdapter);
    }

    @Override
    public void responsebuskqmoredataError(String msg) {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
