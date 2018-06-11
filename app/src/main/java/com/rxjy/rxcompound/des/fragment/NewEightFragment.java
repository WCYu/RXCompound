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
import com.rxjy.rxcompound.des.entity.NewEightInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewEightContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewEightPresenter;
import com.rxjy.rxcompound.widget.TextGridview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewEightFragment extends BaseFragment<NewEightPresenter> implements NewEightContract.View, View.OnClickListener{

    @Bind(R.id.et_new_kehuxingming)
    EditText etNewKehuxingming;

    //    @Bind(R.id.rb_new_xingbie_nan)
//    RadioButton rbNewXingbieNan;
//    @Bind(R.id.rb_new_xingbie_nv)
//    RadioButton rbNewXingbieNv;
//    @Bind(R.id.rg_new_xingbie)
//    RadioGroup rgNewXingbie;
//    @Bind(R.id.rb_new_hehuo_shi)
//    RadioButton rbNewHehuoShi;
//    @Bind(R.id.rb_new_hehuo_fou)
//    RadioButton rbNewHehuoFou;
//    @Bind(R.id.rg_new_hehuo)
//    RadioGroup rgNewHehuo;
//    @Bind(R.id.rb_new_shenfen_xingzheng)
//    RadioButton rbNewShenfenXingzheng;
//    @Bind(R.id.rb_new_shenfen_fuzong)
//    RadioButton rbNewShenfenFuzong;
//    @Bind(R.id.rb_new_shenfen_laoban)
//    RadioButton rbNewShenfenLaoban;
//    @Bind(R.id.rb_new_shenfen_fuzeren)
//    RadioButton rbNewShenfenFuzeren;
//    @Bind(R.id.rb_new_shenfen_laobanzhuli)
//    RadioButton rbNewShenfenLaobanzhuli;
//    @Bind(R.id.rb_new_shenfen_hehuoren)
//    RadioButton rbNewShenfenHehuoren;
//    @Bind(R.id.rb_new_shenfen_caiwu)
//    RadioButton rbNewShenfenCaiwu;
//    @Bind(R.id.rb_new_zhuzhong_xiaolv)
//    RadioButton rbNewZhuzhongXiaolv;
//    @Bind(R.id.rb_new_zhuzhong_xijie)
//    RadioButton rbNewZhuzhongXijie;
//    @Bind(R.id.rb_new_zhuzhong_jiage)
//    RadioButton rbNewZhuzhongJiage;
//    @Bind(R.id.rb_new_zhuzhong_sheji)
//    RadioButton rbNewZhuzhongSheji;
//    @Bind(R.id.rb_new_zhuzhong_zhiliang)
//    RadioButton rbNewZhuzhongZhiliang;
//    @Bind(R.id.rb_new_zhuzhong_gongqi)
//    RadioButton rbNewZhuzhongGongqi;
//    @Bind(R.id.rb_new_zhuzhong_shigongrenyuan)
//    RadioButton rbNewZhuzhongShigongrenyuan;
//    @Bind(R.id.rb_new_zhuzhong_gongsiguimo)
//    RadioButton rbNewZhuzhongGongsiguimo;
//    @Bind(R.id.rg_new_zhuzhong)
//    com.rxjy.des.widget.RadioGroup rgNewZhuzhong;
//    @Bind(R.id.rb_new_xingge_wenhe)
//    RadioButton rbNewXinggeWenhe;
//    @Bind(R.id.rb_new_xingge_jiqing)
//    RadioButton rbNewXinggeJiqing;
//    @Bind(R.id.rb_new_xingge_shijian)
//    RadioButton rbNewXinggeShijian;
//    @Bind(R.id.rb_new_xingge_chuimao)
//    RadioButton rbNewXinggeChuimao;
//    @Bind(R.id.rb_new_xingge_suixing)
//    RadioButton rbNewXinggeSuixing;
//    @Bind(R.id.rb_new_xingge_yongnaixin)
//    RadioButton rbNewXinggeYongnaixin;
//    @Bind(R.id.rb_new_xingge_qiangshi)
//    RadioButton rbNewXinggeQiangshi;
//    @Bind(R.id.rb_new_xingge_jixingzi)
//    RadioButton rbNewXinggeJixingzi;
//    @Bind(R.id.rb_new_xingge_manxingzi)
//    RadioButton rbNewXinggeManxingzi;
//    @Bind(R.id.rb_new_xingge_zuoshi)
//    RadioButton rbNewXinggeZuoshi;
//    @Bind(R.id.rb_new_xingge_shuanglang)
//    RadioButton rbNewXinggeShuanglang;
//    @Bind(R.id.rb_new_xingge_qianxu)
//    RadioButton rbNewXinggeQianxu;
//    @Bind(R.id.rb_new_xingge_zuoshixi)
//    RadioButton rbNewXinggeZuoshixi;
//    @Bind(R.id.rb_new_xingge_jiaoqing)
//    RadioButton rbNewXinggeJiaoqing;
//    @Bind(R.id.rb_new_xingge_moji)
//    RadioButton rbNewXinggeMoji;
//    @Bind(R.id.rb_new_xingge_qiangbi)
//    RadioButton rbNewXinggeQiangbi;
//    @Bind(R.id.rb_new_xingge_xuanze)
//    RadioButton rbNewXinggeXuanze;
//    @Bind(R.id.rg_new_xingge)
//    com.rxjy.des.widget.RadioGroup rgNewXingge;
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;
//    @Bind(R.id.rb_new_nianling_erdaosan)
//    RadioButton rbNewNianlingErdaosan;
//    @Bind(R.id.rb_new_nianling_sandaosi)
//    RadioButton rbNewNianlingSandaosi;
//    @Bind(R.id.rb_new_nianling_sidaowu)
//    RadioButton rbNewNianlingSidaowu;
//    @Bind(R.id.rb_new_nianling_wushang)
//    RadioButton rbNewNianlingWushang;
//    @Bind(R.id.rg_new_nianling)
//    RadioGroup rgNewNianling;
//    @Bind(R.id.rg_new_shenfen)
//    com.rxjy.des.widget.RadioGroup rgNewShenfen;

    @Bind(R.id.tgv_age)
    TextGridview tgv_age;
    @Bind(R.id.tgv_sex)
    TextGridview tgv_sex;
    @Bind(R.id.tgv_contract)
    TextGridview tgv_contract;
    @Bind(R.id.tgv_identity)
    TextGridview tgv_identity;
    @Bind(R.id.tgv_attention)
    TextGridview tgv_attention;
    @Bind(R.id.tgv_character)
    TextGridview tgv_character;

    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;

    int itemmoney=10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、

    //客户信息
    private AllClientNewBean.ClientNewBean clientInfo;

    private String kehuxingming;
    private String shenfen;
    private String xingbie;
    private String nianling;
    private String zhuzhong;
    private String hetongfuzeren;
    private String xingge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_eight;
    }

    DesDaiMeasureActivity activity;
    @Override
    protected void FragmentInitData() {

        //        itemmoney=clientInfo.getJDMoney()/94;
        activity = (DesDaiMeasureActivity) getActivity();

        etNewKehuxingming.addTextChangedListener(new MyEditListener(etNewKehuxingming));

        initAddData();

        btnDesDaiMeasureSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kehuxingming = etNewKehuxingming.getText().toString().trim();
                bodyInfo.setCi_proHead(kehuxingming);

                String age = tgv_age.getSelectcontent();
                if (age != null && age.length() > 0) {
                    for (int i = 0; i < agelist.size(); i++) {
                        if (age.equals(agelist.get(i))) {
                            nianling = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCi_proAge(nianling);

                String sex = tgv_sex.getSelectcontent();
                if (sex != null && sex.length() > 0) {
                    for (int i = 0; i < sexlist.size(); i++) {
                        if (sex.equals(sexlist.get(i))) {
                            xingbie = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCi_proSex(xingbie);


                String contract = tgv_contract.getSelectcontent();
                if (contract != null && contract.length() > 0) {
                    for (int i = 0; i < contractlist.size(); i++) {
                        if (contract.equals(contractlist.get(i))) {
                            hetongfuzeren = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_ContractPerson(hetongfuzeren);

                String identity = tgv_identity.getSelectcontent();
                if (identity != null && identity.length() > 0) {
                    for (int i = 0; i < identitylist.size(); i++) {
                        if (identity.equals(identitylist.get(i))) {
                            shenfen = i + 1 + "";
                            break;
                        }
                    }
                }
                bodyInfo.setCa_proHeadIdentity(shenfen);

                zhuzhong= tgv_attention.getSelectcontent();
                bodyInfo.setCa_NoteFocus(zhuzhong);

                xingge = tgv_character.getSelectcontent();
                bodyInfo.setCa_proHeadCharacter(xingge);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info = JSONUtils.toString(bodyInfo);
                        Log.e("neweight", info);
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(),info,"客户");


                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();

            }
        });
//        rgNewShenfen.setOnCheckedChangeListener(this);
//        rgNewXingbie.setOnCheckedChangeListener(this);
//        rgNewNianling.setOnCheckedChangeListener(this);
//        rgNewZhuzhong.setOnCheckedChangeListener(this);
//        rgNewHehuo.setOnCheckedChangeListener(this);
//        rgNewXingge.setOnCheckedChangeListener(this);
    }

    /**
     * 展示添加的源数据
     */
    private List<String> agelist;
    private List<String> sexlist;
    private List<String> contractlist;
    private List<String> identitylist;
    private List<String> attentionlist;
    private List<String> characterlist;
    private void initAddData() {
        agelist = new ArrayList<>();
        agelist.add("20-30岁");
        agelist.add("30-40岁");
        agelist.add("40-50岁");
        agelist.add("50岁以上");

        sexlist = new ArrayList<>();
        sexlist.add("男");
        sexlist.add("女");

        contractlist = new ArrayList<>();
        contractlist.add("是");
        contractlist.add("否");

        identitylist = new ArrayList<>();
        identitylist.add("行政");
        identitylist.add("副总");
        identitylist.add("老板");
        identitylist.add("负责人");
        identitylist.add("老板助理");
        identitylist.add("合伙人");
        identitylist.add("财务");

        attentionlist = new ArrayList<>();
        attentionlist.add("团队");
        attentionlist.add("平台");
        attentionlist.add("细节");
        attentionlist.add("价格");
        attentionlist.add("设计");
        attentionlist.add("施工工艺");
        attentionlist.add("为人处事");

        characterlist = new ArrayList<>();
        characterlist.add("温和");
        characterlist.add("暴躁");
        characterlist.add("强势");
        characterlist.add("随性");
        characterlist.add("急性子");
        characterlist.add("慢性子");
        characterlist.add("矫情");
        characterlist.add("纠结");
        initShow();
    }

    /**
     * 展示添加的源数据
     */
    int agem,sexm,contractm,identitym,attentionm,characterm;
    private void initShow() {
        tgv_age.setTvType("年龄");
        tgv_age.setGvLines(4);
        tgv_age.setGvData(getActivity(), agelist);
        tgv_age.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(agem!=1){
                    agem=1;
                    addMoney();
                }
                activity.savedatabean.setCi_proAge(position+1+"");
            }
        });

        tgv_sex.setTvType("性别");
        tgv_sex.setGvLines(4);
        tgv_sex.setGvData(getActivity(), sexlist);
        tgv_sex.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(sexm!=1){
                    sexm=1;
                    addMoney();
                }
                activity.savedatabean.setCi_proSex(position+1+"");
            }
        });

        tgv_contract.setTvType("合同负责人");
        tgv_contract.setGvLines(4);
        tgv_contract.setGvData(getActivity(), contractlist);
        tgv_contract.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(contractm!=1){
                    contractm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_ContractPerson(position+1+"");
            }
        });

        tgv_identity.setTvType("身份");
        tgv_identity.setGvLines(4);
        tgv_identity.setGvData(getActivity(), identitylist);
        tgv_identity.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(identitym!=1){
                    identitym=1;
                    addMoney();
                }
                activity.savedatabean.setCa_proHeadIdentity(position+1+"");
            }
        });

        tgv_attention.setTvType("注重");
        tgv_attention.setGvLines(4);
        tgv_attention.setGvData(getActivity(), attentionlist);
        tgv_attention.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(attentionm!=1){
                    attentionm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_NoteFocus(attentionlist.get(position));
            }
        });

        tgv_character.setTvType("性格");
        tgv_character.setGvLines(4);
        tgv_character.setGvData(getActivity(), characterlist);
        tgv_character.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//改变钱数
                if(characterm!=1){
                    characterm=1;
                    addMoney();
                }
                activity.savedatabean.setCa_proHeadCharacter(characterlist.get(position));
            }
        });

//        mPresenter.GetNewEight(clientInfo.getCi_rwdid());
        ShowView(lhousedata);
    }


    @Override
    protected NewEightPresenter onCreatePresenter() {
        return new NewEightPresenter(this);
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
        if(!StringUtils.isEmpty(info.getCi_proHead())){
            kehuxingmingm=1;
            etNewKehuxingming.setText(info.getCi_proHead());
        }

        if(info.getCi_proAge()!=null&&info.getCi_proAge().length()>0){
            agem=1;
            int position = Integer.parseInt(info.getCi_proAge());
            tgv_age.setContents(agelist.get(position - 1), position - 1);
        }

        if(info.getCi_proSex()!=null&&info.getCi_proSex().length()>0){
            sexm=1;
            int position = Integer.parseInt(info.getCi_proSex());
            tgv_sex.setContents(sexlist.get(position - 1), position - 1);
        }

        if(info.getCa_ContractPerson()!=null&&info.getCa_ContractPerson().length()>0){
            contractm=1;
            int position = Integer.parseInt(info.getCa_ContractPerson());
            tgv_contract.setContents(contractlist.get(position - 1), position - 1);
        }

        if(info.getCa_proHeadIdentity()!=null&&info.getCa_proHeadIdentity().length()>0){
            identitym=1;
            int position = Integer.parseInt(info.getCa_proHeadIdentity());
            tgv_identity.setContents(identitylist.get(position - 1), position - 1);
        }

        if(!StringUtils.isEmpty(info.getCa_NoteFocus())){
            attentionm=1;
            for (int i = 0; i < attentionlist.size(); i++) {
                if(attentionlist.get(i).equals(info.getCa_NoteFocus())){
                    tgv_attention.setContents(info.getCa_NoteFocus(), i);
                    break;
                }
            }
        }

        if(!StringUtils.isEmpty(info.getCa_proHeadCharacter())){
            characterm=1;
            for (int i = 0; i < characterlist.size(); i++) {
                if(characterlist.get(i).equals(info.getCa_proHeadCharacter())){
                    tgv_character.setContents(info.getCa_proHeadCharacter(), i);
                    break;
                }
            }
        }

    }


    @Override
    public void onClick(View v) {

    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        switch (checkedId) {
//            case R.id.rb_new_xingbie_nan:
//                xingbie = "1";
//                break;
//            case R.id.rb_new_xingbie_nv:
//                xingbie = "2";
//                break;
//
//            case R.id.rb_new_nianling_erdaosan:
//                nianling = "1";
//                break;
//            case R.id.rb_new_nianling_sandaosi:
//                nianling = "2";
//                break;
//            case R.id.rb_new_nianling_sidaowu:
//                nianling = "3";
//                break;
//            case R.id.rb_new_nianling_wushang:
//                nianling = "4";
//                break;
//
//            case R.id.rb_new_hehuo_shi:
//                hetongfuzeren = "1";
//                break;
//            case R.id.rb_new_hehuo_fou:
//                hetongfuzeren = "2";
//                break;
//        }
//    }

    NewEightInfo.BodyBean bodyInfo;

    @Override
    public void responseGetNewEight(NewEightInfo.BodyBean info) {
        bodyInfo = info;
        Log.e("eight", "eight");
        Log.e("eight", info.getCi_proHead());
        etNewKehuxingming.setText(info.getCi_proHead());

        if(info.getCi_proAge()!=null&&info.getCi_proAge().length()>0){
            int position = Integer.parseInt(info.getCi_proAge());
            tgv_age.setContents(agelist.get(position - 1), position - 1);
        }

        if(info.getCi_proSex()!=null&&info.getCi_proSex().length()>0){
            int position = Integer.parseInt(info.getCi_proSex());
            tgv_sex.setContents(sexlist.get(position - 1), position - 1);
        }

        if(info.getCa_ContractPerson()!=null&&info.getCa_ContractPerson().length()>0){
            int position = Integer.parseInt(info.getCa_ContractPerson());
            tgv_contract.setContents(contractlist.get(position - 1), position - 1);
        }

        if(info.getCa_proHeadIdentity()!=null&&info.getCa_proHeadIdentity().length()>0){
            int position = Integer.parseInt(info.getCa_proHeadIdentity());
            tgv_identity.setContents(identitylist.get(position - 1), position - 1);
        }

        for (int i = 0; i < attentionlist.size(); i++) {
            if(attentionlist.get(i).equals(info.getCa_NoteFocus())){
                tgv_attention.setContents(info.getCa_NoteFocus(), i);
                break;
            }
        }

        for (int i = 0; i < characterlist.size(); i++) {
            if(characterlist.get(i).equals(info.getCa_proHeadCharacter())){
                tgv_character.setContents(info.getCa_proHeadCharacter(), i);
                break;
            }
        }


//        switch(info.getCa_proHeadIdentity()){
//            case "1":
//                rbNewShenfenXingzheng.setChecked(true);
//                break;
//            case "2":
//                rbNewShenfenFuzong.setChecked(true);
//                break;
//            case "3":
//                rbNewShenfenLaoban.setChecked(true);
//                break;
//            case "4":
//                rbNewShenfenFuzeren.setChecked(true);
//                break;
//            case "5":
//                rbNewShenfenLaobanzhuli.setChecked(true);
//                break;
//            case "6":
//                rbNewShenfenHehuoren.setChecked(true);
//                break;
//            case "7":
//                rbNewShenfenCaiwu.setChecked(true);
//                break;
//        }
//        switch (info.getCi_proSex()){
//            case "1":
//                rbNewXingbieNan.setChecked(true);
//                break;
//            case "2":
//                rbNewXingbieNv.setChecked(true);
//                break;
//        }
//        switch (info.getCi_proAge()){
//            case "1":
//                rbNewNianlingErdaosan.setChecked(true);
//                break;
//            case "2":
//                rbNewNianlingSandaosi.setChecked(true);
//                break;
//            case "3":
//                rbNewNianlingSidaowu.setChecked(true);
//                break;
//            case "4":
//                rbNewNianlingWushang.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_NoteFocus()){
//            case "效率":
//                rbNewZhuzhongXiaolv.setChecked(true);
//                break;
//            case "细节":
//                rbNewZhuzhongXijie.setChecked(true);
//                break;
//            case "价格":
//                rbNewZhuzhongJiage.setChecked(true);
//                break;
//            case "设计":
//                rbNewZhuzhongSheji.setChecked(true);
//                break;
//            case "质量":
//                rbNewZhuzhongZhiliang.setChecked(true);
//                break;
//            case "工期":
//                rbNewZhuzhongGongqi.setChecked(true);
//                break;
//            case "施工人员":
//                rbNewZhuzhongShigongrenyuan.setChecked(true);
//                break;
//            case "公司规模":
//                rbNewZhuzhongGongsiguimo.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_ContractPerson()){
//            case "1":
//                rbNewHehuoShi.setChecked(true);
//            break;
//            case "2":
//                rbNewHehuoFou.setChecked(true);
//                break;
//        }
//
//        switch (info.getCa_proHeadCharacter()){
//            case "温和":
//                rbNewXinggeWenhe.setChecked(true);
//                break;
//            case "激情饱满":
//                rbNewXinggeJiqing.setChecked(true);
//                break;
//            case "时间观念强":
//                rbNewXinggeShijian.setChecked(true);
//                break;
//            case "吹毛求疵":
//                rbNewXinggeChuimao.setChecked(true);
//                break;
//            case "随性":
//                rbNewXinggeSuixing.setChecked(true);
//                break;
//            case "有耐心":
//                rbNewXinggeYongnaixin.setChecked(true);
//                break;
//            case "强势":
//                rbNewXinggeQiangshi.setChecked(true);
//                break;
//            case "急性子":
//                rbNewXinggeJixingzi.setChecked(true);
//                break;
//            case "慢性子":
//                rbNewXinggeManxingzi.setChecked(true);
//                break;
//            case "做事认真":
//                rbNewXinggeZuoshi.setChecked(true);
//                break;
//            case "爽朗":
//                rbNewXinggeShuanglang.setChecked(true);
//                break;
//            case "谦虚、实干":
//                rbNewXinggeQianxu.setChecked(true);
//                break;
//            case "做细事":
//                rbNewXinggeZuoshixi.setChecked(true);
//                break;
//            case "矫情":
//                rbNewXinggeJiaoqing.setChecked(true);
//                break;
//            case "墨迹纠结":
//                rbNewXinggeMoji.setChecked(true);
//                break;
//            case "强逼症":
//                rbNewXinggeQiangbi.setChecked(true);
//                break;
//            case "选择困难症":
//                rbNewXinggeXuanze.setChecked(true);
//                break;
//        }

    }

    @Override
    public void responseGetNewEightError(String msg) {
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

    //zidingyi
//    @Override
//    public void onCheckedChanged(com.rxjy.des.widget.RadioGroup group, int checkedId) {
//        switch (checkedId) {
//            case R.id.rb_new_zhuzhong_xiaolv:
//                zhuzhong = "效率";
//                break;
//            case R.id.rb_new_zhuzhong_xijie:
//                zhuzhong = "细节";
//                break;
//            case R.id.rb_new_zhuzhong_jiage:
//                zhuzhong = "价格";
//                break;
//            case R.id.rb_new_zhuzhong_sheji:
//                zhuzhong = "设计";
//                break;
//            case R.id.rb_new_zhuzhong_zhiliang:
//                zhuzhong = "质量";
//                break;
//            case R.id.rb_new_zhuzhong_gongqi:
//                zhuzhong = "工期";
//                break;
//            case R.id.rb_new_zhuzhong_shigongrenyuan:
//                zhuzhong = "施工人员";
//                break;
//            case R.id.rb_new_zhuzhong_gongsiguimo:
//                zhuzhong = "公司规模";
//                break;
//
//            case R.id.rb_new_xingge_wenhe:
//                xingge = "温和";
//                break;
//            case R.id.rb_new_xingge_jiqing:
//                xingge = "激情饱满";
//                break;
//            case R.id.rb_new_xingge_shijian:
//                xingge = "时间观念强";
//                break;
//            case R.id.rb_new_xingge_chuimao:
//                xingge = "吹毛求疵";
//                break;
//            case R.id.rb_new_xingge_suixing:
//                xingge = "随性";
//                break;
//            case R.id.rb_new_xingge_yongnaixin:
//                xingge = "有耐心";
//                break;
//            case R.id.rb_new_xingge_qiangshi:
//                xingge = "强势";
//                break;
//            case R.id.rb_new_xingge_jixingzi:
//                xingge = "急性子";
//                break;
//            case R.id.rb_new_xingge_manxingzi:
//                xingge = "慢性子";
//                break;
//            case R.id.rb_new_xingge_zuoshi:
//                xingge = "做事认真";
//                break;
//            case R.id.rb_new_xingge_shuanglang:
//                xingge = "爽朗";
//                break;
//            case R.id.rb_new_xingge_qianxu:
//                xingge = "谦虚、实干";
//                break;
//            case R.id.rb_new_xingge_zuoshixi:
//                xingge = "做细事";
//                break;
//            case R.id.rb_new_xingge_jiaoqing:
//                xingge = "矫情";
//                break;
//            case R.id.rb_new_xingge_moji:
//                xingge = "墨迹纠结";
//                break;
//            case R.id.rb_new_xingge_qiangbi:
//                xingge = "强逼症";
//                break;
//            case R.id.rb_new_xingge_xuanze:
//                xingge = "选择困难症";
//                break;
//
//            case R.id.rb_new_shenfen_xingzheng:
//                shenfen = "1";
//                break;
//            case R.id.rb_new_shenfen_fuzong:
//                shenfen = "2";
//                break;
//            case R.id.rb_new_shenfen_laoban:
//                shenfen = "3";
//                break;
//            case R.id.rb_new_shenfen_fuzeren:
//                shenfen = "4";
//                break;
//            case R.id.rb_new_shenfen_laobanzhuli:
//                shenfen = "5";
//                break;
//            case R.id.rb_new_shenfen_hehuoren:
//                shenfen = "6";
//                break;
//            case R.id.rb_new_shenfen_caiwu:
//                shenfen = "7";
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


    private String customername="";
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
                case R.id.et_new_kehuxingming:
                    editchanges(lengths,0);
                    if(lengths>0){
                        customername=edittext.getText().toString().trim();
                    }else{
                        customername="";
                    }
                    activity.savedatabean.setCi_proHead(customername);
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

    int kehuxingmingm;

    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length,int type){
        Log.e("length"+length,"type"+type);
        if(length>0){
            switch (type){
                case 0:
                    if(kehuxingmingm!=1){
                        kehuxingmingm=1;
                        addMoney();
                    }
                    break;
            }
        }else{
            switch (type){
                case 0:
                    kehuxingmingm=0;
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
