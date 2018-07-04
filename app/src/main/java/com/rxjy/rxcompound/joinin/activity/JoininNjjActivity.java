package com.rxjy.rxcompound.joinin.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.commons.utils.CheckPermissionsUitl;
import com.rxjy.rxcompound.des.entity.HomeBean;
import com.rxjy.rxcompound.des.entity.IconInfo;
import com.rxjy.rxcompound.des.entity.OrTriaHomeBean;
import com.rxjy.rxcompound.des.mvp.contract.OnTriaHomeContract;
import com.rxjy.rxcompound.des.mvp.presenter.HomeFindPresenter;
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
import com.rxjy.rxcompound.fragment.FindFrqagment;
import com.rxjy.rxcompound.fragment.HomePageFragment;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.joinin.entity.HuanYingBean;
import com.rxjy.rxcompound.joinin.fragment.JoininHomeFragment;
import com.rxjy.rxcompound.joinin.fragment.JoininMoreFragment;
import com.rxjy.rxcompound.joinin.fragment.OnTrialFragment;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.rxjy.rxcompound.R.style.ActionSheetDialogStyle;

/**
 * Created by asus on 2018/5/21.
 */

public class JoininNjjActivity extends BaseActivity<HomeFindPresenter> implements OnTriaHomeContract.View {

    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.iv_tab_home)
    ImageView ivTabHome;
    @Bind(R.id.tv_tab_home)
    TextView tvTabHome;
    @Bind(R.id.rl_tab_home)
    RelativeLayout rlTabHome;
    @Bind(R.id.iv_tab_wallet)
    ImageView ivTabWallet;
    @Bind(R.id.tv_tab_wallet)
    TextView tvTabWallet;
    @Bind(R.id.rl_tab_wallet)
    RelativeLayout rlTabWallet;
    @Bind(R.id.iv_tab_find)
    ImageView ivTabFind;
    @Bind(R.id.tv_tab_find)
    TextView tvTabFind;
    @Bind(R.id.rl_tab_find)
    RelativeLayout rlTabFind;
    @Bind(R.id.iv_tab_mine)
    ImageView ivTabMine;
    @Bind(R.id.img_reddot)
    public ImageView img_reddot;

    @Bind(R.id.tv_tab_mine)
    TextView tvTabMine;
    @Bind(R.id.ll_view)

    LinearLayout llView;
    @Bind(R.id.rl_tab_mine)
    RelativeLayout rlTabMine;
    @Bind(R.id.tv_msgnum)
    TextView tvMsgnum;
    private Fragment currentFragment;
    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int WALLET_FRAGMENT = 1;
    private final int FIND_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;
    //Tab图标的集合
    private List<IconInfo> iconList;
    //碎片的集合
    private List<Fragment> fragmentList;
    private OnTrialFragment homeFragment;
    private JoininMoreFragment walletFragment;
    private FindFrqagment findFragment;
    private MainFragment mineFragment;
    private AlertDialog alertDialog;
    private int[] iconNormal = new int[]{
            R.mipmap.ic_tab_hostpage,
            R.mipmap.ic_tab_more,
            R.mipmap.ic_tab_find,
            R.mipmap.ic_tab_main
    };
    private int[] iconPressed = new int[]{
            R.mipmap.ic_homenblue,
            R.mipmap.ic_morenblue,
            R.mipmap.ic_findnblue,
            R.mipmap.ic_minenblue
    };

    int type = 0;

    public static JoininNjjActivity activity;
    //检测权限列表
    private String[] requestPermissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE
    };
    private TextView text;
    private TextView msgtwo;

    @Override
    public int getLayout() {
        return R.layout.activity_njj;
    }

    @Override
    public void initData() {
        isShow();
        initIcon();
        initFragment();
        //加载默认显示碎片
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
    }


    @Override
    protected HomeFindPresenter onCreatePresenter() {
        return new HomeFindPresenter(this);
    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(ivTabHome, tvTabHome));
        iconList.add(new IconInfo(ivTabWallet, tvTabWallet));
        iconList.add(new IconInfo(ivTabFind, tvTabFind));
        iconList.add(new IconInfo(ivTabMine, tvTabMine));

    }

    @Override
    protected void onResume() {
        super.onResume();
        //权限检测
        CheckPermissionsUitl.checkPermissions(this, requestPermissions);
        Log.e("App.is", App.is_exist + "");

        type = 0;
        if (App.is_exist == 0) {
            mPresenter.getHuanYing(App.account);
            AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.ActionSheetDialogStyle);

            View inflate = getLayoutInflater().inflate(R.layout.home_dialog, null);
            AutoUtils.setSize(this, false, 720, 1280);
            AutoUtils.auto(inflate);
            ImageView image = (ImageView) inflate.findViewById(R.id.delete_image);
            text = (TextView) inflate.findViewById(R.id.dialog_title);
            msgtwo = (TextView) inflate.findViewById(R.id.dialog_title_two);
            ImageView view = (ImageView) inflate.findViewById(R.id.home_image);
            dialog.setView(inflate);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    type = 1;
                    startActivity(new Intent(JoininNjjActivity.this, AnswerActivity.class));
                    alertDialog.dismiss();

                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    type = 1;
                    alertDialog.dismiss();
                    startActivity(new Intent(JoininNjjActivity.this, AnswerActivity.class));

                }
            });
            alertDialog = dialog.create();

            alertDialog.show();
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if (type == 0) {
                        startActivity(new Intent(JoininNjjActivity.this, AnswerActivity.class));
                    } else {

                    }
                }
            });
        }
    }

    private void initFragment() {
        //初始化碎片
        if (homeFragment == null) {
            homeFragment = new OnTrialFragment();
        }
        if (walletFragment == null) {
            walletFragment = new JoininMoreFragment();
        }
//            walletFragment = new WalletFragment();
        if (findFragment == null) {
            findFragment = new FindFrqagment();
        }
        if (mineFragment == null) {
            mineFragment = new MainFragment();
        }

        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(homeFragment);
        fragmentList.add(walletFragment);
        fragmentList.add(findFragment);
        fragmentList.add(mineFragment);
    }

    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */
    private void showFragment(Fragment fragment, int position) {
        JumpFragment(fragment);
        setIcon(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        type = 0;
    }

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_main, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
    }

    /**
     * 设置图标点击效果
     *
     * @param position
     */
    private void setIcon(int position) {

        for (int i = 0; i < iconList.size(); i++) {

            iconList.get(i).getImageView().setImageResource(iconNormal[i]);
            iconList.get(i).getTextView().setTextColor(this.getResources().getColor(R.color.colorGrayDark));

        }
        iconList.get(position).getImageView().setImageResource(iconPressed[position]);
        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.colorPrimaryDes));
    }

    @OnClick({R.id.rl_tab_home, R.id.rl_tab_wallet, R.id.rl_tab_find, R.id.rl_tab_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_tab_home:
                showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
                break;
            case R.id.rl_tab_wallet:
                showFragment(fragmentList.get(WALLET_FRAGMENT), WALLET_FRAGMENT);
                break;
            case R.id.rl_tab_find:
                showFragment(fragmentList.get(FIND_FRAGMENT), FIND_FRAGMENT);
                break;
            case R.id.rl_tab_mine:
                showFragment(fragmentList.get(MINE_FRAGMENT), MINE_FRAGMENT);
                break;
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void responseFindData(HomeBean data) {

    }

    @Override
    public void showHuanying(HuanYingBean.BodyBean bodyBean) {
        if (bodyBean.getWelcomes() != null) {
            Log.e("tag", bodyBean.getWelcomes() + "");
            String[] split = bodyBean.getWelcomes().split("，");
            String substring = split[0].substring(0, 2);
            String substring1 = split[0].substring(2, split[0].length());
            String s1 = "<font color='#696969'>" + substring + "</font>" + "<font color='#FF0000'>" + substring1 + "</font>";
            text.setText(Html.fromHtml(s1));
            msgtwo.setText(split[1]);
        }
    }

    public void isShow() {

        Map map = new HashMap();
        map.put("cardno", App.cardNo);
        map.put("appId", App.app_id);
        OkhttpUtils.doGet("http://wpsnew.rxjy.com/a/sap/sapArticle/isNewArticle", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_获取是否有新文章失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_获取是否有新文章", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            String statusMsg = jsonObject.getString("StatusMsg");
                            if (statusCode == 0) {
                                img_reddot.setVisibility(View.VISIBLE);
                            } else {
                                img_reddot.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
