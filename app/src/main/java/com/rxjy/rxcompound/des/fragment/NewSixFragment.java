package com.rxjy.rxcompound.des.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.rxjy.rxcompound.des.entity.NewSixInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewSixContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewSixPresenter;
import com.rxjy.rxcompound.widget.TextGridview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.DatePicker;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewSixFragment extends BaseFragment<NewSixPresenter> implements NewSixContract.View, View.OnClickListener {

    //    @Bind(R.id.rb_new_fangwuzhuangkuang_maopifang)
//    RadioButton rbNewFangwuzhuangkuangMaopifang;
//    @Bind(R.id.rb_new_fangwuzhuangkuang_qingshuifang)
//    RadioButton rbNewFangwuzhuangkuangQingshuifang;
//    @Bind(R.id.rb_new_fangwuzhuangkuang_jiufanggaizao)
//    RadioButton rbNewFangwuzhuangkuangJiufanggaizao;
//    @Bind(R.id.rb_new_fangwuzhuangkuang_fanxin)
//    RadioButton rbNewFangwuzhuangkuangFanxin;
//    @Bind(R.id.rb_new_fangwuzhuangkuang_jingzhuangfang)
//    RadioButton rbNewFangwuzhuangkuangJingzhuangfang;
//    @Bind(R.id.rg_new_fangwuzhuangkuang)
//    RadioGroup rgNewFangwuzhuangkuang;
//    @Bind(R.id.rb_new_mianzuqi_wu)
//    RadioButton rbNewMianzuqiWu;
//    @Bind(R.id.rb_new_mianzuqi_yinei)
//    RadioButton rbNewMianzuqiYinei;
//    @Bind(R.id.rb_new_mianzuqi_yidaoer)
//    RadioButton rbNewMianzuqiYidaoer;
//    @Bind(R.id.rb_new_mianzuqi_ershang)
//    RadioButton rbNewMianzuqiErshang;
//    @Bind(R.id.rg_new_mianzuqi)
//    android.widget.RadioGroup rgNewMianzuqi;
//    @Bind(R.id.rb_new_chengjiaoleixing_zu)
//    RadioButton rbNewChengjiaoleixingZu;
//    @Bind(R.id.rb_new_chengjiaoleixing_mai)
//    RadioButton rbNewChengjiaoleixingMai;
//    @Bind(R.id.rb_new_chengjiaoleixing_zijian)
//    RadioButton rbNewChengjiaoleixingZijian;
//    @Bind(R.id.rg_new_chengjiaoleixing)
//    android.widget.RadioGroup rgNewChengjiaoleixing;
//    @Bind(R.id.rb_new_fangyuanzhuangtai_yiding)
//    RadioButton rbNewFangyuanzhuangtaiYiding;
//    @Bind(R.id.rb_new_fangyuanzhuangtai_weiding)
//    RadioButton rbNewFangyuanzhuangtaiWeiding;
//    @Bind(R.id.rg_new_fangyuanzhuangtai)
//    android.widget.RadioGroup rgNewFangyuanzhuangtai;
    @Bind(R.id.et_new_mianji)
    EditText etNewMianji;
    @Bind(R.id.et_new_buildmianji)
    EditText etNewBuildmianji;
    @Bind(R.id.tv_new_jiaofangshijian)
    TextView tvNewJiaofangshijian;
    @Bind(R.id.tv_new_liangfangshijian)
    TextView tvNewLiangfangshijian;
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;

    @Bind(R.id.tgv_housestatus)
    TextGridview tgv_housestatus;
    @Bind(R.id.tgv_norenttime)
    TextGridview tgv_norenttime;
    @Bind(R.id.tgv_makedealtype)
    TextGridview tgv_makedealtype;
    @Bind(R.id.tgv_housefromstatus)
    TextGridview tgv_housefromstatus;

    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;

    int itemmoney = 10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、

    //客户信息
    private AllClientNewBean.ClientNewBean clientInfo;

    private String fangwuzhuangkuang;
    private String mianzuqi;
    private String chengjiaoleixing;
    private String fangyuanzhuangtai;
    private String mianji;
    private String jiaofangdate;
    private String liangfangdate;

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
    private DesDaiMeasureABean.BodyBean lhousedata; //量房详情信息

    public void setLHouseData(DesDaiMeasureABean.BodyBean bean) {
        lhousedata = bean;
        Log.e("获取到。。获取到的量房信息", "并显示");
    }

    private void ShowView(DesDaiMeasureABean.BodyBean info) {
        moneynum = activity.moneynum;
        if(!StringUtils.isEmpty(info.getCi_Area())){
            mianjim=1;
            etNewMianji.setText(info.getCi_Area());
        }

        if(!StringUtils.isEmpty(info.getCi_BuildingArea())){
            buildmianji=1;
            etNewBuildmianji.setText(info.getCi_BuildingArea());
        }

        if(!StringUtils.isEmpty(info.getCa_LaunchTime())){
            jiaofangshijianm=1;
            if (!info.getCa_LaunchTime().trim().isEmpty()) {
                tvNewJiaofangshijian.setText(info.getCa_LaunchTime());
            }
        }

        if(!StringUtils.isEmpty(info.getCa_MeasureDate())){
            liangfangshijianm=1;
            if (!info.getCa_MeasureDate().trim().isEmpty()) {
                tvNewLiangfangshijian.setText(info.getCa_MeasureDate());
            }
        }


        if (info.getCa_HousingType() != null && info.getCa_HousingType().length() > 0) {
            housestatusm=1;
            int position = Integer.parseInt(info.getCa_HousingType());
            tgv_housestatus.setContents(housestatuslist.get(position - 1), position - 1);
        }

        if (info.getCa_RentFreeDate() != null && info.getCa_RentFreeDate().length() > 0) {
            norenttimem=1;
            int position = Integer.parseInt(info.getCa_RentFreeDate());
            tgv_norenttime.setContents(norentlist.get(position - 1), position - 1);
        }

        if (info.getCa_TransactionType() != null && info.getCa_TransactionType().length() > 0) {
            makedealtypem=1;
            int position = Integer.parseInt(info.getCa_TransactionType());
            tgv_makedealtype.setContents(makedealtypelist.get(position - 1), position - 1);

        }

        if (info.getCa_AvailabilityStatus() != null && info.getCa_AvailabilityStatus().length() > 0) {
            housefromstatusm=1;
            int position = Integer.parseInt(info.getCa_AvailabilityStatus());
            tgv_housefromstatus.setContents(housefromstatuslist.get(position - 1), position - 1);
        }
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_six;
    }


    DesDaiMeasureActivity activity;

    @Override
    protected void FragmentInitData() {

        //        itemmoney=clientInfo.getJDMoney()/94;
        activity = (DesDaiMeasureActivity) getActivity();

        initAddData();

        btnDesDaiMeasureSub.setOnClickListener(this);
        tvNewJiaofangshijian.setOnClickListener(this);
        tvNewLiangfangshijian.setOnClickListener(this);

        etNewMianji.addTextChangedListener(new MyEditListener(etNewMianji));
        etNewBuildmianji.addTextChangedListener(new MyEditListener(etNewBuildmianji));

//        rgNewChengjiaoleixing.setOnCheckedChangeListener(this);
//        rgNewFangwuzhuangkuang.setOnCheckedChangeListener(this);
//        rgNewFangyuanzhuangtai.setOnCheckedChangeListener(this);
//        rgNewMianzuqi.setOnCheckedChangeListener(this);

    }


    /**
     * 展示添加装修需求的源数据
     */
    private List<String> housestatuslist;
    private List<String> norentlist;
    private List<String> makedealtypelist;
    private List<String> housefromstatuslist;

    private void initAddData() {
        housestatuslist = new ArrayList<>();
        housestatuslist.add("毛坯房");
        housestatuslist.add("清水房");
        housestatuslist.add("旧房改造");
        housestatuslist.add("翻新");
        housestatuslist.add("精装房");

        norentlist = new ArrayList<>();
        norentlist.add("一个月内");
        norentlist.add("1-2个月");
        norentlist.add("2个月以上");
        norentlist.add("无");

        makedealtypelist = new ArrayList<>();
        makedealtypelist.add("租");
        makedealtypelist.add("买");
        makedealtypelist.add("自建");

        housefromstatuslist = new ArrayList<>();
        housefromstatuslist.add("已定");
        housefromstatuslist.add("未定");

        initShow();

    }

    /**
     * 展示添加的源数据
     */
    int housestatusm, norenttimem, makedealtypem, housefromstatusm;

    private void initShow() {
        tgv_housestatus.setTvType("房屋状况");
        tgv_housestatus.setGvLines(4);
        tgv_housestatus.setGvData(getActivity(), housestatuslist);
        tgv_housestatus.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (housestatusm != 1) {
                    housestatusm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_HousingType(position + 1 + "");
            }
        });

        tgv_norenttime.setTvType("免租期");
        tgv_norenttime.setGvLines(4);
        tgv_norenttime.setGvData(getActivity(), norentlist);
        tgv_norenttime.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (norenttimem != 1) {
                    norenttimem = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_RentFreeDate(position + 1 + "");
            }
        });

        tgv_makedealtype.setTvType("成交类型");
        tgv_makedealtype.setGvLines(4);
        tgv_makedealtype.setGvData(getActivity(), makedealtypelist);
        tgv_makedealtype.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (makedealtypem != 1) {
                    makedealtypem = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_TransactionType(position + 1 + "");
            }
        });

        tgv_housefromstatus.setTvType("房源状态");
        tgv_housefromstatus.setGvLines(4);
        tgv_housefromstatus.setGvData(getActivity(), housefromstatuslist);
        tgv_housefromstatus.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (housefromstatusm != 1) {
                    housefromstatusm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_AvailabilityStatus(position + 1 + "");
            }
        });

//        mPresenter.GetNewSix(clientInfo.getCi_rwdid());
        ShowView(lhousedata);
    }


    @Override
    protected NewSixPresenter onCreatePresenter() {
        return new NewSixPresenter(this);
    }

    NewSixInfo.BodyBean bodyInfo;

    @Override
    public void responseGetNewSix(NewSixInfo.BodyBean info) {
        bodyInfo = info;
        etNewMianji.setText(info.getCi_Area());
        if (!info.getCa_LaunchTime().trim().isEmpty()) {
            tvNewJiaofangshijian.setText(info.getCa_LaunchTime());
        }
        if (!info.getCa_MeasureDate().trim().isEmpty()) {
            tvNewLiangfangshijian.setText(info.getCa_MeasureDate());
        }

        if (info.getCa_HousingType() != null && info.getCa_HousingType().length() > 0) {
            int position = Integer.parseInt(info.getCa_HousingType());
            tgv_housestatus.setContents(housestatuslist.get(position - 1), position - 1);
        }

        if (info.getCa_RentFreeDate() != null && info.getCa_RentFreeDate().length() > 0) {
            int position = Integer.parseInt(info.getCa_RentFreeDate());
            tgv_norenttime.setContents(norentlist.get(position - 1), position - 1);
        }

        if (info.getCa_TransactionType() != null && info.getCa_TransactionType().length() > 0) {
            int position = Integer.parseInt(info.getCa_TransactionType());
            tgv_makedealtype.setContents(makedealtypelist.get(position - 1), position - 1);
        }

        if (info.getCa_AvailabilityStatus() != null && info.getCa_AvailabilityStatus().length() > 0) {
            int position = Integer.parseInt(info.getCa_AvailabilityStatus());
            tgv_housefromstatus.setContents(housefromstatuslist.get(position - 1), position - 1);
        }

//        switch (info.getCa_HousingType()){
//            case "1":
//                rbNewFangwuzhuangkuangMaopifang.setChecked(true);
//                break;
//            case "2":
//                rbNewFangwuzhuangkuangQingshuifang.setChecked(true);
//                break;
//            case "3":
//                rbNewFangwuzhuangkuangJiufanggaizao.setChecked(true);
//                break;
//            case "4":
//                rbNewFangwuzhuangkuangFanxin.setChecked(true);
//                break;
//            case "5":
//                rbNewFangwuzhuangkuangJingzhuangfang.setChecked(true);
//                break;
//        }
//        switch (info.getCa_AvailabilityStatus()){
//            case "1":
//                rbNewFangyuanzhuangtaiYiding.setChecked(true);
//                break;
//            case "2":
//                rbNewFangyuanzhuangtaiWeiding.setChecked(true);
//                break;
//        }
//        switch (info.getCa_TransactionType()){
//            case "1":
//                rbNewChengjiaoleixingZu.setChecked(true);
//                break;
//            case "2":
//                rbNewChengjiaoleixingMai.setChecked(true);
//                break;
//            case "3":
//                rbNewChengjiaoleixingZijian.setChecked(true);
//                break;
//        }
//        switch (info.getCa_RentFreeDate()){
//            case "1":
//                rbNewMianzuqiYinei.setChecked(true);
//                break;
//            case "2":
//                rbNewMianzuqiYidaoer.setChecked(true);
//                break;
//            case "3":
//                rbNewMianzuqiErshang.setChecked(true);
//                break;
//            case "4":
//                rbNewMianzuqiWu.setChecked(true);
//                break;
//        }
    }

    @Override
    public void responseGetNewSixError(String msg) {

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

    private String jiaofangshijian;
    private String liangfangshijian;
    private int jiaofangshijianm,liangfangshijianm;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_new_jiaofangshijian:
                DatePicker endPicker = new DatePicker(getActivity());
                endPicker.setRange(2017, 2100);//年份范围
                endPicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {

                        jiaofangshijian = year + "-" + month + "-" + day;
                        tvNewJiaofangshijian.setText(jiaofangshijian);
                        activity.savedatabean.setCa_LaunchTime(jiaofangshijian);
                        if(jiaofangshijianm!=1){
                            jiaofangshijianm=1;
                            addMoney();
                        }

                    }
                });
                endPicker.show();
                break;
            case R.id.tv_new_liangfangshijian:
                DatePicker Picker = new DatePicker(getActivity());
                Picker.setRange(2017, 2100);//年份范围
                Picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        liangfangshijianm=1;
                        liangfangshijian = year + "-" + month + "-" + day;
                        tvNewLiangfangshijian.setText(liangfangshijian);
                        activity.savedatabean.setCa_MeasureDate(liangfangshijian);
                        if(liangfangshijianm!=1){
                            liangfangshijianm=1;
                            addMoney();
                        }
                    }
                });
                Picker.show();
                break;
            case R.id.btn_des_dai_measure_sub:

                mianji = etNewMianji.getText().toString();
                bodyInfo.setCi_Area(mianji);
                jiaofangdate = tvNewJiaofangshijian.getText().toString();
                liangfangdate = tvNewLiangfangshijian.getText().toString();
                bodyInfo.setCa_LaunchTime(jiaofangdate);
                bodyInfo.setCa_MeasureDate(liangfangdate);


                String housestatus = tgv_housestatus.getSelectcontent();
                if (housestatus != null && housestatus.length() > 0) {
                    for (int i = 0; i < housestatuslist.size(); i++) {
                        if (housestatus.equals(housestatuslist.get(i))) {
                            fangwuzhuangkuang = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_HousingType(fangwuzhuangkuang);
                String housefromstatus = tgv_housefromstatus.getSelectcontent();
                if (housefromstatus != null && housefromstatus.length() > 0) {
                    for (int i = 0; i < housefromstatuslist.size(); i++) {
                        if (housefromstatus.equals(housefromstatuslist.get(i))) {
                            fangyuanzhuangtai = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_AvailabilityStatus(fangyuanzhuangtai);
                String makedealtype = tgv_makedealtype.getSelectcontent();
                if (makedealtype != null && makedealtype.length() > 0) {
                    for (int i = 0; i < makedealtypelist.size(); i++) {
                        if (makedealtype.equals(makedealtypelist.get(i))) {
                            chengjiaoleixing = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_TransactionType(chengjiaoleixing);
                String norent = tgv_norenttime.getSelectcontent();
                if (norent != null && norent.length() > 0) {
                    for (int i = 0; i < norentlist.size(); i++) {
                        if (norent.equals(norentlist.get(i))) {
                            mianzuqi = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_RentFreeDate(mianzuqi);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info = JSONUtils.toString(bodyInfo);
                        Log.e("六", info);
//                        mPresenter.UpXinxi(clientInfo.getCi_rwdid(), info, "房源");
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(), info, "房源");

                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
        }
    }

//    @Override
//    public void onCheckedChanged(android.widget.RadioGroup group, int i) {
//
//        switch (i){
//            case R.id.rb_new_fangyuanzhuangtai_yiding:
//                fangyuanzhuangtai="1";
//                break;
//            case R.id.rb_new_fangyuanzhuangtai_weiding:
//                fangyuanzhuangtai="2";
//                break;
//            case R.id.rb_new_chengjiaoleixing_zu:
//                chengjiaoleixing="1";
//                break;
//            case R.id.rb_new_chengjiaoleixing_mai:
//                chengjiaoleixing="2";
//                break;
//            case R.id.rb_new_chengjiaoleixing_zijian:
//                chengjiaoleixing="3";
//                break;
//            case R.id.rb_new_mianzuqi_yinei:
//                mianzuqi="1";
//                break;
//            case R.id.rb_new_mianzuqi_yidaoer:
//                mianzuqi="2";
//                break;
//            case R.id.rb_new_mianzuqi_ershang:
//                mianzuqi="3";
//                break;
//            case R.id.rb_new_mianzuqi_wu:
//                mianzuqi="4";
//                break;
//        }
//    }

    //zidingyi
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//     switch (checkedId){
//         case R.id.rb_new_fangwuzhuangkuang_maopifang:
//             fangwuzhuangkuang="1";
//         break;
//         case R.id.rb_new_fangwuzhuangkuang_qingshuifang:
//             fangwuzhuangkuang="2";
//             break;
//         case R.id.rb_new_fangwuzhuangkuang_jiufanggaizao:
//             fangwuzhuangkuang="3";
//             break;
//         case R.id.rb_new_fangwuzhuangkuang_fanxin:
//             fangwuzhuangkuang="4";
//             break;
//         case R.id.rb_new_fangwuzhuangkuang_jingzhuangfang:
//             fangwuzhuangkuang="5";
//             break;
//     }
//    }

    @Override
    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
        showToast(upNewXinXi.getStatusMsg());
    }

    @Override
    public void responseUpNewOneError(String msg) {
        showToast(msg);
    }


    private String area = "";
    private String buildarea = "";

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
                case R.id.et_new_mianji:
                    editchanges(lengths, 0);
                    if (lengths > 0) {
                        area = edittext.getText().toString().trim();
                    } else {
                        area = "";
                    }
                    activity.savedatabean.setCi_Area(area);
                    break;
                case R.id.et_new_buildmianji:
                    editchanges(lengths, 1);
                    if (lengths > 0) {
                        buildarea = edittext.getText().toString().trim();
                    } else {
                        buildarea = "";
                    }
                    activity.savedatabean.setCi_BuildingArea(buildarea);
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

    int mianjim,buildmianji;

    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length, int type) {
        Log.e("length" + length, "type" + type);
        if (length > 0) {
            switch (type) {
                case 0:
                    if (mianjim != 1) {
                        mianjim = 1;
                        addMoney();
                    }
                    break;
                case 1:
                    if (buildmianji != 1) {
                        buildmianji = 1;
                        addMoney();
                    }
                    break;
            }
        } else {
            switch (type) {
                case 0:
                    mianjim = 0;
                    noaddMoney();
                    break;
                case 1:
                    buildmianji = 0;
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
