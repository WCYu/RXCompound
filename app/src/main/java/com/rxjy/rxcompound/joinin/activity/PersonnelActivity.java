package com.rxjy.rxcompound.joinin.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.CheckPermissionsUitl;
import com.rxjy.rxcompound.joinin.fragment.BusAffairsFragment;
import com.rxjy.rxcompound.joinin.fragment.EngineeringFragment;
import com.rxjy.rxcompound.joinin.fragment.InvestmentFragment;
import com.rxjy.rxcompound.joinin.fragment.MainCaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/21.
 */

public class PersonnelActivity extends BaseActivity {
    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.tv_tab_home)
    TextView tvTabHome;
    @Bind(R.id.tv_tab_wallet)
    TextView tvTabWallet;
    @Bind(R.id.tv_tab_find)
    TextView tvTabFind;
    @Bind(R.id.tv_tab_mine)
    TextView tvTabMine;
    @Bind(R.id.ll_view)
    LinearLayout llView;
    @Bind(R.id.tv_msgnum)
    TextView tvMsgnum;
    @Bind(R.id.rl_tab_home)
    RelativeLayout rlTabHome;
    @Bind(R.id.rl_tab_wallet)
    RelativeLayout rlTabWallet;
    @Bind(R.id.rl_tab_find)
    RelativeLayout rlTabFind;
    @Bind(R.id.rl_tab_mine)
    RelativeLayout rlTabMine;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private Fragment currentFragment;
    //Tab图标的集合
    private List<TextView> iconList;
    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int WALLET_FRAGMENT = 1;
    private final int FIND_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;
    //碎片的集合
    private List<Fragment> fragmentList;
    private BusAffairsFragment homeFragment;
    private MainCaseFragment walletFragment;
    private EngineeringFragment findFragment;
    private InvestmentFragment mineFragment;
    public static PersonnelActivity activity;
    //检测权限列表
    private String[] requestPermissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE
    };

    @Override
    public int getLayout() {
        return R.layout.activity_personnelnjj;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //权限检测
        CheckPermissionsUitl.checkPermissions(this, requestPermissions);
    }

    private void initFragment() {
        //初始化碎片
        if (homeFragment == null) {
            homeFragment = new BusAffairsFragment();
        }
        if (walletFragment == null) {
            walletFragment = new MainCaseFragment();
        }
//            walletFragment = new WalletFragment();
        if (findFragment == null) {
            findFragment = new EngineeringFragment();
        }
        if (mineFragment == null) {
            mineFragment = new InvestmentFragment();
        }

        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(homeFragment);
        fragmentList.add(walletFragment);
        fragmentList.add(findFragment);
        fragmentList.add(mineFragment);
    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(tvTabHome);
        iconList.add(tvTabWallet);
        iconList.add(tvTabFind);
        iconList.add(tvTabMine);

    }

    @Override
    public void initData() {
        tvTitle.setText("人事");
        initIcon();
        initFragment();

        //加载默认显示碎片
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
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

    /**
     * 设置图标点击效果
     *
     * @param position
     */
    private void setIcon(int position) {

        for (int i = 0; i < iconList.size(); i++) {

            // iconList.get(i).getImageView().setImageResource(iconNormal[i]);
            iconList.get(i).setTextColor(this.getResources().getColor(R.color.colorGrayDark));

        }

        iconList.get(position).setTextColor(this.getResources().getColor(R.color.colorred));
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
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
