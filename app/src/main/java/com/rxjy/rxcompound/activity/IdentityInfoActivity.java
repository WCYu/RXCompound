package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.MsgNumBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/17.
 */

public class IdentityInfoActivity extends BaseActivity<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.et_name)
    EditText et_name;
    @Bind(R.id.et_idcard)
    EditText et_idcard;
    @Bind(R.id.et_oldaddress)
    EditText et_oldaddress;
    @Bind(R.id.et_nowaddress)
    EditText et_nowaddress;
    @Bind(R.id.tv_birth)
    TextView tv_birth;
    @Bind(R.id.iv_idcardone)
    ImageView iv_idcardone;
    @Bind(R.id.iv_idcardtwo)
    ImageView iv_idcardtwo;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.rl_idcardone)
    RelativeLayout rlIdcardone;
    @Bind(R.id.rl_idcardtwo)
    RelativeLayout rlIdcardtwo;
    @Bind(R.id.rl_birth)
    RelativeLayout rlBirth;
    @Bind(R.id.tv_save)
    TextView tvSave;

    int hasone, hastwo, hasthree;//第一张第二张图片是否有

    public static IdentityInfoActivity instance = null;
    public int change;
    @Bind(R.id.iv_addone)
    ImageView ivAddone;
    @Bind(R.id.iv_addtwo)
    ImageView ivAddtwo;
    @Bind(R.id.iv_personicon)
    ImageView ivPersonicon;
    @Bind(R.id.iv_addthree)
    ImageView ivAddthree;
    @Bind(R.id.rl_idcardthree)
    RelativeLayout rlIdcardthree;
    @Bind(R.id.tv_marrary)
    TextView tvMarrary;
    @Bind(R.id.rl_ismarry)
    RelativeLayout rlIsmarry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_identityinfor;
    }

    String phonenum, cardno;
    String status;

    @Override
    public void initData() {
        instance = this;
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        mPresenter.getMessage(cardno, "2");
        tv_title.setText("身份信息");
        Intent intent = getIntent();
        status = intent.getStringExtra("status");
        ismarrrylist = new ArrayList<>();
        ismarrrylist.add("已婚");
        ismarrrylist.add("未婚");
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (change == 1) {
            change = 0;
            mPresenter.getMessage(cardno, "2");
        }
    }

    int idcardone, idcardtwo, idcardthree;
    String idcardoneimg, idcardtwoimg, idcardthreeimg;

    @Override
    public void responsegetMessage(String s, PersonBean data) {
        if (data.getBody().getIsFinsh() == 1) {//只能查看
            rlIdcardone.setEnabled(false);
            rlIdcardtwo.setEnabled(false);
            rlIdcardthree.setEnabled(false);
            et_name.setEnabled(false);
            et_idcard.setEnabled(false);
            et_oldaddress.setEnabled(false);
            et_nowaddress.setEnabled(false);
            rlBirth.setEnabled(false);
            rlIsmarry.setEnabled(false);
            tvSave.setVisibility(View.GONE);
        }

        if (!StringUtils.isEmpty(data.getBody().getIdCardName())) {
            et_name.setText(data.getBody().getIdCardName());
        }
        if (!StringUtils.isEmpty(data.getBody().getIdCard())) {
            et_idcard.setText(data.getBody().getIdCard());
        }
        if (!StringUtils.isEmpty(data.getBody().getIdCardAddress())) {
            et_oldaddress.setText(data.getBody().getIdCardAddress());
        }
        if (!StringUtils.isEmpty(data.getBody().getNowAddress())) {
            et_nowaddress.setText(data.getBody().getNowAddress());
        }
        if (!StringUtils.isEmpty(data.getBody().getMarriage())) {
            tvMarrary.setText(data.getBody().getMarriage());
        }
        if (!StringUtils.isEmpty(data.getBody().getBirthday())) {
            String birth = data.getBody().getBirthday();
            if (birth.length() >= 11) {
                birth = data.getBody().getBirthday().substring(0, 10);
                birthup = birth.replaceAll("-", "/");
            }
            tv_birth.setText(birth);
        }
        if (!StringUtils.isEmpty(data.getBody().getIdCardImageHeads())) {
            idcardone = 1;
            hasone = 1;
            idcardoneimg = data.getBody().getIdCardImageHeads();
            ivAddone.setVisibility(View.GONE);
            Glide.with(this).load(data.getBody().getIdCardImageHeads()).into(iv_idcardone);
        }
        if (!StringUtils.isEmpty(data.getBody().getIdCardImageTails())) {
            idcardtwo = 1;
            hastwo = 1;
            idcardtwoimg = data.getBody().getIdCardImageTails();
            ivAddtwo.setVisibility(View.GONE);
            Glide.with(this).load(data.getBody().getIdCardImageTails()).into(iv_idcardtwo);
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
    public void responsegetMessageError(String msg) {

    }

    @Override
    public void responseUpdateMessage(PersonBean data) {
        ShowUtils.Toastshort(this, "修改成功!");
        finish();
    }

    @Override
    public void responseUpdateMessageError(String msg) {
        ShowUtils.Toastshort(this, msg);
    }

    @Override
    public void responseUpdateMessagebank(PersonBean data) {

    }

    @Override
    public void responseUpdateMessagebankError(String msg) {

    }

    @Override
    public void responseBankList(BankBean data) {

    }

    @Override
    public void responseBankListError(String msg) {
        ShowUtils.Toastshort(this, msg);
    }

    @Override
    public void responseImg(ImgBean data) {
        switch (show) {
            case 4:
                hasone = 1;
                ivAddone.setVisibility(View.GONE);
                Glide.with(this).load(imgone.get(0)).into(iv_idcardone);
                break;
            case 13:
                hastwo = 1;
                ivAddtwo.setVisibility(View.GONE);
                Glide.with(this).load(imgtwo.get(0)).into(iv_idcardtwo);
                break;
            case 17:
                hasthree = 1;
                ivAddthree.setVisibility(View.GONE);
                Glide.with(this).load(imgthree.get(0)).into(ivPersonicon);
                MainFragment.aboutsends.iconischange = "1";
                BaseInformationActivity.aboutsend.iconischange = "1";
                break;
        }
    }

    @Override
    public void responseImgError(String msg) {
        ShowUtils.Toastshort(this, msg);
    }

    @Override
    public void responseIcon(IconBean data) {

    }

    @Override
    public void responseIconError(String msg) {

    }

    @Override
    public void responseUserStatus(UserStatusBean data) {

    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void responseMsgStatus(MsgNumBean data) {

    }

    @Override
    public void responseMsgError(String msg) {

    }

    @Override
    public void responseDesMessage(DesBaseInfoBean data) {

    }

    @Override
    public void responseDesMessageError(String msg) {

    }

    @Override
    public void responseIsConsent(ResultBean data) {

    }

    @Override
    public void responseIsConsentError(String msg) {

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
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }


    String birthup;
    private OptionsPickerView pickerView;
    List<String> ismarrrylist;

    @OnClick({R.id.rl_idcardone, R.id.rl_idcardtwo, R.id.iv_back, R.id.rl_birth, R.id.tv_save, R.id.rl_idcardthree, R.id.rl_ismarry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_idcardone:
                if (idcardone == 1) {//跳转
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
                if (idcardtwo == 1) {//跳转
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

//                    Album.album(this)
//                            .requestCode(667)
//                            .toolBarColor(Color.BLACK)
//                            .statusBarColor(Color.BLACK)
//                            .navigationBarColor(Color.BLACK)
//                            .title("选择图片")
//                            .selectCount(1)
//                            .columnCount(2)
//                            .camera(true)
//                            .start();
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_birth:
                TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String birth = getDateToString(date, "yyyy年MM月dd日");
                        birthup = getDateToString(date, "yyyy/MM/dd");
                        tv_birth.setText(birth);

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
            case R.id.tv_save:
                String name = et_name.getText().toString();
                String idcard = et_idcard.getText().toString();
                String address = et_oldaddress.getText().toString();
                String nowaddress = et_nowaddress.getText().toString();
                String marrary = tvMarrary.getText().toString();
                String birth = birthup;
                if (hasone == 1 && hastwo == 1 && hasthree == 1) {
                    mPresenter.getUpdateMessages(cardno, "2", name, idcard, address, nowaddress, birth,marrary);
                } else {
                    ShowUtils.Toastshort(this, "请先上传图片！");
                }

                break;
            case R.id.rl_idcardthree:
                if (idcardthree == 1) {//跳转
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
            case R.id.rl_ismarry:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvMarrary.setText(ismarrrylist.get(options1));

                    }
                }).build();
                pickerView.setPicker(ismarrrylist);
                pickerView.show();
                break;
        }
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
                    mPresenter.upLoadImg(cardno, "4", imgone);
                }
//                if (resultCode == RESULT_OK) {
//                    imgone = Album.parseResult(data);
//                    show = 4;
//                    mPresenter.upLoadImg(cardno, "4", imgone);
//                }
                break;
            case 667:
                imgtwo = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgtwo.add(localMedias.get(i).getCutPath());
                    }
//                    imgtwo = Album.parseResult(data);
                    mPresenter.upLoadImg(cardno, "13", imgtwo);
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
//                    imgtwo = Album.parseResult(data);
                    mPresenter.upLoadImg(cardno, "17", imgthree);
                    show = 17;
                }
                break;
        }
    }


    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

}