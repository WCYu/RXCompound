package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.guwen.AcsessInfo;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XinZengWaiChuActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.iv_save)
    TextView ivSave;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.leixing)
    TextView leixing;
    @Bind(R.id.bianhao)
    EditText bianhao;
    @Bind(R.id.start_time)
    TextView startTime;
    @Bind(R.id.didian)
    EditText didian;
    @Bind(R.id.yuanyin)
    EditText yuanyin;
    @Bind(R.id.tv_save)
    Button tvSave;
    int status;
    int status2;
    private OptionsPickerView pickerView;
    List<String> statuslist;
    private String nexttime;
    private InputMethodManager imm;

    @Override
    public int getLayout() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        return R.layout.activity_waichuxinzeng;
    }

    @Override
    public void initData() {
        tvTitle.setText("新增外出");
        statuslist = new ArrayList<>();
        statuslist.add("信息员");
        statuslist.add("客户");
        initListener();
        //取消软键盘
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void initListener() {
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        leixing.setOnClickListener(this);
        startTime.setOnClickListener(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                String bianhaoString = bianhao.getText().toString().trim();
                String didianString = didian.getText().toString().trim();
                String yuanyinString = yuanyin.getText().toString().trim();
                if (status==0){
                    showToast("请选择类型");
                    return;
                }
                if (TextUtils.isEmpty(bianhaoString)){
                    showToast("请输入项目编号");
                    return;
                }
                if (status2==0){
                    showToast("请选择出行时间");
                    return;
                }
                if (TextUtils.isEmpty(didianString)){
                    showToast("请输入见面地点");
                    return;
                }

                if (TextUtils.isEmpty(yuanyinString)){
                    showToast("请输入外出原因");
                    return;
                }
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("card", App.cardNo);
                map.put("LeiXing",status);
                map.put("WaiChuShiJian", nexttime);
                map.put("WaiChuYuanYin",yuanyinString);
                map.put("MeetingArea", didianString);
                map.put("number", bianhaoString);
                OkhttpUtils.doGet(ApiEngine.BASEURL + "AppEmployee/AddGoOut", map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Log.e("新增外出",string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                AcsessInfo acsessInfo = gson.fromJson(string, AcsessInfo.class);
                                int statusCode = acsessInfo.getStatusCode();
                                if (statusCode==0){
                                    showToast(acsessInfo.getStatusMsg());
                                    finish();
                                }else {
                                    showToast(acsessInfo.getStatusMsg());
                                }
                            }
                        });
                    }
                });
                break;
            case R.id.leixing:
                imm.hideSoftInputFromWindow(bianhao.getWindowToken(),0);
                imm.hideSoftInputFromWindow(didian.getWindowToken(),0);
                imm.hideSoftInputFromWindow(yuanyin.getWindowToken(),0);
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                        switch (statuslist.get(options1)) {
                            case "信息员":
                                status = 1;
                                leixing.setText(statuslist.get(options1));
                                break;
                            case "客户":
                                status = 2;
                                leixing.setText(statuslist.get(options1));
                                break;
                        }
                    }
                }).build();
                pickerView.setPicker(statuslist);
                pickerView.show();
                break;
            case R.id.start_time:
//                bianhao.clearFocus();
                imm.hideSoftInputFromWindow(bianhao.getWindowToken(),0);
                imm.hideSoftInputFromWindow(didian.getWindowToken(),0);
                imm.hideSoftInputFromWindow(yuanyin.getWindowToken(),0);
                TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        status2=1;
                        String birth = getDateToString(date, "yyyy-MM-dd HH:mm:ss");
//                        nexttime = getDateToString(date, "yyyy/MM/dd");
                        nexttime = getDateToString(date, "yyyy-MM-dd HH:mm:ss");
                        startTime.setText(birth);
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
        Log.e("tag", "date>>>>>>>>" + date);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
