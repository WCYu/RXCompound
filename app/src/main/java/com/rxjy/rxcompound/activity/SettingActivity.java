package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.BusinessMainHostActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ACache;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.joinin.activity.JoininNjjActivity;
import com.rxjy.rxcompound.mvp.contract.SettingContract;
import com.rxjy.rxcompound.mvp.presenter.SettingPresenter;
import com.rxjy.rxcompound.supervision.activity.SupervisionMainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.rxjy.rxcompound.commons.App.jpushname;

/**
 * 设置
 * Created by hjh on 2017/11/16.
 */
public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {

    @Bind(R.id.btn_exitlogin)
    Button btn_exitlogin;
    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.tv_version)
    TextView tv_version;
    @Bind(R.id.rl_pwdfix)
    RelativeLayout rlPwdfix;

    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    ACache aCache;
    String cardno;

    @Override
    public void initData() {
        aCache = ACache.get(this);
        tv_title.setText("设置");
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        try {
            String verson = StringUtils.getVersionName(this);
            tv_version.setText(verson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str="one lady程序员";
    }

    @Override
    protected SettingPresenter onCreatePresenter() {
        return new SettingPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_exitlogin, R.id.iv_back,R.id.rl_pwdfix})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exitlogin:
                aCache.put("rx_persondata", "");
                SharedPreferences msp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
                SharedPreferences jpush_msp = getSharedPreferences(Constants.IS_SETALIAS, Activity.MODE_PRIVATE);
                SharedPreferences.Editor edit = msp.edit();
                SharedPreferences.Editor jpush_edit = jpush_msp.edit();
                edit.putString("rxdy_phonenum", "");
                edit.putString("rxdy_cardno", "");
                edit.putString("rxdy_phone", "");
                edit.putString("rxdy_pwd", "");
                edit.commit();
                jpush_edit.putString(jpushname, null);
                jpush_edit.commit();
                startActivity(new Intent(this, LoginActivity.class));
                if (MainTabHostActivity.instance != null) {
                    MainTabHostActivity.instance.finish();
                }
                if (NjjActivity.activity != null) {
                    NjjActivity.activity.finish();
                }
                if (BusinessMainHostActivity.activity != null) {
                    BusinessMainHostActivity.activity.finish();
                }
                if (SupervisionMainActivity.activity != null) {
                    SupervisionMainActivity.activity.finish();
                }
                if (JoininNjjActivity.activity != null) {
                    JoininNjjActivity.activity.finish();
                }
                App.busisnew = 0;
                finish();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_pwdfix:

                break;
        }
    }


    @Override
    public void responseConsent(CheckIsBeingBean data) {
        startActivity(new Intent(this, LoginActivity.class));
        MainTabHostActivity.instance.finish();
        finish();
    }

    @Override
    public void responseConsentError(String msg) {
        if (msg != null) {
            ShowUtils.Toastshort(this, msg);
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

}