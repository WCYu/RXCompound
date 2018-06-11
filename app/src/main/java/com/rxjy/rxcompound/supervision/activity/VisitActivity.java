package com.rxjy.rxcompound.supervision.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.Utility;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.VisitAdapter;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.entity.VisitInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.VisitContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.VisitPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VisitActivity extends BaseActivity<VisitPresenter> implements VisitContract.View, RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_visit)
    ListView lvVisit;
    @Bind(R.id.et_visit_content)
    EditText etVisitContent;
    @Bind(R.id.btn_visit_send)
    Button btnVisitSend;
    @Bind(R.id.rb_visit_left)
    RadioButton rbLeft;
    @Bind(R.id.rb_visit_center)
    RadioButton rbCenter;
    @Bind(R.id.rb_visit_right)
    RadioButton rbRight;
    @Bind(R.id.rg_visit)
    RadioGroup rgVisit;

    public static final String TITLE = "回访";

    private List<VisitInfo.Visit> visitList;

    private VisitAdapter visitAdapter;

    private int status = 0;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_visit;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initVisit();
        initMark();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_VISIT_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initVisit() {

        visitList = new ArrayList<>();

        visitAdapter = new VisitAdapter(this, visitList);

        lvVisit.setAdapter(visitAdapter);

        mPresenter.getWorkLog(proInfo.getOrderNo());

    }

    private void initMark() {

        rgVisit.setOnCheckedChangeListener(this);

    }

    @Override
    protected VisitPresenter onCreatePresenter() {
        return new VisitPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_visit_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_visit_send:
                String content = etVisitContent.getText().toString().trim();
                if (content.equals("")) {
                    showToast("请输入回访内容");
                    return;
                }
                if (status == 0) {
                    showToast("请选择标记");
                    return;
                }
                etVisitContent.setText("");
                //收起软键盘
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                mPresenter.subWorkLog(proInfo.getOrderNo(), content, new ArrayList<String>(), status + "");
                break;
        }
    }

    @Override
    public void responseAddVisitData() {
        mPresenter.getWorkLog(proInfo.getOrderNo());
    }

    @Override
    public void responseAddVisitDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseVisitData(List<VisitInfo.Visit> dataList) {
        visitList.clear();
        visitList.addAll(dataList);
        visitAdapter.notifyDataSetChanged();
        if (visitList.size() != 0)
            lvVisit.setSelection(visitList.size() - 1);
        Utility.setListViewHeightBasedOnChildren(lvVisit);
    }

    @Override
    public void responseVisitDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_visit_left:
                status = 2;
                break;
            case R.id.rb_visit_center:
                status = 1;
                break;
            case R.id.rb_visit_right:
                status = 3;
                break;
        }
    }
}
