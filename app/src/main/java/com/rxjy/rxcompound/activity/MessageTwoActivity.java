package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.MessageTwoAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.entity.InfoMessageBodyBean;
import com.rxjy.rxcompound.mvp.contract.MessageTwoContract;
import com.rxjy.rxcompound.mvp.presenter.MessageTwoPresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/3/9.
 */

public class MessageTwoActivity extends BaseActivity<MessageTwoPresenter> implements MessageTwoContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.ll_message)
    ListView llMessage;

    @Override
    public int getLayout() {
        return R.layout.activity_messagetwo;
    }

    @Override
    public void initData() {
        tvTitle.setText("消息");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String groupid = intent.getStringExtra("groupid");
        Log.e("groupid", groupid);
        Log.e("appcrdno", App.cardNo);
        Log.e("appcrdno", App.regionid + "");
        mPresenter.getInfoMessageTwoList(App.cardNo, groupid);
//        MessageTwoAdapter adapter=new MessageTwoAdapter(this,)
        ShowListview();
    }


    MessageTwoAdapter messageTwoAdapter;
    ArrayList<InfoMessageBodyBean> list;

    private void ShowListview() {
        list = new ArrayList<>();
        messageTwoAdapter = new MessageTwoAdapter(this, list);
        llMessage.setAdapter(messageTwoAdapter);
        llMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.toSeeDetails(list.get(position).getId() + "");
                if (list.get(position).getType().equals("1") || list.get(position).getType().equals("2")) {
                    startActivity(new Intent(MessageTwoActivity.this, IdentityInfoNewActivity.class));
                } else if (list.get(position).getType().equals("3")) {//入职资料
                    startActivity(new Intent(MessageTwoActivity.this, ZThreeActivity.class));
                } else {
                    startActivity(new Intent(MessageTwoActivity.this, MessageDetailsActivity.class).putExtra("id", list.get(position).getId() + ""));
                }
            }
        });
    }

    @Override
    protected MessageTwoPresenter onCreatePresenter() {
        return new MessageTwoPresenter(this);
    }

    @Override
    public void responseInfoMessageTwo(InfoMessageBean data) {
        list.clear();
        list.addAll(data.getBody());
        messageTwoAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseInfoMessageTwoError(String msg) {

    }

    @Override
    public void responseSeeDetails(InfoMessageBean data) {

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


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}