package com.rxjy.rxcompound.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.SupervisorCustormerAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.mvp.contract.CustomerContract;
import com.rxjy.rxcompound.mvp.presenter.CustomerPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by asus on 2018/4/13.
 */

public class CustomerFragment extends BaseFragment<CustomerPresenter> implements CustomerContract.View {
    private List<CustomerBean.BodyBean> mlist;
    @Bind(R.id.customer_list)
    ListView customerList;
    private SupervisorCustormerAdapter customerAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.customerfragment;
    }

    @Override
    protected void FragmentInitData() {
        //Toast.makeText(getContext(), "========", Toast.LENGTH_SHORT).show();
        mlist = new ArrayList<>();
        customerAdapter = new SupervisorCustormerAdapter(getContext(), mlist);
        customerList.setAdapter(customerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

//        if(null!=App.rwdId){
//            mPresenter.loadCustomerData(App.cardNo,4+"");
//            Log.e("bug",App.rwdId+"");
//        }
        Log.e("cano",App.cardNo+"");
        mPresenter.loadCustomerData(App.cardNo,4+"");
       // mPresenter.GetOrderNumber(App.regionid,App.account);
    }

    @Override
    protected CustomerPresenter onCreatePresenter() {
        return new CustomerPresenter(this);
    }

    @Override
    public void responseCustomerData(List<CustomerBean.BodyBean> mlist) {
        if(null!=mlist) {
            this.mlist.clear();
            this.mlist.addAll(mlist);
            customerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showMessage(String msg) {
      showToast(msg);
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
    public void loaDareaid(LHouseNumBean info) {
        String orderNumber = info.getBody().getOrderNumber();
        Log.e("tag",orderNumber);

    }
}
