package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.BusinessMainHostActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.DownLoadApk;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.entity.VPhoneBean;
import com.rxjy.rxcompound.entity.VersionInfo;
import com.rxjy.rxcompound.entity.ZiDonBean;
import com.rxjy.rxcompound.joinin.activity.JoininNjjActivity;
import com.rxjy.rxcompound.mvp.contract.LoginContract;
import com.rxjy.rxcompound.mvp.model.MainModel;
import com.rxjy.rxcompound.mvp.presenter.LoginPresenter;
import com.rxjy.rxcompound.supervision.activity.SupervisionMainActivity;
import com.rxjy.rxcompound.utils.OkhttpUtils;
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

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Subscriber;
import rx.Subscription;


/**
 * 启动页
 * Created by hjh on 2017/11/7.
 */

public class SplashActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    boolean IsFirst = false;
    private static final int TO_LoginActivity = 1000;
    private static final int TO_Guide = 1001;
    private static final long SPLASH_DELAY_MILLIS = 1000;//延时时间
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        getVersionInfo(Integer.parseInt(App.getVersionCode()));
    }

    private void getVersionInfo(int version) {
        Log.e("tag_版本号", version + "");
        MainModel mModel = new MainModel();
        Subscription subscribe = mModel.getVersionInfo(version)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag_获取版本信息失败Splash", "获取版本信息失败 = " + e.toString());
                        init();
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag_获取版本信息Splash", "tag_获取版本信息" + s);
                        VersionInfo info = JSONUtils.toObject(s, VersionInfo.class);
                        if (info.getStatusCode() == 1) {
                            VersionInfo.Version data = info.getBody();
                            if (data != null) {
                                responseVersionData(data);
                            }
                        } else {
                            init();
                        }
                    }
                });

    }

    private void responseVersionData(final VersionInfo.Version data) {
        Log.e("tag_开始", "开始下载");
        if (data.getVersionNo() > Integer.parseInt(App.getVersionCode())) {
            Log.e("tag_成功", "成功下载");
            View view = LayoutInflater.from(this).inflate(R.layout.item_shengji, null);
            TextView shengji = (TextView) view.findViewById(R.id.tv_shengji);
            TextView quxiao = (TextView) view.findViewById(R.id.tv_quxiao);
            TextView contentTv = (TextView) view.findViewById(R.id.tv_content);
            if (data != null) {
                String content = data.getContent();
                if (!TextUtils.isEmpty(content)) {
                    contentTv.setText(content);
                }
                int force = data.getForce();
                Log.e("tag_成功", "成功下载" + force);
                if (force == 1) {
                    quxiao.setVisibility(View.GONE);
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            builder.setCancelable(false);// 设置点击屏幕Dialog不消失
            final AlertDialog dialog = builder.create();
            dialog.show();
            shengji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    DownLoadApk downLoadApk = new DownLoadApk(SplashActivity.this);
                    downLoadApk.downLoadApk(data);
                }
            });

            quxiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialog != null) {
                        dialog.dismiss();
                        init();
                    }
                }
            });
        } else {
            Log.e("tag_失败", "失败");
            init();
        }
        Log.e("tag_结束", "结束下载");
    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }

    String phone, pwd;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TO_Guide:
                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case TO_LoginActivity:
                    SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
                    phone = sp.getString("rxdy_phone", null);
                    pwd = sp.getString("rxdy_pwd", null);
                    token = sp.getString("rxdy_token", null);
                    if (!StringUtils.isEmpty(phone) && !StringUtils.isEmpty(pwd)) {
                        mPresenter.getCheckToken(phone, token);
                    } else {
                        Intent intentl = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intentl);
                        finish();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void init() {
        Log.e("开始", "开始");
        //读取存储，记录应用启动次数
        SharedPreferences preferences = getSharedPreferences(Constants.IS_FIRST_SPLASH, MODE_PRIVATE);
        IsFirst = preferences.getBoolean("IsFirst", true);
        if (IsFirst) {
            preferences.edit().putBoolean("IsFirst", false).commit();
            Log.e("1", "1");
            handler.sendEmptyMessageDelayed(TO_Guide, SPLASH_DELAY_MILLIS);
        } else {
            Log.e("2", "2");
            handler.sendEmptyMessageDelayed(TO_LoginActivity, SPLASH_DELAY_MILLIS);//
        }
        Log.e("结束", "结束");
    }


    @Override
    public void responseIsCheck(VPhoneBean data) {

    }

    @Override
    public void responseTokenError(String msg) {
        showToast(msg);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void responseVerityCode(CheckIsBeingBean data) {

    }

    @Override
    public void responseVerityError(String msg) {

    }

    String cardno;
    int regionid, departs, stages, stage;

    @Override
    public void responseLogin(CheckIsBeingBean data) {

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
        Log.e("app", type + "");
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
                            startActivity(new Intent(this, BusinessMainHostActivity.class).putExtra("isShow", 1));
                            finish();
                        } else if (type == 3) {
                            //跳转温特斯 //主案
                            startActivity(new Intent(this, NjjActivity.class).putExtra("isShow", 1));
                        } else if (type == 4) {//项目监理
                            //SupervisionMainActivity
                            startActivity(new Intent(this, SupervisionMainActivity.class).putExtra("isShow", 1));
                            finish();
                        } else {
//                if (data.getBody().getApp_stage() > 1) {//资料以及完善
                            startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow", 1));
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
                        if (!TextUtils.isEmpty(App.postName)) {
                            if (App.postName.equals("客服主管") || App.postName.equals("客服专员") || (App.postName.equals("客服经理") || App.postName.equals("平台客服"))) {
                                App.busisnew = 1;
                                startActivity(new Intent(this, BusinessMainHostActivity.class).putExtra("isShow", 1));
                                finish();
                            } else {
                                startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow", 1));
                                finish();
                                Log.e("tag", "ccccccccccccc");
                            }
                        } else {
                            startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow", 1));
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
                            startActivity(new Intent(this, AgreeDesActivity.class).putExtra("isShow", 1));
                            finish();
                        } else {//NjjActivity
                            startActivity(new Intent(this, NjjActivity.class).putExtra("isShow", 1));
                            finish();
                        }
                    } else if (App.postid == 30001) {
                        //招商
                        startActivity(new Intent(this, JoininNjjActivity.class).putExtra("isShow", 1));
                        finish();
                    } else {
                        startActivity(new Intent(this, MainTabHostActivity.class).putExtra("isShow", 1));
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

//        if (App.postName.equals("客服主管") || App.postName.equals("客服专员") || App.postName.equals("客服经理") || App.postName.equals("平台客服")) {
//            App.busisnew = 1;
//            startActivity(new Intent(this, BusinessMainHostActivity.class));
//            finish();
//        } else if (type == 2) {
//            /**
//             * 跳转顾问在职
//             *///JoininNjjActivity
//            startActivity(new Intent(this, BusinessMainHostActivity.class));
//            finish();
//        } else if (type == 3) {
//            //跳转温特斯 //主案
//            startActivity(new Intent(this, NjjActivity.class));
//        } else if (type == 4) {//项目监理
//            //SupervisionMainActivity
//            startActivity(new Intent(this, SupervisionMainActivity.class));
//            finish();
//        } else if (App.postid == 10000) {
//            //  外部人事会员
//            if (App.is_exist == 0) {//未同意
//                startActivity(new Intent(this, AgreeDesActivity.class));
//                finish();
//            } else {//NjjActivity
//                startActivity(new Intent(this, NjjActivity.class));
//                finish();
//            }
//        }
//        else if (App.postid == 30001) {
//            //招商
//            startActivity(new Intent(this, JoininNjjActivity.class));
//            finish();
//        }
//        else {
//            if (stage > 1) {//资料以及完善
////                if (data.getBody().getApp_stage() > 1) {//资料以及完善
//                startActivity(new Intent(this, MainTabHostActivity.class));
//                finish();
//            } else {
//                App.stage=2;
//                mPresenter.getIsConsent(cardno, "2");//请求是否需要同意协议
//            }
//        }


    }

    public void isShowDaTi(final Class cls) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder().url("http://edu.rxjy.com/a/api/" + App.app_id + "/isViewQues").build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_是否显示答题失败", e.getMessage().toString());
                Intent intent = new Intent(SplashActivity.this, cls);
                intent.putExtra("isShow", 0);
                startActivity(intent);
                finish();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_是否显示答题", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            Intent intent = new Intent(SplashActivity.this, cls);
                            if (statusCode == 0) {
                                intent.putExtra("isShow", 0);
                            } else {
                                intent.putExtra("isShow", 1);
                            }
                            startActivity(intent);
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        }
                    }
                });
            }
        });
    }

    @Override
    public void responseLoginError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Intent intentl = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intentl);
        finish();
    }

    @Override
    public void responseIsConsent(CheckIsBeingBean data) {
        //已同意
        ToMain(departs, stage, cardno);
    }

    @Override
    public void responseIsConsentError(String msg) {
        startActivity(new Intent(this, EntryJobProtocolActivity.class).putExtra("from", "1"));
        finish();
    }

    @Override
    public void responseUserStatus(UserStatusBean data) {
//        if (regionid == 39 && data.getBody().getStage() < 2) {//请求一个接口
//            mPresenter.getLoginTz(cardno, "Z1||type|1");
//            ToMain(departs, stage, cardno);
//        } else {
        ToMain(departs, stage, cardno);
        //    }
    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void responseIsPrefect(PersonBean data) {
        if (data.getBody().getIsFinsh() == 0) {//未完善资料
            startActivity(new Intent(this, BaseInformationActivity.class));
            finish();
        } else if (data.getBody().getIsFinsh() == 1) {//完善已审批
            startActivity(new Intent(this, MainTabHostActivity.class));
            finish();
        }

    }

    @Override
    public void responseIsPrefectError(String msg) {
        showToast(msg);
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void responseZiDonLogin(ZiDonBean data) {
        Log.e("app.is_exist", App.is_exist + "");
        SharedPreferences msp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = msp.edit();
        edit.putString("rxdy_phonenum", phone);
        edit.putString("rxdy_start", data.getBody().getU_start() + "");
        edit.putString("rxdy_cardno", data.getBody().getCardNo());
        edit.putString("rxdy_phone", phone);
        edit.putString("rxdy_pwd", pwd);
        edit.commit();
        cardno = data.getBody().getCardNo();
        App.cardNo = data.getBody().getCardNo();
        App.depart = data.getBody().getDepart() + "";
        App.regionid = data.getBody().getRegion_id() + "";
        App.account = data.getBody().getAccount();
        App.postid = data.getBody().getPost_id();
        App.apptype = data.getBody().getDepart();
        App.regionname = data.getBody().getRegion_name();
        Log.e("aaaa.is_exist", App.is_exist + "");
        App.name = data.getBody().getName();
        App.appstage = data.getBody().getApp_stage();
        App.icon = data.getBody().getImage();
        App.postName = data.getBody().getPostName();
        App.is_exist = data.getBody().getIs_exist();
        App.dcid = data.getBody().getDepart();
        App.ustart = data.getBody().getU_start();
        App.is_group = data.getBody().getIs_group() + "";
        App.app_id = data.getBody().getApp_id();
        regionid = data.getBody().getRegion_id();
        startLogin();
        departs = data.getBody().getDepart();

        stages = data.getBody().getApp_stage();
        stage = App.stage;
        mPresenter.getUserStatus(cardno);
    }
}
