package com.rxjy.rxcompound.joinin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.activityImage;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.joinin.activity.PersonnelActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/21.
 */

public class JoininMoreFragment extends BaseFragment {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.qingjia_line)
    LinearLayout qingjiaLine;
    @Bind(R.id.zhuanzheng_line)
    LinearLayout zhuanzhengLine;
    @Bind(R.id.matters)
    LinearLayout matters;
    @Bind(R.id.finance)
    LinearLayout finance;
    @Bind(R.id.capital)
    LinearLayout capital;
    @Bind(R.id.affairs)
    LinearLayout affairs;
    @Bind(R.id.main_case)
    LinearLayout mainCase;
    @Bind(R.id.engineering)
    LinearLayout engineering;
    @Bind(R.id.Material_dealer)
    LinearLayout MaterialDealer;
    @Bind(R.id.project_Manager)
    LinearLayout projectManager;
    @Bind(R.id.company)
    LinearLayout company;

    @Override
    protected int getFragmentLayout() {
        return R.layout.joinin_more;
    }

    @Override
    protected void FragmentInitData() {
        tvTitle.setText("瑞祥装饰");
        ivBack.setVisibility(View.GONE);

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

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

    @OnClick({R.id.qingjia_line, R.id.zhuanzheng_line, R.id.matters, R.id.finance, R.id.capital, R.id.affairs, R.id.main_case, R.id.engineering, R.id.Material_dealer, R.id.project_Manager, R.id.company})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qingjia_line:
                break;
            case R.id.zhuanzheng_line:
                break;
            case R.id.matters:
                startActivity(new Intent(getContext(), PersonnelActivity.class));
                break;
            case R.id.finance:
                startActivity(new Intent(getContext(), activityImage.class).putExtra("title","财务"));
                break;
            case R.id.capital:
                startActivity(new Intent(getContext(), activityImage.class).putExtra("title","资金"));
                break;
            case R.id.affairs:
                startActivity(new Intent(getContext(), activityImage.class).putExtra("title","商务"));
                break;
            case R.id.main_case:
                startActivity(new Intent(getContext(), activityImage.class).putExtra("title","主案"));
                break;
            case R.id.engineering:
                startActivity(new Intent(getContext(), activityImage.class).putExtra("title","工程"));
                break;
            case R.id.Material_dealer:

                break;
            case R.id.project_Manager:
                break;
            case R.id.company:
                startActivity(new Intent(getContext(), activityImage.class).putExtra("title","公司"));
                break;
        }
    }
}
