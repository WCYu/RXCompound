package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyBusRewardBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSProgressBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSResultBean;
import com.rxjy.rxcompound.entity.MoneyDTzProcessBean;
import com.rxjy.rxcompound.entity.MoneyDTzResultBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDTzContract;
import com.rxjy.rxcompound.mvp.presenter.MoneyDTzPresenter;
import com.rxjy.rxcompound.widget.MoneyDTzView;

import java.math.BigDecimal;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/14.
 */

public class MoneyDetailsTzActivity extends BaseActivity<MoneyDTzPresenter> implements MoneyDTzContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.mvt_one)
    MoneyDTzView mvtOne;
    @Bind(R.id.mvt_two)
    MoneyDTzView mvtTwo;
    @Bind(R.id.mvt_three)
    MoneyDTzView mvtThree;
    @Bind(R.id.mvt_four)
    MoneyDTzView mvtFour;
    @Bind(R.id.mvt_five)
    MoneyDTzView mvtFive;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.ll_money)
    LinearLayout llMoney;
    @Bind(R.id.mvt_six)
    MoneyDTzView mvtSix;
    @Bind(R.id.mvt_seven)
    MoneyDTzView mvtSeven;

    @Override
    public int getLayout() {
        return R.layout.activity_tzmoneydetails;
    }

    int year, month;

    String cardno;

    @Override
    public void initData() {
        tvTitle.setText("钱包");
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String money = intent.getStringExtra("money");
        tvMoney.setText(money);
//        cardno="01011451";
        cardno = App.cardNo;
        switch (type) {
            case "2"://投资行政经理结果
                tvTitle.setText("结果");
                mPresenter.gettzresultdata(year + "", month + "", cardno);
                break;
            case "3"://投资行政经理过程
                tvTitle.setText("过程");
                mPresenter.gettzprocessdata(year + "", month + "", cardno);
                break;
            case "4"://商务奖罚
                tvTitle.setText("奖罚");
                mPresenter.getbusrewarddata(year + "", month + "", cardno);
                break;
            case "2rs"://人事主管结果
                tvTitle.setText("结果");
                mPresenter.gettzrsresultdata(year + "", month + "", cardno);
                break;
            case "3rs"://人事主管过程
                tvTitle.setText("过程");
                mPresenter.gettzrsprocessdata(year + "", month + "", cardno);
                break;
        }
    }

    @Override
    protected MoneyDTzPresenter onCreatePresenter() {
        return new MoneyDTzPresenter(this);
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
    public void responsetzresultdata(MoneyDTzResultBean data) {
        MoneyDTzResultBean.BodyBean datas = data.getBody();
        mvtOne.setContent("施工签单", "标准 " + datas.getSgqdBz1(), "金额 " + StringUtils.getPrettyNumber(datas.getSgqdMoney() + ""), null, null, null, null, datas.getSgqdGongzi() + "", "合计");
        int shu = datas.getSwlrNum() - datas.getSwlrBz();//数
//        BigDecimal bshu=new BigDecimal(Integer.toString(shu));
        int danjia = datas.getSwlrDanjia() * shu;
        mvtTwo.setContent("商务老人", "标：" + datas.getSwlrNum() + "/" + datas.getSwlrBz(), "数", shu + "", "单价 " + datas.getSwlrDanjia() + "*" + shu + "=" + danjia, "系数 " + danjia + "*0=0", null, datas.getSwlrGongzi() + "", "合计");
        BigDecimal baifenone = new BigDecimal("0.01");
        String jiajumoney = StringUtils.getPrettyNumber(datas.getJiajuGongzi().multiply(baifenone).multiply(datas.getJiaju_precent()) + "");
        String ruodianmoney = StringUtils.getPrettyNumber(datas.getRuodianGongzi().multiply(baifenone).multiply(datas.getRuodian_precent()) + "");
        String shejimoney = StringUtils.getPrettyNumber(datas.getShejiGongzi().multiply(baifenone).multiply(datas.getSheji_precent()) + "");
        String jiaju = StringUtils.getPrettyNumber(datas.getJiajuGongzi() + "");
        String ruodian = StringUtils.getPrettyNumber(datas.getRuodianGongzi() + "");
        String sheji = StringUtils.getPrettyNumber(datas.getShejiGongzi() + "");
        mvtThree.setContent("家具绩效", "绩效签单 ", jiaju, null, "公式", jiaju + "*" + StringUtils.getPrettyNumber(datas.getJiaju_precent() + "") + "%=" + jiajumoney, null, jiaju, "合计");
        mvtFour.setContent("弱电绩效", "绩效签单 ", "" + ruodian, null, "公式", ruodian + "*" + StringUtils.getPrettyNumber(datas.getRuodian_precent() + "") + "%=" + ruodianmoney, null, ruodian, "合计");
        mvtFive.setContent("设计绩效", "绩效签单 ", "" + sheji, null, "公式", sheji + "*" + StringUtils.getPrettyNumber(datas.getSheji_precent() + "") + "%=" + shejimoney, null, sheji, "合计");
        mvtOne.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getSgqdGongzi() + ""), datas.getSgqdGongzi());
        mvtTwo.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getSwlrGongzi() + ""), datas.getSwlrGongzi());
        mvtThree.setTvColor(this, 7, 0, jiaju, datas.getJiajuGongzi());
        mvtFour.setTvColor(this, 7, 0, ruodian, datas.getRuodianGongzi());
        mvtFive.setTvColor(this, 7, 0, sheji, datas.getShejiGongzi());
        mvtSix.setVisibility(View.GONE);
        mvtSeven.setVisibility(View.GONE);
    }

    @Override
    public void responsetzresultdataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsetzprocesdata(MoneyDTzProcessBean data) {

        MoneyDTzProcessBean.BodyBean datas = data.getBody();
        int danjia = datas.getShangwu_danjia() * datas.getShangwu_num();
        int zadanjia = datas.getZhuan_danjia() * datas.getZhuan_num();
        int mddanjia = datas.getMaidan_danjia() * datas.getMaidan_num();
        int ztdanjia = datas.getZaitanHF_danjia() * datas.getZaitanHF_num();
        int wqdanjia = datas.getWeiqian_danjia() * datas.getWeiqian_num();
        int wuxiao = (-datas.getShangwuInvalid_koukuan()) * datas.getShangwuInvalid_num();
        int zawuxiao = (-datas.getZhuanInvalid_koukuan()) * datas.getZhuanInvalid_num();
        mvtOne.setContent("商务人", "总数 " + datas.getShangwu_num(), "无效 " + datas.getShangwuInvalid_num(), null, "单价 " + datas.getShangwu_danjia() + "*" + datas.getShangwu_num() + "=" + danjia, "无效 " + (-datas.getShangwuInvalid_koukuan()) + "*" + datas.getShangwuInvalid_num() + "=" + wuxiao, "系数 " + danjia + "*0=0", StringUtils.getPrettyNumber(datas.getShangwu_gongzi() + ""), "合计");
        mvtTwo.setContent("主案人", "总数 " + datas.getZhuan_num(), "无效 " + datas.getZhuanInvalid_num(), null, "单价 " + datas.getZhuan_danjia() + "*" + datas.getZhuan_num() + "=" + zadanjia, "无效 " + (-datas.getZhuanInvalid_koukuan()) + "*" + datas.getZhuanInvalid_num() + "=" + zawuxiao, "系数 " + zadanjia + "*0=0", StringUtils.getPrettyNumber(datas.getZhuan_gongzi() + ""), "合计");
        mvtThree.setContent("买单", "次数 " + datas.getMaidan_num(), null, null, "单价 " + datas.getMaidan_danjia() + "*" + datas.getMaidan_num() + "=" + mddanjia, "系数 " + mddanjia + "*0=0", null, StringUtils.getPrettyNumber(datas.getMaidan_gongzi() + ""), "合计");
        mvtFour.setContent("在谈回访", "次数 " + datas.getZaitanHF_num(), null, null, "单价 " + datas.getZaitanHF_danjia() + "*" + datas.getZaitanHF_num() + "=" + ztdanjia, "系数 " + ztdanjia + "*0=0", null, StringUtils.getPrettyNumber(datas.getZaitanHF_gongzi() + ""), "合计");
        mvtFive.setContent("未签", "次数 " + datas.getWeiqian_num(), null, null, "单价 " + datas.getWeiqian_danjia() + "*" + datas.getWeiqian_num() + "=" + wqdanjia, "系数 " + wqdanjia + "*0=0", null, StringUtils.getPrettyNumber(datas.getWeiqian_gongzi() + ""), "合计");
        mvtOne.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getShangwu_gongzi() + ""), datas.getShangwu_gongzi());
        mvtTwo.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getZhuan_gongzi() + ""), datas.getZhuan_gongzi());
        mvtThree.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getMaidan_gongzi() + ""), datas.getMaidan_gongzi());
        mvtFour.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getZaitanHF_gongzi() + ""), datas.getZaitanHF_gongzi());
        mvtFive.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getWeiqian_gongzi() + ""), datas.getWeiqian_gongzi());
        mvtSix.setVisibility(View.GONE);
        mvtSeven.setVisibility(View.GONE);
    }

    @Override
    public void responsetzprocesdataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsebusrewarddata(MoneyBusRewardBean data) {
        MoneyBusRewardBean.BodyBean datas = data.getBody().get(0);
        mvtOne.setContent("事件", "总数 " + datas.getEventCount(), null, null, null, null, null, "金额 " + StringUtils.getPrettyNumber(datas.getEventReward() + ""));
        BigDecimal xiaoji = datas.getExecuteGzReward().add(datas.getExecuteXjReward());
        mvtTwo.setContent("执行", "数量 " + datas.getExecuteGzCount(), "数量 " + datas.getExecuteXjCount(), null, "工资 " + StringUtils.getPrettyNumber(datas.getExecuteGzReward() + ""), "现金 " + StringUtils.getPrettyNumber(datas.getExecuteXjReward() + ""), null, "小计 " + StringUtils.getPrettyNumber(xiaoji + ""));
        mvtThree.setContent("量房累计", "数量 " + datas.getLfCount(), null, null, null, null, null, "金额 " + StringUtils.getPrettyNumber(datas.getLfReward() + ""));
        mvtFour.setContent("集团奖金", "数量 " + datas.getJtCount(), null, null, null, null, null, "金额 " + StringUtils.getPrettyNumber(datas.getJtReward() + ""));
        mvtFive.setContent("合计", "数量 " + datas.getTotalCount(), null, null, null, null, null, "金额 " + StringUtils.getPrettyNumber(datas.getTotalMoney() + ""));
        mvtOne.setTvColor(this, 7, 3, "金额 " + StringUtils.getPrettyNumber(datas.getEventReward() + ""), datas.getEventReward());
        mvtTwo.setTvColor(this, 7, 3, "小计 " + StringUtils.getPrettyNumber(xiaoji + ""), xiaoji);
        mvtThree.setTvColor(this, 7, 3, "金额 " + StringUtils.getPrettyNumber(datas.getLfReward() + ""), datas.getLfReward());
        mvtFour.setTvColor(this, 7, 3, "金额 " + StringUtils.getPrettyNumber(datas.getJtReward() + ""), datas.getJtReward());
        mvtFive.setTvColor(this, 7, 3, "金额 " + StringUtils.getPrettyNumber(datas.getTotalMoney() + ""), datas.getTotalMoney());
        mvtSix.setVisibility(View.GONE);
        mvtSeven.setVisibility(View.GONE);
    }

    @Override
    public void responsebusrewarddataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsetzrsresultdata(MoneyDTZRSResultBean data) {
        MoneyDTZRSResultBean.BodyBean datas = data.getBody();
        int danjia_three = datas.getThree_month_dj().intValue();
        int danjia_six = datas.getSix_month_dj().intValue();
        int danjia_one = datas.getOne_year_dj().intValue();
        int danjia_lizhi = datas.getLizhi_dj().intValue();
        int danjias_three = danjia_three * datas.getThree_month_num();
        int danjias_six = danjia_six * datas.getSix_month_num();
        int danjias_one = danjia_one * datas.getOne_year_num();
        int danjias_lizhi = danjia_lizhi * datas.getLizhi_num();
        mvtOne.setContent("三个月", "标：" + datas.getThree_month_num() + "/" + datas.getThree_month_bz(), "数：", datas.getThree_month_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getThree_month_dj() + "") + "*" + datas.getThree_month_num() + "=" + danjias_three, "系数 " + danjias_three + "*0=0", null, StringUtils.getPrettyNumber(datas.getThree_month_gongzi() + "") + "", "合计");
        mvtTwo.setContent("半年老人", "标：" + datas.getSix_month_num() + "/" + datas.getSix_month_bz(), "数：", datas.getSix_month_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getSix_month_dj() + "") + "*" + datas.getSix_month_num() + "=" + danjias_six, "系数 " + danjias_six + "*0=0", null, StringUtils.getPrettyNumber(datas.getSix_month_gongzi() + "") + "", "合计");
        mvtThree.setContent("一年老人", "标：" + datas.getOne_year_num() + "/" + datas.getOne_year_bz(), "数：", datas.getOne_year_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getOne_year_dj() + "") + "*" + datas.getOne_year_num() + "=" + danjias_one, "系数 " + danjias_one + "*0=0", null, StringUtils.getPrettyNumber(datas.getOne_year_gongzi() + "") + "", "合计");
        mvtFour.setContent("离职人数", "标：" + datas.getLizhi_num() + "/" + datas.getLizhi_bz(), "数：", datas.getLizhi_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getLizhi_dj() + "") + "*" + datas.getLizhi_num() + "=" + danjias_lizhi, "系数 " + danjias_lizhi + "*0=0", null, StringUtils.getPrettyNumber(datas.getLizhi_gongzi() + "") + "", "合计");
        mvtOne.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getThree_month_gongzi() + ""), datas.getThree_month_gongzi());
        mvtTwo.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getSix_month_gongzi() + ""), datas.getSix_month_gongzi());
        mvtThree.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getOne_year_gongzi() + ""), datas.getOne_year_gongzi());
        mvtFour.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getLizhi_gongzi() + ""), datas.getLizhi_gongzi());
        mvtFive.setVisibility(View.GONE);
        mvtSix.setVisibility(View.GONE);
        mvtSeven.setVisibility(View.GONE);
    }

    @Override
    public void responsetzrsresultdataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsetzrsprocesdata(MoneyDTZRSProgressBean data) {
        MoneyDTZRSProgressBean.BodyBean datas=data.getBody();
        int danjia_shi = datas.getShigang_dj().intValue();
        int danjias_shi = danjia_shi * datas.getShigang_num();
        int danjia_sw = datas.getSw_ruzhi_dj().intValue();
        int danjias_sw = danjia_sw * datas.getSw_ruzhi_num();
        int danjia_za = datas.getZa_ruzhi_dj().intValue();
        int danjias_za = danjia_za * datas.getZa_ruzhi_num();
        int danjia_zz = datas.getZhuanzheng_dj().intValue();
        int danjias_zz = danjia_zz * datas.getZhuanzheng_num();
        int danjia_hj = datas.getXz_ping_gu_dj().intValue();
        int danjias_hj = danjia_hj * datas.getXz_ping_gu_num();
        int danjia_hjw = datas.getXz_ping_gu_debit().intValue();
        int danjias_hjw = -danjia_hjw * datas.getXz_ping_gu_num_invalid();
        int danjia_xx = datas.getXingxiang_dj().intValue();
        int danjias_xx = danjia_xx * datas.getXingxiang_num();
        int danjia_xxw = datas.getXingxiang_debit().intValue();
        int danjias_xxw = -danjia_xxw * datas.getXingxiang_num_invalid();
        int danjia_rw = datas.getRw_zhi_xing_dj().intValue();
        int danjias_rw = danjia_rw * datas.getRw_zhi_xing_num();
        mvtOne.setContent("试岗", "标：" + datas.getShigang_num() + "/" + datas.getShigang_bz(), "数：", datas.getShigang_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getShigang_dj() + "") + "*" + datas.getShigang_num() + "=" + danjias_shi, "系数 " + danjias_shi + "*0=0", null, StringUtils.getPrettyNumber(datas.getShigang_gongzi() + "") + "", "合计");
        mvtTwo.setContent("商务入职", "标：" + datas.getSw_ruzhi_num() + "/" + datas.getSw_ruzhi_bz(), "数：", datas.getSw_ruzhi_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getSw_ruzhi_dj() + "") + "*" + datas.getSw_ruzhi_num() + "=" + danjias_sw, "系数 " + danjias_sw + "*0=0", null, StringUtils.getPrettyNumber(datas.getSw_ruzhi_gongzi() + "") + "", "合计");
        mvtThree.setContent("主案入职", "标：" + datas.getZhuanzheng_num() + "/" + datas.getZhuanzheng_bz(), "数：", datas.getZhuanzheng_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getZhuanzheng_dj() + "") + "*" + datas.getZhuanzheng_num() + "=" + danjias_za, "系数 " + danjias_za + "*0=0", null, StringUtils.getPrettyNumber(datas.getZhuanzheng_gongzi() + "") + "", "合计");
        mvtFour.setContent("转正", "标：" + datas.getZhuanzheng_num() + "/" + datas.getZhuanzheng_bz(), "数：", datas.getZhuanzheng_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getZhuanzheng_dj() + "") + "*" + datas.getZhuanzheng_num() + "=" + danjias_zz, "系数 " + danjias_zz + "*0=0", null, StringUtils.getPrettyNumber(datas.getZhuanzheng_gongzi() + "") + "", "合计");
        mvtFive.setContent("环境", "标：" + datas.getXz_ping_gu_num() + "/" + datas.getXz_ping_gu_bz(), "数：", datas.getXz_ping_gu_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getXz_ping_gu_dj() + "") + "*" + datas.getXz_ping_gu_num() + "=" + danjias_hj, "系数 " + danjias_hj + "*0=0", "无效 -" + danjia_hjw + "*"+datas.getXz_ping_gu_num_invalid()+"="+danjias_hjw, StringUtils.getPrettyNumber(datas.getXz_ping_gu_gongzi() + "") + "", "合计","无效："+datas.getXz_ping_gu_num_invalid());
        mvtSix.setContent("形象", "标：" + datas.getXingxiang_num() + "/" + datas.getXingxiang_bz(), "数：", datas.getXingxiang_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getXingxiang_dj() + "") + "*" + datas.getXingxiang_num() + "=" + danjias_xx, "系数 " + danjias_xx + "*0=0", "无效 -" + danjia_xxw + "*"+datas.getXingxiang_num_invalid()+"="+danjias_xxw, StringUtils.getPrettyNumber(datas.getXingxiang_gongzi() + "") + "", "合计","无效："+datas.getXingxiang_num_invalid());
        mvtSeven.setContent("任务", "标：" + datas.getRw_zhi_xing_num() + "/" + datas.getRw_zhi_xing_bz(), "数：", datas.getRw_zhi_xing_num() + "", "单价 " + StringUtils.getPrettyNumber(datas.getRw_zhi_xing_dj() + "") + "*" + datas.getRw_zhi_xing_num() + "=" + danjias_rw, "系数 " + danjias_rw + "*0=0", null, StringUtils.getPrettyNumber(datas.getRw_zhi_xing_gongzi() + "") + "", "合计");
        mvtOne.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getShigang_gongzi() + ""), datas.getShigang_gongzi());
        mvtTwo.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getSw_ruzhi_gongzi() + ""), datas.getSw_ruzhi_gongzi());
        mvtThree.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getZa_ruzhi_gongzi() + ""), datas.getZa_ruzhi_gongzi());
        mvtFour.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getZhuanzheng_gongzi() + ""), datas.getZhuanzheng_gongzi());
        mvtFive.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getXz_ping_gu_gongzi() + ""), datas.getXz_ping_gu_gongzi());
        mvtSix.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getXingxiang_gongzi()+ ""), datas.getXingxiang_gongzi());
        mvtSeven.setTvColor(this, 7, 0, StringUtils.getPrettyNumber(datas.getRw_zhi_xing_gongzi() + ""), datas.getRw_zhi_xing_gongzi());

    }

    @Override
    public void responsetzrsprocesdataError(String msg) {
        showToast(msg);
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}