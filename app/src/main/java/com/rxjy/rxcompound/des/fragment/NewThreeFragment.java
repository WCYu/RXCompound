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
import com.rxjy.rxcompound.des.entity.NewThreeInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewThreeContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewThreePresenter;
import com.rxjy.rxcompound.widget.TextGridview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.DatePicker;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;

public class NewThreeFragment extends BaseFragment<NewThreePresenter> implements NewThreeContract.View, View.OnClickListener {

    @Bind(R.id.et_new_zhuangxiuyusuan)
    EditText etNewZhuangxiuyusuan;
    @Bind(R.id.et_new_gongqi)
    EditText etNewGongqi;
    @Bind(R.id.tv_measure_tenancy_term_start_time)
    TextView tvNewYujizhuangxiushijianStart;
    @Bind(R.id.et_new_liangfangdizhi)
    EditText etNewLiangfangdizhi;
    @Bind(R.id.et_new_kongjianxuqiu)
    EditText etNewKongjianxuqiu;
    @Bind(R.id.tv_measure_tenancy_term_time_line)
    TextView tvMeasureTenancyTermTimeLine;
    @Bind(R.id.tv_measure_tenancy_term_end_time)
    TextView tvNewYujizhuangxiushijianEnd;

    //    @Bind(R.id.et_new_shangwubeizhu)
//    EditText etNewShangwubeizhu;....商务备注
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;

    @Bind(R.id.tgv_projectattribute)
    TextGridview tgv_projectattribute;
    @Bind(R.id.tgv_demandstyle)
    TextGridview tgv_demandstyle;
    @Bind(R.id.tgv_zhaobiao)
    TextGridview tgv_zhaobiao;
    @Bind(R.id.tgv_fengshui)
    TextGridview tgv_fengshui;
    @Bind(R.id.tgv_soft)
    TextGridview tgv_soft;
    @Bind(R.id.tgv_intelligentweak)
    TextGridview tgv_intelligentweak;
    @Bind(R.id.tgv_padmoney)
    TextGridview tgv_padmoney;

    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;

    //风格意向
    private String caIntentionalStyle = "";
    //家具软装
    private String caSoftFurniture = "";
    //智能弱电
    private String caIntelligentWeakCurrent = "";
    //风水要求
    private String caFengshuiRequirements = "";
    //项目属性
    private String xiangmushuxing;

    private String zhaobiao;


    private String zhuangxiuyusuan;
    private String gongqi;
    private String yujizhuangxiushijian;
    private String liangfangdizhi;
    private String kongjianxuqiu;
    private String shangwubeizhu;


    int itemmoney = 10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、


    //客户信息
//    private AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;
    private AllClientNewBean.ClientNewBean clientInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_three;
    }

    DesDaiMeasureActivity activity;

    @Override
    protected void FragmentInitData() {

        //        itemmoney=clientInfo.getJDMoney()/94;
        Log.e("单项数据的钱", itemmoney + "");
        activity = (DesDaiMeasureActivity) getActivity();

        btnDesDaiMeasureSub.setOnClickListener(this);
        tvNewYujizhuangxiushijianEnd.setOnClickListener(this);
        tvNewYujizhuangxiushijianStart.setOnClickListener(this);

        etNewZhuangxiuyusuan.addTextChangedListener(new MyEditListener(etNewZhuangxiuyusuan));
        etNewGongqi.addTextChangedListener(new MyEditListener(etNewGongqi));
        etNewLiangfangdizhi.addTextChangedListener(new MyEditListener(etNewLiangfangdizhi));
        etNewKongjianxuqiu.addTextChangedListener(new MyEditListener(etNewKongjianxuqiu));


//        rgDemandCaFenshuiRequirements.setOnCheckedChangeListener(this);
//        rgDemandCaIntelligentWeakCurrent.setOnCheckedChangeListener(this);
//        rgDemandCaIntentionalStyle.setOnCheckedChangeListener(this);
//        rgDemandCaSoftFurniture.setOnCheckedChangeListener(this);
//        rgNewXiangmushuxing.setOnCheckedChangeListener(this);
//        rgNewZhaobiao.setOnCheckedChangeListener(this);

        initAddData();
//        mPresenter.GetNewThree(clientInfo.getCi_rwdid());
    }

    /**
     * 要添加的数据的赋值
     */
    private List<String> projectattribute;//项目属性
    private List<String> demandstyle;//意向风格
    private List<String> yesnolist;//招标、风水要求、家具软装、只能弱电

    private void initAddData() {
        projectattribute = new ArrayList<>();
        projectattribute.add("正常单");//1
        projectattribute.add("看图报价单");//2
        projectattribute.add("设计单");//3
        projectattribute.add("家具单");//6
        projectattribute.add("弱电单");//7
        projectattribute.add("局部改造");//8

        demandstyle = new ArrayList<>();
        demandstyle.add("现代简约");
        demandstyle.add("简欧风格");
        demandstyle.add("新中式");
        demandstyle.add("LOFT");
        demandstyle.add("其他");

        yesnolist = new ArrayList<>();
        yesnolist.add("是");
        yesnolist.add("否");

        initShow();
    }

    /**
     * 展示添加装修需求的源数据
     */
    int projectattributem, demandstylem, zhaobiaom, fengshuim, softm, intelligentweakm, advancePayment;

    private void initShow() {
        tgv_projectattribute.setTvType("项目属性");
        tgv_projectattribute.setGvLines(4);
        tgv_projectattribute.setGvData(getActivity(), projectattribute);
        tgv_projectattribute.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (projectattributem != 1) {
                    projectattributem = 1;
                    addMoney();
                }
                switch (position) {
                    case 0:
                        activity.savedatabean.setCa_proAttribute("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_proAttribute("2");
                        break;
                    case 2:
                        activity.savedatabean.setCa_proAttribute("3");
                        break;
                    case 3:
                        activity.savedatabean.setCa_proAttribute("6");
                        break;
                    case 4:
                        activity.savedatabean.setCa_proAttribute("7");
                        break;
                    case 5:
                        activity.savedatabean.setCa_proAttribute("8");
                        break;
                }
            }
        });

        tgv_demandstyle.setTvType("意向风格");
        tgv_demandstyle.setGvLines(4);
        tgv_demandstyle.setGvData(getActivity(), demandstyle);
        tgv_demandstyle.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (demandstylem != 1) {
                    demandstylem = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_IntentionalStyle(demandstyle.get(position));
            }
        });

        tgv_zhaobiao.setTvType("招标");
        tgv_zhaobiao.setGvLines(4);
        tgv_zhaobiao.setGvData(getActivity(), yesnolist);
        tgv_zhaobiao.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (zhaobiaom != 1) {
                    zhaobiaom = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_InviteTenders(yesnolist.get(position));
            }
        });

        tgv_fengshui.setTvType("风水要求");
        tgv_fengshui.setGvLines(4);
        tgv_fengshui.setGvData(getActivity(), yesnolist);
        tgv_fengshui.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (fengshuim != 1) {
                    fengshuim = 1;
                    addMoney();
                }
                switch (position) {
                    case 0:
                        activity.savedatabean.setCa_FengShuiRequirements("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_FengShuiRequirements("2");
                        break;
                }
            }
        });

        tgv_soft.setTvType("家具软装");
        tgv_soft.setGvLines(4);
        tgv_soft.setGvData(getActivity(), yesnolist);
        tgv_soft.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (softm != 1) {
                    softm = 1;
                    addMoney();
                }
                switch (position) {
                    case 0:
                        activity.savedatabean.setCa_SoftFurniture("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_SoftFurniture("2");
                        break;
                }
            }
        });

        tgv_intelligentweak.setTvType("智能弱电");
        tgv_intelligentweak.setGvLines(4);
        tgv_intelligentweak.setGvData(getActivity(), yesnolist);
        tgv_intelligentweak.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (intelligentweakm != 1) {
                    intelligentweakm = 1;
                    addMoney();
                }
                switch (position) {
                    case 0:
                        activity.savedatabean.setCa_IntelligentWeakCurrent("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_IntelligentWeakCurrent("2");
                        break;
                }
            }
        });
        tgv_padmoney.setTvType("垫资");
        tgv_padmoney.setGvLines(4);
        tgv_padmoney.setGvData(getActivity(), yesnolist);
        tgv_padmoney.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (advancePayment != 1) {
                    advancePayment = 1;
                    addMoney();
                }
                activity.savedatabean.setCi_advancePayment(yesnolist.get(position));
            }
        });

        ShowView(lhousedata);

    }

    //    public void setClientInfo(AllClientInfo.ClientTypeInfo.ClientInfo info) {
//        clientInfo = info;
//    }
    public void setClientInfo(AllClientNewBean.ClientNewBean info) {
        clientInfo = info;
    }


    //量房详情信息
    private DesDaiMeasureABean.BodyBean lhousedata;

    public void setLHouseData(DesDaiMeasureABean.BodyBean bean) {
        lhousedata = bean;

    }


    private void ShowView(DesDaiMeasureABean.BodyBean bean) {
        moneynum = activity.moneynum;

        if (!StringUtils.isEmpty(bean.getCi_DecorationAddress())) {
            liangfangdizhim = 1;
            etNewLiangfangdizhi.setText(bean.getCi_DecorationAddress());
        }
        if (!StringUtils.isEmpty(bean.getCa_DecBudgetPrice())) {
            zhuangxiuyusuanm = 1;
            etNewZhuangxiuyusuan.setText(bean.getCa_DecBudgetPrice());
        }
        if (!StringUtils.isEmpty(bean.getCa_ProjectTime())) {
            gongqim = 1;
            etNewGongqi.setText(bean.getCa_ProjectTime());
        }
        if (!StringUtils.isEmpty(bean.getCa_DecorationDate())) {
            term_start_timem = 1;
            tvNewYujizhuangxiushijianStart.setText(bean.getCa_DecorationDate());
        }
        if (!StringUtils.isEmpty(bean.getCa_SpaceRequirement())) {
            kongjianxuqium = 1;
            etNewKongjianxuqiu.setText(bean.getCa_SpaceRequirement());
        }

//        etNewShangwubeizhu.setText(info.getCa_swRemarks());

        if (bean.getCa_proAttribute() != null && bean.getCa_proAttribute().length() > 0) {
            projectattributem = 1;
            int position = Integer.parseInt(bean.getCa_proAttribute());
//            tgv_projectattribute.setContents(projectattribute.get(position - 1), position - 1);
            switch (position) {
                case 1:
                    tgv_projectattribute.setContents("正常单", 0);
                    break;
                case 2:
                    tgv_projectattribute.setContents("看图报价单", 1);
                    break;
                case 3:
                    tgv_projectattribute.setContents("设计单", 2);
                    break;
                case 6:
                    tgv_projectattribute.setContents("家具单", 3);
                    break;
                case 7:
                    tgv_projectattribute.setContents("弱电单", 4);
                    break;
                case 8:
                    tgv_projectattribute.setContents("局部改造", 5);
                    break;
            }
        }

        if (!StringUtils.isEmpty(bean.getCa_IntentionalStyle())) {
            demandstylem = 1;
            for (int i = 0; i < demandstyle.size(); i++) {
                if (demandstyle.get(i).equals(bean.getCa_IntentionalStyle())) {
                    tgv_demandstyle.setContents(bean.getCa_IntentionalStyle(), i);
                    break;
                }
            }
        }

        //招标
        if (!StringUtils.isEmpty(bean.getCa_InviteTenders())) {
            zhaobiaom = 1;
            for (int i = 0; i < yesnolist.size(); i++) {
                if (yesnolist.get(i).equals(bean.getCa_InviteTenders())) {
                    tgv_zhaobiao.setContents(bean.getCa_InviteTenders(), i);
                    break;
                }
            }
        }


        //家具软装
        if (!StringUtils.isEmpty(bean.getCa_SoftFurniture())) {
            softm = 1;
            switch (bean.getCa_SoftFurniture()) {
                case "1":
                    tgv_soft.setContents("是", 0);
                    break;
                case "2":
                    tgv_soft.setContents("否", 1);
                    break;
            }
        }


        //智能弱电
        if (!StringUtils.isEmpty(bean.getCa_IntelligentWeakCurrent())) {
            intelligentweakm = 1;
            switch (bean.getCa_IntelligentWeakCurrent()) {
                case "1":
                    tgv_intelligentweak.setContents("是", 0);
                    break;
                case "2":
                    tgv_intelligentweak.setContents("否", 1);
                    break;
            }
        }

        //风水要求
        if (!StringUtils.isEmpty(bean.getCa_FengShuiRequirements())) {
            fengshuim = 1;
            switch (bean.getCa_FengShuiRequirements()) {
                case "1":
                    tgv_fengshui.setContents("是", 0);
                    break;
                case "2":
                    tgv_fengshui.setContents("否", 1);
                    break;
            }
        }
        //垫资
        if (!StringUtils.isEmpty(bean.getCi_advancePayment())) {
            advancePayment = 1;
            for (int i = 0; i < yesnolist.size(); i++) {
                if (yesnolist.get(i).equals(bean.getCi_advancePayment())) {
                    tgv_padmoney.setContents(bean.getCi_advancePayment(), i);
                    break;
                }
            }
        }

    }


    @Override
    protected NewThreePresenter onCreatePresenter() {
        return new NewThreePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    NewThreeInfo.BodyBean bodyInfo;

    @Override
    public void responseGetNewThree(NewThreeInfo.BodyBean info) {
        bodyInfo = info;
//        etNewZhuangxiuyusuan.setText(info.getCa_DecBudgetPrice());
//        etNewGongqi.setText(info.getCa_ProjectTime());
//        tvNewYujizhuangxiushijianStart.setText(info.getCa_DecorationDate());
//        etNewLiangfangdizhi.setText(info.getCi_DecorationAddress());
//        etNewKongjianxuqiu.setText(info.getCa_SpaceRequirement());
////        etNewShangwubeizhu.setText(info.getCa_swRemarks());
//
//        if(info.getCa_AuditState()!=null&&info.getCa_AuditState().length()>0){
//            int position = Integer.parseInt(info.getCa_AuditState());
////            tgv_projectattribute.setContents(projectattribute.get(position - 1), position - 1);
//            switch (position){
//                case 1:
//                    tgv_projectattribute.setContents("正常单", 0);
//                    break;
//                case 2:
//                    tgv_projectattribute.setContents("看图报价单", 0);
//                    break;
//                case 3:
//                    tgv_projectattribute.setContents("设计单", 0);
//                    break;
//                case 6:
//                    tgv_projectattribute.setContents("家具单", 0);
//                    break;
//                case 7:
//                    tgv_projectattribute.setContents("弱电单", 0);
//                    break;
//            }
//        }
//
//        for (int i = 0; i < demandstyle.size(); i++) {
//            if(demandstyle.get(i).equals(info.getCa_IntentionalStyle())){
//                tgv_demandstyle.setContents(info.getCa_IntentionalStyle(), i);
//                break;
//            }
//        }
//
//        //招标
//        for (int i = 0; i < yesnolist.size(); i++) {
//            if(yesnolist.get(i).equals(info.getCa_InviteTenders())){
//                tgv_zhaobiao.setContents(info.getCa_InviteTenders(), i);
//                break;
//            }
//        }
//
//        //家具软装
//        switch (info.getCa_SoftFurniture()) {
//            case "1":
//                tgv_soft.setContents("是", 0);
//                break;
//            case "2":
//                tgv_soft.setContents("否", 1);
//                break;
//        }
//
//        //智能弱电
//        switch (info.getCa_IntelligentWeakCurrent()) {
//            case "1":
//                tgv_intelligentweak.setContents("是", 0);
//                break;
//            case "2":
//                tgv_intelligentweak.setContents("否", 1);
//                break;
//        }
//
//        //风水要求
//        switch (info.getCa_FengShuiRequirements()) {
//            case "1":
//                tgv_fengshui.setContents("是", 0);
//                break;
//            case "2":
//                tgv_fengshui.setContents("否", 1);
//                break;
//        }
    }

    @Override
    public void responseGetNewThreeError(String msg) {
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

    private String caLeaseTermStart = "";
    private String caLeaseTermEnd = "";

    int term_start_timem;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_measure_tenancy_term_end_time:
                DatePicker endPicker = new DatePicker(getActivity());
                endPicker.setRange(2017, 2100);//年份范围
                endPicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        caLeaseTermEnd = year + "-" + month + "-" + day;
                        tvNewYujizhuangxiushijianEnd.setText(caLeaseTermEnd);
                    }
                });
                endPicker.show();
                break;
            case R.id.tv_measure_tenancy_term_start_time:
                DatePicker startPicker = new DatePicker(getActivity());
                startPicker.setRange(2017, 2100);//年份范围
                startPicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        caLeaseTermStart = year + "-" + month + "-" + day;
                        tvNewYujizhuangxiushijianStart.setText(caLeaseTermStart);
                        if (term_start_timem != 1) {
                            term_start_timem = 1;
                            addMoney();
                        }
                        activity.savedatabean.setCa_DecorationDate(caLeaseTermStart);
                    }
                });
                startPicker.show();
                break;
            case R.id.btn_des_dai_measure_sub:

                zhuangxiuyusuan = etNewZhuangxiuyusuan.getText().toString().trim().equals("") ? "" : etNewZhuangxiuyusuan.getText().toString().trim();
                bodyInfo.setCa_DecBudgetPrice(zhuangxiuyusuan);
                gongqi = etNewGongqi.getText().toString().trim();
                bodyInfo.setCa_ProjectTime(gongqi);
                yujizhuangxiushijian = tvNewYujizhuangxiushijianStart.getText().toString();
                bodyInfo.setCa_DecorationDate(yujizhuangxiushijian);
                liangfangdizhi = etNewLiangfangdizhi.getText().toString();
                bodyInfo.setCi_DecorationAddress(liangfangdizhi);
                kongjianxuqiu = etNewKongjianxuqiu.getText().toString();
                bodyInfo.setCa_SpaceRequirement(kongjianxuqiu);
//                shangwubeizhu = etNewShangwubeizhu.getText().toString();
                bodyInfo.setCa_swRemarks(shangwubeizhu);

                String projecta = tgv_projectattribute.getSelectcontent();
                if (projecta != null && projecta.length() > 0) {
                    switch (projecta) {
                        case "正常单":
                            xiangmushuxing = "1";
                            break;
                        case "看图报价单":
                            xiangmushuxing = "2";
                            break;
                        case "设计单":
                            xiangmushuxing = "3";
                            break;
                        case "家具单":
                            xiangmushuxing = "6";
                            break;
                        case "弱电单":
                            xiangmushuxing = "7";
                            break;
                        case "局部改造":
                            xiangmushuxing = "8";
                            break;
                    }
                }
//                if(projecta!=null&&projecta.length()>0){
//                    for (int i = 0; i < projectattribute.size(); i++) {
//                        if(projecta.equals(projectattribute.get(i))){
//                            xiangmushuxing=i+1+"";
//                            break;
//                        }
//                    }
//                }


                bodyInfo.setCa_AuditState(xiangmushuxing);
                zhaobiao = tgv_zhaobiao.getSelectcontent();
                bodyInfo.setCa_InviteTenders(zhaobiao);
                caIntentionalStyle = tgv_demandstyle.getSelectcontent();
                bodyInfo.setCa_IntentionalStyle(caIntentionalStyle);
                switch (tgv_fengshui.getSelectcontent()) {
                    case "是":
                        caFengshuiRequirements = "1";
                        break;
                    case "否":
                        caFengshuiRequirements = "2";
                        break;
                }
                bodyInfo.setCa_FengShuiRequirements(caFengshuiRequirements);
                switch (tgv_soft.getSelectcontent()) {
                    case "是":
                        caSoftFurniture = "1";
                        break;
                    case "否":
                        caSoftFurniture = "2";
                        break;
                }
                bodyInfo.setCa_SoftFurniture(caSoftFurniture);
                switch (tgv_intelligentweak.getSelectcontent()) {
                    case "是":
                        caIntelligentWeakCurrent = "1";
                        break;
                    case "否":
                        caIntelligentWeakCurrent = "2";
                        break;
                }
                bodyInfo.setCa_IntelligentWeakCurrent(caIntelligentWeakCurrent);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info = JSONUtils.toString(bodyInfo);
//                        mPresenter.UpXinxi(clientInfo.getCi_rwdid(), info, "装饰");
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(), info, "装饰");

                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;

        }
    }


    @Override
    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
        showToast(upNewXinXi.getStatusMsg());
    }

    @Override
    public void responseUpNewOneError(String msg) {
        showToast(msg);
    }


    private String yumoneyss = "", jobtimess = "", lhouseaddressss = "", spaceneedss = "";

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
                case R.id.et_new_zhuangxiuyusuan:
                    editchanges(lengths, 0);
                    if (lengths > 0) {
                        yumoneyss = edittext.getText().toString().trim();
                    } else {
                        yumoneyss = "";
                    }
                    activity.savedatabean.setCa_DecBudgetPrice(yumoneyss);
                    break;
                case R.id.et_new_gongqi:
                    editchanges(lengths, 1);
                    if (lengths > 0) {
                        jobtimess = edittext.getText().toString().trim();
                    } else {
                        jobtimess = "";
                    }
                    activity.savedatabean.setCa_ProjectTime(jobtimess);
                    break;
                case R.id.et_new_liangfangdizhi:
                    editchanges(lengths, 2);
                    if (lengths > 0) {
                        lhouseaddressss = edittext.getText().toString().trim();
                    } else {
                        lhouseaddressss = "";
                    }
                    activity.savedatabean.setCi_DecorationAddress(lhouseaddressss);
                    break;
                case R.id.et_new_kongjianxuqiu:
                    editchanges(lengths, 3);
                    if (lengths > 0) {
                        spaceneedss = edittext.getText().toString().trim();
                    } else {
                        spaceneedss = "";
                    }
                    activity.savedatabean.setCa_SpaceRequirement(spaceneedss);
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

    int zhuangxiuyusuanm, gongqim, liangfangdizhim, kongjianxuqium;

    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length, int type) {
        Log.e("length" + length, "type" + type);
        if (length > 0) {
            switch (type) {
                case 0:
                    if (zhuangxiuyusuanm != 1) {
                        zhuangxiuyusuanm = 1;
                        addMoney();
                    }
                    break;
                case 1:
                    if (gongqim != 1) {
                        gongqim = 1;
                        addMoney();
                    }
                    break;
                case 2:
                    if (liangfangdizhim != 1) {
                        liangfangdizhim = 1;
                        addMoney();
                    }
                    break;
                case 3:
                    if (kongjianxuqium != 1) {
                        kongjianxuqium = 1;
                        addMoney();
                    }
                    break;
            }
        } else {
            switch (type) {
                case 0:
                    zhuangxiuyusuanm = 0;
                    Log.e("jianle", "0");
                    noaddMoney();
                    break;
                case 1:
                    gongqim = 0;
                    Log.e("jianle", "1");
                    noaddMoney();
                    break;
                case 2:
                    liangfangdizhim = 0;
                    Log.e("jianle", "2");
                    noaddMoney();
                    break;
                case 3:
                    kongjianxuqium = 0;
                    Log.e("jianle", "3");
                    noaddMoney();
                    break;
            }
        }
    }


    double allmoney;
    BigDecimal bigDecimal;
    double showmoney;
    int moneynum;//当前金额对应的个数

    private void addMoney() {
        moneynum = moneynum + 1;
        Log.e("个数；", moneynum + "");
        Log.e("金额是+；", lhousedata.getJDMoney() + "");
        allmoney = Double.parseDouble(lhousedata.getJDMoney());
        showmoney = allmoney / LF_NUM * moneynum;
        bigDecimal = new BigDecimal(showmoney);
        showmoney = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
        activity.setMoneynum(moneynum);
    }

    private void noaddMoney() {
        moneynum = moneynum - 1;
        Log.e("个数；", moneynum + "");
        allmoney = Double.parseDouble(lhousedata.getJDMoney());
        showmoney = allmoney / LF_NUM * moneynum;
        bigDecimal = new BigDecimal(showmoney);
        showmoney = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
        activity.setMoneynum(moneynum);
    }

}
