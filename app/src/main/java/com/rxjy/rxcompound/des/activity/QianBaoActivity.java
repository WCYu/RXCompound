package com.rxjy.rxcompound.des.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.adapter.QianBaoFenAdapter;
import com.rxjy.rxcompound.des.adapter.QianBaoListAdapter;
import com.rxjy.rxcompound.des.entity.QianBaoInfo;
import com.rxjy.rxcompound.des.entity.QianbaoFenInfo;
import com.rxjy.rxcompound.des.mvp.contract.QianBaoContracts;
import com.rxjy.rxcompound.des.mvp.presenter.QianBaoPresenter;
import com.rxjy.rxcompound.widget.xlistview.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;

public class QianBaoActivity extends BaseActivity<QianBaoPresenter> implements QianBaoContracts.View, XListView.IXListViewListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_benyueshouru)
    TextView tvBenyueshouru;
    @Bind(R.id.tv_jiedanshouru)
    TextView tvJiedanshouru;
    @Bind(R.id.tv_fanganshouru)
    TextView tvFanganshouru;
    @Bind(R.id.tv_yusuanshouru)
    TextView tvYusuanshouru;
    @Bind(R.id.tv_qiatanshouru)
    TextView tvQiatanshouru;
    @Bind(R.id.tv_hetongshouru)
    TextView tvHetongshouru;
    @Bind(R.id.tv_jiangjinshouru)
    TextView tvJiangjinshouru;
    @Bind(R.id.xlv_qianbao)
    XListView xlv_qianbao;

    @Bind(R.id.ll_jiedan)
    LinearLayout ll_jiedan;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.ll_fangan)
    LinearLayout llFangan;
    @Bind(R.id.ll_yusuan)
    LinearLayout llYusuan;
    @Bind(R.id.ll_qiatan)
    LinearLayout llQiatan;
    @Bind(R.id.ll_hetong)
    LinearLayout llHetong;
    @Bind(R.id.ll_jiangjin)
    LinearLayout llJiangjin;

    @Bind(R.id.ll_zong)
    LinearLayout llzong;

    private int zongfenbs = 0;
    QianBaoListAdapter madapter;
    QianBaoFenAdapter madapterfen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_qian_bao2);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_qian_bao2;
    }

    @Override
    public void initData() {
        mPresenter.getQianBaoInfo(App.cardNo, 1);
        xlv_qianbao.setXListViewListener(this);
        xlv_qianbao.setPullLoadEnable(true);
        tvTitle.setText("钱包");
        Onclick();
    }

    //是否显示加载更多
    private void isShowLoad(int size) {
        if (size < 10) {
            xlv_qianbao.setPullLoadEnable(false);
        } else {
            xlv_qianbao.setPullLoadEnable(true);
        }
    }

    public void Onclick() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llzong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                zongfenbs = 0;
                mPresenter.getQianBaoInfo(App.cardNo, 1);
            }
        });

        ll_jiedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                zongfenbs = 1;
                mPresenter.getQianBaoFenInfo(App.cardNo, 1, 1);
            }
        });
        llFangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                zongfenbs = 2;
                mPresenter.getQianBaoFenInfo(App.cardNo, 1, 2);
            }
        });
        llQiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                zongfenbs = 3;
                mPresenter.getQianBaoFenInfo(App.cardNo, 1, 3);
            }
        });
        llYusuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                zongfenbs = 4;
                mPresenter.getQianBaoFenInfo(App.cardNo, 1, 4);
            }
        });
        llHetong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                zongfenbs = 5;
                mPresenter.getQianBaoFenInfo(App.cardNo, 1, 5);
            }
        });
    }


    @Override
    protected QianBaoPresenter onCreatePresenter() {
        return new QianBaoPresenter(this);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
        xlv_qianbao.stopRefresh();
        xlv_qianbao.stopLoadMore();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        xlv_qianbao.setRefreshTime(sdf.format(new Date()));
    }

    List<QianBaoInfo.BodyBean.SalaryDetailBean> list = new ArrayList<>();
    List<QianbaoFenInfo.BodyBean> listfen = new ArrayList<>();

    @Override
    public void responseQianBaoInfo(QianBaoInfo QBInfo) {

        String benyue = QBInfo.getBody().getAllSalary().replace(".00", "");
        tvBenyueshouru.setText(benyue);
        String jiedan = QBInfo.getBody().getOrderSummary().replace(".00", "");
        tvJiedanshouru.setText(jiedan);
        String fangan = QBInfo.getBody().getProgrammeSummary().replace(".00", "");
        tvFanganshouru.setText(fangan);
        String qiatan = QBInfo.getBody().getNegotiateSummary().replace(".00", "");
        tvQiatanshouru.setText(qiatan);
        String yusuan = QBInfo.getBody().getBudgetSummary().replace(".00", "");
        tvYusuanshouru.setText(yusuan);
        int in1 = QBInfo.getBody().getContractSummary().indexOf(".");
        Log.e("in1", in1 + "");
        String hetong1 = QBInfo.getBody().getContractSummary().substring(0, in1).replace(".00", "");
        int ht1 = Integer.valueOf(hetong1).intValue();
        int ht = ht1;
        tvHetongshouru.setText(ht + "");
        String jiangjin = QBInfo.getBody().getBonus().replace(".00", "");
        tvJiangjinshouru.setText(jiangjin);
        list.clear();
        list.addAll(QBInfo.getBody().getSalaryDetail());
        madapter = new QianBaoListAdapter(this, list);
        xlv_qianbao.setAdapter(madapter);
    }

    @Override
    public void responseQianBaoFenInfo(QianbaoFenInfo QBInfo) {
        listfen.clear();
        listfen.addAll(QBInfo.getBody());
        madapterfen = new QianBaoFenAdapter(this, listfen);
        xlv_qianbao.setAdapter(madapterfen);
    }


    @Override
    public void responseXLQianBaoInfo(QianBaoInfo QBInfo) {
        if (QBInfo.getStatusCode() == 0) {
            i = i + 1;
            list.addAll(QBInfo.getBody().getSalaryDetail());
            madapter.notifyDataSetChanged();
            isShowLoad(QBInfo.getBody().getSalaryDetail().size());
        }
    }

    @Override
    public void responseQianBaoInfoError() {

    }

    @Override
    public void onRefresh() {
        if (zongfenbs==0) {
            mPresenter.getQianBaoInfo(App.cardNo, 1);
        }else{
            mPresenter.getQianBaoFenInfo(App.cardNo,zongfenbs,1);
        }

        }

    int i = 2;

    @Override
    public void onLoadMore() {
        Log.e("zongfenbs", zongfenbs + "");
        if (zongfenbs == 0) {
            mPresenter.getXLQianBaoInfo(App.cardNo, i);
        } else {
            Log.e("zongfenbs"," zongfenbs");
            mPresenter.getXLFenQianBaoInfo(App.cardNo, zongfenbs, i);
        }
    }
}
