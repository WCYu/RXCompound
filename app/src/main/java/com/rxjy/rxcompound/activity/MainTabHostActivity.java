package com.rxjy.rxcompound.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.DownLoadApk;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.fragment.HomeFragment;
import com.rxjy.rxcompound.entity.Tabs;
import com.rxjy.rxcompound.entity.VersionInfo;
import com.rxjy.rxcompound.fragment.AdministrationMoreFragment;
import com.rxjy.rxcompound.fragment.FindFrqagment;
import com.rxjy.rxcompound.fragment.HomePageFragment;
import com.rxjy.rxcompound.fragment.MainFragment;
import com.rxjy.rxcompound.fragment.MoreFragment;
import com.rxjy.rxcompound.fragment.NewPeopleHomeFragment;
import com.rxjy.rxcompound.fragment.NewestHomeFragment;
import com.rxjy.rxcompound.fragment.PersonalFragment;
import com.rxjy.rxcompound.mvp.contract.MainContract;
import com.rxjy.rxcompound.mvp.presenter.MainPresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.rxjy.rxcompound.receiver.MessageReceiver.MSG_NUM;
import static com.rxjy.rxcompound.receiver.MessageReceiver.msgnum;


/**
 * Created by hjh on 2017/11/6.
 */

public class MainTabHostActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    static FragmentTabHost mTabHost;

    private LayoutInflater mInflater;

    private List<Tabs> mTabs = new ArrayList<Tabs>(4);

    public static MainTabHostActivity instance = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_maintabhost;
    }

    @Override
    public void initData() {
        instance = this;
        init();
//        mPresenter.getVersionInfo(Integer.parseInt(App.getVersionCode()));
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }

    Tabs tab_home, tab_more, tab_find, tab_main;
    TabHost.TabSpec tabSpec;

    private void init() {
        if(getIntent().getIntExtra("isShow",0) == 1){
            tab_home = new Tabs("首页", null, R.drawable.selector_tabicon_home, HomePageFragment.class);
        }else {
            tab_home = new Tabs("首页", null, R.drawable.selector_tabicon_home, NewPeopleHomeFragment.class);
        }
        tab_more = new Tabs("更多", null, R.drawable.selector_tabicon_more, MoreFragment.class);
        tab_find = new Tabs("发现", null, R.drawable.selector_tabicon_find, FindFrqagment.class);
        tab_main = new Tabs("我", null, R.drawable.selector_tabicon_main, MainFragment.class);
//        Tabs tab_main = new Tabs("我", R.drawable.selector_tabicon_main, PersonalFragment.class);

        mTabs.add(tab_home);
        mTabs.add(tab_more);
        mTabs.add(tab_find);
        mTabs.add(tab_main);

        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) this.findViewById(R.id.main_tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_framcontent);

        for (Tabs tab : mTabs) {

            tabSpec = mTabHost.newTabSpec(tab.getTitle());

            tabSpec.setIndicator(buildIndicator(tab));

            mTabHost.addTab(tabSpec, tab.getFragment(), null);

            mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

            mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    switch (tabId) {
                        case "我":
                            SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
                            preferences.edit().putInt(msgnum, 0).commit();
                            SetMsgNum(0);
                            break;
                    }
                }
            });
        }
        SharedPreferences preferences = getSharedPreferences(MSG_NUM, MODE_PRIVATE);
        int num = preferences.getInt(msgnum, 0);
        if (num > 0) {
            SetMsgNum(num);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(" 应用被杀死","应用死亡");
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

    /**
     * 给Tab设置图标跟文字
     *
     * @param tab
     * @return
     */
    private View buildIndicator(Tabs tab) {
        View view = mInflater.inflate(R.layout.item_maintab, null);
        ImageView img = (ImageView) view.findViewById(R.id.main_tabitempic);
        TextView text = (TextView) view.findViewById(R.id.main_tabitemtex);
        TextView msgnum = (TextView) view.findViewById(R.id.tv_msgnum);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        if (!StringUtils.isEmpty(tab.getMsgnum()) && !tab.getMsgnum().equals("0")) {
            msgnum.setText(tab.getMsgnum());
            msgnum.setVisibility(View.VISIBLE);
        } else {
            msgnum.setVisibility(View.GONE);
        }
        return view;
    }


    /**
     * 设置消息角标
     *
     * @param num
     */
    public static void SetMsgNum(int num) {
        Log.e("设置消息角标", num + "....");
        View view = mTabHost.getTabWidget().getChildAt(3);
        if (view != null) {
            TextView txt = (TextView) view.findViewById(R.id.tv_msgnum);
            if (num > 0) {
                txt.setText(num + "");
                txt.setVisibility(View.VISIBLE);
            } else {
                txt.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public void responseVersionData(final VersionInfo.Version data) {
        Log.e("版本号是：：：：：：：：：", "-----");
        if (data.getVersionNo() > Integer.parseInt(App.getVersionCode())) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_shengji, null);
            TextView shengji = (TextView) view.findViewById(R.id.tv_shengji);
            TextView quxiao = (TextView) view.findViewById(R.id.tv_quxiao);
            TextView contentTv = (TextView) view.findViewById(R.id.tv_content);
            if (data != null) {
                String content = data.getContent();
                if (TextUtils.isEmpty(content)) {
                    contentTv.setText(content);
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            builder.setCancelable(false);// 设置点击屏幕Dialog不消失
            final AlertDialog dialog = builder.create();
            dialog.show();
            shengji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownLoadApk downLoadApk = new DownLoadApk(MainTabHostActivity.this);
                    downLoadApk.downLoadApk(data);
                }
            });

            quxiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
        }
        //        if (data.getVersionNo() > Integer.parseInt(App.getVersionCode())) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("版本升级");
//            builder.setCancelable(false);// 设置点击屏幕Dialog不消失
//            builder.setMessage(data.getContent());
//            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    DownLoadApk downLoadApk = new DownLoadApk(MainTabHostActivity.this);
//                    downLoadApk.downLoadApk(data);
//                }
//            });
        //            if (data.getForce() == 0) {
//                builder.setNegativeButton("取消", null);
//            }
//            AlertDialog dialog = builder.create();
//            dialog.show();
//        }

    }

    @Override
    public void responseVersionDataError(String msg) {
        showToast(msg);
    }
}