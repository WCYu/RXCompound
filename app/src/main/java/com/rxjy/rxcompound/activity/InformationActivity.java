package com.rxjy.rxcompound.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ACache;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.MsgNumBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人资料
 * Created by hjh on 2017/11/6.
 */
public class InformationActivity extends BaseActivity<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.ic_back)
    ImageView ic_back;
    @Bind(R.id.iv_icon)
    ImageView iv_icon;
    @Bind(R.id.tv_name)
    TextView tv_name;
    @Bind(R.id.tv_sex)
    TextView tv_sex;
    @Bind(R.id.tv_phonenum)
    TextView tv_phonenum;
    @Bind(R.id.tv_ismarry)
    TextView tv_ismarry;
    ACache aCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_information;
    }

    @Override
    public void initData() {
        aCache=ACache.get(this);
        String persondata=aCache.getAsString("rx_persondata");
        if(persondata!=null){
            PersonBean info = JSONUtils.toObject(persondata, PersonBean.class);
            tv_name.setText(info.getBody().getName());
            tv_sex.setText(info.getBody().getSex());
            tv_phonenum.setText(info.getBody().getPhone());
            tv_ismarry.setText(info.getBody().getMarriage());
            Glide.with(this).load(info.getBody().getImage()).into(iv_icon);
        }
    }

    @OnClick({R.id.ic_back})
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.ic_back:
                finish();
                break;
        }
    }

    @Override
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }



    @Override
    public void responsegetMessage(String s, PersonBean data) {

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
}
