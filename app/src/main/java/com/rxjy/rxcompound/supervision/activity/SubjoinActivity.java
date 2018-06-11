package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubjoinActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.btn_submit)
    Button btnSubmit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_disbursement_content)
    EditText etDisbursementContent;
    @Bind(R.id.tv_subjoin_count)
    TextView tvSubjoinCount;

    public static final String TITLE = "备注";

    @Override
    public int getLayout() {
        return R.layout.activity_subjoin;
    }

    @Override
    public void initData() {
        initTitle();
        initEdit();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
        btnSubmit.setText("确定");
    }

    private void initEdit() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        switch (position){
            case 0:
                etDisbursementContent.setHint("回访：质量验收是否合格，质量问题如何处理？");
                break;
            case 1:
                etDisbursementContent.setHint("回访：目前已完成工程总进度百分比。");
                break;
            case 2:
                etDisbursementContent.setHint("回访：是否存在安全管理问题，如何处理？");
                break;
            case 3:
                etDisbursementContent.setHint("回访：是否存在不达标问题，如何处理？");
                break;
            case 4:
                etDisbursementContent.setHint("回访：是否符合项目要求？问题如何处理？");
                break;
            case 5:
                etDisbursementContent.setHint("回访："+"\n"+
                        "1、下周施工计划，表述清楚施工部位，施工内容，计划完成时间即可。"+"\n"+"（例如：二层总经理办公室下周三轻钢龙骨树立完成）。"+"\n" +
                        "2、成品及定制材料是否现场量尺，能否按时进场？存在问题如何处理？"+"\n" +
                        "3、是否存在其他项目协调问题，如何处理？"+"\n" +
                        "4、联系客户，反馈客户意见。");
                break;

        }
        tvSubjoinCount.setText("限制字数" + 0 + "/70");
        etDisbursementContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvSubjoinCount.setText("限制字数" + s.toString().length() + "/70");
            }
        });

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                String remark = etDisbursementContent.getText().toString().trim();
                if (remark.equals("")) {
                    showToast("请输入备注信息");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(Constants.BACK_TO_ROUTING_SUB_REMARK, remark);
                setResult(Constants.REQUEST_CODE_REMARK, intent);
                finish();
                break;
        }
    }
}
