package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
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
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/17.
 */

public class EnterJobActivity extends BaseActivity<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.iv_bankone)
    ImageView iv_bankone;
    @Bind(R.id.iv_degree)
    ImageView iv_degree;
    @Bind(R.id.iv_bodycheck)
    ImageView iv_bodycheck;
    @Bind(R.id.iv_photo)
    ImageView iv_photo;
    @Bind(R.id.iv_leaveoffice)
    ImageView iv_leaveoffice;
    @Bind(R.id.iv_majorlce)
    ImageView iv_majorlce;
    @Bind(R.id.iv_addone)
    ImageView iv_addone;
    @Bind(R.id.iv_addtwo)
    ImageView iv_addtwo;
    @Bind(R.id.iv_addthree)
    ImageView iv_addthree;
    @Bind(R.id.iv_addfour)
    ImageView iv_addfour;
    @Bind(R.id.iv_addfive)
    ImageView iv_addfive;
    @Bind(R.id.iv_addsix)
    ImageView iv_addsix;
    @Bind(R.id.tv_bank)
    TextView tv_bank;
    @Bind(R.id.et_banknum)
    EditText et_banknum;
    @Bind(R.id.et_bankname)
    EditText et_bankname;
    @Bind(R.id.et_person)
    EditText et_person;
    @Bind(R.id.et_relation)
    EditText et_relation;
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.tv_save)
    TextView tv_save;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.rl_banktype)
    RelativeLayout rlBanktype;
    @Bind(R.id.rl_bankone)
    RelativeLayout rlBankone;
    @Bind(R.id.rl_degree)
    RelativeLayout rlDegree;
    @Bind(R.id.rl_bodycheck)
    RelativeLayout rlBodycheck;
    @Bind(R.id.rl_photo)
    RelativeLayout rlPhoto;
    @Bind(R.id.rl_leaveoffice)
    RelativeLayout rlLeaveoffice;
    @Bind(R.id.rl_majorlce)
    RelativeLayout rlMajorlce;

    private OptionsPickerView pickerView;

    int picone, pictwo, picthree, picfour,picfive,picsix;

    public static EnterJobActivity instance = null;
    public int change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_enterjobinfo;
    }

    String phonenum, status, cardno;

    @Override
    public void initData() {
        instance = this;
        tvTitle.setText("入职资料");
        Intent intent = getIntent();
        status = intent.getStringExtra("status");
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        mPresenter.getMessage(cardno, "3");
        mPresenter.getBankList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (change == 1) {
            change = 0;
            mPresenter.getMessage(cardno, "3");
        }
    }

    /**
     * 获取到数据并显示
     * @param s
     * @param data
     */
    String img1, img2, img3, img4,img5,img6;
    @Override
    public void responsegetMessage(String s, PersonBean data) {

        if (data.getBody().getIsFinsh() == 1) {
            rlBankone.setEnabled(false);
            rlDegree.setEnabled(false);
            rlBodycheck.setEnabled(false);
            rlPhoto.setEnabled(false);
            rlBanktype.setEnabled(false);
            rlLeaveoffice.setEnabled(false);
            rlMajorlce.setEnabled(false);
            et_banknum.setEnabled(false);
            et_bankname.setEnabled(false);
            et_person.setEnabled(false);
            et_relation.setEnabled(false);
            et_phone.setEnabled(false);
            tv_save.setVisibility(View.GONE);
        }

        if (!StringUtils.isEmpty(data.getBody().getBankName())) {
            tv_bank.setText(data.getBody().getBankName());
        }
        if (!StringUtils.isEmpty(data.getBody().getBankCard())) {
            et_banknum.setText(data.getBody().getBankCard());
        }
        if (!StringUtils.isEmpty(data.getBody().getBankUserName())) {
            et_bankname.setText(data.getBody().getBankUserName());
        }
        if (!StringUtils.isEmpty(data.getBody().getUrgentPerson())) {
            et_person.setText(data.getBody().getUrgentPerson());
        }
        if (!StringUtils.isEmpty(data.getBody().getUrgentContact())) {
            et_relation.setText(data.getBody().getUrgentContact());
        }
        if (!StringUtils.isEmpty(data.getBody().getUrgentPhone())) {
            et_phone.setText(data.getBody().getUrgentPhone());
        }
        if (!StringUtils.isEmpty(data.getBody().getBankImage())) {
            Glide.with(this).load(data.getBody().getBankImage()).into(iv_bankone);
            picone = 1;
            iv_addone.setVisibility(View.GONE);
            img1 = data.getBody().getBankImage();
        }
        if (!StringUtils.isEmpty(data.getBody().getDegreeCertificate())) {
            Glide.with(this).load(data.getBody().getDegreeCertificate()).into(iv_degree);
            pictwo = 1;
            iv_addtwo.setVisibility(View.GONE);
            img2 = data.getBody().getDegreeCertificate();
        }
        if (!StringUtils.isEmpty(data.getBody().getResignationCertificate())) {
            Glide.with(this).load(data.getBody().getResignationCertificate()).into(iv_leaveoffice);
            picthree = 1;
            iv_addthree.setVisibility(View.GONE);
            img3 = data.getBody().getResignationCertificate();
        }
        if (!StringUtils.isEmpty(data.getBody().getPassportPhoto())) {
            Glide.with(this).load(data.getBody().getPassportPhoto()).into(iv_photo);
            picfour = 1;
            iv_addfour.setVisibility(View.GONE);
            img4 = data.getBody().getPassportPhoto();
        }

        if (!StringUtils.isEmpty(data.getBody().getHealthCertificate())) {
            Glide.with(this).load(data.getBody().getHealthCertificate()).into(iv_bodycheck);
            picfive = 1;
            iv_addfive.setVisibility(View.GONE);
            img5 = data.getBody().getHealthCertificate();
        }
        if (!StringUtils.isEmpty(data.getBody().getQualificationCertificate())) {
            Glide.with(this).load(data.getBody().getQualificationCertificate()).into(iv_majorlce);
            picsix = 1;
            iv_addsix.setVisibility(View.GONE);
            img6 = data.getBody().getQualificationCertificate();
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

    List<String> banklist;
    /**
     * 获取银行数据列表
     * @param data
     */
    @Override
    public void responseBankList(BankBean data) {
        banklist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            banklist.add(data.getBody().get(i).getBank_name());
        }
    }

    @Override
    public void responseBankListError(String msg) {

    }

    @Override
    public void responseImg(ImgBean data) {
        switch (show) {
            case 1:
                picone = 1;
                iv_addone.setVisibility(View.GONE);
                Glide.with(this).load(imgone.get(0)).into(iv_bankone);
                break;
            case 2:
                pictwo = 1;
                iv_addtwo.setVisibility(View.GONE);
                Glide.with(this).load(imgtwo.get(0)).into(iv_degree);
                break;
            case 3:
                picthree = 1;
                iv_addthree.setVisibility(View.GONE);
                Glide.with(this).load(imgthree.get(0)).into(iv_leaveoffice);
                break;
            case 4:
                picfour = 1;
                iv_addfour.setVisibility(View.GONE);
                Glide.with(this).load(imgfour.get(0)).into(iv_photo);
                break;
            case 5:
                picfive= 1;
                iv_addfive.setVisibility(View.GONE);
                Glide.with(this).load(imgfive.get(0)).into(iv_bodycheck);
                break;
            case 6:
                picsix = 1;
                iv_addsix.setVisibility(View.GONE);
                Glide.with(this).load(imgsix.get(0)).into(iv_majorlce);
                break;
        }

    }

    @Override
    public void responseImgError(String msg) {

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

    @OnClick({R.id.rl_banktype, R.id.iv_back, R.id.rl_bankone, R.id.rl_degree, R.id.rl_bodycheck, R.id.rl_photo, R.id.tv_save,
    R.id.rl_leaveoffice,R.id.rl_majorlce})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.rl_banktype:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tv_bank.setText(banklist.get(options1));
                    }
                }).build();
                pickerView.setPicker(banklist);
                pickerView.show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_bankone:
                if (picone == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "银行卡正面")
                            .putExtra("type", "5")
                            .putExtra("img", img1));
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
            case R.id.rl_degree:
                if (pictwo == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "学历证明")
                            .putExtra("type", "3")
                            .putExtra("img", img2));

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
            case R.id.rl_leaveoffice:
                if (picthree == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "离职证明")
                            .putExtra("type", "6")
                            .putExtra("img", img3));
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

//                    Album.album(this)
//                            .requestCode(668)
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
            case R.id.rl_photo:
                if (picfour == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "证件照")
                            .putExtra("type", "7")
                            .putExtra("img", img4));

                } else {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(669);//结果回调onActivityResult code 
//                    Album.album(this)
//                            .requestCode(669)
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
            case R.id.rl_bodycheck:
                if (picfive == 1) {
                    startActivity(new Intent(this, ImagesShowActivity.class).putExtra("title", "体检证明")
                            .putExtra("type", "8"));
                } else {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(670);//结果回调onActivityResult code 
//                    Album.album(this)
//                            .requestCode(670)
//                            .toolBarColor(Color.BLACK)
//                            .statusBarColor(Color.BLACK)
//                            .navigationBarColor(Color.BLACK)
//                            .title("选择图片")
//                            .selectCount(10)
//                            .columnCount(2)
//                            .camera(true)
//                            .start();
                }
                break;
            case R.id.rl_majorlce:
                if (picsix == 1) {
                    startActivity(new Intent(this, ImagesShowActivity.class).putExtra("title", "从业资格证书")
                            .putExtra("type", "14"));
                } else {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(671);//结果回调onActivityResult code 
//                    Album.album(this)
//                            .requestCode(671)
//                            .toolBarColor(Color.BLACK)
//                            .statusBarColor(Color.BLACK)
//                            .navigationBarColor(Color.BLACK)
//                            .title("选择图片")
//                            .selectCount(10)
//                            .columnCount(2)
//                            .camera(true)
//                            .start();
                }
                break;
            case R.id.tv_save:
                String bankname = tv_bank.getText().toString();
                String banknum = et_banknum.getText().toString();
                String bankusername = et_bankname.getText().toString();
                String personname = et_person.getText().toString();
                String personcotact = et_relation.getText().toString();
                String personphone = et_phone.getText().toString();
                if (picone == 1 && pictwo == 1 && picthree == 1 && picfour == 1 &&picfive==1) {
                    mPresenter.getUpdateMessage(cardno, "3", bankname, banknum, bankusername, personname, personcotact, personphone);
                } else {
                    ShowUtils.Toastshort(this, "请先上传图片！");
                }
                break;
        }
    }


    ArrayList<String> imgone = new ArrayList<>();
    ArrayList<String> imgtwo = new ArrayList<>();
    ArrayList<String> imgthree = new ArrayList<>();
    ArrayList<String> imgfour = new ArrayList<>();
    ArrayList<String> imgfive = new ArrayList<>();
    ArrayList<String> imgsix = new ArrayList<>();
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
//                    imgone = Album.parseResult(data);
                    show = 1;
                    mPresenter.upLoadImg(cardno, "5", imgone);
                    //上传。。。。
                }
                break;
            case 667:
                imgtwo = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgtwo.add(localMedias.get(i).getCutPath());
                    }
//                    imgtwo = Album.parseResult(data);
                    show = 2;
                    mPresenter.upLoadImg(cardno, "3", imgtwo);
                }
                break;
            case 668:
                imgthree = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgthree.add(localMedias.get(i).getCutPath());
                    }
//                    imgthree = Album.parseResult(data);
                    show = 3;
                    mPresenter.upLoadImg(cardno, "6", imgthree);
                }
                break;
            case 669:
                imgfour = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgfour.add(localMedias.get(i).getCutPath());
                    }
//                    imgfour = Album.parseResult(data);
                    show = 4;
                    mPresenter.upLoadImg(cardno, "7", imgfour);
                }
                break;
            case 670:
                imgfive = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgfive.add(localMedias.get(i).getCutPath());
                    }
//                    imgfive = Album.parseResult(data);
                    show = 5;
                    mPresenter.upLoadImg(cardno, "8", imgfive);
                }
                break;
            case 671:
                imgsix = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgsix.add(localMedias.get(i).getCutPath());
                    }
//                    imgsix = Album.parseResult(data);
                    show = 6;
                    mPresenter.upLoadImg(cardno, "14", imgsix);
                }
                break;
        }
    }
}
