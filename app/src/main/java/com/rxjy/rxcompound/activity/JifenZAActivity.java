package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.JifenZAAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.GlideCircleTransform;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.JiFenBean;
import com.rxjy.rxcompound.mvp.contract.JiFenZAContract;
import com.rxjy.rxcompound.mvp.presenter.JiFenZAPresenter;
import com.rxjy.rxcompound.widget.CircleProgressView;

import java.math.BigDecimal;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/2.
 */

public class JifenZAActivity extends BaseActivity<JiFenZAPresenter> implements JiFenZAContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_starone)
    ImageView ivStarone;
    @Bind(R.id.iv_startwo)
    ImageView ivStartwo;
    @Bind(R.id.iv_starthree)
    ImageView ivStarthree;
    @Bind(R.id.iv_starfour)
    ImageView ivStarfour;
    @Bind(R.id.iv_starfive)
    ImageView ivStarfive;
    @Bind(R.id.tv_details)
    TextView tvDetails;
    @Bind(R.id.gv_level)
    GridView gvLevel;
    @Bind(R.id.cpv_one)
    CircleProgressView cpvOne;
    @Bind(R.id.cpv_two)
    CircleProgressView cpvTwo;
    @Bind(R.id.tv_moneyone)
    TextView tvMoneyone;
    @Bind(R.id.tv_moneytwo)
    TextView tvMoneytwo;
    @Bind(R.id.tv_moneythree)
    TextView tvMoneythree;
    @Bind(R.id.tv_moneyfour)
    TextView tvMoneyfour;
    @Bind(R.id.tv_cirnumone)
    TextView tv_cirnumone;
    @Bind(R.id.tv_cirnumtwo)
    TextView tv_cirnumtwo;
    @Bind(R.id.tv_cirtipone)
    TextView tv_cirtipone;
    @Bind(R.id.tv_cirtiptwo)
    TextView tv_cirtiptwo;
    @Bind(R.id.hsv_sv)
    HorizontalScrollView hsvSsv;

    @Override
    public int getLayout() {
        return R.layout.activity_jifenza;
    }

    ArrayList<String> list;

    @Override
    public void initData() {
        tvTitle.setText("积分");
        Intent intent = getIntent();
        String icon = intent.getStringExtra("icon");
        String name = intent.getStringExtra("name");
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(this));
        Glide.with(this).load(icon).apply(options).into(ivIcon);
        tvName.setText(name);
        mPresenter.getMessage(App.cardNo);
        cpvOne.setProgress(0, getResources().getColor(R.color.cir_greentwo), getResources().getColor(R.color.cir_greenone), "1", 60);
        cpvTwo.setProgress(0, getResources().getColor(R.color.cir_bluetwo), getResources().getColor(R.color.cir_blueone), "1", 60);

    }

    @Override
    protected JiFenZAPresenter onCreatePresenter() {
        return new JiFenZAPresenter(this);
    }

    JifenZAAdapter jifenZAAdapter;
    ArrayList<String> jidianlist;

    @Override
    public void responsegetMessage(final JiFenBean data) {
        if (!StringUtils.isEmpty(data.getBody())) {
            list = new ArrayList<>();
            jidianlist = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            list.add("7");
            list.add("8");
            list.add("9");
            list.add("10");
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getOneRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getTwoRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getThreeRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getFourRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getFiveRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getSixRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getSevenRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getEightRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getNineRemind() + ""));
            jidianlist.add(StringUtils.getPrettyNumber(data.getBody().get(0).getTenRemind() + ""));
            tvDetails.setText(data.getBody().get(0).getDdeclaration());
            setStar(data.getBody().get(0).getAchievementGrade());
            tvMoneyone.setText("￥" + StringUtils.getPrettyNumber(data.getBody().get(0).getLessThenTwo() + ""));
            tvMoneytwo.setText("￥" + StringUtils.getPrettyNumber(data.getBody().get(0).getTwoToFive() + ""));
            tvMoneythree.setText("￥" + StringUtils.getPrettyNumber(data.getBody().get(0).getFiveToTwelve() + ""));
            tvMoneyfour.setText("￥" + StringUtils.getPrettyNumber(data.getBody().get(0).getGreaterThenTwelve() + ""));
            changeGridView();
            jifenZAAdapter = new JifenZAAdapter(this, list);
            gvLevel.setAdapter(jifenZAAdapter);
            jifenZAAdapter.setNum(data.getBody().get(0).getGrade());
            jifenZAAdapter.setList(jidianlist);
            if (data.getBody().get(0).getGrade() > 3) {
                new Handler().postDelayed((new Runnable() {
                    @Override
                    public void run() {
                        hsvSsv.scrollTo(300 * data.getBody().get(0).getGrade() - 600, 0);
                    }
                }), 3);
            }

            BigDecimal shengjicha = data.getBody().get(0).getUpStandard().subtract(data.getBody().get(0).getFinalMoney());
            int shengjichaint = shengjicha.intValue();
            if (shengjichaint > 0) {
                tv_cirnumone.setText(StringUtils.toWanYuan(shengjicha) + "万");
            } else {
                tv_cirtipone.setText("完成升级任务");
                tv_cirnumtwo.setText(StringUtils.toWanYuan(data.getBody().get(0).getUpStandard()) + "万");
            }

            BigDecimal jiangjicha = data.getBody().get(0).getDownStandard().subtract(data.getBody().get(0).getFinalMoney());
            int jiangjichaint = jiangjicha.intValue();
            if (jiangjichaint > 0) {
                tv_cirnumtwo.setText(StringUtils.toWanYuan(jiangjicha) + "万");
            } else {
                tv_cirtiptwo.setText("完成级别任务");
                tv_cirnumtwo.setText(StringUtils.toWanYuan(data.getBody().get(0).getDownStandard()) + "万");
            }
            BigDecimal oneh = new BigDecimal("100");
            int shengjibi = data.getBody().get(0).getFinalMoney().divide(data.getBody().get(0).getUpStandard()).multiply(oneh).intValue();
            int jiangjibi = data.getBody().get(0).getFinalMoney().divide(data.getBody().get(0).getDownStandard()).multiply(oneh).intValue();
            Log.e("shengjibi" + shengjibi, "jiangjibi" + jiangjibi);
            cpvOne.setProgress(shengjibi, getResources().getColor(R.color.cir_greenone), getResources().getColor(R.color.cir_greentwo), "1", 60);
            cpvTwo.setProgress(jiangjibi, getResources().getColor(R.color.cir_blueone), getResources().getColor(R.color.cir_bluetwo), "1", 60);
        }
    }


    private void setStar(int i) {
        switch (i) {
            case 0:
                ivStarone.setVisibility(View.GONE);
                ivStartwo.setVisibility(View.GONE);
                ivStarthree.setVisibility(View.GONE);
                ivStarfour.setVisibility(View.GONE);
                ivStarfive.setVisibility(View.GONE);
                break;
            case 1:
                ivStarone.setVisibility(View.VISIBLE);
                ivStartwo.setVisibility(View.GONE);
                ivStarthree.setVisibility(View.GONE);
                ivStarfour.setVisibility(View.GONE);
                ivStarfive.setVisibility(View.GONE);
                break;
            case 2:
                ivStarone.setVisibility(View.VISIBLE);
                ivStartwo.setVisibility(View.VISIBLE);
                ivStarthree.setVisibility(View.GONE);
                ivStarfour.setVisibility(View.GONE);
                ivStarfive.setVisibility(View.GONE);
                break;
            case 3:
                ivStarone.setVisibility(View.VISIBLE);
                ivStartwo.setVisibility(View.VISIBLE);
                ivStarthree.setVisibility(View.VISIBLE);
                ivStarfour.setVisibility(View.GONE);
                ivStarfive.setVisibility(View.GONE);
                break;
            case 4:
                ivStarone.setVisibility(View.VISIBLE);
                ivStartwo.setVisibility(View.VISIBLE);
                ivStarthree.setVisibility(View.VISIBLE);
                ivStarfour.setVisibility(View.VISIBLE);
                ivStarfive.setVisibility(View.GONE);
                break;
            case 5:
                ivStarone.setVisibility(View.VISIBLE);
                ivStartwo.setVisibility(View.VISIBLE);
                ivStarthree.setVisibility(View.VISIBLE);
                ivStarfour.setVisibility(View.VISIBLE);
                ivStarfive.setVisibility(View.VISIBLE);
                break;
        }
    }


    private void changeGridView() {
        // item宽度
        int itemWidth = 300;
        // item之间的间隔
        int itemPaddingH = 10;
        int size = list.size();
        // 计算GridView宽度
        int gridviewWidth = size * (itemWidth + itemPaddingH);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        gvLevel.setLayoutParams(params);
        gvLevel.setColumnWidth(itemWidth);
        gvLevel.setHorizontalSpacing(itemPaddingH);
        gvLevel.setStretchMode(GridView.NO_STRETCH);
        gvLevel.setNumColumns(size);
    }


    @Override
    public void responsegetMessageError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
