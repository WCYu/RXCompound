package com.rxjy.rxcompound.activity.guwen;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.guwen.WaiChuAdapter;
import com.rxjy.rxcompound.activity.guwen.WaiChuInfo;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class WaiChuActivity extends BaseActivity implements View.OnClickListener{
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.iv_save)
    TextView ivSave;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_waichu)
    ListView lvWaichu;
    private List<WaiChuInfo.BodyBean> body;

    @Override
    public int getLayout() {
        return R.layout.activity_waichu;
    }

    @Override
    public void initData() {
        tvTitle.setText("外出记录");
        getData();
        initListener();
        lvWaichu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (body.get(position).getStatus().equals("待反馈")){
                Intent intent = new Intent(WaiChuActivity.this,NewWaiChuDetialActivity.class);
                intent.putExtra("id",body.get(position).getWaiChuID());
                intent.putExtra("leixing",body.get(position).getLeiXing());
                startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        showLoading();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("card", App.cardNo);
        OkhttpUtils.doGet(ApiEngine.BASEURL + "AppEmployee/FeedbackList", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("外出ACTIVITY",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        WaiChuInfo waiChuInfo = gson.fromJson(string, WaiChuInfo.class);
                        int statusCode = waiChuInfo.getStatusCode();
                        if (statusCode==0){
                            body = waiChuInfo.getBody();
                            initAdapter(body);
                            dismissLoading();
                        }
                    }
                });
            }
        });
    }

    private void initAdapter(List<WaiChuInfo.BodyBean> body) {
        WaiChuAdapter adapter = new WaiChuAdapter(body,WaiChuActivity.this);
        lvWaichu.setAdapter(adapter);
    }

    private void initListener() {
        ivAdd.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                Intent intent = new Intent(this,XinZengWaiChuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
