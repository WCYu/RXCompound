package com.rxjy.rxcompound.activity.guwen;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.guwen.AcsessInfo;
import com.rxjy.rxcompound.activity.guwen.GuWenShangchuanInfo;
import com.rxjy.rxcompound.activity.guwen.ImageAddAdapterJie;
import com.rxjy.rxcompound.activity.guwen.WaiChuDetialInfo;
import com.rxjy.rxcompound.adapter.ImageAddAdapter;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.OkhttpUtils2;
import com.rxjy.rxcompound.utils.TakePhotoUtils;
import com.rxjy.rxcompound.widget.MyGridView;

import java.io.File;
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
import okhttp3.Response;

import static com.rxjy.rxcompound.utils.TakePhotoUtils.getOwnCacheDirectory;

public class NewWaiChuDetialActivity extends BaseActivity implements View.OnClickListener, Thread.UncaughtExceptionHandler {
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
    ImageAddAdapterJie imageAddAdapter;
    private int leixing1;
    private String trim;
    private Uri uri;
    private Uri imageUri;

    @Override
    public int getLayout() {
        return R.layout.activity_waichudetial;
    }

    @Override
    public void initData() {
        list_lm = new ArrayList<>();
        list_img = new ArrayList<>();
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
        imageAddAdapter = new ImageAddAdapterJie(list_img, NewWaiChuDetialActivity.this);
        gvImg.setAdapter(imageAddAdapter);
        gvImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i = 1;
                if (position == parent.getChildCount() - 1) {
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//                    startActivityForResult(intent, TAKE_PHOTO_REQUEST);
                    requestPower();
                    requestAllPower();


                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    imageUri = null;
                    if (takePictureIntent.resolveActivity(NewWaiChuDetialActivity.this.getPackageManager()) != null) {
                        String sdcardState = Environment.getExternalStorageState();
                        File outputImage = null;
                        if (Environment.MEDIA_MOUNTED.equals(sdcardState)) {
                            try {
                                outputImage = createImageFile(NewWaiChuDetialActivity.this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(NewWaiChuDetialActivity.this.getApplicationContext(), "内存异常", Toast.LENGTH_SHORT).show();
                        }
                        try {
                            if (outputImage.exists()) {
                                outputImage.delete();
                            }
                            outputImage.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (outputImage != null) {
                            imageUri = Uri.fromFile(outputImage);
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                            startActivityForResult(takePictureIntent, 0);
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                String path = imageUri.getPath();
                File file = new File(path);
                Log.e("====", path + "");
                if (path != null && file.length() != 0) {
                    list_img.add(path);
                    list_imguplode.add(path);
                }
                imageAddAdapter.notifyDataSetChanged();
                Log.e("====", imageUri + "");
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
                            if (leixing1 == 1) {
                                leixing.setText("信息员");
                            } else if (leixing1 == 2) {
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
                break;
        }
    }

    private String upimgstr = "";

    private void commitData() {
        showLoading();
        Map<String, Object> map = new HashMap<String, Object>();
        for (String s : list_imguplode) {
            Log.e("listData>>>>>>>", s);
        }
//        ActionApi/TZManage/UploadImagesToTZ   ApiEngine.RS_API_HOST + "ActionApi/TZManage/UploadImagesToTZ"
//        AppEmployee/UpLoadOutImage
        OkhttpUtils2.uploadFile(ApiEngine.BASEURL + "AppEmployee/UpLoadOutImage", list_imguplode, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("ERROR>>>>>>>>>", e.getMessage());
                showToast("链接服务器失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("shangchuan>>>>>>>>>", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        GuWenShangchuanInfo guWenShangchuanInfo = gson.fromJson(string, GuWenShangchuanInfo.class);
                        List<String> body = guWenShangchuanInfo.getBody();
                        if (body!=null){
                            for (String s : body) {
                                upimgstr = s + ",";
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
                        if (acsessInfo.getStatusCode() == 0) {
                            showToast(acsessInfo.getStatusMsg());
                            dismissLoading();
                            finish();
                        } else {
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

    public void requestPower() {
        //判断是否已经赋予权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //如果应用之前请求过此权限但用户拒绝了请求，此方法将返回 true。
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {//这里可以写个对话框之类的项向用户解释为什么要申请权限，并在对话框的确认键后续再次申请权限
            } else {
                //申请权限，字符串数组内是一个或多个要申请的权限，1是申请权限结果的返回参数，在onRequestPermissionsResult可以得知申请结果
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA,}, 1);
            }
        }
    }

    public void requestAllPower() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    public static File createImageFile(Activity mActivity) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp;//创建以时间命名的文件名称
        File storageDir = getOwnCacheDirectory(mActivity, "takephoto");//创建保存的路径
        File image = new File(storageDir.getPath(), imageFileName + ".jpg");
        if (!image.exists()) {
            try {
                //在指定的文件夹中创建文件
                image.createNewFile();
            } catch (Exception e) {
            }
        }
        return image;
    }
}