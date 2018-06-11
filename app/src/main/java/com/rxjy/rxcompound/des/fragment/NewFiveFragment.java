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

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.DesDaiMeasureActivity;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;
import com.rxjy.rxcompound.des.entity.NewFiveInfo;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewFiveCantract;
import com.rxjy.rxcompound.des.mvp.presenter.NewFivePresenter;
import com.rxjy.rxcompound.widget.TextGridview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFiveFragment extends BaseFragment<NewFivePresenter> implements NewFiveCantract.View, View.OnClickListener {
    @Bind(R.id.et_new_xiangmumingcheng)
    EditText etNewXiangmumingcheng;
    @Bind(R.id.et_new_bangongdidian)
    EditText etNewBangongdidian;
    //    @Bind(R.id.rb_new_xiangmuleixing_bangong)
//    RadioButton rbNewXiangmuleixingBangong;
//    @Bind(R.id.rb_new_xiangmuleixing_canyin)
//    RadioButton rbNewXiangmuleixingCanyin;
//    @Bind(R.id.rb_new_xiangmuleixing_shangye)
//    RadioButton rbNewXiangmuleixingShangye;
//    @Bind(R.id.rb_new_xiangmuleixing_jiudian)
//    RadioButton rbNewXiangmuleixingJiudian;
//    @Bind(R.id.rb_new_xiangmuleixing_qita)
//    RadioButton rbNewXiangmuleixingQita;
//    @Bind(R.id.rg_new_xiangmuleixing)
//    RadioGroup rgNewXiangmuleixing;
//    @Bind(R.id.rb_new_hangyeleixing_liansuo)
//    RadioButton rbNewHangyeleixingLiansuo;
//    @Bind(R.id.rb_new_hangyeleixing_laodian)
//    RadioButton rbNewHangyeleixingLaodian;
//    @Bind(R.id.rb_new_hangyeleixing_yingxiao)
//    RadioButton rbNewHangyeleixingYingxiao;
//    @Bind(R.id.rb_new_hangyeleixing_jishuxing)
//    RadioButton rbNewHangyeleixingJishuxing;
//    @Bind(R.id.rb_new_hangyeleixing_tese)
//    RadioButton rbNewHangyeleixingTese;
//    @Bind(R.id.rb_new_hangyeleixing_jiaoyu)
//    RadioButton rbNewHangyeleixingJiaoyu;
//    @Bind(R.id.rg_new_hangyeleixing)
//    RadioGroup rgNewHangyeleixing;
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;
    @Bind(R.id.tv_measure_tenancy_term_end_time)
    TextView tvMeasureTenancyTermEndTime;
    @Bind(R.id.tv_measure_tenancy_term_time_line)
    TextView tvMeasureTenancyTermTimeLine;
    @Bind(R.id.tv_measure_tenancy_term_start_time)
    TextView tvMeasureTenancyTermStartTime;

    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;

//    @Bind(R.id.tgv_projectattribute)
//    TextGridview tgv_projectattribute;
    @Bind(R.id.tgv_industrytype)
    TextGridview tgv_industrytype;
    @Bind(R.id.tv_projectattribute)
    TextView tvProjectattribute;

    //客户信息
    private AllClientNewBean.ClientNewBean clientInfo;

    private String xiangmumingcheng;
    private String bangongdidian;
    private String zuqi;
    private String xiangmuleixing;
    private String hangyeleixing;

    private String zuqiEnd;
    private String zuqiStart;

    int itemmoney = 10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、

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
        if (!StringUtils.isEmpty(info.getCi_ClientName())) {
            xiangmumingchengm = 1;
            etNewXiangmumingcheng.setText(info.getCi_ClientName());
        }
        if (!StringUtils.isEmpty(info.getCi_OfficeAddress())) {
            bangongdidianm = 1;
            etNewBangongdidian.setText(info.getCi_OfficeAddress());
        }

        if (info.getCa_LeaseTermStart() != null && info.getCa_LeaseTermStart().length() > 0) {
            start_timem = 1;
            tvMeasureTenancyTermStartTime.setText(info.getCa_LeaseTermStart());
        }
        if (info.getCa_LeaseTermEnd() != null && info.getCa_LeaseTermEnd().length() > 0) {
            end_timem = 1;
            tvMeasureTenancyTermEndTime.setText(info.getCa_LeaseTermEnd());
        }

//        if (info.getCi_Type() != null && info.getCi_Type().length() > 0) {
//            projectattributem = 1;
//            Log.e("111","show"+isshowed);
//            if(isshowed==1){
//                Log.e("222","show");
//                for (int i = 0; i <protypelist.size() ; i++) {
//                    if(info.getCi_Type().equals(protypelist.get(i).getID())){
//                        tvProjectattribute.setText(protypelist.get(i).getMingCheng());
//                        Log.e("333","show");
//                        for (int j = 0; j < protypelist.get(i).getZiji().size(); j++) {
//                            if(info.getCa_SWIndustryTypeID().equals(protypelist.get(i).getZiji().get(j).getID())){
//                                Log.e("444","show");
//                                tvProjectattribute.setText(protypelist.get(i).getMingCheng()+"-"+protypelist.get(i).getZiji().get(j).getMingCheng());
//                            }
//                        }
//                    }
//
//                }
//
//            }
////            tvProjectattribute.setText(info.getCi_Type());
//        }


//        if (!StringUtils.isEmpty(info.getCi_Type())) {
//            projectattributem = 1;
//            int position = Integer.parseInt(info.getCi_Type());
//            tgv_projectattribute.setContents(projectattributelist.get(position - 1), position - 1);
//        }


        if (info.getCa_HangYeLeIXing() != null && info.getCa_HangYeLeIXing().length() > 0) {
            industrytypem = 1;
            int position = Integer.parseInt(info.getCa_HangYeLeIXing());
            if (position >= 212) {
                tgv_industrytype.setContents(industrytypelist.get(position - 212), position - 212);
            }

        }
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_five;
    }

    DesDaiMeasureActivity activity;

    @Override
    protected void FragmentInitData() {
        mPresenter.getProjecttype();

        //        itemmoney=clientInfo.getJDMoney()/94;
        activity = (DesDaiMeasureActivity) getActivity();

        initAddData();

        btnDesDaiMeasureSub.setOnClickListener(this);
        tvMeasureTenancyTermStartTime.setOnClickListener(this);
        tvMeasureTenancyTermEndTime.setOnClickListener(this);

        etNewXiangmumingcheng.addTextChangedListener(new MyEditListener(etNewXiangmumingcheng));
        etNewBangongdidian.addTextChangedListener(new MyEditListener(etNewBangongdidian));

//        rgNewHangyeleixing.setOnCheckedChangeListener(this);
//        rgNewXiangmuleixing.setOnCheckedChangeListener(this);

    }

    /**
     * 展示添加装修需求的源数据
     */
    private List<String> projectattributelist;
    private List<String> industrytypelist;

    private void initAddData() {
        projectattributelist = new ArrayList<>();
        projectattributelist.add("办公");
        projectattributelist.add("餐饮");
        projectattributelist.add("商业");
        projectattributelist.add("酒店");
        projectattributelist.add("其它");

        industrytypelist = new ArrayList<>();
//        industrytypelist.add("连锁");
//        industrytypelist.add("老店");
//        industrytypelist.add("营销");
//        industrytypelist.add("技术型");
//        industrytypelist.add("特色");
//        industrytypelist.add("教育");
        industrytypelist.add("直营连锁");
        industrytypelist.add("加盟");
        industrytypelist.add("联盟");

        initShow();
    }

    /**
     * 展示添加的源数据
     */
    int projectattributem, industrytypem;

    private void initShow() {
//        tgv_projectattribute.setTvType("项目属性");
//        tgv_projectattribute.setGvLines(4);
//        tgv_projectattribute.setGvData(getActivity(), projectattributelist);
//        tgv_projectattribute.tochoose(new TextGridview.Choose() {
//            @Override
//            public void tochoose(int position) {//改变钱数
//                if (projectattributem != 1) {
//                    projectattributem = 1;
//                    addMoney();
//                    activity.savedatabean.setCi_Type(position + 1 + "");
//                }
//            }
//        });

        tgv_industrytype.setTvType("经营模式");
        tgv_industrytype.setGvLines(4);
        tgv_industrytype.setGvData(getActivity(), industrytypelist);
        tgv_industrytype.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if (industrytypem != 1) {
                    industrytypem = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_HangYeLeIXing(212 + position + "");
            }
        });

//        mPresenter.GetNewFive(clientInfo.getCi_rwdid());
        ShowView(lhousedata);
    }

    @Override
    protected NewFivePresenter onCreatePresenter() {
        return new NewFivePresenter(this);
    }


    private NewFiveInfo.BodyBean bodyInfo;
    @Override
    public void responseGetNewFive(NewFiveInfo.BodyBean info) {
        bodyInfo = info;
        etNewXiangmumingcheng.setText(info.getCi_ClientName());
        etNewBangongdidian.setText(info.getCi_OfficeAddress());
        if (info.getCa_LeaseTermStart() != null && info.getCa_LeaseTermStart().length() > 0) {
            tvMeasureTenancyTermStartTime.setText(info.getCa_LeaseTermStart());
        }
        if (info.getCa_LeaseTermEnd() != null && info.getCa_LeaseTermEnd().length() > 0) {
            tvMeasureTenancyTermEndTime.setText(info.getCa_LeaseTermEnd());
        }

//        if (info.getCi_Type() != null && info.getCi_Type().length() > 0) {
//            int position = Integer.parseInt(info.getCi_Type());
//            tgv_projectattribute.setContents(projectattributelist.get(position - 1), position - 1);
//        }

        if (info.getCa_HangYeLeIXing() != null && info.getCa_HangYeLeIXing().length() > 0) {
            int position = Integer.parseInt(info.getCa_HangYeLeIXing());
            tgv_industrytype.setContents(industrytypelist.get(position - 212), position - 212);
        }

//        switch (info.getCi_Type()){
//            case "1":
//                rbNewXiangmuleixingBangong.setChecked(true);
//                break;
//            case "2":
//                    rbNewXiangmuleixingCanyin.setChecked(true);
//                break;
//            case "3":
//                rbNewXiangmuleixingShangye.setChecked(true);
//                break;
//            case "4":
//                rbNewXiangmuleixingJiudian.setChecked(true);
//                break;
//            case "5":
//                rbNewXiangmuleixingQita.setChecked(true);
//                break;
//
//        }
//
//        switch (info.getCa_HangYeLeIXing()){
//            case "90":
//                rbNewHangyeleixingLiansuo.setChecked(true);
//                break;
//            case "91":
//                rbNewHangyeleixingLaodian.setChecked(true);
//                break;
//            case "92":
//                rbNewHangyeleixingYingxiao.setChecked(true);
//                break;
//            case "93":
//                rbNewHangyeleixingJishuxing.setChecked(true);
//                break;
//            case "94":
//                rbNewHangyeleixingTese.setChecked(true);
//                break;
//            case "95":
//                rbNewHangyeleixingJiaoyu.setChecked(true);
//                break;
//        }


    }

    @Override
    public void responseGetNewFiveError(String msg) {

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
    int end_timem, start_timem;

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
                        tvMeasureTenancyTermEndTime.setText(caLeaseTermEnd);
                        if (end_timem != 1) {
                            end_timem = 1;
                            addMoney();
                        }
                        activity.savedatabean.setCa_LeaseTermEnd(caLeaseTermEnd);
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
                        tvMeasureTenancyTermStartTime.setText(caLeaseTermStart);
                        if (start_timem != 1) {
                            start_timem = 1;
                            addMoney();
                        }
                        activity.savedatabean.setCa_LeaseTermStart(caLeaseTermStart);
                    }
                });
                startPicker.show();
                break;
            case R.id.btn_des_dai_measure_sub:

                xiangmumingcheng = etNewXiangmumingcheng.getText().toString().trim();
                bodyInfo.setCi_ClientName(xiangmumingcheng);
                bangongdidian = etNewBangongdidian.getText().toString().trim();
                bodyInfo.setCi_OfficeAddress(bangongdidian);

                zuqiEnd = tvMeasureTenancyTermEndTime.getText().toString();
                zuqiStart = tvMeasureTenancyTermStartTime.getText().toString();
                bodyInfo.setCa_LeaseTermEnd(zuqiEnd);
                bodyInfo.setCa_LeaseTermStart(zuqiStart);

//                String projectattribute = tgv_projectattribute.getSelectcontent();
//                if (projectattribute != null && projectattribute.length() > 0) {
//                    for (int i = 0; i < projectattributelist.size(); i++) {
//                        if (projectattribute.equals(projectattributelist.get(i))) {
//                            xiangmuleixing = i + 1 + "";
//                            break;
//                        }
//                    }
//                }
                bodyInfo.setCi_Type(xiangmuleixing);
                String industrytype = tgv_industrytype.getSelectcontent();
                if (industrytype != null && industrytype.length() > 0) {
                    for (int i = 0; i < industrytypelist.size(); i++) {
                        if (industrytype.equals(industrytypelist.get(i))) {
                            hangyeleixing = i + 212 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_HangYeLeIXing(hangyeleixing);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info = JSONUtils.toString(bodyInfo);
                        Log.e("五", info);
//                        mPresenter.UpXinxi(clientInfo.getCi_rwdid(), info, "基本");
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(), info, "基本");


                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;

        }

    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//        switch (checkedId) {
//            case R.id.rb_new_xiangmuleixing_bangong:
//                 xiangmuleixing="1";
//                break;
//            case R.id.rb_new_xiangmuleixing_canyin:
//                xiangmuleixing="2";
//                break;
//            case R.id.rb_new_xiangmuleixing_shangye:
//                xiangmuleixing="3";
//                break;
//            case R.id.rb_new_xiangmuleixing_jiudian:
//                xiangmuleixing="4";
//                break;
//            case R.id.rb_new_xiangmuleixing_qita:
//                xiangmuleixing="5";
//                break;
//
//            case R.id.rb_new_hangyeleixing_liansuo:
//                hangyeleixing="90";
//                break;
//            case R.id.rb_new_hangyeleixing_laodian:
//                hangyeleixing="91";
//                break;
//            case R.id.rb_new_hangyeleixing_yingxiao:
//                hangyeleixing="92";
//                break;
//            case R.id.rb_new_hangyeleixing_jishuxing:
//                hangyeleixing="93";
//                break;
//            case R.id.rb_new_hangyeleixing_tese:
//                hangyeleixing="94";
//                break;
//            case R.id.rb_new_hangyeleixing_jiaoyu:
//                hangyeleixing="95";
//                break;
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
        showToast(upNewXinXi.getStatusMsg());
    }

    @Override
    public void responseUpNewOneError(String msg) {
        showToast(msg);
    }

    private OptionsPickerView pVprojecttype;
    List<String> protypefulist;
    List<List<String>> protypezilist;
    List<ProjectTypeBean.FatherDataBean> protypelist;
    int isshowed;

    @Override
    public void responseProjecttype(ProjectTypeBean data) {
        isshowed=1;
        //得到了数据展示
        protypefulist = new ArrayList<>();
        protypezilist = new ArrayList<>();
        protypelist = new ArrayList<>();
        protypelist.addAll(data.getBody());
        for (ProjectTypeBean.FatherDataBean fatherDataBean : data.getBody()) {
            protypefulist.add(fatherDataBean.getMingCheng());
            List<String> child = new ArrayList<>();
            for (ProjectTypeBean.FatherDataBean.SonDataBean childbean : fatherDataBean.getZiji()) {
                child.add(childbean.getMingCheng());
            }
            protypezilist.add(child);
        }

        //判断有没有值并展示
        if (lhousedata.getCi_Type() != null && lhousedata.getCi_Type().length() > 0) {
            projectattributem = 1;
            Log.e("111","show"+isshowed);
                Log.e("222","show");
                for (int i = 0; i <protypelist.size() ; i++) {
                    if(lhousedata.getCi_Type().equals(protypelist.get(i).getID())){
                        tvProjectattribute.setText(protypelist.get(i).getMingCheng());
                        Log.e("333","show");
                        for (int j = 0; j < protypelist.get(i).getZiji().size(); j++) {
                            if(lhousedata.getCa_SWIndustryTypeID().equals(protypelist.get(i).getZiji().get(j).getID())){
                                Log.e("444","show");
                                tvProjectattribute.setText(protypelist.get(i).getMingCheng()+"-"+protypelist.get(i).getZiji().get(j).getMingCheng());
                            }
                        }
                    }

                }
//            tvProjectattribute.setText(info.getCi_Type());
        }


    }

    private void Showpupwindow() {

        pVprojecttype = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                tvProjectattribute.setText(protypelist.get(options1).getMingCheng() + "-" + protypelist.get(options1).getZiji().get(options2).getMingCheng());
                activity.savedatabean.setCi_Type(protypelist.get(options1).getID());
                activity.savedatabean.setCa_SWIndustryTypeID(protypelist.get(options1).getZiji().get(options2).getID());
                if (projectattributem != 1) {
                    projectattributem = 1;
                    addMoney();
                    addMoney();
                }
            }
        }).build();
        pVprojecttype.setPicker(protypefulist, protypezilist);
        pVprojecttype.show();
    }

    @Override
    public void responseProjecttypeError(String msg) {

    }


    private String projectname = "", workaddress = "";

    //请求项目类型显示
    @OnClick(R.id.rl_projectattribute)
    public void onViewClicked() {
        if (isshowed == 1) {
            Showpupwindow();
        }
//        else {
//            mPresenter.getProjecttype();
//        }
    }

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
                case R.id.et_new_xiangmumingcheng:
                    editchanges(lengths, 0);
                    if (lengths > 0) {
                        projectname = edittext.getText().toString().trim();
                    } else {
                        projectname = "";
                    }
                    activity.savedatabean.setCi_ClientName(projectname);
                    break;
                case R.id.et_new_bangongdidian:
                    editchanges(lengths, 1);
                    if (lengths > 0) {
                        workaddress = edittext.getText().toString().trim();
                    } else {
                        workaddress = "";
                    }
                    activity.savedatabean.setCi_OfficeAddress(workaddress);
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

    int xiangmumingchengm, bangongdidianm;

    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length, int type) {
        Log.e("length" + length, "type" + type);
        if (length > 0) {
            switch (type) {
                case 0:
                    if (xiangmumingchengm != 1) {
                        xiangmumingchengm = 1;
                        addMoney();
                    }
                    break;
                case 1:
                    if (bangongdidianm != 1) {
                        bangongdidianm = 1;
                        addMoney();
                    }
                    break;
            }
        } else {
            switch (type) {
                case 0:
                    xiangmumingchengm = 0;
                    noaddMoney();
                    break;
                case 1:
                    bangongdidianm = 0;
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
