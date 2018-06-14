package com.rxjy.rxcompound.activity.my;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.my.UserInfoBean;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.microedition.khronos.opengles.GL;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserInfoActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.riv_head_photo)
    ImageView rivHeadPhoto;
    @Bind(R.id.rl_icon)
    RelativeLayout rlIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.rl_name)
    RelativeLayout rlName;
    @Bind(R.id.tv_gender)
    TextView tvGender;
    @Bind(R.id.rl_sex)
    RelativeLayout rlSex;
    @Bind(R.id.tv_birthday)
    TextView tvBirthday;
    @Bind(R.id.rl_time)
    RelativeLayout rlTime;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_mailbox)
    TextView tvMailbox;
    @Bind(R.id.rl_youxiang)
    RelativeLayout rlYouxiang;
    @Bind(R.id.tv_erweima)
    ImageView tvErweima;
    @Bind(R.id.rl_erweima)
    RelativeLayout rlErweima;
    @Bind(R.id.tv_area)
    TextView tvArea;
    private ArrayList<Object> sexList;
    private OptionsPickerView sexPicker;
    private String key;
    private String mSex;
    private DatePicker picker;
    private String time;
    private String path;
    private String imgUrl;
    private String imgName;
    private String token;
    private PopupWindow popupWindow;

    @Override
    public int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        getUserInfo();
        initSexData();
        initUpData();
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

    @OnClick({R.id.iv_back, R.id.rl_icon, R.id.rl_name, R.id.rl_sex, R.id.rl_time, R.id.rl_youxiang, R.id.rl_erweima})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_icon://选择头像
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
                break;
            case R.id.rl_name://修改名字
                startActivityForResult(new Intent(UserInfoActivity.this,SetNameActivity.class),1001);
                break;
            case R.id.rl_sex://修改性别
                sexPicker.show();
                break;
            case R.id.rl_time://修改生日
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        key = "birthday";
                        time = year + "-" + month + "-" + day;
                        tvBirthday.setText(time);
                        setUserInfo("birthday",time);
                    }
                });
                picker.show();
                break;
            case R.id.rl_youxiang://修改邮箱
                startActivityForResult(new Intent(UserInfoActivity.this,SetEmiActivity.class),1002);
                break;
            case R.id.rl_erweima://二维码
                View inflate = LayoutInflater.from(this).inflate(R.layout.popu_item_erweima, null);
                popupWindow(inflate,rlErweima);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void setUserInfo(String key,String value) {
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        token = sp.getString("rxdy_token", null);
        Map map = new HashMap();
        map.put("cardNo", App.cardNo);
        map.put("token", token);
        map.put("key", key);
        map.put("value", value);
        Log.e("tag_修改信息", key +"  " +value);
        Log.e("tag_用户信息_App.token", App.cardNo);
        Log.e("tag_用户信息_App.token", token);
        OkhttpUtils.doPost("https://api.dcwzg.com:9191/actionapi/AN_Home/UpdateMyInfo", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_修改信息_失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_修改信息_成功", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }

    private void popupWindow(View vicinityView,View view) {

        popupWindow = new PopupWindow(vicinityView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView img_close = (ImageView) vicinityView.findViewById(R.id.img_close);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha=0.4f;
        getWindow().setAttributes(attributes);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha=1;
                getWindow().setAttributes(attributes);
                popupWindow.dismiss();
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha=1;
                getWindow().setAttributes(attributes);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    path = localMedias.get(0).getCutPath();
                    setImg(path);
                    Glide.with(UserInfoActivity.this).load(path).apply(RequestOptions.circleCropTransform()).into(rivHeadPhoto);
                    break;
            }
        }else {
            switch (requestCode){
                case 1001:
                    if(data!=null){
                        String name = data.getStringExtra("name");
                        Log.e("tag_name",name);
                        setUserInfo("u_name",name);
                    }
                    break;
                case 1002:
                    if(data!=null){
                        String emi = data.getStringExtra("emi");
                        Log.e("tag_emi",emi);
                        setUserInfo("email",emi);
                    }
                    break;
            }
        }
    }

    public void setImg(String path) {
        if (path != null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            File file = new File(path);
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("facefile", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
            builder.addFormDataPart("cardNo", App.cardNo);
            builder.addFormDataPart("token", token);
            RequestBody body = builder.build();
            Request request = new Request.Builder().url("https://api.dcwzg.com:9191/actionapi/AN_Home/UpdateImages").addHeader("Referer", "iPanda.Android")
                    .addHeader("User-Agent", "CNTV_APP_CLIENT_CBOX_MOBILE")
                    .post(body).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("tag_图片上传_失败", e.getMessage().toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Log.e("tag_图片上传", string);
                    try {
                        JSONObject jsonObject = new JSONObject(string);
                        int statusCode = jsonObject.getInt("StatusCode");
                        if (statusCode==0) {
                            JSONObject object = jsonObject.getJSONObject("Body");
                            String url = object.getString("url");
                            Log.e("tag_图片上传成功", url);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initSexData() {

        sexList = new ArrayList<>();

        sexList.add("男");
        sexList.add("女");

        sexPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                key = "sex";
                tvGender.setText(sexList.get(options1).toString());
                mSex = sexList.get(options1).toString();
                setUserInfo("sex",mSex);
            }
        }).build();

        sexPicker.setPicker(sexList);

    }

    private void initUpData() {
        //初始化时间选择器
        picker = new DatePicker(this);
        picker.setRange(1900, 2100);
    }

    public void getUserInfo() {
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        token = sp.getString("rxdy_token", null);
        Map map = new HashMap();
        map.put("cardNo", App.cardNo);
        map.put("token", token);
        Log.e("tag_用户信息_App.token", App.cardNo);
        Log.e("tag_用户信息_App.token", token);
        OkhttpUtils.doPost("https://api.dcwzg.com:9191/actionapi/AN_Home/ShowMyInfo", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_用户信息_失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_用户信息_成功", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        UserInfoBean userInfoBean = gson.fromJson(string, UserInfoBean.class);
                        UserInfoBean.BodyBean bodyBean = userInfoBean.getBody().get(0);
                        tvName.setText(bodyBean.getU_name());
                        tvGender.setText(bodyBean.getSex());
                        tvBirthday.setText(bodyBean.getBirthday_txt());
                        tvPhone.setText(bodyBean.getPhone());
                        tvMailbox.setText(bodyBean.getEmail());
                        Glide.with(UserInfoActivity.this).load(bodyBean.getImage()).apply(RequestOptions.circleCropTransform()).into(rivHeadPhoto);
                    }
                });
            }
        });
    }
}
