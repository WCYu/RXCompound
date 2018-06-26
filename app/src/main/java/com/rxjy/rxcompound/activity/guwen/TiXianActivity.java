package com.rxjy.rxcompound.activity.guwen;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
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

public class TiXianActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_titletop)
    RelativeLayout rlTitletop;
    @Bind(R.id.et_jine)
    EditText etJine;
    @Bind(R.id.btn_tixian)
    Button btnTixian;

    @Override
    public int getLayout() {
        return R.layout.activity_ti_xian;
    }

    @Override
    public void initData() {

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

    @OnClick({R.id.iv_back, R.id.btn_tixian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_tixian:
                if(TextUtils.isEmpty(etJine.getText().toString())){
                    ToastUtil.getInstance().toastCentent("请输入提现金额");
                    return;
                }
                Map map = new HashMap();
                map.put("Money",etJine.getText().toString());
                map.put("card_no", App.cardNo);
                OkhttpUtils.doPost("https://api.niujingji.cn:8183/AppAgent/HuiYuanTiXian", map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("tag_提现",e.getMessage().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.getInstance().toastCentent("失败 ");
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        Log.e("tag_提现",string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonObject = new JSONObject(string);
                                    int statusCode = jsonObject.getInt("StatusCode");
                                    String statusMsg = jsonObject.getString("StatusMsg");
                                    if(statusCode == 0){
                                        ToastUtil.getInstance().toastCentent("提取成功");
                                        finish();
                                    }else {
                                        ToastUtil.getInstance().toastCentent(statusMsg);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                });
                break;
        }
    }
}
