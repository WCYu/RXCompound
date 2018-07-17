package com.rxjy.rxcompound.activity.guwen;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.MainActivity;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.guwen.AcsessInfo;
import com.rxjy.rxcompound.activity.guwen.ImageAddAdapterJie;
import com.rxjy.rxcompound.activity.guwen.WaiChuDetialInfo;
import com.rxjy.rxcompound.adapter.ImageAddAdapter;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.EnvirImgBean;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.mvp.contract.EnvirDetailsContract;
import com.rxjy.rxcompound.mvp.presenter.EnvirDetailsPresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.OkhttpUtils2;
import com.rxjy.rxcompound.widget.MyGridView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WaiChuDetialActivity extends BaseActivity implements View.OnClickListener, Thread.UncaughtExceptionHandler {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.iv_save)
    TextView ivSave;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.leixing)
    TextView leixing;
    @Bind(R.id.bianhao)
    TextView bianhao;
    @Bind(R.id.start_time)
    TextView startTime;
    @Bind(R.id.didian)
    TextView didian;
    @Bind(R.id.yuanyin)
    TextView yuanyin;
    @Bind(R.id.fankui)
    EditText fankui;
    @Bind(R.id.gv_img)
    MyGridView gvImg;
    ArrayList<String> list_img;
    private List<WaiChuDetialInfo.BodyBean> body;
    ImageAddAdapter imageAddAdapter;
    private int leixing1;
    private String trim;

    @Override
    public int getLayout() {
        return R.layout.activity_waichudetial;
    }

    @Override
    public void initData() {
        list_lm = new ArrayList<>();
        list_img = new ArrayList<>();
        list_img.add("");
        list_imguplode = new ArrayList<>();
        tvTitle.setText("外出详情");
        ivBack.setOnClickListener(this);
        ivSave.setOnClickListener(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        leixing1 = intent.getIntExtra("leixing", 0);
        getData(id);
        ShowImageAdd();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    int i;
    ArrayList<String> list_imguplode;
    List<LocalMedia> list_lm;

    private void ShowImageAdd() {
        imageAddAdapter = new ImageAddAdapter(WaiChuDetialActivity.this, list_img);
        gvImg.setAdapter(imageAddAdapter);
        gvImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i = 1;
                if (position == parent.getChildCount() - 1) {
                    PictureSelector.create(WaiChuDetialActivity.this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .minSelectNum(0)
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(false)//是否剪裁
                            .compress(false)
                            .selectionMedia(list_lm)
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(666);//结果回调onActivityResult code 
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                list_img.clear();
                list_imguplode.clear();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    list_lm = localMedias;
                    for (int i = 0; i < localMedias.size(); i++) {
                        list_img.add(localMedias.get(i).getPath());
                        list_imguplode.add(localMedias.get(i).getPath());
                    }
                }
                list_img.add(null);
                imageAddAdapter.notifyDataSetChanged();
                break;
        }
    }


    private void getData(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        OkhttpUtils.doGet(ApiEngine.BASEURL + "AppEmployee/GetSalesmanOutDetail", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("外出详情", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        WaiChuDetialInfo waiChuDetialInfo = gson.fromJson(string, WaiChuDetialInfo.class);
                        int statusCode = waiChuDetialInfo.getStatusCode();
                        if (statusCode == 0) {
                            body = waiChuDetialInfo.getBody();
//                            Log.e("类型", leixing1);
                            if (leixing1==1){
                            leixing.setText("信息员");
                            }else if (leixing1==2){
                                leixing.setText("会员");
                            }
                            bianhao.setText(body.get(0).getName());
                            startTime.setText(body.get(0).getWaiChuShiJian());
                            didian.setText(body.get(0).getMeetingArea());
                            yuanyin.setText(body.get(0).getWaiChuYuanYin());
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_save:
                trim = fankui.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    showToast("请输入反馈信息");
                    return;
                }
                if (i == 0) {
                    showToast("请选择反馈照片");
                    return;
                }
                commitData();
//                mPresenter.upLoadImg(list_imguplode);
                break;
        }
    }

    private String upimgstr = "";

    private void commitData() {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String s : list_imguplode) {
            Log.e("listData>>>>>>>", s);
        }
//        ActionApi/TZManage/UploadImagesToTZ
//        AppEmployee/UpLoadOutImage
        OkhttpUtils2.uploadFile(ApiEngine.RS_API_HOST + "ActionApi/TZManage/UploadImagesToTZ", list_imguplode, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("ERROR>>>>>>>>>", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("shangchuan>>>>>>>>>", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        FigureImgBean figureImgBean = gson.fromJson(string, FigureImgBean.class);
                        if (figureImgBean.getStatusCode() == 0) {
                            ArrayList<String> body = figureImgBean.getBody();
                            for (String s : body) {
                                String substring = upimgstr + s.substring(0, s.length() - 1);
                                upimgstr = substring + ",";
                            }
                            upimgstr = upimgstr.substring(0, upimgstr.length() - 1);
                            Log.e("拼接后的字符串", upimgstr);
                            fankui();
                        }
                    }
                });
            }
        });

    }

    private void fankui() {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("WaiChuID", body.get(0).getWaiChuID());
        map1.put("IsFanKui", 1);
        map1.put("WaiChuFanKui", trim);
        map1.put("url", upimgstr);
        OkhttpUtils.doGet(ApiEngine.BASEURL + "AppEmployee/AddWaiChuShenQing", map1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        AcsessInfo acsessInfo = gson.fromJson(string, AcsessInfo.class);
                        if (acsessInfo.getStatusCode()==0){
                            showToast(acsessInfo.getStatusMsg());
                            finish();
                        }else {
                            showToast(acsessInfo.getStatusMsg());
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //在此处理异常
        Log.i("Exception", "uncaughtException   " + e.getMessage());
    }
}