package com.rxjy.rxcompound.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.BaseInformationActivity;
import com.rxjy.rxcompound.activity.BecomeWorkerActivity;
import com.rxjy.rxcompound.activity.DesBaseInfoActivity;
import com.rxjy.rxcompound.activity.InformMessageActivity;
import com.rxjy.rxcompound.activity.JifenZAActivity;
import com.rxjy.rxcompound.activity.LeaveActivity;
import com.rxjy.rxcompound.activity.MoneyActivity;
import com.rxjy.rxcompound.activity.MoneyTzActivity;
import com.rxjy.rxcompound.activity.OfficeActivity;
import com.rxjy.rxcompound.activity.SettingActivity;
import com.rxjy.rxcompound.activity.WorkActivity;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.activity.my.JiFenActivity;
import com.rxjy.rxcompound.activity.my.UserInfoActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.ACache;
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
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
import com.rxjy.rxcompound.entity.my.UserInfoBean;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.presenter.BaseInformPresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 我的
 * Created by hjh on 2017/11/6.
 */
public class MainFragment extends BaseFragment<BaseInformPresenter> implements BaseInformContract.View {

    @Bind(R.id.rl_persondetails)
    RelativeLayout rl_persondetails;
    @Bind(R.id.tv_pname)
    TextView tv_pname;
    @Bind(R.id.tv_pjob)
    TextView tv_pjob;
    @Bind(R.id.tv_paccount)
    TextView tv_paccount;
    @Bind(R.id.iv_personicon)
    ImageView iv_personicon;
    @Bind(R.id.img_erweima)
    ImageView img_erweima;
    @Bind(R.id.rl_setting)
    RelativeLayout rl_setting;
    @Bind(R.id.rl_informmessage)
    RelativeLayout rl_informmessage;
    ACache aCache;
    public static MainFragment aboutsends = null;//单例模式
    public String iconischange = "";
    @Bind(R.id.rl_maintop)
    RelativeLayout rlMaintop;
    @Bind(R.id.rl_wallet)
    RelativeLayout rlWallet;
    @Bind(R.id.rl_chengjiu)
    RelativeLayout rl_chengjiu;
    @Bind(R.id.tv_messagenum)
    TextView tvMessagenum;
    @Bind(R.id.rl_jifen)
    RelativeLayout rlJifen;
    @Bind(R.id.rl_office)
    RelativeLayout rl_office;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    String cardno;
    String icon, name;//头像

    @Override
    protected void FragmentInitData() {
        switch (App.apptype) {
            case 2:
                rlMaintop.setBackgroundColor(getResources().getColor(R.color.textorange));
                break;
            case 3:
                rlMaintop.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDes));
                break;
            case 4:
                rlMaintop.setBackgroundColor(getResources().getColor(R.color.colorPrimarys));
                break;
            default:
                break;
        }
        if (App.postid == 30001) {
            rl_office.setVisibility(View.GONE);
        }
        aboutsends = this;
        //获取缓存数据，否则网络请求
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String phonenum = sp.getString("rxdy_phonenum", null);
        aCache = ACache.get(getActivity());
//        String persondata=aCache.getAsJSONObject("rx_persondata");
        String persondata = aCache.getAsString("rx_persondata");
//        cardno = sp.getString("rxdy_cardno", null);
        cardno = App.cardNo;

        mPresenter.getUserStatus(cardno);
        if (App.depart.equals("3") && App.postid == 10000) {
            mPresenter.getDesMessage(App.cardNo);
        } else {
            if (!StringUtils.isEmpty(persondata)) {
                PersonBean info = JSONUtils.toObject(persondata, PersonBean.class);
                tv_pname.setText(App.name);
                name = info.getBody().getName();
                if(!TextUtils.isEmpty(App.postName)){
                    tv_pjob.setText(info.getBody().getSex() + "   " + App.postName);
                }
                tv_paccount.setText("账号 " + App.cardNo);
                Glide.with(getActivity()).load(info.getBody().getImage()).into(iv_personicon);
//                icon=info.getBody().getImage();
            } else {
                mPresenter.getMessage(cardno, "1");
            }
        }

        if (App.is_group.equals("2")) {
            getUserInfo();
            img_erweima.setVisibility(View.VISIBLE);
            rl_chengjiu.setVisibility(View.GONE);
            rlWallet.setEnabled(false);
            rl_informmessage.setEnabled(false);
        }
    }

    public void getUserInfo() {
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        token = sp.getString("rxdy_token", null);
        Map map = new HashMap();
        map.put("cardNo", App.cardNo);
        map.put("token", token);
        Log.e("tag_用户信息_App.token", App.cardNo);
        Log.e("tag_用户信息_App.token", token);
        OkhttpUtils.doPost("https://api.dcwzg.com:9191/actionapi/AN_Home/ShowMyInfo", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_用户信息_失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_用户信息_成功", string);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            String statusMsg = jsonObject.getString("StatusMsg");
                            if (statusCode == 0) {
                                Gson gson = new Gson();
                                UserInfoBean userInfoBean = gson.fromJson(string, UserInfoBean.class);
                                UserInfoBean.BodyBean bodyBean = userInfoBean.getBody().get(0);
                                tv_pname.setText(bodyBean.getU_name());
                                if (!TextUtils.isEmpty(App.postName)) {
                                    if (App.postName.equals("投资招商")) {
                                        tv_paccount.setText(bodyBean.getPhone());
                                        tv_pjob.setVisibility(View.GONE);
                                    } else {
                                        tv_paccount.setText(bodyBean.getCard_no());
                                    }
                                } else {
                                    tv_paccount.setText(bodyBean.getCard_no());
                                }
                                if (!TextUtils.isEmpty(bodyBean.getImage())) {
                                    Glide.with(getActivity()).load(bodyBean.getImage()).apply(RequestOptions.circleCropTransform()).into(iv_personicon);
                                }
                            } else {
                                ToastUtil.getInstance().toastCentent(statusMsg, getActivity());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }

    public int desdatachange;

    @Override
    public void onResume() {
        super.onResume();
        if (App.is_group.equals("2")) {
            getUserInfo();
        } else {
            if (!TextUtils.isEmpty(App.icon)) {
                Glide.with(getActivity()).load(App.icon).into(iv_personicon);
            }
            icon = App.icon;
            if (iconischange.equals("1")) {
                iconischange = "";
                mPresenter.getMessage(cardno, "1");
            }
            mPresenter.getMsgnum(cardno);
            if (desdatachange == 1) {
                desdatachange = 0;
                mPresenter.getDesMessage(App.cardNo);
            }
        }
    }

    @Override
    protected BaseInformPresenter onCreatePresenter() {
        return new BaseInformPresenter(this);
    }

    @OnClick({R.id.rl_persondetails, R.id.rl_setting, R.id.rl_informmessage, R.id.rl_wallet, R.id.rl_jifen, R.id.rl_office})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_persondetails:

                Log.e("tag___信息", App.depart + "  " + App.postid);
                if (App.depart.equals("3") && App.postid == 10000) {//设计师会员
//                    startActivity(new Intent(getActivity(), DesBaseInfoActivity.class));
                    startActivity(new Intent(getActivity(), UserInfoActivity.class));
                } else {
                    if (!TextUtils.isEmpty(App.postName)) {
                        if (App.postName.equals("投资招商")) {
                            startActivity(new Intent(getActivity(), UserInfoActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), BaseInformationActivity.class).putExtra("isback", "1").putExtra("status", status + "").putExtra("ismain", "1"));
                        }
                    } else {
                            startActivity(new Intent(getActivity(), BaseInformationActivity.class).putExtra("isback", "1").putExtra("status", status + "").putExtra("ismain", "1"));
                    }
                }
                break;
            case R.id.rl_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.rl_informmessage:
                startActivity(new Intent(getActivity(), InformMessageActivity.class));
                break;
            case R.id.rl_wallet:

                switch (App.apptype) {
                    case 34:
                        startActivity(new Intent(getActivity(), MoneyTzActivity.class));
                        break;
                    default:
                        startActivity(new Intent(getActivity(), MoneyActivity.class));
                        break;
                }
                break;
            case R.id.rl_jifen:
                switch (App.apptype) {
                    case 3:
//                        startActivity(new Intent(getActivity(), JifenZAActivity.class).putExtra("icon",icon).putExtra("name",name));
                        startActivity(new Intent(getActivity(), JiFenActivity.class));
                        break;
                    case 2:
//                        startActivity(new Intent(getActivity(), JifenZAActivity.class).putExtra("icon",icon).putExtra("name",name));
                        startActivity(new Intent(getActivity(), JiFenActivity.class));
                        break;
                }
                break;
            case R.id.rl_office:
                switch (App.apptype) {
//                    case 34:
//                        startActivity(new Intent(getActivity(), OfficeActivity.class));
//                        break;
                    default:
                        //startActivity(new Intent(getActivity(), LeaveActivity.class));
                        startActivity(new Intent(getActivity(), WorkActivity.class));
                        break;
                }
                break;
        }
    }


    @Override
    public void responsegetMessage(String s, PersonBean data) {
        aCache.put("rx_persondata", s);
        tv_pname.setText(data.getBody().getName());
        name = data.getBody().getName();
        tv_pjob.setText(data.getBody().getSex() + "   " + data.getBody().getPostName());
        tv_paccount.setText("账号：" + data.getBody().getCardNo());
        if (!TextUtils.isEmpty(data.getBody().getImage())) {
            Glide.with(getActivity()).load(data.getBody().getImage()).into(iv_personicon);
        }
        icon = data.getBody().getImage();
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

    }

    @Override
    public void responseIconError(String msg) {

    }

    int status;

    @Override
    public void responseUserStatus(UserStatusBean data) {
        status = data.getBody().getStage();
    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void responseMsgStatus(MsgNumBean data) {
        if (data.getBody() > 0) {
            tvMessagenum.setVisibility(View.VISIBLE);
            tvMessagenum.setText(data.getBody() + "");
        } else {
            tvMessagenum.setVisibility(View.GONE);
        }
    }

    @Override
    public void responseMsgError(String msg) {

    }

    @Override
    public void responseDesMessage(DesBaseInfoBean data) {
//        Glide.with(getActivity()).load(data.getBody().getImage()).into(iv_personicon);
        tv_pname.setText(data.getBody().getName());
        String sex = data.getBody().getSex();
        String postname = data.getBody().getPostName();
        if (StringUtils.isEmpty(data.getBody().getSex())) {
            sex = "";
        }
        if (StringUtils.isEmpty(data.getBody().getPostName())) {
            postname = "";
        }
        tv_pjob.setText(sex + "   " + postname);
        tv_paccount.setText("账号：" + data.getBody().getCardNo());
        icon = data.getBody().getImage();

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.rl_jifen)
    public void onViewClicked() {
    }
}