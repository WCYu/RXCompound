package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.GlideCircleTransform;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.mvp.contract.DesBaseInfoContract;
import com.rxjy.rxcompound.mvp.presenter.DesBaseInfoPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/20.
 */

public class DesBaseInfoActivity extends BaseActivity<DesBaseInfoPresenter> implements DesBaseInfoContract.View {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ic_icon)
    ImageView icIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_trydate)
    TextView tvTrydate;
    @Bind(R.id.gv_tryinfor)
    GridView gvTryinfor;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.rl_phone)
    RelativeLayout rlPhone;
    @Bind(R.id.et_email)
    TextView etEmail;
    @Bind(R.id.rl_email)
    RelativeLayout rlEmail;
    @Bind(R.id.rl_identity)
    RelativeLayout rlIdentity;
    @Bind(R.id.rl_shenqing)
    RelativeLayout rlShenqing;

    @Override
    public int getLayout() {
        return R.layout.activity_baseinformation;
    }

    public static DesBaseInfoActivity instent=null;

    @Override
    public void initData() {
        tvTitle.setText("个人资料");
        instent=this;
        rlPhone.setVisibility(View.GONE);
        rlEmail.setVisibility(View.VISIBLE);
        etName.setEnabled(false);
        etPhone.setEnabled(false);
        mPresenter.getDesMessage(App.cardNo);

    }

    @Override
    protected DesBaseInfoPresenter onCreatePresenter() {
        return new DesBaseInfoPresenter(this);
    }

    public DesBaseInfoBean desbaseinfo=new DesBaseInfoBean();

    @Override
    public void responseDesMessage(DesBaseInfoBean data) {
        desbaseinfo=data;
        DesBaseInfoBean.BodyBean datas=data.getBody();
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(this));
        Glide.with(this).load(datas.getPassport_photo()).apply(options).into(icIcon);
        tvName.setText(datas.getName());
        String dates="";
        if(!StringUtils.isEmpty(datas.getCreate_date())){
            dates=datas.getCreate_date();
            dates=dates.substring(0,10);
        }
        tvTrydate.setText("创建日期 "+dates);
        etName.setText(datas.getName());
        tvSex.setText(datas.getSex());
        etEmail.setText(datas.getEmail());
        cultureNames = new String[]{"瑞祥集团", data.getBody().getPostName(), data.getBody().getCardNo()};
        showgv();
    }

    @Override
    public void responseDesMessageError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseDesIdenImgMessage(ImageDesBean data) {
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(this));
        Glide.with(this).load(data.getBody().getUrl()).apply(options).into(icIcon);
        desbaseinfo.getBody().setPassport_photo(data.getBody().getUrl());
        MainFragment.aboutsends.desdatachange=1;
        showToast("头像修改成功！");
    }

    public  int dataischange;
    @Override
    protected void onResume() {
        super.onResume();
        if(dataischange==1){
            dataischange=0;
            mPresenter.getDesMessage(App.cardNo);
        }
    }

    @Override
    public void responseDesIdenImgMessageError(String msg) {
        showToast("头像修改失败！");
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

    @OnClick({R.id.iv_back,R.id.rl_identity, R.id.rl_shenqing,R.id.ic_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_identity:
                startActivity(new Intent(this,DesIdentityInfoActivity.class).putExtra("baseinfo",desbaseinfo));
                break;
            case R.id.rl_shenqing:
                startActivity(new Intent(this,DesEnterJobActivity.class).putExtra("baseinfo",desbaseinfo));
                break;
            case R.id.ic_icon:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                        .imageSpanCount(3)// 每行显示个数 int
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .enableCrop(true)// 是否裁剪 true or false
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                        .forResult(666);//结果回调onActivityResult code 
                break;
        }
    }



    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> data_list;
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
        gvTryinfor.setAdapter(simpleAdapter);
        gvTryinfor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DesBaseInfoActivity.this, cultureNames[i], Toast.LENGTH_SHORT).show();
            }
        });
    }



    ArrayList<String> imgone = new ArrayList<>();
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
                    mPresenter.upLoadDesIdentityImg(App.cardNo, "7", imgone);
                }
                break;
        }
    }

}
