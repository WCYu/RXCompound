package com.rxjy.rxcompound.joinin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.des.activity.WebActivity;
import com.rxjy.rxcompound.des.adapter.HomeShejiAdapter;
import com.rxjy.rxcompound.des.entity.HomeBean;
import com.rxjy.rxcompound.des.mvp.contract.OnTriaHomeContract;
import com.rxjy.rxcompound.des.mvp.presenter.HomeFindPresenter;
import com.rxjy.rxcompound.joinin.entity.HuanYingBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/23.
 */

public class OnTrialFragment extends BaseFragment<HomeFindPresenter> implements OnTriaHomeContract.View {
    @Bind(R.id.vp_findbanner)
    ViewPager vp_findbanner;
    @Bind(R.id.iv_circleone)
    ImageView iv_circleone;
    @Bind(R.id.iv_circletwo)
    ImageView iv_circletwo;
    @Bind(R.id.iv_circlethree)
    ImageView iv_circlethree;
    @Bind(R.id.lv_finddata)
    ListView lv_finddata;
    @Bind(R.id.rl_findtop)
    RelativeLayout rlFindtop;
    @Bind(R.id.publish)
    ImageView publish;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    @Bind(R.id.ly_web)
    LinearLayout ly_web;
    @Bind(R.id.home_view)
    WebView newWeb;

    private ScrollView scrollView;
    private PagerAdapter pagerAdapter;
    int index = 0;
    int size = 0;
    HomeShejiAdapter findListAdapter;
    ArrayList<HomeBean.BodyBean.ListBean> showlist;
    String url ="http://edu.rxjy.com/a/rs/curaInfo/"+App.cardNo+"01012167/tryPostApp";
    @Override
    protected int getFragmentLayout() {
        return R.layout.activity_home_shiji;
    }

    @Override
    protected void FragmentInitData() {
        if (App.is_group.equals("1") || App.is_group.equals("0")) {
            if (App.ustart != 2 && App.ustart != 3 && App.ustart != 4) {
                ly_web.setVisibility(View.VISIBLE);
                newWeb.loadUrl(url);
                Log.e("webView————————", url);

                WebSettings settings = newWeb.getSettings();
                settings.setJavaScriptEnabled(true);
                //设置自适应屏幕，两者合用
                settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
                settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
                settings.setDomStorageEnabled(true);
                newWeb.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });
            } else {
                ly_web.setVisibility(View.GONE);
            }
        } else {
            ly_web.setVisibility(View.GONE);
        }

        mPresenter.getFindList(App.cardNo);

    }

    @Override
    protected HomeFindPresenter onCreatePresenter() {
        return new HomeFindPresenter(this);
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
    public void showMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void responseFindData(HomeBean data) {
        size = data.getBody().getTopList().size();
        ShowList(data.getBody().getList());
        ShowBanner(data.getBody().getTopList());
    }

    @Override
    public void showHuanying(HuanYingBean.BodyBean bodyBean) {
        String welcomes = bodyBean.getWelcomes();
        if (welcomes != null) {

        }
    }

    private void ShowList(final List<HomeBean.BodyBean.ListBean> list) {
        findListAdapter = new HomeShejiAdapter(getActivity(), list);
        lv_finddata.setAdapter(findListAdapter);
        lv_finddata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = list.get(i).getId();
                startActivity(new Intent(getContext(), WebActivity.class).putExtra("id", id));
            }
        });
    }

    /**
     * 显示顶部数据
     *
     * @param datalist
     */
    private void ShowBanner(final List<HomeBean.BodyBean.TopListBean> datalist) {
        if (datalist.size() == 0) {
            backLayout.setVisibility(View.INVISIBLE);
        }
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return datalist.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                View view = View.inflate(getActivity(), R.layout.vp_bannerfind, null);
                ImageView iv_bannerimg = (ImageView) view.findViewById(R.id.iv_bannerimg);
                TextView tv_bannerdescribe = (TextView) view.findViewById(R.id.tv_bannerdescribe);
                Glide.with(getActivity()).load(datalist.get(position).getCover()).into(iv_bannerimg);
                tv_bannerdescribe.setText(datalist.get(position).getTitle());
                iv_bannerimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getContext(), WebActivity.class).putExtra("id", datalist.get(position).getId()));
                    }
                });
                container.addView(view);
                return view;
            }
        };
        vp_findbanner.setAdapter(pagerAdapter);
        vp_findbanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        iv_circleone.setImageResource(R.drawable.dotwhite);
                        iv_circletwo.setImageResource(R.drawable.dotgrey);
                        iv_circlethree.setImageResource(R.drawable.dotgrey);
                        break;
                    case 1:
                        iv_circleone.setImageResource(R.drawable.dotgrey);
                        iv_circletwo.setImageResource(R.drawable.dotwhite);
                        iv_circlethree.setImageResource(R.drawable.dotgrey);
                        break;
                    case 2:
                        iv_circleone.setImageResource(R.drawable.dotgrey);
                        iv_circletwo.setImageResource(R.drawable.dotgrey);
                        iv_circlethree.setImageResource(R.drawable.dotwhite);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        handler.sendEmptyMessageDelayed(5, 3000);
        Log.e("轮播图","开始");
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 5) {
                if (index >= size) {
                    index = 0;
                }
                if (vp_findbanner != null) {
                    vp_findbanner.setCurrentItem(index++);
//                    Log.e("轮播图","轮播"+index);
                    handler.sendEmptyMessageDelayed(5, 3000);
                } else {
                    handler.removeMessages(5);
                }
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
