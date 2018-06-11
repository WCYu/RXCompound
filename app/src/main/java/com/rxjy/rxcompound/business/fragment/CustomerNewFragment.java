package com.rxjy.rxcompound.business.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.AddNewActivity;
import com.rxjy.rxcompound.business.adapter.CustomerNewAdapter;
import com.rxjy.rxcompound.business.entity.CustomerNewBean;
import com.rxjy.rxcompound.business.mvp.contract.CustomerNewContract;
import com.rxjy.rxcompound.business.mvp.presenter.CustomerNewPresenter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.widget.MyListview;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/5/11.
 */

public class CustomerNewFragment extends BaseFragment<CustomerNewPresenter> implements CustomerNewContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.lv_customer)
    MyListview lvCustomer;
    @Bind(R.id.pullsv_customer)
    PullToRefreshScrollView pullsvCustomer;

    private ScrollView scrollView;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_customer;
    }


    @Override
    protected void FragmentInitData() {
        tvTitle.setText("客户");
        ivBack.setVisibility(View.GONE);
        tvRight.setText("+");
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setTextSize(30);
    }


    @Override
    public void onResume() {
        super.onResume();
        RequestDate();
    }

    @Override
    protected CustomerNewPresenter onCreatePresenter() {
        return new CustomerNewPresenter(this);
    }


    ArrayList<CustomerNewBean.BodyBean> customerlist;
    @Override
    public void responsegetCustomer(CustomerNewBean data) {
        if (ispulldown == 1) {
            pullsvCustomer.onRefreshComplete();
            ispulldown = 0;
        }
        customerlist = new ArrayList<>();
        customerlist = data.getBody();
        ShowData(data.getBody());
        customerNewAdapter=new CustomerNewAdapter(getActivity(),data.getBody());
        lvCustomer.setAdapter(customerNewAdapter);
    }

    @Override
    public void responsegetCustomerError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetCustomerMore(CustomerNewBean data) {
        if (data.getBody() != null && data.getBody().size() < 10) {
            isload = 1;
        }
        customerlist.addAll(data.getBody());
        customerNewAdapter.notifyDataSetChanged();
        pullsvCustomer.onRefreshComplete();

    }

    @Override
    public void responsegetCustomerMoreError(String msg) {
        showToast(msg);
    }


    /**
     * 显示数据列表
     */
    CustomerNewAdapter customerNewAdapter;
    private void ShowData(final ArrayList<CustomerNewBean.BodyBean> list) {
        customerNewAdapter = new CustomerNewAdapter(getActivity(), list);
        lvCustomer.setAdapter(customerNewAdapter);
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), AddNewActivity.class).putExtra("customerbaseid", list.get(position).getKeHuBaseID() + ""));
            }
        });
    }

    /**
     * 请求数据
     */
    int pageIndex = 1;//页数
    int pageSize = 10;//每页条数
    int ispulldown = 0;//是否刷新  1：是
    int isload = 0;//1:不可加载
    private void RequestDate() {
        mPresenter.getCustomer(App.cardNo, pageSize + "", pageIndex + "");
        pullsvCustomer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex = 1;
                pageSize = 10;
                ispulldown = 1;
                isload = 0;
                mPresenter.getCustomer(App.cardNo, pageSize + "", pageIndex + "");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                if (isload == 1) {
                    showToast("没有更多数据啦!");
                    pullsvCustomer.onRefreshComplete();
                } else {
                    pageIndex = pageIndex + 1;
                    mPresenter.getCustomerMore(App.cardNo, pageSize + "", pageIndex + "");
                }
            }
        });
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({ R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_right:
                startActivity(new Intent(getActivity(), AddNewActivity.class));
                break;
        }
    }
}