package com.rxjy.rxcompound.business.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.IconInfo;
import com.rxjy.rxcompound.business.fragment.CustomerFragment;
import com.rxjy.rxcompound.business.fragment.CustomerNewFragment;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.mvp.contract.DestoryContract;
import com.rxjy.rxcompound.des.mvp.presenter.DestoryPresenter;
import com.rxjy.rxcompound.entity.NumberPackets;
import com.rxjy.rxcompound.fragment.FindFrqagment;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.fragment.MoreFragment;
import com.rxjy.rxcompound.fragment.NewHomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.rxjy.rxcompound.receiver.MessageReceiver.MSG_NUM;
import static com.rxjy.rxcompound.receiver.MessageReceiver.msgnum;

/**
 * Created by hjh on 2017/11/23.
 */

public class BusinessMainHostActivity extends BaseActivity<DestoryPresenter> implements DestoryContract.View {

    private static View v;
    @Bind(R.id.fl_busimain)
    FrameLayout flBusimain;
    @Bind(R.id.iv_busicustomer)
    ImageView ivBusicustomer;
    @Bind(R.id.tv_busicustomer)
    TextView tvBusicustomer;
    @Bind(R.id.iv_busiwallet)
    ImageView ivBusiwallet;
    @Bind(R.id.tv_busiwallet)
    TextView tvBusiwallet;
    @Bind(R.id.iv_busifind)
    ImageView ivBusifind;
    @Bind(R.id.tv_busifind)
    TextView tvBusifind;
    @Bind(R.id.iv_busimine)
    ImageView ivBusimine;
    @Bind(R.id.tv_busimine)
    TextView tvBusimine;
    @Bind(R.id.tv_msgnum)
    TextView tv_msgnum;
    @Bind(R.id.red_display)
    TextView redDisplay;

    private Fragment currentFragment;

    private int[] iconNormal = new int[]{
            R.drawable.ic_tab_hostpage,
            R.drawable.ic_tab_more,
            R.drawable.ic_tab_find,
            R.drawable.ic_tab_main
    };

    private int[] iconPressed = new int[]{
            R.drawable.ic_tab_hostpageorange,
            R.drawable.ic_tab_moreorange,
            R.drawable.ic_tab_findorange,
            R.drawable.ic_tab_mainorange
    };

    //指定Fragment的坐标
    private final int CUSTOMER_FRAGMENT = 0;
    private final int WALLET_FRAGMENT = 1;
    private final int FIND_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;

    //Tab图标的集合
    private List<IconInfo> iconList;

    //碎片的集合
    private List<Fragment> fragmentList;


//    private CustomerFragment customerFragment;
    private CustomerNewFragment customerFragmentnew;
    private MoreFragment walletFragment;
    private NewHomeFragment newHomeFragment;

    //    private WalletFragment walletFragment;
    private FindFrqagment findFragment;
    //    private MineFragment mineFragment;
//    private PersonalFragment mineFragment;
    private MainFragment mineFragment;

    public static BusinessMainHostActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_bus_main;
    }

    @Override
    public void initData() {
        activity = this;
        initIcon();
        initFragment();
        showFragment(fragmentList.get(CUSTOMER_FRAGMENT), CUSTOMER_FRAGMENT);

        SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
        int num = preferences.getInt(msgnum, 0);
        if (num > 0) {
            ShowMsgNum(num);
        }
    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(ivBusicustomer, tvBusicustomer));
        iconList.add(new IconInfo(ivBusiwallet, tvBusiwallet));
        iconList.add(new IconInfo(ivBusifind, tvBusifind));
        iconList.add(new IconInfo(ivBusimine, tvBusimine));
    }

    private void initFragment() {
        if (newHomeFragment == null)
            newHomeFragment = new NewHomeFragment();
        if (customerFragmentnew == null)
            customerFragmentnew = new CustomerNewFragment();
        if (walletFragment == null)
            walletFragment = new MoreFragment();
//            walletFragment = new WalletFragment();
        if (findFragment == null)
            findFragment = new FindFrqagment();
        if (mineFragment == null)
            mineFragment = new MainFragment();
//            mineFragment = new PersonalFragment();
//            mineFragment = new MineFragment();
        fragmentList = new ArrayList<>();

//        if (App.busisnew == 1) {
//            fragmentList.add(customerFragmentnew);
//        } else {
            fragmentList.add(newHomeFragment);
//        }

        fragmentList.add(walletFragment);
        fragmentList.add(findFragment);
        fragmentList.add(mineFragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(App.dcid==2) {
            mPresenter.getRedTask(App.cardNo);
        }
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
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_busimain, fragment);
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
            iconList.get(i).getTextView().setTextColor(this.getResources().getColor(R.color.textgreytwo));
        }
        iconList.get(position).getImageView().setImageResource(iconPressed[position]);
        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.textorange));
    }


    public void ShowMsgNum(int num) {
        if (num > 0) {
            tv_msgnum.setText(num + "");
            tv_msgnum.setVisibility(View.VISIBLE);
        } else {
            tv_msgnum.setVisibility(View.GONE);
        }
    }


    @Override
    protected DestoryPresenter onCreatePresenter() {
        return new DestoryPresenter(this);
    }

    @OnClick({R.id.ll_busicustomer, R.id.ll_busiwallet, R.id.ll_busiadd, R.id.ll_busifind, R.id.ll_busimine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_busicustomer:
                showFragment(fragmentList.get(CUSTOMER_FRAGMENT), CUSTOMER_FRAGMENT);
                break;
            case R.id.ll_busiwallet:
                showFragment(fragmentList.get(WALLET_FRAGMENT), WALLET_FRAGMENT);
                break;
            case R.id.ll_busiadd:
                Log.e("跳转哟！！", "hahahahha");
                startActivity(new Intent(this, AddActivity.class));
                break;
            case R.id.ll_busifind:
                showFragment(fragmentList.get(FIND_FRAGMENT), FIND_FRAGMENT);
                break;
            case R.id.ll_busimine:
                SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
                preferences.edit().putInt(msgnum, 0).commit();
                ShowMsgNum(0);
                showFragment(fragmentList.get(MINE_FRAGMENT), MINE_FRAGMENT);
                break;
        }
    }

    @Override
    public void responseUserStatusError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void responseTaskData(NumberPackets.BodyBean mlist) {
        if(mlist.getCount()<=0){
        }else {
            redDisplay.setVisibility(View.VISIBLE);
        }

    }
}
