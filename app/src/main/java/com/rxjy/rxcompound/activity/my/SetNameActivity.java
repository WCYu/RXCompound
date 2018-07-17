package com.rxjy.rxcompound.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetNameActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_name)
    EditText tvName;
    @Bind(R.id.rl_name)
    LinearLayout rlName;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    @Bind(R.id.rl_back)
    RelativeLayout rl_back;

    @Override
    public int getLayout() {
        return R.layout.activity_set_name;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        if (App.postName.equals("投资招商")) {
            rl_back.setBackgroundColor(getResources().getColor(R.color.text_red));
            btnCommit.setBackgroundColor(getResources().getColor(R.color.text_red));
        }
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
                if (!TextUtils.isEmpty(tvName.getText().toString())) {
                    setResult(1001, getIntent().putExtra("name", tvName.getText().toString()));
                    finish();
                } else {
                    ToastUtil.getInstance().toastCentent("请输入姓名", this);
                }
                break;
        }
    }
}
