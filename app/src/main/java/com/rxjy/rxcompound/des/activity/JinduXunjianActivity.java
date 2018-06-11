package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.adapter.XunjianAdapter;
import com.rxjy.rxcompound.des.entity.GetZaishiInfo;
import com.rxjy.rxcompound.des.mvp.contract.GetXunjianListContract;
import com.rxjy.rxcompound.des.mvp.presenter.GetXunjianListPresenter;
import com.rxjy.rxcompound.entity.XunjianListInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class JinduXunjianActivity extends BaseActivity<GetXunjianListPresenter> implements GetXunjianListContract.View {
    XunjianAdapter mAdapter;
    List<XunjianListInfo.BodyBean> list;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_xujnian_xiangmuname)
    TextView tvXujnianXiangmuname;
    @Bind(R.id.tv_xunjian_xiangmuaddress)
    TextView tvXunjianXiangmuaddress;
    @Bind(R.id.lv_jinduxunjian)
    ListView lvJinduxunjian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_jindu_xunjian);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.GetScheduleCheckList(rwdId);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_jindu_xunjian;
    }

    String gongsiname;
    String rwdId;

    @Override
    public void initData() {
        initTitle();
        GetZaishiInfo.BodyBean info = (GetZaishiInfo.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        rwdId = info.getCi_RwdId();

        gongsiname = info.getCi_ClientName();
        list = new ArrayList<>();
        mAdapter = new XunjianAdapter(this, list, gongsiname);
        lvJinduxunjian.setAdapter(mAdapter);
        tvXujnianXiangmuname.setText(info.getCi_ClientName());
        tvXunjianXiangmuaddress.setText(info.getCi_DecorationAddress());
        lvJinduxunjian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(JinduXunjianActivity.this, JinduxunjianXQYActivty.class);
                intent.putExtra("scid", bodyBean.get(position).getSc_Id());
                intent.putExtra("stateName", bodyBean.get(position).getSc_StateName());
                startActivity(intent);
            }
        });

    }

    private void initTitle() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle.setText("进度巡检");


    }

    @Override
    protected GetXunjianListPresenter onCreatePresenter() {
        return new GetXunjianListPresenter(this);
    }

    List<XunjianListInfo.BodyBean> bodyBean;

    @Override
    public void responseXunjianListData(List<XunjianListInfo.BodyBean> bodyBeen) {
        bodyBean = bodyBeen;
        list.clear();
        list.addAll(bodyBeen);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void responseXunjianListDataError() {

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
