package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.fragment.ElectronicFragment;
import com.rxjy.rxcompound.supervision.fragment.PaperFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatumActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_header)
    TextView tvHeader;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rb_datum_paper)
    RadioButton rbDatumPaper;
    @Bind(R.id.rb_datum_electronic)
    RadioButton rbDatumElectronic;
    @Bind(R.id.rg_datum)
    RadioGroup rgDatum;
    @Bind(R.id.v_datum_paper)
    View vDatumPaper;
    @Bind(R.id.v_datum_electronic)
    View vDatumElectronic;
    @Bind(R.id.fl_datum)
    FrameLayout flDatum;

    public static final String TITLE = "资料上传";

    //碎片的集合
    private List<Fragment> fragmentList;

    private PaperFragment paperFragment;

    private ElectronicFragment electronicFragment;

    private Fragment currentFragment;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_datum;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initFragment();
        initTab();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_DATUM_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
        tvHeader.setText("附件资料");
    }

    private void initFragment() {

        fragmentList = new ArrayList<>();

        paperFragment = new PaperFragment();

        electronicFragment = new ElectronicFragment();

        Bundle paperBundle = new Bundle();
        paperBundle.putSerializable(Constants.ACTION_TO_PAPER_PRO_INFO, proInfo);
        paperFragment.setArguments(paperBundle);

        Bundle electronicBundle = new Bundle();
        electronicBundle.putSerializable(Constants.ACTION_TO_ELECTRONIC_PRO_INFO, proInfo);
        electronicFragment.setArguments(electronicBundle);

        fragmentList.add(paperFragment);

        fragmentList.add(electronicFragment);

    }

    private void initTab() {

        rgDatum.setOnCheckedChangeListener(this);

        //初始化选中纸质资料
        selectorDatum(0);

    }

    private void selectorDatum(int index) {
        switch (index) {
            case 0:
                vDatumPaper.setVisibility(View.VISIBLE);
                vDatumElectronic.setVisibility(View.INVISIBLE);
                break;
            case 1:
                vDatumPaper.setVisibility(View.INVISIBLE);
                vDatumElectronic.setVisibility(View.VISIBLE);
                break;
        }
        JumpFragment(fragmentList.get(index));
    }

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_datum, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
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

    @OnClick({R.id.iv_back, R.id.tv_header})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_header:
                Intent intent = new Intent(this, AttachmentActivity.class);
                intent.putExtra(Constants.ACTION_TO_ATTACHMENT_PRO_INFO, proInfo);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_datum_paper:
                selectorDatum(0);
                break;
            case R.id.rb_datum_electronic:
                selectorDatum(1);
                break;
        }
    }
}
