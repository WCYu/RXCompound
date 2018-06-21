package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.my.ZhuanZhengActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @Bind(R.id.ly_ruzhi)
    LinearLayout lyRuzhi;
    @Bind(R.id.imageView27)
    ImageView imageView27;
    @Bind(R.id.ly_tiaozhi)
    LinearLayout lyTiaozhi;
    @Bind(R.id.ly_tiaoxin)
    LinearLayout lyTiaoxin;
    @Bind(R.id.img_tiao)
    ImageView imgTiao;

    @Override
    public int getLayout() {
        return R.layout.activity_work2;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
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
                if (!App.regionid.equals("39")) {
                    if (App.ustart == 2 || App.ustart == 3 || App.ustart == 4) {
                        startActivity(new Intent(WorkActivity.this, LeaveActivity.class));
                    }
                }
                //  showToast("暂未开放");

            }
        });
        zhuanzhengLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(WorkActivity.this, "点击了"+App.ustart, Toast.LENGTH_SHORT).show();\
                Log.e("tag_状态",App.ustart+"  "+App.is_group);
                if (App.ustart == 2) {
                    if(App.is_group.equals("0")){
                        startActivity(new Intent(WorkActivity.this, BecomeWorkerActivity.class));
                    }else if(App.is_group.equals("1")){
                        startActivity(new Intent(WorkActivity.this, ZhuanZhengActivity.class));
                    }
                }else if(App.ustart == 3){
                    ToastUtil.getInstance().toastCentent("您已经是正式员工");
                }else {
                    ToastUtil.getInstance().toastCentent("只有试用期人员才可以申请");
                }
                //  showToast("暂未开放");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.ly_ruzhi, R.id.ly_tiaozhi, R.id.ly_tiaoxin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ly_ruzhi:
//                ToastUtil.getInstance().toastCentent("入职");
                break;
            case R.id.ly_tiaozhi:
                ToastUtil.getInstance().toastCentent("调职");
                break;
            case R.id.ly_tiaoxin:
                ToastUtil.getInstance().toastCentent("调薪");
                break;
        }
    }
}
