package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.GlideCircleTransform;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.entity.ShopBean;
import com.rxjy.rxcompound.des.mvp.contract.ShopContract;
import com.rxjy.rxcompound.des.mvp.presenter.ShopPresenter;
import com.rxjy.rxcompound.widget.StarBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/24.
 */

public class BusShopActivity extends BaseActivity<ShopPresenter> implements ShopContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_header)
    TextView tvHeader;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.user_English)
    TextView userEnglish;
    @Bind(R.id.annual_salary)
    TextView annualSalary;
    @Bind(R.id.user_age)
    TextView userAge;
    @Bind(R.id.postage)
    TextView postage;
    @Bind(R.id.Proverbs)
    TextView Proverbs;
    @Bind(R.id.shop_vCode)
    ImageView shopVCode;
    @Bind(R.id.starBar)
    StarBar starBar;
    private ShopBean.BodyBean bodyBean;

    @Override
    public int getLayout() {
        return R.layout.activity_shop;
    }

    @Override
    public void initData() {
        tvHeader.setVisibility(View.VISIBLE);
        tvHeader.setText("修改");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.GetShopBean("00000003");
    }

    @Override
    protected ShopPresenter onCreatePresenter() {
        return new ShopPresenter(this);
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
    public void showMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void shopresopneData(ShopBean.BodyBean bodyBean) {
        if (StringUtils.isEmpty(bodyBean.getUm_Name())) {
            userName.setText("无");
        } else {
            userName.setText(bodyBean.getUm_Name());
        }
        if (StringUtils.isEmpty(bodyBean.getUm_Age())) {
            userAge.setText("无");
        } else {
            userAge.setText(bodyBean.getUm_Age() + "");
        }
        if (StringUtils.isEmpty(bodyBean.getUm_EnglishName())) {
            userEnglish.setText("无");
        } else {
            userEnglish.setText(bodyBean.getUm_EnglishName() + "");
        }
        if (StringUtils.isEmpty(bodyBean.getUm_Motto())) {
            Proverbs.setText("无");
        } else {
            Proverbs.setText(bodyBean.getUm_Motto() + "");
        }
        //annualSalary
        if (StringUtils.isEmpty(bodyBean.getUm_WorkYears())) {
            annualSalary.setText("无");
        } else {
            annualSalary.setText(bodyBean.getUm_WorkYears() + "");
        }
        Glide.with(this).load(bodyBean.getUm_QRCode()).into(shopVCode);
        //consultation
        //um_ImagePhoto
        starBar.setStarMark(2.4f);
        if (StringUtils.isEmpty(bodyBean.getUm_Consultation())) {
            postage.setText("无");
        } else {
            postage.setText(bodyBean.getUm_Consultation() + "");
        }
//        RequestOptions options = new RequestOptions();
//        options.centerCrop().transform(new GlideCircleTransform(this));
//        Glide.with(this).load(datas.getPassport_photo()).apply(options).into(icIcon);
        this.bodyBean = bodyBean;
    }


    @OnClick({R.id.iv_back, R.id.tv_header})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_header:
                startActivity(new Intent(this, ShopModifyActivity.class).putExtra("content", bodyBean));
                break;
        }
    }

}
