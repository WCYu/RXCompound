package com.rxjy.rxcompound.des.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.DesignInfo;
import com.rxjy.rxcompound.des.mvp.contract.CompactContract;
import com.rxjy.rxcompound.des.mvp.presenter.CompactPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/14.
 */

public class CompactActivity extends BaseActivity<CompactPresenter> implements CompactContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.payment_Ratio)
    TextView paymentRatio;
    @Bind(R.id.contract_Signing)
    TextView contractSigning;
    @Bind(R.id.time_limit)
    EditText timeLimit;
    @Bind(R.id.ocnstructionTime)
    TextView ocnstructionTime;
    @Bind(R.id.regional_Protection)
    TextView regionalProtection;
    @Bind(R.id.Blueprint)
    TextView Blueprint;
    @Bind(R.id.audit_Cycle)
    EditText auditCycle;
    @Bind(R.id.management_Expense)
    EditText managementExpense;
    @Bind(R.id.deposit)
    EditText deposit;
    @Bind(R.id.waterElectricity)
    EditText waterElectricity;
    @Bind(R.id.discharge_Fee)
    EditText dischargeFee;
    @Bind(R.id.air_Conditioner)
    TextView airConditioner;
    @Bind(R.id.fire_Control)
    TextView fireControl;
    @Bind(R.id.all_Engineering)
    EditText allEngineering;
    @Bind(R.id.submission)
    Button submission;
    AllClientNewBean.ClientNewBean info;
    @Override
    public int getLayout() {
        return R.layout.activity_add_contract;
    }

    @Override
    public void initData() {
        info = (AllClientNewBean.ClientNewBean) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        Log.e("lrj",info.getCi_RwdId());
       // Log.e("lrj",info.get)
        mPresenter.getDegisInfoData(info.getCi_RwdId());
    }

    @Override
    protected CompactPresenter onCreatePresenter() {
        return new CompactPresenter(this);
    }

    @Override
    public void getDegisInfoData(DesignInfo.BodyBean bodyBean) {
//        /**设计师卡号*/
//        @property(nonatomic,strong)NSString               *ci_DesignerCard;
//
///**项目类型*/
//        @property(nonatomic,strong)NSString               *ci_Type;
///**二级类型*/
//        @property(nonatomic,strong)NSString               *ca_SWIndustryTypeID;
///**公司名称*/
//        @property(nonatomic,strong)NSString               *ci_ClientName;
///**地址*/
////@property(nonatomic,strong)NSString               *ci_OfficeAddress;
///**使用面积*/
//        @property(nonatomic,assign)CGFloat               ci_Area;
///**状态*/
//        @property(nonatomic,copy)NSString            * ca_AvailabilityStatus;
///**地区id*/
//        @property(nonatomic,strong)NSString               *tb_diqu;
///**<#注解#>*/
//        @property(nonatomic,strong)NSString               *ci_DecorationAddress;
///**装修预算*/
//        @property(nonatomic,assign)double             ca_DecBudgetPrice;
///**<#注解#>*/
//        @property(nonatomic,copy)NSString               *ca_IntentionalStyle;
///**房屋状况*/
//        @property(nonatomic,copy)NSString            * ca_HousingType;
///**免租期*/
//        @property(nonatomic,copy)NSString            * ca_RentFreeDate;
///**建筑面积*/
//        @property(nonatomic,assign)double             ci_BuildingArea;
///**装修时间*/
//        @property(nonatomic,copy)NSString            * ca_DecorationDate;
///**风水要求*/
//        @property(nonatomic,copy)NSString            * ca_FengShuiRequirements;
///**家居软装*/
//        @property(nonatomic,copy)NSString            * ca_SoftFurniture;
///**智能弱电*/
//        @property(nonatomic,copy)NSString            * ca_IntelligentWeakCurrent;
///**电梯使用情况*/
//        @property(nonatomic,copy)NSString            * ca_Elevator;
///**保护材料*/
//        @property(nonatomic,copy)NSString            * ca_ProtectiveMaterial;
///**施工时间*/
//        @property(nonatomic,strong)NSString               *ca_ReqConTime;
///**指定空调公司*/
//        @property(nonatomic,copy)NSString            * ca_DesignatedAirCompany;
///**指定消防公司*/
//        @property(nonatomic,copy)NSString            *ca_DesignatedFireCompany;
///**工程一切险要求*/
//        @property(nonatomic,copy)NSString            * ca_PropertyInsurance;
///**指定垃圾外运公司*/
//        @property(nonatomic,copy)NSString            * ca_DesignatedSinotrans;
///**报审蓝图*/
//        @property(nonatomic,copy)NSString            * ca_Blueprint;
///**资质要求*/
//        @property(nonatomic,copy)NSString            * ca_Aptitude;
///**空调消防维保单位*/
//        @property(nonatomic,copy)NSString            * ca_Maintenance;
///**纸质审核*/
//        @property(nonatomic,copy)NSString            * ca_DrawAudit;
///**付款比例*/
//        @property(nonatomic,copy)NSString               *ca_HtPayProportion;
///**签订日期*/
//        @property(nonatomic,copy)NSString               *ca_HtSignDate;
///**合同工期*/
//        @property(nonatomic,copy)NSString               *ca_HtWorkCycle;
///**区域保护*/
//        @property(nonatomic,copy)NSString               *ca_ProductProtection;
///**审核周期*/
//        @property(nonatomic,copy)NSString               *ca_HtAuditingCycle;
///**管理费*/
//        @property(nonatomic,copy)NSString               *ca_HtManagePrice;
///**押金*/
//        @property(nonatomic,copy)NSString               *ca_HtDeposit;
///**水电费*/
//        @property(nonatomic,copy)NSString               *ca_HtHydropowerPrice;
///**泄水费*/
//        @property(nonatomic,copy)NSString               *ca_HtBlowdownPrice;
///**工程一切险金额*/
//        @property(nonatomic,copy)NSString               *ca_HtRiskPrice;
        DesignInfo.BodyBean.BaseInformationBean baseInformation = bodyBean.getBaseInformation();
        DesignInfo.BodyBean.BuildingInformationBean buildingInformation = bodyBean.getBuildingInformation();
        String ca_htPayProportion = bodyBean.getContractInfomationPojo().getCa_HtPayProportion();
       if(!ca_htPayProportion.equals("")) {
           paymentRatio.setText(ca_htPayProportion);
       }
        //ca_HtSignDate
        String ca_htSignDate = bodyBean.getContractInfomationPojo().getCa_HtSignDate();
        if(!ca_htSignDate.equals("")) {
            contractSigning.setText(ca_htSignDate);
        }
        String ca_htWorkCycle = bodyBean.getContractInfomationPojo().getCa_HtWorkCycle();
        if(!ca_htSignDate.equals("")){
            timeLimit.setText(ca_htWorkCycle);
        }
        //ca_ReqConTime
        DesignInfo.BodyBean.PropertyInformationBean propertyInformation = bodyBean.getPropertyInformation();

        String ca_reqConTime = propertyInformation.getCa_ReqConTime();
        if(!ca_reqConTime.equals("")){
            ocnstructionTime.setText(ca_reqConTime);
        }
        //ca_ProductProtection
        String ca_productProtection = propertyInformation.getCa_ProductProtection();
        if(!ca_productProtection.equals("")){
            regionalProtection.setText(ca_productProtection);
        }
        //Blueprint ca_Blueprint
        String ca_blueprint = propertyInformation.getCa_Blueprint();
        if(!ca_blueprint.equals("")){
            Blueprint.setText(ca_blueprint);
        }
        //ca_HtAuditingCycle
        String ca_htAuditingCycle = propertyInformation.getCa_HtAuditingCycle();
//        if(!ca_blueprint.equals("")){
//            auditCycle
//        }
    }

    @Override
    public void showMessage(String message) {
        showToast(message);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }



    @OnClick({R.id.iv_back, R.id.submission})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.submission:
                break;
        }
    }
}
