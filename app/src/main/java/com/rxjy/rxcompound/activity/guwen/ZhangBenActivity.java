package com.rxjy.rxcompound.activity.guwen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 解亚鑫 on 2018/6/20.
 */

public class ZhangBenActivity extends BaseActivity implements View.OnClickListener {

    public List<ZhangBenInfo.BodyBean.TableBean> table;
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
    @Bind(R.id.lv_zhangben)
    ListView lvZhangben;
    @Bind(R.id.tv_tixian)
    TextView tvTixian;
    private ZhangBenInfo zhangBenInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_zhangben;
    }

    @Override
    public void initData() {
        Log.e("tag_账本", "账本数据");
        ButterKnife.bind(this);
        tvTitle.setText("账本");
        getData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void initListener() {
        ivBack.setOnClickListener(this);
        lvZhangben.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ZhangBenActivity.this, ZhangBenDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("table", table.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        Log.e("tag_账本", "账本数据");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("card_no", App.cardNo);
//        map.put("card_no", "s00004141");
        OkhttpUtils.doPost(ApiEngine.BASEURL + "AppAgent/GetZhangBenList", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_账本", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_账本", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson1 = new Gson();
                        zhangBenInfo = gson1.fromJson(string, ZhangBenInfo.class);
                        tvSum.setText(zhangBenInfo.getBody().getTotal().getBalance() + "");
                        table = zhangBenInfo.getBody().getTable();
                        initAdapter();
                    }
                });
            }
        });
    }

    private void initAdapter() {
        ZhangBenAdapter adapter = new ZhangBenAdapter(table, ZhangBenActivity.this);
        lvZhangben.setAdapter(adapter);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @OnClick(R.id.tv_tixian)
    public void onViewClicked() {
        Intent intent = new Intent(this,TiXianActivity.class);
        startActivity(intent);
    }
}
