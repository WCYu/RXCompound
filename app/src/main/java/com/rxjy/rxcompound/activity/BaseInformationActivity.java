package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ACache;
import com.rxjy.rxcompound.commons.utils.GlideCircleTransform;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 基本资料
 * Created by hjh on 2017/11/6.
 */
public class BaseInformationActivity extends BaseActivity<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.tv_join)
    TextView tv_join;
    @Bind(R.id.tv_name)
    TextView tv_name;
    @Bind(R.id.tv_trydate)
    TextView tv_trydate;
    @Bind(R.id.tv_ismarry)
    TextView tv_ismarry;
    @Bind(R.id.et_name)
    EditText et_name;
    @Bind(R.id.tv_sex)
    TextView tv_sex;
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.ic_icon)
    ImageView ic_icon;
    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.gv_tryinfor)
    GridView gv_tryinfor;
    @Bind(R.id.rl_ismarry)
    RelativeLayout rl_ismarry;
    @Bind(R.id.rl_sex)
    RelativeLayout rl_sex;

    ACache aCache;

    String phonenum, u_start, cardno;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_ztwo)
    TextView tvZtwo;
    @Bind(R.id.tv_zthree)
    TextView tvZthree;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> data_list;

    private OptionsPickerView pickerView, pickerViewsex;
    List<String> ismarrrylist;
    List<String> sexlist;
    public String iconischange = "";
    public static BaseInformationActivity aboutsend = null;//单例模式

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_baseinformation;
    }

    String status;

    int statuss;
    String ismain;

    @Override
    public void initData() {
        aboutsend = this;
        aCache = ACache.get(this);
        Intent intent = getIntent();
        String isback = intent.getStringExtra("isback");
        ismain = intent.getStringExtra("ismain");
        status = intent.getStringExtra("status");
        if (status != null) {
            statuss = Integer.parseInt(status);
        }
        et_phone.setEnabled(false);
//        if (!StringUtils.isEmpty(status)) {
//            int sta = Integer.parseInt(status);
//            if (sta > 2) {//设置不可编辑
//                et_name.setEnabled(false);
//                tv_sex.setEnabled(false);
//                rl_sex.setEnabled(false);
//                ic_icon.setEnabled(false);
//                rl_ismarry.setEnabled(false);
//                tv_join.setVisibility(View.GONE);
//            }
//        }
        if (isback != null && isback.equals("1")) {
            iv_back.setVisibility(View.VISIBLE);
        } else {
            iv_back.setVisibility(View.GONE);
        }
        if (ismain != null && ismain.equals("1")) {
            tvTitle.setText("个人资料");
        } else {
            tvTitle.setText("入职资料");
        }
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        u_start = sp.getString("rxdy_start", null);
        mPresenter.getMessage(cardno, "1");
        ismarrrylist = new ArrayList<>();
        ismarrrylist.add("已婚");
        ismarrrylist.add("未婚");
        sexlist = new ArrayList<>();
        sexlist.add("男");
        sexlist.add("女");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getUserStatus(cardno);
        //如果头像改变要重新请求数据
        if (iconischange.equals("1")) {
            iconischange = "";
            mPresenter.getMessage(cardno, "1");
        }
    }

    @Override
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }


    int hasicon;

    /**
     * 显示
     *
     * @param data
     */
    @Override
    public void responsegetMessage(String s, PersonBean data) {
        if (data.getBody().getZ2IsFinsh() == 1) {
            tvZtwo.setVisibility(View.GONE);
        } else {
            tvZtwo.setVisibility(View.VISIBLE);
        }
        if (data.getBody().getZ3IsFinsh() == 1) {
            tvZthree.setVisibility(View.GONE);
        } else {
            tvZthree.setVisibility(View.VISIBLE);
        }

        tv_name.setText(data.getBody().getName());
        tv_trydate.setText("试岗日期 " + data.getBody().getTryHillockTime());
        tv_name.setText(data.getBody().getName());
        if (!StringUtils.isEmpty(App.icon)) {
            RequestOptions options = new RequestOptions();
            options.centerCrop().transform(new GlideCircleTransform(this));
            Glide.with(this).load(App.icon).apply(options).into(ic_icon);
            hasicon = 1;
        }

//        if (!StringUtils.isEmpty(data.getBody().getPassport_photo())) {
////            Glide.with(this).load(data.getBody().getImage()).centerCrop().transform(new GlideCircleTransform(this)).into(ic_icon);
////            Glide.with(this).load(data.getBody().getImage()).into(ic_icon);
//            hasicon = 1;
//        }
        cultureNames = new String[]{data.getBody().getDepartName(), data.getBody().getPostName(), data.getBody().getCardNo()};
        showgv();
        et_name.setText(data.getBody().getName());
        et_phone.setText(data.getBody().getPhone());
        tv_sex.setText(data.getBody().getSex());
        tv_ismarry.setText(data.getBody().getMarriage());

        if (data.getBody().getIsFinsh() == 1) {
            et_name.setEnabled(false);
            tv_sex.setEnabled(false);
            rl_sex.setEnabled(false);
//            ic_icon.setEnabled(false);
            rl_ismarry.setEnabled(false);
        }
        tv_join.setVisibility(View.GONE);

    }

    @Override
    public void responsegetMessageError(String msg) {
        if (!StringUtils.isEmpty(msg)) {
            showToast(msg);
        } else {
            showToast("网络不给力！");
        }
    }

    @Override
    public void responseUpdateMessage(PersonBean data) {
        //如果是从入职需知来的，跳转到mainTabHostclass
        if (!StringUtils.isEmpty(status)) {
            aCache.put("rx_persondata", "");
            finish();
        } else {
            Intent intent = new Intent(BaseInformationActivity.this, MainTabHostActivity.class);
            startActivity(intent);
            finish();
        }
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

    }

    @Override
    public void responseImg(ImgBean data) {

    }

    @Override
    public void responseImgError(String msg) {

    }

    @Override
    public void responseIcon(IconBean data) {
        //清除数据缓存（个人信息部分显示）
        if (ismain != null && ismain.equals("1")) {
            MainFragment.aboutsends.iconischange = "1";
        } else {
            aCache.put("rx_persondata", "");
        }
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(this));
        Glide.with(this).load(imgone.get(0)).apply(options).into(ic_icon);
        App.icon = imgone.get(0);
//        Glide.with(this).load(imgone.get(0)).into(ic_icon);
        hasicon = 1;

    }

    @Override
    public void responseIconError(String msg) {
        ShowUtils.Toastshort(this, msg);

    }

    @Override
    public void responseUserStatus(UserStatusBean data) {
        statuss = data.getBody().getStage();
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

    int agreetype;//1:岗责 2：保密

    @Override
    public void responseIsConsent(ResultBean data) {//已同意
        switch (agreetype) {
            case 1:
                agreetype = 2;
                mPresenter.getIsConsent(App.cardNo, "3");//请求是否同意保密
                break;
            case 2:
                agreetype = 0;
                startActivity(new Intent(this, ZThreeActivity.class));
                break;
        }
    }

    @Override
    public void responseIsConsentError(String msg) {
        //未同意
        switch (agreetype) {
            case 1://跳转到岗责
                agreetype = 0;
                startActivity(new Intent(this, BeforeJobActivity.class));
                break;
            case 2://跳转到保密
                agreetype = 0;
                startActivity(new Intent(this, SecretSureActivity.class));
                break;

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

    @OnClick({R.id.tv_join, R.id.iv_back, R.id.rl_ismarry, R.id.ic_icon, R.id.rl_sex, R.id.rl_identity, R.id.rl_shenqing})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.tv_join:
                //提交接口
                String name = et_name.getText().toString();
                String sex = tv_sex.getText().toString();
                String marry = tv_ismarry.getText().toString();
                String phone = et_phone.getText().toString();
                if (hasicon == 1) {
                    mPresenter.getUpdateMessage(cardno, "1", name, sex, phone);
                } else {
                    showToast("请先上传头像！");
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_ismarry:
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tv_ismarry.setText(ismarrrylist.get(options1));

                    }
                }).build();
                pickerView.setPicker(ismarrrylist);
                pickerView.show();
                break;
            case R.id.ic_icon://上传头像
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                        .forResult(666);//结果回调onActivityResult code 

//                Album.album(this)
//                        .requestCode(666)
//                        .toolBarColor(Color.BLACK)
//                        .statusBarColor(Color.BLACK)
//                        .navigationBarColor(Color.BLACK)
//                        .title("选择图片")
//                        .selectCount(1)
//                        .columnCount(2)
//                        .camera(true)
//                        .start();
                break;
            case R.id.rl_sex:
                pickerViewsex = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tv_sex.setText(sexlist.get(options1));
                    }
                }).build();
                pickerViewsex.setPicker(sexlist);
                pickerViewsex.show();
                break;
            case R.id.rl_identity:
                startActivity(new Intent(this, IdentityInfoNewActivity.class));
                break;
            case R.id.rl_shenqing:
                //判断岗责和保密协议是否同意过
                agreetype = 1;
                mPresenter.getIsConsent(App.cardNo, "1");
                break;
        }
    }

    ArrayList<String> imgone = new ArrayList<>();

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
                    //上传。。。。
                    Log.e("图片：", imgone.get(0));
                    mPresenter.upLoadIcon(cardno, imgone.get(0));
                }
                break;
        }
    }


    private String[] cultureNames;
    private int[] cultureIcon = new int[]{R.drawable.ic_department, R.drawable.ic_job, R.drawable.ic_jobnumber};

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < cultureIcon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", cultureIcon[i]);
            map.put("text", cultureNames[i]);
            data_list.add(map);
        }
        return data_list;
    }

    private void showgv() {
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        simpleAdapter = new SimpleAdapter(this, data_list, R.layout.item_moreitem, from, to);
        gv_tryinfor.setAdapter(simpleAdapter);
        gv_tryinfor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BaseInformationActivity.this, cultureNames[i], Toast.LENGTH_SHORT).show();
            }
        });
    }


}
