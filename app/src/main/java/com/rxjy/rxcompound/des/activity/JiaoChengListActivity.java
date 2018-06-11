package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;

public class JiaoChengListActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.ll_biaoshu)
    LinearLayout ll_biaoshu;
    @Bind(R.id.ll_yusuan)
    LinearLayout ll_yusuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_jiao_cheng_list);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_jiao_cheng_list;
    }

    @Override
    public void initData() {

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title.setText("标书");

        ll_biaoshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(JiaoChengListActivity.this,BiaoShuActivity.class);
                intent.putExtra(Constants.JIAOCHENG,1);
                startActivity(intent);
            }
        });

        ll_yusuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(JiaoChengListActivity.this,BiaoShuActivity.class);
                intent.putExtra(Constants.JIAOCHENG,2);
                startActivity(intent);
            }
        });

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
