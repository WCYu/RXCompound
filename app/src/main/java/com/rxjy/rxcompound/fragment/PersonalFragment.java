package com.rxjy.rxcompound.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.Advicectivity;
import com.rxjy.rxcompound.activity.MsgActivity;
import com.rxjy.rxcompound.activity.SettingActivity;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.ACache;
import com.rxjy.rxcompound.commons.utils.GlideCircleTransform;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by hjh on 2018/1/19.
 */

public class PersonalFragment extends BaseFragment<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_account)
    TextView tvAccount;
    @Bind(R.id.tv_levelnum)
    TextView tvLevelnum;
    @Bind(R.id.tv_resultnum)
    TextView tvResultnum;
    @Bind(R.id.tv_integralnum)
    TextView tvIntegralnum;
    @Bind(R.id.tv_teamnum)
    TextView tvTeamnum;
    @Bind(R.id.gv_minegv)
    GridView gvMinegv;
    ACache aCache;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_personal;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    String cardno;
    @Override
    protected void FragmentInitData() {
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        aCache = ACache.get(getActivity());
//        String persondata=aCache.getAsJSONObject("rx_persondata");
        String persondata = aCache.getAsString("rx_persondata");
        String cardno = sp.getString("rxdy_cardno", null);
        if (!StringUtils.isEmpty(persondata)) {
            PersonBean info = JSONUtils.toObject(persondata, PersonBean.class);
            tvName.setText(info.getBody().getName());
//            tv_pjob.setText(info.getBody().getDepartName());
            tvAccount.setText("账号：" + info.getBody().getCardNo());
            RequestOptions options = new RequestOptions();
            options.centerCrop().transform(new GlideCircleTransform(getActivity()));
            Glide.with(getActivity()).load(info.getBody().getImage()).apply(options).into(ivIcon);
        } else {
            mPresenter.getMessage(cardno, "1");
        }
        ShowItem();
    }


    /**
     * 展示
     *
     * @return
     */
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> data_list;
    private String[] cultureNames = new String[]{"钱包", "团队管理", "消息", "奖罚记录", "设置", "投诉与建议"};
    private int[] cultureIcon = new int[]{R.drawable.ic_mine_wallet, R.drawable.ic_mine_team, R.drawable.ic_mine_message, R.drawable.ic_mine_award, R.drawable.ic_mine_set, R.drawable.ic_mine_advise};

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < cultureIcon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", cultureIcon[i]);
            map.put("text", cultureNames[i]);
            data_list.add(map);
        }
        return data_list;
    }

    private void ShowItem() {
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        simpleAdapter = new SimpleAdapter(getActivity(), data_list, R.layout.item_moreitem, from, to);
        gvMinegv.setAdapter(simpleAdapter);
        gvMinegv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 2:
                        startActivity(new Intent(getActivity(), MsgActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), SettingActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), Advicectivity.class));
                        break;
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }

    @Override
    public void responsegetMessage(String s, PersonBean data) {
        aCache.put("rx_persondata", s);
        tvName.setText(data.getBody().getName());
        tvAccount.setText("账号：" + data.getBody().getCardNo());
        Glide.with(getActivity()).load(data.getBody().getImage()).into(ivIcon);
    }

    @Override
    public void responsegetMessageError(String msg) {

    }

    @Override
    public void responseUpdateMessage(PersonBean data) {

    }

    @Override
    public void responseUpdateMessageError(String msg) {

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
        aCache.put("rx_persondata", "");
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(getActivity()));
        Glide.with(this).load(imgone.get(0)).apply(options).into(ivIcon);
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

    }

    @Override
    public void hideDialog() {

    }

    @OnClick(R.id.iv_icon)
    public void onViewClicked() {
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

    ArrayList<String> imgone = new ArrayList<>();
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 666:
                imgone = new ArrayList<>();
                if(resultCode==RESULT_OK){
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < localMedias.size(); i++) {
                        imgone.add(localMedias.get(i).getCutPath());
                    }
                    //上传。。。。
                    mPresenter.upLoadIcon(cardno, imgone.get(0));
                }
                break;
        }
    }

}