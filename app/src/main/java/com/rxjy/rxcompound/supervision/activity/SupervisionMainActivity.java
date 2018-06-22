package com.rxjy.rxcompound.supervision.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.IconInfo;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.DownLoadApk;
import com.rxjy.rxcompound.entity.VersionInfo;
import com.rxjy.rxcompound.fragment.FindFrqagment;
import com.rxjy.rxcompound.fragment.HomeNewFragment;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.fragment.MoreFragment;
import com.rxjy.rxcompound.supervision.fragment.ProjectFragment;
import com.rxjy.rxcompound.supervision.mvp.contract.MainContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.MainPresenter;
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

/**
 * Created by hjh on 2018/2/1.
 * 项目监理
 */

public class SupervisionMainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.iv_tab_home)
    ImageView ivTabHome;
    @Bind(R.id.tv_tab_home)
    TextView tvTabHome;
    @Bind(R.id.rl_tab_home)
    RelativeLayout rlTabHome;
    @Bind(R.id.iv_tab_wallet)
    ImageView ivTabMore;
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

    private Fragment currentFragment;

    private int[] iconNormal = new int[]{
            R.mipmap.home_normal,
            R.mipmap.more_normal,
            R.mipmap.find_normal,
            R.mipmap.mine_normal
    };

    private int[] iconPressed = new int[]{
            R.mipmap.home_pressed,
            R.mipmap.more_pressed,
            R.mipmap.find_pressed,
            R.mipmap.mine_pressed
    };

    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int MORE_FRAGMENT = 1;
    private final int FIND_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;

    //Tab图标的集合
    private List<IconInfo> iconList;

    //碎片的集合
    private List<Fragment> fragmentList;

    private HomeNewFragment homeNewFragment;
    private MoreFragment moreFragment;
    private FindFrqagment findFragment;
    private MainFragment mineFragment;

    public static SupervisionMainActivity activity;

    @Override
    public int getLayout() {
        return R.layout.activity_aupmain;
    }

    @Override
    public void initData() {
        activity=this;
        initIcon();
        initFragment();
        //加载默认显示碎片
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
        mPresenter.getVersionInfo();

        SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
        int num = preferences.getInt(msgnum, 0);
        if(num>0){
            ShowMsgNum(num);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initFragment() {
        //初始化碎片
        if (homeNewFragment == null)
            homeNewFragment = new HomeNewFragment();
        if (moreFragment == null)
            moreFragment = new MoreFragment();
        if (findFragment == null)
            findFragment = new FindFrqagment();
        if (mineFragment == null)
            mineFragment = new MainFragment();
        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(homeNewFragment);
        fragmentList.add(moreFragment);
        fragmentList.add(findFragment);
        fragmentList.add(mineFragment);
    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(ivTabHome, tvTabHome));
        iconList.add(new IconInfo(ivTabMore, tvTabWallet));
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
        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.colorPrimarys));
    }

    public void ShowMsgNum(int num){
        if(num>0){
            tv_msgnum.setText(num+"");
            tv_msgnum.setVisibility(View.VISIBLE);
        }else{
            tv_msgnum.setVisibility(View.GONE);
        }
    }


    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
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
                showFragment(fragmentList.get(MORE_FRAGMENT), MORE_FRAGMENT);
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
    public void responseVersionData(final VersionInfo.Version data) {
        if (data.getVersionNo() > Integer.parseInt(App.getVersionCode())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("版本升级");
            builder.setCancelable(false);// 设置点击屏幕Dialog不消失
            builder.setMessage(data.getContent());
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownLoadApk downLoadApk = new DownLoadApk(SupervisionMainActivity.this);
                    downLoadApk.downLoadApk(data);
                }
            });
            builder.setNegativeButton("取消", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public void responseVersionDataError(String msg) {
        showToast(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

}
