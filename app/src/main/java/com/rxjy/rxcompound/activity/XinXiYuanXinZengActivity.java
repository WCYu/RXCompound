package com.rxjy.rxcompound.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.guwen.QuYuInfo;
import com.rxjy.rxcompound.activity.guwen.XinZengResultInfo;
import com.rxjy.rxcompound.activity.guwen.XingZhiInfo;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XinXiYuanXinZengActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.iv_save)
    TextView ivSave;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.phone)
    EditText phone;
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.gongsi)
    EditText gongsi;
    @Bind(R.id.xingzhi)
    TextView xingzhi;
    @Bind(R.id.quyu)
    TextView quyu;
    @Bind(R.id.loupan)
    EditText loupan;
    @Bind(R.id.tv_save)
    Button tvSave;
    int isSelect;
    int isSelect2;
    //条件选择器
    private OptionsPickerView optionsPickerView;
    private OptionsPickerView optionsPickerView2;

    private List<String> groupList;

    private List<List<String>> childList;
    private List<String> quyugroupList;

    private List<List<String>> quyuchildList;
    private String phoneString;
    private String nameString;
    private String gongsiString;
    private String loupanString;
    private int xingzhiID;
    private int xingzhiID2;
    private String quyuName;
    private int quyuID;
    private String shangquanName;
    private int shangquanID;

    @Override
    public int getLayout() {
        return R.layout.activity_xinxiyuanxinzeng;

    }

    @Override
    public void initData() {
        groupList = new ArrayList<String>();
        childList = new ArrayList<List<String>>();
        quyugroupList = new ArrayList<String>();
        quyuchildList = new ArrayList<List<String>>();
        ivBack.setOnClickListener(this);
        xingzhi.setOnClickListener(this);
        quyu.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        tvTitle.setText("新增");
        getData();
    }

    private void getData() {
        Map<String,Object> map = new HashMap<String,Object>();
        OkhttpUtils.doGet(ApiEngine.BASEURL + "AppEmployee/MessengerProperty", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag___性质",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        XingZhiInfo xingZhiInfo = gson.fromJson(string, XingZhiInfo.class);
                        final List<XingZhiInfo.BodyBean.MessengerBean> messenger = xingZhiInfo.getBody().getMessenger();
                        for (XingZhiInfo.BodyBean.MessengerBean messengerBean : messenger) {
                            groupList.add(messengerBean.getMingCheng());
                            List<String> child = new ArrayList<>();
                            List<XingZhiInfo.BodyBean.MessengerBean.ZijiBean> ziji = messengerBean.getZiji();
                            for (XingZhiInfo.BodyBean.MessengerBean.ZijiBean zijiBean : ziji) {
                                child.add(zijiBean.getMingCheng());
                            }
                            childList.add(child);
                        }
                        optionsPickerView = new OptionsPickerView.Builder(XinXiYuanXinZengActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                xingzhi.setText(messenger.get(options1).getMingCheng()+" - "+messenger.get(options1).getZiji().get(options1).getMingCheng());
                                xingzhiID = messenger.get(options1).getID();
                                xingzhiID2 = messenger.get(options1).getZiji().get(options1).getID();
                                isSelect = 1;
                            }
                        }).build();
                        optionsPickerView.setPicker(groupList, childList);
                    }
                });
            }
        });
        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("card", App.cardNo);
        OkhttpUtils.doGet(ApiEngine.BASEURL + "AppEmployee/RegionalBusinessCircle", maps, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i("tag____区域",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        QuYuInfo quYuInfo = gson.fromJson(string, QuYuInfo.class);
                        final List<QuYuInfo.BodyBean> body = quYuInfo.getBody();
                        for (QuYuInfo.BodyBean bodyBean : body) {
                            quyugroupList.add(bodyBean.getMingCheng());
                            List<String> child = new ArrayList<>();
                            List<QuYuInfo.BodyBean.ZijiBean> ziji = bodyBean.getZiji();
                            for (QuYuInfo.BodyBean.ZijiBean zijiBean : ziji) {
                                child.add(zijiBean.getMingCheng());
                            }
                            quyuchildList.add(child);
                        }
                        optionsPickerView2 = new OptionsPickerView.Builder(XinXiYuanXinZengActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                quyu.setText(body.get(options1).getMingCheng()+" - "+body.get(options1).getZiji().get(options1).getMingCheng());
//                                clientTypeOne = messenger.get(options1).getID();
//                                clientTypeTwo = messenger.get(options1).getZiji().get(options2).getID();
                                quyuName = body.get(options1).getMingCheng();
                                quyuID = body.get(options1).getID();
                                shangquanName = body.get(options1).getZiji().get(options1).getMingCheng();
                                shangquanID = body.get(options1).getZiji().get(options1).getID();
                                isSelect2 = 2;
                                String text = quyu.getText().toString().trim();
                                Log.i("区域----",text);
                            }
                        }).build();
                        optionsPickerView2.setPicker(quyugroupList, quyuchildList);
                    }
                });
            }
        });
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
            case R.id.quyu:
                if (optionsPickerView2!=null){
                    optionsPickerView2.show();
                }
                break;
            case R.id.xingzhi:
                if (optionsPickerView!=null){
                    optionsPickerView.show();
                }
                break;
            case R.id.tv_save:
                phoneString = phone.getText().toString().trim();
                nameString = name.getText().toString().trim();
                gongsiString = gongsi.getText().toString().trim();
                loupanString = loupan.getText().toString().trim();
                if (TextUtils.isEmpty(phoneString)){
                    showToast("请输入电话");
                    return;
                }
                if (TextUtils.isEmpty(nameString)){
                    showToast("请输入姓名");
                    return;
                }
                if (TextUtils.isEmpty(gongsiString)){
                    showToast("请输入公司名称");
                    return;
                }
                if (TextUtils.isEmpty(loupanString)){
                    showToast("请输入楼盘名称");
                    return;
                }
                if (isSelect==0){
                    showToast("请选择性质");
                    return;
                }
                if (isSelect2==0){
                    showToast("请选择区域");
                    return;
                }
                commitData();
                break;
        }
    }

    private void commitData() {
        showLoading();
        int address_id = Integer.parseInt(App.regionid);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("XinXiYuanBaseID",0);
        map.put("card",App.cardNo);
        map.put("ShouJiHaoYi",phoneString);
        map.put("XingMing",nameString);
        map.put("GongSiMingCheng",gongsiString);
        map.put("YingZhiYiID",xingzhiID);
        map.put("YingZhiErID",xingzhiID2);
        map.put("QuYuName",quyuName);
        map.put("QuYuID",quyuID);
        map.put("ShangQuanName",shangquanName);
        map.put("ShangQuanID",shangquanID);
        map.put("LouPanID",0);
        map.put("QuDaoID",0);
        map.put("LouPanMingCheng",loupanString);
        map.put("FenGongSiID", address_id);
        map.put("JieGuo", 0);
        map.put("CityID", 0);
        Log.e("TAG","XinXiYuanBaseID>>>>>>>>"+0);
        Log.e("TAG","card>>>>>>>>"+App.cardNo);
        Log.e("TAG","ShouJiHaoYi>>>>>>>>"+phoneString);
        Log.e("TAG","XingMing>>>>>>>>"+nameString);
        Log.e("TAG","GongSiMingCheng>>>>>>>>"+gongsiString);
        Log.e("TAG","YingZhiYiID>>>>>>>>"+xingzhiID);
        Log.e("TAG","YingZhiErID>>>>>>>>"+xingzhiID2);
        Log.e("TAG","QuYuName>>>>>>>>"+quyuName);
        Log.e("TAG","QuYuID>>>>>>>>"+quyuID);
        Log.e("TAG","ShangQuanName>>>>>>>>"+shangquanName);
        Log.e("TAG","ShangQuanID>>>>>>>>"+shangquanID);
        Log.e("TAG","LouPanID>>>>>>>>"+0);
        Log.e("TAG","QuDaoID>>>>>>>>"+0);
        Log.e("TAG","LouPanMingCheng>>>>>>>>"+loupanString);
        Log.e("TAG","FenGongSiID>>>>>>>>"+address_id);
        Log.e("TAG","JieGuo>>>>>>>>"+0);
        Log.e("TAG","CityID>>>>>>>>"+0);
        OkhttpUtils.doPost(ApiEngine.BASEURL + "AppEmployee/XinXiYuanSave", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i("tag______新增信息员",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        XinZengResultInfo xinZengResultInfo = gson.fromJson(string, XinZengResultInfo.class);
                        if (xinZengResultInfo.getStatusCode()==0){
                            dismissLoading();
                            showToast(xinZengResultInfo.getStatusMsg());
                            finish();
                        }else if (xinZengResultInfo.getStatusCode()==-2){
                            dismissLoading();
                            showToast(xinZengResultInfo.getStatusMsg());
                        }else if (xinZengResultInfo.getStatusCode()==-1){
                            dismissLoading();
                            showToast(xinZengResultInfo.getStatusMsg());
                        }
                    }
                });
            }
        });
    }
}
