package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.entity.NumberPackets;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.mvp.contract.GetUserStatusContract;
import com.rxjy.rxcompound.mvp.presenter.GetUserStatusPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心
 * Created by hjh on 2018/1/26.
 */

public class PersonCenterActivity extends BaseActivity<GetUserStatusPresenter> implements GetUserStatusContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
//    @Bind(R.id.gv_data)
//    GridView gvData;

    @Override
    public int getLayout() {
        return R.layout.activity_personcenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        tvTitle.setText("个人资料");
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String cardno = sp.getString("rxdy_cardno", null);
        mPresenter.getUserStatus(cardno);

        initPersonData();
    }

    @Override
    protected GetUserStatusPresenter onCreatePresenter() {
        return new GetUserStatusPresenter(this);
    }


    /**
     * 新个人资料
     */
    private List<Map<String, Object>> ndata_list;
    private SimpleAdapter ndataAdapter;
    private String[] perNames = new String[]{"基础信息", "账户信息", "合同信息"};
    private int[] perIcon = new int[]{R.drawable.ic_more_message, R.drawable.ic_more_account, R.drawable.ic_more_hetong};
    public List<Map<String, Object>> getPersonData() {
        for (int i = 0; i < perNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", perIcon[i]);
            map.put("text", perNames[i]);
            ndata_list.add(map);
        }
        return ndata_list;
    }

    private void initPersonData() {
        ndata_list = new ArrayList<Map<String, Object>>();
        getPersonData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        ndataAdapter = new SimpleAdapter(this, ndata_list, R.layout.item_moreitem, from, to);
//        gvData.setAdapter(ndataAdapter);
//        gvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (i) {
//                    case 0:
//                        startActivity(new Intent(PersonCenterActivity.this, BaseInformationActivity.class).putExtra("isback", "1").putExtra("status", status + ""));
//                        break;
//                    case 1:
//                        if (status > 2) {
//                            startActivity(new Intent(PersonCenterActivity.this, IdentityInfoActivity.class).putExtra("status", status + ""));
//                        } else {
//                            ShowUtils.Toastshort(PersonCenterActivity.this, "请完善基础资料");
//                        }
////                        if(status<=2){
////                            ShowUtils.Toastshort(getActivity(),"请完善基础资料");
////                        }else if(status>=5){
////                            ShowUtils.Toastshort(getActivity(),"入职后不能修改资料,如需修改请联系人事");
////                        }else{
////                            startActivity(new Intent(getActivity(), IdentityInfoActivity.class).putExtra("status", status + ""));
////                        }
//                        break;
//                    case 2:
//                        if (status > 2) {
//                            startActivity(new Intent(PersonCenterActivity.this, EnterJobActivity.class).putExtra("status", status + ""));
//                        } else {
//                            ShowUtils.Toastshort(PersonCenterActivity.this, "请完善基础资料");
//                        }
////                        if(status<=2){
////                            ShowUtils.Toastshort(getActivity(),"请完善基础资料");
////                        }else if(status>=5){
////                            ShowUtils.Toastshort(getActivity(),"入职后不能修改资料,如需修改请联系人事");
////                        }else{
////                            startActivity(new Intent(getActivity(), EnterJobActivity.class).putExtra("status", status + ""));
////                        }
//                        break;
//                }
//            }
//        });
    }


    int status;
    @Override
    public void responseUserStatus(UserStatusBean data) {
        status = data.getBody().getStage();
    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void responseTaskData(NumberPackets.BodyBean mlist) {

    }


    @OnClick({R.id.iv_back, R.id.iv_account, R.id.iv_basezl, R.id.iv_xyzl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_account:
                if (status > 2) {
                    startActivity(new Intent(PersonCenterActivity.this, IdentityInfoActivity.class).putExtra("status", status + ""));
                } else {
                    ShowUtils.Toastshort(PersonCenterActivity.this, "请完善基础资料");
                }
//                        if(status<=2){
//                            ShowUtils.Toastshort(getActivity(),"请完善基础资料");
//                        }else if(status>=5){
//                            ShowUtils.Toastshort(getActivity(),"入职后不能修改资料,如需修改请联系人事");
//                        }else{
//                            startActivity(new Intent(getActivity(), IdentityInfoActivity.class).putExtra("status", status + ""));
//                        }
                break;
            case R.id.iv_basezl:
                startActivity(new Intent(PersonCenterActivity.this, BaseInformationActivity.class).putExtra("isback", "1").putExtra("status", status + ""));
                break;
            case R.id.iv_xyzl:
                if (status > 2) {
                    startActivity(new Intent(PersonCenterActivity.this, EnterJobActivity.class).putExtra("status", status + ""));
                } else {
                    ShowUtils.Toastshort(PersonCenterActivity.this, "请完善基础资料");
                }
//                        if(status<=2){
//                            ShowUtils.Toastshort(getActivity(),"请完善基础资料");
//                        }else if(status>=5){
//                            ShowUtils.Toastshort(getActivity(),"入职后不能修改资料,如需修改请联系人事");
//                        }else{
//                            startActivity(new Intent(getActivity(), EnterJobActivity.class).putExtra("status", status + ""));
//                        }
            break;
        }
    }
}