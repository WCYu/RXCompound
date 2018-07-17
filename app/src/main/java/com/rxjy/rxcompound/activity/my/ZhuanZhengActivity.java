package com.rxjy.rxcompound.activity.my;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.MsgNumBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
import com.rxjy.rxcompound.entity.my.ZhuanZhengBean;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ZhuanZhengActivity extends BaseActivity<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_sex)
    EditText etSex;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_time)
    EditText etTime;
    @Bind(R.id.et_hukou)
    TextView etHukou;
    @Bind(R.id.et_baoxian)
    TextView etBaoxian;
    @Bind(R.id.duty)
    EditText duty;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    private String cardno;
    private OptionsPickerView choiceData;

    String hukou;
    String baoxian;
    private OptionsPickerView baoXianData;
    private ZhuanZhengBean zhuanZhengBean;

    @Override
    public int getLayout() {
        return R.layout.activity_zhun_zheng;
    }

    @Override
    public void initData() {
        showDialog();
        setProgressDialog(3000);
        ButterKnife.bind(this);
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        cardno = sp.getString("rxdy_cardno", "数据为空");
        mPresenter.getMessage(cardno, "1");
//        Log.e("tag",cardno);
        ArrayList<String> huKouList = new ArrayList<>();
        huKouList.add("本市城镇");
        huKouList.add("本市农村");
        huKouList.add("外埠城镇");
        huKouList.add("外埠农村");
        initChoiceData(huKouList);

        ArrayList<String> baoXianList = new ArrayList<>();
        baoXianList.add("续交");
        baoXianList.add("新增");
        baoXianList.add("放弃");
        initBaoXianData(baoXianList);

        getUserData(cardno);
    }

    private void initChoiceData(final ArrayList<String> arrayList) {

        choiceData = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                etHukou.setText(arrayList.get(options1).toString());
                hukou = arrayList.get(options1).toString();
            }
        }).build();

        choiceData.setPicker(arrayList);

    }

    private void initBaoXianData(final ArrayList<String> arrayList) {

        baoXianData = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                etBaoxian.setText(arrayList.get(options1).toString());
                baoxian = arrayList.get(options1).toString();
            }
        }).build();

        baoXianData.setPicker(arrayList);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }

    @Override
    public void responsegetMessage(String s, PersonBean data) {
        if (data != null) {
            dismissLoading();
        }
        etName.setText(data.getBody().getName());
        etTime.setText(data.getBody().getTryHillockTime());
        etPhone.setText(data.getBody().getPhone());
        etSex.setText(data.getBody().getSex());
    }

    @Override
    public void responsegetMessageError(String msg) {

    }

    @Override
    public void responseUpdateMessage(PersonBean data) {

    }

    @Override
    public void responseUpdateMessageError(String msg) {

    }

    @Override
    public void responseUpdateMessagebank(PersonBean data) {

    }

    @Override
    public void responseUpdateMessagebankError(String msg) {

    }

    @Override
    public void responseBankList(BankBean data) {

    }

    @Override
    public void responseBankListError(String msg) {

    }

    @Override
    public void responseImg(ImgBean data) {

    }

    @Override
    public void responseImgError(String msg) {

    }

    @Override
    public void responseIcon(IconBean data) {

    }

    @Override
    public void responseIconError(String msg) {

    }

    @Override
    public void responseUserStatus(UserStatusBean data) {

    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void responseMsgStatus(MsgNumBean data) {

    }

    @Override
    public void responseMsgError(String msg) {

    }

    @Override
    public void responseDesMessage(DesBaseInfoBean data) {

    }

    @Override
    public void responseDesMessageError(String msg) {

    }

    @Override
    public void responseIsConsent(ResultBean data) {

    }

    @Override
    public void responseIsConsentError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @OnClick({R.id.iv_back, R.id.et_hukou, R.id.et_baoxian, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.et_hukou:
//                ToastUtil.getInstance().toastCentent("户口");
                choiceData.show();
                break;
            case R.id.et_baoxian:
                baoXianData.show();
                break;
            case R.id.btn_commit:

                if (TextUtils.isEmpty(hukou)) {
                    ToastUtil.getInstance().toastCentent("请选择户口性质");
                    return;
                }

                if (TextUtils.isEmpty(baoxian)) {
                    ToastUtil.getInstance().toastCentent("请选择保险情况");
                    return;
                }

                if (TextUtils.isEmpty(duty.getText().toString())) {
                    ToastUtil.getInstance().toastCentent("请填写述职情况");
                    return;
                }

                if (zhuanZhengBean == null) {
                    ToastUtil.getInstance().toastCentent("未获取到员工信息");
                    return;
                }

                String hege = zhuanZhengBean.getBody().getHege();

//                if(hege.equals("1")){//允许转正
                commitData();
//                }else {
//                    Log.e("tag_申请转正",baoxian + hukou + duty.getText().toString());
//                    ToastUtil.getInstance().toastCentent(zhuanZhengBean.getBody().getZhuanzhengTimeStr());
//                }

                break;
        }
    }

    private void commitData() {
        Map map = new HashMap();
        map.put("u_kahao", cardno);
        map.put("shebao", baoxian);
        map.put("hukou", hukou);
        map.put("shuzhi", duty.getText().toString());
        map.put("u_zhuanzhengtime", zhuanZhengBean.getBody().getZhuanzhengTime());
        map.put("reason", "App提交转正");
        map.put("KaHao", "");
        OkhttpUtils.doPost(ApiEngine.ZHUANZHNEGURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_申请转正_失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_申请转正", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            String statusMsg = jsonObject.getString("StatusMsg");
                            if (statusCode == 0) {
                                ToastUtil.getInstance().toastCentent(statusMsg);
                                App.ustart = 100010;
                                finish();
                            } else {
                                ToastUtil.getInstance().toastCentent(statusMsg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    public void getUserData(String card) {
        Map map = new HashMap();
        map.put("u_kahao", card);
        OkhttpUtils.doGet(ApiEngine.ZHUANZHNEDATAGURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_获取转正状态失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_获取转正状态", string);
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    String statusMsg = jsonObject.getString("StatusMsg");
                    int statusCode = jsonObject.getInt("StatusCode");
                    if (statusCode == 0) {
                        Gson gson = new Gson();
                        zhuanZhengBean = gson.fromJson(string, ZhuanZhengBean.class);
                    } else {
                        ToastUtil.getInstance().toastCentent(statusMsg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
