package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProDetailActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_pro_detail_person)
    TextView tvProDetailPerson;
    @Bind(R.id.tv_pro_detail_pro_name)
    TextView tvProDetailProName;
    @Bind(R.id.tv_pro_detail_address)
    TextView tvProDetailAddress;
    @Bind(R.id.tv_prepare_state_count)
    TextView tvPrepareStateCount;
    @Bind(R.id.tv_routing_state_count)
    TextView tvRoutingStateCount;
    @Bind(R.id.tv_camera_state_count)
    TextView tvCameraStateCount;
    @Bind(R.id.tv_visit_state_count)
    TextView tvVisitStateCount;
    @Bind(R.id.tv_contract_state_count)
    TextView tvContractStateCount;
    @Bind(R.id.tv_material_upload_state_count)
    TextView tvMaterialUploadStateCount;
    @Bind(R.id.tv_mat_list_state_count)
    TextView tvMatListStateCount;
    @Bind(R.id.tv_audit_state_count)
    TextView tvAuditStateCount;
    @Bind(R.id.tv_day_count)
    TextView tvDayCount;

    public final String TITLE = "项目详情";

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_pro_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initPro();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_PRO_DETAIL_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initPro() {
        tvProDetailPerson.setText(proInfo.getMobile() + " " + proInfo.getUserName() + " 监理");
        tvProDetailProName.setText(proInfo.getProName());
        tvProDetailAddress.setText(proInfo.getProAddr());
        tvDayCount.setText(proInfo.getWorkDays() + "");
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

    @OnClick({R.id.iv_back, R.id.rl_prepare, R.id.rl_routing, R.id.rl_camera, R.id.rl_visit, R.id.rl_contract, R.id.rl_datum_upload, R.id.rl_mat_list, R.id.rl_audit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_prepare:
                Intent preIntent = new Intent(this, PrepareActivity.class);
                preIntent.putExtra(Constants.ACTION_TO_PREPARE_PRO_INFO, proInfo);
                startActivity(preIntent);
                break;
            case R.id.rl_routing:
                Intent routIntent = new Intent(this, RoutingActivity.class);
                routIntent.putExtra(Constants.ACTION_TO_ROUTING_PRO_INFO, proInfo);
                startActivity(routIntent);
                break;
            case R.id.rl_camera:
                break;
            case R.id.rl_visit:
                Intent visitIntent = new Intent(this, VisitActivity.class);
                visitIntent.putExtra(Constants.ACTION_TO_VISIT_PRO_INFO, proInfo);
                startActivity(visitIntent);
                break;
            case R.id.rl_contract:
                Intent contractIntent = new Intent(this, ContractActivity.class);
                contractIntent.putExtra(Constants.ACTION_TO_CONTRACT_PRO_INFO, proInfo);
                startActivity(contractIntent);
                break;
            case R.id.rl_datum_upload:
                Intent datumIntent = new Intent(this, DatumActivity.class);
                datumIntent.putExtra(Constants.ACTION_TO_DATUM_PRO_INFO, proInfo);
                startActivity(datumIntent);
                break;
            case R.id.rl_mat_list:
                Intent matIntent = new Intent(this, MatListActivity.class);
                matIntent.putExtra(Constants.ACTION_TO_MAT_LIST_PRO_INFO, proInfo);
                startActivity(matIntent);
                break;
            case R.id.rl_audit:
                Intent auditIntent = new Intent(this, AuditActivity.class);
                auditIntent.putExtra(Constants.ACTION_TO_AUDIT_PRO_INFO, proInfo);
                startActivity(auditIntent);
                break;
        }
    }
}