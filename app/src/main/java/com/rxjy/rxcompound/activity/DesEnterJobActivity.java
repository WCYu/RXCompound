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
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.DesEnterJobContract;
import com.rxjy.rxcompound.mvp.presenter.DesEnterJobPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/20.
 */
public class DesEnterJobActivity extends BaseActivity<DesEnterJobPresenter> implements DesEnterJobContract.View {
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
    @Bind(R.id.iv_designerhelp)
    ImageView ivDesignerhelp;
    @Bind(R.id.iv_addtwo)
    ImageView ivAddtwo;
    @Bind(R.id.rl_designerhelp)
    RelativeLayout rlDesignerhelp;
    @Bind(R.id.iv_designermiddle)
    ImageView ivDesignermiddle;
    @Bind(R.id.iv_addthree)
    ImageView ivAddthree;
    @Bind(R.id.rl_designermiddle)
    RelativeLayout rlDesignermiddle;
    @Bind(R.id.iv_designerhight)
    ImageView ivDesignerhight;
    @Bind(R.id.iv_addfour)
    ImageView ivAddfour;
    @Bind(R.id.rl_designerhight)
    RelativeLayout rlDesignerhight;
    @Bind(R.id.tv_bank)
    TextView tvBank;
    @Bind(R.id.rl_banktype)
    RelativeLayout rlBanktype;
    @Bind(R.id.et_bankname)
    EditText etBankname;
    @Bind(R.id.et_banknum)
    EditText etBanknum;
    @Bind(R.id.tv_save)
    TextView tvSave;
     private int  id;

    @Override
    public int getLayout() {
        return R.layout.activity_desenterjobinfo;
    }


    public static DesEnterJobActivity instent=null;
    public String changetype="";

    DesBaseInfoBean baseinfo;
    @Override
    public void initData() {
        instent=this;
        tvTitle.setText("申请资料");
        Intent intent = getIntent();
        baseinfo = (DesBaseInfoBean) intent.getSerializableExtra("baseinfo");
        if (baseinfo.getBody().getEntry_state() == 0) {//可编辑
            edittrue();
        } else {//不可编辑
            editfalse();
        }
        show();
        mPresenter.getBankList();
    }

    @Override
    protected DesEnterJobPresenter onCreatePresenter() {
        return new DesEnterJobPresenter(this);
    }


    public String backbankimg,backdehelpimg,backdemiddleimg,backdehightimg;
    @Override
    protected void onResume() {
        super.onResume();
        switch (changetype){
            case "5":
                hasbank=1;
                bankimg=backbankimg;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setBank_image_heads(bankimg);
                Glide.with(this).load(bankimg).into(ivBankone);
                break;
            case "39":
                hasdehelp=1;
                dehelpimg=backdehelpimg;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setPrimaryCertificate(dehelpimg);
                Glide.with(this).load(dehelpimg).into(ivDesignerhelp);
                break;
            case "40":
                hasdemiddle=1;
                demiddleimg=backdemiddleimg;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setIntermediateCertificate(demiddleimg);
                Glide.with(this).load(demiddleimg).into(ivDesignermiddle);
                break;
            case "41":
                hasdehight=1;
                dehightimg=backdehightimg;
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setAdvancedCertificate(dehightimg);
                Glide.with(this).load(dehightimg).into(ivDesignerhight);
                break;
        }
    }

    /**
     * 数据展示
     */
    private void show() {
        if (!StringUtils.isEmpty(baseinfo.getBody().getBank_image_heads())) {
            hasbank=1;
            bankimg=baseinfo.getBody().getBank_image_heads();
            ivAddone.setVisibility(View.GONE);
            Glide.with(this).load(baseinfo.getBody().getBank_image_heads()).into(ivBankone);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getPrimaryCertificate())) {
            hasdehelp=1;
            dehelpimg=baseinfo.getBody().getPrimaryCertificate();
            ivAddtwo.setVisibility(View.GONE);
            Glide.with(this).load(baseinfo.getBody().getPrimaryCertificate()).into(ivDesignerhelp);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getIntermediateCertificate())) {
            hasdemiddle=1;
            demiddleimg=baseinfo.getBody().getIntermediateCertificate();
            ivAddthree.setVisibility(View.GONE);
            Glide.with(this).load(baseinfo.getBody().getIntermediateCertificate()).into(ivDesignermiddle);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getAdvancedCertificate())) {
            hasdehight=1;
            dehightimg=baseinfo.getBody().getAdvancedCertificate();
            ivAddfour.setVisibility(View.GONE);
            Glide.with(this).load(baseinfo.getBody().getAdvancedCertificate()).into(ivDesignerhight);
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getBank_name())) {
            tvBank.setText(baseinfo.getBody().getBank_name());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getBank_user_name())) {
            etBankname.setText(baseinfo.getBody().getBank_user_name());
        }
        if (!StringUtils.isEmpty(baseinfo.getBody().getBank_card())) {
            etBanknum.setText(baseinfo.getBody().getBank_card());
        }
    }

    /**
     * 不可编辑
     */
    private void editfalse() {
        ivAddone.setVisibility(View.GONE);
        ivAddthree.setVisibility(View.GONE);
        ivAddtwo.setVisibility(View.GONE);
        ivAddfour.setVisibility(View.GONE);
        tvSave.setVisibility(View.GONE);
        rlBanktype.setEnabled(false);
        etBankname.setEnabled(false);
        etBanknum.setEnabled(false);
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

    private int hasbank,hasdehelp,hasdemiddle,hasdehight;
    private String bankimg,dehelpimg,demiddleimg,dehightimg;
    private OptionsPickerView pickerView;
    @OnClick({R.id.iv_back, R.id.rl_bankone, R.id.rl_designerhelp, R.id.rl_designermiddle, R.id.rl_designerhight, R.id.rl_banktype, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_bankone:
                if(hasbank==0){
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
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "银行卡正面")
                            .putExtra("type", "5")
                            .putExtra("img", bankimg));
                }
                break;
            case R.id.rl_designerhelp:
                if(hasdehelp==0){
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
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "助理设计师-选填")
                            .putExtra("type", "39")
                            .putExtra("img", dehelpimg));
                }
                break;
            case R.id.rl_designermiddle:
                if(hasdemiddle==0){
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
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "中级设计师-选填")
                            .putExtra("type", "40")
                            .putExtra("img", demiddleimg));
                }
                break;
            case R.id.rl_designerhight:
                if(hasdehight==0){
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .enableCrop(true)// 是否裁剪 true or false
                            .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                            .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                            .forResult(669);//结果回调onActivityResult code 
                }else{
                    startActivity(new Intent(this, ImageShowDesActivity.class).putExtra("title", "高级设计师-选填")
                            .putExtra("type", "41")
                            .putExtra("img", dehightimg));
                }
                break;
            case R.id.rl_banktype:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvBank.setText(banklist.get(options1));
                        id=branchlist.get(options1);

                    }
                }).build();
                pickerView.setPicker(banklist);
                pickerView.show();
                break;
            case R.id.tv_save:
                if(hasbank==0){
                    showToast("请上传银行卡正面！");
                    return;
                }
                String bank=tvBank.getText().toString();
                String username=etBankname.getText().toString();
                String banknum=etBanknum.getText().toString();
                if(StringUtils.isEmpty(bank)||bank.equals("请选择")){
                    showToast("请选择开户行！");
                    return;
                }
                if(StringUtils.isEmpty(username)||username.equals("请输入")){
                    showToast("请输入开户人姓名！");
                    return;
                }
                if(StringUtils.isEmpty(banknum)||banknum.equals("请输入")){
                    showToast("请输入银行卡号！");
                    return;
                }
                mPresenter.updateDesJobMessage(App.cardNo,"2",bank,banknum,username,id);
                break;
        }
    }

    @Override
    public void responseDesJobMessage(ResultBean data) {
        showToast("保存成功！");
        DesBaseInfoActivity.instent.dataischange=1;
        finish();
    }

    @Override
    public void responseDesJobMessageError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseDesIdenImgMessage(ImageDesBean data) {
        switch (show) {
            case 5:
                hasbank = 1;
                ivAddone.setVisibility(View.GONE);
                bankimg=data.getBody().getUrl();
                Glide.with(this).load(imgone.get(0)).into(ivBankone);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setBank_image_heads(bankimg);
                break;
            case 39:
                hasdehelp = 1;
                ivAddtwo.setVisibility(View.GONE);
                dehelpimg=data.getBody().getUrl();
                Glide.with(this).load(imgtwo.get(0)).into(ivDesignerhelp);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setPrimaryCertificate(dehelpimg);
                break;
            case 40:
                hasdemiddle = 1;
                ivAddthree.setVisibility(View.GONE);
                demiddleimg=data.getBody().getUrl();
                Glide.with(this).load(imgthree.get(0)).into(ivDesignermiddle);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setIntermediateCertificate(demiddleimg);
                break;
            case 41:
                hasdehight = 1;
                ivAddfour.setVisibility(View.GONE);
                dehightimg=data.getBody().getUrl();
                Glide.with(this).load(imgfour.get(0)).into(ivDesignerhight);
                DesBaseInfoActivity.instent.desbaseinfo.getBody().setAdvancedCertificate(dehightimg);
                break;
        }

    }

    @Override
    public void responseDesIdenImgMessageError(String msg) {
        showToast("上传图片失败");
    }


    List<String> banklist;
    List<Integer> branchlist;
    @Override
    public void responseBankMessage(BankBean data) {
        banklist = new ArrayList<>();
        branchlist=new ArrayList<>();
        for (int i = 0; i < data.getBody().size(); i++) {
            banklist.add(data.getBody().get(i).getBank_name());
            branchlist.add(data.getBody().get(i).getId());
        }
    }

    @Override
    public void responseBankMessageError(String msg) {
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
    ArrayList<String> imgfour = new ArrayList<>();
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
                    show = 5;
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "5", imgone);
                }
                break;
            case 667:
                imgtwo = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgtwo.add(localMedias.get(i).getCutPath());
                    }
                    show = 39;
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "39", imgtwo);

                }
                break;
            case 668:
                imgthree = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgthree.add(localMedias.get(i).getCutPath());
                    }
                    show = 40;
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "40", imgthree);

                }
                break;
            case 669:
                imgfour = new ArrayList<>();
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgfour.add(localMedias.get(i).getCutPath());
                    }
                    show = 41;
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "41", imgfour);

                }
                break;
        }
    }
}