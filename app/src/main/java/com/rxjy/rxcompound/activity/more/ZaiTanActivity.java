package com.rxjy.rxcompound.activity.more;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.more.KeHuDataBean;
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

public class ZaiTanActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.et_leixing)
    EditText etLeixing;
    @Bind(R.id.et_hangye)
    EditText etHangye;
    @Bind(R.id.et_zhiming)
    EditText etZhiming;
    @Bind(R.id.et_kehu)
    EditText etKehu;
    @Bind(R.id.et_shenfen)
    EditText etShenfen;
    @Bind(R.id.et_xijie)
    EditText etXijie;
    @Bind(R.id.et_fangyuan)
    EditText etFangyuan;
    @Bind(R.id.et_mianji)
    EditText etMianji;
    @Bind(R.id.et_fangwu)
    EditText etFangwu;
    @Bind(R.id.et_yusuan)
    EditText etYusuan;
    @Bind(R.id.et_liangfang)
    EditText etLiangfang;
    @Bind(R.id.et_shuxing)
    EditText etShuxing;
    @Bind(R.id.btn_commit)
    Button btnCommit;

    @Override
    public int getLayout() {
        return R.layout.activity_zai_tan;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        getKeHuInfo();
        getLieBiaoData();
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

    public void getKeHuInfo() {
        Map map = new HashMap();
        map.put("id",getIntent().getIntExtra("id",0));
        map.put("type",1);
        OkhttpUtils.doPost(ApiEngine.KEHUINFOURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_客户详情",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_客户详情",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        KeHuDataBean keHuDataBean = gson.fromJson(string, KeHuDataBean.class);
                        List<KeHuDataBean.BodyBean> body = keHuDataBean.getBody();
                        KeHuDataBean.BodyBean bodyBean = body.get(0);
                        etLeixing.setText(bodyBean.getLeiXingMingCheng());
                        etHangye.setText(bodyBean.getLeiXingErMingCheng());
                        String zhiMingQiYe = bodyBean.getZhiMingQiYe();
                        if(!TextUtils.isEmpty(zhiMingQiYe)){
                            switch (zhiMingQiYe){
                                case "1":
                                    etZhiming.setText("是");
                                    break;
                                case "2":
                                    etZhiming.setText("否");
                                    break;
                            }
                        }

                        etKehu.setText(bodyBean.getXingMing());
                        etShenfen.setText(bodyBean.getShenFenName());
                        String zhuZhongDianID = bodyBean.getZhuZhongDianID();
                        if(!TextUtils.isEmpty(zhuZhongDianID)){
                            switch (zhuZhongDianID){
                                case "157":
                                    etXijie.setText("效率");
                                    break;
                                case "158":
                                    etXijie.setText("细节");
                                    break;
                                case "159":
                                    etXijie.setText("价格");
                                    break;
                                case "160":
                                    etXijie.setText("设计");
                                    break;
                                case "161":
                                    etXijie.setText("质量");
                                    break;
                                case "185":
                                    etXijie.setText("工期");
                                    break;
                                case "186":
                                    etXijie.setText("施工人员");
                                    break;
                                case "187":
                                    etXijie.setText("公司规模");
                                    break;
                            }
                        }


                        String fangYuan = bodyBean.getFangYuan();
                        if(!TextUtils.isEmpty(fangYuan)){
                            switch (fangYuan){
                                case "1":
                                    etFangyuan.setText("已定");
                                    break;
                                case "2":
                                    etFangyuan.setText("未定");
                                    break;
                            }
                        }

                        etMianji.setText(bodyBean.getMianJi()+" ㎡");
                        String yuJiZhuangXiu = bodyBean.getYuJiZhuangXiu();
                        if(!TextUtils.isEmpty(yuJiZhuangXiu)){
                            switch (yuJiZhuangXiu){
                                case "1":
                                    etFangwu.setText("毛坯房");
                                    break;
                                case "2":
                                    etFangwu.setText("清水房");
                                    break;
                                case "3":
                                    etFangwu.setText("精装房");
                                    break;
                                case "5":
                                    etFangwu.setText("翻新");
                                    break;
                                case "6":
                                    etFangwu.setText("旧房改造");
                                    break;
                            }
                        }

                        etYusuan.setText(bodyBean.getZhuangXiuYuSuan()+"");
                        etLiangfang.setText(bodyBean.getLiangFangDiZhi());
                        etShuxing.setText(bodyBean.getShuXing());
                    }
                });
            }
        });
    }

    public void getLieBiaoData() {
        Map map = new HashMap();
        map.put("type",2);
        OkhttpUtils.doGet(ApiEngine.LISTURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_列表",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_列表",string);
            }
        });
    }
}
