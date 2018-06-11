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
import com.rxjy.rxcompound.des.entity.NewNineInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewNineContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewNinePresenter;
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
public class NineFragment extends BaseFragment<NewNinePresenter> implements NewNineContract.View {

//    @Bind(R.id.rb_new_qiyexingzhi_guoqi)
//    RadioButton rbNewQiyexingzhiGuoqi;
//    @Bind(R.id.rb_new_qiyexingzhi_siqi)
//    RadioButton rbNewQiyexingzhiSiqi;
//    @Bind(R.id.rb_new_qiyexingzhi_waiqi)
//    RadioButton rbNewQiyexingzhiWaiqi;
//    @Bind(R.id.rb_new_qiyexingzhi_yangqi)
//    RadioButton rbNewQiyexingzhiYangqi;
//    @Bind(R.id.rb_new_qiyexingzhi_hezi)
//    RadioButton rbNewQiyexingzhiHezi;
//    @Bind(R.id.rg_new_qiyexingzhi)
//    RadioGroup rgNewQiyexingzhi;
//    @Bind(R.id.rb_new_qiyeguimo_sanshixia)
//    RadioButton rbNewQiyeguimoSanshixia;
//    @Bind(R.id.rb_new_qiyeguimo_sanshidaowushi)
//    RadioButton rbNewQiyeguimoSanshidaowushi;
//    @Bind(R.id.rb_new_qiyeguimo_wushidaoyibai)
//    RadioButton rbNewQiyeguimoWushidaoyibai;
//    @Bind(R.id.rb_new_qiyeguimo_yibaiyishang)
//    RadioButton rbNewQiyeguimoYibaiyishang;
//    @Bind(R.id.rg_new_qiyeguimo)
//    android.widget.RadioGroup rgNewQiyeguimo;
//    @Bind(R.id.rb_new_shouciruzhu_shi)
//    RadioButton rbNewShouciruzhuShi;
//    @Bind(R.id.rb_new_shouciruzhu_fou)
//    RadioButton rbNewShouciruzhuFou;
//    @Bind(R.id.rg_new_shouciruzhu)
//    android.widget.RadioGroup rgNewShouciruzhu;
    @Bind(R.id.tv_new_chenglishijian)
    TextView tvNewChenglishijian;
    @Bind(R.id.et_new_jingyingfanwei)
    EditText etNewJingyingfanwei;
    @Bind(R.id.et_new_qiyewenhua)
    EditText etNewQiyewenhua;
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;
//    @Bind(R.id.rb_new_qiyexingzhi_qita)
//    RadioButton rbNewQiyexingzhiQita;

    @Bind(R.id.tgv_enterprise)
    TextGridview tgv_enterprise;
    @Bind(R.id.tgv_enterprisesize)
    TextGridview tgv_enterprisesize;
    @Bind(R.id.tgv_firstin)
    TextGridview tgv_firstin;

    //客户信息
    private AllClientNewBean.ClientNewBean clientInfo;

    private String qiyexingzhi;
    private String qiyeguimo;
    private String chenglidate;
    private String qiyeshouciruzhu;
    private String jingyingfanwei;
    private String qiyewenhua;


    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;

    int itemmoney=10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、

    private String chenglishijian;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void setClientInfo(AllClientNewBean.ClientNewBean info) {
        clientInfo = info;
    }

    /**
     * 获取到的量房信息
     */
    private DesDaiMeasureABean.BodyBean lhousedata; //量房详情信息
    public void setLHouseData(DesDaiMeasureABean.BodyBean bean) {
        lhousedata=bean;
        Log.e("获取到。。获取到的量房信息","并显示");
    }

    private void ShowView(DesDaiMeasureABean.BodyBean info){
        moneynum = activity.moneynum;

        if(!StringUtils.isEmpty(info.getCa_EstablishmentTime())){
            Chenglishijianm=1;
            if (!info.getCa_EstablishmentTime().trim().isEmpty()){
                tvNewChenglishijian.setText(info.getCa_EstablishmentTime());
            }
        }
        if(!StringUtils.isEmpty(info.getCa_BusinessScope())){
            jingyingfanweim=1;
            etNewJingyingfanwei.setText(info.getCa_BusinessScope());
        }
        if(!StringUtils.isEmpty(info.getCa_BusinessScope())){
            qiyewenhuam=1;
            etNewQiyewenhua.setText(info.getCa_CorporateCulture());
        }


        if(!StringUtils.isEmpty(info.getCa_EnterpriseNature())){
            enterprisem=1;
            for (int i = 0; i < enterpriselist.size(); i++) {
                if(enterpriselist.get(i).equals(info.getCa_EnterpriseNature())){
                    tgv_enterprise.setContents(info.getCa_EnterpriseNature(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_EnterprisesScale())){
            enterprisesizem=1;
            for (int i = 0; i < enterprisesizelist.size(); i++) {
                if(enterprisesizelist.get(i).equals(info.getCa_EnterprisesScale())){
                    tgv_enterprisesize.setContents(info.getCa_EnterprisesScale(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_ForeignEnterprises())){
            firstinm=1;
            for (int i = 0; i < firstinlist.size(); i++) {
                if(firstinlist.get(i).equals(info.getCa_ForeignEnterprises())){
                    tgv_firstin.setContents(info.getCa_ForeignEnterprises(), i);
                    break;
                }
            }
        }


    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_nine;
    }

    int Chenglishijianm;
    DesDaiMeasureActivity activity;
    @Override
    protected void FragmentInitData() {

        //        itemmoney=clientInfo.getJDMoney()/94;
        activity = (DesDaiMeasureActivity) getActivity();

        initAddData();

        etNewJingyingfanwei.addTextChangedListener(new MyEditListener(etNewJingyingfanwei));
        etNewQiyewenhua.addTextChangedListener(new MyEditListener(etNewQiyewenhua));
//        rgNewQiyeguimo.setOnCheckedChangeListener(this);
//        rgNewQiyexingzhi.setOnCheckedChangeListener(this);
//        rgNewShouciruzhu.setOnCheckedChangeListener(this);

        tvNewChenglishijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker Picker = new DatePicker(getActivity());
                Picker.setRange(2017, 2100);//年份范围
                Picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener()
                {
                    @Override
                    public void onDatePicked(String year, String month, String day)
                    {
                        chenglishijian = year + "-" + month + "-" + day;
                        tvNewChenglishijian.setText(chenglishijian);
                        if(Chenglishijianm!=1){
                            Chenglishijianm=1;
                            addMoney();
                        }
                        activity.savedatabean.setCa_EstablishmentTime(chenglishijian);
                    }
                });
                Picker.show();
            }
        });

        btnDesDaiMeasureSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               chenglidate=tvNewChenglishijian.getText().toString();
                bodyInfo.setCa_EstablishmentTime(chenglidate);
                jingyingfanwei=etNewJingyingfanwei.getText().toString();
                bodyInfo.setCa_BusinessScope(jingyingfanwei);
                qiyewenhua=etNewQiyewenhua.getText().toString();
                bodyInfo.setCa_CorporateCulture(qiyewenhua);

                qiyexingzhi=tgv_enterprise.getSelectcontent();
                bodyInfo.setCa_EnterpriseNature(qiyexingzhi);
                qiyeguimo=tgv_enterprisesize.getSelectcontent();
                bodyInfo.setCa_EnterprisesScale(qiyeguimo);
                qiyeshouciruzhu=tgv_firstin.getSelectcontent();
                bodyInfo.setCa_ForeignEnterprises(qiyeshouciruzhu);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info= JSONUtils.toString(bodyInfo);
                        Log.e("nine",info);
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(),info,"企业");


                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
            }
        });
    }


    /**
     * 展示添加的源数据
     */
    private List<String> enterpriselist;
    private List<String> enterprisesizelist;
    private List<String> firstinlist;
    private void initAddData(){
        enterpriselist=new ArrayList<>();
        enterpriselist.add("国企");
        enterpriselist.add("私企");
        enterpriselist.add("外企");
        enterpriselist.add("央企");
        enterpriselist.add("合资");
        enterpriselist.add("其他");

        enterprisesizelist=new ArrayList<>();
        enterprisesizelist.add("30人以下");
        enterprisesizelist.add("30-50人");
        enterprisesizelist.add("50-100人");
        enterprisesizelist.add("100人以上");

        firstinlist=new ArrayList<>();
        firstinlist.add("是");
        firstinlist.add("否");

        initShow();
    }

    /**
     * 展示添加的源数据
     */
    int enterprisem,enterprisesizem,firstinm;
    private void initShow() {
        tgv_enterprise.setTvType("企业性质");
        tgv_enterprise.setGvLines(4);
        tgv_enterprise.setGvData(getActivity(), enterpriselist);
        tgv_enterprise.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(enterprisem!=1){
                    enterprisem=1;
                    addMoney();
                }
                activity.savedatabean.setCa_EnterpriseNature(enterpriselist.get(position));
            }
        });

        tgv_enterprisesize.setTvType("企业规模");
        tgv_enterprisesize.setGvLines(4);
        tgv_enterprisesize.setGvData(getActivity(), enterprisesizelist);
        tgv_enterprisesize.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(enterprisesizem!=1){
                    enterprisesizem=1;
                    addMoney();
                }
                activity.savedatabean.setCa_EnterprisesScale(enterprisesizelist.get(position));
            }
        });

        tgv_firstin.setTvType("是否首次创业");
        tgv_firstin.setGvLines(4);
        tgv_firstin.setGvData(getActivity(), firstinlist);
        tgv_firstin.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(firstinm!=1){
                    firstinm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_ForeignEnterprises(firstinlist.get(position));
            }
        });

//        mPresenter.GetNewNine(clientInfo.getCi_rwdid());

        ShowView(lhousedata);

    }


    @Override
    protected NewNinePresenter onCreatePresenter() {
        return new NewNinePresenter(this);
    }

    NewNineInfo.BodyBean bodyInfo;
    @Override
    public void responseGetNewNine(NewNineInfo.BodyBean info) {
      bodyInfo=info;

        if (!info.getCa_EstablishmentTime().trim().isEmpty()){
            tvNewChenglishijian.setText(info.getCa_EstablishmentTime());
        }
        etNewJingyingfanwei.setText(info.getCa_BusinessScope());
        etNewQiyewenhua.setText(info.getCa_CorporateCulture());

        for (int i = 0; i < enterpriselist.size(); i++) {
            if(enterpriselist.get(i).equals(info.getCa_EnterpriseNature())){
                tgv_enterprise.setContents(info.getCa_EnterpriseNature(), i);
                break;
            }
        }

        for (int i = 0; i < enterprisesizelist.size(); i++) {
            if(enterprisesizelist.get(i).equals(info.getCa_EnterprisesScale())){
                tgv_enterprisesize.setContents(info.getCa_EnterprisesScale(), i);
                break;
            }
        }

        for (int i = 0; i < firstinlist.size(); i++) {
            if(firstinlist.get(i).equals(info.getCa_ForeignEnterprises())){
                tgv_firstin.setContents(info.getCa_ForeignEnterprises(), i);
                break;
            }
        }

//        switch (info.getCa_EnterpriseNature()){
//            case "国企":
//                rbNewQiyexingzhiGuoqi.setChecked(true);
//                break;
//            case "私企":
//                rbNewQiyexingzhiSiqi.setChecked(true);
//                break;
//            case "外企":
//                rbNewQiyexingzhiWaiqi.setChecked(true);
//                break;
//            case "央企":
//                rbNewQiyexingzhiYangqi.setChecked(true);
//                break;
//            case "合资":
//                rbNewQiyexingzhiHezi.setChecked(true);
//                break;
//            case "其他":
//                rbNewQiyexingzhiQita.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_EnterprisesScale()){
//            case "30人以下":
//                rbNewQiyeguimoSanshixia.setChecked(true);
//                break;
//            case "30-50人":
//                rbNewQiyeguimoSanshidaowushi.setChecked(true);
//                break;
//            case "50-100人":
//                rbNewQiyeguimoWushidaoyibai.setChecked(true);
//                break;
//            case "100人以上":
//                rbNewQiyeguimoYibaiyishang.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_ForeignEnterprises()){
//            case "是":
//                rbNewShouciruzhuShi.setChecked(true);
//                break;
//            case "否":
//                rbNewShouciruzhuFou.setChecked(true);
//                break;
//        }


    }

    @Override
    public void responseGetNewNineError(String msg) {
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

//    @Override
//    public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {
//
//        switch (checkedId) {
//            case R.id.rb_new_qiyeguimo_sanshixia:
//                qiyeguimo="30人以下";
//             break;
//            case R.id.rb_new_qiyeguimo_sanshidaowushi:
//
//                qiyeguimo="30-50人";
//                break;
//            case R.id.rb_new_qiyeguimo_wushidaoyibai:
//                qiyeguimo="50-100人";
//                break;
//            case R.id.rb_new_qiyeguimo_yibaiyishang:
//                qiyeguimo="100人以上";
//                break;
//
//            case R.id.rb_new_shouciruzhu_shi:
//                qiyeshouciruzhu="是";
//                break;
//            case R.id.rb_new_shouciruzhu_fou:
//                qiyeshouciruzhu="否";
//                break;
//        }
//    }

    //zidingyi
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        switch (checkedId) {
//            case R.id.rb_new_qiyexingzhi_guoqi:
//                qiyexingzhi = "国企";
//                break;
//            case R.id.rb_new_qiyexingzhi_siqi:
//                qiyexingzhi = "私企";
//                break;
//            case R.id.rb_new_qiyexingzhi_waiqi:
//                qiyexingzhi = "外企";
//                break;
//            case R.id.rb_new_qiyexingzhi_yangqi:
//                qiyexingzhi = "央企";
//                break;
//            case R.id.rb_new_qiyexingzhi_hezi:
//                qiyexingzhi = "合资";
//                break;
//            case R.id.rb_new_qiyexingzhi_qita:
//                qiyexingzhi = "其他";
//                break;
//
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



    private String fanwei="",companywenhua="";
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
                case R.id.et_new_jingyingfanwei:
                    editchanges(lengths,0);
                    if(lengths>0){
                        fanwei=edittext.getText().toString().trim();
                    }else{
                        fanwei="";
                    }
                    activity.savedatabean.setCa_BusinessScope(fanwei);
                    break;
                case R.id.et_new_qiyewenhua:
                    editchanges(lengths,1);
                    if(lengths>0){
                        companywenhua=edittext.getText().toString().trim();
                    }else{
                        companywenhua="";
                    }
                    activity.savedatabean.setCa_CorporateCulture(companywenhua);
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

    int jingyingfanweim,qiyewenhuam;

    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length,int type){
        if(length>0){
            switch (type){
                case 0:
                    if(jingyingfanweim!=1){
                        jingyingfanweim=1;
                        addMoney();
                    }
                    break;
                case 1:
                    if(qiyewenhuam!=1){
                        qiyewenhuam=1;
                        addMoney();
                    }
                    break;
            }
        }else{
            switch (type){
                case 0:
                    jingyingfanweim=0;
                    noaddMoney();
                    break;
                case 1:
                    qiyewenhuam=0;
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
