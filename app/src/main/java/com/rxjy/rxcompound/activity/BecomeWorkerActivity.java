package com.rxjy.rxcompound.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.BecomeBean;
import com.rxjy.rxcompound.entity.BeconmeConditionsBean;
import com.rxjy.rxcompound.mvp.contract.BecomeWorkerContract;
import com.rxjy.rxcompound.mvp.presenter.BecomeWorkerPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/18.
 */

public class BecomeWorkerActivity extends BaseActivity<BecomeWorkerPresenter> implements BecomeWorkerContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.duty)
    EditText duty;
    @Bind(R.id.achievement)
    EditText achievement;
    @Bind(R.id.submit)
    Button submit;
    @Bind(R.id.condition)
    TextView condition;
    @Bind(R.id.hiddenDisplay)
    LinearLayout hiddenDisplay;

    @Override
    public int getLayout() {
        return R.layout.activity_become;
    }

    @Override
    public void initData() {
        tvTitle.setText("申请转正");
        mPresenter.getSubmitConditions(App.cardNo);
    }

    @Override
    protected BecomeWorkerPresenter onCreatePresenter() {
        return new BecomeWorkerPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.submit:
                String shuzhi = duty.getText().toString();
                String yeji = achievement.getText().toString();
                if (!shuzhi.equals("") && !yeji.equals("")) {
                    mPresenter.getSubmitBecome(App.cardNo, shuzhi, yeji);
                } else {
                    showToast("转正资料不全");
                }
                break;
        }
    }

    @Override
    public void responseBecomeDataError(String msg) {
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
    public void responseBeconmeConditions(BeconmeConditionsBean.BodyBean bodyBean) {

        // Log.e("===========",applyFormalUserTime);
        //  Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        // String str = formatter.format(curDate);
        //  Long aLong1 = timeStrToSecond(str);
        //请求下来的时间大于当前时间才能提交，否则不能提交

        String applyFormalUserCondition = bodyBean.getApplyFormalUserCondition();
        if (applyFormalUserCondition.equals("")) {
            hiddenDisplay.setVisibility(View.GONE);
            submit.setFocusable(true);
        } else {
            hiddenDisplay.setVisibility(View.VISIBLE);
            String[] split = applyFormalUserCondition.split(";");
            StringBuffer string = new StringBuffer();
            for (int i = 0; i < split.length; i++) {
                string.append(i + 1 + ". " + split[i] + "\n");
            }
            condition.setText(string);
            submit.setFocusable(false);
        }
    }

    @Override
    public void responseBeconmeData(BecomeBean becomeBean) {
    App.ustart=4;
        finish();
    }

    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 将时间转化成毫秒
     * 时间格式: yyyy-MM-dd HH:mm:ss
     *
     * @param time
     * @return
     */
    public static Long timeStrToSecond(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Long second = format.parse(time).getTime();
            return second;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1l;
    }
}
