package com.rxjy.rxcompound.joinin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.des.adapter.AnswerAdapter;
import com.rxjy.rxcompound.des.entity.Person;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.joinin.mvp.contract.AnswerContract;
import com.rxjy.rxcompound.joinin.mvp.presenter.AnswerPresenter;
import com.rxjy.rxcompound.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/24.
 */

public class AnswerThereActivity extends BaseActivity<AnswerPresenter> implements AnswerContract.View {
    @Bind(R.id.Answer_grid)
    MyGridView AnswerGrid;

    List<Person> datas = new ArrayList();//数据集合
    List<Person> datatwo = new ArrayList();//数据集合
    List<Person> datathere = new ArrayList();//数据集合
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.head_image)
    ImageView headImage;
    @Bind(R.id.titile_one)
    TextView titileOne;
    @Bind(R.id.titile_two)
    TextView titileTwo;
    @Bind(R.id.Answer_grid_two)
    MyGridView AnswerGridTwo;
    @Bind(R.id.titile_there)
    TextView titileThere;
    @Bind(R.id.Answer_grid_there)
    MyGridView AnswerGridThere;
    @Bind(R.id.sunmit)
    Button sunmit;
    @Bind(R.id.head_title)
    TextView headTitle;
    private AnswerAdapter myAdapter;
    private AnswerAdapter twoAdapter;
    private AnswerAdapter thereAdapter;
    private String answer;

    @Override
    public int getLayout() {
        return R.layout.answer_activity;
    }

    @Override
    public void initData() {
        answer = getIntent().getStringExtra("answer");
        headTitle.setText("初审/观念");
        headImage.setImageResource(R.mipmap.guannian);
        int[] screenSize = getScreenSize(this);
        int heghit = screenSize[0];
        int v = (int) (heghit * 0.6);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) headImage.getLayoutParams(); //取控件textView当前的布局参数
        linearParams.height = v;
        headImage.setLayoutParams(linearParams);
        sunmit.setText("完成");
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText("瑞祥装饰");
        //地域人脉
        titileOne.setText("1、加盟关注");
        titileTwo.setText("2、经验难点");
        titileThere.setText("3、经验目标");
        datas.add(new Person("品牌", 31));
        datas.add(new Person("发展", 32));
        datas.add(new Person("单元", 33));
        datas.add(new Person("资质", 34));
        datatwo.add(new Person("人员目标", 35));
        datatwo.add(new Person("企业发展", 36));
        datatwo.add(new Person("投资收益", 37));
        datatwo.add(new Person("企业服务", 38));
        datathere.add(new Person("本地立足", 39));
        datathere.add(new Person("年产值20万", 40));
        datathere.add(new Person("大区总代", 41));
        twoAdapter = new AnswerAdapter(this, datatwo);
        thereAdapter = new AnswerAdapter(this, datathere);
        myAdapter = new AnswerAdapter(this, datas);
        AnswerGrid.setAdapter(myAdapter);
        AnswerGridTwo.setAdapter(twoAdapter);
        AnswerGridThere.setAdapter(thereAdapter);

        AnswerGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int currentNum = -1;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (Person person : datas) { //遍历list集合中的数据
                    person.setChecked(false);//全部设为未选中
                }
                if (currentNum == -1) { //选中
                    datas.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum == position) { //同一个item选中变未选中
                    datas.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum != position) { //不是同一个item选中当前的，去除上一个选中的
                    for (Person person : datas) {
                        person.setChecked(false);
                    }
                    datas.get(position).setChecked(true);
                    currentNum = position;
                }
                // Toast.makeText(parent.getContext(),datas.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                myAdapter.notifyDataSetChanged();//刷新adapter
            }
        });
        AnswerGridTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int currentNum = -1;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (Person person : datatwo) { //遍历list集合中的数据
                    person.setChecked(false);//全部设为未选中
                }
                if (currentNum == -1) { //选中
                    datatwo.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum == position) { //同一个item选中变未选中
                    datatwo.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum != position) { //不是同一个item选中当前的，去除上一个选中的
                    for (Person person : datatwo) {
                        person.setChecked(false);

                    }
                    datatwo.get(position).setChecked(true);
                    currentNum = position;
                }
                // Toast.makeText(parent.getContext(),datas.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                twoAdapter.notifyDataSetChanged();//刷新adapter
            }
        });
        AnswerGridThere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int currentNum = -1;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (Person person : datathere) { //遍历list集合中的数据
                    person.setChecked(false);//全部设为未选中
                }
                if (currentNum == -1) { //选中
                    datathere.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum == position) { //同一个item选中变未选中
                    datathere.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum != position) { //不是同一个item选中当前的，去除上一个选中的
                    for (Person person : datas) {
                        person.setChecked(false);
                    }
                    datathere.get(position).setChecked(true);
                    currentNum = position;
                }
                // Toast.makeText(parent.getContext(),datas.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                thereAdapter.notifyDataSetChanged();//刷新adapter
            }
        });
    }

    @Override
    protected AnswerPresenter onCreatePresenter() {
        return new AnswerPresenter(this);
    }

    @OnClick(R.id.sunmit)
    public void onViewClicked() {
        StringBuffer stringbuffer = new StringBuffer(answer);
        StringBuffer string = new StringBuffer();
        for (Person pos : datas) {
            boolean checked = pos.isChecked();
            if (checked) {
                stringbuffer.append(pos.getId() + ",");
                string.append("1");
            }
        }
        for (Person pos : datatwo) {
            boolean checked = pos.isChecked();
            if (checked) {
                stringbuffer.append(pos.getId() + ",");
                string.append("2");
            }
        }
        for (Person pos : datathere) {
            boolean checked = pos.isChecked();
            if (checked) {
                stringbuffer.append(pos.getId());
                string.append("3");
            }
        }
        if (string.toString().equals("123")) {
            Log.e("tag", stringbuffer.toString());
            mPresenter.getAgreeYes(App.cardNo, stringbuffer.toString());
        } else {
            showToast("请答完全部题");
        }
    }

    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }

    @Override
    public void responseAgreeYes() {
        Log.e("tag", App.cardNo + "");
        mPresenter.getConsent(App.cardNo, "5");
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
    public void responseConsent(CheckIsBeingBean data) {

    }

    @Override
    public void responseConsentError(String msg) {
        showToast(msg);
    }

    @Override
    public void showToast() {
        App.is_exist = 6;
        finish();

    }
}
