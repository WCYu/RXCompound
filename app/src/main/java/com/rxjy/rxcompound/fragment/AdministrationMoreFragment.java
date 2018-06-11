package com.rxjy.rxcompound.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.AdministrationMoreAdapter;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.widget.MyGridView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/9.
 */

public class AdministrationMoreFragment extends BaseFragment {
    @Bind(R.id.gridview)
    MyGridView gridview;
    private Map<Integer,String> mlist;

    @Override
    protected int getFragmentLayout() {
        return R.layout.administration_more;
    }

    @Override
    protected void FragmentInitData() {
        mlist=new HashMap<>();
        //Red envelopes
        mlist.put(R.mipmap.more_redenvelopes,"红包");
        mlist.put(R.mipmap.more_returnguest,"回头客");
        mlist.put(R.mipmap.more_joinin,"加盟");
        mlist.put(R.mipmap.more_cost,"费用");
        mlist.put(R.mipmap.more_moneybag,"钱袋");
        mlist.put(R.mipmap.more_news,"消息");
        AdministrationMoreAdapter moreAdapter=new AdministrationMoreAdapter(mlist,getContext());
        gridview.setAdapter(moreAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Set<Integer> integers = mlist.keySet();
                for (Integer key:integers) {
                    switch (key){
                        case R.mipmap.more_redenvelopes :

                            break;
                        case R.mipmap.more_returnguest:
                            break;
                        case R.mipmap.more_joinin:
                            break;
                        case R.mipmap.more_cost:
                            break;
                        case R.mipmap.more_moneybag:
                            break;
                        case R.mipmap.more_news:

                            break;
                        default:
                            break;


                    }
                }

            }
        });

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

}
