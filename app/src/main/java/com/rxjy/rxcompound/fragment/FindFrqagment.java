package com.rxjy.rxcompound.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.FindListActivity;
import com.rxjy.rxcompound.activity.PublishActivity;
import com.rxjy.rxcompound.adapter.FindListAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.entity.FindBean;
import com.rxjy.rxcompound.entity.FindDataBean;
import com.rxjy.rxcompound.mvp.contract.FindFContract;
import com.rxjy.rxcompound.mvp.presenter.FindFPresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/6.
 */
public class FindFrqagment extends BaseFragment<FindFPresenter> implements FindFContract.View {

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
    @Bind(R.id.pullsv_find)
    PullToRefreshScrollView pullsv_find;
    @Bind(R.id.rl_findtop)
    RelativeLayout rlFindtop;
    @Bind(R.id.publish)
    ImageView publish;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    private ScrollView scrollView;
    private PagerAdapter pagerAdapter;
    int index = 0;
    int size = 0;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_find;
    }

    String phonenum, cardno;

    @Override
    protected void FragmentInitData() {

        mPresenter.getFindObtainWhethe(App.cardNo);
        switch (App.apptype) {
            case 2:
                rlFindtop.setBackgroundColor(getResources().getColor(R.color.textorange));
                break;
            case 3:
                rlFindtop.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDes));
                break;
            case 4:
                rlFindtop.setBackgroundColor(getResources().getColor(R.color.colorPrimarys));
                break;
            default:
                break;
        }
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        scrollView = pullsv_find.getRefreshableView();
        RequestDate(cardno);
    }

    /**
     * 请求数据
     */
    int pageIndex = 1;//页数
    int pageSize = 10;//每页条数
    int ispulldown = 0;//是否刷新  1：是
    int isload = 0;//1:不可加载

    private void RequestDate(final String cardno) {
        mPresenter.getFindList(cardno, pageIndex, pageSize);
        Log.e("lrj", cardno + "==========" + pageIndex + "=======" + pageSize);
        pullsv_find.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex = 1;
                pageSize = 10;
                ispulldown = 1;
                mPresenter.getFindList(cardno, pageIndex, pageSize);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                if (isload == 1) {
                    Toast.makeText(getActivity(), "没有更多数据啦！", Toast.LENGTH_SHORT).show();
                }
                pageIndex = pageIndex + 1;
                mPresenter.getFindListLoadmore(cardno, pageIndex, pageSize);

            }
        });
    }

    @Override
    protected FindFPresenter onCreatePresenter() {
        return new FindFPresenter(this);
    }

    @Override
    public void responseFindData(FindBean data) {
        if (data.getBody().getTopList() != null) {
            size = data.getBody().getTopList().size();
        }
        if (ispulldown == 1) {
            pullsv_find.onRefreshComplete();
            ispulldown = 0;
        }
        ShowBanner(data.getBody().getTopList());
        showlist = new ArrayList<>();
        showlist = data.getBody().getList();
        ShowList(showlist);
    }

    @Override
    public void responseFindDataError(String msg) {

    }

    @Override
    public void responseFindDataLoadmore(FindBean data) {
        if (data.getBody().getList() != null && data.getBody().getList().size() < 10) {
            isload = 1;
        }
        showlist.addAll(data.getBody().getList());
        findListAdapter.notifyDataSetChanged();
        pullsv_find.onRefreshComplete();
    }

    @Override
    public void responseFindDataLoadmoreError(String msg) {

    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 5) {
                if (index >= size) index = 0;
                if (vp_findbanner != null) {
                    vp_findbanner.setCurrentItem(index++);
                    handler.sendEmptyMessageDelayed(5, 3000);
                } else {
                    handler.removeMessages(5);
                }
            }
        }
    };

    /**
     * 显示顶部数据
     *
     * @param datalist
     */
    private void ShowBanner(final ArrayList<FindDataBean> datalist) {

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
                tv_bannerdescribe.setText(datalist.get(position).getName());
                iv_bannerimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), FindListActivity.class).putExtra("id", datalist.get(position).getId() + "").putExtra("title", datalist.get(position).getName()).putExtra("type", "0"));
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
    }

    /**
     * 显示列表数据
     */
    FindListAdapter findListAdapter;
    ArrayList<FindDataBean> showlist;

    private void ShowList(final ArrayList<FindDataBean> list) {
        findListAdapter = new FindListAdapter(getActivity(), list);
        lv_finddata.setAdapter(findListAdapter);
        lv_finddata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = "";
                switch (list.get(i).getType()) {
                    case 0:
                        title = list.get(i).getName();
                        break;
                    case 1:
                        title = "岗前答题";
                        break;
                    case 2:
                        title = "日常培训";
                        break;
                    case 3:
                        title = list.get(i).getName();
                        break;
                }
                startActivity(new Intent(getActivity(), FindListActivity.class).putExtra("id", list.get(i).getId() + "").putExtra("title", title).putExtra("type", list.get(i).getType() + "").putExtra("courseId", list.get(i).getCourseId() + ""));
            }
        });
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void obtainWhetheData(int i) {
        if (i == 1) {
            publish.setVisibility(View.VISIBLE);
        } else {
            publish.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.publish)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), PublishActivity.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}