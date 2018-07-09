package com.rxjy.rxcompound.des.activity;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.IconInfo;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.CheckPermissionsUitl;
import com.rxjy.rxcompound.des.fragment.HomeFragment;
import com.rxjy.rxcompound.des.mvp.contract.DestoryContract;
import com.rxjy.rxcompound.des.mvp.presenter.DestoryPresenter;
import com.rxjy.rxcompound.entity.NumberPackets;
import com.rxjy.rxcompound.fragment.FindFrqagment;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.fragment.MoreFragment;
import com.rxjy.rxcompound.fragment.NewPeopleHomeFragment;
import com.rxjy.rxcompound.joinin.fragment.JoininMoreFragment;
import com.rxjy.rxcompound.joinin.fragment.OnTrialFragment;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.rxjy.rxcompound.receiver.MessageReceiver.MSG_NUM;
import static com.rxjy.rxcompound.receiver.MessageReceiver.msgnum;

public class NjjActivity extends BaseActivity<DestoryPresenter> implements DestoryContract.View {

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
    @Bind(R.id.tv_tab_mine)
    TextView tvTabMine;
    @Bind(R.id.rl_tab_mine)
    RelativeLayout rlTabMine;
    @Bind(R.id.tv_msgnum)
    TextView tv_msgnum;
    @Bind(R.id.red_display)
    TextView redDisplay;
    @Bind(R.id.ll_view)
    LinearLayout llView;

    private Fragment currentFragment;

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

    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int WALLET_FRAGMENT = 1;
    private final int FIND_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;

    //Tab图标的集合
    private List<IconInfo> iconList;

    //碎片的集合
    private List<Fragment> fragmentList;

    private HomeFragment homeFragment;
    //    private WalletFragment walletFragment;
    private MoreFragment walletFragment;
    private FindFrqagment findFragment;
    private MainFragment mineFragment;
    private JoininMoreFragment onTrialHomeFragment;
    private OnTrialFragment onTrialFragment;

    public static NjjActivity activity;

    //检测权限列表
    private String[] requestPermissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE
    };

    @Override
    public int getLayout() {
        return R.layout.activity_njj;
    }

    @Override
    public void initData() {
        activity = this;
        //设置别名
        setAlias();
        initIcon();
        initFragment();
        //加载默认显示碎片
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);

        SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
        int num = preferences.getInt(msgnum, 0);
        if (num > 0) {
            ShowMsgNum(num);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //权限检测
        CheckPermissionsUitl.checkPermissions(this, requestPermissions);
        if(App.dcid==3||App.dcid==34) {
            mPresenter.getRedTask(App.cardNo);
        }
    }

    private void initFragment() {
        //初始化碎片
        if (homeFragment == null)
            homeFragment = new HomeFragment();
        if (walletFragment == null)
            walletFragment = new MoreFragment();
//            walletFragment = new WalletFragment();
        if (findFragment == null)
            findFragment = new FindFrqagment();
        if (mineFragment == null)
            mineFragment = new MainFragment();
//            mineFragment = new PersonalFragment();
//            mineFragment = new MineFragment();
        //初始化fragmentList数据集合
        if (onTrialFragment == null) {
            onTrialFragment = new OnTrialFragment();
        }
        if (onTrialHomeFragment == null) {
            onTrialHomeFragment = new JoininMoreFragment();
        }

        fragmentList = new ArrayList<>();
        //将碎片添加到集合中

//        fragmentList.add(homeFragment);
        if(getIntent().getIntExtra("isShow",0) == 0){
            fragmentList.add(new NewPeopleHomeFragment());
        }else {
            fragmentList.add(homeFragment);
        }
        fragmentList.add(walletFragment);
        fragmentList.add(findFragment);
        fragmentList.add(mineFragment);
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


    public void ShowMsgNum(int num) {
        if (num > 0) {
            tv_msgnum.setText(num + "");
            tv_msgnum.setVisibility(View.VISIBLE);
        } else {
            tv_msgnum.setVisibility(View.GONE);
        }
    }


    // 这是来自 JPush Example 的设置别名的 Activity 里的代码。一般 App 的设置的调用入口，在任何方便的地方调用都可以。
    private void setAlias() {

//        String alias = App.cardNo;
//        // 调用 Handler 来异步设置别名
//        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, alias));
    }

    //    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
//        @Override
//        public void gotResult(int code, String alias, Set<String> tags) {
//            String logs ;
//            switch (code) {
//                case 0:
//                    logs = "Set tag and alias success";
//                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
//                    break;
//                case 6002:
//                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
//
//                    // 延迟 60 秒来调用 Handler 设置别名
//                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
//                    break;
//                default:
//            }
//        }
//    };
    private static final int MSG_SET_ALIAS = 1001;
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
                    // 调用 JPush 接口来设置别名。
//                    JPushInterface.setAliasAndTags(getApplicationContext(),
//                            (String) msg.obj,
//                            null,
//                            mAliasCallback);
                    break;
                default:
            }
        }
    };


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


    @Override
    protected DestoryPresenter onCreatePresenter() {
        return new DestoryPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
                SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
                preferences.edit().putInt(msgnum, 0).commit();
                ShowMsgNum(0);
                showFragment(fragmentList.get(MINE_FRAGMENT), MINE_FRAGMENT);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.getDestoryListener();
            Log.e("应用被杀死","应用死亡");
            Map map = new HashMap();
            map.put("cardNo",App.cardNo);
            OkhttpUtils.doPost("https://api.dcwzg.com:9191/actionapi/AppHome/OfflineApp", map, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("下线",e.getMessage().toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Log.e("下线",string);
                }
            });
    }

    @Override
    public void responseUserStatusError(String msg) {
        showToast(msg);
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
    public void responseTaskData(NumberPackets.BodyBean mlist) {
        if(mlist.getCount()<=0){

        }else {
            redDisplay.setVisibility(View.GONE);
        }

    }


}