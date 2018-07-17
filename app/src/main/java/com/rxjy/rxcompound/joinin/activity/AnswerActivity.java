package com.rxjy.rxcompound.joinin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.des.adapter.AnswerAdapter;
import com.rxjy.rxcompound.des.entity.Person;
import com.rxjy.rxcompound.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/24.
 */

public class AnswerActivity extends BaseActivity {
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
    private AnswerAdapter myAdapter;
    private AnswerAdapter twoAdapter;
    private AnswerAdapter thereAdapter;

    @Override
    public int getLayout() {
        return R.layout.answer_activity;
    }

    @Override
    public void initData() {
        int[] screenSize = getScreenSize(this);
        int heghit = screenSize[0];
        int v = (int) (heghit * 0.6);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) headImage.getLayoutParams(); //取控件textView当前的布局参数
        linearParams.height = v;
        headImage.setLayoutParams(linearParams);
        ivBack.setVisibility(View.INVISIBLE);

        tvTitle.setText("瑞祥装饰");
        datas.add(new Person("无", 14));
        datas.add(new Person("三年以下", 15));
        datas.add(new Person("三年以上", 16));
        datatwo.add(new Person("家装", 17));
        datatwo.add(new Person("公装", 18));
        datatwo.add(new Person("其他", 19));
        datathere.add(new Person("无", 20));
        datathere.add(new Person("10人以上", 21));
        datathere.add(new Person("30人以上", 22));
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
                    currentNum = -1;
                } else if (currentNum != position) { //不是同一个item选中当前的，去除上一个选中的
                    for (Person person : datas) {
                        person.setChecked(false);
                    }
                    datas.get(position).setChecked(true);
                    currentNum = position;
                }
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
                    for (Person person : datathere) {
                        person.setChecked(false);
                    }
                    datathere.get(position).setChecked(true);
                    currentNum = position;
                }
                thereAdapter.notifyDataSetChanged();//刷新adapter
            }
        });
    }


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick(R.id.sunmit)
    public void onViewClicked() {
        StringBuffer stringbuffer = new StringBuffer();
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
                stringbuffer.append(pos.getId() + ",");
                string.append("3");
            }
        }
    Log.e("tag",string.toString());
        if (string.toString().equals("123")) {
            startActivity(new Intent(this, AnswerTwoActivity.class).putExtra("answer", stringbuffer.toString()));
            Log.e("tag", "tag");
            finish();
            Log.e("tag", "-----");
        } else {
            showToast("请答完全部题");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tag","++++++++++++++");
    }

    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }
}
