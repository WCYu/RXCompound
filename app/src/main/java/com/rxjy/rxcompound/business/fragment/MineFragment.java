package com.rxjy.rxcompound.business.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.SettingActivity;
import com.rxjy.rxcompound.business.activity.BusiPersonMessage;
import com.rxjy.rxcompound.business.entity.MyGradeBean;
import com.rxjy.rxcompound.business.entity.MyGradeMoneyBean;
import com.rxjy.rxcompound.business.mvp.contract.MineContract;
import com.rxjy.rxcompound.business.mvp.presenter.MinePresenter;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.GlideCircleTransform;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/23.
 */

public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {

    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_vip)
    ImageView ivVip;
    @Bind(R.id.iv_levels)
    ImageView iv_levels;
    @Bind(R.id.iv_level)
    ImageView ivLevel;
    @Bind(R.id.pb_progress)
    ProgressBar pbProgress;
    @Bind(R.id.tv_nowmoney)
    TextView tvNowmoney;
    @Bind(R.id.tv_allmoney)
    TextView tvAllmoney;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_busmine;
    }

    @Override
    protected void FragmentInitData() {
        tvTitle.setText("我");
        iv_back.setVisibility(View.GONE);
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String phonenum = sp.getString("rxdy_phonenum", null);
        String cardno = sp.getString("rxdy_cardno", null);
//        mPresenter.getMessage(cardno);
        mPresenter.getMessage("01012283");
        mPresenter.getGradeMessage("01012283");
    }

    @OnClick({R.id.ll_message, R.id.rl_houselevel, R.id.rl_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_message:
                startActivity(new Intent(getActivity(), BusiPersonMessage.class)
                        .putExtra("cardnum", cardnum)
                        .putExtra("weichatnum", weichatnum)
                        .putExtra("emailnum", emailnum)
                        .putExtra("icon", iconurl));
                break;
            case R.id.rl_houselevel:
                break;
            case R.id.rl_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }

    String cardnum, weichatnum, emailnum, iconurl;

    @Override
    public void responsegetMessage(MyGradeBean data) {
        //显示吧
        tvName.setText(data.getBody().get(0).getXingMing());
        if (!StringUtils.isEmpty(data.getBody().get(0).getTouXiangImg())) {
//            Glide.with(this).load(data.getBody().get(0).getTouXiangImg()).centerCrop().transform(new GlideCircleTransform(getActivity())).into(ivIcon);
            Glide.with(this).load(data.getBody().get(0).getTouXiangImg()).into(ivIcon);
        }
        cardnum = data.getBody().get(0).getKaHao();
        weichatnum = data.getBody().get(0).getWeiXinHao();
        emailnum = data.getBody().get(0).getYouXiang();
        iconurl = data.getBody().get(0).getTouXiangImg();
        switch (data.getBody().get(0).getUpdate_after()) {
            case "一级":
                ivLevel.setImageResource(R.drawable.v1);
                iv_levels.setImageResource(R.drawable.v1);
                break;
            case "二级":
                ivLevel.setImageResource(R.drawable.v2);
                iv_levels.setImageResource(R.drawable.v2);
                break;
            case "三级":
                ivLevel.setImageResource(R.drawable.v3);
                iv_levels.setImageResource(R.drawable.v3);
                break;
            case "四级":
                ivLevel.setImageResource(R.drawable.v4);
                iv_levels.setImageResource(R.drawable.v4);
                break;
            case "五级":
                ivLevel.setImageResource(R.drawable.v5);
                iv_levels.setImageResource(R.drawable.v5);
                break;
            case "六级":
                ivLevel.setImageResource(R.drawable.v6);
                iv_levels.setImageResource(R.drawable.v6);
                break;
            case "七级":
                ivLevel.setImageResource(R.drawable.v7);
                iv_levels.setImageResource(R.drawable.v7);
                break;
            case "八级":
                ivLevel.setImageResource(R.drawable.v8);
                iv_levels.setImageResource(R.drawable.v8);
                break;
            case "九级":
                ivLevel.setImageResource(R.drawable.v9);
                iv_levels.setImageResource(R.drawable.v9);
                break;
            case "十级":
                ivLevel.setImageResource(R.drawable.v10);
                iv_levels.setImageResource(R.drawable.v10);
                break;
            case "十一级":
                ivLevel.setImageResource(R.drawable.v11);
                iv_levels.setImageResource(R.drawable.v11);
                break;
            case "十二级":
                ivLevel.setImageResource(R.drawable.v12);
                iv_levels.setImageResource(R.drawable.v12);
                break;
            case "十三级":
                ivLevel.setImageResource(R.drawable.v13);
                iv_levels.setImageResource(R.drawable.v13);
                break;
            case "十四级":
                ivLevel.setImageResource(R.drawable.v14);
                iv_levels.setImageResource(R.drawable.v14);
                break;
            case "十五级":
                ivLevel.setImageResource(R.drawable.v15);
                iv_levels.setImageResource(R.drawable.v15);
                break;
            case "十六级":
                ivLevel.setImageResource(R.drawable.v16);
                iv_levels.setImageResource(R.drawable.v16);
                break;
            case "十七级":
                ivLevel.setImageResource(R.drawable.v17);
                iv_levels.setImageResource(R.drawable.v17);
                break;
            case "十八级":
                ivLevel.setImageResource(R.drawable.v18);
                iv_levels.setImageResource(R.drawable.v18);
                break;
            case "十九级":
                ivLevel.setImageResource(R.drawable.v18);
                iv_levels.setImageResource(R.drawable.v18);
                break;
            case "二十级":
                ivLevel.setImageResource(R.drawable.v20);
                iv_levels.setImageResource(R.drawable.v20);
                break;
        }
    }


    @Override
    public void responsegetMessageError(String msg) {
        showToast(msg);
    }


    @Override
    public void responsegetGradeMessage(MyGradeMoneyBean data) {
        tvNowmoney.setText(data.getBody().getPackageType().get(0).getChenJiuLeiJi() + "w");
        tvAllmoney.setText(" /" + data.getBody().getPackageType().get(0).getShengjichaE() + "w");
        int progress = (data.getBody().getPackageType().get(0).getChenJiuLeiJi() / data.getBody().getPackageType().get(0).getShengjichaE()) * 100;
        pbProgress.setProgress(progress);
    }

    @Override
    public void responsegetGradeMessageError(String msg) {
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected MinePresenter onCreatePresenter() {
        return new MinePresenter(this);
    }
}

