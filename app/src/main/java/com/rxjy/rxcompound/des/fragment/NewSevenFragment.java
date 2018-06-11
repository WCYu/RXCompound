package com.rxjy.rxcompound.des.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;
import com.rxjy.rxcompound.des.entity.NewSevenInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewSevenContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewSevenPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NewSevenFragment extends BaseFragment<NewSevenPresenter> implements NewSevenContract.View {

    @Bind(R.id.et_new_loupan)
    EditText etNewLoupan;
    @Bind(R.id.et_new_qizuo)
    EditText etNewQizuo;
    @Bind(R.id.et_new_louceng)
    EditText etNewLouceng;
    @Bind(R.id.et_new_menpaihao)
    EditText etNewMenpaihao;
    @Bind(R.id.btn_des_dai_measure_sub)
    Button btnDesDaiMeasureSub;
    //客户信息
//    private AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;
    private AllClientNewBean.ClientNewBean clientInfo;

    private String loupan;
    private String qizuo;
    private String louceng;
    private String menpaihao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    //    public void setClientInfo(AllClientInfo.ClientTypeInfo.ClientInfo info) {
//        clientInfo = info;
//    }
    public void setClientInfo(AllClientNewBean.ClientNewBean info) {
        clientInfo = info;
    }

    /**
     * 获取到的量房信息
     */
    private DesDaiMeasureABean.BodyBean lhousedata; //量房详情信息

    public void setLHouseData(DesDaiMeasureABean.BodyBean bean) {
        lhousedata = bean;
        Log.e("获取到。。获取到的量房信息", "并显示");
    }

    private void ShowView(DesDaiMeasureABean.BodyBean info) {

        etNewLoupan.setText(info.getCa_RealEstate());
        etNewQizuo.setText(info.getCa_RealEstatePeriod());
        etNewLouceng.setText(info.getCa_DevelopmentFloor());
        etNewMenpaihao.setText(info.getCa_HouseNumber());
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_seven;
    }


    @Override
    protected void FragmentInitData() {
//        mPresenter.GetNewSeven(clientInfo.getCi_rwdid());
        ShowView(lhousedata);

        btnDesDaiMeasureSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loupan = etNewLoupan.getText().toString().trim();
                qizuo = etNewQizuo.getText().toString().trim();
                louceng = etNewLouceng.getText().toString().trim();
                menpaihao = etNewMenpaihao.getText().toString().trim();

                bodyInfo.setCa_RealEstate(loupan);
                bodyInfo.setCa_RealEstatePeriod(qizuo);
                bodyInfo.setCa_DevelopmentFloor(louceng);
                bodyInfo.setCa_HouseNumber(menpaihao);


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {

                        String info = JSONUtils.toString(bodyInfo);
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(), info, "楼盘");


                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
            }
        });
    }

    @Override
    protected NewSevenPresenter onCreatePresenter() {
        return new NewSevenPresenter(this);
    }

    private NewSevenInfo.BodyBean bodyInfo;

    @Override
    public void responseGetNewSeven(NewSevenInfo.BodyBean info) {
        bodyInfo = info;
        etNewLoupan.setText(info.getCa_RealEstate());
        etNewQizuo.setText(info.getCa_RealEstatePeriod());
        etNewLouceng.setText(info.getCa_DevelopmentFloor());
        etNewMenpaihao.setText(info.getCa_HouseNumber());

    }

    @Override
    public void responseGetNewSevenError(String msg) {
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
        showToast(upNewXinXi.getStatusMsg());
    }

    @Override
    public void responseUpNewOneError(String msg) {
        showToast(msg);
    }

}
