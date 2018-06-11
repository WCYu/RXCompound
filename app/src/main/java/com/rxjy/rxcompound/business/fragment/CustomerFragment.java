package com.rxjy.rxcompound.business.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.AddActivity;
import com.rxjy.rxcompound.business.adapter.CustomerAdapter;
import com.rxjy.rxcompound.business.adapter.CustomerAdapters;
import com.rxjy.rxcompound.business.entity.CustomerBean;
import com.rxjy.rxcompound.business.entity.MyGradeBean;
import com.rxjy.rxcompound.business.mvp.contract.CustomerContract;
import com.rxjy.rxcompound.business.mvp.presenter.CustomerPresenter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/23.
 */

public class CustomerFragment extends BaseFragment<CustomerPresenter> implements CustomerContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.lv_customer)
    ListView lvCustomer;
    @Bind(R.id.pullsv_customer)
    PullToRefreshScrollView pullsv_customer;
    private ScrollView scrollView;
    private String cardno;
    public static CustomerFragment instance = null;
    public String ischange = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_customer;
    }


    String key = "";
    @Override
    protected void FragmentInitData() {
        instance = this;
//        SharedPreferences sp = getActivity().getSharedPreferences("rxsw_userdatas", Activity.MODE_PRIVATE);
//        cardno = sp.getString("rxsw_cardno", null);
        cardno=App.cardNo;
        ivBack.setVisibility(View.GONE);
        tvTitle.setText("客户");
        tvRight.setText("+");
        tvRight.setTextSize(30);
        tvRight.setVisibility(View.VISIBLE);
        scrollView = pullsv_customer.getRefreshableView();
        editText.addTextChangedListener(new MyEditListener(editText));
        RequestDate();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ischange.equals("1")) {
            ischange = "";
            mPresenter.getCustomer(cardno, "1", pageSize + "", key);
        }
    }

    /**
     * 请求数据
     */
    int pageIndex = 1;//页数
    int pageSize = 10;//每页条数
    int ispulldown = 0;//是否刷新  1：是
    int isload = 0;//1:不可加载
    private void RequestDate() {
        mPresenter.getCustomer(cardno, pageIndex + "", pageSize + "", key);
        pullsv_customer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex = 1;
                pageSize = 10;
                ispulldown = 1;
                isload = 0;
                mPresenter.getCustomer(cardno, pageIndex + "", pageSize + "", key);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                if (isload == 1) {
                    Toast.makeText(getActivity(), "没有更多数据啦！", Toast.LENGTH_SHORT).show();
                    pullsv_customer.onRefreshComplete();
                } else {
                    pageIndex = pageIndex + 1;
                    mPresenter.getCustomerMore(cardno, pageIndex + "", pageSize + "", key);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected CustomerPresenter onCreatePresenter() {
        return new CustomerPresenter(this);
    }


    ArrayList<CustomerBean.BodyBean> customerlist;
    @Override
    public void responsegetCustomer(CustomerBean data) {
        if (ispulldown == 1) {
            pullsv_customer.onRefreshComplete();
            ispulldown = 0;
        }
        customerlist = new ArrayList<>();
        customerlist = data.getBody();
        ShowData(data.getBody());
    }

    @Override
    public void responsegetCustomerError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetCustomerMore(CustomerBean data) {
        if (data.getBody() != null && data.getBody().size() < 10) {
            isload = 1;
        }
        customerlist.addAll(data.getBody());
        customerAdapter.notifyDataSetChanged();
        pullsv_customer.onRefreshComplete();

    }

    @Override
    public void responsegetCustomerMoreError(String msg) {
        showToast(msg);
    }

    /**
     * 显示数据列表
     */
    CustomerAdapters customerAdapter;
    private void ShowData(final ArrayList<CustomerBean.BodyBean> list) {
        customerAdapter = new CustomerAdapters(getActivity(), list);
        lvCustomer.setAdapter(customerAdapter);
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), AddActivity.class).putExtra("customerbaseid", list.get(position).getKeHuBaseID() + ""));
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

    @OnClick(R.id.tv_right)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), AddActivity.class));
    }

    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }

        @Override
        public void afterTextChanged(Editable arg0) {
            int lengths = arg0.length();
            switch (edittext.getId()) {
                case R.id.editText:
                    pageIndex = 1;
                    key = edittext.getText().toString();
                    mPresenter.getCustomer(cardno, pageIndex + "", pageSize + "", key);
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
            // TODO Auto-generated method stub
        }
    }




    private void Test() {
        String title="";
        String txt="";
    }
}
