package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.TalkActivity;
import com.rxjy.rxcompound.mvp.contract.BackVisitContract;
import com.rxjy.rxcompound.mvp.presenter.BackVisitPresenter;
import com.rxjy.rxcompound.utils.ToastUtil;
import com.rxjy.rxcompound.widget.UrlTools;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/4.
 */

public class BackVisitActivity extends BaseActivity<BackVisitPresenter> implements BackVisitContract.View ,RadioGroup.OnCheckedChangeListener{


    @Bind(R.id.ed_progress)
    EditText edProgress;
    @Bind(R.id.ed_problem)
    EditText edProblem;
    @Bind(R.id.ed_nextplan)
    EditText edNextplan;
    @Bind(R.id.ed_help)
    EditText edHelp;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.rb_face_to_face)
    RadioButton rbFaceToFace;
    @Bind(R.id.rb_communication)
    RadioButton rbCommunication;
    @Bind(R.id.rb_un_talk)
    RadioButton rbUnTalk;
    @Bind(R.id.rb_un_companytalk)
    RadioButton rb_un_companytalk;
    @Bind(R.id.gv_talk)
    RadioGroup gvTalk;

    private int visitMonth = -1;

    @Override
    public int getLayout() {
        return R.layout.activity_huifang;
    }

    String cid, type;

    @Override
    public void initData() {
        Intent intent = getIntent();
        cid = intent.getStringExtra("cid");
        type = intent.getStringExtra("type");
        tvTitle.setText("回访");
        gvTalk.setOnCheckedChangeListener(this);
    }

    @Override
    protected BackVisitPresenter onCreatePresenter() {
        return new BackVisitPresenter(this);
    }

    @Override
    public void responseTalkData() {
        //返回刷新数据
        showToast("添加回访成功！");
        TalkActivity.isshuaxin = "1";
        finish();
    }

    @Override
    public void responseTalkDataError(String msg) {
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

    @OnClick({R.id.tv_submit, R.id.iv_back})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:
                String progress = edProgress.getText().toString();
                String problem = edProblem.getText().toString();
                String nextplan = edNextplan.getText().toString();
                String help = edHelp.getText().toString();
                if (StringUtils.isEmpty(progress)) {
                    showToast("请填写项目进展！");
                    break;
                }
                if (StringUtils.isEmpty(problem)) {
                    showToast("请填写遇到问题！");
                    break;
                }
                if (StringUtils.isEmpty(nextplan)) {
                    showToast("请填写下步计划！");
                    break;
                }
                if (StringUtils.isEmpty(help)) {
                    showToast("请填写部门协助！");
                    break;
                }
                String addstr = "<b>项目进展：</b>"+progress+ "<br><b>遇到问题：</b>"+problem+"<br><b>下步计划：</b>"+nextplan+"<br><b>部门协助：</b>"+help;
                Log.e("addstr",addstr);
                String addstrs= UrlTools.encode(addstr);
                int types = Integer.parseInt(type);
                mPresenter.addHuiFangData(cid, addstrs, types);
                break;
            case R.id.iv_back:
                //刷新
                TalkActivity.isshuaxin = "2";
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_face_to_face:
                visitMonth = 0;
                type = "0";
//                ToastUtil.getInstance().toastCentent(type,BackVisitActivity.this);
                break;
            case R.id.rb_communication:
                visitMonth = 1;
                type = "1";
//                ToastUtil.getInstance().toastCentent(type,BackVisitActivity.this);
                break;
            case R.id.rb_un_talk:
                visitMonth = 2;
                type = "2";
//                ToastUtil.getInstance().toastCentent(type,BackVisitActivity.this);
                break;
            case R.id.rb_un_companytalk:
                visitMonth = 3;
                type = "3";
//                ToastUtil.getInstance().toastCentent(type,BackVisitActivity.this);
                break;
        }
    }
}
