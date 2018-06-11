package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.BackVisitActivity;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.adapter.TalkAdapter;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.GetHuiFang;
import com.rxjy.rxcompound.des.mvp.contract.CompactContract;
import com.rxjy.rxcompound.des.mvp.contract.TalkContract;
import com.rxjy.rxcompound.des.mvp.presenter.TalkPresenter;
import com.rxjy.rxcompound.widget.xlistview.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.OnClick;

public class TalkActivity extends BaseActivity<TalkPresenter> implements TalkContract.View, XListView.IXListViewListener, RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.iv_add)
    TextView tv_add;
    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.tv_title)
    TextView tvtitle;
    @Bind(R.id.zsxm_lv)
    XListView xListView;
    @Bind(R.id.zsxm_et)
    EditText et_zsxm;
    @Bind(R.id.iv_zsxm_noinfo)
    ImageView iv_noinfo;
    @Bind(R.id.tv_zsxm_noinfo)
    TextView tv_noinfo;
    @Bind(R.id.btn_talk_send)
    Button btn_send;
    @Bind(R.id.ll_liangfangandyiqian)
    LinearLayout llLiangfangandyiqian;
    @Bind(R.id.tv_liangfang)
    TextView tvLiangfang;
    @Bind(R.id.tv_shigongyiqian)
    TextView tvShigongyiqian;
    @Bind(R.id.rb_face_to_face)
    RadioButton rbFaceToFace;
    @Bind(R.id.rb_communication)
    RadioButton rbCommunication;
    @Bind(R.id.rb_un_talk)
    RadioButton rbUnTalk;
    @Bind(R.id.rb_un_companytalk)
    RadioButton rb_un_companytalk;
    @Bind(R.id.gv_talk)
    RadioGroup gvTalk;

    //    AllClientInfo.ClientTypeInfo.ClientInfo info;
    AllClientNewBean.ClientNewBean info;

    TalkAdapter adapter;
    public String TITLE = "在谈项目";
    @Bind(R.id.tv_plan)
    TextView tvPlan;
    @Bind(R.id.tv_contract)
    TextView tvContract;
    private int visitMonth = -1;
    public static TalkActivity activity;
    public static String isshuaxin = "";//1：刷新所有数据  2：只刷新底部选中按钮

    //int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_talk);
    }

    private boolean panduan;

    @Override
    public int getLayout() {
        return R.layout.activity_talk;
    }

    @Override
    public void initData() {
        activity = this;
        initTitle();
        onclick();
        initMark();
        xListView.setXListViewListener(this);
        xListView.setPullLoadEnable(false);

//        info = (AllClientInfo.ClientTypeInfo.ClientInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        info = (AllClientNewBean.ClientNewBean) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        Log.e("info", info.toString());
//        mPresenter.getHuiFangData(info.getCi_rwdid(), 1);
        mPresenter.getHuiFangData(info.getCi_RwdId(), 1);
        xListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (totalItemCount > visibleItemCount) {
                    //有第二页
                    panduan = true;
                }
                if (totalItemCount < visibleItemCount) {
                    panduan = false;
                }
                if (panduan == true) {
                    xListView.setStackFromBottom(true);
                } else if (panduan == false) {
                    xListView.setStackFromBottom(false);
                }

            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        switch (isshuaxin) {
            case "1":
                isshuaxin = "";
                visitMonth = -1;
//                mPresenter.getHuiFangData(info.getCi_rwdid(), 1);
                mPresenter.getHuiFangData(info.getCi_RwdId(), 1);
                break;
            case "2":
                isshuaxin = "";
                visitMonth = -1;
                break;
        }
    }

    private void initMark() {
        gvTalk.setOnCheckedChangeListener(this);

    }

    int lfandyqbs = 0;

    private void onclick() {
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lfandyqbs == 0) {
                    lfandyqbs = 1;
                    llLiangfangandyiqian.setVisibility(View.VISIBLE);
                } else if (lfandyqbs == 1) {
                    lfandyqbs = 0;
                    llLiangfangandyiqian.setVisibility(View.GONE);
                }
            }
        });

        tvLiangfang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TalkActivity.this, YiLiangFangActivity.class);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO));
                lfandyqbs = 0;
                llLiangfangandyiqian.setVisibility(View.GONE);

                startActivity(intent);
            }
        });

        tvShigongyiqian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TalkActivity.this, ShigonghetongActivity.class);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, info);

                lfandyqbs = 0;
                llLiangfangandyiqian.setVisibility(View.GONE);

                startActivity(intent);

            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_zsxm.getText().toString().isEmpty()) {
                    showToast("还是写点什么吧");
                    return;
                }
                if (visitMonth == -1) {
                    showToast("亲记得选择回访类型呦...");
                    return;
                }
//                mPresenter.addHuiFangData(info.getCi_rwdid(), et_zsxm.getText().toString(), visitMonth);
                mPresenter.addHuiFangData(info.getCi_RwdId(), et_zsxm.getText().toString(), visitMonth);
                et_zsxm.setText("");

            }
        });
        tvContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(TalkActivity.this, CompactActivity.class);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, info);
                startActivity(intent);
            }
        });
    }

    private void initTitle() {

        tvtitle.setText(TITLE);
        tv_add.setVisibility(View.VISIBLE);
    }


    @Override
    protected TalkPresenter onCreatePresenter() {
        return new TalkPresenter(this);
    }

    @Override
    public void loadnodata() {
        showToast("没有更多数据了！");
    }

    List<GetHuiFang.Body> list = new ArrayList<>();

    @Override
    public void responseTalkData() {
//        mPresenter.getHuiFangData(info.getCi_rwdid(), 1);
        mPresenter.getHuiFangData(info.getCi_RwdId(), 1);
    }

    @Override
    public void responseTalkDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void xlshowList(GetHuiFang body) {
        if (body.getStatusCode() == 1) {
            loadnodata();
        } else {
            i = i + 1;
            list.addAll(0, body.getBody());
            xListView.setStackFromBottom(false);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showList(List<GetHuiFang.Body> body) {
        // if (i==1){
        list.clear();
        if (body.size() == 0) {
            xListView.setVisibility(View.GONE);
            iv_noinfo.setVisibility(View.VISIBLE);
            tv_noinfo.setVisibility(View.VISIBLE);
        } else {
            xListView.setVisibility(View.VISIBLE);
            iv_noinfo.setVisibility(View.GONE);
            tv_noinfo.setVisibility(View.GONE);
        }
        //   }
        for (GetHuiFang.Body body1 : body) {
            Log.e("pos22", body1.getCv_Type() + "");
            Log.e("pos22", body1.getCv_TodayProgress());

        }
        list.addAll(body);
        adapter = new TalkAdapter(this, list);
        xListView.setAdapter(adapter);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
        xListView.stopRefresh();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        xListView.setRefreshTime(sdf.format(new Date()));
    }

    int i = 2;

    @Override
    public void onRefresh(){
//        mPresenter.xlgetHuiFangData(info.getCi_rwdid(), i);
        mPresenter.xlgetHuiFangData(info.getCi_RwdId(), i);

    }

    @Override
    public void onLoadMore(){

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_face_to_face:
                visitMonth = 0;
                ToaddTalk(visitMonth);
                break;
            case R.id.rb_communication:
                visitMonth = 1;
                ToaddTalk(visitMonth);
                break;
            case R.id.rb_un_talk:
                visitMonth = 2;
                ToaddTalk(visitMonth);
                break;
            case R.id.rb_un_companytalk:
                visitMonth = 3;
                ToaddTalk(visitMonth);
                break;
        }
    }


    public void ToaddTalk(int type) {
        gvTalk.clearCheck();
        startActivity(new Intent(this, BackVisitActivity.class).putExtra("type", type + "").putExtra("cid", info.getCi_RwdId()));
    }




    @OnClick({R.id.tv_plan, R.id.tv_contract})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_plan:
                lfandyqbs = 0;
                llLiangfangandyiqian.setVisibility(View.GONE);
                startActivity(new Intent(this, PlanActivity.class).putExtra("title", info.getCi_ClientName()).putExtra("address", info.getCi_DecorationAddress()).putExtra("rwdid", info.getCi_RwdId()));
                break;
            case R.id.tv_contract://合同
                lfandyqbs = 0;
                llLiangfangandyiqian.setVisibility(View.GONE);
                startActivity(new Intent(this,TalkContractActivity.class).putExtra("rwdid",info.getCi_RwdId()));
                break;
        }
    }


}