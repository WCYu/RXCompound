package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.BusinessMainHostActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.EntryJobPContract;
import com.rxjy.rxcompound.mvp.presenter.EntryJobPresenter;
import com.rxjy.rxcompound.supervision.activity.SupervisionMainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/10.
 */

public class EntryJobProtocolActivity extends BaseActivity<EntryJobPresenter> implements EntryJobPContract.View {


    @Bind(R.id.cb_entrybox)
    CheckBox cb_entrybox;
    @Bind(R.id.wb_entryjobview)
    WebView wb_entryjobview;
    @Bind(R.id.tv_sure)
    TextView tv_sure;
    @Bind(R.id.ic_back)
    ImageView ic_back;

    String phonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    String isfrom, cardno;
    @Override
    public void responseConsent(CheckIsBeingBean data) {
        ToMain(App.apptype, App.appstage, cardno);

        finish();
//        if (isfrom != null && isfrom.equals("1")) {
//            startActivity(new Intent(this, BaseInformationActivity.class));
//            finish();
//        } else {
//            startActivity(new Intent(this, SecretSureActivity.class));
//            finish();
//        }
    }


    private void ToMain(int type, int stage, String cardno) {
        if(TextUtils.isEmpty(App.postName)){
            if(App.postName.equals("客服主管")||App.postName.equals("客服专员")){
                App.busisnew=1;
                startActivity(new Intent(this, BusinessMainHostActivity.class));
                finish();
            }else {
                switch (type) {
                    case 2://商务
                        /**
                         * 跳转商务在职
                         */
                        startActivity(new Intent(this, BusinessMainHostActivity.class));
                        finish();
                        break;
                    case 3://温特斯
                        /**
                         * 跳转温特斯
                         */
                        if (App.postid == 10000) {//会员
                            if (App.is_exist == 0) {//未同意
                                startActivity(new Intent(this, AgreeDesActivity.class));
                                finish();
                            } else {
                                startActivity(new Intent(this, NjjActivity.class));
                                finish();
                            }
                        } else {
                            startActivity(new Intent(this, NjjActivity.class));
                            finish();
                        }
                        break;
                    case 4://项目监理
                        startActivity(new Intent(this, SupervisionMainActivity.class));
                        finish();
                        break;
                    default://瑞祥平台
                        startActivity(new Intent(this, MainTabHostActivity.class));
                        finish();
                        break;
                }
            }
        }
    }

    @Override
    public void responseConsentError(String msg) {
        ShowUtils.Toastshort(this, msg);
    }

    @Override
    public void responseEntryJob(CheckIsBeingBean data) {

    }

    @Override
    public void responseEntryJobError(String msg) {

    }

    @Override
    public void responseIsConsent(ResultBean data) {

    }

    @Override
    public void responseIsConsentError(String msg) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_entryjobp;
    }


    @Override
    public void initData() {
        Intent intent = getIntent();
        isfrom = intent.getStringExtra("from");
        tv_sure.setBackgroundColor(getResources().getColor(R.color.textgreytwo));
        tv_sure.setEnabled(false);//设置不可点击
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = App.cardNo;
        ShowWebView();
        cb_entrybox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {//选中
                    tv_sure.setBackgroundColor(getResources().getColor(R.color.colorred));
                    tv_sure.setEnabled(true);//设置可点击
                } else {
                    tv_sure.setBackgroundColor(getResources().getColor(R.color.textgreytwo));
                    tv_sure.setEnabled(false);//设置不可点击
                }
            }
        });
    }

    /**
     * 显示入职需知
     */
    private void ShowWebView() {
        wb_entryjobview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wb_entryjobview.loadUrl(Constants.WEBURL_ENTRYJOB + "CardNo=" + cardno + "&Type=" + "2");
    }

    @OnClick({R.id.tv_sure, R.id.ic_back})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sure://同意协议
                mPresenter.getConsent(cardno, "2");
                break;
            case R.id.ic_back:
                finish();
                break;
        }
    }


    @Override
    protected EntryJobPresenter onCreatePresenter() {
        return new EntryJobPresenter(this);
    }
}
