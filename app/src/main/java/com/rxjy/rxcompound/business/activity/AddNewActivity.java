package com.rxjy.rxcompound.business.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.AddressBean;
import com.rxjy.rxcompound.business.entity.CustomerDNewBean;
import com.rxjy.rxcompound.business.entity.IndustryBean;
import com.rxjy.rxcompound.business.entity.KFChannelBean;
import com.rxjy.rxcompound.business.entity.KFCityBean;
import com.rxjy.rxcompound.business.entity.PersonPhoneBean;
import com.rxjy.rxcompound.business.mvp.contract.AddNewContract;
import com.rxjy.rxcompound.business.mvp.presenter.AddNewPresenter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/5/14.
 */

public class AddNewActivity extends BaseActivity<AddNewPresenter> implements AddNewContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;
    @Bind(R.id.v_address)
    View vAddress;
    @Bind(R.id.ed_name)
    EditText edName;
    @Bind(R.id.v_name)
    View vName;
    @Bind(R.id.ed_phone)
    EditText edPhone;
    @Bind(R.id.v_phone)
    View vPhone;
    @Bind(R.id.mianji_tv)
    TextView mianjiTv;
    @Bind(R.id.ed_area)
    EditText edArea;
    @Bind(R.id.mi_tv)
    TextView miTv;
    @Bind(R.id.v_area)
    View vArea;
    @Bind(R.id.tv_jobtype)
    TextView tvJobtype;
    @Bind(R.id.ll_jobtype)
    LinearLayout llJobtype;
    @Bind(R.id.v_jobtype)
    View vJobtype;
    @Bind(R.id.ed_personphone)
    EditText edPersonphone;
    @Bind(R.id.v_personphone)
    View vPersonphone;
    @Bind(R.id.tv_housefrom)
    TextView tvHousefrom;
    @Bind(R.id.ll_housefrom)
    LinearLayout llHousefrom;
    @Bind(R.id.v_housefrom)
    View vHousefrom;
    @Bind(R.id.ed_company)
    EditText edCompany;
    @Bind(R.id.v_company)
    View vCompany;
    @Bind(R.id.tv_city)
    TextView tvCity;
    @Bind(R.id.ll_city)
    LinearLayout llCity;
    @Bind(R.id.v_city)
    View vCity;
    @Bind(R.id.tv_from)
    TextView tvFrom;
    @Bind(R.id.ll_from)
    LinearLayout llFrom;
    @Bind(R.id.v_from)
    View vFrom;
    @Bind(R.id.tv_channel)
    TextView tvChannel;
    @Bind(R.id.ll_channel)
    LinearLayout llChannel;
    @Bind(R.id.v_channel)
    View vChannel;
    @Bind(R.id.ed_key)
    EditText edKey;
    @Bind(R.id.v_key)
    View vKey;
    @Bind(R.id.ed_consult)
    EditText edConsult;
    @Bind(R.id.v_consult)
    View vConsult;
    @Bind(R.id.ed_fall)
    EditText edFall;
    @Bind(R.id.v_fall)
    View vFall;
    @Bind(R.id.tv_port)
    TextView tvPort;
    @Bind(R.id.ll_port)
    LinearLayout llPort;
    @Bind(R.id.v_port)
    View vPort;
    @Bind(R.id.ll_customer)
    LinearLayout llCustomer;
    @Bind(R.id.tv_save)
    TextView tvSave;
    @Bind(R.id.ll_bottom)
    LinearLayout llBottom;
    @Bind(R.id.tv_platform)
    TextView tvPlatform;
    @Bind(R.id.ll_platform)
    LinearLayout llPlatform;

    @Override
    public int getLayout() {
        return R.layout.activity_messageaddnew;
    }

    int isedit;
    String customerbaseid = null;

    @Override
    public void initData() {
        mPresenter.getAddress(App.postName);
        mPresenter.getIndustryType("2");
        mPresenter.getCity(App.cardNo);

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
            mPresenter.getCustomerDetails(customerbaseid);
            llPlatform.setVisibility(View.GONE);
        } else {
            tvTitle.setText("新增");
            showToast("标题后带ˇ为必填选项，请知悉");
        }
    }

    /**
     * 添加数据
     */
    ArrayList<String> housefromlist, portlist, fromlist, platform;

    private void addData() {
        housefromlist = new ArrayList<>();//房源
        housefromlist.add("已定");
        housefromlist.add("未定");
        portlist = new ArrayList<>();//端口
        portlist.add("PC");
        portlist.add("移动");
        fromlist = new ArrayList<>();//来源
        fromlist.add("QQ");
        fromlist.add("电话");
        fromlist.add("商务通");
        fromlist.add("其他");
        fromlist.add("报名");
        fromlist.add("表单");
        platform = new ArrayList<>();
        platform.add("电商");
        platform.add("温特斯");
        platform.add("施工");

    }


    @Override
    protected AddNewPresenter onCreatePresenter() {
        return new AddNewPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private int addressid, type1, type2, housefrom, cityid, fromid, channelid, portid;
    private int platformid = 4;
    private OptionsPickerView pVaddress, pVIndustry, pVHousefrom, pVCity, pVFrom, pVChannel, pVPort, platformFrom;

    @OnClick({R.id.iv_back, R.id.ll_address, R.id.ll_jobtype, R.id.ll_housefrom, R.id.ll_city, R.id.ll_from, R.id.ll_channel, R.id.ll_port, R.id.ll_customer, R.id.tv_save, R.id.ll_bottom, R.id.ll_platform})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_address:
                if (addresslist != null) {
                    pVaddress = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvAddress.setText(addresslist.get(options1));
                            addressid = addressidlist.get(options1);
                            tvAddress.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                        }
                    }).build();
                    pVaddress.setPicker(addresslist);
                    pVaddress.show();
                }
                break;
            case R.id.ll_jobtype:
                if (industryfulist != null) {
                    pVIndustry = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvJobtype.setText(industrylist.get(options1).getMingCheng() + "-" + industrylist.get(options1).getZiji().get(options2).getMingCheng());
                            tvJobtype.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            type1 = industrylist.get(options1).getID();
                            type2 = industrylist.get(options1).getZiji().get(options2).getID();
                        }
                    }).build();
                    pVIndustry.setPicker(industryfulist, industryzilist);
                    pVIndustry.show();
                }
                break;
            case R.id.ll_housefrom:
                if (housefromlist != null) {

                    pVHousefrom = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvHousefrom.setText(housefromlist.get(options1));
                            tvHousefrom.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            housefrom = options1 + 1;
                        }
                    }).build();
                    pVHousefrom.setPicker(housefromlist);
                    pVHousefrom.show();
                }
                break;
            case R.id.ll_city:
                if (citylist != null) {
                    pVCity = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvCity.setText(citylist.get(options1));
                            tvCity.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            cityid = cityidlist.get(options1);
                            mPresenter.getChannel(cityid + "", null);
                        }
                    }).build();
                    pVCity.setPicker(citylist);
                    pVCity.show();
                }
                break;
            case R.id.ll_from:
                if (fromlist != null) {
                    pVFrom = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvFrom.setText(fromlist.get(options1));
                            tvFrom.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            fromid = options1 + 1;
                        }
                    }).build();
                    pVFrom.setPicker(fromlist);
                    pVFrom.show();
                }
                break;
            case R.id.ll_channel:
                if (channellist != null) {
                    pVChannel = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvChannel.setText(channellist.get(options1));
                            tvChannel.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            channelid = channelidlist.get(options1);
                        }
                    }).build();
                    pVChannel.setPicker(channellist);
                    pVChannel.show();
                } else {
                    showToast("请先选择城市!");
                }
                break;
            case R.id.ll_port:
                if (portlist != null) {
                    pVPort = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvPort.setText(portlist.get(options1));
                            tvPort.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            portid = options1 + 1;
                        }
                    }).build();
                    pVPort.setPicker(portlist);
                    pVPort.show();
                }
                break;
            case R.id.tv_save:
                if (customerbaseid != null) {//修改
                    fixCustomer();
                } else {//新增
                    saveCustomer();
                }
                break;
            case R.id.ll_platform:
                if (platform != null) {
                    platformFrom = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvPlatform.setText(platform.get(options1));
                            tvPlatform.setTextColor(AddNewActivity.this.getResources().getColor(R.color.textblack));
                            platformid = options1 + 4;
                        }
                    }).build();
                    platformFrom.setPicker(platform);
                    platformFrom.show();
                }
                break;
        }
    }


    /**
     * 保存客户
     */
    private String name, phone, mianji, phone2, companyname, key, counsult, fall;

    private void saveCustomer() {
        name = edName.getText().toString();
        phone = edPhone.getText().toString();
        mianji = edArea.getText().toString();
        phone2 = edPersonphone.getText().toString();
        companyname = edCompany.getText().toString();
        key = edKey.getText().toString();
        counsult = edConsult.getText().toString();
        fall = edFall.getText().toString();
        if (!StringUtils.isEmpty(mianji) && mianji.length() < 2) {
            showToast("面积最少输入两位数字！");
        } else {
            if (isedit == 1) {
                if (!StringUtils.isEmpty(name)) {
//                    mPresenter.getSaveCustomer(addressid, name, phone, mianji, type1, type2, phone2, housefrom, companyname, 0, customerbaseid);
                } else {
                    showToast("请输入姓名！");
                }
            } else {
                Log.e("addressid??", addressid + "");
                if (addressid == 0) {
                    addressid = addressidlist.get(1);
                }

                if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(phone) && cityid != 0 && fromid != 0
                        && channelid != 0 && portid != 0 && !StringUtils.isEmpty(mianji)
                        && housefrom != 0 && type1 != 0 && type2 != 0 && !StringUtils.isEmpty(companyname)) {
                    isclick = 1;
                    mPresenter.getCustomerPhone(phone);
                } else if (StringUtils.isEmpty(name)) {
                    showToast("请输入姓名！");
                } else if (StringUtils.isEmpty(phone)) {
                    showToast("请输入电话！");
                } else if (StringUtils.isEmpty(mianji)) {
                    showToast("请输入面积！");
                } else if (type1 == 0) {
                    showToast("请选择行业类型！");
                } else if (housefrom == 0) {
                    showToast("请选择房源！");
                } else if (StringUtils.isEmpty(companyname)) {
                    showToast("请输入公司名称！");
                } else if (cityid == 0) {
                    showToast("请选择城市！");
                } else if (fromid == 0) {
                    showToast("请选择来源！");
                } else if (channelid == 0) {
                    showToast("请选择渠道！");
                } else if (portid == 0) {
                    showToast("请选择端口！");
                }
            }
        }
    }

    /**
     * 修改
     */
    private void fixCustomer() {
        name = edName.getText().toString();
        phone = edPhone.getText().toString();
        mianji = edArea.getText().toString();
        phone2 = edPersonphone.getText().toString();
        companyname = edCompany.getText().toString();
        key = edKey.getText().toString();
        counsult = edConsult.getText().toString();
        fall = edFall.getText().toString();
        if (!StringUtils.isEmpty(mianji) && mianji.length() < 2) {
            showToast("面积最少输入两位数字！");
        } else {
            Log.e("addressid??", addressid + "");
            if (addressid == 0) {
                addressid = addressidlist.get(1);
            }

            if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(phone) && cityid != 0 && fromid != 0
                    && channelid != 0 && portid != 0 && !StringUtils.isEmpty(mianji)
                    && housefrom != 0 && type1 != 0 && type2 != 0 && !StringUtils.isEmpty(companyname)) {
                isclick = 1;
                mPresenter.fixCustomer(customerbaseid, name, phone, channelid + "", cityid + "", type1 + "", fromid + "", companyname, key, mianji, housefrom + "", type2 + "", counsult, fall, "0", portid + "");
            } else if (StringUtils.isEmpty(name)) {
                showToast("请输入姓名！");
            } else if (StringUtils.isEmpty(phone)) {
                showToast("请输入电话！");
            } else if (StringUtils.isEmpty(mianji)) {
                showToast("请输入面积！");
            } else if (type1 == 0) {
                showToast("请选择行业类型！");
            } else if (housefrom == 0) {
                showToast("请选择房源！");
            } else if (StringUtils.isEmpty(companyname)) {
                showToast("请输入公司名称！");
            } else if (cityid == 0) {
                showToast("请选择城市！");
            } else if (fromid == 0) {
                showToast("请选择来源！");
            } else if (channelid == 0) {
                showToast("请选择渠道！");
            } else if (portid == 0) {
                showToast("请选择端口！");
            }
        }
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
     * 城市的数据
     */
    List<String> citylist;
    List<Integer> cityidlist;
    private KFCityBean citydata;

    @Override
    public void responsegetCity(KFCityBean data) {
        citydata = data;
        citylist = new ArrayList<>();
        cityidlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            citylist.add(data.getBody().get(i).getGongSiMingCheng());
            cityidlist.add(data.getBody().get(i).getFenGongSiID());
        }
    }

    @Override
    public void responsegetCityError(String msg) {

    }


    /**
     * 渠道的数据
     */
    List<String> channellist;
    List<Integer> channelidlist;
    private KFChannelBean channeldata;

    @Override
    public void responsegetChannel(KFChannelBean data) {
        channeldata = data;
        channellist = new ArrayList<>();
        channelidlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            channellist.add(data.getBody().get(i).getName());
            channelidlist.add(data.getBody().get(i).getType());
        }
        if (channelid != 0) {
            for (int i = 0; i < channelidlist.size(); i++) {
                if (channelid == channelidlist.get(i)) {
                    tvChannel.setText(channellist.get(i));
                }
            }
        }
    }

    @Override
    public void responsegetChannelError(String msg) {

    }

    int isclick = 0;

    @Override
    public void responseCustomerPhone() {
        if (isclick == 1) {
            isclick = 0;
            Log.e("tag", platformid + "");
            mPresenter.addCustomer(name, phone, App.cardNo, channelid + "", cityid + "", type1 + "", fromid + "", companyname, key, mianji, housefrom + "", type2 + "", counsult, fall, portid + "", platformid + "");

            // }
        }
    }

    @Override
    public void responseCustomerPhoneError(String msg) {
        showToast(msg);

    }

    @Override
    public void responseaddCustomer() {
        showToast("新增成功！");
        finish();
    }

    @Override
    public void responseaddCustomerError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsePersonPhone(PersonPhoneBean data) {
        mPresenter.addCustomer(name, phone, App.cardNo, channelid + "", cityid + "", type1 + "", fromid + "", companyname, key, mianji, housefrom + "", type2 + "", counsult, fall, portid + "", platform + "");
    }

    @Override
    public void responsePersonPhoneError(String msg) {

    }

    @Override
    public void responseCustomerDeatils(CustomerDNewBean data) {
        Log.e("dsdfsdfafsdf", "fsafsdfsd11111111111111");
        //异地
        addressid = data.getBody().get(0).getTb_diqu();
        for (int i = 0; i < addressdata.getBody().size(); i++) {
            if (data.getBody().get(0).getTb_diqu() == addressdata.getBody().get(i).getFenGongSiID()) {
                tvAddress.setText(addressdata.getBody().get(i).getName());
                tvAddress.setTextColor(this.getResources().getColor(R.color.textblack));
            }
        }
        if (!StringUtils.isEmpty(data.getBody().get(0).getXingMing())) {//姓名
            edName.setText(data.getBody().get(0).getXingMing());
        }
        if (!StringUtils.isEmpty(data.getBody().get(0).getShouJiHaoYi())) {//手机号
            edPhone.setText(data.getBody().get(0).getShouJiHaoYi());
        }
        if (!StringUtils.isEmpty(data.getBody().get(0).getMianJi())) {//面积
            edArea.setText(data.getBody().get(0).getMianJi() + "");
        }
        if (!StringUtils.isEmpty(data.getBody().get(0).getShouJiHaoEr())) {//信电
            edPersonphone.setText(data.getBody().get(0).getShouJiHaoEr());
        }
        if (!StringUtils.isEmpty(data.getBody().get(0).getGongSiMingCheng())) {//公司
            edCompany.setText(data.getBody().get(0).getGongSiMingCheng());
        }
        housefrom = data.getBody().get(0).getFangYuan();
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
        type1 = data.getBody().get(0).getLeiXingYi();
        type2 = data.getBody().get(0).getLeiXingEr();
        tvJobtype.setText(data.getBody().get(0).getLeiXingMingCheng() + "-" + data.getBody().get(0).getLeiXingErMingCheng());
        cityid = data.getBody().get(0).getTb_diqu();
        tvCity.setText(data.getBody().get(0).getCity());
        fromid = data.getBody().get(0).getLaiYuan();
        for (int i = 0; i < fromlist.size(); i++) {
            if (fromid == i + 1) {
                tvFrom.setText(fromlist.get(i));
            }
        }
        edKey.setText(data.getBody().get(0).getKeyWord());
        edConsult.setText(data.getBody().get(0).getFromURL());
        edFall.setText(data.getBody().get(0).getLandingURL());
        portid = data.getBody().get(0).getIsMobilePC();
        for (int i = 0; i < portlist.size(); i++) {
            if (i + 1 == portid) {
                tvPort.setText(portlist.get(i));
            }
        }
        channelid = data.getBody().get(0).getChannel();
        mPresenter.getChannel(cityid + "", null);

    }

    @Override
    public void responseCustomerDeatilsError(String msg) {

    }

    @Override
    public void responsefixCustomer() {
        showToast("修改成功！");
        finish();
    }

    @Override
    public void responsefixCustomerError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }


}
