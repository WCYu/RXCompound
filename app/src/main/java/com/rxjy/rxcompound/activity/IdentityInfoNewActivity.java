package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.IdentityInfoBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.mvp.contract.IdentityInfoContract;
import com.rxjy.rxcompound.mvp.presenter.IdentityInfoPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.rxjy.rxcompound.activity.IdentityInfoActivity.getDateToString;

/**
 * Created by hjh on 2018/5/3.
 */
public class IdentityInfoNewActivity extends BaseActivity<IdentityInfoPresenter> implements IdentityInfoContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_personicon)
    ImageView ivPersonicon;
    @Bind(R.id.iv_addthree)
    ImageView ivAddthree;
    @Bind(R.id.rl_idcardthree)
    RelativeLayout rlIdcardthree;
    @Bind(R.id.rl_idcardfour)
    RelativeLayout rlIdcardfour;
    @Bind(R.id.iv_idcardone)
    ImageView ivIdcardone;
    @Bind(R.id.iv_addone)
    ImageView ivAddone;
    @Bind(R.id.rl_idcardone)
    RelativeLayout rlIdcardone;
    @Bind(R.id.iv_idcardtwo)
    ImageView ivIdcardtwo;
    @Bind(R.id.iv_addtwo)
    ImageView ivAddtwo;
    @Bind(R.id.rl_idcardtwo)
    RelativeLayout rlIdcardtwo;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_idcard)
    EditText etIdcard;
    @Bind(R.id.et_oldaddress)
    EditText etOldaddress;
    @Bind(R.id.et_nowaddress)
    EditText etNowaddress;
    @Bind(R.id.tv_birth)
    TextView tvBirth;
    @Bind(R.id.rl_birth)
    RelativeLayout rlBirth;
    @Bind(R.id.tv_edu)
    TextView tvEdu;
    @Bind(R.id.rl_edu)
    RelativeLayout rlEdu;
    @Bind(R.id.tv_marrary)
    TextView tvMarrary;
    @Bind(R.id.rl_ismarry)
    RelativeLayout rlIsmarry;
    @Bind(R.id.tv_save)
    TextView tvSave;

    List<String> ismarrrylist;
    List<String> edubglist;

    @Override
    public int getLayout() {
        return R.layout.activity_identityinfor;
    }

    public static IdentityInfoNewActivity instance = null;
    public int change;

    @Override
    public void initData() {
        instance = this;
        tvTitle.setText("身份信息");
        mPresenter.getMessage(App.cardNo, "2");
        ismarrrylist = new ArrayList<>();
        ismarrrylist.add("已婚");
        ismarrrylist.add("未婚");

        edubglist = new ArrayList<>();
        edubglist.add("高中");
        edubglist.add("专科");
        edubglist.add("中专");
        edubglist.add("大专");
        edubglist.add("本科");
        edubglist.add("本科以上");
    }

    @Override
    protected IdentityInfoPresenter onCreatePresenter() {
        return new IdentityInfoPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    int txtnochange = 0;

    @Override
    protected void onResume() {
        super.onResume();
        if (change == 1) {
            change = 0;
            txtnochange = 1;
            mPresenter.getMessage(App.cardNo, "2");
        }
    }


    int idcardone, idcardtwo, idcardthree;
    String idcardoneimg, idcardtwoimg, idcardthreeimg;
    String birthup;
    int hasone, hastwo, hasthree;//第一张第二、三张图片是否有

    @OnClick({R.id.iv_back, R.id.rl_idcardthree, R.id.rl_idcardfour, R.id.rl_idcardone, R.id.rl_idcardtwo, R.id.rl_birth, R.id.rl_edu, R.id.rl_ismarry, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //提交数据到服务器
//                。。。。。。。。
                SubmitData();
                break;
            case R.id.rl_idcardthree:
                if (hasthree == 1) {//跳转
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "个人形象照")
                            .putExtra("type", "17")
                            .putExtra("img", idcardthreeimg));

                } else {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(668);//结果回调onActivityResult code 
                }
                break;
            case R.id.rl_idcardfour:
                break;
            case R.id.rl_idcardone:
                if (hasone == 1) {//跳转
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "身份证正面")
                            .putExtra("type", "4")
                            .putExtra("img", idcardoneimg));
                } else {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(666);//结果回调onActivityResult code 
                }
                break;
            case R.id.rl_idcardtwo:
                if (hastwo == 1) {//跳转
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "身份证反面")
                            .putExtra("type", "13")
                            .putExtra("img", idcardtwoimg));
                } else {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(667);//结果回调onActivityResult code 
                }
                break;
            case R.id.rl_birth:
                TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String birth = getDateToString(date, "yyyy年MM月dd日");
                        birthup = getDateToString(date, "yyyy/MM/dd");
                        tvBirth.setText(birth);

                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                        .build();
                timePickerView.show();
                break;
            case R.id.rl_edu:
                OptionsPickerView pickerViewedubg = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvEdu.setText(edubglist.get(options1));
                    }
                }).build();
                pickerViewedubg.setPicker(edubglist);
                pickerViewedubg.show();
                break;
            case R.id.rl_ismarry:
                OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvMarrary.setText(ismarrrylist.get(options1));
                    }
                }).build();
                pickerView.setPicker(ismarrrylist);
                pickerView.show();
                break;
            case R.id.tv_save:
                if (hasthree == 0) {
                    showToast("请上传形象照！");
                    return;
                }
                if (hasone == 0) {
                    showToast("请上传身份证正面！");
                    return;
                }
                if (hastwo == 0) {
                    showToast("请上传身份证反面！");
                    return;
                }
                String name = etName.getText().toString();
                String idcard = etIdcard.getText().toString();
                String address = etOldaddress.getText().toString();
                String nowaddress = etNowaddress.getText().toString();
                String birth = birthup;
                String edu = tvEdu.getText().toString();
                String marrary = tvMarrary.getText().toString();
                if (StringUtils.isEmpty(name) || name.equals("请输入")) {
                    showToast("请输入身份姓名！");
                    return;
                }
                if (StringUtils.isEmpty(idcard) || idcard.equals("请输入")) {
                    showToast("请输入身份证号！");
                    return;
                }
                if (StringUtils.isEmpty(address) || address.equals("请输入")) {
                    showToast("请输入身份地址！");
                    return;
                }
                if (StringUtils.isEmpty(nowaddress) || nowaddress.equals("请输入")) {
                    showToast("请输入现住址！");
                    return;
                }
                if (StringUtils.isEmpty(birth)) {
                    showToast("请选择生日！");
                    return;
                }
                if (StringUtils.isEmpty(edu)) {
                    showToast("请选择学历！");
                    return;
                }
                if (StringUtils.isEmpty(marrary) || marrary.equals("请输入")) {
                    showToast("请选择婚否！");
                    return;
                }
                subtype=2;
                mPresenter.upDataMessage(App.cardNo, "2", idcard, name, birth, address, nowaddress, marrary, edu);
                break;
        }
    }

    @Override
    public void responseMessage(IdentityInfoBean data) {
        //设置点击
        if (data.getBody().getIsFinsh() == 1) {
            rlIdcardthree.setEnabled(false);
            rlIdcardone.setEnabled(false);
            rlIdcardtwo.setEnabled(false);
            etName.setEnabled(false);
            etIdcard.setEnabled(false);
            etOldaddress.setEnabled(false);
            etNowaddress.setEnabled(false);
            rlBirth.setEnabled(false);
            rlEdu.setEnabled(false);
            rlIsmarry.setEnabled(false);
            tvSave.setVisibility(View.GONE);
        } else {
            if (!StringUtils.isEmpty(data.getBody().getImageState())) {
                if (data.getBody().getImageState().equals("1") || data.getBody().getImageState().equals("4")) {
                    rlIdcardthree.setEnabled(false);
                } else {
                    rlIdcardthree.setEnabled(true);
                }
            } else {
                rlIdcardthree.setEnabled(true);
            }
            if (!StringUtils.isEmpty(data.getBody().getShenFenDataState())) {
                if (data.getBody().getShenFenDataState().equals("1") || data.getBody().getShenFenDataState().equals("4")) {
                    rlIdcardone.setEnabled(false);
                    rlIdcardtwo.setEnabled(false);
                    etName.setEnabled(false);
                    etIdcard.setEnabled(false);
                    etOldaddress.setEnabled(false);
                } else {
                    rlIdcardone.setEnabled(true);
                    rlIdcardtwo.setEnabled(true);
                    etName.setEnabled(true);
                    etIdcard.setEnabled(true);
                    etOldaddress.setEnabled(true);
                }
            } else {
                rlIdcardone.setEnabled(true);
                rlIdcardtwo.setEnabled(true);
                etName.setEnabled(true);
                etIdcard.setEnabled(true);
                etOldaddress.setEnabled(true);
            }
            if (!StringUtils.isEmpty(data.getBody().getXianZhuZhiDataState())) {
                if (data.getBody().getXianZhuZhiDataState().equals("1") || data.getBody().getXianZhuZhiDataState().equals("4")) {
                    etNowaddress.setEnabled(false);
                } else {
                    etNowaddress.setEnabled(true);
                }
            } else {
                etNowaddress.setEnabled(true);
            }
            if (!StringUtils.isEmpty(data.getBody().getShengRiDataState())) {
                if (data.getBody().getShengRiDataState().equals("1") || data.getBody().getShengRiDataState().equals("4")) {
                    rlBirth.setEnabled(false);
                } else {
                    rlBirth.setEnabled(true);
                }
            } else {
                rlBirth.setEnabled(true);
            }
            if (!StringUtils.isEmpty(data.getBody().getXueLiDataState())) {
                if (data.getBody().getXueLiDataState().equals("1") || data.getBody().getXueLiDataState().equals("4")) {
                    rlEdu.setEnabled(false);
                } else {
                    rlEdu.setEnabled(true);
                }
            } else {
                rlEdu.setEnabled(true);
            }
            if (!StringUtils.isEmpty(data.getBody().getHunFouDataState())) {
                if (data.getBody().getHunFouDataState().equals("1") || data.getBody().getHunFouDataState().equals("4")) {
                    rlEdu.setEnabled(false);
                } else {
                    rlEdu.setEnabled(true);
                }
            } else {
                rlEdu.setEnabled(true);
            }
        }


        //设置内容
        if (txtnochange == 0) {
            if (!StringUtils.isEmpty(data.getBody().getIdCardName())) {
                etName.setText(data.getBody().getIdCardName());
            }
            if (!StringUtils.isEmpty(data.getBody().getIdCard())) {
                etIdcard.setText(data.getBody().getIdCard());
            }
            if (!StringUtils.isEmpty(data.getBody().getIdCardAddress())) {
                etOldaddress.setText(data.getBody().getIdCardAddress());
            }
            if (!StringUtils.isEmpty(data.getBody().getNowAddress())) {
                etNowaddress.setText(data.getBody().getNowAddress());
            }
            if (!StringUtils.isEmpty(data.getBody().getMarriage())) {
                tvMarrary.setText(data.getBody().getMarriage());
            }
            if (!StringUtils.isEmpty(data.getBody().getBirthday())) {
                String birth = data.getBody().getBirthday();
                birthup = birth.replaceAll("-", "/");
                birthup = birthup.replaceAll("年", "/");
                birthup = birthup.replaceAll("月", "/");
                birthup = birthup.replaceAll("日", "");
                Log.e("birthup1", birthup);
                tvBirth.setText(birth);
            }
            if (!StringUtils.isEmpty(data.getBody().getXueli())) {
                tvEdu.setText(data.getBody().getXueli());
            }
        }

        if (!StringUtils.isEmpty(data.getBody().getIdCardImageHeads())) {
            idcardone = 1;
            hasone = 1;
            idcardoneimg = data.getBody().getIdCardImageHeads();
            ivAddone.setVisibility(View.GONE);
            Glide.with(this).load(data.getBody().getIdCardImageHeads()).into(ivIdcardone);
        }
        if (!StringUtils.isEmpty(data.getBody().getIdCardImageTails())) {
            idcardtwo = 1;
            hastwo = 1;
            idcardtwoimg = data.getBody().getIdCardImageTails();
            ivAddtwo.setVisibility(View.GONE);
            Glide.with(this).load(data.getBody().getIdCardImageTails()).into(ivIdcardtwo);
        }
        if (!StringUtils.isEmpty(data.getBody().getImage())) {
            idcardthree = 1;
            hasthree = 1;
            idcardthreeimg = data.getBody().getImage();
            ivAddthree.setVisibility(View.GONE);
            Glide.with(this).load(data.getBody().getImage()).into(ivPersonicon);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            SubmitData();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void responseMessageError(String msg) {
        showToast(msg);
    }

    @Override
    public void updateMessage() {
        switch (subtype){
            case 2:
                showToast("保存成功！");
                finish();
                break;
        }

    }

    @Override
    public void updateMessageError(String msg) {
        switch (subtype){
            case 2:
                showToast(msg);
                break;
        }

    }

    @Override
    public void responseImg(ImgBean data) {
        switch (show) {
            case 4:
                hasone = 1;
                ivAddone.setVisibility(View.GONE);
                idcardoneimg = imgone.get(0);
                Glide.with(this).load(imgone.get(0)).into(ivIdcardone);
                break;
            case 13:
                hastwo = 1;
                ivAddtwo.setVisibility(View.GONE);
                idcardtwoimg = imgtwo.get(0);
                Glide.with(this).load(imgtwo.get(0)).into(ivIdcardtwo);
                break;
            case 17:
                hasthree = 1;
                ivAddthree.setVisibility(View.GONE);
                idcardthreeimg = imgtwo.get(0);
                Glide.with(this).load(imgthree.get(0)).into(ivPersonicon);
                break;
        }
    }

    @Override
    public void responseImgError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    ArrayList<String> imgone = new ArrayList<>();
    ArrayList<String> imgtwo = new ArrayList<>();
    ArrayList<String> imgthree = new ArrayList<>();
    int show;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                imgone = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgone.add(localMedias.get(i).getCutPath());
                    }
                    show = 4;
                    mPresenter.upLoadImg(App.cardNo, "4", imgone);
                }
                break;
            case 667:
                imgtwo = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgtwo.add(localMedias.get(i).getCutPath());
                    }
                    mPresenter.upLoadImg(App.cardNo, "13", imgtwo);
                    show = 13;
                }
                break;
            case 668:
                imgthree = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgthree.add(localMedias.get(i).getCutPath());
                    }
                    mPresenter.upLoadImg(App.cardNo, "17", imgthree);
                    show = 17;
                }
                break;
        }
    }

    /**
     * 提交当前的数据到服务器
     */
    int subtype;
    private void SubmitData() {
        String name = etName.getText().toString();
        String idcard = etIdcard.getText().toString();
        String address = etOldaddress.getText().toString();
        String nowaddress = etNowaddress.getText().toString();
        String birth = birthup;
        String edu = tvEdu.getText().toString();
        String marrary = tvMarrary.getText().toString();
        if ((!StringUtils.isEmpty(name) && !name.equals("请输入")) && (!StringUtils.isEmpty(idcard) && !idcard.equals("请输入")) &&(!StringUtils.isEmpty(address) && !address.equals("请输入"))) {
            subtype=6;
            mPresenter.upDataMessage(App.cardNo, "6", idcard, name, null, address, null, null, null);
        }
        if (!StringUtils.isEmpty(nowaddress)&&!nowaddress.equals("请输入")) {
            subtype=7;
            mPresenter.upDataMessage(App.cardNo, "7",null,null,null,null,nowaddress,null,null);
        }
        if (!StringUtils.isEmpty(birth)) {
            subtype=8;
            mPresenter.upDataMessage(App.cardNo, "8",null,null,birth,null,null,null,null);
        }
        if (!StringUtils.isEmpty(edu)) {
            subtype=9;
            mPresenter.upDataMessage(App.cardNo, "9",null,null,null,null,null,null,edu);
        }
        if (!StringUtils.isEmpty(marrary)&&!marrary.equals("请输入")) {
            subtype=10;
            mPresenter.upDataMessage(App.cardNo, "10",null,null,null,null,null,marrary,null);
        }
        finish();
    }

}