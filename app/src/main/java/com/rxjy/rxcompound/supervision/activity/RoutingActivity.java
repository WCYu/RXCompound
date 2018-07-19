package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.TimeUtil;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.ImageAdapter;
import com.rxjy.rxcompound.supervision.adapter.RoutingAdapter;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.entity.RoutingListInfo;
import com.rxjy.rxcompound.supervision.entity.RoutingStateInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.RoutingContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.RoutingPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoutingActivity extends BaseActivity<RoutingPresenter> implements RoutingContract.View, AdapterView.OnItemClickListener, RoutingAdapter.OnRoutingAdapterClick {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_routing_pro_name)
    TextView tvProName;
    @Bind(R.id.tv_routing_address)
    TextView tvAddress;
    @Bind(R.id.tv_day_count)
    TextView tvDayCount;
    @Bind(R.id.tv_routing_task_state)
    TextView tvTaskState;
    @Bind(R.id.tv_routing_task_time)
    TextView tvTaskTime;
    @Bind(R.id.tv_routing_task_text)
    TextView tvRouting_task_text;
    @Bind(R.id.rl_routing)
    RelativeLayout rlRouting;
    @Bind(R.id.lv_routing)
    ListView lvRouting;

    public static final String TITLE = "巡检记录";

    private List<RoutingListInfo.RoutingInfo> routingList;

    private RoutingAdapter mAdapter;

    private int xjID;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_routing;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initRouting();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ROUTING_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initRouting() {
        tvProName.setText(proInfo.getProName());
        tvAddress.setText(proInfo.getProAddr());
        tvDayCount.setText(proInfo.getWorkDays() + "");

        routingList = new ArrayList<>();

        mAdapter = new RoutingAdapter(this, routingList);

        mAdapter.setOnRoutingAdapterListener(this);

        lvRouting.setAdapter(mAdapter);

        lvRouting.setOnItemClickListener(this);

    }

    @Override
    protected RoutingPresenter onCreatePresenter() {
        return new RoutingPresenter(this);
    }



    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getRoutingList(proInfo.getOrderNo());
        mPresenter.getRoutingState(proInfo.getOrderNo());
    }

    @OnClick({R.id.iv_back, R.id.iv_routing_add, R.id.rl_routing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_routing_add:
//                Intent addIntent = new Intent(this, RoutingSubActivity.class);
                Intent addIntent = new Intent(this, NewRoutingSubActivity.class);
                addIntent.putExtra(Constants.ACTION_TO_ROUTING_SUB_PRO_INFO, proInfo);
                addIntent.putExtra(Constants.ACTION_TO_ROUTING_SUB_XJ_ID, xjID);
                startActivity(addIntent);
                break;
            case R.id.rl_routing:
                //这里作为事件拦截，所以写一个空的点击事件
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RoutingListInfo.RoutingInfo info = routingList.get(position);
//        Intent intent = new Intent(this, RoutingDetailActivity.class);


        Intent intent = new Intent(this, NewRoutingDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_ROUTING_DETAIL_ROUTING_INFO, info);
        intent.putExtra(Constants.ACTION_TO_ROUTING_DETAIL_PRO_INFO, proInfo);
        startActivity(intent);
    }

    @Override
    public void responseRoutingListData(List<RoutingListInfo.RoutingInfo> dataList) {
        routingList.clear();
        routingList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseRoutingListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseRoutingStateData(RoutingStateInfo.RoutingState data) {
        xjID = data.getXj_id();
        tvTaskTime.setText("巡检日期 " + TimeUtil.getNormalTime(data.getBeginTime()).substring(5) + " — " + TimeUtil.getNormalTime(data.getEndTime()).substring(5));
        // isstatus 0 未完成  1  完成
        if (data.getIsstatus() == 0) {
            tvTaskState.setText("未完成");
            tvTaskState.setTextColor(getResources().getColor(R.color.colorRed));
            rlRouting.setVisibility(View.VISIBLE);
        } else {
            tvTaskState.setText("完成");
            tvTaskState.setTextColor(getResources().getColor(R.color.colorGreen));
            rlRouting.setVisibility(View.GONE);
        }

        if(data.getClosetype()==0){
            tvRouting_task_text.setText("本周巡检任务");
        }else{
            tvRouting_task_text.setText("完工巡检");
        }

    }

    @Override
    public void responseRoutingStateDataError(String msg) {
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
    public void onPushTaskClick(RoutingListInfo.RoutingInfo data) {
        showToast("任务推送");
    }
}
