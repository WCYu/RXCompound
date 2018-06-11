package com.rxjy.rxcompound.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;
import com.rxjy.rxcompound.supervision.entity.HousingInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.AddCustomersCotract;
import com.rxjy.rxcompound.supervision.mvp.presenter.AddCustomersPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/13.
 */

public class CustomerActivity extends BaseActivity<AddCustomersPresenter> implements AddCustomersCotract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_Customer_name)
    TextView tvCustomerName;
    @Bind(R.id.lv_Ctomer_name)
    EditText lvCtomerName;
    @Bind(R.id.tv_name_line)
    TextView tvNameLine;
    @Bind(R.id.tv_Customer_number)
    TextView tvCustomerNumber;
    @Bind(R.id.et_Customer_number)
    EditText etCustomerNumber;
    @Bind(R.id.tv_ic_card_num_line)
    TextView tvIcCardNumLine;
    @Bind(R.id.tv_entry_name)
    TextView tvEntryName;
    @Bind(R.id.et_entry_name)
    EditText etEntryName;
    @Bind(R.id.tv_bank_num_line)
    TextView tvBankNumLine;
    @Bind(R.id.tv_entry_type)
    TextView tvEntryType;
    @Bind(R.id.et_bank_master)
    TextView etBankMaster;
    @Bind(R.id.tv_bank_master_line)
    TextView tvBankMasterLine;
    @Bind(R.id.tv_entry_attribute)
    TextView tvEntryAttribute;
    @Bind(R.id.tv_bank_name)
    TextView tvBankName;
    @Bind(R.id.tv_bank_name_line)
    TextView tvBankNameLine;
    @Bind(R.id.tv_entry_measure)
    TextView tvEntryMeasure;
    @Bind(R.id.et_bank_address)
    EditText etBankAddress;
    @Bind(R.id.tv_bank_address_line)
    TextView tvBankAddressLine;
    @Bind(R.id.tv_Customer_budget)
    TextView tvCustomerBudget;
    @Bind(R.id.et_emergency_contact)
    EditText etEmergencyContact;
    @Bind(R.id.tv_emergency_contact_line)
    TextView tvEmergencyContactLine;
    @Bind(R.id.lv_amount_room)
    TextView lvAmountRoom;
    @Bind(R.id.tv_amount_room)
    TextView tvAmountRoom;
    @Bind(R.id.tv_relation_line)
    TextView tvRelationLine;
    @Bind(R.id.tv_Housing_situation)
    TextView tvHousingSituation;
    @Bind(R.id.et_Housing_situation)
    TextView etHousingSituation;
    @Bind(R.id.tv_phone_line_leng)
    TextView tvPhoneLineLeng;
    @Bind(R.id.tv_phone_text)
    TextView tvPhoneText;
    @Bind(R.id.et_phone)
    TextView etPhone;
    @Bind(R.id.tv_phone_line)
    TextView tvPhoneLine;
    @Bind(R.id.tv_Transaction_type)
    TextView tvTransactionType;
    @Bind(R.id.et_Transaction_type)
    TextView etTransactionType;
    @Bind(R.id.tv_Transaction_type_leng)
    TextView tvTransactionTypeLeng;
    @Bind(R.id.tv_Volumeroom)
    TextView tvVolumeroom;
    @Bind(R.id.lt_Volumeroom)
    TextView ltVolumeroom;
    @Bind(R.id.tv_Volumeroom_leng)
    TextView tvVolumeroomLeng;
    @Bind(R.id.Submit)
    Button Submit;
    @Bind(R.id.lv_Decoration_time)
    TextView lvDecorationTime;
    @Bind(R.id.tv_Decoration_time)
    TextView tvDecorationTime;
    @Bind(R.id.tvDecoration_time_line)
    TextView tvDecorationTimeLine;
    @Bind(R.id.Customer_scrollview)
    ScrollView CustomerScrollview;
    private List<List<String>> mlist;
    private List<String> body;
    private OptionsPickerView pickerView;

    private List<String> ca_proAttribute;
    private List<String> mlist2;
    private List<String> mlist3;
    private List<String> mlist4;

    private List<HousingInfo> mlist5;
    private List<HousingInfo> mlist6;
    private List<HousingInfo> mlist7;
    private List<HousingInfo> mlist8;

    private int postoion1, postoion2, postoion3, postoion4, postoion5, postoion6;
    private TimePickerView timePickerView;
    private ArrayList<ProjectTypeBean.FatherDataBean> body1;
    private String clientInfoobj;
    private String clientAuxiliaryobj;

    @Override
    public int getLayout() {
        return R.layout.activity_add_customer;
    }

    @Override
    public void initData() {
        //获取时间
        mPresenter.getProTypeData();

        tvTitle.setText("信息完善");

        mlist = new ArrayList<>();
        body = new ArrayList<>();



        ca_proAttribute = new ArrayList<>();
        ca_proAttribute.add("请选择");
        ca_proAttribute.add("正常单");
        ca_proAttribute.add("看图报价单");
        ca_proAttribute.add("设计单");
        ca_proAttribute.add("家具单");
        ca_proAttribute.add("弱电单");
        ca_proAttribute.add("局部改造");
        mlist2 = new ArrayList<>();


        mlist2.add("请选择");
        mlist2.add("毛坯房");
        mlist2.add("清水房");
        mlist2.add("旧房改造");
        mlist2.add("翻新");
        mlist2.add("精装房");

        mlist3 = new ArrayList<>();
        mlist3.add("请选择");
        mlist3.add("已定");
        mlist3.add("未定");

        mlist4 = new ArrayList<>();
        mlist4.add("请选择");
        mlist4.add("租");
        mlist4.add("买");
        mlist4.add("自建房");
//项目属性
        mlist5 = new ArrayList<>();
        mlist5.add(new HousingInfo("0", "请选择"));
        mlist5.add(new HousingInfo("1", "正常单"));
        mlist5.add(new HousingInfo("2", "看图报价单"));
        mlist5.add(new HousingInfo("3", "设计单"));
        mlist5.add(new HousingInfo("6", "家具单"));
        mlist5.add(new HousingInfo("7", "弱电单"));
        mlist5.add(new HousingInfo("8", "局部改造"));
        //房屋状况
        mlist6 = new ArrayList<>();
        mlist6.add(new HousingInfo("0", "请选择"));
        mlist6.add(new HousingInfo("1", "毛坯房"));
        mlist6.add(new HousingInfo("2", "清水房"));
        mlist6.add(new HousingInfo("3", "旧房改造"));
        mlist6.add(new HousingInfo("4", "翻新"));
        mlist6.add(new HousingInfo("5", "精装房"));
        //房源状态
        mlist7 = new ArrayList<>();
        mlist7.add(new HousingInfo("0", "请选择"));
        mlist7.add(new HousingInfo("1", "已定"));
        mlist7.add(new HousingInfo("2", "未定"));
        //成交类型
        mlist8 = new ArrayList<>();
        mlist8.add(new HousingInfo("0", "请选择"));
        mlist8.add(new HousingInfo("1", "租"));
        mlist8.add(new HousingInfo("2", "买"));
        mlist8.add(new HousingInfo("3", "自建房"));



    }


    @Override
    protected AddCustomersPresenter onCreatePresenter() {
        return new AddCustomersPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.iv_add, R.id.tv_title, R.id.lv_Ctomer_name, R.id.tv_name_line, R.id.tv_Customer_number, R.id.et_Customer_number, R.id.tv_ic_card_num_line, R.id.tv_entry_name, R.id.et_entry_name, R.id.tv_bank_num_line, R.id.tv_entry_type, R.id.et_bank_master, R.id.tv_bank_master_line, R.id.tv_entry_attribute, R.id.tv_bank_name, R.id.tv_bank_name_line, R.id.tv_entry_measure, R.id.et_bank_address, R.id.tv_bank_address_line, R.id.tv_Customer_budget, R.id.et_emergency_contact, R.id.tv_emergency_contact_line, R.id.lv_amount_room, R.id.tv_amount_room, R.id.tv_relation_line, R.id.tv_Housing_situation, R.id.et_Housing_situation, R.id.tv_phone_line_leng, R.id.tv_phone_text, R.id.et_phone, R.id.tv_phone_line, R.id.tv_Transaction_type, R.id.et_Transaction_type, R.id.tv_Transaction_type_leng, R.id.tv_Volumeroom, R.id.lt_Volumeroom, R.id.tv_Volumeroom_leng, R.id.tv_Decoration_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:

                break;
            case R.id.tv_title:
                break;
            case R.id.lv_Ctomer_name:
                break;
            case R.id.tv_name_line:
                break;
            case R.id.tv_Customer_number:
                break;
            case R.id.et_Customer_number:
                break;
            case R.id.tv_ic_card_num_line:
                break;
            case R.id.tv_entry_name:
                break;
            case R.id.et_entry_name:
                break;
            case R.id.tv_bank_num_line:
                break;
            case R.id.tv_entry_type:
                break;
            case R.id.et_bank_master:
                closeKeyboard();
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        postoion1 = options1;
                        postoion2 = options2;
                        etBankMaster.setText(body.get(options1)+" - "+mlist.get(options1).get(options2));
                    }
                }).build();
                pickerView.setPicker(body, mlist);
                pickerView.show();
                break;
            case R.id.tv_bank_master_line:
                break;
            case R.id.tv_entry_attribute:
                break;
            case R.id.tv_bank_name:
                closeKeyboard();
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        postoion3 = options1;
                        tvBankName.setText(ca_proAttribute.get(options1));
                    }
                }).build();
                pickerView.setPicker(ca_proAttribute);
                pickerView.show();
                break;
            case R.id.tv_bank_name_line:
                break;
            case R.id.tv_entry_measure:
                break;
            case R.id.et_bank_address:
                break;
            case R.id.tv_bank_address_line:
                break;
            case R.id.tv_Customer_budget:
                break;
            case R.id.et_emergency_contact:
                break;
            case R.id.tv_emergency_contact_line:
                break;
            case R.id.lv_amount_room:
                break;
            case R.id.tv_amount_room:
                break;
            case R.id.tv_relation_line:
                break;
            case R.id.tv_Housing_situation:
                break;
            case R.id.et_Housing_situation:
                closeKeyboard();
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        postoion4 = options1;
                        etHousingSituation.setText(mlist2.get(options1));
                    }
                }).build();
                pickerView.setPicker(mlist2);
                pickerView.show();
                break;
            case R.id.tv_phone_line_leng:
                break;
            case R.id.tv_phone_text:
                break;
            case R.id.et_phone:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        postoion5 = options1;
                        etPhone.setText(mlist3.get(options1));
                    }
                }).build();
                pickerView.setPicker(mlist3);
                pickerView.show();
                break;
            case R.id.tv_phone_line:
                break;
            case R.id.tv_Transaction_type:
                break;
            case R.id.et_Transaction_type:
                closeKeyboard();
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        postoion6 = options1;
                        etTransactionType.setText(mlist4.get(options1));

                    }
                }).build();
                pickerView.setPicker(mlist4);
                pickerView.show();
                break;
            case R.id.tv_Transaction_type_leng:
                break;
            case R.id.tv_Volumeroom:
                break;
            case R.id.lt_Volumeroom:
                closeKeyboard();
                timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        ltVolumeroom.setText(time);
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
            case R.id.tv_Volumeroom_leng:

                break;
            case R.id.tv_Decoration_time:
                closeKeyboard();
                timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd");
                        tvDecorationTime.setText(time);
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
        }
    }

    @OnClick(R.id.Submit)
    public void onViewClicked() {

        String CtomerName = lvCtomerName.getText().toString();
        String CustomerNumber = etCustomerNumber.getText().toString();
        String BankName = tvBankName.getText().toString();
        String bankAddress = etBankAddress.getText().toString();
        String EntryName = etEntryName.getText().toString();
        String BankMaster = etBankMaster.getText().toString();
        String EmergencyContact = etEmergencyContact.getText().toString();
        String AmountRoom = tvAmountRoom.getText().toString();
        String HousingSituation = etHousingSituation.getText().toString();
        String phone = etPhone.getText().toString();
        String TransactionType = etTransactionType.getText().toString();
        String Volumeroom = ltVolumeroom.getText().toString();
//tvAmountRoom

        if (CtomerName.equals("") || CustomerNumber.equals("") || BankName.equals("") || bankAddress.equals("") || EntryName.equals("") || BankMaster.equals("") || EmergencyContact.equals("") || AmountRoom.equals("") || HousingSituation.equals("") || phone.equals("") || TransactionType.equals("") || Volumeroom.equals("")) {
            Toast.makeText(application, "资料未填写完毕", Toast.LENGTH_SHORT).show();
        } else {
            mPresenter.GetOrderNumber(App.regionid + "", CustomerNumber);
        }
    }

    @Override
    public void responseProListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void loadProTypeData(String data) {
        mlist.clear();
        body.clear();
        try {
            ProjectTypeBean projectTypeBean = JSONUtils.toObject(data, ProjectTypeBean.class);
            body1 = projectTypeBean.getBody();
            for (int i = 0; i < body1.size(); i++) {
                this.body.add(body1.get(i).getMingCheng());
                ArrayList<ProjectTypeBean.FatherDataBean.SonDataBean> ziji = body1.get(i).getZiji();
                ArrayList<String> lists = new ArrayList<>();
                for (int j = 0; j < ziji.size(); j++) {
                    lists.add(ziji.get(j).getMingCheng());
                }
                mlist.add(lists);
            }


        } catch (Exception e) {

        }

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void loaDareaid(LHouseNumBean info) {
        //订单 rwdId
      App.rwdId = info.getBody().getOrderNumber();
        //客户姓名
        String name = lvCtomerName.getText().toString();
        //客户电话
        String s = etCustomerNumber.getText().toString();
        //项目名称
        String s1 = etEntryName.getText().toString();
        //项目类型1级
        String id = body1.get(postoion1).getID();
        //面积
        String s2 = etBankAddress.getText().toString();
        //卡号
        String cardNo = App.cardNo;
        //姓名
        String jpushname = App.jpushname;
        //量房地址
        String s3 = tvAmountRoom.getText().toString();


        //        "ca_DecorationDate":"装修时间",
        tvDecorationTime.getText().toString();
//                "ca_proAttribute":"项目属性",
        mlist5.get(postoion3).getId();
//                "ca_DecBudgetPrice":"装修预算",
        etEmergencyContact.getText().toString();
//                "ca_HousingType":"房屋状况",
        mlist6.get(postoion4).getId();
//                "ca_AvailabilityStatus":"房源状态",
        mlist7.get(postoion5).getId();
//                "ca_TransactionType":"成交类型",
        mlist8.get(postoion6).getId();
//                "ca_MeasureDate":"量房时间",
        ltVolumeroom.getText().toString();
//                "ca_SWIndustryTypeID":"项目类型2级"
        body1.get(postoion1).getZiji().get(postoion2).getID();

        try {
            JSONObject json = new JSONObject();
            json.put("ci_proHead", name);
            json.put("ci_proHeadTel", s);
            json.put("ci_ClientName", s1);
            json.put("ci_Type", id);
            json.put("ci_Area", s2);
            json.put("ci_SalesmanCard", cardNo);
            json.put("ci_SalesmanName", jpushname);
            json.put("ci_DecorationAddress", s3);
            clientInfoobj = json.toString();

            JSONObject tojiso = new JSONObject();

            tojiso.put("ca_DecorationDate", tvDecorationTime.getText().toString());
            tojiso.put("ca_proAttribute", mlist5.get(postoion3).getId());
            tojiso.put("ca_DecBudgetPrice", etEmergencyContact.getText().toString());
            tojiso.put("ca_HousingType", mlist6.get(postoion4).getId());
            tojiso.put("ca_AvailabilityStatus", mlist7.get(postoion5).getId());
            tojiso.put("ca_TransactionType", mlist8.get(postoion6).getId());
            tojiso.put("ca_MeasureDate", ltVolumeroom.getText().toString());
            tojiso.put("ca_SWIndustryTypeID", body1.get(postoion1).getZiji().get(postoion2).getID());
            clientAuxiliaryobj = tojiso.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("App.rwdId ",App.rwdId );
        Log.e("cc",App.regionid+"");
        Log.e("json",clientInfoobj);
        Log.e("flag",clientAuxiliaryobj);
        mPresenter.postCustomersInfo( App.rwdId , App.regionid + "", 4 + "", clientInfoobj, clientAuxiliaryobj);
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void toIntent() {
        finish();
    }

    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
