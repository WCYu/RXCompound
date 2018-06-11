package com.rxjy.rxcompound.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.LeaveSubmitBean;
import com.rxjy.rxcompound.entity.LeaveTypeBean;
import com.rxjy.rxcompound.mvp.contract.LeavePageContract;
import com.rxjy.rxcompound.mvp.presenter.LeavePagePresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/17.
 */

public class LeavePageActivirt extends BaseActivity<LeavePagePresenter> implements LeavePageContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_bank_master)
    TextView etBankMaster;
    @Bind(R.id.et_kaishi)
    TextView etKaishi;
    @Bind(R.id.et_jieshu)
    TextView etJieshu;
    @Bind(R.id.et_zongshichang)
    EditText etZongshichang;
    @Bind(R.id.submit)
    Button submit;
    @Bind(R.id.leave_Reason)
    EditText leaveReason;
    private OptionsPickerView pickerView;
    private TimePickerView timePickerView;
    private Calendar calendar;
    private List<String> mtype;
    List<LeaveTypeBean.BodyBean> bodyBeen;
    private int year;
   private int position;
    private Calendar endDate;

    @Override
    public int getLayout() {
        return R.layout.leave_page;
    }

    @Override
    public void initData() {
        mtype = new ArrayList<>();
        bodyBeen = new ArrayList<>();
        mPresenter.getLeaveData();
        calendar = Calendar.getInstance();
        tvTitle.setText("请假");
//获取系统的日期
//年
        year = calendar.get(Calendar.YEAR);
        calendar.set(year,1,1);//设置结束年份
//月
        int month = calendar.get(Calendar.MONTH) + 1;
//日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
//获取系统时间
//小时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//分钟
        int minute = calendar.get(Calendar.MINUTE);
//秒
        int second = calendar.get(Calendar.SECOND);
        endDate = Calendar.getInstance();
        endDate.set(2050,1,1);//设置结束年份
    }

    @Override
    protected LeavePagePresenter onCreatePresenter() {
        return new LeavePagePresenter(this);
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
    public void showMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void getLeavePageTypeData(List<LeaveTypeBean.BodyBean> bodyBeen) {
        this.bodyBeen.clear();
        this.bodyBeen.addAll(bodyBeen);
    }

    @Override
    public void loadLeaveSubmit(LeaveSubmitBean leaveSubmitBean) {
        showToast(leaveSubmitBean.getStatusMsg());
        finish();
    }

    private boolean[] type = new boolean[]{true, true, true, true, true, false};//显示类型 默认全部显示

    @OnClick({R.id.iv_back, R.id.et_bank_master, R.id.et_kaishi, R.id.et_jieshu, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                closeKeyboard();
                finish();
                break;
            case R.id.et_bank_master:
                closeKeyboard();
                for (LeaveTypeBean.BodyBean mlsit : bodyBeen) {
                    mtype.add(mlsit.getName());
                }
                pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                        etBankMaster.setText(mtype.get(options1));
                        position=options1;
                    }
                }).build();
                pickerView.setPicker(mtype);
                pickerView.show();
                break;
            case R.id.et_kaishi:
                closeKeyboard();
                timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd HH:mm");
                        etKaishi.setText(time);
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(year, Calendar.YEAR)
                        .isCyclic(false)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")

                        .setDate(calendar)
                        .setType(type)
                        .isCenterLabel(true)//是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .setRangDate(calendar,endDate)//起始终止年月日设定
                        .build();
                timePickerView.show();
                break;
            case R.id.et_jieshu:
                closeKeyboard();
                timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = getDateToString(date, "yyyy/MM/dd HH:mm");
                        etJieshu.setText(time);
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(year, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .setDate(calendar)
                        .setType(type)
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .setRangDate(calendar,endDate)//起始终止年月日设定
                        .build();
                timePickerView.show();
                break;
            case R.id.submit:
                closeKeyboard();
                String type = etBankMaster.getText().toString();
                String kaishi = etKaishi.getText().toString();
                String jieshu = etJieshu.getText().toString();
                String day = etZongshichang.getText().toString();

                String reason = leaveReason.getText().toString();
                Log.e("id",bodyBeen.get(position).getId()+"======="+reason);
                Log.e("time",kaishi+"    "+jieshu+"    "+jieshu);
                if (!type.equals("") && !kaishi.equals("") && !jieshu.equals("") && !day.equals("")&&!reason.equals("")) {
                    mPresenter.getpplyAttendance(App.cardNo,kaishi,jieshu,day,reason,bodyBeen.get(position).getId());
                }else {
                    showToast("资料不完整");
                }
                break;
        }
    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


}
