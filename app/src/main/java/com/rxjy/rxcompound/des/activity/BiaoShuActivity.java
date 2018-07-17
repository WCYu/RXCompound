package com.rxjy.rxcompound.des.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.des.fragment.BiaoShuFragment;

import butterknife.Bind;

public class BiaoShuActivity extends BaseActivity {
    @Bind(R.id.biaoshu_vp)
    ViewPager lv_biaoshu;
    @Bind(R.id.biaoshu_cancel)
    ImageView iv_cancel;
    private MyPagerAdapter2 adapter;
    int jiaochengbs;

    private void initViewData() {
        adapter = new MyPagerAdapter2(getSupportFragmentManager());
        lv_biaoshu.setAdapter(adapter);
        iv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_biao_shu);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_biao_shu;
    }

    @Override
    public void initData() {
        initViewData();

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    private int[] pics = new int[]{
            R.mipmap.page01,
            R.mipmap.page02,
            R.mipmap.page03,
            R.mipmap.page04,
            R.mipmap.page05,
            R.mipmap.page06,
            R.mipmap.page07,
            R.mipmap.page08,
            R.mipmap.page09,
            R.mipmap.page10,
            R.mipmap.page11,
            R.mipmap.page12,
            R.mipmap.page13,
            R.mipmap.page14,
            R.mipmap.page15,
            R.mipmap.page16,
            R.mipmap.page17,
            R.mipmap.page18,
            R.mipmap.page19,
            R.mipmap.page20,
            R.mipmap.page21,
            R.mipmap.page22,
            R.mipmap.page23,
            R.mipmap.page24,
            R.mipmap.page26,
            R.mipmap.page27,
            R.mipmap.page28,
            R.mipmap.page29,
            R.mipmap.page30,
            R.mipmap.page31,
            R.mipmap.page32,
            R.mipmap.page33,
            R.mipmap.page34
    };
    private int[] pics2 = new int[]{
            R.mipmap.yusuan1,
            R.mipmap.yusuan2,
            R.mipmap.yuansuan3,
            R.mipmap.yusuan4,
            R.mipmap.yusuan5,
            R.mipmap.yusuan6,
            R.mipmap.yusuan7,
            R.mipmap.yusuan8,
            R.mipmap.yusuan9,
            R.mipmap.yusuan10,
            R.mipmap.yusuan11,
            R.mipmap.yusuan12,
            R.mipmap.yusuan13,
            R.mipmap.yusuan14,
            R.mipmap.yusuan15,

    };

    public class MyPagerAdapter2 extends FragmentStatePagerAdapter {

        // private final List<String> catalogs = new ArrayList<String>();

        public MyPagerAdapter2(FragmentManager fm) {
            super(fm);

        }

        @Override
        public int getCount() {
            jiaochengbs = getIntent().getIntExtra(Constants.JIAOCHENG, -1);
            if (jiaochengbs == 1) {
                return pics.length;
            } else {
                return pics2.length;
            }
        }

        @Override
        public Fragment getItem(int position) {
            jiaochengbs = getIntent().getIntExtra(Constants.JIAOCHENG, -1);
            if (jiaochengbs == 1) {
                return BiaoShuFragment.newInstance(pics, position);
            } else {
                return BiaoShuFragment.newInstance(pics2, position);
            }
        }
    }

}
