package com.rxjy.rxcompound.des.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.PublishActivity;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.GlideRoundTransform;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.entity.ShopBean;
import com.rxjy.rxcompound.des.mvp.contract.ShopContract;
import com.rxjy.rxcompound.des.mvp.presenter.ShopPresenter;
import com.rxjy.rxcompound.entity.MoneySupBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/24.
 */

public class ShopModifyActivity extends BaseActivity<ShopPresenter> implements ShopContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.updata_image)
    ImageView updataImage;
    @Bind(R.id.sheji_age)
    EditText shejiAge;
    @Bind(R.id.sheji_years)
    EditText shejiYears;
    @Bind(R.id.shop_English_name)
    EditText shopEnglishName;
    @Bind(R.id.shop_postage)
    TextView shopPostage;
    @Bind(R.id.autograph)
    EditText autograph;
    @Bind(R.id.submit)
    Button submit;
    private String icCardUpUrl = "";
    RequestOptions options;
    private int CAMERA_INFO_IDENTIFICATION_PHOTO = 1000;
    private OptionsPickerView pickerView;
    private List<String> body;
    private ShopBean.BodyBean bodyBean;

    @Override
    public int getLayout() {
        return R.layout.bes_upload_data;
    }

    @Override
    public void initData() {
        options = new RequestOptions();
        options.centerCrop().transform(new GlideRoundTransform(this, 6));
        body = new ArrayList<>();
        body.add("300元以下");
        body.add("300-800元");
        body.add("800-3000元");
        body.add("3000以上");
        bodyBean = (ShopBean.BodyBean) getIntent().getSerializableExtra("content");

        if (StringUtils.isEmpty(bodyBean.getUm_Age())) {
            shejiAge.setText("无");
        } else {
            shejiAge.setText(bodyBean.getUm_Age() + "");
        }
        if (StringUtils.isEmpty(bodyBean.getUm_EnglishName())) {
            shopEnglishName.setText("无");
        } else {
            shopEnglishName.setText(bodyBean.getUm_EnglishName() + "");
        }
        if (StringUtils.isEmpty(bodyBean.getUm_Motto())) {
            autograph.setText("无");
        } else {
            autograph.setText(bodyBean.getUm_Motto() + "");
        }
        //annualSalary
        if (StringUtils.isEmpty(bodyBean.getUm_WorkYears())) {
            shejiYears.setText("无");
        } else {
            shejiYears.setText(bodyBean.getUm_WorkYears() + "");
        }
        if (StringUtils.isEmpty(bodyBean.getUm_Consultation())) {
            shopPostage.setText("无");
        } else {
            shopPostage.setText(bodyBean.getUm_Consultation() + "");
        }
        //consultation
        //um_ImagePhoto
//        if(StringUtils.isEmpty(bodyBean.getUm_Consultation())){
//            postage.setText("无");
//        }else {
//            postage.setText(bodyBean.getUm_WorkYears()+"");
//        }
    }

    @Override
    protected ShopPresenter onCreatePresenter() {
        return new ShopPresenter(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_INFO_IDENTIFICATION_PHOTO) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            icCardUpUrl = localMedias.get(0).getCompressPath();
            Glide.with(this).load(icCardUpUrl).apply(options).into(updataImage);

        }

    }

    @OnClick({R.id.iv_back, R.id.updata_image, R.id.shop_postage, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                closeKeyboard();
                finish();
                break;
            case R.id.updata_image:
                closeKeyboard();
                PictureSelector.create(ShopModifyActivity.this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .maxSelectNum(1)// 最大图片选择数量 int
                        .minSelectNum(1)// 最小选择数量 int
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .compress(true)// 是否压缩 true or fals
                        .isCamera(true)// 是否显示拍照按钮 true or false
                        .forResult(CAMERA_INFO_IDENTIFICATION_PHOTO);//结果回调onActivityResult code 
                break;
            case R.id.shop_postage:
                closeKeyboard();
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                        shopPostage.setText(body.get(options1));
                    }
                }).build();
                pickerView.setPicker(body);
                pickerView.show();
                break;
            case R.id.submit:
                closeKeyboard();
                String um_age = shejiAge.getText().toString();
                int age = Integer.parseInt(um_age);
                String um_years = shejiYears.getText().toString();
                int years = Integer.parseInt(um_years);
                String englishName = shopEnglishName.getText().toString();
                String zifei = shopPostage.getText().toString();
                String auto = autograph.getText().toString();

                mPresenter.psotUpShopInfo("00000003","",age,years,englishName,zifei,auto);
                break;
        }

    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void showMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void shopresopneData(ShopBean.BodyBean bodyBean) {

    }
}
