package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.JobTryAnAdapter;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.AssementBean;
import com.rxjy.rxcompound.entity.FindBean;
import com.rxjy.rxcompound.mvp.contract.JobTryAnContract;
import com.rxjy.rxcompound.mvp.presenter.JobTryAnPresenter;
import com.rxjy.rxcompound.widget.CircleProgressView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/16.
 */

public class JobTryAnswer extends BaseActivity<JobTryAnPresenter> implements JobTryAnContract.View{

    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.iv_img)
    ImageView iv_img;

    @Bind(R.id.tv_day)
    TextView tv_day;
    @Bind(R.id.cpv_cirprogress)
    CircleProgressView cpv_cirprogress;
    @Bind(R.id.lv_details)
    ListView lv_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    String day,part,cardno;
    @Override
    public void initData() {
        tv_title.setText("试岗答题");
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        Intent intent=getIntent();
        part=intent.getStringExtra("part");
        day=intent.getStringExtra("day");
        mPresenter.getGetData(cardno,part,day);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getGetData(cardno,part,day);
    }

    @OnClick({R.id.iv_back})
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void responseGetData(AssementBean data) {
        double progress=Double.valueOf(data.getPressess());
        cpv_cirprogress.setProgress((int)progress);
        if(day.equals("1")){
            tv_day.setText("第一天");
            iv_img.setImageResource(R.drawable.ic_topdayone);
        }else if(day.equals("2")){
            tv_day.setText("第二天");
            iv_img.setImageResource(R.drawable.ic_topdaytwo);
        }else if(day.equals("3")){
            tv_day.setText("第三天");
            iv_img.setImageResource(R.drawable.ic_topdaythree);
        }
        JobTryAnAdapter jobTryAnAdapter=new JobTryAnAdapter(this,data.getCura());
        lv_details.setAdapter(jobTryAnAdapter);
    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_jobtryan;
    }



    @Override
    protected JobTryAnPresenter onCreatePresenter() {
        return new JobTryAnPresenter(this);
    }

}
