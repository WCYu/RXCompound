package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.AgreeDesContract;
import com.rxjy.rxcompound.mvp.presenter.AgreeDesPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/21.
 */

public class AgreeDesActivity extends BaseActivity<AgreeDesPresenter> implements AgreeDesContract.View {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_agree)
    ImageView ivAgree;
    //    @Bind(R.id.wb_rxsongs)
//    WebView wbRxsongs;
    private WebView wbRxsongs;
    @Bind(R.id.tv_agree)
    TextView tvAgree;

    @Override
    public int getLayout() {
        return R.layout.activity_desxieyi;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void initData() {
        tvTitle.setText("用户协议");
        wbRxsongs = (WebView) findViewById(R.id.wb_rxsongs);
        wbRxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wbRxsongs.loadUrl("http://www.wenes.cn/wenes/AgreementPage");

    }

    @Override
    protected AgreeDesPresenter onCreatePresenter() {
        return new AgreeDesPresenter(this);
    }

    @Override
    public void responseAgreeYes(ResultBean data) {
        //同意了跳转到主页
        showToast("同意协议成功！");
        startActivity(new Intent(this, MainTabHostActivity.class));
        finish();
    }

    @Override
    public void responseAgreeYesError(String msg) {
        showToast("请求同意协议失败！请重试！");
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    int isagree;
    @OnClick({R.id.iv_back, R.id.tv_agree,R.id.iv_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_agree:
                if(isagree==0){
                    showToast("您还未同意《用户协议》");
                }else{
                    mPresenter.getAgreeYes(App.cardNo, "4");
                }
                break;
            case R.id.iv_agree:
                if(isagree==0){
                    isagree=1;
                    ivAgree.setImageResource(R.mipmap.choice_icon_pre);
                }else{
                    isagree=0;
                    ivAgree.setImageResource(R.mipmap.choice_icon);
                }
                break;
        }
    }

}