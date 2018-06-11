package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.AdTaskAdaper;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.mvp.contract.RedTaskContract;
import com.rxjy.rxcompound.mvp.presenter.RedTaskPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/9.
 */

public class AdministrationRedActivity extends BaseActivity<RedTaskPresenter> implements RedTaskContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.lv_task)
    ListView lvTask;
    private List<AdRedEnvelopesBean.BodyBean> mlist;
    private AdTaskAdaper taskAdaper;


    @Override
    public int getLayout() {
        return R.layout.ad_red_activity;
    }

    @Override
    public void initData() {
        tvTitle.setText("红包列表");
        mlist=new ArrayList<>();
        taskAdaper=new AdTaskAdaper(this,mlist);
        lvTask.setAdapter(taskAdaper);

        mPresenter.getRedTask(App.cardNo);
        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AdministrationRedActivity.this,RedTaskActivity.class).putExtra("task",mlist.get(position)));
            }
        });


    }

    @Override
    protected RedTaskPresenter onCreatePresenter() {
        return new RedTaskPresenter(this);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseTaskData(List<AdRedEnvelopesBean.BodyBean> mlist) {
        this.mlist.clear();
        this.mlist.addAll(mlist);
        taskAdaper.notifyDataSetChanged();

    }

    @Override
    public void responseConsentError(String msg) {
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
    public void showMeaaage(String msg) {
         showToast(msg);
    }
}
