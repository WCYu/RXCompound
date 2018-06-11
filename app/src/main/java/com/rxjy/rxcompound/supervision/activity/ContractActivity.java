package com.rxjy.rxcompound.supervision.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.TimeUtil;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.entity.ContractInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.ContractContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.ContractPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContractActivity extends BaseActivity<ContractPresenter> implements ContractContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_contract_principal_name)
    TextView tvContractPrincipalName;
    @Bind(R.id.tv_contract_principal_phone)
    TextView tvContractPrincipalPhone;
    @Bind(R.id.tv_contract_des_name)
    TextView tvContractDesName;
    @Bind(R.id.tv_contract_special_requirements)
    TextView tvContractSpecialRequirements;
    @Bind(R.id.tv_contract_behalf_mat_price)
    TextView tvContractBehalfMatPrice;
    @Bind(R.id.tv_contract_date_of_signing)
    TextView tvContractDateOfSigning;
    @Bind(R.id.tv_contract_time_limit_for_project)
    TextView tvContractTimeLimitForProject;
    @Bind(R.id.tv_contract_area_of_structure)
    TextView tvContractAreaOfStructure;
    @Bind(R.id.tv_contract_pro_location)
    TextView tvContractProLocation;

    public static final String TITLE = "甲方合同";

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_contract;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initContract();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_CONTRACT_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initContract() {
        mPresenter.getFirstPartyContract(proInfo.getOrderNo());
    }

    @Override
    protected ContractPresenter onCreatePresenter() {
        return new ContractPresenter(this);
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

    @Override
    public void responseContractData(ContractInfo.Contract data) {
        tvContractPrincipalName.setText(data.getWorkorder_user().getPart_a_chief());
        tvContractPrincipalPhone.setText(data.getWorkorder_user().getPart_a_chief_mobile());
        tvContractDesName.setText(data.getWorkorder_user().getDesigner_username());
        tvContractSpecialRequirements.setText(data.getCustomer_demand());
        tvContractBehalfMatPrice.setText(data.getWorkorder_money().getPurchasing_material_fee() + "");
        tvContractDateOfSigning.setText(TimeUtil.getNormalTime(data.getContract_date()));
        tvContractTimeLimitForProject.setText(data.getConstruction_period() + "天");
        tvContractAreaOfStructure.setText(data.getProarea() + "㎡");
        tvContractProLocation.setText(data.getProaddr());
    }

    @Override
    public void responseContractDataError(String msg) {
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
