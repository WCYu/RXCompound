package com.rxjy.rxcompound.des.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rxjy.rxcompound.des.fragment.WpsImageFragment;

import java.util.List;

/**
 * Created by csonezp on 15-12-28.
 */
public class WpsImageViewPagerAdapter extends FragmentStatePagerAdapter
{

    List<String> mDatas;

    public WpsImageViewPagerAdapter(FragmentManager fm, List data) {
        super(fm);
        mDatas = data;
    }

    @Override
    public Fragment getItem(int position) {
        String url = mDatas.get(position);
        Fragment fragment = WpsImageFragment.newInstance(url);
        return fragment;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }
}
