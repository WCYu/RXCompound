package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.LeaveAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.LeaveBean;
import com.rxjy.rxcompound.mvp.contract.LeaveContract;
import com.rxjy.rxcompound.mvp.presenter.LeavePresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/17.
 */

public class LeaveActivity extends BaseActivity<LeavePresenter> implements LeaveContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_header)
    TextView tvHeader;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.leave_lsit)
    ListView leaveLsit;
    private List<LeaveBean.BodyBean> mlist;
    private LeaveAdapter leaveAdapter;

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
    public void getLeaveData(List<LeaveBean.BodyBean> bodyBeen) {
        mlist.clear();
        mlist.addAll(bodyBeen);
        leaveAdapter.notifyDataSetChanged();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_leave;
    }

    @Override
    public void initData() {
        tvTitle.setText("请假");
        mlist=new ArrayList<>();
        leaveAdapter=new LeaveAdapter(this,mlist);
        leaveLsit.setAdapter(leaveAdapter);
        tvHeader.setText("添加");
        tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeaveActivity.this,LeavePageActivirt.class));
            }
        });

    }

    @Override
    protected LeavePresenter onCreatePresenter() {
        return new LeavePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
//获取系统的日期
//年
        int year = calendar.get(Calendar.YEAR);
//月
        int month = calendar.get(Calendar.MONTH)+1;
//日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
//获取系统时间
//小时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//分钟
        int minute = calendar.get(Calendar.MINUTE);
//秒
        int second = calendar.get(Calendar.SECOND);

        Log.e("tag",year+"==========="+month);
        mPresenter.getLeaveData(App.cardNo,year,month);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
