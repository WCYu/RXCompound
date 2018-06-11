package com.rxjy.rxcompound.supervision.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;
import com.rxjy.rxcompound.supervision.entity.PushElectronicInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PushElectronicContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.PushElectronicPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PushElectronicActivity extends BaseActivity<PushElectronicPresenter> implements PushElectronicContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_push_electronic)
    EditText etPushElectronic;
    @Bind(R.id.btn_push_electronic_save)
    Button btnPushElectronicSave;
    @Bind(R.id.btn_push_electronic_save_and_push)
    Button btnPushElectronicSaveAndPush;
    @Bind(R.id.lin_push_electronic)
    LinearLayout linPushElectronic;

    private DatumListInfo.DatumInfo.Datum datumInfo;

    private PushElectronicInfo.PushElectronic pushElectronicInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_push_electronic;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPushElectronic();
    }

    private void initIntent() {
        datumInfo = (DatumListInfo.DatumInfo.Datum) getIntent().getSerializableExtra(Constants.ACTION_TO_ELECTRONIC_DATUM_INFO);
    }

    private void initTitle() {
        tvTitle.setText(datumInfo.getAttr_name());
    }

    private void initPushElectronic() {

        if (datumInfo.getConfirm_status() == 5) {
            linPushElectronic.setVisibility(View.GONE);
            etPushElectronic.setEnabled(false);
        } else {
            linPushElectronic.setVisibility(View.VISIBLE);
        }

        mPresenter.getPaperInfo(datumInfo.getOrderno(), datumInfo.getAttr_model_id());

    }

    @Override
    protected PushElectronicPresenter onCreatePresenter() {
        return new PushElectronicPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_push_electronic_save, R.id.btn_push_electronic_save_and_push})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_push_electronic_save:
                String content = etPushElectronic.getText().toString().trim();
                if (content.equals("")) {
                    showToast("请输入保存内容");
                    return;
                }
                mPresenter.saveElectronicInfo(datumInfo.getOrderno(), datumInfo.getAttr_model_id(), pushElectronicInfo.getEleid(), content);
                break;
            case R.id.btn_push_electronic_save_and_push:
                mPresenter.savePushElectronicInfo(datumInfo.getOrderno(), datumInfo.getAttr_model_id());
                break;
        }
    }

    @Override
    public void responsePushElectronicData(PushElectronicInfo.PushElectronic data) {
        pushElectronicInfo = data;
        etPushElectronic.setText(data.getContent());
    }

    @Override
    public void responsePushElectronicDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSaveElectronicData() {
        showToast("保存电子资料成功");
        finish();
    }

    @Override
    public void responseSaveElectronicDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSavePushElectronicData() {
        showToast("保存并推送电子资料成功");
        finish();
    }

    @Override
    public void responseSavePushElectronicDataError(String msg) {
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
