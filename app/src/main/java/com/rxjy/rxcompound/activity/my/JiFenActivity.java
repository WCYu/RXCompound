package com.rxjy.rxcompound.activity.my;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.more.JiFenBean;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class JiFenActivity extends BaseActivity {

    @Bind(R.id.tv_jibie)
    TextView tvJibie;
    @Bind(R.id.tv_tidian)
    TextView tvTidian;
    @Bind(R.id.tv_yushou)
    TextView tvYushou;
    @Bind(R.id.tv_shengji)
    TextView tvShengji;
    @Bind(R.id.tv_jiangji)
    TextView tvJiangji;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.tv_yushouC)
    TextView tvYushouC;
    @Bind(R.id.tv_jiangjiC)
    TextView tvJiangjiC;

    @Override
    public int getLayout() {
        return R.layout.activity_ji_fen;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        getJiFenData();
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

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    public void getJiFenData() {
        Map map = new HashMap();
        map.put("kahao",App.cardNo);
        OkhttpUtils.doGet(ApiEngine.JIFENURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_积分",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_积分",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            String statusMsg = jsonObject.getString("StatusMsg");
                            if(statusCode == 0){
                                Gson gson = new Gson();
                                JiFenBean jiFenBean = gson.fromJson(string, JiFenBean.class);
                                JiFenBean.BodyBean body = jiFenBean.getBody();
                                tvJibie.setText( body.getSpare1()+"级");
                                tvTidian.setText(body.getRewardPercent()+"%");
                                tvYushou.setText(body.getRewardRoom()+"");
                                tvYushouC.setText(body.getCRewardRoom()+"");
                                tvShengji.setText(body.getSignOrderUp()+"");
                                tvJiangji.setText(body.getSignOrderDown()+"");
                                tvJiangjiC.setText(body.getMeasureHourse()+"");
                            }else {
                                ToastUtil.getInstance().toastCentent(statusMsg,JiFenActivity.this);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }
}
