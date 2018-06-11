package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.TaskBean;
import com.rxjy.rxcompound.mvp.contract.TaskContract;
import com.rxjy.rxcompound.mvp.presenter.TaskPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/9.
 */

public class TaskActivity extends BaseActivity<TaskPresenter> implements TaskContract.View {
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_job)
    TextView tvJob;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.tv_task)
    TextView tvTask;
    @Bind(R.id.ed_content)
    EditText edContent;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.tv_titles)
    TextView tvTitles;
    @Bind(R.id.tv_reason)
    TextView tvReason;

    @Override
    public int getLayout() {
        return R.layout.activity_taskdetails;
    }

    String taskid;

    @Override
    public void initData() {
        tvTitle.setText("任务");
        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid");
        mPresenter.getTaskDetails(taskid);
    }

    @Override
    protected TaskPresenter onCreatePresenter() {
        return new TaskPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                String content = edContent.getText().toString();
                if (StringUtils.isEmpty(content)) {
                    showToast("请输入任务描述！");
                    break;
                }
                mPresenter.submitTask(taskid, null, content, null, App.cardNo);
                break;
        }
    }

    @Override
    public void responseTask(TaskBean data) {
        int money=data.getBody().getT_money().intValue();
        if(money==0){
            tvMoney.setVisibility(View.GONE);
        }else{
            tvMoney.setVisibility(View.VISIBLE);
        }
        tvMoney.setText("￥" + StringUtils.getPrettyNumber("" + data.getBody().getT_money()));
        tvJob.setText(data.getBody().getSname() + "-" + data.getBody().getTname() + "-" + data.getBody().getYname() + "-" + data.getBody().getT_sysPathStr());
        tvTitles.setText(data.getBody().getT_theme());
        tvTask.setText(data.getBody().getT_describe());
        tvTime.setText(data.getBody().getBeginTimeStr()+"-"+data.getBody().getEndTimeStr());
        tvReason.setText(data.getBody().getExecutorName());
    }

    @Override
    public void responseTaskError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsesubmitTask(TaskBean data) {
        showToast("提交成功！");//刷新
        finish();
    }

    @Override
    public void responsesubmitTaskError(String msg) {
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
}
