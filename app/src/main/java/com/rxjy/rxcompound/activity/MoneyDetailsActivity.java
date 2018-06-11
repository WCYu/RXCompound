package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.BusMoneyBean;
import com.rxjy.rxcompound.entity.BusProcessBean;
import com.rxjy.rxcompound.entity.BusResultBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDetailsContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyDetailsPresenter;
import com.rxjy.rxcompound.widget.MoneyView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/13.
 */

public class MoneyDetailsActivity extends BaseActivity<MoneyDetailsPresenter> implements MoneyDetailsContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.mv_one)
    MoneyView mvOne;
    @Bind(R.id.mv_two)
    MoneyView mvTwo;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.ll_money)
    LinearLayout llMoney;

    @Override
    public int getLayout() {
        return R.layout.activity_walletdetails;
    }

    int year, month;

    @Override
    public void initData() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        Log.e("年：" + year, "月" + month);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String money=intent.getStringExtra("money");
        tvMoney.setText(money);
        switch (type) {
//            case "1"://商务工资
//                tvTitle.setText("工资");
//                mvTwo.Show(0);
//                mvOne.setTitleAndType("商务-工资", "时间", "理由", "备注", "补贴金额");
//                mPresenter.getbusmoneydata(year + "", month + "", App.cardNo);
//                break;
            case "2"://商务过程
                tvTitle.setText("过程");
                mvOne.setTitleAndType("信访", "总数", "标准", "差额", "合计");
                mvTwo.setTitleAndType("经访", "总数", "标准", "差额", "合计");
                mPresenter.getbusprocessdata(year + "", month + "", App.cardNo);
                break;
            case "3"://商务结果
                tvTitle.setText("结果");
                mvTwo.Show(0);
                mvOne.setTitleAndType("量房", "总数", "标准", "差额", "合计");
                mPresenter.getbusresultdata(year + "", month + "", App.cardNo);
                break;
            case "4"://商务奖罚
                break;
        }
    }

    @Override
    protected MoneyDetailsPresenter onCreatePresenter() {
        return new MoneyDetailsPresenter(this);
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

    @Override
    public void responsebusmoneydata(BusMoneyBean data) {
//        BusMoneyBean.BodyBean datas = data.getBody().get(0);
//        mvOne.setContent(datas.getCtime(), datas.getReason(), datas.getRemark(), datas.getSubSidyMoney());
//        mvOne.setTextColor(3, 1);
    }

    @Override
    public void responsebusmoneydataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsebusprocesdata(BusProcessBean data) {
        BusProcessBean.BodyBean datas = data.getBody().get(0);
        int xfcha = datas.getMessengerVisit() - datas.getSmessengerVisit();
        int jfcha = datas.getAgentVisit() - datas.getSagentVisit();
        mvOne.setContent(datas.getMessengerVisit() + "", datas.getSmessengerVisit() + "", xfcha + "", StringUtils.getPrettyNumber(datas.getXfInCome() + ""));
        mvTwo.setContent(datas.getAgentVisit() + "", datas.getSagentVisit() + "", jfcha + "", StringUtils.getPrettyNumber(datas.getJfInCome() + ""));
//        mvOne.setTextColor(3, 1);
//        mvTwo.setTextColor(3, 1);

    }

    @Override
    public void responsebusprocesdataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsebusresultdata(BusResultBean data) {
        BusResultBean.BodyBean datas = data.getBody().get(0);
        int cha = datas.getJiaoYi() - datas.getJiaoYiStandard();
        mvOne.setContent(datas.getJiaoYi() + "", datas.getJiaoYiStandard() + "", cha + "", datas.getLfIncome());
//        mvOne.setTextColor(3, 1);
    }

    @Override
    public void responsebusresultdataError(String msg) {
        showToast(msg);
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}