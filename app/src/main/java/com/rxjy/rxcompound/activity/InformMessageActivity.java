package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.InformMessageAdapter;
import com.rxjy.rxcompound.adapter.MessageNewAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.mvp.contract.InfoMessageContract;
import com.rxjy.rxcompound.mvp.presenter.InfoMessagePresenter;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/21.
 */

public class InformMessageActivity extends BaseActivity<InfoMessagePresenter> implements InfoMessageContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.lv_infomessage)
    ListView lv_infomessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_informmessage;
    }

    @Override
    public void initData() {
        tvTitle.setText("消息");
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String cardno = sp.getString("rxdy_cardno", null);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getInfoMessageList(App.cardNo);
    }

    @Override
    protected InfoMessagePresenter onCreatePresenter() {
        return new InfoMessagePresenter(this);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    InformMessageAdapter informMessageAdapter;
    MessageNewAdapter messageNewAdapter;

    @Override
    public void responseInfoMessage(final InfoMessageBean data) {

//        informMessageAdapter=new InformMessageAdapter(this,data.getBody());
        messageNewAdapter = new MessageNewAdapter(this, data.getBody());
        lv_infomessage.setAdapter(messageNewAdapter);
        lv_infomessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //查看二级页面

//                if (!data.getBody().get(position).getState().equals("1")) {
//                    mPresenter.toSeeDetails(data.getBody().get(position).getId() + "");
//                    data.getBody().get(position).setState("1");
//                }
//                if (!StringUtils.isEmpty(data.getBody().get(position).getType())) {
//                    int type = Integer.parseInt(data.getBody().get(position).getType());
//                    if (type == 1 || type == 2) {
//                        startActivity(new Intent(InformMessageActivity.this, IdentityInfoActivity.class));
//                    } else if (type == 3) {//入职资料
//                        startActivity(new Intent(InformMessageActivity.this, EnterJobActivity.class));
//                    }else{

                if(position==0||position==1||position==2){
                    if (!StringUtils.isEmpty(data.getBody().get(position).getGroup()))
                        startActivity(new Intent(InformMessageActivity.this, MessageTwoActivity.class).putExtra("groupid", data.getBody().get(position).getGroup()));
                }else {
                        if (!StringUtils.isEmpty(data.getBody().get(position).getGroup()))
                            startActivity(new Intent(InformMessageActivity.this, AdnewsActivity.class).putExtra("groupid", data.getBody().get(position).getGroup()));
                    }
//                }
                }
//                        if (!StringUtils.isEmpty(data.getBody().get(position).getGroup()))
//                            startActivity(new Intent(InformMessageActivity.this, MessageTwoActivity.class).putExtra("groupid", data.getBody().get(position).getGroup()));
//                    }
//                }
      //      }
        });
    }

    @Override
    public void responseInfoMessageError(String msg) {

    }

    @Override
    public void responseSeeDetails(InfoMessageBean data) {
//        informMessageAdapter.notifyDataSetChanged();
        messageNewAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseSeeDetailsError(String msg) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
}