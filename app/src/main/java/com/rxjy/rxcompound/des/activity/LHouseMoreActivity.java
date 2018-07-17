package com.rxjy.rxcompound.des.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.des.entity.LHouseSubmitBean;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;
import com.rxjy.rxcompound.des.mvp.contract.LHouseMContract;
import com.rxjy.rxcompound.des.mvp.presenter.LHouseMPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by hjh on 2018/4/4.
 */

public class LHouseMoreActivity extends BaseActivity<LHouseMPresenter> implements LHouseMContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ed_cname)
    EditText edCname;
    @Bind(R.id.v_cname)
    TextView vCname;
    @Bind(R.id.ed_phone)
    EditText edPhone;
    @Bind(R.id.v_phone)
    TextView vPhone;
    @Bind(R.id.tv_pname)
    TextView tvPname;
    @Bind(R.id.ed_pname)
    EditText edPname;
    @Bind(R.id.v_pname)
    TextView vPname;
    @Bind(R.id.tv_ptype)
    TextView tvPtype;
    @Bind(R.id.ll_ptype)
    LinearLayout llPtype;
    @Bind(R.id.v_ptype)
    View vPtype;
    @Bind(R.id.tv_pshuxing)
    TextView tvPshuxing;
    @Bind(R.id.ll_pshuxing)
    LinearLayout llPshuxing;
    @Bind(R.id.v_shuxing)
    TextView vShuxing;
    @Bind(R.id.tv_fixtime)
    TextView tvFixtime;
    @Bind(R.id.ll_fixtime)
    LinearLayout llFixtime;
    @Bind(R.id.v_fixtime)
    TextView vFixtime;
    @Bind(R.id.mianji_tv)
    TextView mianjiTv;
    @Bind(R.id.ed_area)
    EditText edArea;
    @Bind(R.id.mi_tv)
    TextView miTv;
    @Bind(R.id.v_area)
    TextView vArea;
    @Bind(R.id.tv_yumoney)
    TextView tvYumoney;
    @Bind(R.id.ed_yumoney)
    EditText edYumoney;
    @Bind(R.id.tv_wan)
    TextView tvWan;
    @Bind(R.id.v_yumoney)
    TextView vYumoney;
    @Bind(R.id.ed_haddress)
    EditText edHaddress;
    @Bind(R.id.v_haddress)
    TextView vHaddress;
    @Bind(R.id.tv_hstatue)
    TextView tvHstatue;
    @Bind(R.id.ll_hstatue)
    LinearLayout llHstatue;
    @Bind(R.id.v_hstatue)
    TextView vHstatue;
    @Bind(R.id.tv_housestatue)
    TextView tvHousestatue;
    @Bind(R.id.ll_housestatue)
    LinearLayout llHousestatue;
    @Bind(R.id.v_housestatue)
    TextView vHousestatue;
    @Bind(R.id.tv_chengjiaotype)
    TextView tvChengjiaotype;
    @Bind(R.id.ll_chengjiaotype)
    LinearLayout llChengjiaotype;
    @Bind(R.id.v_chengjiaotype)
    TextView vChengjiaotype;
    @Bind(R.id.tv_lhousetime)
    TextView tvLhousetime;
    @Bind(R.id.ll_lhousetime)
    LinearLayout llLhousetime;
    @Bind(R.id.v_lhousetime)
    TextView vLhousetime;
    @Bind(R.id.ll_cname)
    LinearLayout llCname;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;

    @Override
    public int getLayout() {
        return R.layout.activity_deshomemore;
    }

    @Override
    public void initData() {
        tvTitle.setText("回头客");
        initLine();
        addData();
    }

    /**
     * 添加数据
     */
    ArrayList<String> housefromlist, houselist, transtypelist, attributelist;

    //    ArrayList<String> housefromlist, houselist, transtypelist, attributelist, progremtypelist;
    private void addData() {
        housefromlist = new ArrayList<>();//房源状态
        housefromlist.add("请选择房源状态");
        housefromlist.add("已定");
        housefromlist.add("未定");

        houselist = new ArrayList<>();//房屋状况
        houselist.add("请选择房屋状况");
        houselist.add("毛坯房");
        houselist.add("清水房");
        houselist.add("旧房改造");
        houselist.add("翻新");
        houselist.add("精装房");

        transtypelist = new ArrayList<>();//成交类型
        transtypelist.add("请选择成交类型");
        transtypelist.add("租");
        transtypelist.add("买");
        transtypelist.add("自建房");

        attributelist = new ArrayList<>();//项目属性
        attributelist.add("请选择项目属性");
        attributelist.add("正常单");
        attributelist.add("看图报价单");
        attributelist.add("设计单");
        attributelist.add("家具单");
        attributelist.add("弱电单");
        attributelist.add("局部改造");

        mPresenter.getProjecttype();
//        progremtypelist=new ArrayList<>();//项目类型
//        progremtypelist.add("请选择类型");
//        progremtypelist.add("办公");
//        progremtypelist.add("餐饮");
//        progremtypelist.add("商业");
//        progremtypelist.add("酒店");
//        progremtypelist.add("其它");
//        progremtypelist.add("教育");
//        progremtypelist.add("会所");
    }

    @Override
    protected LHouseMPresenter onCreatePresenter() {
        return new LHouseMPresenter(this);
    }

    private void initLine() {
        edCname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    vCname.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    vCname.setEnabled(false);
                }
            }
        });
        edPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    vPhone.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    vPhone.setEnabled(false);
                }
            }
        });
        edPname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    vPname.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    vPname.setEnabled(false);
                }
            }
        });
        edArea.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    vArea.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    vArea.setEnabled(false);
                }
            }
        });
        edYumoney.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    vYumoney.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    vYumoney.setEnabled(false);
                }
            }
        });
        edHaddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    vHaddress.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    vHaddress.setEnabled(false);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    private LHouseSubmitBean.clientInfos subdataone;
    private LHouseSubmitBean.clientAuxiliarys subdatatwo;

    int ptypec = 0, ptypetwoc = 0, pshuxingc = 0, hstatec = 0, hfromsc = 0, chengjiaoc = 0;
    private OptionsPickerView ptypePV, pattrPV, hstatePV, hsingstatePV, cjtypePV;
    String clientAuxiliary, clientInfo;
    String zhuangxiutime, liangfangtime;

    @OnClick({R.id.iv_back, R.id.ll_ptype, R.id.ll_pshuxing, R.id.ll_fixtime, R.id.ll_hstatue, R.id.ll_housestatue, R.id.ll_chengjiaotype, R.id.ll_lhousetime, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_ptype:
                if (protypefulist != null && protypezilist != null) {
                    ptypePV = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvPtype.setText(protypelist.get(options1).getMingCheng() + "-" + protypelist.get(options1).getZiji().get(options2).getMingCheng());
                            tvPtype.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                            ptypec = Integer.parseInt(protypelist.get(options1).getID());
                            ptypetwoc = Integer.parseInt(protypelist.get(options1).getZiji().get(options2).getID());
                        }
                    }).build();
                    ptypePV.setPicker(protypefulist, protypezilist);
                    ptypePV.show();
                }
                break;
            case R.id.ll_pshuxing:
                pattrPV = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvPshuxing.setText(attributelist.get(options1));
                        tvPshuxing.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                        pshuxingc = options1;
                    }
                }).build();
                pattrPV.setPicker(attributelist);
                pattrPV.show();
                break;
            case R.id.ll_fixtime:
                TimePickerView fixtimePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String lhousetime = getDateToString(date, "yyyy/MM/dd");
                        tvFixtime.setText(lhousetime);
                        tvFixtime.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                        zhuangxiutime = lhousetime;

                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .build();
                fixtimePickerView.show();
                break;
            case R.id.ll_hstatue:
                hstatePV = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvHstatue.setText(houselist.get(options1));
                        tvHstatue.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                        hstatec = options1;
                    }
                }).build();
                hstatePV.setPicker(houselist);
                hstatePV.show();
                break;
            case R.id.ll_housestatue:
                hsingstatePV = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvHousestatue.setText(housefromlist.get(options1));
                        tvHousestatue.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                        hfromsc = options1;
                    }
                }).build();
                hsingstatePV.setPicker(housefromlist);
                hsingstatePV.show();
                break;
            case R.id.ll_chengjiaotype:
                cjtypePV = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tvChengjiaotype.setText(transtypelist.get(options1));
                        tvChengjiaotype.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                        chengjiaoc = options1;
                    }
                }).build();
                cjtypePV.setPicker(transtypelist);
                cjtypePV.show();
                break;
            case R.id.ll_lhousetime:
                TimePickerView lhousetimePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String lhousetimes = getDateToString(date, "yyyy/MM/dd");
                        tvLhousetime.setText(lhousetimes);
                        tvLhousetime.setTextColor(LHouseMoreActivity.this.getResources().getColor(R.color.textblack));
                        liangfangtime = lhousetimes;

                    }
                }).setType(new boolean[]{true, true, true, false, false, false})
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(16)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setRange(1900, Calendar.YEAR)
                        .isCyclic(true)//是否循环滚动
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .build();
                lhousetimePickerView.show();
                break;
            case R.id.tv_submit:
                subdataone = new LHouseSubmitBean.clientInfos();
                subdatatwo = new LHouseSubmitBean.clientAuxiliarys();
                String cname = edCname.getText().toString();
                String phone = edPhone.getText().toString();
                String pname = edPname.getText().toString();
                String area = edArea.getText().toString();
                String yumoney = edYumoney.getText().toString();
                String lhaddress = edHaddress.getText().toString();
                if (StringUtils.isEmpty(cname)) {
                    showToast("请输入客户姓名！");
                    break;
                }
                if (StringUtils.isEmpty(phone)) {
                    showToast("请输入电话！");
                    break;
                }
                if (phone.length() != 11) {
                    showToast("请输入正确电话！");
                    break;
                }
                if (StringUtils.isEmpty(pname)) {
                    showToast("请输入项目名称！");
                    break;
                }
                if (ptypec == 0) {
                    showToast("请输入项目类型！");
                    break;
                }
                if (pshuxingc == 0) {
                    showToast("请输入项目属性！");
                    break;
                }
                if (StringUtils.isEmpty(zhuangxiutime)) {
                    showToast("请输入装修时间！");
                    break;
                }

                if (StringUtils.isEmpty(area)) {
                    showToast("请输入面积！");
                    break;
                }
                if (StringUtils.isEmpty(yumoney)) {
                    showToast("请输入客户预算！");
                    break;
                }
                if (StringUtils.isEmpty(lhaddress)) {
                    showToast("请输入量房地址！");
                    break;
                }

                if (hstatec == 0) {
                    showToast("请输入房屋状况！");
                    break;
                }
                if (hfromsc == 0) {
                    showToast("请输入房源状态！");
                    break;
                }
                if (chengjiaoc == 0) {
                    showToast("请输入成交类型！");
                    break;
                }

                if (StringUtils.isEmpty(liangfangtime)) {
                    showToast("请输入量房时间！");
                    break;
                }
                subdataone.setCi_proHead(cname);
                subdataone.setCi_proHeadTel(phone);
                subdataone.setCi_ClientName(pname);
                subdataone.setCi_Type(ptypec + "");
                subdataone.setCi_Area(area);
                subdataone.setCi_DecorationAddress(lhaddress);
                subdataone.setCi_DesignerCard(App.cardNo);
                clientInfo = JSONUtils.toString(subdataone);
                Log.e("clientInfo", clientInfo);

                subdatatwo.setCa_proAttribute(pshuxingc + "");
                subdatatwo.setCa_DecorationDate(zhuangxiutime);
                subdatatwo.setCa_DecBudgetPrice(yumoney);
                subdatatwo.setCa_HousingType(hstatec + "");
                subdatatwo.setCa_AvailabilityStatus(hfromsc + "");
                subdatatwo.setCa_TransactionType(chengjiaoc + "");
                subdatatwo.setCa_MeasureDate(liangfangtime);
                subdatatwo.setCa_SWIndustryTypeID(ptypetwoc + "");
                clientAuxiliary = JSONUtils.toString(subdatatwo);
                Log.e("clientAuxiliary", clientAuxiliary);
                mPresenter.GetData(App.regionid, phone);
                tvSubmit.setEnabled(false);
//                mPresenter.submitData(ordernum,clientInfo,clientAuxiliary);

                break;
        }
    }

    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


    String ordernum;

    @Override
    public void responsedata(LHouseNumBean data) {
        ordernum = data.getBody().getOrderNumber();
        mPresenter.submitData(ordernum, clientInfo, clientAuxiliary);
    }

    @Override
    public void responsedataError(String error) {
        tvSubmit.setEnabled(true);
        showToast("该项目已与商务提单重复，提交失败");
    }

    @Override
    public void responsesubmitdata(String msg) {
        showToast("提交成功！");
        finish();
    }

    @Override
    public void responsesubmitdataError(String error) {
        tvSubmit.setEnabled(true);
        showToast(error);
    }


    List<String> protypefulist;
    List<List<String>> protypezilist;
    List<ProjectTypeBean.FatherDataBean> protypelist;

    @Override
    public void responseProjecttype(ProjectTypeBean data) {
        protypefulist = new ArrayList<>();
        protypezilist = new ArrayList<>();
        protypelist = new ArrayList<>();
        protypelist.addAll(data.getBody());
        for (ProjectTypeBean.FatherDataBean fatherDataBean : data.getBody()) {
            protypefulist.add(fatherDataBean.getMingCheng());
            List<String> child = new ArrayList<>();
            for (ProjectTypeBean.FatherDataBean.SonDataBean childbean : fatherDataBean.getZiji()) {
                child.add(childbean.getMingCheng());
            }
            protypezilist.add(child);
        }
    }

    @Override
    public void responseProjecttypeError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}