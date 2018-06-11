package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.mvp.contract.ForgetPwdContract;
import com.rxjy.rxcompound.mvp.presenter.ForgetPwdPresenter;
import com.rxjy.rxcompound.widget.DownTimerButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/30.
 */

public class ForgetPwdActivity extends BaseActivity<ForgetPwdPresenter> implements ForgetPwdContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.imageView6)
    ImageView imageView6;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.iv_phone_icon)
    ImageView ivPhoneIcon;
    @Bind(R.id.tv_phone_text)
    TextView tvPhoneText;
    @Bind(R.id.et_phone_num)
    EditText etPhoneNum;
    @Bind(R.id.tv_old_password_line)
    TextView tvOldPasswordLine;
    @Bind(R.id.iv_verification_code_icon)
    ImageView ivVerificationCodeIcon;
    @Bind(R.id.tv_verification_code_text)
    TextView tvVerificationCodeText;
    @Bind(R.id.btn_verification_code)
    DownTimerButton btnVerificationCode;
    @Bind(R.id.et_verification_code)
    EditText etVerificationCode;
    @Bind(R.id.tv_verification_code_line)
    TextView tvVerificationCodeLine;
    @Bind(R.id.iv_new_password_icon)
    ImageView ivNewPasswordIcon;
    @Bind(R.id.tv_new_password_text)
    TextView tvNewPasswordText;
    @Bind(R.id.et_new_password)
    EditText etNewPassword;
    @Bind(R.id.tv_new_password_line)
    TextView tvNewPasswordLine;
    @Bind(R.id.iv_confirm_password_icon)
    ImageView ivConfirmPasswordIcon;
    @Bind(R.id.tv_confirm_password_text)
    TextView tvConfirmPasswordText;
    @Bind(R.id.et_confirm_password)
    EditText etConfirmPassword;
    @Bind(R.id.tv_confirm_password_line)
    TextView tvConfirmPasswordLine;
    @Bind(R.id.btn_forget_password)
    Button btnForgetPassword;

    @Override
    public int getLayout() {
        return R.layout.activity_pwdforget;
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        String phone=intent.getStringExtra("phone");
        if(phone!=null){
            etPhoneNum.setText(phone);
        }
        btnForgetPassword.setEnabled(false);
        tvTitle.setText("忘记密码");
        initLine();
        etPhoneNum.addTextChangedListener(new MyEditListener(etPhoneNum));
        etNewPassword.addTextChangedListener(new MyEditListener(etNewPassword));
        etVerificationCode.addTextChangedListener(new MyEditListener(etVerificationCode));
        etConfirmPassword.addTextChangedListener(new MyEditListener(etConfirmPassword));
    }

    private void initLine() {
        etPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvOldPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvOldPasswordLine.setEnabled(false);
                }
            }
        });
        etVerificationCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvVerificationCodeLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvVerificationCodeLine.setEnabled(false);
                }
            }
        });
        etNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvNewPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvNewPasswordLine.setEnabled(false);
                }
            }
        });
        etConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvConfirmPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvConfirmPasswordLine.setEnabled(false);
                }
            }
        });
    }


    @Override
    protected ForgetPwdPresenter onCreatePresenter() {
        return new ForgetPwdPresenter(this);
    }


    @Override
    public void responseVCode(String str) {
        showToast(str);
    }

    @Override
    public void responseVCodeError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsetoFixPwd() {
        showToast("修改成功！此密码已经与您的WPS密码同时修改！！");
        finish();
    }

    @Override
    public void responsetoFixPwdError(String msg) {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_verification_code, R.id.btn_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_verification_code:
                String phone = etPhoneNum.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    showToast("请输入手机号");
                    return;
                }
                if (!StringUtils.isMobileNO(phone)) {
                    showToast("请输入正确的手机号");
                    return;
                }
                DownTimerButton.setIsclick(1);
                mPresenter.getVCode(phone);
                break;
            case R.id.btn_forget_password:
                //判断两个密码一致性
                String phoneNum = etPhoneNum.getText().toString().trim();
                String verificationCode = etVerificationCode.getText().toString().trim();
                String newPassword = etNewPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
                    showToast("请输入手机号");
                    return;
                }
                if (!StringUtils.isMobileNO(phoneNum)) {
                    showToast("请输入正确的手机号");
                    return;
                }
                if (TextUtils.isEmpty(verificationCode)) {
                    showToast("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(newPassword)) {
                    showToast("请输入新密码");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    showToast("请输入确认密码");
                    return;
                }

                //密码最少6位
                if (newPassword.length() < 6) {
                    showToast("密码最少6位");
                    return;
                }

                if (!newPassword.equals(confirmPassword)) {
                    showToast("两次密码输入不一致");
                    return;
                }

                //密码数相同
//                if (StringUtils.isSameChars(newPassword)) {
//                    showToast("密码过于简单");
//                    return;
//                }

                //密码为连续数
                if (newPassword.equals("123456") || newPassword.equals("234567") || newPassword.equals("345678") || newPassword.equals("456789")) {
                    showToast("密码过于简单");
                    return;
                }
                mPresenter.toFixPwd(phoneNum, newPassword, verificationCode);
                break;
        }
    }


    int phonetrue=1,codetrue=0,pwdtrue=0,pwdsuretrue=0;
    String pwd,pwdsure;
    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }

        @Override
        public void afterTextChanged(Editable arg0) {
            int lengths = arg0.length();
            switch (edittext.getId()) {
                case R.id.et_phone_num:
                    if(lengths==11){
                        phonetrue=1;
                    }else {
                        phonetrue=0;
                    }
                    break;
                case R.id.et_verification_code:
                    if(lengths>0){
                        codetrue=1;
                    }else {
                        codetrue=0;
                    }
                    break;
                case R.id.et_new_password:
                    pwd=etNewPassword.getText().toString();
                    if(lengths>0){
                        pwdtrue=1;
                    }else {
                        pwdtrue=0;
                    }
                    break;
                case R.id.et_confirm_password:
                    pwdsure=etConfirmPassword.getText().toString();
                    if(lengths>0){
                        pwdsuretrue=1;
                    }else {
                        pwdsuretrue=0;
                    }
                    break;
            }

            Log.e("phonetrue"+phonetrue,"codetrue"+codetrue+"pwdtrue"+pwdtrue+"pwdsuretrue"+pwdsuretrue);
            Log.e("pwd"+pwd,"pwdsure"+pwdsure);
            if(phonetrue==1&&codetrue==1&&pwdtrue==1&&pwdsuretrue==1&&!StringUtils.isEmpty(pwd)&&
                    !StringUtils.isEmpty(pwdsure)&&pwd.equals(pwdsure)){
                btnForgetPassword.setEnabled(true);
            }else{
                btnForgetPassword.setEnabled(false);
            }

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
            // TODO Auto-generated method stub
        }
    }

}