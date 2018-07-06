package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;

import com.rxjy.rxcompound.activity.guwen.AcsessInfo;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.utils.OkhttpUtils2;

import java.io.IOException;
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

public class HuiFangActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.tv_marking)
    TextView tvMarking;
    @Bind(R.id.rl_marking)
    RelativeLayout rlMarking;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.tv_visittime)
    TextView tvVisittime;
    @Bind(R.id.rl_visittime)
    RelativeLayout rlVisittime;
    @Bind(R.id.ed_visitcontent)
    EditText edVisitcontent;
    @Bind(R.id.iv_save)
    TextView ivSave;
    int status;
    int zstatus;
    String nexttime, addressid;
    List<String> statuslist;
    int xinxiyuanid, yewuyuanid;
    int customer_id, sale_id, address_id;
    @Bind(R.id.tv_zhongyao)
    TextView tvZhongyao;
    @Bind(R.id.rl_zhongyao)
    RelativeLayout rlZhongyao;
    private OptionsPickerView pickerView;
    private String phone;
    List<String> zlist;
    @Override
    public int getLayout() {
        return R.layout.activity_xinxiyuanhuifang;
    }

    @Override
    public void initData() {
        tvTitle.setText("回访");
        ivSave.setVisibility(View.VISIBLE);
        ivSave.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        rlMarking.setOnClickListener(this);
        rlVisittime.setOnClickListener(this);
        rlZhongyao.setOnClickListener(this);
//
        addressid = App.regionid;
        Intent intent = getIntent();
        xinxiyuanid = intent.getIntExtra("xinxiyuanid", 0);
        yewuyuanid = intent.getIntExtra("yewuyuanid", 0);
        phone = intent.getStringExtra("phone");
//        customer_id = Integer.parseInt(xinxiyuanid);
//        sale_id = Integer.parseInt(yewuyuanid);
        address_id = Integer.parseInt(addressid);
        statuslist = new ArrayList<>();
        statuslist.add("优");
        statuslist.add("中");
        statuslist.add("差");

        zlist = new ArrayList<>();
        zlist.add("正常");
        zlist.add("异常");
        zlist.add("问题");
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_save:
                String content = edVisitcontent.getText().toString();
                if (status != 0 && !StringUtils.isEmpty(nexttime) && !StringUtils.isEmpty(content)) {
                    commitData();
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
                            case "优":
                                status = 1;
                                tvMarking.setText(statuslist.get(options1));
                                break;
                            case "中":
                                status = 2;
                                tvMarking.setText(statuslist.get(options1));
                                break;
                            case "差":
                                status = 3;
                                tvMarking.setText(statuslist.get(options1));
                                break;
                        }

                    }
                }).build();
                pickerView.setPicker(statuslist);
                pickerView.show();
                break;
            case R.id.rl_zhongyao:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                        switch (zlist.get(options1)) {
                            case "正常":
                                zstatus = 1;
                                tvZhongyao.setText(zlist.get(options1));
                                break;
                            case "异常":
                                zstatus = 2;
                                tvZhongyao.setText(zlist.get(options1));
                                break;
                            case "问题":
                                zstatus = 3;
                                tvZhongyao.setText(zlist.get(options1));
                                break;
                        }
                    }
                }).build();
                pickerView.setPicker(zlist);
                pickerView.show();
                break;
            case R.id.rl_visittime:
                TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String birth = getDateToString(date, "yyyy-MM-dd HH:mm:ss");
//                        nexttime = getDateToString(date, "yyyy/MM/dd");
                        nexttime = getDateToString(date, "yyyy-MM-dd HH:mm:ss");
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

    private void commitData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("XinXiYuanBaseID", xinxiyuanid);
        map.put("YeWuYuanID", yewuyuanid);
        map.put("HuiFangNeiRong", edVisitcontent.getText().toString().trim());
        map.put("tb_diqu", address_id);
        map.put("selXxyZhongYaoXing", status);
        map.put("XiaCiHuiFang", nexttime);
        Log.i("tag", "date>>>>>>>" + new Date());
        map.put("Phone", phone);
        map.put("Importance", zstatus);
        Log.i("tag", "date>>>>>>>" + xinxiyuanid);
        Log.i("tag", "YeWuYuanID>>>>>>>" + yewuyuanid);
        Log.i("tag", "HuiFangNeiRong>>>>>>>" + edVisitcontent.getText().toString().trim());
        Log.i("tag", "tb_diqu>>>>>>>" + address_id);
        Log.i("tag", "selXxyZhongYaoXing>>>>>>>" + status);
        Log.i("tag", "XiaCiHuiFang>>>>>>>" + nexttime);
        Log.i("tag", "Phone>>>>>>>" + phone);
        Log.i("tag", "Importance>>>>>>>" + zstatus);
        OkhttpUtils2.doPost(ApiEngine.BASEURL + "AppEmployee/AddMessengerVisit", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("tag", "IOException>>>>>>>" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i("tag", "data>>>>>" + string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        AcsessInfo acsessInfo = gson.fromJson(string, AcsessInfo.class);
                        if (acsessInfo.getStatusCode()==0){
                            Toast.makeText(HuiFangActivity.this, acsessInfo.getStatusMsg(), Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(HuiFangActivity.this, acsessInfo.getStatusMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
//        OkhttpUtils.doPost(ApiEngine.BASEURL + "AppEmployee/AddMessengerVisit", map, new OkhttpUtils.MyCall() {
//            @Override
//            public void success(String data) {
//                Log.e("tag","回访data>>>>>>>>>>>>>>>>"+data);
//                ToastUtil.getInstance().toastCentent("添加回访成功");
//                finish();
//            }
//
//            @Override
//            public void error(String message) {
//                ToastUtil.getInstance().toastCentent("添加回访失败");
//                Log.e("tag","回访Error data>>>>>>>>>>>>>>>>"+message);
//            }
//        });
    }

    public static String getDateToString(Date date, String pattern) {
        Log.i("tag", "date>>>>>>>>" + date);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
