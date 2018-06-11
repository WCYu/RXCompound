package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.OrderGetBean;
import com.rxjy.rxcompound.des.entity.ResultBean;
import com.rxjy.rxcompound.des.mvp.contract.OrderGetContract;
import com.rxjy.rxcompound.des.mvp.presenter.OrderGetPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/16.
 */

public class OrderGetActivity extends BaseActivity<OrderGetPresenter> implements OrderGetContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_projectnum)
    TextView tvProjectnum;
    @Bind(R.id.v_projectnum)
    TextView vProjectnum;
    @Bind(R.id.tv_projectname)
    TextView tvProjectname;
    @Bind(R.id.v_projectname)
    TextView vProjectname;
    @Bind(R.id.tv_shuxing)
    TextView tvShuxing;
    @Bind(R.id.v_shuxing)
    TextView vShuxing;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.v_type)
    TextView vType;
    @Bind(R.id.tv_decorate)
    TextView tvDecorate;
    @Bind(R.id.v_decorate)
    TextView vDecorate;
    @Bind(R.id.tv_lhouse)
    TextView tvLhouse;
    @Bind(R.id.v_lhouse)
    TextView vLhouse;
    @Bind(R.id.tv_use)
    TextView tvUse;
    @Bind(R.id.v_use)
    TextView vUse;
    @Bind(R.id.tv_yumoney)
    TextView tvYumoney;
    @Bind(R.id.v_yumoney)
    TextView vYumoney;
    @Bind(R.id.tv_no)
    TextView tvNo;
    @Bind(R.id.tv_accept)
    TextView tvAccept;

    @Override
    public int getLayout() {
        return R.layout.activity_orderget;
    }

    String orderid;
    private AllClientNewBean.ClientNewBean infos;
    @Override
    public void initData() {
        tvTitle.setText("接单");
        Intent intent=getIntent();
        orderid =intent.getStringExtra("orderid");
        infos=(AllClientNewBean.ClientNewBean) intent.getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        mPresenter.GetData(orderid);
    }

    @Override
    protected OrderGetPresenter onCreatePresenter() {
        return new OrderGetPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_no, R.id.tv_accept})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_no://拒单
                OrderDeal(2);
                break;
            case R.id.tv_accept://接单
                OrderDeal(1);
                break;
        }
    }

    @Override
    public void responseGetData(OrderGetBean info) {
        tvProjectnum.setText(orderid);
        tvProjectname.setText(info.getBody().getBaseInformation().getCi_ClientName());
        tvShuxing.setText(info.getBody().getDecorateInformation().getCa_proAttribute());
        tvType.setText(info.getBody().getBaseInformation().getCi_Type());
        tvDecorate.setText(info.getBody().getDecorateInformation().getCa_DecorationDate());
        tvLhouse.setText(info.getBody().getHousingResourcesInformation().getCa_MeasureDate());
        tvUse.setText(info.getBody().getHousingResourcesInformation().getCi_Area()+" ㎡");
        tvYumoney.setText(info.getBody().getDecorateInformation().getCa_DecBudgetPrice()+" 万");
    }

    private void OrderDeal(int deal){//1:接单  2:拒单
        mPresenter.OrderDeal(orderid,"{ci_ReciveStatus:"+deal+"}","基本");
    }

    @Override
    public void responseGetDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseOrderDeal(ResultBean info) {
        showToast("提交成功！");//接单或者拒单成功。。。。做下步操作
        Intent intent = new Intent(this, DesDaiMeasureActivity.class);
        intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, infos);
        startActivity(intent);
        finish();
    }

    @Override
    public void responseOrderDealError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

}