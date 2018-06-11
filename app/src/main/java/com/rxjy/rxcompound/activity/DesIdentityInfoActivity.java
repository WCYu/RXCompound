package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.mvp.contract.DesIdentityInfoContract;
import com.rxjy.rxcompound.mvp.presenter.DesIdentityInfoPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.rxjy.rxcompound.activity.IdentityInfoActivity.getDateToString;

/**
 * Created by hjh on 2018/4/20.
 */
public class DesIdentityInfoActivity extends BaseActivity<DesIdentityInfoPresenter> implements DesIdentityInfoContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
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
    @Bind(R.id.iv_personicon)
    ImageView ivPersonicon;
    @Bind(R.id.iv_addthree)
    ImageView ivAddthree;
    @Bind(R.id.rl_idcardthree)
    RelativeLayout rlIdcardthree;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.rl_sex)
    RelativeLayout rlSex;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_email)
    EditText etEmail;
    @Bind(R.id.tv_birth)
    TextView tvBirth;
    @Bind(R.id.rl_birth)
    RelativeLayout rlBirth;
    @Bind(R.id.tv_edubg)
    TextView tvEdubg;
    @Bind(R.id.rl_edubg)
    RelativeLayout rlEdubg;
    @Bind(R.id.et_idcard)
    EditText etIdcard;
    @Bind(R.id.et_nowaddress)
    EditText etNowaddress;
    @Bind(R.id.tv_save)
    TextView tvSave;

    @Override
    public int getLayout() {
        return R.layout.activity_desidentityinfo;
    }

    DesBaseInfoBean baseinfo;
    List<String> sexlist;
    List<String> edubglist;

    public static DesIdentityInfoActivity instent=null;
    public String changetype="";

    @Override
    public void initData() {
        tvTitle.setText("身份信息");
        instent=this;
        Intent intent = getIntent();
        baseinfo = (DesBaseInfoBean) intent.getSerializableExtra("baseinfo");
        Log.e("接受到的值：",baseinfo.toString());

        sexlist = new ArrayList<>();
        sexlist.add("男");
        sexlist.add("女");

        edubglist=new ArrayList<>();
        edubglist.add("高中");
        edubglist.add("专科");
        edubglist.add("中专");
        edubglist.add("大专");
        edubglist.add("本科");
        edubglist.add("本科以上");

        if (baseinfo.getBody().getIdentity_state() == 0) {//可编辑
            edittrue();
        } else {//不可编辑
            editfalse();
        }
        show();
    }

    @Override
    protected DesIdentityInfoPresenter onCreatePresenter() {
        return new DesIdentityInfoPresenter(this);
    }

    public String backidcardone,backidcardtwo,backxingxiang;
    @Override
    protected void onResume() {
        super.onResume();
        switch (changetype){
            case "4":
                hasone=1;
                idcardoneimg=backidcardone;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setId_card_image_heads(idcardoneimg);
                Glide.with(this).load(idcardoneimg).into(ivIdcardone);
                break;
            case "13":
                hastwo=1;
                idcardtwoimg=backidcardtwo;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setId_card_image_tails(idcardtwoimg);
                Glide.with(this).load(idcardtwoimg).into(ivIdcardtwo);
                break;
            case "17":
                hasthree=1;
                xingxiangimg=backxingxiang;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setImage(xingxiangimg);
                Glide.with(this).load(xingxiangimg).into(ivPersonicon);
//                DesBaseInfoActivity.instent.iconimg=xingxiangimg;
//                DesBaseInfoActivity.instent.iconimgischange=1;
                break;
        }
    }

    /**
     * 数据展示
     */
    private void show() {

        if (!StringUtils.isEmpty(baseinfo.getBody().getId_card_image_heads())) {
            hasone=1;
            ivAddone.setVisibility(View.GONE);
            idcardoneimg=baseinfo.getBody().getId_card_image_heads();
            Glide.with(this).load(baseinfo.getBody().getId_card_image_heads()).into(ivIdcardone);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getId_card_image_tails())) {
            hastwo=1;
            ivAddtwo.setVisibility(View.GONE);
            idcardtwoimg=baseinfo.getBody().getId_card_image_tails();
            Glide.with(this).load(baseinfo.getBody().getId_card_image_tails()).into(ivIdcardtwo);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getImage())) {
            hasthree=1;
            ivAddthree.setVisibility(View.GONE);
            xingxiangimg=baseinfo.getBody().getImage();
            Glide.with(this).load(baseinfo.getBody().getImage()).into(ivPersonicon);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getName())) {
            etName.setText(baseinfo.getBody().getName());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getSex())) {
            tvSex.setText(baseinfo.getBody().getSex());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getPhone())) {
            etPhone.setText(baseinfo.getBody().getPhone());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getEmail())) {
            etEmail.setText(baseinfo.getBody().getEmail());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getStrBirthday())) {
            tvBirth.setText(baseinfo.getBody().getStrBirthday());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getEducation())) {
            tvEdubg.setText(baseinfo.getBody().getEducation());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getId_card())) {
            etIdcard.setText(baseinfo.getBody().getId_card());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getLiving_place())) {
            etNowaddress.setText(baseinfo.getBody().getLiving_place());
        }
    }

    /**
     * 不可编辑
     */
    private void editfalse() {
        ivAddone.setVisibility(View.GONE);
        ivAddthree.setVisibility(View.GONE);
        ivAddtwo.setVisibility(View.GONE);
        tvSave.setVisibility(View.GONE);
        etName.setEnabled(false);
        rlSex.setEnabled(false);
        etPhone.setEnabled(false);
        etEmail.setEnabled(false);
        rlBirth.setEnabled(false);
        rlEdubg.setEnabled(false);
        etIdcard.setEnabled(false);
        etNowaddress.setEnabled(false);
    }

    /**
     * 可编辑
     */
    private void edittrue() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private String idcardoneimg,idcardtwoimg,xingxiangimg;

    private OptionsPickerView  pickerViewsex,pickerViewedubg;
    String birthup;
    @OnClick({R.id.iv_back, R.id.rl_idcardone, R.id.rl_idcardtwo, R.id.rl_idcardthree, R.id.rl_sex, R.id.rl_birth, R.id.rl_edubg, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_idcardone:
                if(hasone==0){
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(666);//结果回调onActivityResult code 
                }else{
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "身份证正面")
                            .putExtra("type", "4")
                            .putExtra("img", idcardoneimg));
                }
                break;
            case R.id.rl_idcardtwo:
                if(hastwo==0){
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(667);//结果回调onActivityResult code 
                }else{
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "身份证反面")
                            .putExtra("type", "13")
                            .putExtra("img", idcardtwoimg));
                }
                break;
            case R.id.rl_idcardthree:
                if(hasthree==0){
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(668);//结果回调onActivityResult code 
                }else{
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "形象照")
                            .putExtra("type", "17")
                            .putExtra("img", xingxiangimg));
                }
                break;
            case R.id.rl_sex:
                pickerViewsex = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvSex.setText(sexlist.get(options1));
                    }
                }).build();
                pickerViewsex.setPicker(sexlist);
                pickerViewsex.show();
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
            case R.id.rl_edubg:
                pickerViewedubg = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvEdubg.setText(edubglist.get(options1));
                    }
                }).build();
                pickerViewedubg.setPicker(edubglist);
                pickerViewedubg.show();
                break;
            case R.id.tv_save:
                if(hasone==0){
                    showToast("请上传身份证正面！");
                    return;
                }
                if(hastwo==0){
                    showToast("请上传身份证反面！");
                    return;
                }
                if(hasthree==0){
                    showToast("请上传形象照！");
                    return;
                }
                String name = etName.getText().toString();
                String sex = tvSex.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String birth = tvBirth.getText().toString();
                String edubg = tvEdubg.getText().toString();
                String idcard = etIdcard.getText().toString();
                String nowaddress = etNowaddress.getText().toString();
                if (StringUtils.isEmpty(name) || name.equals("请输入")) {
                    showToast("请输入姓名！");
                    return;
                }
                if(StringUtils.isEmpty(sex)){
                    showToast("请选择性别！");
                    return;
                }
                if(StringUtils.isEmpty(phone)||phone.equals("请输入")){
                    showToast("请输入手机号！");
                    return;
                }
                if(StringUtils.isEmpty(email)||email.equals("请输入")){
                    showToast("请输入邮箱！");
                    return;
                }
                if(StringUtils.isEmpty(birth)){
                    showToast("请选择生日！");
                    return;
                }
                if(StringUtils.isEmpty(edubg)){
                    showToast("请选择学历！");
                    return;
                }
                if(StringUtils.isEmpty(idcard)||idcard.equals("请输入")){
                    showToast("请输入身份证号！");
                    return;
                }
                if(StringUtils.isEmpty(nowaddress)||nowaddress.equals("请输入")){
                    showToast("请输入现住址！");
                    return;
                }
                mPresenter.updateDesIdentityMessage(App.cardNo,"1",phone,name,sex,idcard,birthup,nowaddress,edubg,email);
                break;
        }
    }

    @Override
    public void responseDesIdentityMessage(ResultBean data) {
        showToast("保存成功！");
        DesBaseInfoActivity.instent.dataischange=1;
        MainFragment.aboutsends.desdatachange=1;
        finish();
    }

    @Override
    public void responseDesIdentityMessageError(String msg) {
        showToast(msg);
    }

    int hasone, hastwo, hasthree;//第一张第二、三张图片是否有
    @Override
    public void responseDesIdenImgMessage(ImageDesBean data) {
        switch (show) {
            case 4:
                hasone = 1;
                ivAddone.setVisibility(View.GONE);
                idcardoneimg=data.getBody().getUrl();
                Glide.with(this).load(imgone.get(0)).into(ivIdcardone);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setId_card_image_heads(data.getBody().getUrl());
                break;
            case 13:
                hastwo = 1;
                ivAddtwo.setVisibility(View.GONE);
                idcardtwoimg=data.getBody().getUrl();
                Glide.with(this).load(imgtwo.get(0)).into(ivIdcardtwo);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setId_card_image_tails(data.getBody().getUrl());
                break;
            case 17:
                hasthree = 1;
                ivAddthree.setVisibility(View.GONE);
                xingxiangimg=data.getBody().getUrl();
                Glide.with(this).load(imgthree.get(0)).into(ivPersonicon);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setImage(data.getBody().getUrl());
//                DesBaseInfoActivity.instent.iconimg=data.getBody().getUrl();
//                DesBaseInfoActivity.instent.iconimgischange=1;
//                MainFragment.aboutsends.desdatachange=1;
                break;
        }
    }

    @Override
    public void responseDesIdenImgMessageError(String msg) {
        showToast("上传图片失败");
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
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "4", imgone);
                }
                break;
            case 667:
                imgtwo = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgtwo.add(localMedias.get(i).getCutPath());
                    }
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "13", imgtwo);
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
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "17", imgthree);
                    show = 17;
                }
                break;
        }
    }
}