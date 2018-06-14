package com.rxjy.rxcompound.activity.more;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZaiGenActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.et_yidi)
    EditText etYidi;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_mianji)
    EditText etMianji;
    @Bind(R.id.et_hangye)
    EditText etHangye;
    @Bind(R.id.et_xindian)
    EditText etXindian;
    @Bind(R.id.et_fangyuan)
    EditText etFangyuan;
    @Bind(R.id.et_gongsi)
    EditText etGongsi;
    @Bind(R.id.btn_commit)
    Button btnCommit;

    @Override
    public int getLayout() {
        return R.layout.activity_zai_gen;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_commit:
                break;
        }
    }
}
