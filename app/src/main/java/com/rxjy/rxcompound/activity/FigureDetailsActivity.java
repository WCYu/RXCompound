package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.adapter.ImageAddAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.entity.FigurePersonBean;
import com.rxjy.rxcompound.entity.ImgDataBean;
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
import com.rxjy.rxcompound.mvp.contract.FigureContract;
import com.rxjy.rxcompound.mvp.presenter.FigurePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;
import com.rxjy.rxcompound.widget.MyGridView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
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
 * Created by hjh on 2018/4/25.
 */

public class FigureDetailsActivity extends BaseActivity<FigurePresenter> implements FigureContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.ed_idea)
    EditText edIdea;
    @Bind(R.id.gv_img)
    MyGridView gvImg;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.gv_top)
    RelativeLayout gvTop;
    @Bind(R.id.rl_viewimg)
    RelativeLayout rlViewimg;
    @Bind(R.id.iv_picexample)
    ImageView ivPicexample;
    private String title;

    ArrayList watchimglist ;
    @Override
    public int getLayout() {
        return R.layout.activity_figuredetails;
    }

    private String id_dnum, type;

    @Override
    public void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        type = intent.getStringExtra("type");
        id_dnum = intent.getStringExtra("id_dnum");
        tvTitle.setText(title);
        list_txt = new ArrayList<>();
        list_id = new ArrayList<>();
        mPresenter.getPerson(App.cardNo, type);
        list_img = new ArrayList<>();
        list_imguplode = new ArrayList<>();
        list_img.add("");
        list_lm = new ArrayList<>();
        watchimglist = new ArrayList();
//        rlViewimg.setVisibility(View.GONE);
        ShowImageAdd();
        showImg();
    }

    private void showImg() {
        Map map = new HashMap();
        switch (title){
            case "商务部":
                map.put("dept", 2);
                break;
            case "投资部":
                map.put("dept", 1);
                break;
            case "工程部":
                map.put("dept", 3);
                break;
            case "主案部":
                map.put("dept", 4);
                break;
        }
        map.put("region", App.regionid);
        OkhttpUtils.doGet("http://edu.rxjy.com/a/xz/xzImage/getFormStandard", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_获取默认图片失败",e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tag_默认图片",string);
                Gson gson = new Gson();
                final ImgDataBean imgDataBean = gson.fromJson(string, ImgDataBean.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String imgUrl = imgDataBean.getBody().getImgUrl();
                        Glide.with(FigureDetailsActivity.this).load(imgUrl).into(ivPicexample);
                        watchimglist.add(imgUrl);
                    }
                });
            }
        });

    }

    @Override
    protected FigurePresenter onCreatePresenter() {
        return new FigurePresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private OptionsPickerView pickerView;
    String name, namecard, idea;

    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.gv_top,R.id.iv_picexample})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                name = tvName.getText().toString();
                idea = edIdea.getText().toString();
                if (StringUtils.isEmpty(idea)) {
                    showToast("请输入这一刻的想法！");
                    return;
                }
                if (list_imguplode.size() <= 0) {
                    showToast("请选择图片！");
                    return;
                }
                if (list_imguplode.size() < 1) {
                    showToast("请至少上传一张图片！");
                    return;
                }
                tvSubmit.setEnabled(false);
                mPresenter.upLoadImg(list_imguplode);
                break;
            case R.id.gv_top:
                if (list_txt != null && list_txt.size() > 0) {
                    pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvName.setText(list_txt.get(options1));
                            namecard = list_id.get(options1);
                        }
                    }).build();
                    pickerView.setPicker(list_txt);
                    pickerView.show();
                }
                break;
            case R.id.iv_picexample:
                if(watchimglist!=null&&watchimglist.size()>0){
                    App.titletopcolor=1;
                    watchLargerImage2("",watchimglist,0);
                }
                break;
        }
    }

    ArrayList<String> list_txt;
    ArrayList<String> list_id;

    @Override
    public void responsePerson(FigurePersonBean data) {
        list_txt.clear();
        list_id.clear();
        for (int i = 0; i < data.getBody().size(); i++) {
            list_txt.add(data.getBody().get(i).getUserName());
            list_id.add(data.getBody().get(i).getUserCardno());
        }

    }

    @Override
    public void responsePersonError(String msg) {

    }


    private String upimgstr = "";

    @Override
    public void responseImg(FigureImgBean data) {//图片上传成功！

        for (int i = 0; i < data.getBody().size(); i++) {
            upimgstr = upimgstr + data.getBody().get(i) + ";";
        }
        upimgstr = upimgstr.substring(0, upimgstr.length() - 1);
        Log.e("图片合集", upimgstr);
        mPresenter.upLoadData(namecard, name, idea, upimgstr, id_dnum, App.cardNo, App.name, App.regionid, type,"1");

    }

    @Override
    public void responseImgError(String msg) {
        tvSubmit.setEnabled(true);
        showToast(msg);
    }

    @Override
    public void responseData() {
        showToast("执行成功！");
        finish();
    }

    @Override
    public void responseDataError(String msg) {
        tvSubmit.setEnabled(true);
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();

    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    ArrayList<String> list_img;
    ArrayList<String> list_imguplode;
    List<LocalMedia> list_lm;
    ImageAddAdapter imageAddAdapter;

    private void ShowImageAdd() {
        imageAddAdapter = new ImageAddAdapter(this, list_img);
        gvImg.setAdapter(imageAddAdapter);
        gvImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == list_img.size() - 1) {//点击添加图片
                    PictureSelector.create(FigureDetailsActivity.this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .minSelectNum(0)
                            .compress(true)
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(false)//是否剪裁
                            .selectionMedia(list_lm)
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(666);//结果回调onActivityResult code 
                }
            }
        });
        imageAddAdapter.notifyDataSetChanged();
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
                        list_img.add(localMedias.get(i).getCompressPath());
                        list_imguplode.add(localMedias.get(i).getCompressPath());
                    }
                }
                list_img.add(null);
                imageAddAdapter.notifyDataSetChanged();
                break;
        }
    }

}