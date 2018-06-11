package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MessageDetailsBean;
import com.rxjy.rxcompound.mvp.contract.MessageDetailsContract;
import com.rxjy.rxcompound.mvp.presenter.MessageDetailsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/9.
 */

public class MessageDetailsActivity extends BaseActivity<MessageDetailsPresenter> implements MessageDetailsContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_titles)
    TextView tvTitles;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.tv_moneynum)
    TextView tvMoneynum;
    @Bind(R.id.tv_person)
    TextView tvPerson;

    @Override
    public int getLayout() {
        return R.layout.activity_messagethree;
    }

    @Override
    public void initData() {
        tvTitle.setText("消息详情");
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.getInfoMessageDList(id);
    }

    @Override
    protected MessageDetailsPresenter onCreatePresenter() {
        return new MessageDetailsPresenter(this);
    }

    @Override
    public void responseInfoMessageD(MessageDetailsBean data) {
        tvTitles.setText(data.getBody().getTitle());
        tvContent.setText(data.getBody().getTxt());
        tvTime.setText(data.getBody().getCreate_date());
        if(!StringUtils.isEmpty(data.getBody().getInitiator_name())){
            tvPerson.setText(data.getBody().getInitiator_name());
            tvPerson.setVisibility(View.VISIBLE);
        }else{
            tvPerson.setVisibility(View.GONE);
        }
        if(!StringUtils.isEmpty(data.getBody().getReward_money())){
            int money= Integer.parseInt(data.getBody().getReward_money());
            tvMoneynum.setText(data.getBody().getReward_money());
            tvMoneynum.setVisibility(View.VISIBLE);
            tvMoney.setVisibility(View.VISIBLE);
            if(money==0){
                tvMoneynum.setVisibility(View.GONE);
                tvMoney.setVisibility(View.GONE);
            }else if(money>0){
                tvMoneynum.setTextColor(this.getResources().getColor(R.color.colorPrimarys));
            }else{
                tvMoneynum.setTextColor(this.getResources().getColor(R.color.textred));
            }
        }else{
            tvMoneynum.setVisibility(View.GONE);
            tvMoney.setVisibility(View.GONE);
        }
    }

    @Override
    public void responseInfoMessageDError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}