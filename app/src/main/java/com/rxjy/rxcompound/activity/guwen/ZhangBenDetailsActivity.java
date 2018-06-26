package com.rxjy.rxcompound.activity.guwen;

import android.content.Intent;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 解亚鑫 on 2018/6/21.
 */

public class ZhangBenDetailsActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_titletop)
    RelativeLayout rlTitletop;
    @Bind(R.id.lv_zhangben_details)
    ListView lvZhangbenDetails;

    private String laiyuan;
    public static final String TAG = "ZhangbenDetailsActivity";
    private ZhangBenInfo.BodyBean.TableBean table;
    private List<ZhangBenDetailsInfo.BodyBean.TableBean> table1;

    @Override
    public int getLayout() {
        return R.layout.activity_zhangbendetails;
    }

    @Override
    public void initData() {
        getIntentData();
        tvTitle.setText(table.getLaiYuan());
        initListener();
    }

    private void initListener() {
        ivBack.setOnClickListener(this);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        table = (ZhangBenInfo.BodyBean.TableBean) intent.getSerializableExtra("table");
        HashMap<String, Object> map = new HashMap<>();
        map.put("card_no", App.cardNo);
        map.put("Type", table.getType());
        map.put("ShouZhiType", table.getShouZhiType());
        map.put("ZhuangTai", "0");
        map.put("LeiXing", "1");

        OkhttpUtils.doPost(ApiEngine.BASEURL + "AppAgent/getLiuShuiList", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i(TAG, "zhangbendetails>>>>>>>>>>>>" + string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson1 = new Gson();
                        ZhangBenDetailsInfo zhangBenDetailsInfo = gson1.fromJson(string, ZhangBenDetailsInfo.class);
                        table1 = zhangBenDetailsInfo.getBody().getTable();
                        initAdapter();
                    }
                });
            }
        });
    }

    private void initAdapter() {

        ZhangBenDetailsAdapter adapter = new ZhangBenDetailsAdapter(table1, this);
        lvZhangbenDetails.setAdapter(adapter);
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
