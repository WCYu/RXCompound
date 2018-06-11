package com.rxjy.rxcompound.business.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.StatusBean;
import com.rxjy.rxcompound.business.fragment.CustomerFragment;
import com.rxjy.rxcompound.business.mvp.contract.CustomerFollowContract;
import com.rxjy.rxcompound.business.mvp.presenter.CustomerFollowPresenter;
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
 * Created by hjh on 2017/11/30.
 */

public class CustomerFollowActivity extends BaseActivity<CustomerFollowPresenter> implements CustomerFollowContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.tv_marking)
    TextView tvMarking;
    @Bind(R.id.rl_marking)
    RelativeLayout rlMarking;
    @Bind(R.id.tv_visittime)
    TextView tvVisittime;
    @Bind(R.id.rl_visittime)
    RelativeLayout rlVisittime;
    @Bind(R.id.ed_visitcontent)
    EditText edVisitcontent;
    private OptionsPickerView pickerView;
    int status;
    String nexttime, addressid;
    List<String> statuslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_customerfollow;
    }

    String customerid, saleid;
    int customer_id, sale_id, address_id;

    @Override
    public void initData() {
        tvTitle.setText("跟进");
        tvRight.setText("提交");
        tvRight.setVisibility(View.VISIBLE);
//        SharedPreferences sp = getSharedPreferences("rxsw_userdatas", Activity.MODE_PRIVATE);
//        addressid = sp.getString("rxsw_addressid", null);
        addressid= App.regionid;
        Intent intent = getIntent();
        customerid = intent.getStringExtra("customerid");
        saleid = intent.getStringExtra("saleid");
        customer_id = Integer.parseInt(customerid);
        sale_id = Integer.parseInt(saleid);
        address_id = Integer.parseInt(addressid);
        statuslist = new ArrayList<>();
        statuslist.add("正常");
        statuslist.add("异常");
        statuslist.add("问题");
        statuslist.add("取消");
    }

    @Override
    protected CustomerFollowPresenter onCreatePresenter() {
        return new CustomerFollowPresenter(this);
    }


    @Override
    public void responsegetaddCustomerV(StatusBean data) {
        showToast("提交成功！");
        CustomerFragment.instance.ischange="1";
        finish();
    }

    @Override
    public void responsegetaddCustomerVError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @OnClick({R.id.iv_back, R.id.tv_right, R.id.rl_marking, R.id.rl_visittime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right://提交数据
                String content = edVisitcontent.getText().toString();
                if (status != 0 && !StringUtils.isEmpty(nexttime) && !StringUtils.isEmpty(content)) {
                    mPresenter.addCustomervisit(customer_id, sale_id, content, address_id, nexttime, status);
                } else if (status == 0) {
                    showToast("请选择标记");
                } else if (StringUtils.isEmpty(nexttime)) {
                    showToast("请选择下次回访时间");
                } else if (StringUtils.isEmpty(content)) {
                    showToast("请输入回访内容");
                }
                break;
            case R.id.rl_marking:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                        switch (statuslist.get(options1)) {
                            case "正常":
                                status = 1;
                                tvMarking.setText(statuslist.get(options1));
                                break;
                            case "异常":
                                status = 2;
                                tvMarking.setText(statuslist.get(options1));
                                break;
                            case "问题":
                                status = 3;
                                tvMarking.setText(statuslist.get(options1));
                                break;
                            case "取消":
                                break;
                        }

                    }
                }).build();
                pickerView.setPicker(statuslist);
                pickerView.show();
                break;
            case R.id.rl_visittime:
                TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String birth = getDateToString(date, "yyyy年MM月dd日 HH时mm分");
//                        nexttime = getDateToString(date, "yyyy/MM/dd");
                        nexttime = getDateToString(date, "yyyy年MM月dd日 HH时mm分");
                        tvVisittime.setText(birth);
                    }
                }).setType(new boolean[]{true, true, true, true, true, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(15)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
//                        .setRangDate()
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                        .build();
                timePickerView.show();
                break;
        }
    }

    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}