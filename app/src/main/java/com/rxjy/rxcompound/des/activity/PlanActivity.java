package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.adapter.PlanImgAdapter;
import com.rxjy.rxcompound.des.adapter.PlanImgCaiAdapter;
import com.rxjy.rxcompound.des.entity.PlanImageBean;
import com.rxjy.rxcompound.des.entity.PlanStrBean;
import com.rxjy.rxcompound.des.mvp.contract.PlanContract;
import com.rxjy.rxcompound.des.mvp.presenter.PlanPresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/16.
 */

public class PlanActivity extends BaseActivity<PlanPresenter> implements PlanContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_from)
    TextView tvFrom;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.tv_describe)
    TextView tvDescribe;
    @Bind(R.id.gv_chu)
    GridView gvChu;
    @Bind(R.id.gv_cai)
    GridView gvCai;

    @Override
    public int getLayout() {
        return R.layout.activity_plan;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String address = intent.getStringExtra("address");
        String rwdid = intent.getStringExtra("rwdid");
//        String rwdid = "25-68522";
        tvFrom.setText(title);
        tvAddress.setText(address);
        mPresenter.GetTxt(rwdid);
        mPresenter.GetImage(rwdid);
    }

    @Override
    protected PlanPresenter onCreatePresenter() {
        return new PlanPresenter(this);
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

    @Override
    public void responseGetTxt(PlanStrBean data) {
        if (!StringUtils.isEmpty(data.getBody().getProjectBrief())) {
            tvDescribe.setText(data.getBody().getProjectBrief());
        }
    }

    @Override
    public void responseGetTxtError(String msg) {
        showToast(msg);
    }


    ArrayList<String> chuimglist = new ArrayList<>();
    ArrayList<String> caiimglist = new ArrayList<>();

    @Override
    public void responseGetImage(PlanImageBean data) {
        chuimglist.clear();
        caiimglist.clear();
        for (int i = 0; i < data.getBody().size(); i++) {
            if (data.getBody().get(i).getCatalogID() == 57 && !StringUtils.isEmpty(data.getBody().get(i).getImageUrl())) {//初稿
                chuimglist.add(data.getBody().get(i).getImageUrl());
            } else if (data.getBody().get(i).getCatalogID() == 90 && !StringUtils.isEmpty(data.getBody().get(i).getImageUrl())) {//彩平
                caiimglist.add(data.getBody().get(i).getImageUrl());
            }
        }
        ShowChuimgs();
        ShowCaiimgs();
    }

    /**
     * 初稿
     */
    PlanImgAdapter chuadapter;
    private void ShowChuimgs(){
        chuadapter=new PlanImgAdapter(this,chuimglist);
        gvChu.setAdapter(chuadapter);
        gvChu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                watchLargerImage2("", chuimglist,position);
            }
        });
    }

    /**
     * 彩平
     */
    PlanImgCaiAdapter caiadapter;
    private void ShowCaiimgs(){
        caiadapter=new PlanImgCaiAdapter(this,caiimglist);
        gvCai.setAdapter(caiadapter);
        gvCai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                watchLargerImage2("", chuimglist,position);
            }
        });
    }



    @Override
    public void responseGetImageError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}