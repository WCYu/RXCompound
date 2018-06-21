package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyTzBean;
import com.rxjy.rxcompound.mvp.contract.MoneyTzContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyTzPresenter;
import com.rxjy.rxcompound.widget.MoneyTzView;
import com.rxjy.rxcompound.widget.moneytext.RiseNumberTextView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/27.
 */

public class MoneyTzActivity extends BaseActivity<MoneyTzPresenter> implements MoneyTzContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_money)
    RiseNumberTextView tvMoney;
    @Bind(R.id.mv_one)
    MoneyTzView mvOne;
    @Bind(R.id.mv_two)
    MoneyTzView mvTwo;
    @Bind(R.id.mv_three)
    MoneyTzView mvThree;
    @Bind(R.id.mv_four)
    MoneyTzView mvFour;
    @Bind(R.id.mv_five)
    MoneyTzView mvFive;
    @Bind(R.id.mv_six)
    MoneyTzView mvSix;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.mv_seven)
    MoneyTzView mvSeven;

    @Override
    public int getLayout() {
        return R.layout.activity_tzwallet;
    }

    @Override
    public void initData() {
        tvTitle.setText("钱包");
        tvRight.setText("历史");
        show();
    }

    Float moneyall;
    int year, month;
    String cardno;
    private void show() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
//        cardno = "01011451";
        cardno = App.cardNo;

        switch (App.apptype) {
            case 34://投资
                switch (App.postid) {
                    case 34://投资行政经理00002000
                        Log.e("tag","+++++++++");
                        mvOne.setTitleAndType("合计", "保底", "绩效", "", "最终");
                        mvTwo.setTitleAndType("结果", "结果", "", "", "合计");
                        mvThree.setTitleAndType("过程", "过程", "", "", "合计");
                        mvFour.setTitleAndType("奖罚", "奖", "罚", "现金", "合计");
                        mvFive.setTitleAndType("社保", "社保", "公积金", "", "合计");
                        mvSix.setTitleAndType("分红", "笔数", "", "", "合计");
                        mvSeven.setVisibility(View.GONE);
                        mPresenter.getxzmoneydata(year + "", month + "", cardno);
                        break;
                    case 35://投资人事主管
                        mvOne.setTitleAndType("合计", "保底", "绩效", "取其高", "最终");
                        mvTwo.setTitleAndType("结果", "结果", "", "", "合计");
                        mvThree.setTitleAndType("过程", "过程", "", "", "合计");
                        mvFour.setTitleAndType("奖罚", "奖", "罚", "现金", "合计");
                        mvFive.setTitleAndType("社保", "社保", "公积金", "", "合计");
                        mvSix.setTitleAndType("分红", "笔数", "", "", "合计");
                        mvSeven.setVisibility(View.GONE);
                        mPresenter.gettzmoneydata(year + "", month + "", cardno);
                        break;
                    case 54://投资会计
                        mvOne.setTitleAndType("总收", "保底工资", "绩效收入", "取其高", "合计");
                        mvTwo.setTitleAndType("过程", "过程收入", "", "", "过程收入");
                        mvThree.setTitleAndType("结果", "结果收入", "", "", "结果收入");
                        mvFour.setTitleAndType("奖罚", "奖金", "罚款", "", "合计");
                        mvFive.setTitleAndType("提成", "分红", "", "", "合计");
                        mvSix.setTitleAndType("社保", "社保", "公积金", "", "合计");
                        mvSeven.setTitleAndType("历史", "", "", "应发薪酬", "未发薪酬");
                        mPresenter.getkjmoneydata(year + "", month + "", cardno);
                        break;
                    case 55://投资出纳
                        mvOne.setTitleAndType("总收", "保底工资", "绩效收入", "取其高", "合计");
                        mvTwo.setTitleAndType("过程", "过程收入", "", "", "过程收入");
                        mvThree.setTitleAndType("结果", "结果收入", "", "", "结果收入");
                        mvFour.setTitleAndType("奖罚", "奖金", "罚款", "", "合计");
                        mvFive.setTitleAndType("提成", "分红", "", "", "合计");
                        mvSix.setTitleAndType("社保", "社保", "公积金", "", "合计");
                        mvSeven.setTitleAndType("历史", "", "", "应发薪酬", "未发薪酬");
                        mPresenter.getcnmoneydata(year + "", month + "", cardno);
                        break;
                }
                break;
        }
    }

    @Override
    protected MoneyTzPresenter onCreatePresenter() {
        return new MoneyTzPresenter(this);
    }

    String tzrsresultmoney;

    @Override
    public void responsetzmoneydata(MoneyTzBean data) {
        MoneyTzBean.BodyBean datas = data.getBody();
//        tvMoney.setText(datas.getZuiZhongGongZi());
        moneyall = Float.valueOf(datas.getZuiZhongGongZi());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setLasttwoContent(datas.getBaoDiGongZi(), datas.getJiXiaoGongZi(), datas.getQuQiGao(), datas.getZuiZhongGongZi(), datas.getZuiZhongGongZiHou());
        mvTwo.setContent("" + datas.getJieGuoGongZi(), "", "", "" + datas.getJieGuoGongZi());
        tzrsresultmoney = datas.getJieGuoGongZi();
        mvThree.setContent(datas.getGuoChengGongZi(), "", "", datas.getGuoChengGongZi());
        mvFour.setLasttwoContent(datas.getrMoney(), datas.getPmoney(), datas.getXianJin(), StringUtils.getPrettyNumber("" + datas.getJiangFaGongZi()), StringUtils.getPrettyNumber("" + datas.getJiangFaGongZiHou()));
        mvFive.setContent(datas.getSheBao(), datas.getHousePrivate(), "", datas.getSheBao());
        mvSix.setContent(datas.getFenHongNum(), "", "", datas.getFenHongSumMoney());
        int jfhjmoney = datas.getJiangFaGongZi().intValue();
        int jfhjmoneyhou = datas.getJiangFaGongZiHou().intValue();
        if (jfhjmoney >= 0) {
            mvFour.setTextColor(1, 4);
        } else {
            mvFour.setTextColor(2, 4);
        }
        if (jfhjmoneyhou >= 0) {
            mvFour.setTextColor(1, 5);
        } else {
            mvFour.setTextColor(2, 5);
        }
    }

    @Override
    public void responsetzmoneydataError(String msg) {
        showToast(msg);
    }

    String tzxzresultmoney, tzxzgcmoney, tzxzjfmoney, tzxzfhmoney;

    @Override
    public void responsexzmoneydata(MoneyTzBean data) {
        MoneyTzBean.BodyBean datas = data.getBody();
//        tvMoney.setText(datas.getZuiZhongGongZi());
        moneyall = Float.valueOf(datas.getZuiZhongGongZi());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setLasttwoContent(datas.getBaoDiGongZi(), datas.getJiXiaoGongZi(), "", datas.getZuiZhongGongZi(), datas.getZuiZhongGongZiHou());
        mvTwo.setContent("" + datas.getJieGuoGongZi(), "", "", "" + datas.getJieGuoGongZi());
        tzxzresultmoney = datas.getJieGuoGongZi();
        mvThree.setContent(datas.getGuoChengGongZi(), "", "", datas.getGuoChengGongZi());
        tzxzgcmoney = datas.getGuoChengGongZi();
        mvFour.setLasttwoContent(datas.getrMoney(), datas.getPmoney(), datas.getXianJin(), StringUtils.getPrettyNumber("" + datas.getJiangFaGongZi()), StringUtils.getPrettyNumber("" + datas.getJiangFaGongZiHou()));
        tzxzjfmoney = StringUtils.getPrettyNumber("" + datas.getJiangFaGongZiHou());
        mvFive.setContent(datas.getSheBao(), datas.getHousePrivate(), "", datas.getSheBao());
        mvSix.setContent(datas.getFenHongNum(), "", "", datas.getFenHongSumMoney());
        tzxzfhmoney = datas.getFenHongSumMoney();
        int jfhjmoney = datas.getJiangFaGongZi().intValue();
        int jfhjmoneyhou = datas.getJiangFaGongZiHou().intValue();
        if (jfhjmoney >= 0) {
            mvFour.setTextColor(1, 4);
        } else {
            mvFour.setTextColor(2, 4);
        }
        if (jfhjmoneyhou >= 0) {
            mvFour.setTextColor(1, 5);
        } else {
            mvFour.setTextColor(2, 5);
        }
    }

    @Override
    public void responsexzmoneydataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsekjmoneydata(MoneyTzBean data) {
        MoneyTzBean.BodyBean datas=data.getBody();
        moneyall = Float.valueOf(datas.getZuiZhongGongZi());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setContent(StringUtils.getPrettyNumber(datas.getBaoDiGongZi()),StringUtils.getPrettyNumber(datas.getJiXiaoGongZi()),StringUtils.getPrettyNumber(datas.getQuQiGao()),StringUtils.getPrettyNumber(datas.getZuiZhongGongZi()));
        mvTwo.setContent(StringUtils.getPrettyNumber(datas.getGuoChengGongZi()),"","",StringUtils.getPrettyNumber(datas.getGuoChengGongZi()));
        mvThree.setContent(StringUtils.getPrettyNumber(datas.getJieGuoGongZi()),"","",StringUtils.getPrettyNumber(datas.getJieGuoGongZi()));
        mvFour.setContent(StringUtils.getPrettyNumber(datas.getrMoney()),StringUtils.getPrettyNumber(datas.getpMoney()),"",StringUtils.getPrettyNumber(datas.getJiangFaGongZi()+""));
        mvFive.setContent(StringUtils.getPrettyNumber(datas.getFenHongSumMoney()),"","",StringUtils.getPrettyNumber(datas.getFenHongSumMoney()));
        mvSix.setContent(StringUtils.getPrettyNumber(datas.getSocialPrivate()),StringUtils.getPrettyNumber(datas.getHousePrivate()),"",StringUtils.getPrettyNumber(datas.getSheBao()));
        mvSeven.setContent("","",StringUtils.getPrettyNumber(datas.getShouldPay()),StringUtils.getPrettyNumber(datas.getNoPay()));
    }

    @Override
    public void responsekjmoneydataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsecnmoneydata(MoneyTzBean data) {
        MoneyTzBean.BodyBean datas=data.getBody();
        moneyall = Float.valueOf(datas.getZuiZhongGongZi());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setContent(StringUtils.getPrettyNumber(datas.getBaoDiGongZi()),StringUtils.getPrettyNumber(datas.getJiXiaoGongZi()),StringUtils.getPrettyNumber(datas.getQuQiGao()),StringUtils.getPrettyNumber(datas.getZuiZhongGongZi()));
        mvTwo.setContent(StringUtils.getPrettyNumber(datas.getGuoChengGongZi()),"","",StringUtils.getPrettyNumber(datas.getGuoChengGongZi()));
        mvThree.setContent(StringUtils.getPrettyNumber(datas.getJieGuoGongZi()),"","",StringUtils.getPrettyNumber(datas.getJieGuoGongZi()));
        mvFour.setContent(StringUtils.getPrettyNumber(datas.getrMoney()),StringUtils.getPrettyNumber(datas.getpMoney()),"",StringUtils.getPrettyNumber(datas.getJiangFaGongZi()+""));
        mvFive.setContent(StringUtils.getPrettyNumber(datas.getFenHongSumMoney()),"","",StringUtils.getPrettyNumber(datas.getFenHongSumMoney()));
        mvSix.setContent(StringUtils.getPrettyNumber(datas.getSocialPrivate()),StringUtils.getPrettyNumber(datas.getHousePrivate()),"",StringUtils.getPrettyNumber(datas.getSheBao()));
        mvSeven.setContent("","",StringUtils.getPrettyNumber(datas.getShouldPay()),StringUtils.getPrettyNumber(datas.getNoPay()));
    }

    @Override
    public void responsecnmoneydataError(String msg) {
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



    @OnClick({R.id.iv_back, R.id.tv_right, R.id.mv_one, R.id.mv_two, R.id.mv_three, R.id.mv_four, R.id.mv_five, R.id.mv_six})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                showToast("暂无此功能！");
                break;
            case R.id.mv_one:
                DataDetails(1);
                break;
            case R.id.mv_two:
                DataDetails(2);
                break;
            case R.id.mv_three:
                DataDetails(3);
                break;
            case R.id.mv_four:
                DataDetails(4);
                break;
            case R.id.mv_five:
                DataDetails(5);
                break;
            case R.id.mv_six:
                DataDetails(6);
                break;
            case R.id.mv_seven:
                DataDetails(7);
                break;
        }
    }

    /**
     * 查看详情
     */
    private void DataDetails(int type) {//种类
        switch (App.apptype) {
            case 34:
                switch (App.postid) {//投资行政经理
                    case 34:
                        switch (type) {
                            case 2:
                                startActivity(new Intent(this, MoneyDetailsTzActivity.class).putExtra("type", type + "").putExtra("money", tzxzresultmoney));
                                break;
                            case 3:
                                startActivity(new Intent(this, MoneyDetailsTzActivity.class).putExtra("type", type + "").putExtra("money", tzxzgcmoney));
                                break;
                            case 4:
                                startActivity(new Intent(this, MoneyDetailsTzTwoActivity.class).putExtra("type", "jiangfa").putExtra("money", tzxzjfmoney));
                                break;
                            case 6:
                                startActivity(new Intent(this, MoneyDetailsTzTwoActivity.class).putExtra("type", "fenhong").putExtra("money", tzxzfhmoney));
                                break;
                        }
                        break;
                    case 35:
                        switch (type){
                            case 2:
                                startActivity(new Intent(this, MoneyDetailsTzActivity.class).putExtra("type", type + "rs").putExtra("money", tzxzresultmoney));
                                break;
                            case 3:
                                startActivity(new Intent(this, MoneyDetailsTzActivity.class).putExtra("type", type + "rs").putExtra("money", tzxzresultmoney));
                                break;
                        }
                        break;
                }
                break;
        }
    }

}