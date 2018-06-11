package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.EnvironmentAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.EnvirBean;
import com.rxjy.rxcompound.mvp.contract.EnvironmentContract;
import com.rxjy.rxcompound.mvp.presenter.EnvironmentPresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/25.
 */

public class EnvironmentActivity extends BaseActivity<EnvironmentPresenter> implements EnvironmentContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.lv_envir)
    ListView lvEnvir;

    @Override
    public int getLayout() {
        return R.layout.activity_environment;
    }

    ArrayList<String> list;
    ArrayList<String> list_id;

    @Override
    public void initData() {
        tvTitle.setText("环境");
        list = new ArrayList<>();
        list_id = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getEnvir(App.cardNo, App.regionid, "2");
    }

    @Override
    protected EnvironmentPresenter onCreatePresenter() {
        return new EnvironmentPresenter(this);
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

    EnvironmentAdapter adapter;

    @Override
    public void responseEnvir(final EnvirBean data) {
        adapter = new EnvironmentAdapter(this, data.getBody());
        lvEnvir.setAdapter(adapter);
        lvEnvir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(EnvironmentActivity.this, EnvironmentDetailsActivity.class)
                        .putExtra("getid", data.getBody().get(position).getId()+"")
                        .putExtra("getcontentid", data.getBody().get(position).getContentId()+"")
                        .putExtra("getareaname", data.getBody().get(position).getAreaName()));
            }
        });
    }

    @Override
    public void responseEnvirError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}