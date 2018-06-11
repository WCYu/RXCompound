package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorkActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.qingjia_line)
    LinearLayout qingjiaLine;
    @Bind(R.id.zhuanzheng_line)
    LinearLayout zhuanzhengLine;
    @Bind(R.id.ge_line)
    LinearLayout geLine;
    @Bind(R.id.wenhua_line)
    LinearLayout wenhuaLine;

    @Override
    public int getLayout() {
        return R.layout.activity_work2;
    }

    @Override
    public void initData() {
        tvTitle.setText("办公");
        geLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkActivity.this, RXSongsActivity.class));
            }
        });
        wenhuaLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkActivity.this, RXlinesActivity.class));
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        qingjiaLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!App.regionid.equals("39")){
                    if(App.ustart==2||App.ustart==3||App.ustart==4){
                        startActivity(new Intent(WorkActivity.this, LeaveActivity.class));
                    }
                }
              //  showToast("暂未开放");

            }
        });
        zhuanzhengLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(WorkActivity.this, "点击了"+App.ustart, Toast.LENGTH_SHORT).show();
                if(App.ustart==2){
                    startActivity(new Intent(WorkActivity.this, BecomeWorkerActivity.class));
                }
              //  showToast("暂未开放");
            }
        });
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
}
