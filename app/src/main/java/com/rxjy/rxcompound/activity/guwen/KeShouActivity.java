package com.rxjy.rxcompound.activity.guwen;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 解亚鑫 on 2018/6/20.
 */

public class KeShouActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_titletop)
    RelativeLayout rlTitletop;
    @Bind(R.id.img_zonge)
    ImageView imgZonge;
    @Bind(R.id.tv_sum)
    TextView tvSum;
    @Bind(R.id.lv_keshou)
    ListView lvKeshou;
    private List<HuiShouInfo.BodyBean.TableBean> table;
    private HuiShouInfo huiShouInfo;
    public static final String TAG = "KeShouActivity";

    @Override
    public int getLayout() {
        return R.layout.activity_keshou;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        tvTitle.setText("客户收入");
        getdata();
        initListener();
    }

    private void initListener() {
        ivBack.setOnClickListener(this);
    }

    private void getdata() {
        Map<String, Object> map = new HashMap<>();
        map.put("card_no", App.cardNo);
        map.put("Type", "12,13");
        map.put("ShouZhiType", "1");
        map.put("ZhuangTai", "0");
        map.put("LeiXing", "2");
        OkhttpUtils.doPost(ApiEngine.BASEURL + "AppAgent/getLiuShuiList", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i(TAG, "会收>>>>>>>>" + string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson1 = new Gson();
                        huiShouInfo = gson1.fromJson(string, HuiShouInfo.class);
                        table = huiShouInfo.getBody().getTable();
                        tvSum.setText(huiShouInfo.getBody().getTotal().getARMoney() + "");
                        initAdapter();
                    }
                });
            }
        });
    }

    private void initAdapter() {
        HuiShouAdapter adapter = new HuiShouAdapter(table, this);
        lvKeshou.setAdapter(adapter);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
