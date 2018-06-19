package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.HospitalBean;
import com.rxjy.rxcompound.entity.MoneyBean;
import com.rxjy.rxcompound.entity.MoneyBusBean;
import com.rxjy.rxcompound.entity.MoneyBusNewBean;
import com.rxjy.rxcompound.entity.MoneyDesBean;
import com.rxjy.rxcompound.entity.MoneySupBean;
import com.rxjy.rxcompound.entity.MoneyTzBean;
import com.rxjy.rxcompound.mvp.contract.MoneyContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyPresenter;
import com.rxjy.rxcompound.widget.MoneyView;
import com.rxjy.rxcompound.widget.moneytext.RiseNumberTextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/2.
 */
public class MoneyActivity extends BaseActivity<MoneyPresenter> implements MoneyContract.View {

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
        show();
    }

    @Override
    protected MoneyPresenter onCreatePresenter() {
        return new MoneyPresenter(this);
    }

    int year, month;
    String cardno;

    private void show() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
//        cardno = "02800200";
        cardno = App.cardNo;
        switch (App.apptype) {
            case 2://商务
//                mvOne.setTitleAndType("工资", "保底", "绩效", "工资", "合计");
//                mvTwo.setTitleAndType("过程", "过程", "", "", "合计");
//                mvThree.setTitleAndType("结果", "结果", "", "", "合计");
//                mvFour.setTitleAndType("奖罚", "工资", "现金", "", "合计");
//                mvFive.setTitleAndType("提成", "施工", "", "", "合计");
//                mvSix.setTitleAndType("社保", "社保", "公积金", "", "合计");
//                mPresenter.getbusmoneydata(year + "", month + "", cardno);

                //新页面
                mvOne.setTitleAndType("总收", "保底工资", "绩效收入", "取其高", "合计");
                mvTwo.setTitleAndType("过程", "过程收入", "", "", "过程收入");
                mvThree.setTitleAndType("结果", "结果收入", "", "", "结果收入");
                mvFour.setTitleAndType("奖罚", "奖金", "罚款", "", "合计");
                mvFive.setTitleAndType("提成", "设计", "施工", "", "合计");
                mvSix.setTitleAndType("社保", "社保", "公积金", "", "合计");
                mvSeven.setTitleAndType("历史", "", "", "应发薪酬", "未发薪酬");
                mvSeven.setVisibility(View.VISIBLE);
                mPresenter.getbusmoneynewdata(year + "", month + "", cardno);
                break;
            case 3://温特斯
                mvOne.setTitleAndType("总收（绩效收入=过程收入+结果收入）", "保底工资", "绩效收入", "取其高", "合计");
                mvTwo.setTitleAndType("过程", "过程收入", "", "", "合计");
                mvThree.setTitleAndType("结果", "结果收入", "", "", "合计");
                mvFour.setTitleAndType("奖罚", "奖金", "罚款", "签单奖金", "合计");
                mvFive.setTitleAndType("提成", "设计", "施工", "", "合计");
                mvSix.setTitleAndType("社保", "社保", "公积金", "", "合计");
                mPresenter.getdesmoneydata(year + "", month + "", cardno);
                break;
            case 4://项目监理
                mvSix.Show(0);
                mvOne.setTitleAndType("合计", "基本", "绩效", "取其高", "合计");
                mvTwo.setTitleAndType("绩效", "过程", "结果", "", "合计");
                mvThree.setTitleAndType("奖罚", "奖金", "罚款", "", "合计");
                mvFour.setTitleAndType("创收", "增项", "罚款", "", "合计");
                mvFive.setTitleAndType("社保", "社保", "公积金", "", "合计");
                mPresenter.getgcmoneydata(year + "", month + "", cardno);
                break;
            case 34://投资
                switch (App.postid) {
                    case 34://投资行政经理00002000
                        mvOne.setTitleAndType("合计", "保底", "绩效", "", "最终");
                        mvTwo.setTitleAndType("结果", "结果", "", "", "合计");
                        mvThree.setTitleAndType("过程", "过程", "", "", "合计");
                        mvFour.setTitleAndType("奖罚", "", "奖", "罚", "现金", "合计");
                        mvFive.setTitleAndType("社保", "社保", "公积金", "", "合计");
                        mvSix.setTitleAndType("分红", "笔数", "", "", "合计");
                        mPresenter.getxzmoneydata(year + "", month + "", cardno);
                        break;
                    case 35://投资人事主管
                        mvOne.setTitleAndType("合计", "保底", "绩效", "取其高", "最终");
                        mvTwo.setTitleAndType("结果", "结果", "", "", "合计");
                        mvThree.setTitleAndType("过程", "过程", "", "", "合计");
                        mvFour.setTitleAndType("奖罚", "次数", "奖", "罚", "现金", "合计");
                        mvFive.setTitleAndType("社保", "社保", "公积金", "", "合计");
                        mvSix.setTitleAndType("分红", "笔数", "", "", "合计");
                        mPresenter.gettzmoneydata(year + "", month + "", cardno);
                        break;
                }
                break;
            default:
//                mvSix.Show(0);
//                mvOne.setTitleAndType("工资", "底薪", "绩效", "奖罚", "合计");
//                mvTwo.setTitleAndType("绩效工资", "应用", "开发", "管理", "合计");
//                mvThree.setTitleAndType("奖励处罚", "奖金", "罚款", "现金", "合计");
//                mvFour.setTitleAndType("社保公积金", "社保", "公积", "", "合计");
//                mvFive.setTitleAndType("出勤", "事假", "病假", "", "合计");
//                mPresenter.getmoneydata(cardno);

                mvSix.Show(1);
                mvOne.setTitleAndType("总收", "基本工资", "绩效工资", "取其高", "实发");
                mvTwo.setTitleAndType("过程", "过程", "", "", "合计");
                mvThree.setTitleAndType("结果", "预收", "已收", "", "合计");
                mvFour.setTitleAndType("奖罚", "奖金", "罚款", "考勤", "合计");
                mvFive.setTitleAndType("提成", "提成收入", "", "", "合计");
                mvSix.setTitleAndType("社保","社保","公积","个人所得税","合计");
                mvSeven.setVisibility(View.VISIBLE);
                mvSeven.setTitleAndType("历史","应发薪酬","未发薪酬","","");
                mPresenter.getHospitaldata(cardno);
                break;
        }
    }


    @OnClick({R.id.iv_back, R.id.tv_right, R.id.mv_one, R.id.mv_two, R.id.mv_three, R.id.mv_four, R.id.mv_five, R.id.mv_six, R.id.mv_seven})
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

    Float moneyall;

    @Override
    public void responsemoneydata(MoneyBean data) {
        MoneyBean.BodyBean datas = data.getBody();
//        tvMoney.setText(datas.getIncomeTotal() + "");
        moneyall = Float.valueOf(datas.getIncomeTotal());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setContent(datas.getSalaryMonth() + "", datas.getAchievementsMoney() + "", datas.getRewardTotal() + "", datas.getIncomeTotal() + "");
        mvTwo.setContent(datas.getYyMoney() + "", datas.getKfMoney() + "", datas.getGlMoney() + "", datas.getAchievementsMoney() + "");
        mvThree.setContent(datas.getReward() + "", datas.getFine() + "", datas.getCash() + "", datas.getRewardTotal() + "");
        mvFour.setContent(datas.getpSocialSecurity() + "", datas.getpAccumulationFund() + "", "", datas.getSocialFund() + "");
        mvFive.setContent(datas.getSjLeave() + "h", datas.getBjLeave() + "h", "", datas.getLeaveMoney() + "");
    }

    @Override
    public void responsemoneydataError(String msg) {
        showToast(msg);
    }


    String busresultmoney, busgzmoney, busgcmoney, busjfmoney, bushismoney;

    @Override
    public void responsebusmoneydata(MoneyBusBean data) {
        MoneyBusBean.BodyBean datas = data.getBody();
        moneyall = Float.valueOf(datas.getTotalIncome());
        tvMoney.withNumber(moneyall, false).start();
//        tvMoney.setText(datas.getTotalIncome());
        mvOne.setContent(datas.getSubSidyMoney(), datas.getPerformanceIncome(), datas.getSalary(), datas.getSalary());
        busgzmoney = datas.getSalary();
        mvTwo.setContent(datas.getProcessIncome(), "", "", datas.getProcessIncome());
        busgcmoney = datas.getProcessIncome();
        mvThree.setContent(datas.getResultIncome(), "", "", datas.getResultIncome());
        busresultmoney = datas.getResultIncome();
        mvFour.setContent(datas.getSanctionIncome(), datas.getExecuteXjReward(), "", datas.getSanctionIncome());
        busjfmoney = datas.getSanctionIncome();
        mvFive.setContent(datas.getTiCheng(), "", "", datas.getTiCheng());
        BigDecimal allsg = datas.getSheBao().add(datas.getGongJiJin());
        mvSix.setContent(datas.getSheBao() + "", datas.getGongJiJin() + "", "", allsg + "");
    }

    @Override
    public void responsebusmoneydataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsebusmoneynewdata(MoneyBusNewBean data) {
        MoneyBusNewBean.BodyBean datas=data.getBody();
        moneyall = Float.valueOf(datas.getTotalIncome());
        tvMoney.withNumber(moneyall, false).start();
        busjfmoney = datas.getjFHeJi();
        bushismoney=datas.getWeiFaXinChou();
        mvOne.setContent(StringUtils.getPrettyNumber(datas.getSubsidymoney()), StringUtils.getPrettyNumber(datas.getPerformanceIncome()),  StringUtils.getPrettyNumber(datas.getQuqigao()),  StringUtils.getPrettyNumber(datas.getTotalIncome()));
        mvTwo.setContent(StringUtils.getPrettyNumber(datas.getProcessIncome()), "",  "",  StringUtils.getPrettyNumber(datas.getProcessIncome()));
        mvThree.setContent(StringUtils.getPrettyNumber(datas.getResultIncome()), "",  "",  StringUtils.getPrettyNumber(datas.getResultIncome()));
        mvFour.setContent(StringUtils.getPrettyNumber(datas.getJiangJin()), StringUtils.getPrettyNumber(datas.getFaKuan()),  "",  StringUtils.getPrettyNumber(datas.getjFHeJi()));
        mvFive.setContent(StringUtils.getPrettyNumber(datas.getsJTiCheng()), StringUtils.getPrettyNumber(datas.getsGTiCheng()),  "",  StringUtils.getPrettyNumber(datas.getTiCheng()));
        mvSix.setContent(StringUtils.getPrettyNumber(datas.getSheBao()), StringUtils.getPrettyNumber(datas.getGongJiJin()), "",  StringUtils.getPrettyNumber(datas.getSheBaoGJHeJi()));
        mvSeven.setContent("", "",  StringUtils.getPrettyNumber(datas.getYingFaXinChou()),  StringUtils.getPrettyNumber(datas.getWeiFaXinChou()));
    }

    @Override
    public void responsebusmoneynewdataError(String msg) {
        showToast(msg);
    }

    String desmoney, desgcmoney, desjfmoney;

    @Override
    public void responsedesmoneydata(MoneyDesBean data) {
        MoneyDesBean.BodyBean datas = data.getBody();
//        tvMoney.setText(datas.getAverageIncome());
        moneyall = Float.valueOf(datas.getComprehensiveIncome());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setContent(datas.getDesignerAchievements(), datas.getAchievementsWages(), datas.getTakeItHigh(), datas.getComprehensiveIncome());
        desgcmoney = datas.getProcessIncome();
        mvTwo.setContent(datas.getProcessIncome(), "", "", datas.getProcessIncome());
        desmoney = datas.getResultMoney();
        mvThree.setContent(datas.getResultMoney(), "", "", datas.getResultMoney());
        desjfmoney = datas.getWagesMoney();
        mvFour.setContent(datas.getCashMoney(), datas.getWagesMoney(), datas.getBonus(), datas.getWagesTotal());
        mvFive.setContent(datas.getDesignCommission(), datas.getShiGongCommission(), "", datas.getCommissionTotal());
        mvSix.setContent(datas.getSocialSecurity(), datas.getHousingFund(), "", datas.getHstotal());
    }

    @Override
    public void responsedesmoneydataError(String msg) {
        showToast(msg);
    }

    String gcjxmoney, gcjfmoney, gccsmoney;

    @Override
    public void responsegcmoneydata(MoneySupBean data) {
        MoneySupBean.BodyBean datas = data.getBody();
//        tvMoney.setText(datas.getSalaryTotal());
        moneyall = Float.valueOf(datas.getSalaryTotal());
        tvMoney.withNumber(moneyall, false).start();
        mvOne.setContent(datas.getBasePay(), datas.getPerformance(), datas.getSalaryTotal(), datas.getSalaryTotal());
        mvTwo.setContent(datas.getStartCommission(), datas.getFinishCommission(), "", StringUtils.getPrettyNumber(datas.getPerformanceTotal() + ""));
        gcjxmoney = StringUtils.getPrettyNumber(datas.getPerformanceTotal() + "");
        mvThree.setContent(datas.getGain(), datas.getFine(), "", datas.getEventTotal());
        gcjfmoney = datas.getEventTotal();
        mvFour.setContent(datas.getGainCommission(), datas.getFineCommission(), "", StringUtils.getPrettyNumber(datas.getRevenue() + ""));
        gccsmoney = StringUtils.getPrettyNumber(datas.getRevenue() + "");
        BigDecimal allsg = datas.getSocialSecurity().add(datas.getHousingFund());
        mvFive.setContent(datas.getSocialSecurity() + "", datas.getHousingFund() + "", "", allsg + "");
    }

    @Override
    public void responsegcmoneydataError(String msg) {
        showToast(msg);
    }

    String tzrsresultmoney;

    @Override
    public void responsetzmoneydata(MoneyTzBean data) {
//        MoneyTzBean.BodyBean datas = data.getBody();
////        tvMoney.setText(datas.getZuiZhongGongZi());
//        moneyall= Float.valueOf(datas.getZuiZhongGongZi());
//        tvMoney.withNumber(moneyall,false).start();
//        mvOne.setLasttwoContent(datas.getBaoDiGongZi(), datas.getJiXiaoGongZi(), datas.getQuQiGao(), datas.getZuiZhongGongZi(), "|" + datas.getZuiZhongGongZiHou());
//        mvTwo.setContent(""+datas.getJieGuoGongZi(), "", "", ""+datas.getJieGuoGongZi());
//        tzrsresultmoney=datas.getJieGuoGongZi();
//        mvThree.setContent(datas.getGuoChengGongZi(), "", "", datas.getGuoChengGongZi());
//        mvFour.setContentFive("", "", datas.getrMoney(), datas.getPmoney(), datas.getXianJin(), datas.getJiangFaGongZi(), datas.getJiangFaGongZiHou());
//        mvFive.setContent(datas.getSheBao(), datas.getHousePrivate(), "", datas.getSheBao());
//        mvSix.setContent(datas.getFenHongNum(), "", "", datas.getFenHongSumMoney());
    }

    @Override
    public void responsetzmoneydataError(String msg) {
        showToast(msg);
    }

    String tzxzresultmoney, tzxzgcmoney, tzxzjfmoney, tzxzfhmoney;

    @Override
    public void responsexzmoneydata(MoneyTzBean data) {
//        MoneyTzBean.BodyBean datas = data.getBody();alueOf(datas.getZuiZhongGongZi());
//        tvMoney.withNumber(moneyall,false).start();
//        mvOne.setLasttwoContent(datas.getBaoDiGongZi(), datas.getJiXiaoGongZi(), "", datas.getZuiZhongGongZi(), "|" + datas.getZuiZhongGongZiHou());
//        mvTwo.setContent(""+datas.getJieGuoGongZi(), "", "",""+datas.getJieGuoGongZi());
//        tzxzresultmoney=datas.getJieGuoGongZi();
//        mvThree.setContent(datas.getGuoChengGongZi(), "", "", datas.getGuoChengGongZi());
//        tzxzgcmoney=datas.getGuoChengGongZi();
//        mvFour.setContentFive("", "", datas.getrMoney(), datas.getPmoney(), datas.getXianJin(), datas.getJiangFaGongZi(), datas.getJiangFaGongZiHou());
//        tzxzjfmoney=datas.getJiangFaGongZiHou();
//        mvFive.setContent(datas.getSheBao(), datas.getHousePrivate(), "", datas.getSheBao());
//        mvSix.setContent(datas.getFenHongNum(), "", "", datas.getFenHongSumMoney());
//        tzxzfhmoney=data
//        tvMoney.setText(datas.getZuiZhongGongZi());
//        moneyall= Float.vs.getFenHongSumMoney();
    }

    /**
     * 查看详情
     */
    private void DataDetails(int type) {//种类
        switch (App.apptype) {
            case 2://商务
                switch (type) {
                    case 1:
                        startActivity(new Intent(this, MoneyDetailsTzTwoActivity.class).putExtra("type", "swgongzi").putExtra("money", busgzmoney));
                        break;
                    case 2:
                        startActivity(new Intent(this, MoneyDetailsActivity.class).putExtra("type", type + "").putExtra("money", busgcmoney));
                        break;
                    case 3:
                        startActivity(new Intent(this, MoneyDetailsActivity.class).putExtra("type", type + "").putExtra("money", busresultmoney));
                        break;
                    case 4:
//                        startActivity(new Intent(this, MoneyDetailsTzActivity.class).putExtra("type", type + "").putExtra("money", busjfmoney));
                        startActivity(new Intent(this, MoneyDetailsBusjfActivity.class).putExtra("title", "奖罚").putExtra("money", busjfmoney));
                        break;
                    case 7:
                        startActivity(new Intent(this, MoneyDetailsTzTwoActivity.class).putExtra("type", "swhistory").putExtra("money", bushismoney));
                        break;
                }
                break;
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
                }
                break;
            case 3://主案
                switch (type) {
                    case 2:
                        startActivity(new Intent(this, MoneyDetailsZaActivity.class).putExtra("type", type + "").putExtra("money", desgcmoney));
                        break;
                    case 3:
                        startActivity(new Intent(this, MoneyDetailsZaActivity.class).putExtra("type", type + "").putExtra("money", desmoney));
                        break;
                    case 4:
                        startActivity(new Intent(this, MoneyDetailsTzTwoActivity.class).putExtra("type", "gcjiangfa").putExtra("money", desjfmoney));//主案奖罚和工程奖罚共用
                        break;
                }
                break;
            case 4://工程
                switch (type) {
                    case 2:
                        startActivity(new Intent(this, MoneyDetailsGcActivity.class).putExtra("type", type + "").putExtra("money", gcjxmoney));
                        break;
                    case 3:
                        startActivity(new Intent(this, MoneyDetailsTzTwoActivity.class).putExtra("type", "gcjiangfa").putExtra("money", gcjfmoney));
                        break;
                    case 4:
                        startActivity(new Intent(this, MoneyDetailsGcActivity.class).putExtra("type", type + "").putExtra("money", gccsmoney));
                        break;
                }
                break;
        }
    }

    @Override
    public void responsexzmoneydataError(String msg) {

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
    public void responseHospitalSalary(HospitalBean.BodyBean bean) {
        //                mvOne.setTitleAndType("总收", "基本工资", "绩效工资", "取其高", "实发");
//                mvTwo.setTitleAndType("过程", "", "", "", "");
//                mvThree.setTitleAndType("结果", "预收", "已收", "", "合计");
//                mvFour.setTitleAndType("奖罚", "奖金", "罚款", "考勤", "合计");
//                mvFive.setTitleAndType("提成", "提成收入", "", "", "");
//                mvSix.setTitleAndType("社保","社保","公积","个人所得税","合计");
//                mvSeven.setVisibility(View.VISIBLE);
//                mvSeven.setTitleAndType("历史","应发薪酬","未发薪酬","","");
//                mPresenter.getmoneydata(cardno);
        double salary = bean.getSalary();//实师工资      //实发
        float f = (float)salary;
        tvMoney.withNumber(f, false).start();
        double basicSalary = bean.getBasicSalary();//基本工资
        double achievements = bean.getAchievements();//绩效工资
        double high = bean.getHigh();//取其高
        mvOne.setContent(basicSalary+"",achievements+"",high+"",salary+"");
        double advancemoney = bean.getAdvancemoney();//预收
        double sumkfmoney = bean.getSumkfmoney();//已收
        double v = advancemoney + sumkfmoney;//合计
        Log.e("tag",v+"");
        mvTwo.setContent(0+"","","",0+"");
        mvThree.setContent(advancemoney+"",sumkfmoney+"","",v+"");
        double reward = bean.getReward();//奖金
        double fine = bean.getFine();//罚款
        double kq = bean.getKq();//考勤
        double v1 = reward + fine + kq;//合计
         mvFour.setContent(reward+"",fine+"",kq+"",v1+"");
        double tiCheng = bean.getTiCheng();  // bean.get  //提成收入
        mvFive.setContent(tiCheng+"","","",tiCheng+"");
        double social_security = bean.getSocial_security();//社保
        double accumulation_fund = bean.getAccumulation_fund();//公积
        double income_tax = bean.getIncome_tax();//个税
        double v3 = income_tax * (-1);//个税

        double v2 = social_security + accumulation_fund + v3;//合计
        mvSix.setContent(social_security+"",accumulation_fund+"",v3+"",doubleToString(v2));
        double historymoney = bean.getHistorymoney();
        mvSeven.setContent(historymoney+"","0","","");
    }
    /**
     * double转String,保留小数点后两位
     * @param num
     * @return
     */
    public static String doubleToString(double num){
        //使用0.00不足位补0，#.##仅保留有效位
        return new DecimalFormat("0.00").format(num);
    }
}