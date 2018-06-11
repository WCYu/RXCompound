package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.BusinessMainHostActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.entity.VPhoneBean;
import com.rxjy.rxcompound.entity.ZiDonBean;
import com.rxjy.rxcompound.joinin.activity.JoininNjjActivity;
import com.rxjy.rxcompound.mvp.contract.LoginContract;
import com.rxjy.rxcompound.mvp.presenter.LoginPresenter;
import com.rxjy.rxcompound.supervision.activity.SupervisionMainActivity;

import butterknife.ButterKnife;

import static com.rxjy.rxcompound.receiver.MessageReceiver.MSG_NUM;
import static com.rxjy.rxcompound.receiver.MessageReceiver.msgnum;

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

        init();

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
                        mPresenter.getCheckToken(phone,token);

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
        //读取存储，记录应用启动次数
        SharedPreferences preferences = getSharedPreferences(Constants.IS_FIRST_SPLASH, MODE_PRIVATE);
        IsFirst = preferences.getBoolean("IsFirst", true);
        if (IsFirst) {
            preferences.edit().putBoolean("IsFirst", false).commit();
            handler.sendEmptyMessageDelayed(TO_Guide, SPLASH_DELAY_MILLIS);
        } else {
            handler.sendEmptyMessageDelayed(TO_LoginActivity, SPLASH_DELAY_MILLIS);//
        }
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
    int regionid, departs, stages;

    @Override
    public void responseLogin(CheckIsBeingBean data) {

    }

    private void ToMain(int type, int stage, String cardno) {
        Log.e("app", type + "");
        if (App.postName.equals("客服主管") || App.postName.equals("客服专员") || App.postName.equals("客服经理") || App.postName.equals("平台客服")) {
            App.busisnew = 1;
            startActivity(new Intent(this, BusinessMainHostActivity.class));
            finish();
        } else if (type == 2) {
            /**
             * 跳转顾问在职
             *///JoininNjjActivity
            startActivity(new Intent(this, BusinessMainHostActivity.class));
            finish();
        } else if (type == 3) {
            //跳转温特斯 //主案
            startActivity(new Intent(this, NjjActivity.class));
        } else if (type == 4) {//项目监理
            //SupervisionMainActivity
            startActivity(new Intent(this, SupervisionMainActivity.class));
            finish();
        } else if (App.postid == 10000) {
            //  外部人事会员
            if (App.is_exist == 0) {//未同意
                startActivity(new Intent(this, AgreeDesActivity.class));
                finish();
            } else {//NjjActivity
                startActivity(new Intent(this, NjjActivity.class));
                finish();
            }
        }
        else if (App.postid == 30001) {
            //招商
            startActivity(new Intent(this, JoininNjjActivity.class));
            finish();
        }
        else {
            if (stage > 1) {//资料以及完善
//                if (data.getBody().getApp_stage() > 1) {//资料以及完善
                startActivity(new Intent(this, MainTabHostActivity.class));
                finish();
            } else {
                stages=2;
                mPresenter.getIsConsent(cardno, "2");//请求是否需要同意协议
            }
        }


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
        ToMain(departs, stages, cardno);
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
//            ToMain(departs, stages, cardno);
//        } else {
            ToMain(departs, stages, cardno);
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
    }
    @Override
    public void showDialog() {

    }
    @Override
    public void hideDialog() {

    }
    @Override
    public void responseZiDonLogin(ZiDonBean data) {
        Log.e("app.is_exist", App.is_exist+"");
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
        Log.e("aaaa.is_exist", App.is_exist+"");
        App.name = data.getBody().getName();
        App.appstage = data.getBody().getApp_stage();
        App.icon = data.getBody().getImage();
        App.postName = data.getBody().getPostName();
        App.is_exist = data.getBody().getIs_exist();

        App.dcid = data.getBody().getDepart();
        App.ustart = data.getBody().getU_start();

        regionid = data.getBody().getRegion_id();

        departs = data.getBody().getDepart();

        stages = data.getBody().getApp_stage();

        mPresenter.getUserStatus(cardno);
    }
}