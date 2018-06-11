package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.MessageTwoAdapter;
import com.rxjy.rxcompound.adapter.NewsRedAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.entity.InfoMessageBodyBean;
import com.rxjy.rxcompound.mvp.contract.MessageTwoContract;
import com.rxjy.rxcompound.mvp.presenter.MessageTwoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/18.
 */

public class AdnewsActivity extends BaseActivity <MessageTwoPresenter> implements MessageTwoContract.View {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.ll_message)
    ListView llMessage;
    private List<InfoMessageBodyBean> list;
    NewsRedAdapter newsRedAdapter;
    @Override
    public int getLayout() {
        return R.layout.activity_messagetwo;
    }

    @Override
    public void initData() {
        tvTitle.setText("消息");
        Intent intent=getIntent();
        String groupid=intent.getStringExtra("groupid");
        Log.e("groupid",groupid);
        mPresenter.getInfoMessageTwoList(App.cardNo,groupid);

        ShowListview();
    }
    private void ShowListview(){
        list=new ArrayList<>();
       newsRedAdapter=new NewsRedAdapter(this,list);
       llMessage.setAdapter(newsRedAdapter);
        llMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.toSeeDetails(list.get(position).getId()+"");
                if (list.get(position).getType().equals("1") || list.get(position).getType().equals("2")) {
                    startActivity(new Intent(AdnewsActivity.this, IdentityInfoNewActivity.class));
                } else if (list.get(position).getType().equals("3")) {//入职资料
                    startActivity(new Intent(AdnewsActivity.this, ZThreeActivity.class));
                } else {
                    startActivity(new Intent(AdnewsActivity.this, MessageDetailsActivity.class).putExtra("id", list.get(position).getId() + ""));
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
        newsRedAdapter.notifyDataSetChanged();
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
