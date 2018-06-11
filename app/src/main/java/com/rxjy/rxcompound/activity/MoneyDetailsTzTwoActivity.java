package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.MoneyDBusAdapter;
import com.rxjy.rxcompound.adapter.MoneyDBusHisAdapter;
import com.rxjy.rxcompound.adapter.MoneyDLisTwoAdapter;
import com.rxjy.rxcompound.adapter.MoneyDListAdapter;
import com.rxjy.rxcompound.adapter.MoneyDTitleAdapter;
import com.rxjy.rxcompound.adapter.MoneyDZaRewardAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.BusMoneyBean;
import com.rxjy.rxcompound.entity.MoneyBusHisBean;
import com.rxjy.rxcompound.entity.MoneyDTzFenhongBean;
import com.rxjy.rxcompound.entity.MoneyDTzRewardBean;
import com.rxjy.rxcompound.entity.MoneyDZaRewardBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDTzTwoContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyDTzTwoPresenter;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDetailsTzTwoActivity extends BaseActivity<MoneyDTzTwoPresenter> implements MoneyDTzTwoContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.gv_one)
    GridView gvOne;
    @Bind(R.id.lv_one)
    ListView lvOne;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.ll_money)
    LinearLayout llMoney;

    @Override
    public int getLayout() {
        return R.layout.activity_tzmoneydetailstwo;
    }

    MoneyDTitleAdapter moneyDTitleAdapter;
    MoneyDListAdapter moneyDListAdapter;
    MoneyDLisTwoAdapter moneyDLisTwoAdapter;

    int year, month;
    String cardno;

    @Override
    public void initData() {
//        cardno = "02800200";
        cardno = App.cardNo;
        Calendar c = Calendar.getInstance();
//        year = 2017;
        year = c.get(Calendar.YEAR);
//        month = 12;
        month = c.get(Calendar.MONTH) + 1;
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String money=intent.getStringExtra("money");
        tvMoney.setText(money);
        titlelist = new ArrayList<>();
        fenhongdata = new ArrayList<>();
        rewarddata = new ArrayList<>();
        switch (type) {
            case "fenhong":
                tvTitle.setText("分红");
                titlelist.add("日期");
                titlelist.add("金额");
                titlelist.add("比例");
                titlelist.add("分红");
                ShowTitle();
                mPresenter.gettzfenhongdata(year + "", month + "", cardno);
                break;
            case "jiangfa":
                tvTitle.setText("奖罚");
                titlelist.add("日期");
                titlelist.add("来源");
                titlelist.add("内容");
                titlelist.add("金额");
                titlelist.add("状态");
                ShowTitle();
                mPresenter.gettzrewarddata(year + "", month + "", cardno);
                break;
            case "gcjiangfa":
                tvTitle.setText("奖罚");
                titlelist.add("时间");
                titlelist.add("原因");
                titlelist.add("金额");
                titlelist.add("发起人");
                ShowTitle();
                mPresenter.getzarewarddata(year + "", month + "", cardno);
                break;
            case "swgongzi":
                tvTitle.setText("工资");
                titlelist.add("时间");
                titlelist.add("理由");
                titlelist.add("备注");
                titlelist.add("补贴金额");
                ShowTitle();
                mPresenter.getbusmoneydata(year + "", month + "", cardno);
                break;
            case "swhistory":
                tvTitle.setText("历史");
                titlelist.add("月份");
                titlelist.add("工资");
                titlelist.add("提成");
                titlelist.add("综合");
                titlelist.add("剩余");
                ShowTitle();
                mPresenter.getbusmhisdata(App.regionid+"", cardno);
                break;
        }
    }

    /**
     * 显示种类标题
     */
    ArrayList<String> titlelist;

    private void ShowTitle() {
        gvOne.setNumColumns(titlelist.size());
        moneyDTitleAdapter = new MoneyDTitleAdapter(this, titlelist);
        gvOne.setAdapter(moneyDTitleAdapter);
    }

    ArrayList<MoneyDTzFenhongBean.BodyBean> fenhongdata;
    ArrayList<MoneyDTzRewardBean.BodyBean> rewarddata;

    @Override
    protected MoneyDTzTwoPresenter onCreatePresenter() {
        return new MoneyDTzTwoPresenter(this);
    }

    @Override
    public void responsetzfenhongdata(MoneyDTzFenhongBean data) {
        fenhongdata.clear();
        fenhongdata = data.getBody();
        moneyDListAdapter = new MoneyDListAdapter(this, fenhongdata);
        lvOne.setAdapter(moneyDListAdapter);
    }

    @Override
    public void responsetzfenhongdataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsetzrewarddata(MoneyDTzRewardBean data) {
        rewarddata.clear();
        rewarddata = data.getBody();
        moneyDLisTwoAdapter = new MoneyDLisTwoAdapter(this, rewarddata);
        lvOne.setAdapter(moneyDLisTwoAdapter);
        lvOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MoneyDetailsTzTwoActivity.this, TextDetailsActivity.class).putExtra("txt", rewarddata.get(position).getContent()));
            }
        });
    }

    @Override
    public void responsetzrewarddataError(String msg) {
        showToast(msg);
    }

    MoneyDZaRewardAdapter moneyDZaRewardAdapter;
    @Override
    public void responsezarewarddata(final MoneyDZaRewardBean data) {
        moneyDZaRewardAdapter = new MoneyDZaRewardAdapter(this, data.getBody());
        lvOne.setAdapter(moneyDZaRewardAdapter);
        lvOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MoneyDetailsTzTwoActivity.this, TextDetailsActivity.class).putExtra("txt", data.getBody().get(position).getRpRemarks()));
            }
        });
    }

    @Override
    public void responsezarewarddataError(String msg) {
        showToast(msg);
    }

    MoneyDBusAdapter moneyDBusAdapter;
    @Override
    public void responsebusmoneydata(final BusMoneyBean data) {
        moneyDBusAdapter = new MoneyDBusAdapter(this, data.getBody());
        lvOne.setAdapter(moneyDBusAdapter);
        lvOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MoneyDetailsTzTwoActivity.this, TextDetailsActivity.class).putExtra("txt", data.getBody().get(position).getRemark()));
            }
        });
    }

    @Override
    public void responsebusmoneydataError(String msg) {
        showToast(msg);
    }

    MoneyDBusHisAdapter moneyDBusHisAdapter;
    @Override
    public void responsebushisdata(MoneyBusHisBean data) {
        moneyDBusHisAdapter=new MoneyDBusHisAdapter(this,data.getBody());
        lvOne.setAdapter(moneyDBusHisAdapter);
    }

    @Override
    public void responsebushisdataError(String msg) {
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