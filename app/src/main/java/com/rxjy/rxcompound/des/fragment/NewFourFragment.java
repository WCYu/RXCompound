package com.rxjy.rxcompound.des.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.DesDaiMeasureActivity;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;
import com.rxjy.rxcompound.des.entity.NewFourInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewFourContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewFourPresenter;
import com.rxjy.rxcompound.widget.TextGridview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;


public class NewFourFragment extends BaseFragment<NewFourPresenter> implements NewFourContract.View, View.OnClickListener {


//    @Bind(R.id.rb_new_shigongshijian_baitian)
//    RadioButton rbNewShigongshijianBaitian;
//    @Bind(R.id.rb_new_shigongshijian_wanshang)
//    RadioButton rbNewShigongshijianWanshang;
//    @Bind(R.id.rb_new_shigongshijian_junke)
//    RadioButton rbNewShigongshijianJunke;
//    @Bind(R.id.rg_new_shigongshijian)
//    RadioGroup rgNewShigongshijian;
//    @Bind(R.id.rb_new_gonggongquyubaohu_shi)
//    RadioButton rbNewGonggongquyubaohuShi;
//    @Bind(R.id.rb_new_gonggongquyubaohu_fou)
//    RadioButton rbNewGonggongquyubaohuFou;
//    @Bind(R.id.rg_new_gonggongquyubaohu)
//    RadioGroup rgNewGonggongquyubaohu;
//    @Bind(R.id.rb_new_wuyegongcheng_shi)
//    RadioButton rbNewWuyegongchengShi;
//    @Bind(R.id.rb_new_wuyegongcheng_fou)
//    RadioButton rbNewWuyegongchengFou;
//    @Bind(R.id.rg_new_wuyegongcheng)
//    RadioGroup rgNewWuyegongcheng;
//    @Bind(R.id.rb_new_zhidingxiaofang_shi)
//    RadioButton rbNewZhidingxiaofangShi;
//    @Bind(R.id.rb_new_zhidingxiaofang_fou)
//    RadioButton rbNewZhidingxiaofangFou;
//    @Bind(R.id.rg_new_zhidingxiaofang)
//    RadioGroup rgNewZhidingxiaofang;
//    @Bind(R.id.rb_new_zhidingkongtiao_shi)
//    RadioButton rbNewZhidingkongtiaoShi;
//    @Bind(R.id.rb_new_zhidingkongtiao_fou)
//    RadioButton rbNewZhidingkongtiaoFou;
//    @Bind(R.id.rg_new_zhidingkongtiao)
//    RadioGroup rgNewZhidingkongtiao;
//    @Bind(R.id.rb_new_zhidinglajiwaiyun_shi)
//    RadioButton rbNewZhidinglajiwaiyunShi;
//    @Bind(R.id.rb_new_zhidinglajiwaiyun_fou)
//    RadioButton rbNewZhidinglajiwaiyunFou;
//    @Bind(R.id.rg_new_zhidinglajiwaiyun)
//    RadioGroup rgNewZhidinglajiwaiyun;
//    @Bind(R.id.rb_new_baoshenlantu_shi)
//    RadioButton rbNewBaoshenlantuShi;
//    @Bind(R.id.rb_new_baoshenlantu_fou)
//    RadioButton rbNewBaoshenlantuFou;
//    @Bind(R.id.rg_new_baoshenlantu)
//    RadioGroup rgNewBaoshenlantu;
    @Bind(R.id.et_new_wuyeshigongyaoqiu)
    EditText etNewWuyeshigongyaoqiu;
    @Bind(R.id.et_new_propertyperson)
    EditText et_new_propertyperson;
    @Bind(R.id.et_new_twofixperson)
    EditText et_new_twofixperson;
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;

    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;
//    @Bind(R.id.rb_new_baohucailiao_swxm)
//    RadioButton rbNewBaohucailiaoSwxm;
//    @Bind(R.id.rb_new_baohucailiao_sbxm)
//    RadioButton rbNewBaohucailiaoSbxm;
//    @Bind(R.id.rb_new_baohucailiao_sesg)
//    RadioButton rbNewBaohucailiaoSesg;
//    @Bind(R.id.rb_new_baohucailiao_jwsg)
//    RadioButton rbNewBaohucailiaoJwsg;
//    @Bind(R.id.rb_new_baohucailiao_wbt)
//    RadioButton rbNewBaohucailiaoWbt;
//    @Bind(R.id.rb_new_baohucailiao_cgb)
//    RadioButton rbNewBaohucailiaoCgb;
//    @Bind(R.id.rb_new_baohucailiao_wd)
//    RadioButton rbNewBaohucailiaoWd;
//    @Bind(R.id.rg_new_baohucailiao)
//    com.rxjy.des.widget.RadioGroup rgNewBaohucailiao;
//    @Bind(R.id.rb_new_diantishiyong_mf)
//    RadioButton rbNewDiantishiyongMf;
//    @Bind(R.id.rb_new_diantishiyong_sf)
//    RadioButton rbNewDiantishiyongSf;
//    @Bind(R.id.rb_new_diantishiyong_jy)
//    RadioButton rbNewDiantishiyongJy;
//    @Bind(R.id.rg_new_diantishiyong)
//    RadioGroup rgNewDiantishiyong;

    @Bind(R.id.tgv_protectmaterial)
    TextGridview tgv_protectmaterial;
    @Bind(R.id.tgv_elevatoruse)
    TextGridview tgv_elevatoruse;
    @Bind(R.id.tgv_constructiontime)
    TextGridview tgv_constructiontime;
    @Bind(R.id.tgv_publicareaprotect)
    TextGridview tgv_publicareaprotect;
    @Bind(R.id.tgv_propertyinsurance)
    TextGridview tgv_propertyinsurance;
    @Bind(R.id.tgv_firecompany)
    TextGridview tgv_firecompany;
    @Bind(R.id.tgv_aircoldcompany)
    TextGridview tgv_aircoldcompany;
    @Bind(R.id.tgv_garbagetranscompany)
    TextGridview tgv_garbagetranscompany;
    @Bind(R.id.tgv_blueprint)
    TextGridview tgv_blueprint;
    @Bind(R.id.tgv_aircoldfixunit)
    TextGridview tgv_aircoldfixunit;
    @Bind(R.id.tgv_qualification)
    TextGridview tgv_qualification;
    @Bind(R.id.tgv_drawingreview)
    TextGridview tgv_drawingreview;


    //客户信息
//    private AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;
    private AllClientNewBean.ClientNewBean clientInfo;

    private String shigongshijian;
    private String gonggongquyubaohu;
    private String wuyegongcheng;
    private String zhidingxiaofang;
    private String zhidingkongtiao;
    private String zhidinglajiwaiyun;
    private String baoshenlantu;
    private String diantishiyong;
    private String baohucailiao;
    private String wuyeshigongyaoqiu;
    private String propertyperson;//物业负责人
    private String twofixperson;//二装经理
    private String aircoldfixunit;//空调消防维保单位
    private String qualification;//资质要求
    private String drawingreview;//图纸审核


    int itemmoney=10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

//    public void setClientInfo(AllClientInfo.ClientTypeInfo.ClientInfo info) {
//        clientInfo = info;
//    }
    public void setClientInfo(AllClientNewBean.ClientNewBean info) {
        clientInfo = info;
    }

    /**
     * 获取到的量房信息
     */
    private DesDaiMeasureABean.BodyBean lhousedata;//量房详情信息
    public void setLHouseData(DesDaiMeasureABean.BodyBean bean) {
        lhousedata=bean;
        Log.e("获取到。。获取到的量房信息","并显示");
    }

    private void ShowView(DesDaiMeasureABean.BodyBean info){
        moneynum = activity.moneynum;
        if(!StringUtils.isEmpty(info.getCa_SpecialRequirement())){
            wuyeshigongyaoqium=1;
            etNewWuyeshigongyaoqiu.setText(info.getCa_SpecialRequirement());
        }

        if(!StringUtils.isEmpty(info.getCa_ProtectiveMaterial())){
            protectmaterialm=1;
            for (int i = 0; i < projectmateriallist.size(); i++) {
                if(projectmateriallist.get(i).equals(info.getCa_ProtectiveMaterial())){
                    tgv_protectmaterial.setContents(info.getCa_ProtectiveMaterial(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_Elevator())){
            elevatorusem=1;
            for (int i = 0; i < elevatoruselist.size(); i++) {
                if(elevatoruselist.get(i).equals(info.getCa_Elevator())){
                    tgv_elevatoruse.setContents(info.getCa_Elevator(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_ReqConTime())){
            constructiontimem=1;
            for (int i = 0; i < constructiontimelist.size(); i++) {
                if(constructiontimelist.get(i).equals(info.getCa_ReqConTime())){
                    tgv_constructiontime.setContents(info.getCa_ReqConTime(), i);
                    break;
                }
            }
        }


        if(!StringUtils.isEmpty(info.getCa_ProductProtection())){
            publicareaprotectm=1;
            for (int i = 0; i < yesnolist.size(); i++) {
                if(yesnolist.get(i).equals(info.getCa_ProductProtection())){
                    tgv_publicareaprotect.setContents(info.getCa_ProductProtection(), i);
                    break;
                }
            }
        }


        if(!StringUtils.isEmpty(info.getCa_PropertyInsurance())){
            propertyinsurancem=1;
            for (int i = 0; i < yesnolist.size(); i++) {
                if(yesnolist.get(i).equals(info.getCa_PropertyInsurance())){
                    tgv_propertyinsurance.setContents(info.getCa_PropertyInsurance(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_DesignatedFireCompany())){
            firecompanym=1;
            switch (info.getCa_DesignatedFireCompany()) {
                case "1":
                    tgv_firecompany.setContents("是", 0);
                    break;
                case "2":
                    tgv_firecompany.setContents("否", 1);
                    break;
            }
        }

        if(!StringUtils.isEmpty(info.getCa_DesignatedAirCompany())){
            aircoldcompanym=1;
            switch (info.getCa_DesignatedAirCompany()) {
                case "1":
                    tgv_aircoldcompany.setContents("是", 0);
                    break;
                case "2":
                    tgv_aircoldcompany.setContents("否", 1);
                    break;
            }
        }


        if(!StringUtils.isEmpty(info.getCa_DesignatedSinotrans())){
            garbagetranscompanym=1;
            switch (info.getCa_DesignatedSinotrans()) {
                case "1":
                    tgv_garbagetranscompany.setContents("是", 0);
                    break;
                case "2":
                    tgv_garbagetranscompany.setContents("否", 1);
                    break;
            }
        }


        if(!StringUtils.isEmpty(info.getCa_Blueprint())){
            blueprintm=1;
            for (int i = 0; i < blueprintlist.size(); i++) {
                if(blueprintlist.get(i).equals(info.getCa_Blueprint())){
                    tgv_blueprint.setContents(info.getCa_Blueprint(), i);
                    break;
                }
            }
        }


        if(info.getCa_LeadName()!=null&&info.getCa_LeadName().length()>0){
            propertypersonm=1;
            et_new_propertyperson.setText(info.getCa_LeadName());
        }
        if(info.getCa_TwoManagerTel()!=null&&info.getCa_TwoManagerTel().length()>0){
            twofixpersonm=1;
            et_new_twofixperson.setText(info.getCa_TwoManagerTel());
        }

        if(!StringUtils.isEmpty(info.getCa_Maintenance())){
            aircoldfixunitm=1;
            for (int i = 0; i < ishaslist.size(); i++) {
                if(ishaslist.get(i).equals(info.getCa_Maintenance())){
                    tgv_aircoldfixunit.setContents(info.getCa_Maintenance(), i);
                    break;
                }
            }
        }


        if(!StringUtils.isEmpty(info.getCa_Aptitude())){
            qualificationm=1;
            for (int i = 0; i < qualificationlist.size(); i++) {
                if(qualificationlist.get(i).equals(info.getCa_Aptitude())){
                    tgv_qualification.setContents(info.getCa_Aptitude(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_DrawAudit())){
            drawingreviewm=1;
            for (int i = 0; i < ishaslist.size(); i++) {
                if(ishaslist.get(i).equals(info.getCa_DrawAudit())){
                    tgv_drawingreview.setContents(info.getCa_DrawAudit(), i);
                    break;
                }
            }
        }

    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_four;
    }

    DesDaiMeasureActivity activity;
    @Override
    protected void FragmentInitData() {

//        itemmoney=clientInfo.getJDMoney()/94;
        Log.e("单项数据的钱",itemmoney+"");
        activity = (DesDaiMeasureActivity) getActivity();

        initAddData();
        btnDesDaiMeasureSub.setOnClickListener(this);


        etNewWuyeshigongyaoqiu.addTextChangedListener(new MyEditListener(etNewWuyeshigongyaoqiu));
        et_new_propertyperson.addTextChangedListener(new MyEditListener(et_new_propertyperson));
        et_new_twofixperson.addTextChangedListener(new MyEditListener(et_new_twofixperson));

//        rgNewBaoshenlantu.setOnCheckedChangeListener(this);
//        rgNewGonggongquyubaohu.setOnCheckedChangeListener(this);
//        rgNewShigongshijian.setOnCheckedChangeListener(this);
//        rgNewWuyegongcheng.setOnCheckedChangeListener(this);
//        rgNewZhidingxiaofang.setOnCheckedChangeListener(this);
//        rgNewZhidingkongtiao.setOnCheckedChangeListener(this);
//        rgNewZhidinglajiwaiyun.setOnCheckedChangeListener(this);
//        rgNewBaohucailiao.setOnCheckedChangeListener(this);
//        rgNewDiantishiyong.setOnCheckedChangeListener(this);
    }


    /**
     * 要添加的数据的赋值
     */
    private List<String> projectmateriallist;//保护材料
    private List<String> elevatoruselist;//电梯使用情况
    private List<String> constructiontimelist;//施工时间
    private List<String> yesnolist;//公共区域保护，物业保险保额，指定消防、空调、垃圾外运公司
    private List<String> blueprintlist;//报审蓝图
    private List<String> ishaslist;//空调消防维保单位、图纸审核
    private List<String> qualificationlist;//资质要求
    private void initAddData(){
        projectmateriallist=new ArrayList<>();
        projectmateriallist.add("15mm细木工板");
        projectmateriallist.add("18mm细木工板");
        projectmateriallist.add("12mm石膏板");
        projectmateriallist.add("9.5mm石膏板");
        projectmateriallist.add("彩布条");
        projectmateriallist.add("彩钢板");
        projectmateriallist.add("围挡外围宣传喷绘");
        projectmateriallist.add("其他");

        elevatoruselist=new ArrayList<>();
        elevatoruselist.add("免费");
        elevatoruselist.add("收费");
        elevatoruselist.add("禁用");

        constructiontimelist=new ArrayList<>();
        constructiontimelist.add("白天");
        constructiontimelist.add("晚上");
        constructiontimelist.add("均可");

        yesnolist = new ArrayList<>();
        yesnolist.add("是");
        yesnolist.add("否");

        blueprintlist=new ArrayList<>();
        blueprintlist.add("蓝图");
        blueprintlist.add("白图");

        ishaslist=new ArrayList<>();
        ishaslist.add("有");
        ishaslist.add("无");

        qualificationlist=new ArrayList<>();
        qualificationlist.add("一级");
        qualificationlist.add("二级");
        qualificationlist.add("无");

        initShow();
    }

    /**
     * 展示添加的数据
     */
    int protectmaterialm,elevatorusem,constructiontimem,publicareaprotectm,propertyinsurancem,firecompanym,
            aircoldcompanym,garbagetranscompanym,blueprintm,aircoldfixunitm,qualificationm,drawingreviewm;
    private void initShow(){
        tgv_protectmaterial.setTvType("保护材料");
        tgv_protectmaterial.setGvLines(4);
        tgv_protectmaterial.setGvData(getActivity(), projectmateriallist);
        tgv_protectmaterial.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(protectmaterialm!=1){
                    protectmaterialm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_ProtectiveMaterial(projectmateriallist.get(position));
            }
        });

        tgv_elevatoruse.setTvType("电梯使用情况");
        tgv_elevatoruse.setGvLines(4);
        tgv_elevatoruse.setGvData(getActivity(), elevatoruselist);
        tgv_elevatoruse.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(elevatorusem!=1){
                    elevatorusem=1;
                    addMoney();
                }
                activity.savedatabean.setCa_Elevator(elevatoruselist.get(position));
            }
        });

        tgv_constructiontime.setTvType("施工时间");
        tgv_constructiontime.setGvLines(4);
        tgv_constructiontime.setGvData(getActivity(), constructiontimelist);
        tgv_constructiontime.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(constructiontimem!=1){
                    constructiontimem=1;
                    addMoney();
                }
                activity.savedatabean.setCa_ReqConTime(constructiontimelist.get(position));
            }
        });

        tgv_publicareaprotect.setTvType("公共区域保护");
        tgv_publicareaprotect.setGvLines(4);
        tgv_publicareaprotect.setGvData(getActivity(), yesnolist);
        tgv_publicareaprotect.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(publicareaprotectm!=1){
                    publicareaprotectm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_ProductProtection(yesnolist.get(position));
            }
        });

        tgv_propertyinsurance.setTvType("工程一切险要求");
        tgv_propertyinsurance.setGvLines(4);
        tgv_propertyinsurance.setGvData(getActivity(), yesnolist);
        tgv_propertyinsurance.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(propertyinsurancem!=1){
                    propertyinsurancem=1;
                    addMoney();
                }
                activity.savedatabean.setCa_PropertyInsurance(yesnolist.get(position));
            }
        });

        tgv_firecompany.setTvType("指定消防公司");
        tgv_firecompany.setGvLines(4);
        tgv_firecompany.setGvData(getActivity(), yesnolist);
        tgv_firecompany.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(firecompanym!=1){
                    firecompanym=1;
                    addMoney();
                }
                switch (position){
                    case 0:
                        activity.savedatabean.setCa_DesignatedFireCompany("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_DesignatedFireCompany("2");
                        break;
                }
            }
        });

        tgv_aircoldcompany.setTvType("指定空调公司");
        tgv_aircoldcompany.setGvLines(4);
        tgv_aircoldcompany.setGvData(getActivity(), yesnolist);
        tgv_aircoldcompany.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(aircoldcompanym!=1){
                    aircoldcompanym=1;
                    addMoney();
                }
                switch (position){
                    case 0:
                        activity.savedatabean.setCa_DesignatedAirCompany("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_DesignatedAirCompany("2");
                        break;
                }
            }
        });

        tgv_garbagetranscompany.setTvType("指定垃圾外运公司");
        tgv_garbagetranscompany.setGvLines(4);
        tgv_garbagetranscompany.setGvData(getActivity(), yesnolist);
        tgv_garbagetranscompany.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(garbagetranscompanym!=1){
                    garbagetranscompanym=1;
                    addMoney();
                }
                switch (position){
                    case 0:
                        activity.savedatabean.setCa_DesignatedSinotrans("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_DesignatedSinotrans("2");
                        break;
                }
            }
        });

        tgv_blueprint.setTvType("报审蓝图");
        tgv_blueprint.setGvLines(4);
        tgv_blueprint.setGvData(getActivity(), blueprintlist);
        tgv_blueprint.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(blueprintm!=1){
                    blueprintm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_Blueprint(blueprintlist.get(position));
            }
        });

        tgv_aircoldfixunit.setTvType("空调消防维保单位");
        tgv_aircoldfixunit.setGvLines(4);
        tgv_aircoldfixunit.setGvData(getActivity(), ishaslist);
        tgv_aircoldfixunit.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(aircoldfixunitm!=1){
                    aircoldfixunitm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_Maintenance(ishaslist.get(position));
            }
        });

        tgv_qualification.setTvType("资质要求");
        tgv_qualification.setGvLines(4);
        tgv_qualification.setGvData(getActivity(), qualificationlist);
        tgv_qualification.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(qualificationm!=1){
                    qualificationm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_Aptitude(qualificationlist.get(position));
            }
        });

        tgv_drawingreview.setTvType("图纸审核");
        tgv_drawingreview.setGvLines(4);
        tgv_drawingreview.setGvData(getActivity(), ishaslist);
        tgv_drawingreview.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(drawingreviewm!=1){
                    drawingreviewm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_DrawAudit(ishaslist.get(position));
            }
        });

//        mPresenter.GetNewFour(clientInfo.getCi_rwdid());

        ShowView(lhousedata);
    }



    @Override
    protected NewFourPresenter onCreatePresenter() {
        return new NewFourPresenter(this);
    }


    NewFourInfo.BodyBean bodyInfo;

    @Override
    public void responseGetNewFour(NewFourInfo.BodyBean info) {

        bodyInfo = info;

        etNewWuyeshigongyaoqiu.setText(info.getCa_SpecialRequirements());

        for (int i = 0; i < projectmateriallist.size(); i++) {
            if(projectmateriallist.get(i).equals(info.getCa_ProtectiveMaterial())){
                tgv_protectmaterial.setContents(info.getCa_ProtectiveMaterial(), i);
                break;
            }
        }

        for (int i = 0; i < elevatoruselist.size(); i++) {
            if(elevatoruselist.get(i).equals(info.getCa_Elevator())){
                tgv_elevatoruse.setContents(info.getCa_Elevator(), i);
                break;
            }
        }

        for (int i = 0; i < constructiontimelist.size(); i++) {
            if(constructiontimelist.get(i).equals(info.getCa_ReqConTime())){
                tgv_constructiontime.setContents(info.getCa_ReqConTime(), i);
                break;
            }
        }

        for (int i = 0; i < yesnolist.size(); i++) {
            if(yesnolist.get(i).equals(info.getCa_ProductProtection())){
                tgv_publicareaprotect.setContents(info.getCa_ProductProtection(), i);
                break;
            }
        }

        for (int i = 0; i < yesnolist.size(); i++) {
            if(yesnolist.get(i).equals(info.getCa_PropertyInsurance())){
                tgv_propertyinsurance.setContents(info.getCa_PropertyInsurance(), i);
                break;
            }
        }

        switch (info.getCa_DesignatedFireCompany()) {
            case "1":
                tgv_firecompany.setContents("是", 0);
                break;
            case "2":
                tgv_firecompany.setContents("否", 1);
                break;
        }

        switch (info.getCa_DesignatedAirCompany()) {
            case "1":
                tgv_aircoldcompany.setContents("是", 0);
                break;
            case "2":
                tgv_aircoldcompany.setContents("否", 1);
                break;
        }

        switch (info.getCa_DesignatedSinotrans()) {
            case "1":
                tgv_garbagetranscompany.setContents("是", 0);
                break;
            case "2":
                tgv_garbagetranscompany.setContents("否", 1);
                break;
        }

        for (int i = 0; i < blueprintlist.size(); i++) {
            if(blueprintlist.get(i).equals(info.getCa_Blueprint())){
                tgv_blueprint.setContents(info.getCa_Blueprint(), i);
                break;
            }
        }

        if(info.getCa_LeadName()!=null&&info.getCa_LeadName().length()>0){
            et_new_propertyperson.setText(info.getCa_LeadName());
        }
        if(info.getCa_TwoManagerTel()!=null&&info.getCa_TwoManagerTel().length()>0){
            et_new_twofixperson.setText(info.getCa_TwoManagerTel());
        }

        for (int i = 0; i < ishaslist.size(); i++) {
            if(ishaslist.get(i).equals(info.getCa_Maintenance())){
                tgv_aircoldfixunit.setContents(info.getCa_Maintenance(), i);
                break;
            }
        }

        for (int i = 0; i < qualificationlist.size(); i++) {
            if(qualificationlist.get(i).equals(info.getCa_Aptitude())){
                tgv_qualification.setContents(info.getCa_Aptitude(), i);
                break;
            }
        }

        for (int i = 0; i < ishaslist.size(); i++) {
            if(ishaslist.get(i).equals(info.getCa_DrawAudit())){
                tgv_drawingreview.setContents(info.getCa_DrawAudit(), i);
                break;
            }
        }

//        switch (info.getCa_ReqConTime()) {
//            case "白天":
//                rbNewShigongshijianBaitian.setChecked(true);
//                break;
//            case "晚上":
//                rbNewShigongshijianWanshang.setChecked(true);
//                break;
//            case "均可":
//                rbNewShigongshijianJunke.setChecked(true);
//                break;
//        }
//        switch (info.getCa_ProductProtection()) {
//            case "是":
//                rbNewGonggongquyubaohuShi.setChecked(true);
//                break;
//            case "否":
//                rbNewGonggongquyubaohuFou.setChecked(true);
//                break;
//        }
//        switch (info.getCa_PropertyInsurance()) {
//            case "是":
//                rbNewWuyegongchengShi.setChecked(true);
//                break;
//            case "否":
//                rbNewWuyegongchengFou.setChecked(true);
//                break;
//        }
//        switch (info.getCa_DesignatedFireCompany()) {
//            case "1":
//                rbNewZhidingxiaofangShi.setChecked(true);
//                break;
//            case "2":
//                rbNewZhidingxiaofangFou.setChecked(true);
//                break;
//        }
//        switch (info.getCa_DesignatedAirCompany()) {
//            case "1":
//                rbNewZhidingkongtiaoShi.setChecked(true);
//                break;
//            case "2":
//                rbNewZhidingkongtiaoFou.setChecked(true);
//                break;
//        }
//        switch (info.getCa_DesignatedSinotrans()) {
//            case "1":
//                rbNewZhidinglajiwaiyunShi.setChecked(true);
//                break;
//            case "2":
//                rbNewZhidinglajiwaiyunFou.setChecked(true);
//                break;
//        }
//        switch (info.getCa_Blueprint()) {
//            case "蓝图":
//                rbNewBaoshenlantuShi.setChecked(true);
//                break;
//            case "白图":
//                rbNewBaoshenlantuFou.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_ProtectiveMaterial()){
//            case "15mm细木工板":
//                rbNewBaohucailiaoSwxm.setChecked(true);
//                break;
//            case "18mm细木工板":
//                rbNewBaohucailiaoSbxm.setChecked(true);
//                break;
//            case "12mm石膏板":
//                rbNewBaohucailiaoSesg.setChecked(true);
//                break;
//            case "9.5mm石膏板":
//                rbNewBaohucailiaoJwsg.setChecked(true);
//                break;
//            case "彩布条":
//                rbNewBaohucailiaoWbt.setChecked(true);
//                break;
//            case "彩钢板":
//                rbNewBaohucailiaoCgb.setChecked(true);
//                break;
//            case "围挡外围宣传喷绘":
//                rbNewBaohucailiaoWd.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_Elevator()){
//            case "免费":
//               rbNewDiantishiyongMf.setChecked(true);
//                break;
//            case "收费":
//                rbNewDiantishiyongSf.setChecked(true);
//                break;
//            case "禁用":
//                rbNewDiantishiyongJy.setChecked(true);
//                break;
//        }

    }

    @Override
    public void responseGetNewFourError(String msg) {
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_des_dai_measure_sub:

                wuyeshigongyaoqiu = etNewWuyeshigongyaoqiu.getText().toString().trim();
                bodyInfo.setCa_SpecialRequirements(wuyeshigongyaoqiu);

                shigongshijian=tgv_constructiontime.getSelectcontent();
                bodyInfo.setCa_ReqConTime(shigongshijian);
                gonggongquyubaohu=tgv_publicareaprotect.getSelectcontent();
                bodyInfo.setCa_ProductProtection(gonggongquyubaohu);
                wuyegongcheng=tgv_propertyinsurance.getSelectcontent();
                bodyInfo.setCa_PropertyInsurance(wuyegongcheng);
                String firecompany=tgv_firecompany.getSelectcontent();
                switch (firecompany){
                    case "是":
                        zhidingxiaofang="1";
                        break;
                    case "否":
                        zhidingxiaofang="2";
                        break;
                }
                bodyInfo.setCa_DesignatedFireCompany(zhidingxiaofang);
                String aircoldcompany=tgv_aircoldcompany.getSelectcontent();
                switch (aircoldcompany){
                    case "是":
                        zhidingkongtiao="1";
                        break;
                    case "否":
                        zhidingkongtiao="2";
                        break;
                }
                bodyInfo.setCa_DesignatedAirCompany(zhidingkongtiao);
                String garbagetranscompany=tgv_garbagetranscompany.getSelectcontent();
                switch (garbagetranscompany){
                    case "是":
                        zhidinglajiwaiyun="1";
                        break;
                    case "否":
                        zhidinglajiwaiyun="2";
                        break;
                }
                bodyInfo.setCa_DesignatedSinotrans(zhidinglajiwaiyun);
                baoshenlantu=tgv_blueprint.getSelectcontent();
                bodyInfo.setCa_Blueprint(baoshenlantu);
                baohucailiao=tgv_protectmaterial.getSelectcontent();
                bodyInfo.setCa_ProtectiveMaterial(baohucailiao);
                diantishiyong=tgv_elevatoruse.getSelectcontent();
                bodyInfo.setCa_Elevator(diantishiyong);

                propertyperson=et_new_propertyperson.getText().toString();
                bodyInfo.setCa_LeadName(propertyperson);
                twofixperson=et_new_twofixperson.getText().toString();
                bodyInfo.setCa_TwoManagerTel(twofixperson);
                aircoldfixunit=tgv_aircoldfixunit.getSelectcontent();
                bodyInfo.setCa_Maintenance(aircoldfixunit);
                qualification=tgv_qualification.getSelectcontent();
                bodyInfo.setCa_Aptitude(qualification);
                drawingreview=tgv_drawingreview.getSelectcontent();
                bodyInfo.setCa_DrawAudit(drawingreview);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info = JSONUtils.toString(bodyInfo);
                        Log.e("newfour", info);
//                        mPresenter.UpXinxi(clientInfo.getCi_rwdid(), info, "物业");
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(), info, "物业");
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
        }

    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int i) {
//        switch (i) {
//            case R.id.rb_new_shigongshijian_baitian:
//                shigongshijian = "白天";
//                break;
//            case R.id.rb_new_shigongshijian_wanshang:
//                shigongshijian = "晚上";
//                break;
//            case R.id.rb_new_shigongshijian_junke:
//                shigongshijian = "均可";
//                break;
//            case R.id.rb_new_gonggongquyubaohu_shi:
//                gonggongquyubaohu = "是";
//                break;
//            case R.id.rb_new_gonggongquyubaohu_fou:
//                gonggongquyubaohu = "否";
//                break;
//            case R.id.rb_new_wuyegongcheng_shi:
//                wuyegongcheng = "是";
//                break;
//            case R.id.rb_new_wuyegongcheng_fou:
//                wuyegongcheng = "否";
//                break;
//            case R.id.rb_new_zhidingxiaofang_shi:
//                zhidingxiaofang = "1";
//                break;
//            case R.id.rb_new_zhidingxiaofang_fou:
//                zhidingxiaofang = "2";
//                break;
//            case R.id.rb_new_zhidingkongtiao_shi:
//                zhidingkongtiao = "1";
//                break;
//            case R.id.rb_new_zhidingkongtiao_fou:
//                zhidingkongtiao = "2";
//                break;
//            case R.id.rb_new_zhidinglajiwaiyun_shi:
//                zhidinglajiwaiyun = "1";
//                break;
//            case R.id.rb_new_zhidinglajiwaiyun_fou:
//                zhidinglajiwaiyun = "2";
//                break;
//            case R.id.rb_new_baoshenlantu_shi:
//                baoshenlantu = "蓝图";
//                break;
//            case R.id.rb_new_baoshenlantu_fou:
//                baoshenlantu = "白图";
//                break;
//            case R.id.rb_new_diantishiyong_mf:
//                diantishiyong = "免费";
//                break;
//            case R.id.rb_new_diantishiyong_sf:
//                diantishiyong = "收费";
//                break;
//            case R.id.rb_new_diantishiyong_jy:
//                diantishiyong = "禁用";
//                break;
//        }
//    }

    @Override
    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
        showToast(upNewXinXi.getStatusMsg());
    }

    @Override
    public void responseUpNewOneError(String msg) {
        showToast(msg);
    }

//    //zidingyi
//    @Override
//    public void onCheckedChanged(com.rxjy.des.widget.RadioGroup group, int checkedId) {
//
//        switch (checkedId){
//            case R.id.rb_new_baohucailiao_swxm:
//                baohucailiao="15mm细木工板";
//                break;
//            case R.id.rb_new_baohucailiao_sbxm:
//                baohucailiao="18mm细木工板";
//                break;
//            case R.id.rb_new_baohucailiao_sesg:
//                baohucailiao="12mm石膏板";
//                break;
//            case R.id.rb_new_baohucailiao_jwsg:
//                baohucailiao="9.5mm石膏板";
//                break;
//            case R.id.rb_new_baohucailiao_wbt:
//                baohucailiao="彩布条";
//                break;
//            case R.id.rb_new_baohucailiao_cgb:
//                baohucailiao="彩钢板";
//                break;
//            case R.id.rb_new_baohucailiao_wd:
//                baohucailiao="围挡外围宣传喷绘";
//                break;
//        }
//    }


    private String wuyeneed="",wuyeperson="",personphone="";
    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }

        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub
            int lengths = arg0.length();
            switch (edittext.getId()) {
                case R.id.et_new_wuyeshigongyaoqiu:
                    editchanges(lengths,0);
                    if(lengths>0){
                        wuyeneed=edittext.getText().toString().trim();
                    }else{
                        wuyeneed="";
                    }
                    activity.savedatabean.setCa_SpecialRequirement(wuyeneed);
                    break;
                case R.id.et_new_propertyperson:
                    editchanges(lengths,1);
                    if(lengths>0){
                        wuyeperson=edittext.getText().toString().trim();
                    }else{
                        wuyeperson="";
                    }
                    activity.savedatabean.setCa_LeadName(wuyeperson);
                    break;
                case R.id.et_new_twofixperson:
                    editchanges(lengths,3);
                    if(lengths>0){
                        personphone=edittext.getText().toString().trim();
                    }else{
                        personphone="";
                    }
                    activity.savedatabean.setCa_TwoManagerTel(personphone);
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
            // TODO Auto-generated method stub
        }
    }

    int wuyeshigongyaoqium,propertypersonm,twofixpersonm;

    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length,int type){
        Log.e("length"+length,"type"+type);
        if(length>0){
            switch (type){
                case 0:
                    if(wuyeshigongyaoqium!=1){
                        wuyeshigongyaoqium=1;
                        addMoney();
                    }
                    break;
                case 1:
                    if(propertypersonm!=1){
                        propertypersonm=1;
                        addMoney();
                    }
                    break;
                case 2:
                    if(twofixpersonm!=1){
                        twofixpersonm=1;
                        addMoney();
                    }
                    break;
            }
        }else{
            switch (type){
                case 0:
                    wuyeshigongyaoqium=0;
                    noaddMoney();
                    break;
                case 1:
                    propertypersonm=0;
                    noaddMoney();
                    break;
                case 2:
                    twofixpersonm=0;
                    noaddMoney();
                    break;
            }
        }
    }



    //显示金额（金额=总金额/96*个数 ）
    double allmoney;
    BigDecimal bigDecimal;
    double showmoney;
    int moneynum;//当前金额对应的个数
    private void addMoney() {
        moneynum = moneynum + 1;
        Log.e("个数；", moneynum + "");
        Log.e("金额是+；", lhousedata.getJDMoney() + "");
        allmoney = Double.parseDouble(lhousedata.getJDMoney());
        showmoney=allmoney / LF_NUM * moneynum;
        bigDecimal=new BigDecimal(showmoney);
        showmoney=bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
        activity.setMoneynum(moneynum);
    }

    private void noaddMoney() {
        moneynum = moneynum - 1;
        Log.e("个数；", moneynum + "");
        allmoney = Double.parseDouble(lhousedata.getJDMoney());
        showmoney=allmoney / LF_NUM * moneynum;
        bigDecimal=new BigDecimal(showmoney);
        showmoney=bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
        activity.setMoneynum(moneynum);
    }


}
