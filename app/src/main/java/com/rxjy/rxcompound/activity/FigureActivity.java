package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.FigureListBean;
import com.rxjy.rxcompound.mvp.contract.FigureListContract;
import com.rxjy.rxcompound.mvp.presenter.FigureListPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/25.
 */

public class FigureActivity extends BaseActivity<FigureListPresenter> implements FigureListContract.View{

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.ll_sw)
    LinearLayout llSw;
    @Bind(R.id.ll_tz)
    LinearLayout llTz;
    @Bind(R.id.ll_gc)
    LinearLayout llGc;
    @Bind(R.id.ll_za)
    LinearLayout llZa;

    @Override
    public int getLayout() {
        return R.layout.activity_figure;
    }

    @Override
    public void initData() {
        tvTitle.setText("形象");
        mPresenter.getFigureList(App.cardNo,App.regionid,"1");

    }

    @Override
    protected FigureListPresenter onCreatePresenter() {
        return new FigureListPresenter(this);
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



    @OnClick({R.id.ll_sw, R.id.ll_tz, R.id.ll_gc, R.id.ll_za})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_sw:
                startActivity(new Intent(FigureActivity.this, FigureDetailsActivity.class).putExtra("title", "商务部").putExtra("type","2").putExtra("id_dnum",id_sw));
                break;
            case R.id.ll_tz:
                startActivity(new Intent(FigureActivity.this, FigureDetailsActivity.class).putExtra("title", "投资部").putExtra("type","34").putExtra("id_dnum",id_tz));
                break;
            case R.id.ll_gc:
                startActivity(new Intent(FigureActivity.this, FigureDetailsActivity.class).putExtra("title", "工程部").putExtra("type","4").putExtra("id_dnum",id_gc));
                break;
            case R.id.ll_za:
                startActivity(new Intent(FigureActivity.this, FigureDetailsActivity.class).putExtra("title", "主案部").putExtra("type","3").putExtra("id_dnum",id_za));
                break;
        }
    }

    private String id_sw,id_tz,id_gc,id_za;
    @Override
    public void responseFigureList(FigureListBean data) {
        if(data.getBody().size()==4){
            id_tz=data.getBody().get(0).getId()+"";
            id_sw=data.getBody().get(1).getId()+"";
            id_za=data.getBody().get(2).getId()+"";
            id_gc=data.getBody().get(3).getId()+"";
        }
    }

    @Override
    public void responseFigureListError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}