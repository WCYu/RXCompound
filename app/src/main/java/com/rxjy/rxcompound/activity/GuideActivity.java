package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 引导页
 * Created by hjh on 2017/11/3.
 */
public class GuideActivity extends BaseActivity{

    private ViewPager guide_viewpager;
    private TextView guide_go;
    private View view_guide1,view_guide2,view_guide3,view_guide4;
    private List<View> viewlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_guide;
    }

    @Override
    public void initData() {
        init();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    private void init(){
        guide_go= (TextView) findViewById(R.id.guide_go);
        guide_viewpager= (ViewPager) findViewById(R.id.guide_viewpager);
        LayoutInflater inflater=getLayoutInflater();
        view_guide1=inflater.inflate(R.layout.activity_guideone, null);
        view_guide2=inflater.inflate(R.layout.activity_guidetwo, null);
        view_guide3=inflater.inflate(R.layout.activity_guidethree, null);
        view_guide4=inflater.inflate(R.layout.activity_guidefour, null);

        guide_go.setVisibility(View.GONE);

        viewlist=new ArrayList<View>();
        viewlist.add(view_guide1);
        viewlist.add(view_guide2);
        viewlist.add(view_guide3);
        viewlist.add(view_guide4);

        PagerAdapter pageradapter=new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0==arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewlist.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewlist.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewlist.get(position));
                return viewlist.get(position);
            }


        };

        guide_viewpager.setAdapter(pageradapter);

        guide_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                switch(arg0){
                    case 0:
                        guide_go.setVisibility(View.GONE);
                        break;
                    case 1:
                        guide_go.setVisibility(View.GONE);
                        break;
                    case 2:
                        guide_go.setVisibility(View.GONE);
                        break;
                    case 3:
                        guide_go.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });


        guide_go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(GuideActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
