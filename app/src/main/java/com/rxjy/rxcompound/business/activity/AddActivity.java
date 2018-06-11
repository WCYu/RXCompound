package com.rxjy.rxcompound.business.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.AddressBean;
import com.rxjy.rxcompound.business.entity.AgeBean;
import com.rxjy.rxcompound.business.entity.IndustryBean;
import com.rxjy.rxcompound.business.entity.MessageCustomerBean;
import com.rxjy.rxcompound.business.entity.MessageHouseBean;
import com.rxjy.rxcompound.business.entity.PersonPhoneBean;
import com.rxjy.rxcompound.business.fragment.CustomerFragment;
import com.rxjy.rxcompound.business.mvp.contract.AddContract;
import com.rxjy.rxcompound.business.mvp.presenter.AddPresenter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/12/1.
 */

public class AddActivity extends BaseActivity<AddPresenter> implements AddContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_change)
    ImageView ivChange;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.ed_name)
    EditText edName;
    @Bind(R.id.ed_phone)
    EditText edPhone;
    @Bind(R.id.ed_area)
    EditText edArea;
    @Bind(R.id.tv_jobtype)
    TextView tvJobtype;
    @Bind(R.id.ed_personphone)
    EditText edPersonphone;
    @Bind(R.id.tv_housefrom)
    TextView tvHousefrom;
    @Bind(R.id.ed_company)
    EditText edCompany;
    @Bind(R.id.tv_identity)
    TextView tvIdentity;
    @Bind(R.id.tv_attention)
    TextView tvAttention;
    @Bind(R.id.ll_attention)
    LinearLayout llAttention;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_house)
    TextView tvHouse;
    @Bind(R.id.tv_transacttype)
    TextView tvTransacttype;
    @Bind(R.id.tv_zutype)
    TextView tvZutype;
    @Bind(R.id.tv_submithousetime)
    TextView tvSubmithousetime;
    @Bind(R.id.ed_lhouseaddress)
    EditText edLhouseaddress;
    @Bind(R.id.tv_need)
    TextView tvNeed;
    @Bind(R.id.ll_need)
    LinearLayout llNeed;
    @Bind(R.id.tv_pattribute)
    TextView tvPattribute;
    @Bind(R.id.ed_yutime)
    EditText edYutime;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_lhousetime)
    TextView tvLhousetime;
    @Bind(R.id.tv_scale)
    TextView tvScale;
    @Bind(R.id.tv_save)
    TextView tvSave;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;
    @Bind(R.id.ll_customer)
    LinearLayout llCustomer;
    @Bind(R.id.ll_lhouse)
    LinearLayout llLhouse;
    @Bind(R.id.v_address)
    View vAddress;
    @Bind(R.id.v_name)
    View vName;
    @Bind(R.id.v_phone)
    View vPhone;
    @Bind(R.id.v_area)
    View vArea;
    @Bind(R.id.v_jobtype)
    View vJobtype;
    @Bind(R.id.v_personphone)
    View vPersonphone;
    @Bind(R.id.v_housefrom)
    View vHousefrom;
    @Bind(R.id.v_company)
    View vCompany;
    @Bind(R.id.v_identity)
    View vIdentity;
    @Bind(R.id.v_attention)
    View vAttention;
    @Bind(R.id.v_age)
    View vAge;
    @Bind(R.id.v_sex)
    View vSex;
    @Bind(R.id.v_house)
    View vHouse;
    @Bind(R.id.v_transtype)
    View vTranstype;
    @Bind(R.id.v_zutype)
    View vZutype;
    @Bind(R.id.v_submithousetime)
    View vSubmithousetime;
    @Bind(R.id.v_lhouseaddress)
    View vLhouseaddress;///////////
    @Bind(R.id.v_need)
    View vNeed;
    @Bind(R.id.v_pattribute)
    View vPattribute;
    @Bind(R.id.v_yu)
    View vYu;//////////
    @Bind(R.id.v_time)
    View vTime;
    @Bind(R.id.v_lhousetime)
    View vLhousetime;
    @Bind(R.id.v_scale)
    View vScale;
    private OptionsPickerView pVaddress, pVIndustry, pVHousefrom, pVAge, pVSex,
            pVIdentity, pVAttention, pVHouse, pVTransacttype, pVZutype, pVNeed,
            pVAttribute, pVScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_messageadd;
    }

    ArrayList<String> housefromlist, sexlist, houselist, transtypelist, zutypelist, needlist, attributelist, scalelist;
    String department, cardno;

    String customerbaseid = null;

    int isedit;

    @Override
    public void initData() {
        tvSubmit.setVisibility(View.GONE);
//        SharedPreferences sp = getSharedPreferences("rxsw_userdatas", Activity.MODE_PRIVATE);
//        department = sp.getString("rxsw_addressname", null);
//        cardno = sp.getString("rxsw_cardno", null);
        cardno= App.cardNo;
       // department=App.postName;
        department= App.regionname;
        mPresenter.getAddress(department);
        mPresenter.getIndustryType("2");
        mPresenter.getAge();
        mPresenter.getIdentity();
        mPresenter.getAttention();
        addData();
        Intent intent = getIntent();
        customerbaseid = intent.getStringExtra("customerbaseid");
        if (customerbaseid != null) {
            isedit = 1;
            tvTitle.setText("详情");
            int id = Integer.parseInt(customerbaseid);
            //设置异地、手机号、信电不可编辑
            llAddress.setEnabled(false);
            edPhone.setEnabled(false);
            edPersonphone.setEnabled(false);
            mPresenter.getCustomerMessage(id, 1);
            mPresenter.getCustomerMessage(id, 2);
        } else {
            tvTitle.setText("新增");
        }
//        edPhone.addTextChangedListener(new MyEditListener(edPhone));
        edPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vPhone.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColor(0);
                } else {
                    vPhone.setBackgroundColor(getResources().getColor(R.color.appbg));
                    phone = edPhone.getText().toString();
                    if (isedit != 1 && phone != null && phone.length() > 0) {
                        mPresenter.getCustomerPhone(phone);
                    }
                }
            }
        });
        edName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vName.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColor(0);
                } else {
                    vName.setBackgroundColor(getResources().getColor(R.color.appbg));
                }
            }
        });
        edArea.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vArea.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColor(0);
                } else {
                    vArea.setBackgroundColor(getResources().getColor(R.color.appbg));
                }
            }
        });
        edPersonphone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vPersonphone.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColor(0);
                } else {
                    vPersonphone.setBackgroundColor(getResources().getColor(R.color.appbg));
                }
            }
        });
        edCompany.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vCompany.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColor(0);
                } else {
                    vCompany.setBackgroundColor(getResources().getColor(R.color.appbg));
                }
            }
        });
        edLhouseaddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vLhouseaddress.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColorLhouse(0);
                } else {
                    vLhouseaddress.setBackgroundColor(getResources().getColor(R.color.appbg));
                }
            }
        });
        edYutime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    vYu.setBackgroundColor(getResources().getColor(R.color.lineorange));
                    setLineColorLhouse(0);
                } else {
                    vYu.setBackgroundColor(getResources().getColor(R.color.appbg));
                }
            }
        });
    }


    /**
     * 添加数据
     */
    private void addData() {
        housefromlist = new ArrayList<>();//房源
        housefromlist.add("已定");
        housefromlist.add("未定");
        sexlist = new ArrayList<>();//性别
        sexlist.add("男");
        sexlist.add("女");
        houselist = new ArrayList<>();//房屋
        houselist.add("毛坯房");
        houselist.add("清水房");
        houselist.add("精装房");
        houselist.add("翻新");
        houselist.add("旧房改造");
        transtypelist = new ArrayList<>();//成交类型
        transtypelist.add("租");
        transtypelist.add("买");
        transtypelist.add("自建");
        zutypelist = new ArrayList<>();//免租
        zutypelist.add("一个月");
        zutypelist.add("1-2月");
        zutypelist.add("2月以上");
        needlist = new ArrayList<>();//装修需求
        needlist.add("基础装修");
        needlist.add("二次改造");
        needlist.add("精装修");
        needlist.add("局部改造");
        needlist.add("无法确定");
        attributelist = new ArrayList<>();//项目属性
        attributelist.add("正常单");
        attributelist.add("平面图报价");
        attributelist.add("全套图纸（含效果图）报价");
        attributelist.add("报价清单报价");
        scalelist = new ArrayList<>();//规模
        scalelist.add("30人以下");
        scalelist.add("30-50人");
        scalelist.add("50-100人");
        scalelist.add("100人以上");
    }

    @Override
    protected AddPresenter onCreatePresenter() {
        return new AddPresenter(this);
    }

    /**
     * 地点选择
     */
    ArrayList<String> addresslist;
    ArrayList<Integer> addressidlist;
    private AddressBean addressdata;

    @Override
    public void responsegetAddress(AddressBean data) {
        addressdata = data;
        addresslist = new ArrayList<>();
        addressidlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            addresslist.add(data.getBody().get(i).getName());
            addressidlist.add(data.getBody().get(i).getFenGongSiID());
        }
    }

    @Override
    public void responsegetAddressError(String msg) {

    }

    /**
     * 行业类型的数据
     */
    List<String> industryfulist;
    List<List<String>> industryzilist;
    List<IndustryBean.BodyBean.CusTomerBean> industrylist;
    private IndustryBean hangyetype;

    @Override
    public void responsegetIndustryType(IndustryBean data) {
        hangyetype = data;
        industryfulist = new ArrayList<>();
        industryzilist = new ArrayList<>();
        industrylist = new ArrayList<>();
        industrylist.addAll(data.getBody().getCusTomer());
        for (IndustryBean.BodyBean.CusTomerBean customerbean : data.getBody().getCusTomer()) {
            industryfulist.add(customerbean.getMingCheng());
            List<String> child = new ArrayList<>();
            for (IndustryBean.BodyBean.CusTomerBean.ChildCusTomerBean childbean : customerbean.getZiji()) {
                child.add(childbean.getMingCheng());
            }
            industryzilist.add(child);
        }
    }

    @Override
    public void responsegetIndustryTypeError(String msg) {

    }


    /**
     * 年龄范围
     */
    ArrayList<String> agelist;
    ArrayList<Integer> ageidlist;
    private AgeBean agedata;

    @Override
    public void responsegetgetAge(AgeBean data) {
        agedata = data;
        agelist = new ArrayList<>();
        ageidlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            agelist.add(data.getBody().get(i).getMingCheng());
            ageidlist.add(data.getBody().get(i).getID());
        }
    }

    @Override
    public void responsegetgetAgeError(String msg) {

    }


    /**
     * 身份
     */
    ArrayList<String> identitylist;
    ArrayList<Integer> identityidlist;
    private AgeBean identitydata;

    @Override
    public void responsegetgetIdentity(AgeBean data) {
        identitydata = data;
        identitylist = new ArrayList<>();
        identityidlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            identitylist.add(data.getBody().get(i).getMingCheng());
            identityidlist.add(data.getBody().get(i).getID());
        }
    }


    /**
     * 注重
     */
    ArrayList<String> attentionlist;
    ArrayList<Integer> attentionidlist;
    private AgeBean attentiondata;

    @Override
    public void responsegetgetAttention(AgeBean data) {
        attentiondata = data;
        attentionlist = new ArrayList<>();
        attentionidlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            attentionlist.add(data.getBody().get(i).getMingCheng());
            attentionidlist.add(data.getBody().get(i).getID());
        }
    }

    @Override
    public void responseSaveCustomer() {
        //返回刷新数据
        showToast("保存成功");
        CustomerFragment.instance.ischange = "1";
    }

    @Override
    public void responseSaveCustomerError(String msg) {
        Log.e("2", "吐司2");
        showToast(msg);
    }

    @Override
    public void responseAddCustomer(String kahao) {
        showToast("保存成功");
        CustomerFragment.instance.ischange = "1";
        //得到卡号并设置量房可点击
        isedit = 1;
        customerbaseid = kahao;
    }

    @Override
    public void responseSaveMessage() {//保存或提交量房信息
        //刷新数据
        showToast("保存成功");
        CustomerFragment.instance.ischange = "1";
        finish();
    }

    @Override
    public void responseSaveMessageError(String msg) {
        Log.e("1", "吐司1");
        showToast(msg);
    }

    /**
     * 展示客户数据
     *
     * @param data
     */
    @Override
    public void responseCustomerMessage(MessageCustomerBean data) {
        //异地
        addressid = data.getBody().getFenGongSiID();
        for (int i = 0; i < addressdata.getBody().size(); i++) {
            if (data.getBody().getFenGongSiID() == addressdata.getBody().get(i).getFenGongSiID()) {
                tvAddress.setText(addressdata.getBody().get(i).getName());
                tvAddress.setTextColor(this.getResources().getColor(R.color.textblack));
            }
        }
        if (!StringUtils.isEmpty(data.getBody().getXingMing())) {//姓名
            edName.setText(data.getBody().getXingMing());
        }
        if (!StringUtils.isEmpty(data.getBody().getShouJiHaoYi())) {//手机号
            edPhone.setText(data.getBody().getShouJiHaoYi());
        }
        if (!StringUtils.isEmpty(data.getBody().getMianJi())) {//面积
            edArea.setText(data.getBody().getMianJi() + "");
        }
        if (!StringUtils.isEmpty(data.getBody().getPhone())) {//信电
            edPersonphone.setText(data.getBody().getPhone());
        }
        if (!StringUtils.isEmpty(data.getBody().getGongSiMingCheng())) {//公司
            edCompany.setText(data.getBody().getGongSiMingCheng());
        }
        housefrom = data.getBody().getFangYuan();
        switch (housefrom) {
            case 1:
                tvHousefrom.setText("已定");
                tvHousefrom.setTextColor(this.getResources().getColor(R.color.textblack));
                break;
            case 2:
                tvHousefrom.setText("未定");
                tvHousefrom.setTextColor(this.getResources().getColor(R.color.textblack));
                break;
        }
        type1 = data.getBody().getLeiXingYi();
        type2 = data.getBody().getLeiXingEr();
        Log.e("type1+;;" + type1, "type2=;;" + type2);
        for (int i = 0; i < hangyetype.getBody().getCusTomer().size(); i++) {
            if (type1 == hangyetype.getBody().getCusTomer().get(i).getID()) {
                Log.e("相等了？？！", "2121212");
                tvJobtype.setText(hangyetype.getBody().getCusTomer().get(i).getMingCheng());
                tvJobtype.setTextColor(this.getResources().getColor(R.color.textblack));
                for (int j = 0; j < hangyetype.getBody().getCusTomer().get(i).getZiji().size(); j++) {
                    if (type2 == hangyetype.getBody().getCusTomer().get(i).getZiji().get(j).getID()) {
                        tvJobtype.setText(hangyetype.getBody().getCusTomer().get(i).getMingCheng() + "-" +
                                hangyetype.getBody().getCusTomer().get(i).getZiji().get(j).getMingCheng());
                        break;
                    }
                }
            }
        }
    }

    /**
     * 展示量房数据
     */
    @Override
    public void responseHouseMessage(MessageHouseBean data) {
        //身份
        identity = data.getBody().getShenFenID();
        Log.e("shenfen ", identity + "");
        if (identitydata != null) {
            for (int i = 0; i < identitydata.getBody().size(); i++) {
                if (identity == identitydata.getBody().get(i).getID()) {
                    Log.e("显示啊 ？？？", "kakak");
                    tvIdentity.setText(identitydata.getBody().get(i).getMingCheng());
                    tvIdentity.setTextColor(this.getResources().getColor(R.color.textblack));
                    break;
                }
            }
        }
        //注重
        attention = data.getBody().getZhuZhongDianID();
        if (attentiondata != null) {
            for (int i = 0; i < attentiondata.getBody().size(); i++) {
                if (attention == attentiondata.getBody().get(i).getID()) {
                    tvAttention.setText(attentiondata.getBody().get(i).getMingCheng());
                    tvAttention.setTextColor(this.getResources().getColor(R.color.textblack));
                }
            }
        }
        //年龄
        age = data.getBody().getNianLingID();
        Log.e("年龄，，，", age + "");
        if (agedata != null) {
            for (int i = 0; i < agedata.getBody().size(); i++) {
                if (age == agedata.getBody().get(i).getID()) {
                    tvAge.setText(agedata.getBody().get(i).getMingCheng());
                    tvAge.setTextColor(this.getResources().getColor(R.color.textblack));
                }
            }
        }
        sex = data.getBody().getXingBie();
        if (sexlist != null && sex != 0) {
            tvSex.setText(sexlist.get(sex - 1));
            tvSex.setTextColor(this.getResources().getColor(R.color.textblack));
        }
        house = data.getBody().getYuJiZhuangXiu();
        if (houselist != null && house != 0) {
            if (house < 5) {
                tvHouse.setText(houselist.get(house - 1));
                tvHouse.setTextColor(this.getResources().getColor(R.color.textblack));
            } else {
                tvHouse.setText(houselist.get(house - 2));
                tvHouse.setTextColor(this.getResources().getColor(R.color.textblack));
            }

        }
        saletype = data.getBody().getChengJiaoLeiXing();
        if (transtypelist != null && saletype != 0) {
            tvTransacttype.setText(transtypelist.get(saletype - 1));
            tvTransacttype.setTextColor(this.getResources().getColor(R.color.textblack));
        }
        mianzu = data.getBody().getMianZuQi();
        if (zutypelist != null && mianzu != 0) {
            tvZutype.setText(zutypelist.get(mianzu - 1));
            tvZutype.setTextColor(this.getResources().getColor(R.color.textblack));
        }
        need = data.getBody().getZhuangXiuXuQiu();
        if (needlist != null && need != 0) {
            tvNeed.setText(needlist.get(need - 1));
            tvNeed.setTextColor(this.getResources().getColor(R.color.textblack));
        }
        attribute = data.getBody().getXiangMuShuXing();
        if (attributelist != null && attribute != 0) {
            tvPattribute.setText(attributelist.get(attribute - 1));
            tvPattribute.setTextColor(this.getResources().getColor(R.color.textblack));
        }
        scale = data.getBody().getQiYeGuiMoID();
        if (scalelist != null && scale != 0) {
            tvScale.setText(scalelist.get(scale - 115));
            tvScale.setTextColor(this.getResources().getColor(R.color.textblack));
        }
        if (!StringUtils.isEmpty(data.getBody().getJiaoFangShiJian())) {//交房时间
            tvSubmithousetime.setText(data.getBody().getJiaoFangShiJian());
            tvSubmithousetime.setTextColor(this.getResources().getColor(R.color.textblack));
            time1 = data.getBody().getJiaoFangShiJian();
        }
        if (!StringUtils.isEmpty(data.getBody().getLiangFangDiZhi())) {//量房地址
            edLhouseaddress.setText(data.getBody().getLiangFangDiZhi());
        }
        if (!StringUtils.isEmpty(data.getBody().getZhuangXiuYuSuan())) {//装修预算
            edYutime.setText(data.getBody().getZhuangXiuYuSuan() + "");
        }
        if (!StringUtils.isEmpty(data.getBody().getYuJiZhuangXiuShiJian())) {//装修时间
            tvTime.setText(data.getBody().getYuJiZhuangXiuShiJian());
            tvTime.setTextColor(this.getResources().getColor(R.color.textblack));
            time2 = data.getBody().getJiaoFangShiJian();
        }
        if (!StringUtils.isEmpty(data.getBody().getYuJiLiangFang())) {//量房时间
            tvLhousetime.setText(data.getBody().getYuJiLiangFang());
            tvLhousetime.setTextColor(this.getResources().getColor(R.color.textblack));
            time3 = data.getBody().getYuJiLiangFang();
        }
    }

    @Override
    public void responseCustomerMessageError(String msg) {
        Log.e("3", "吐司3");
        showToast(msg);
    }

    int LouPanKeHu;

    int isclick = 0;

    @Override
    public void responseCustomerPhone() {
        Log.e("LouPanKeHu", LouPanKeHu + "");
        if (isclick == 1) {
            isclick = 0;
            if (tvAddress.getText().toString().equals("本地单") || tvAddress.getText().toString().equals("请选择") || tvAddress.getText().toString().equals("请选择地点")) {
                LouPanKeHu = 0;
            } else {
                LouPanKeHu = addressid;
            }

            Log.e("LouPanKeHu", LouPanKeHu + "");
            if (!StringUtils.isEmpty(phone2)) {
                mPresenter.getPersonPhone(phone2, cardno);
            } else {
                mPresenter.getAddCustomer(name, phone, mianji, type1, type2, housefrom, addressid, cardno, null, companyname, LouPanKeHu);
            }

        }

    }

    @Override
    public void responseCustomerPhoneError(String msg) {
        Log.e("4", "吐司4");
        showToast(msg);
    }

    @Override
    public void responsePersonPhone(PersonPhoneBean data) {
        mPresenter.getAddCustomer(name, phone, mianji, type1, type2, housefrom, addressid, cardno, data.getBody().getXinXiYuanBianHao(), companyname, LouPanKeHu);
    }

    @Override
    public void responsePersonPhoneError(String msg) {
        Log.e("5", "吐司5");
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


    int type = 0;//客户：0  量房：1
    @OnClick({R.id.iv_back, R.id.ll_changecustomer, R.id.ll_changemsg, R.id.ll_address, R.id.ll_jobtype, R.id.ll_identity,
            R.id.ll_attention, R.id.ll_sex, R.id.ll_house, R.id.ll_transacttype, R.id.ll_zutype, R.id.ll_submithousetime,
            R.id.ll_need, R.id.ll_pattribute, R.id.ll_time, R.id.ll_lhousetime, R.id.ll_scale, R.id.ll_bottom,
            R.id.ll_housefrom, R.id.ll_age, R.id.tv_save, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_changecustomer:
                type = 0;
                ivChange.setImageResource(R.drawable.ic_changecustomer);
                llCustomer.setVisibility(View.VISIBLE);
                llLhouse.setVisibility(View.GONE);
                tvSubmit.setVisibility(View.GONE);
                break;
            case R.id.ll_changemsg:
                if (isedit == 1) {//当是修改或者已经新增的情况下可以点击
                    type = 1;
                    ivChange.setImageResource(R.drawable.ic_changemsg);
                    llCustomer.setVisibility(View.GONE);
                    llLhouse.setVisibility(View.VISIBLE);
                    tvSubmit.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_address:
                setLineColor(1);
                if(addresslist!=null){
                    pVaddress = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvAddress.setText(addresslist.get(options1));
                            addressid = addressidlist.get(options1);
                            tvAddress.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                            Log.e("address", addressid + "");
                        }
                    }).build();
                    pVaddress.setPicker(addresslist);
                    pVaddress.show();
                }
                break;
            case R.id.ll_jobtype:
                setLineColor(5);
                pVIndustry = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvJobtype.setText(industrylist.get(options1).getMingCheng() + "-" + industrylist.get(options1).getZiji().get(options2).getMingCheng());
                        tvJobtype.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        type1 = industrylist.get(options1).getID();
                        type2 = industrylist.get(options1).getZiji().get(options2).getID();
                    }
                }).build();
                pVIndustry.setPicker(industryfulist, industryzilist);
                pVIndustry.show();
                break;
            case R.id.ll_housefrom:
                setLineColor(7);
                pVHousefrom = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvHousefrom.setText(housefromlist.get(options1));
                        tvHousefrom.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        housefrom = options1 + 1;
                    }
                }).build();
                pVHousefrom.setPicker(housefromlist);
                pVHousefrom.show();
                break;
            case R.id.ll_identity:
                setLineColorLhouse(1);
                pVIdentity = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvIdentity.setText(identitylist.get(options1));
                        tvIdentity.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        identity = identityidlist.get(options1);
                    }
                }).build();
                pVIdentity.setPicker(identitylist);
                pVIdentity.show();
                break;
            case R.id.ll_attention:
                setLineColorLhouse(2);
                pVAttention = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvAttention.setText(attentionlist.get(options1));
                        tvAttention.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        attention = attentionidlist.get(options1);
                    }
                }).build();
                pVAttention.setPicker(attentionlist);
                pVAttention.show();
                break;
            case R.id.ll_age:
                setLineColorLhouse(3);
                pVAge = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvAge.setText(agelist.get(options1));
                        tvAge.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        age = ageidlist.get(options1);
                    }
                }).build();
                pVAge.setPicker(agelist);
                pVAge.show();
                break;
            case R.id.ll_sex:
                setLineColorLhouse(4);
                pVSex = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvSex.setText(sexlist.get(options1));
                        tvSex.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        sex = options1 + 1;
                    }
                }).build();
                pVSex.setPicker(sexlist);
                pVSex.show();
                break;
            case R.id.ll_house:
                setLineColorLhouse(5);
                pVHouse = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvHouse.setText(houselist.get(options1));
                        tvHouse.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        if (options1 + 1 >= 4) {
                            house = options1 + 2;
                        } else {
                            house = options1 + 1;
                        }
                    }
                }).build();
                pVHouse.setPicker(houselist);
                pVHouse.show();
                break;
            case R.id.ll_transacttype:
                setLineColorLhouse(6);
                pVTransacttype = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvTransacttype.setText(transtypelist.get(options1));
                        tvTransacttype.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        saletype = options1 + 1;
                    }
                }).build();
                pVTransacttype.setPicker(transtypelist);
                pVTransacttype.show();
                break;
            case R.id.ll_zutype:
                setLineColorLhouse(7);
                pVZutype = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvZutype.setText(zutypelist.get(options1));
                        tvZutype.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        mianzu = options1 + 1;
                    }
                }).build();
                pVZutype.setPicker(zutypelist);
                pVZutype.show();
                break;
            case R.id.ll_submithousetime:
                setLineColorLhouse(8);
                TimePickerView submittimePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        tvSubmithousetime.setText(time);
                        tvSubmithousetime.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        time1 = time;
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
                submittimePickerView.show();
                break;
            case R.id.ll_need:
                setLineColorLhouse(10);
                pVNeed = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvNeed.setText(needlist.get(options1));
                        tvNeed.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        need = options1 + 1;
                    }
                }).build();
                pVNeed.setPicker(needlist);
                pVNeed.show();
                break;
            case R.id.ll_pattribute:
                setLineColorLhouse(11);
                pVAttribute = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvPattribute.setText(attributelist.get(options1));
                        tvPattribute.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        attribute = options1 + 1;
                    }
                }).build();
                pVAttribute.setPicker(attributelist);
                pVAttribute.show();
                break;
            case R.id.ll_time:
                setLineColorLhouse(13);
                TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        tvTime.setText(time);
                        tvTime.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        time2 = time;
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
            case R.id.ll_lhousetime:
                setLineColorLhouse(14);
                TimePickerView housetimePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String lhousetime = getDateToString(date, "yyyy/MM/dd");
                        tvLhousetime.setText(lhousetime);
                        tvLhousetime.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        time3 = lhousetime;
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
                housetimePickerView.show();
                break;
            case R.id.ll_scale:
                setLineColorLhouse(15);
                pVScale = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvScale.setText(scalelist.get(options1));
                        tvScale.setTextColor(AddActivity.this.getResources().getColor(R.color.textblack));
                        scale = options1 + 115;//(115开始)
                    }
                }).build();
                pVScale.setPicker(scalelist);
                pVScale.show();
                break;
            case R.id.tv_save:
                if (type == 0) {
                    saveCustomer();
                } else if (type == 1) {
                    saveHouse(0);//保存量房
                }
                break;
            case R.id.tv_submit:
                saveHouse(17);//提交量房
                break;
        }
    }

    /**
     * 保存客户
     */
    private int addressid, housefrom, type1, type2;
    private String name, phone, mianji, phone2, companyname;
    private void saveCustomer() {
        name = edName.getText().toString();
        phone = edPhone.getText().toString();
        mianji = edArea.getText().toString();
        phone2 = edPersonphone.getText().toString();
        companyname = edCompany.getText().toString();
        if (!StringUtils.isEmpty(mianji) && mianji.length() < 2) {
            showToast("面积最少输入两位数字！");
        } else {
            if (isedit == 1) {
                if (!StringUtils.isEmpty(name)) {
                    mPresenter.getSaveCustomer(addressid, name, phone, mianji, type1, type2, phone2, housefrom, companyname, 0, customerbaseid);
                } else {
                    showToast("请输入姓名！");
                }
            } else {
                if (addressid == 0) {
                    Log.e("haha.....", "sdfsdfsdf");
                    addressid = addressidlist.get(1);
                }
                Log.e("haha地区选的是：：", addressid + "");
                if (addressid != 0 && !StringUtils.isEmpty(name) && !StringUtils.isEmpty(phone)) {
                    isclick = 1;
                    Log.e("haha......hehe：：", addressid + "addressid" + name + "name" + phone + "phone");
                    mPresenter.getCustomerPhone(phone);
                } else if (addressid == 0) {
                    showToast("请选择地点！");
                } else if (StringUtils.isEmpty(name)) {
                    showToast("请输入姓名！");
                } else if (StringUtils.isEmpty(phone)) {
                    showToast("请输入电话！");
                }
            }
        }
    }

    /**
     * 保存、提交量房信息
     */
    private int identity, attention, age, sex, house, saletype, mianzu, need, attribute, scale;
    private String time1, time2, time3, houseaddress, yumoney;
    private void saveHouse(int status) {
        houseaddress = edLhouseaddress.getText().toString();
        yumoney = edYutime.getText().toString();
        if (status == 0) {
            mPresenter.getSaveMessage(identity, attention, age, sex, house, saletype, mianzu, time1, houseaddress, need, attribute, yumoney, time2, time3, scale, status, customerbaseid);
        } else {//提交，所有的内容都必填
            if (identity != 0 && attention != 0 && age != 0 && sex != 0 && house != 0 && saletype != 0 && mianzu != 0
                    && !time1.equals("请选择交房时间") && !StringUtils.isEmpty(houseaddress) && need != 0 &&
                    !StringUtils.isEmpty(yumoney) && !time2.equals("请选择装修时间") &&
                    !time3.equals("请选择量房时间") && scale != 0) {
                mPresenter.getSaveMessage(identity, attention, age, sex, house, saletype, mianzu, time1, houseaddress, need, attribute, yumoney, time2, time3, scale, status, customerbaseid);
            } else if (identity == 0) {
                showToast("请选择身份！");
            } else if (attention == 0) {
                showToast("请选择注重！");
            } else if (age == 0) {
                showToast("请选择年龄！");
            } else if (sex == 0) {
                showToast("请选择性别！");
            } else if (house == 0) {
                showToast("请选择房屋！");
            } else if (saletype == 0) {
                showToast("请选择成交类型！");
            } else if (mianzu == 0) {
                showToast("请选择类型！");
            } else if (time1.equals("请选择交房时间")) {
                showToast("请选择交房时间！");
            } else if (StringUtils.isEmpty(houseaddress)) {
                showToast("请输入量房地址！");
            } else if (need == 0) {
                showToast("请选择装修需求！");
            } else if (StringUtils.isEmpty(yumoney)) {
                showToast("请输入预算！");
            } else if (time2.equals("请选择装修时间")) {
                showToast("请选择装修时间！");
            } else if (time3.equals("请选择量房时间")) {
                showToast("请选择量房时间！");
            } else if (scale == 0) {
                showToast("请选择规模！");
            }
        }
    }


    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
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
                case R.id.ed_phone:
                    phone = edPhone.getText().toString();
                    if (isedit != 1) {
                        mPresenter.getCustomerPhone(phone);
                    }
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

    private void setLineColor(int linenum) {
        switch (linenum) {
            case 0:
                vAddress.setBackgroundColor(getResources().getColor(R.color.appbg));
                vJobtype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHousefrom.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 1:
                vAddress.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vJobtype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHousefrom.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 5:
                vAddress.setBackgroundColor(getResources().getColor(R.color.appbg));
                vJobtype.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vHousefrom.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 7:
                vAddress.setBackgroundColor(getResources().getColor(R.color.appbg));
                vJobtype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHousefrom.setBackgroundColor(getResources().getColor(R.color.lineorange));
                break;
        }
    }


    private void setLineColorLhouse(int linenum) {
        switch (linenum) {
            case 0:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 1:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 2:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 3:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 4:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 5:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 6:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 7:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 8:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 10:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 11:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 13:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 14:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.lineorange));
                vScale.setBackgroundColor(getResources().getColor(R.color.appbg));
                break;
            case 15:
                vIdentity.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAttention.setBackgroundColor(getResources().getColor(R.color.appbg));
                vAge.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSex.setBackgroundColor(getResources().getColor(R.color.appbg));
                vHouse.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTranstype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vZutype.setBackgroundColor(getResources().getColor(R.color.appbg));
                vSubmithousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vNeed.setBackgroundColor(getResources().getColor(R.color.appbg));
                vPattribute.setBackgroundColor(getResources().getColor(R.color.appbg));
                vTime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vLhousetime.setBackgroundColor(getResources().getColor(R.color.appbg));
                vScale.setBackgroundColor(getResources().getColor(R.color.lineorange));
                break;
        }
    }


}
