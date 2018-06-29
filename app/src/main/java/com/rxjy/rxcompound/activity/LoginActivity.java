package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.business.activity.BusinessMainHostActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.entity.VPhoneBean;
import com.rxjy.rxcompound.entity.ZiDonBean;
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
import com.rxjy.rxcompound.joinin.activity.JoininNjjActivity;
import com.rxjy.rxcompound.mvp.contract.LoginContract;
import com.rxjy.rxcompound.mvp.presenter.LoginPresenter;
import com.rxjy.rxcompound.supervision.activity.SupervisionMainActivity;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;
import com.rxjy.rxcompound.utils.ZJson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 登录页面
 * Created by hjh on 2017/11/3.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    private String TAG = "LoginActivity";

    @Bind(R.id.ed_phone)
    EditText ed_phone;
    @Bind(R.id.ed_vitifycode)
    EditText ed_vitifycode;
    @Bind(R.id.ed_pwd)
    EditText ed_pwd;

    @Bind(R.id.tv_vitifycodeget)
    TextView tv_vitifycodeget;
    @Bind(R.id.tv_forgetpwd)
    TextView tv_forgetpwd;

    @Bind(R.id.btn_next)
    Button btn_next;

    @Bind(R.id.rl_veritycode)
    RelativeLayout rl_veritycode;
    @Bind(R.id.rl_phone)
    RelativeLayout rl_phone;
    @Bind(R.id.rl_pwd)
    RelativeLayout rl_pwd;
    @Bind(R.id.ll_toforget)
    LinearLayout ll_toforget;
    @Bind(R.id.tv_prompt)
    TextView tv_prompt;


    String phonenum, veritycode, pwdnum;
    int logintype;//0：验证码登  1：密码登录


    @Override
    public int getLayout() {
        return R.layout.activity_loginfirst;
    }

    @Override
    public void initData() {

        rl_veritycode.setVisibility(View.GONE);
        btn_next.setVisibility(View.GONE);
        rl_pwd.setVisibility(View.GONE);
        tv_forgetpwd.setVisibility(View.GONE);
        ll_toforget.setVisibility(View.GONE);
        ed_phone.addTextChangedListener(new MyEditListener(ed_phone));
    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_next, R.id.tv_vitifycodeget, R.id.tv_forgetpwd, R.id.ll_toforget})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
//                startActivity(new Intent(this, SupervisionMainActivity.class));
                veritycode = ed_vitifycode.getText().toString();
                pwdnum = ed_pwd.getText().toString();
                if (pwdnum.length() < 6) {
                    tv_prompt.setText("密码不少于6位");
                    return;
                }
                showLoading();
                switch (logintype) {
                    case 1:
                        if (!phonenum.isEmpty() && !veritycode.isEmpty() && !pwdnum.isEmpty()) {
                            //请求登录
                            mPresenter.tologin(phonenum, veritycode, pwdnum);
                        } else if (phonenum.isEmpty()) {
//                            ShowUtils.Toastshort(this, "请输入手机号！");
                            tv_prompt.setText("请输入手机号！");
                        } else if (veritycode.isEmpty()) {
//                            ShowUtils.Toastshort(this, "请输入验证码！");
                            tv_prompt.setText("请输入验证码！");
                        } else if (pwdnum.isEmpty()) {
//                            ShowUtils.Toastshort(this, "请输入密码！");
                            tv_prompt.setText("请输入密码！");
                        }
                        break;
                    case 0:
                        if (!phonenum.isEmpty() && !pwdnum.isEmpty()) {
                            //请求登录
                            mPresenter.tologin(phonenum, "", pwdnum);
                        } else if (phonenum.isEmpty()) {
//                            ShowUtils.Toastshort(this, "请输入手机号！");
                            tv_prompt.setText("请输入手机号！");
                        } else if (pwdnum.isEmpty()) {
//                            ShowUtils.Toastshort(this, "请输入密码！");
                            tv_prompt.setText("请输入密码！");
                        }
                        break;
                }

//                /**
//                 * 跳转温特斯
//                 */
////                startActivity(new Intent(this, NjjActivity.class));
//                /**
//                 * 跳转商务在职
//                 */
//                startActivity(new Intent(this, BusinessMainHostActivity.class));
                break;
            case R.id.tv_vitifycodeget:
                mPresenter.getVerityCode(phonenum);
                break;
            case R.id.tv_forgetpwd:
                startActivity(new Intent(this, ForgetPwdActivity.class).putExtra("phone", getphone));
                break;
            case R.id.ll_toforget:
                startActivity(new Intent(this, ForgetPwdActivity.class).putExtra("phone", getphone));
                break;

        }
    }

    /**
     * 判断用户是否存在
     *
     * @param data
     */
    String getphone = "";

    @Override
    public void responseIsCheck(VPhoneBean data) {
        switch (data.getStatusCode()) {
            case 0://用户存在
                tv_prompt.setText("");
                getphone = data.getBody().getPhone();
                btn_next.setText("登录");
                logintype = 0;
                btn_next.setVisibility(View.VISIBLE);
                rl_pwd.setVisibility(View.VISIBLE);
                tv_forgetpwd.setVisibility(View.VISIBLE);
                ll_toforget.setVisibility(View.VISIBLE);
                rl_veritycode.setVisibility(View.GONE);
                break;
            case 1://用户不存在,获取验证码注册
                tv_prompt.setText("");
                logintype = 1;
                rl_veritycode.setVisibility(View.VISIBLE);
                btn_next.setVisibility(View.VISIBLE);
                rl_pwd.setVisibility(View.VISIBLE);
                tv_forgetpwd.setVisibility(View.GONE);
                ll_toforget.setVisibility(View.GONE);
                break;
            default:
//                showToast(data.getStatusMsg());
                Log.e("hahahah", data.getStatusMsg());
                tv_prompt.setText(data.getStatusMsg());
                break;
        }
    }

    @Override
    public void responseTokenError(String msg) {

    }

    /**
     * 获取验证码
     *
     * @param data
     */
    @Override
    public void responseVerityCode(CheckIsBeingBean data) {
        switch (data.getStatusCode()) {
            case 0://发送成功，，，倒计时。。。
                updateTime();
                Toast.makeText(this, data.getStatusMsg(), Toast.LENGTH_SHORT).show();
                break;
            case -1://发送失败
                Toast.makeText(this, data.getStatusMsg(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void responseVerityError(String msg) {
    }


    String cardno;

    /**
     * 登录
     *
     * @param data
     */
    int regionid, departs, stages, stage;

    @Override
    public void responseLogin(CheckIsBeingBean data) {

        SharedPreferences msp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = msp.edit();
        edit.putString("rxdy_phonenum", phonenum);
        edit.putString("rxdy_start", data.getBody().getU_start() + "");
        edit.putString("rxdy_cardno", data.getBody().getCardNo());
        edit.putString("rxdy_token", data.getBody().getToken());
        edit.putString("rxdy_phone", ed_phone.getText().toString());
        edit.putString("rxdy_pwd", ed_pwd.getText().toString());
        edit.commit();

        App.name = data.getBody().getName();
        cardno = data.getBody().getCardNo();
        App.cardNo = data.getBody().getCardNo();
        App.token = data.getBody().getToken();
        Log.e("-------------登陆--------", data.getBody().getToken());
        App.depart = data.getBody().getDepart() + "";
        App.regionid = data.getBody().getRegion_id() + "";///39阶段小于2，请求
        App.account = data.getBody().getAccount();
        App.postid = data.getBody().getPost_id();
        App.apptype = data.getBody().getDepart();
        App.postName = data.getBody().getPostName();
        App.regionname = data.getBody().getRegion_name();
        App.name = data.getBody().getName();
        App.icon = data.getBody().getImage();
        App.appstage = data.getBody().getApp_stage();
        App.is_exist = data.getBody().getIs_exist();
        App.dcid = data.getBody().getDepart();
        App.ustart = data.getBody().getU_start();
        App.is_group = data.getBody().getIs_group();
        App.setContext(this);
        App.setAlias(data.getBody().getAccount());
        regionid = data.getBody().getRegion_id();
        departs = data.getBody().getDepart();
        stages = data.getBody().getApp_stage();

        stage = App.stage;
        mPresenter.getUserStatus(cardno);
        startLogin();
//        //判断部门决定跳转到哪个App
//        ToMain(data.getBody().getDepart(),data.getBody().getApp_stage(),cardno);

    }

    private void startLogin() {

        Map map = new HashMap();
        map.put("app_id", "");
        map.put("card_no", App.cardNo);
        map.put("landing_date", "");
        map.put("offline_date", "");
        map.put("locate_province_now", "");
        map.put("locate_city_now", "");
        map.put("a_equipment ", android.os.Build.MODEL);//使用设备
        map.put("network_status ", "");//网络状态
        map.put("a_ip ", getIp(this));//IP地址
        map.put("id", "");
        map.put("flag", "");
        map.put("name", "");
        map.put("create_date", "");
        map.put("update_date", "");
//        {
//            "app_id": "string",
//                "card_no": "string",
//                "landing_date": "2018-06-22T07:16:27.303Z",
//                "offline_date": "2018-06-22T07:16:27.303Z",
//                "locate_province_now": "string",
//                "locate_city_now": "string",
//                "a_equipment": "string",
//                "network_status": "string",
//                "a_ip": "string",
//                "id": 0,
//                "flag": 0,
//                "name": "string",
//                "create_date": "2018-06-22T07:16:27.303Z",
//                "update_date": "2018-06-22T07:16:27.303Z"
//        }

//        map.put("locate_province_now", -1);//当前定位省
//        map.put("locate_city_now", -1);//当前定位市

        String toJSONMap = ZJson.toJSONMap(map);
        OkHttpClient client = new OkHttpClient();
        MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url("https://api.dcwzg.com:9191/actionapi/AppHome/AddlandingMessage")
                .post(RequestBody.create(MEDIA_TYPE_TEXT, toJSONMap))
                .build();
        Log.e("tag_数据统计", toJSONMap);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_数据统计_失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_数据统计", string);
            }
        });

    }

    public static String getIp(final Context context) {
        String ip = null;
        ConnectivityManager conMan = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        // mobile 3G Data Network
        android.net.NetworkInfo.State mobile = conMan.getNetworkInfo(
                ConnectivityManager.TYPE_MOBILE).getState();
        // wifi
        android.net.NetworkInfo.State wifi = conMan.getNetworkInfo(
                ConnectivityManager.TYPE_WIFI).getState();

        // 如果3G网络和wifi网络都未连接，且不是处于正在连接状态 则进入Network Setting界面 由用户配置网络连接
        if (mobile == android.net.NetworkInfo.State.CONNECTED
                || mobile == android.net.NetworkInfo.State.CONNECTING) {
            ip = getLocalIpAddress();
        }
        if (wifi == android.net.NetworkInfo.State.CONNECTED
                || wifi == android.net.NetworkInfo.State.CONNECTING) {
            //获取wifi服务
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            //判断wifi是否开启
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int ipAddress = wifiInfo.getIpAddress();
            ip = (ipAddress & 0xFF) + "." +
                    ((ipAddress >> 8) & 0xFF) + "." +
                    ((ipAddress >> 16) & 0xFF) + "." +
                    (ipAddress >> 24 & 0xFF);
        }
        return ip;

    }

    private static String getLocalIpAddress() {
        try {
            //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {//获取IPv4的IP地址
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }


        return null;
    }

    private void ToMain(int type, int stage, String cardno) {
        Log.e("tag", "++++++++++");
        dismissLoading();
        switch (App.is_group) {
            case "0"://分公司
                if (App.ustart != 2 && App.ustart != 3 && App.ustart != 4) {
                    if (type == 2) {
                        isShowDaTi(BusinessMainHostActivity.class);
                    } else if (type == 3) {
                        isShowDaTi(NjjActivity.class);
                    } else if (type == 4) {//项目监理
                        isShowDaTi(SupervisionMainActivity.class);
                    } else {
                        isShowDaTi(MainTabHostActivity.class);
                    }
                } else {
                    if (App.stage > 1) {
                        if (type == 2) {
                            /**
                             * 跳转顾问在职
                             */ //
                            startActivity(new Intent(this, BusinessMainHostActivity.class).putExtra("isShow",1));
                            finish();
                        } else if (type == 3) {
                            //跳转温特斯 //主案
                            startActivity(new Intent(this, NjjActivity.class).putExtra("isShow",1));
                        } else if (type == 4) {//项目监理
                            //SupervisionMainActivity
                            startActivity(new Intent(this, SupervisionMainActivity.class).putExtra("isShow",1));
                            finish();
                        } else {
//                if (data.getBody().getApp_stage() > 1) {//资料以及完善
                            startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow",1));
                            finish();
                            Log.e("tag", "ccccccccccccc");
                        }
                    } else {
                        App.stage = 2;
                        mPresenter.getIsConsent(cardno, "2");//请求是否需要同意协议
                        Log.e("tag", "ddddddddd");
                    }

                }
                break;
            case "1"://集团
                Log.e("部门---", "集团");
                if (App.ustart != 2 && App.ustart != 3 && App.ustart != 4) {
                    isShowDaTi(MainTabHostActivity.class);
                } else {
                    Log.e("-----", "老员工");
                    if (App.stage > 1) {//资料以及完善
//                if (data.getBody().getApp_stage() > 1) {//资料以及完善
                        if (App.postName.equals("客服主管") || App.postName.equals("客服专员") || (App.postName.equals("客服经理") || App.postName.equals("平台客服"))) {
                            App.busisnew = 1;
                            startActivity(new Intent(this, BusinessMainHostActivity.class).putExtra("isShow",1));
                            finish();
                        } else {
                            startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow",1));
                            finish();
                            Log.e("tag", "ccccccccccccc");
                        }
                    } else {
                        App.stage = 2;
                        mPresenter.getIsConsent(cardno, "2");//请求是否需要同意协议
                        Log.e("tag", "ddddddddd");
                    }
                }

                break;
            case "2"://招商

                Log.e("tag", "---------");
                if (App.stage > 1) {//资料以及完善
                    if (App.postid == 10000) {
                        //外部人事
                        if (App.is_exist == 0) {//未同意
                            startActivity(new Intent(this, AgreeDesActivity.class).putExtra("isShow",1));
                            finish();
                        } else {//NjjActivity
                            startActivity(new Intent(this, NjjActivity.class).putExtra("isShow",1));
                            finish();
                        }
                    } else if (App.postid == 30001) {
                        //招商
                        startActivity(new Intent(this, JoininNjjActivity.class).putExtra("isShow",1));
                        finish();
                    } else {
                        startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow",1));
                        finish();
                        Log.e("tag", "ccccccccccccc");
                    }
//                if (data.getBody().getApp_stage() > 1) {//资料以及完善

                } else {
                    App.stage = 2;
                    mPresenter.getIsConsent(cardno, "2");//请求是否需要同意协议
                    Log.e("tag", "ddddddddd");
                }

                break;
            default:

                break;
        }

    }


    @Override
    public void responseLoginError(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        tv_prompt.setText(msg);
    }

    @Override
    public void responseIsConsent(CheckIsBeingBean data) {
        //已同意
        ToMain(departs, stage, cardno);

    }

    @Override
    public void responseIsConsentError(String msg) {//未同意
        if (msg.equals("连接失败")) {
            tv_prompt.setText(msg);
        } else {
            startActivity(new Intent(this, EntryJobProtocolActivity.class).putExtra("from", "1"));
            finish();
        }
    }

    @Override
    public void responseUserStatus(UserStatusBean data) {
        Log.e("tag", "11111111111");
        ToMain(departs, stage, cardno);
    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void responseIsPrefect(PersonBean data) {
//        if (data.getBody().getIsFinsh() == 0) {//未完善资料
//            startActivity(new Intent(this, BaseInformationActivity.class));
//            finish();
//        } else if (data.getBody().getIsFinsh() == 1) {//完善已审批
//            startActivity(new Intent(this, MainTabHostActivity.class));
//            finish();
//        }
    }

    @Override
    public void responseIsPrefectError(String msg) {
//        showToast(msg);
        tv_prompt.setText(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {
//        tv_prompt.setText("连接失败");
        dismissLoading();
    }

    @Override
    public void responseZiDonLogin(ZiDonBean ziDonBean) {

    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int time = msg.arg1;
            if (tv_vitifycodeget != null) {
                tv_vitifycodeget.setText(time + "s后重发");
                tv_vitifycodeget.setEnabled(false);
                tv_vitifycodeget.setBackgroundColor(getResources().getColor(R.color.colorline));
                if (time == 0) {
                    tv_vitifycodeget.setText("获取验证码");
                    tv_vitifycodeget.setEnabled(true);
                    tv_vitifycodeget.setBackgroundColor(getResources().getColor(R.color.colorred));
                }
            }
        }
    };

    //倒计时
    private void updateTime() {
        new Thread() {
            public void run() {
                for (int i = 60; i >= 0; --i) {
                    Message msg = handler.obtainMessage();
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                    SystemClock.sleep(1000);     //  1s
                }
            }
        }.start();
    }

    public void isShowDaTi(final Class cls) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder().url("http://edu.rxjy.com/a/api/"+App.cardNo+"/isViewCurr").build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_是否答题失败",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_是否答题",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            Intent intent = new Intent(LoginActivity.this, cls);
                            if(statusCode == 0){
                                intent.putExtra("isShow",0);
                            }else {
                                intent.putExtra("isShow",1);
                            }
                            startActivity(intent);
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }


    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }

        @Override
        public void afterTextChanged(Editable arg0) {
            int lengths = arg0.length();
            switch (edittext.getId()) {
                case R.id.ed_phone:
                    phonenum = ed_phone.getText().toString();
                    if (lengths == 11) {//11手机号位请求判断
                        String strthree = phonenum.substring(0, 3);
                        if (!strthree.equals("WTS")) {
                            mPresenter.getCheckIsVerity(phonenum);
                        } else {
                            mPresenter.getCheckIsVerity(phonenum);
                        }
                    } else if (lengths == 8) {
                        String strthree = phonenum.substring(0, 3);
                        if (!strthree.equals("WTS")) {
                            int cardnum = 0;
                            try {
                                cardnum = Integer.parseInt(phonenum);
                                if (cardnum < 10000000) {
                                    mPresenter.getCheckIsVerity(phonenum);
                                }
                            } catch (Exception e) {
//                                showToast("请输入正确的账号！");
                                tv_prompt.setText("请输入正确的账号！");
                            }
                        }

                    } else {
                        tv_prompt.setText("");
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

}