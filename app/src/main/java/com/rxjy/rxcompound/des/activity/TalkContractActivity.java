package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.entity.TalkContractBean;
import com.rxjy.rxcompound.des.entity.TalkContractSubBean;
import com.rxjy.rxcompound.des.mvp.contract.TalkContractContract;
import com.rxjy.rxcompound.des.mvp.presenter.TalkContractPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/5/15.
 */

public class TalkContractActivity extends BaseActivity<TalkContractPresenter> implements TalkContractContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_proportion)
    EditText etProportion;
    @Bind(R.id.rl_proportion)
    RelativeLayout rlProportion;
    @Bind(R.id.et_contract)
    EditText etContract;
    @Bind(R.id.rl_contract)
    RelativeLayout rlContract;
    @Bind(R.id.et_warkdate)
    EditText etWarkdate;
    @Bind(R.id.et_roadworkdate)
    EditText etRoadworkdate;
    @Bind(R.id.rl_roadworkdate)
    RelativeLayout rlRoadworkdate;
    @Bind(R.id.et_protect)
    EditText etProtect;
    @Bind(R.id.rl_protect)
    RelativeLayout rlProtect;
    @Bind(R.id.et_blueprint)
    EditText etBlueprint;
    @Bind(R.id.rl_blueprint)
    RelativeLayout rlBlueprint;
    @Bind(R.id.et_auditdate)
    EditText etAuditdate;
    @Bind(R.id.et_managementmoney)
    EditText etManagementmoney;
    @Bind(R.id.et_deposit)
    EditText etDeposit;
    @Bind(R.id.et_waterelectricity)
    EditText etWaterelectricity;
    @Bind(R.id.et_waterlose)
    EditText etWaterlose;
    @Bind(R.id.et_airconditioning)
    EditText etAirconditioning;
    @Bind(R.id.rl_airconditioning)
    RelativeLayout rlAirconditioning;
    @Bind(R.id.et_fire)
    EditText etFire;
    @Bind(R.id.rl_fire)
    RelativeLayout rlFire;
    @Bind(R.id.et_project)
    EditText etProject;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;

    @Override
    public int getLayout() {
        return R.layout.activity_talkcontract;
    }

    String rwdid;

    @Override
    public void initData() {
        Intent intent = getIntent();
        rwdid = intent.getStringExtra("rwdid");
        DataAdd();
        mPresenter.getData(rwdid);
    }

    @Override
    protected TalkContractPresenter onCreatePresenter() {
        return new TalkContractPresenter(this);
    }

    /**
     * 添加数据
     */
    ArrayList<String> proportionlist, blueprintlist, roadworkdatelist, yesnolist;

    private void DataAdd() {
        proportionlist = new ArrayList<>();
        proportionlist.add("6/3/1");
        proportionlist.add("5/4/1");
        proportionlist.add("4/5/4");
        proportionlist.add("4/3/2/1");
        proportionlist.add("3/3/3/1");
        blueprintlist = new ArrayList<>();
        blueprintlist.add("蓝图");
        blueprintlist.add("白图");
        roadworkdatelist = new ArrayList<>();
        roadworkdatelist.add("白天");
        roadworkdatelist.add("晚上");
        roadworkdatelist.add("均可");
        yesnolist = new ArrayList<>();
        yesnolist.add("是");
        yesnolist.add("否");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    private TimePickerView timePickerView, timePickerViewtwo;
    private OptionsPickerView pVproportion, pVprotect, pVblueprint, pVaircond, pVfire;

    @OnClick({R.id.iv_back, R.id.rl_proportion, R.id.rl_contract, R.id.rl_roadworkdate, R.id.rl_protect,
            R.id.rl_blueprint, R.id.rl_airconditioning, R.id.rl_fire, R.id.tv_submit,R.id.et_proportion,
            R.id.et_contract, R.id.et_roadworkdate, R.id.et_protect, R.id.et_blueprint, R.id.et_airconditioning, R.id.et_fire})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_proportion:
                pVproportion = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etProportion.setText(proportionlist.get(options1));
                    }
                }).build();
                pVproportion.setPicker(proportionlist);
                pVproportion.show();
                break;
            case R.id.rl_contract:
                timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        etContract.setText(time);
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .build();
                timePickerView.show();
                break;
            case R.id.rl_roadworkdate:
                timePickerViewtwo = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        etRoadworkdate.setText(time);
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .build();
                timePickerViewtwo.show();
                break;
            case R.id.rl_protect:
                pVprotect = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etProtect.setText(yesnolist.get(options1));
                    }
                }).build();
                pVprotect.setPicker(yesnolist);
                pVprotect.show();
                break;
            case R.id.rl_blueprint:
                pVblueprint = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etBlueprint.setText(blueprintlist.get(options1));
                    }
                }).build();
                pVblueprint.setPicker(blueprintlist);
                pVblueprint.show();
                break;
            case R.id.rl_airconditioning:
                pVaircond = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etAirconditioning.setText(yesnolist.get(options1));
                    }
                }).build();
                pVaircond.setPicker(yesnolist);
                pVaircond.show();
                break;
            case R.id.rl_fire:
                pVfire = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etFire.setText(yesnolist.get(options1));
                    }
                }).build();
                pVfire.setPicker(yesnolist);
                pVfire.show();
                break;
            case R.id.et_proportion:
                pVproportion = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etProportion.setText(proportionlist.get(options1));
                    }
                }).build();
                pVproportion.setPicker(proportionlist);
                pVproportion.show();
                break;
            case R.id.et_contract:
                timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        etContract.setText(time);
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .build();
                timePickerView.show();
                break;
            case R.id.et_roadworkdate:
                timePickerViewtwo = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        etRoadworkdate.setText(time);
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .build();
                timePickerViewtwo.show();
                break;
            case R.id.et_protect:
                pVprotect = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etProtect.setText(yesnolist.get(options1));
                    }
                }).build();
                pVprotect.setPicker(yesnolist);
                pVprotect.show();
                break;
            case R.id.et_blueprint:
                pVblueprint = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etBlueprint.setText(blueprintlist.get(options1));
                    }
                }).build();
                pVblueprint.setPicker(blueprintlist);
                pVblueprint.show();
                break;
            case R.id.et_airconditioning:
                pVaircond = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etAirconditioning.setText(yesnolist.get(options1));
                    }
                }).build();
                pVaircond.setPicker(yesnolist);
                pVaircond.show();
                break;
            case R.id.et_fire:
                pVfire = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        etFire.setText(yesnolist.get(options1));
                    }
                }).build();
                pVfire.setPicker(yesnolist);
                pVfire.show();
                break;
            case R.id.tv_submit:
                Submit();
                break;
        }
    }


    /**
     * 数据提交
     */
    String proportion, contract, workdate, roadworkdate, protect, blueprint, auditdate,
            managementmoney, deposit, waterelectricity, waterlose, aircondit, fire, project;
    int airconditint, fireint;

    private void Submit() {
        proportion = etProportion.getText().toString();
        contract = etContract.getText().toString();
        workdate = etWarkdate.getText().toString();
        roadworkdate = etRoadworkdate.getText().toString();
        protect = etProtect.getText().toString();
        blueprint = etBlueprint.getText().toString();
        auditdate = etAuditdate.getText().toString();
        managementmoney = etManagementmoney.getText().toString();
        deposit = etDeposit.getText().toString();
        waterelectricity = etWaterelectricity.getText().toString();
        waterlose = etWaterlose.getText().toString();
        aircondit = etAirconditioning.getText().toString();
        if (!StringUtils.isEmpty(aircondit)) {
            switch (aircondit) {
                case "是":
                    airconditint = 1;
                    break;
                case "否":
                    airconditint = 2;
                    break;
            }
        }
        fire = etFire.getText().toString();
        if (!StringUtils.isEmpty(fire)) {
            switch (fire) {
                case "是":
                    fireint = 1;
                    break;
                case "否":
                    fireint = 2;
                    break;
            }
        }
        project = etProject.getText().toString();
        TalkContractSubBean submitdata = new TalkContractSubBean();
        submitdata.setCaHtPayProportion(proportion);
        submitdata.setCaHtSignDate(contract);
        submitdata.setCaHtWorkCycle(workdate);
        submitdata.setCaReqConTime(roadworkdate);
        submitdata.setCaProductProtection(protect);
        submitdata.setCaBlueprint(blueprint);
        submitdata.setCaHtAuditingCycle(auditdate);
        submitdata.setCaHtManagePrice(managementmoney);
        submitdata.setCaHtDeposit(deposit);
        submitdata.setCaHtHydropowerPrice(waterelectricity);
        submitdata.setCaHtBlowdownPrice(waterlose);
        submitdata.setCaDesignatedAirCompany(airconditint + "");
        submitdata.setCaDesignatedFireCompany(fireint + "");
        submitdata.setCaHtRiskPrice(project);
        Gson gson = new Gson();
        String subdata = gson.toJson(submitdata);
        Log.e("上传的数据是：：", subdata);
        mPresenter.submitData(subdata,rwdid);

    }


    /**
     * 请求下数据返回
     */
    @Override
    public void responseData(TalkContractBean data) {
        etProportion.setText(data.getBody().getContractInfomationPojo().getCa_HtPayProportion());
        etContract.setText(data.getBody().getContractInfomationPojo().getCa_HtSignDate());
        etWarkdate.setText(data.getBody().getContractInfomationPojo().getCa_HtWorkCycle());
        etRoadworkdate.setText(data.getBody().getPropertyInformation().getCa_ReqConTime());
        etProtect.setText(data.getBody().getPropertyInformation().getCa_ProductProtection());
        etBlueprint.setText(data.getBody().getPropertyInformation().getCa_Blueprint());
        etAuditdate.setText(data.getBody().getPropertyInformation().getCa_HtAuditingCycle());
        etManagementmoney.setText(data.getBody().getPropertyInformation().getCa_HtManagePrice());
        etDeposit.setText(data.getBody().getPropertyInformation().getCa_HtDeposit());
        etWaterelectricity.setText(data.getBody().getPropertyInformation().getCa_HtHydropowerPrice());
        etWaterlose.setText(data.getBody().getPropertyInformation().getCa_HtBlowdownPrice());
        switch (data.getBody().getPropertyInformation().getCa_DesignatedAirCompany()){
            case "1":
                etAirconditioning.setText("是");
                break;
            case "2":
                etAirconditioning.setText("否");
                break;
        }
        switch (data.getBody().getPropertyInformation().getCa_DesignatedFireCompany()){
            case "1":
                etFire.setText("是");
                break;
            case "2":
                etFire.setText("否");
                break;
        }
        etProject.setText(data.getBody().getPropertyInformation().getCa_HtRiskPrice());
    }

    @Override
    public void responseDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsesubmitData() {
        showToast("提交成功！");
        finish();
    }

    @Override
    public void responsesubmitDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    public String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

}