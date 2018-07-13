package com.rxjy.rxcompound.des.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.IconInfo;
import com.rxjy.rxcompound.des.fragment.HetongFragment;
import com.rxjy.rxcompound.des.fragment.TuzhiFragment;
import com.rxjy.rxcompound.des.fragment.YusuanFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class ShigonghetongActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_tab_hetong)
    TextView tvTabHetong;
    @Bind(R.id.tv_tab_hetong_line)
    TextView tvTabHetongLine;
    @Bind(R.id.ll_tab_hetong)
    LinearLayout llTabHetong;
    @Bind(R.id.tv_tab_yusuan)
    TextView tvTabYusuan;
    @Bind(R.id.tv_tab_yusuan_line)
    TextView tvTabYusuanLine;
    @Bind(R.id.ll_tab_yusuan)
    LinearLayout llTabYusuan;
    @Bind(R.id.tv_tab_tuzhi)
    TextView tvTabTuzhi;
    @Bind(R.id.tv_tab_tuzhi_line)
    TextView tvTabTuzhiLine;
    @Bind(R.id.ll_tab_tuzhi)
    LinearLayout llTabTuzhi;
    @Bind(R.id.fl_des_dai_main)
    FrameLayout flDesDaiMain;


    //指定Fragment的坐标
    private final int ONE_FRAGMENT = 0;
    private final int TWO_FRAGMENT = 1;
    private final int THREE_FRAGMENT = 2;


    //碎片的集合
    private List<Fragment> fragmentList;

    //new
    private HetongFragment  newOneFragment;
    private YusuanFragment newTwoFragment;
    private TuzhiFragment newThreeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_shigonghetong);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_shigonghetong;
    }


    @Override
    public void initData() {
        initTitle();
        initFragment();
        initIcon();
        setRwdidToFragment();

        //加载默认显示碎片
        showFragment(fragmentList.get(ONE_FRAGMENT), ONE_FRAGMENT);
    }

    private void setRwdidToFragment() {
        AllClientInfo.ClientTypeInfo.ClientInfo info = (AllClientInfo.ClientTypeInfo.ClientInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        newOneFragment.setClientInfo(info);
        newTwoFragment.setClientInfo(info);
        newThreeFragment.setClientInfo(info);
    }

    private void initTitle() {
        //初始化标题
        tvTitle.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("施工合同");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initFragment() {
        if (newOneFragment == null) {
            newOneFragment = new HetongFragment();
        }
        if (newTwoFragment == null) {
            newTwoFragment = new YusuanFragment();
        }
        if (newThreeFragment == null) {
            newThreeFragment = new TuzhiFragment();
        }

        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(newOneFragment);
        fragmentList.add(newTwoFragment);
        fragmentList.add(newThreeFragment);
    }

    //Tab图标的集合
    private List<IconInfo> iconList;

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(tvTabHetong, tvTabHetongLine));
        iconList.add(new IconInfo(tvTabYusuan, tvTabYusuanLine));
        iconList.add(new IconInfo(tvTabTuzhi, tvTabTuzhiLine));
    }

    @OnClick({R.id.ll_tab_hetong, R.id.ll_tab_yusuan, R.id.ll_tab_tuzhi})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.ll_tab_hetong:
                showFragment(fragmentList.get(ONE_FRAGMENT), ONE_FRAGMENT);
                break;
            case R.id.ll_tab_yusuan:
                showFragment(fragmentList.get(TWO_FRAGMENT), TWO_FRAGMENT);
                break;
            case R.id.ll_tab_tuzhi:
                showFragment(fragmentList.get(THREE_FRAGMENT), THREE_FRAGMENT);
                break;
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
        //加载显示的标题
        //tvTitle.setText(titleArr[position]);
    }

    private Fragment currentFragment;

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_des_dai_main, fragment);
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
            //iconList.get(i).getImageView().setImageResource(iconNormal[i]);
            //iconList.get(i).getTextView().setText(titleArr[i]);
            iconList.get(i).getTextView().setTextColor(this.getResources().getColor(R.color.cor666));
            iconList.get(i).getTextView2().setVisibility(View.INVISIBLE);
        }
        //iconList.get(position).getImageView().setImageResource(iconPressed[position]);
        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.cor0068b7));
        iconList.get(position).getTextView2().setVisibility(View.VISIBLE);
    }


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
