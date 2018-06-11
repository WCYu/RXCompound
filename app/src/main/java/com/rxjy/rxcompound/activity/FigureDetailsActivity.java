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
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.ImageAddAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.entity.FigurePersonBean;
import com.rxjy.rxcompound.mvp.contract.FigureContract;
import com.rxjy.rxcompound.mvp.presenter.FigurePresenter;
import com.rxjy.rxcompound.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    public int getLayout() {
        return R.layout.activity_figuredetails;
    }

    private String id_dnum, type;

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
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
        rlViewimg.setVisibility(View.GONE);
        ShowImageAdd();
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
    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.gv_top})
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
        mPresenter.upLoadData(namecard, name, idea, upimgstr, id_dnum, App.cardNo, App.name, App.regionid, type);

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