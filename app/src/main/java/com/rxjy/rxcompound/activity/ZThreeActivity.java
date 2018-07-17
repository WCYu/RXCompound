package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ZthreeBean;
import com.rxjy.rxcompound.mvp.contract.ZThreeContract;
import com.rxjy.rxcompound.mvp.presenter.ZThreePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/5/10.
 */

public class ZThreeActivity extends BaseActivity<ZThreePresenter> implements ZThreeContract.View {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_bankone)
    ImageView ivBankone;
    @Bind(R.id.iv_addone)
    ImageView ivAddone;
    @Bind(R.id.rl_bankone)
    RelativeLayout rlBankone;
    @Bind(R.id.tv_bank)
    TextView tvBank;
    @Bind(R.id.rl_banktype)
    RelativeLayout rlBanktype;
    @Bind(R.id.et_bankname)
    EditText etBankname;
    @Bind(R.id.et_banknum)
    EditText etBanknum;
    @Bind(R.id.et_person)
    EditText etPerson;
    @Bind(R.id.et_relation)
    EditText etRelation;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.iv_photo)
    ImageView ivPhoto;
    @Bind(R.id.iv_addfour)
    ImageView ivAddfour;
    @Bind(R.id.rl_photo)
    RelativeLayout rlPhoto;
    @Bind(R.id.iv_degree)
    ImageView ivDegree;
    @Bind(R.id.iv_addtwo)
    ImageView ivAddtwo;
    @Bind(R.id.rl_degree)
    RelativeLayout rlDegree;
    @Bind(R.id.iv_bodycheck)
    ImageView ivBodycheck;
    @Bind(R.id.iv_addfive)
    ImageView ivAddfive;
    @Bind(R.id.rl_bodycheck)
    RelativeLayout rlBodycheck;
    @Bind(R.id.iv_leaveoffice)
    ImageView ivLeaveoffice;
    @Bind(R.id.iv_addthree)
    ImageView ivAddthree;
    @Bind(R.id.rl_leaveoffice)
    RelativeLayout rlLeaveoffice;
    @Bind(R.id.tv_save)
    TextView tvSave;
    private int id;

    @Override
    public int getLayout() {
        return R.layout.activity_zthree;
    }

    public static ZThreeActivity instance = null;
    public int change;
    String status = null;

    @Override
    public void initData() {
        showLoading();
        instance = this;
        tvTitle.setText("入职资料");
        mPresenter.getMessage(App.cardNo, "3");
        mPresenter.getBankList();
        setProgressDialog(4000);
    }

    int txtnochange = 0;

    @Override
    protected void onResume() {
        super.onResume();
        if (change == 1) {
            change = 0;
            txtnochange = 1;
            mPresenter.getMessage(App.cardNo, "3");
        }
    }

    @Override
    protected ZThreePresenter onCreatePresenter() {
        return new ZThreePresenter(this);
    }

    int picone, pictwo, picthree, picfour, picfive, picsix;
    String img1, img2, img3, img4, img5, img6;

    @Override
    public void responseMessage(ZthreeBean data) {

        status = data.getBody().getIsFinsh() + "";
        if (data.getBody().getIsFinsh() == 1) {
            tvSave.setVisibility(View.GONE);
        }

        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getBankImageState().equals("1") || data.getBody().getBankImageState().equals("4")) {
                rlBankone.setEnabled(false);
                picone = 1;
            } else {
                rlBankone.setEnabled(true);
                picone = 0;
            }
        } catch (Exception e) {
            rlBankone.setEnabled(true);
            picone = 0;
        }
        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getPassportPhotoState().equals("1") || data.getBody().getPassportPhotoState().equals("4")) {
//                rlPhoto.setEnabled(false);
                picfour = 1;
            } else {
//                rlPhoto.setEnabled(true);
                picfour = 0;
            }
        } catch (Exception e) {
//            rlPhoto.setEnabled(true);
            picfour = 0;
        }
        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getDegreeCertificateState().equals("1") || data.getBody().getDegreeCertificateState().equals("4")) {
//                rlDegree.setEnabled(false);
                pictwo = 1;
            } else {
//                rlDegree.setEnabled(true);
                pictwo = 0;
            }
        } catch (Exception e) {
            rlDegree.setEnabled(true);
            pictwo = 0;
        }
        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getHealthCertificateState().equals("1") || data.getBody().getHealthCertificateState().equals("4")) {
//                rlBodycheck.setEnabled(false);
                picfive = 1;
            } else {
//                rlBodycheck.setEnabled(true);
                picfive = 0;
            }
        } catch (Exception e) {
//            rlBodycheck.setEnabled(true);
            picfive = 0;
        }
        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getResignationCertificateState().equals("1") || data.getBody().getResignationCertificateState().equals("4")) {
//                rlLeaveoffice.setEnabled(false);
                picthree = 1;
            } else {
//                rlLeaveoffice.setEnabled(true);
                picthree = 0;
            }
        } catch (Exception e) {
//            rlLeaveoffice.setEnabled(true);
            picthree = 0;
        }
        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getYinHangDataState().equals("1") || data.getBody().getYinHangDataState().equals("4")) {
                rlBanktype.setEnabled(false);
                etBankname.setEnabled(false);
                etBanknum.setEnabled(false);
            } else {
                rlBanktype.setEnabled(true);
                etBankname.setEnabled(true);
                etBanknum.setEnabled(true);
            }
        } catch (Exception e) {
            rlBanktype.setEnabled(true);
            etBankname.setEnabled(true);
            etBanknum.setEnabled(true);
        }
        try {
            if (data.getBody().getIsFinsh() == 1 || data.getBody().getJinJiLianXiDataState().equals("1") || data.getBody().getJinJiLianXiDataState().equals("4")) {
                etPerson.setEnabled(false);
                etRelation.setEnabled(false);
                etPhone.setEnabled(false);
            } else {
                etPerson.setEnabled(true);
                etRelation.setEnabled(true);
                etPhone.setEnabled(true);
            }
        } catch (Exception e) {
            etPerson.setEnabled(true);
            etRelation.setEnabled(true);
            etPhone.setEnabled(true);
        }

        //设置内容
        if (txtnochange == 0) {
            if (!StringUtils.isEmpty(data.getBody().getBankName())) {
                tvBank.setText(data.getBody().getBankName());
            }
            if (!StringUtils.isEmpty(data.getBody().getBankCard())) {
                etBanknum.setText(data.getBody().getBankCard());
            }
            if (!StringUtils.isEmpty(data.getBody().getBankUserName())) {
                etBankname.setText(data.getBody().getBankUserName());
            }
            if (!StringUtils.isEmpty(data.getBody().getUrgentPerson())) {
                etPerson.setText(data.getBody().getUrgentPerson());
            }
            if (!StringUtils.isEmpty(data.getBody().getUrgentContact())) {
                etRelation.setText(data.getBody().getUrgentContact());
            }
            if (!StringUtils.isEmpty(data.getBody().getUrgentPhone())) {
                etPhone.setText(data.getBody().getUrgentPhone());
            }
        }


        if (!StringUtils.isEmpty(data.getBody().getBankImage())) {
            Glide.with(this).load(data.getBody().getBankImage()).into(ivBankone);
//            picone = 1;
            ivAddone.setVisibility(View.GONE);
            img1 = data.getBody().getBankImage();
        }
        if (!StringUtils.isEmpty(data.getBody().getPassportPhoto())) {
            Glide.with(this).load(data.getBody().getPassportPhoto()).into(ivPhoto);
//            picfour = 1;
            ivAddfour.setVisibility(View.GONE);
            img4 = data.getBody().getPassportPhoto();
        }
        if (!StringUtils.isEmpty(data.getBody().getDegreeCertificate())) {
            Glide.with(this).load(data.getBody().getDegreeCertificate()).into(ivDegree);
//            pictwo = 1;
            ivAddtwo.setVisibility(View.GONE);
            img2 = data.getBody().getDegreeCertificate();
        }
        if (!StringUtils.isEmpty(data.getBody().getHealthCertificate())) {
            Glide.with(this).load(data.getBody().getHealthCertificate()).into(ivBodycheck);
//            picfive = 1;
            ivAddfive.setVisibility(View.GONE);
            img5 = data.getBody().getHealthCertificate();
        }
        if (!StringUtils.isEmpty(data.getBody().getResignationCertificate())) {
            Glide.with(this).load(data.getBody().getResignationCertificate()).into(ivLeaveoffice);
//            picthree = 1;
            ivAddthree.setVisibility(View.GONE);
            img3 = data.getBody().getResignationCertificate();
        }
        dismissLoading();
    }

    @Override
    public void responseMessageError(String msg) {
        showToast(msg);
    }

    @Override
    public void updateMessage() {
        //更新成功后清除掉缓存
        switch (subtype) {
            case 3:
                showToast("保存成功！");
                finish();
                break;
        }
    }

    @Override
    public void updateMessageError(String msg) {
        switch (subtype) {
            case 3:
                showToast(msg);
                break;
        }

    }

    @Override
    public void responseImg(ImgBean data) {
        switch (show) {
            case 1:
//                picone = 1;
                ivAddone.setVisibility(View.GONE);
                Glide.with(this).load(imgone.get(0)).into(ivBankone);
                break;
            case 2:
//                pictwo = 1;
                ivAddtwo.setVisibility(View.GONE);
                Glide.with(this).load(imgtwo.get(0)).into(ivDegree);
                break;
            case 3:
//                picthree = 1;
                ivAddthree.setVisibility(View.GONE);
                Glide.with(this).load(imgthree.get(0)).into(ivLeaveoffice);
                break;
            case 4:
//                picfour = 1;
                ivAddfour.setVisibility(View.GONE);
                Glide.with(this).load(imgfour.get(0)).into(ivPhoto);
                break;
            case 5:
//                picfive = 1;
                ivAddfive.setVisibility(View.GONE);
                Glide.with(this).load(imgfive.get(0)).into(ivBodycheck);
                break;
        }
    }

    @Override
    public void responseImgError(String msg) {
        showToast(msg);
    }


    List<String> banklist;
    List<Integer> branchlist;

    @Override
    public void responseBankList(BankBean data) {
        banklist = new ArrayList<>();
        branchlist = new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            banklist.add(data.getBody().get(i).getBank_name());
            branchlist.add(data.getBody().get(i).getId());
        }
    }

    @Override
    public void responseBankListError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private OptionsPickerView pickerView;

    @OnClick({R.id.iv_back, R.id.rl_bankone, R.id.rl_banktype, R.id.rl_photo, R.id.rl_degree, R.id.rl_bodycheck, R.id.rl_leaveoffice, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //缓存填写的入职资料到本地
                SubmitData();
                break;
            case R.id.rl_bankone:
                if (picone == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "银行卡正面")
                            .putExtra("type", "5")
                            .putExtra("img", img1).putExtra("status", status));
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
            case R.id.rl_banktype:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvBank.setText(banklist.get(options1));
                        id = branchlist.get(options1);
                    }
                }).build();
                pickerView.setPicker(banklist);
                pickerView.show();
                break;
            case R.id.rl_photo:
                if (picfour == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "一寸照")
                            .putExtra("type", "7")
                            .putExtra("img", img4).putExtra("status", status));
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
                }
                break;
            case R.id.rl_degree:
                if (pictwo == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "学历证明")
                            .putExtra("type", "3")
                            .putExtra("img", img2).putExtra("status", status));

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
            case R.id.rl_bodycheck:
                if (picfive == 1) {
                    startActivity(new Intent(this, ImagesShowActivity.class).putExtra("title", "体检报告")
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
                }
                break;
            case R.id.rl_leaveoffice:
                if (picthree == 1) {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("title", "离职证明")
                            .putExtra("type", "6")
                            .putExtra("img", img3).putExtra("status", status));
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
            case R.id.tv_save:
//                if (picone != 1) {
//                    showToast("请上传银行卡正面！");
//                    break;
//                }
//                if (picfour != 1) {
//                    showToast("请上传一寸照！");
//                    break;
//                }
//                if (pictwo != 1) {
//                    showToast("请上传学历证明！");
//                    break;
//                }
//                if (picfive != 1) {
//                    showToast("请上传体检报告！");
//                    break;
//                }
//                if (picthree != 1) {
//                    showToast("请上传离职证明！");
//                    break;
//                }
                String bankname = tvBank.getText().toString();
                String bankusername = etBankname.getText().toString();
                String banknum = etBanknum.getText().toString();
                String personname = etPerson.getText().toString();
                String personcotact = etRelation.getText().toString();
                String personphone = etPhone.getText().toString();
                if (StringUtils.isEmpty(bankname) || bankname.equals("请选择")) {
                    showToast("请选择开户行！");
                    return;
                }
                if (StringUtils.isEmpty(bankusername) || bankusername.equals("请输入")) {
                    showToast("请输入开户名！");
                    return;
                }
                if (StringUtils.isEmpty(banknum) || banknum.equals("请输入")) {
                    showToast("请输入银行卡号！");
                    return;
                }
                if (StringUtils.isEmpty(personname) || personname.equals("请输入")) {
                    showToast("请输入紧急联系人！");
                    return;
                }
                if (StringUtils.isEmpty(personcotact) || personcotact.equals("请输入")) {
                    showToast("请输入联系人关系！");
                    return;
                }
                if (StringUtils.isEmpty(personphone) || personphone.equals("请输入")) {
                    showToast("请输入联系人电话！");
                    return;
                }
                subtype = 3;
                mPresenter.upDataMessage(App.cardNo, "3", banknum, bankname, bankusername, personname, personphone, personcotact, id);
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //提交数据到服务器
//            。。。。。。。
            SubmitData();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    ArrayList<String> imgone = new ArrayList<>();
    ArrayList<String> imgtwo = new ArrayList<>();
    ArrayList<String> imgthree = new ArrayList<>();
    ArrayList<String> imgfour = new ArrayList<>();
    ArrayList<String> imgfive = new ArrayList<>();
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
                    show = 1;
                    mPresenter.upLoadImg(App.cardNo, "5", imgone);
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
                    show = 2;
                    mPresenter.upLoadImg(App.cardNo, "3", imgtwo);
                }
                break;
            case 668:
                imgthree = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgthree.add(localMedias.get(i).getCutPath());
                    }
                    show = 3;
                    mPresenter.upLoadImg(App.cardNo, "6", imgthree);
                }
                break;
            case 669:
                imgfour = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgfour.add(localMedias.get(i).getCutPath());
                    }
                    show = 4;
                    mPresenter.upLoadImg(App.cardNo, "7", imgfour);
                }
                break;
            case 670:
                imgfive = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgfive.add(localMedias.get(i).getCutPath());
                    }
                    show = 5;
                    mPresenter.upLoadImg(App.cardNo, "8", imgfive);
                }
                break;
        }
    }

    /**
     * 提交数据到服务器
     */
    int subtype;

    private void SubmitData() {
        String bankname = tvBank.getText().toString();
        String bankusername = etBankname.getText().toString();
        String banknum = etBanknum.getText().toString();
        String personname = etPerson.getText().toString();
        String personcotact = etRelation.getText().toString();
        String personphone = etPhone.getText().toString();
        if ((!StringUtils.isEmpty(bankname) && !bankname.equals("请选择")) && (!StringUtils.isEmpty(bankusername) && !bankusername.equals("请输入"))
                && (!StringUtils.isEmpty(banknum) && !banknum.equals("请输入"))) {
            subtype = 4;
            mPresenter.upDataMessage(App.cardNo, "4", banknum, bankname, bankusername, null, null, null, id);
        }
        if ((!StringUtils.isEmpty(personname) && !personname.equals("请输入")) && (!StringUtils.isEmpty(personcotact) && !personcotact.equals("请输入"))
                && (!StringUtils.isEmpty(personphone) && !personphone.equals("请输入"))) {
            subtype = 5;
            mPresenter.upDataMessage(App.cardNo, "5", null, null, null, personname, personphone, personcotact, id);
        }
        finish();
    }
}