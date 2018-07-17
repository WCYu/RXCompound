package com.rxjy.rxcompound.des.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;

public class BiaoShuFragment extends BaseFragment {

    private static final String ARG_POSITION = "position";
    private static int[] picsz;

    private int position;

    @Bind(R.id.iv_biaoshu)
    ImageView iv_biaoshu;


    public static BiaoShuFragment newInstance(int[] pics,int position) {
        picsz=pics;
        BiaoShuFragment f = new BiaoShuFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.list_item_biaoshu;
    }

    @Override
    protected void FragmentInitData() {
        Log.e("position",position+"");
        iv_biaoshu.setImageResource(picsz[position]);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}