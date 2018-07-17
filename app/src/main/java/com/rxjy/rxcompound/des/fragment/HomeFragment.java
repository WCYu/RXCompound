package com.rxjy.rxcompound.des.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.acker.simplezxing.activity.CaptureActivity;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.DesDaiMeasureActivity;
import com.rxjy.rxcompound.des.activity.JiaoChengListActivity;
import com.rxjy.rxcompound.des.activity.JinduXunjianActivity;
import com.rxjy.rxcompound.des.activity.JungongActivity;
import com.rxjy.rxcompound.des.activity.KaigongjiaodiActivity;
import com.rxjy.rxcompound.des.activity.LHouseMoreActivity;
import com.rxjy.rxcompound.des.activity.OrderGetActivity;
import com.rxjy.rxcompound.des.activity.TalkActivity;
import com.rxjy.rxcompound.des.adapter.HomeAdapter;
import com.rxjy.rxcompound.des.adapter.ZaishiAdapter;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.DesERLoginBean;
import com.rxjy.rxcompound.des.entity.GetZaishiInfo;
import com.rxjy.rxcompound.des.mvp.contract.GetALLClientInfoContract;
import com.rxjy.rxcompound.des.mvp.presenter.GetALLClientInfoPresenter;
import com.rxjy.rxcompound.entity.ErCodeBean;
import com.rxjy.rxcompound.entity.ErCodeTBean;
import com.rxjy.rxcompound.entity.FloatedBean;
import com.rxjy.rxcompound.widget.AutoTextView;
import com.rxjy.rxcompound.widget.MyListview;
import com.rxjy.rxcompound.widget.xlistview.XListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


/**
 * Created by AAA on 2017/7/26.
 */

public class HomeFragment extends BaseFragment<GetALLClientInfoPresenter> implements GetALLClientInfoContract.View, View.OnClickListener, XListView.IXListViewListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.xlv_home_page2)
    MyListview xlv_home_page;
    @Bind(R.id.iv_home_noinfo)
    ImageView ivhome_noinfo;
    @Bind(R.id.tv_home_noinfo)
    TextView tvhome_noinfo;
    @Bind(R.id.tv_more)
    TextView tv_more;
    String phone;
    HomeAdapter adapter;

    public static final String TITLE = "项目跟进";
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.iv_biaoshu)
    ImageView ivBiaoshu;
    @Bind(R.id.ll_jiedan)
    LinearLayout llJiedan;

    int jiedanbs = 0;
    int zaishibs = 0;
    @Bind(R.id.jiedan_jiantou)
    ImageView jiedanJiantou;
    @Bind(R.id.zaishi_jiantou)
    ImageView zaishiJiantou;
    @Bind(R.id.ll_zaishi)
    LinearLayout llZaishi;
    @Bind(R.id.ll_topmore)
    LinearLayout llTopmore;
    @Bind(R.id.tv_moreperson)
    TextView tvMoreperson;
    @Bind(R.id.tv_ercode)
    TextView tvErcode;
    @Bind(R.id.xlv_home_zaishi)
    MyListview xlvHomeZaishi;
    @Bind(R.id.autoTextView)
    AutoTextView autoTextView;
    @Bind(R.id.tv_huitokei)
    TextView tvHuitokei;
    @Bind(R.id.ly_web)
    LinearLayout ly_web;
    @Bind(R.id.home_view)
    WebView newWeb;
    @Bind(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @Bind(R.id.pager)
    ViewPager pager;
    private Handler handler = new Handler();
    private int count = 0;
    private List<FloatedBean> list = new ArrayList<>();
    private AlertDialog alertDialog;

    String url = "http://edu.rxjy.com/a/rs/curaInfo/" + App.cardNo + "01012167/tryPostApp";
    private int[] img;
    private ArrayList<ImageView> arrayList;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void FragmentInitData() {

//        img = new int[]{R.drawable.page1, R.drawable.page2, R.drawable.page3};
//        arrayList = new ArrayList();
//        for (int i = 0; i < img.length; i++) {
//            ImageView imageView = new ImageView(getActivity());
//            imageView.setBackgroundResource(img[i]);
//            arrayList.add(imageView);
//        }
//        pager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return arrayList.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
////                super.destroyItem(container, position, object);
//                container.removeView(arrayList.get(position));
//            }
//
//            @Override
//            public int getItemPosition(Object object) {
//                return super.getItemPosition(object);
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                container.addView(arrayList.get(position));
//                return arrayList.get(position);
//            }
//        });
        if (App.is_group.equals("1") || App.is_group.equals("0")) {
            if (App.ustart != 2 && App.ustart != 3 && App.ustart != 4) {
                ly_web.setVisibility(View.VISIBLE);
                newWeb.loadUrl(url);
                Log.e("webView————————", url);

                WebSettings settings = newWeb.getSettings();
                settings.setJavaScriptEnabled(true);
                newWeb.addJavascriptInterface(new WebViewJump(), "android");
                //设置自适应屏幕，两者合用
                settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
                settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
                settings.setDomStorageEnabled(true);
                newWeb.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });
            } else {
                ly_web.setVisibility(View.GONE);
            }
        } else {
            ly_web.setVisibility(View.GONE);
        }

        if (App.dcid == 3) {
            mPresenter.getFloatedSheet("0");
            autoTextView.setVisibility(View.VISIBLE);
        } else {
            autoTextView.setVisibility(View.GONE);
        }

        phone = App.account;
        initTitle();
//        phone="15810563815";
//        xlv_home_page.setXListViewListener(this);
//        xlv_home_page.setPullLoadEnable(false);
//
//        xlvHomeZaishi.setXListViewListener(new XListView.IXListViewListener() {
//            @Override
//            public void onRefresh() {
//                mPresenter.GetUCList(App.cardNo);
//            }
//
//            @Override
//            public void onLoadMore() {
//
//            }
//        });
//        xlvHomeZaishi.setPullLoadEnable(false);

        initListener();
    }

    private void initListener() {
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh();
                mPresenter.GetUCList(App.cardNo);
                mPresenter.getALLClientInfoNew(phone);
            }
        });
        smartRefresh.setEnableLoadMore(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class WebViewJump {
        @JavascriptInterface
        public void jump() {
            Log.e("tag——", "进入");
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            startActivity(intent);
            getActivity().finish();
        }
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
        /**
         * todo
         */
//        phone = getActivity().getIntent().getStringExtra(Constants.ACTION_TO_MAIN_ACTIVITY);


//        mPresenter.getALLClientInfo(phone);
        mPresenter.getALLClientInfoNew(phone);
        /**
         * todo
         */
        mPresenter.GetUCList(App.cardNo);
        //initData();

        ivBiaoshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JiaoChengListActivity.class));
            }
        });

        llJiedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jiedanbs == 0) {
                    mPresenter.getALLClientInfoNew(phone);
                    xlv_home_page.setVisibility(View.VISIBLE);
                    jiedanJiantou.setImageResource(R.mipmap.jiantouxia);
                    jiedanbs = 1;
                } else if (jiedanbs == 1) {
                    xlv_home_page.setVisibility(View.GONE);
                    jiedanbs = 0;
                }
            }
        });

        llZaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zaishibs == 0) {
                    /**
                     * todo
                     */
                    mPresenter.GetUCList(App.cardNo);
//                    mPresenter.GetUCList("01012694");
                    xlvHomeZaishi.setVisibility(View.VISIBLE);
                    zaishiJiantou.setImageResource(R.mipmap.jiantouxia);
                    zaishibs = 1;
                } else if (zaishibs == 1) {
                    xlvHomeZaishi.setVisibility(View.GONE);
                    zaishibs = 0;
                }
            }
        });
        onclick();
    }

    @Override
    protected GetALLClientInfoPresenter onCreatePresenter() {
        return new GetALLClientInfoPresenter(this);
    }


    int lfandyqbs = 0;

    private void onclick() {
        xlv_home_page.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 1) {
//                    startActivity(new Intent(getActivity(), JiaoChengListActivity.class));
//                } else
//                if (adapter.getItem(position).getRpstate() == 0) {
//                    Intent intent = new Intent(getActivity(), DesDaiMeasureActivity.class);
//                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position));
//                    startActivity(intent);
//                } else if (adapter.getItem(position).getRpstate() == 4) {
//                    Intent intent = new Intent(getActivity(), TalkActivity.class);
//                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position));
//                    startActivity(intent);
//                }
                if (!StringUtils.isEmpty(adapter.getItem(position).getStateName())) {
                    if (adapter.getItem(position).getStateName().equals("待接单")) {
                        startActivity(new Intent(getActivity(), OrderGetActivity.class).putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position)).putExtra("orderid", adapter.getItem(position).getCi_RwdId()));
                    } else if (adapter.getItem(position).getStateName().equals("量房中")) {
                        Intent intent = new Intent(getActivity(), DesDaiMeasureActivity.class);
                        intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position));
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getActivity(), TalkActivity.class);
                        intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position));
                        startActivity(intent);
                    }
                }
//                if (adapter.getItem(position).getRpstate() == 4) {
//                    Intent intent = new Intent(getActivity(), TalkActivity.class);
//                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position));
//                    startActivity(intent);
//                }else{
//                    Intent intent = new Intent(getActivity(), DesDaiMeasureActivity.class);
//                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter.getItem(position));
//                    startActivity(intent);
//                }
            }
        });

        xlvHomeZaishi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (adapter2.getItem(position).getSg_StateName().equals("开工")) {
                    Intent intent = new Intent(getActivity(), KaigongjiaodiActivity.class);
                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter2.getItem(position));
                    startActivity(intent);
                } else if (adapter2.getItem(position).getSg_StateName().equals("竣工")) {
                    Intent intent = new Intent(getActivity(), JungongActivity.class);
                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter2.getItem(position));
                    startActivity(intent);
                } else if (adapter2.getItem(position).getSg_StateName().equals("施工")) {
                    Intent intent = new Intent(getActivity(), JinduXunjianActivity.class);
                    intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, adapter2.getItem(position));
                    startActivity(intent);
                }
            }
        });

        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lfandyqbs == 0) {
                    lfandyqbs = 1;
                    llTopmore.setVisibility(View.VISIBLE);
                } else if (lfandyqbs == 1) {
                    lfandyqbs = 0;
                    llTopmore.setVisibility(View.GONE);
                }
            }
        });
        tvMoreperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lfandyqbs = 0;
                llTopmore.setVisibility(View.GONE);
                startActivity(new Intent(getActivity(), LHouseMoreActivity.class));
            }
        });
        tvErcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lfandyqbs = 0;
                llTopmore.setVisibility(View.GONE);
                QRCodeScan();
            }
        });
    }


    public void initData() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.peixun_title, null);
        xlv_home_page.addHeaderView(v);
    }

    @Override
    public void pagehomelist(List<AllClientInfo.ClientTypeInfo.ClientInfo> list) {


        if (list.size() == 0) {
            llJiedan.setVisibility(View.GONE);
            llZaishi.setVisibility(View.GONE);
            xlv_home_page.setVisibility(View.GONE);
            ivhome_noinfo.setVisibility(View.VISIBLE);
            tvhome_noinfo.setVisibility(View.VISIBLE);
        } else {
//            if (jiedanbs == 1) {
//                xlv_home_page.setVisibility(View.VISIBLE);
//            }
            ivhome_noinfo.setVisibility(View.GONE);
            tvhome_noinfo.setVisibility(View.GONE);
        }
//        adapter = new HomeAdapter(getActivity(), list);
//        xlv_home_page.setAdapter(adapter);

    }

    @Override
    public void pagehomelistnew(final AllClientNewBean data) {

        if (data.getBody().size() == 0) {
            llJiedan.setVisibility(View.GONE);
            llZaishi.setVisibility(View.GONE);
            xlv_home_page.setVisibility(View.GONE);
            ivhome_noinfo.setVisibility(View.VISIBLE);
            tvhome_noinfo.setVisibility(View.VISIBLE);
        } else {
//            if (jiedanbs == 1) {
//                xlv_home_page.setVisibility(View.VISIBLE);
//            }
            ivhome_noinfo.setVisibility(View.GONE);
            tvhome_noinfo.setVisibility(View.GONE);
        }
        adapter = new HomeAdapter(getActivity(), data.getBody());
        xlv_home_page.setAdapter(adapter);
        adapter.toshowercode(new HomeAdapter.ShowERcode() {
            @Override
            public void toshowercode(String orderid) {//显示二维码
                ShowDialog(orderid);
            }
        });
    }

    ZaishiAdapter adapter2;

    @Override
    public void pagehomelist2(List<GetZaishiInfo.BodyBean> info) {
        adapter2 = new ZaishiAdapter(getActivity(), info);
        xlvHomeZaishi.setAdapter(adapter2);
    }

    @Override
    public void responseDesERLoginData() {
        showToast("登录成功！");
    }

    @Override
    public void responseDesERLoginDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
//        xlv_home_page.stopRefresh();
//        xlv_home_page.stopLoadMore();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        xlv_home_page.setRefreshTime(sdf.format(new Date()));
//
//        xlvHomeZaishi.stopRefresh();
//        xlvHomeZaishi.stopLoadMore();
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        xlvHomeZaishi.setRefreshTime(sdf2.format(new Date()));

    }

    //#cor00a0ea
    @Override
    public void getFloatedSheetData(List<FloatedBean> mlist) {
        list.clear();
        list = mlist;
        handler.postDelayed(runnable, 0);
    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            // handler自带方法实现定时器
            try {
                handler.postDelayed(this, 3000);
                autoTextView.next();
                FloatedBean floatedBean = list.get(count % list.size());
                String diquName = floatedBean.getCi_DesignerName();
//                SpannableString spannableString = new SpannableString();
//                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 4,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                double signAmount = floatedBean.getSignAmount();
                if (signAmount < 200000) {
                    String s1 = "" + "<font color='#595757'>" + floatedBean.getCi_ClientName() + "</font>" + "" + "<font color='#0080FF'>" + diquName + "</font>" + "" + "<font color='#595757'>签署完成工单</font>";
                    autoTextView.setText(Html.fromHtml(s1));
                } else {
                    double v = signAmount / 10000;
                    double floor = Math.floor(v);
                    String s = String.valueOf(floor);
                    String substring = s.substring(0, s.length() - 2);
                    Log.e("substring", substring);
                    String s1 = "" + "<font color='#595757'>" + floatedBean.getCi_ClientName() + "</font>" + "" + "<font color='#0080FF'>" + diquName + "</font>" + "" + "<font color='#595757'>签署完成</font>" + "" + "<font color='#0080FF'>" + substring + "万" + "</font>";
                    autoTextView.setText(Html.fromHtml(s1));
                }
                count++;
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    };

    @Override
    public void onRefresh() {
        mPresenter.getALLClientInfoNew(phone);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 扫描二维码
     */
    private static final int REQ_CODE_PERMISSION = 0x1111;

    private void QRCodeScan() {//6.0以上的手机需要处理权限
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Do not have the permission of camera, request it.
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQ_CODE_PERMISSION);
        } else {
            // Have gotten the permission
            startActivityForResult(new Intent(getActivity(), CaptureActivity.class), CaptureActivity.REQ_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // User agree the permission
                    startActivityForResult(new Intent(getActivity(), CaptureActivity.class), CaptureActivity.REQ_CODE);
                } else {
                    // User disagree the permission
                    Toast.makeText(getActivity(), "You must agree the camera permission request before you use the code scan function", Toast.LENGTH_LONG).show();
                }
            }
            break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CaptureActivity.REQ_CODE:
                switch (resultCode) {
                    case RESULT_OK:
                        if (data != null) {
//                            192.168.1.192:8616/bloc/cduan/PhoneLoginController?cardno=&password=
                            Log.e("RESULT_OK=====", data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));
                            String result = data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT);
                            if (!StringUtils.isEmpty(result)) {
                                DesERLoginBean info = JSONUtils.toObject(result, DesERLoginBean.class);
                                SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
                                String pwd = sp.getString("rxdy_pwd", null);
                                mPresenter.DesERLogin(App.cardNo, pwd, info.getUuid());
                            } else {
                                showToast("请扫描正确的二维码！");
                            }
                        }
                        break;
                    case RESULT_CANCELED:
                        if (data != null) {
                            Log.e("RESULT_CANCELED=====", data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));
                        }
                        break;
                }
                break;
        }
    }


    /**
     * 二维码的弹出框
     */
    Dialog dialog;
    View v;
    private ImageView iv_close, iv_ercode;

    private void ShowDialog(String orderid) {
        dialog = new Dialog(getActivity(), R.style.ActionSheetDialogStyle);
        v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_ercode, null);
        dialog.setContentView(v);
        Window dialogwindow = dialog.getWindow();
        dialogwindow.setGravity(Gravity.CENTER);
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogwindow.getAttributes();
        lp.height = (int) (display.getHeight());
        lp.width = (int) (display.getWidth());
        dialogwindow.setAttributes(lp);
        dialog.show();
        iv_close = (ImageView) v.findViewById(R.id.iv_close);
        iv_ercode = (ImageView) v.findViewById(R.id.iv_ercode);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Gson gson = new Gson();
        ErCodeTBean erCodeTBean = new ErCodeTBean();
        erCodeTBean.setOrderNo(orderid);
        ErCodeBean erCodeBean = new ErCodeBean();
        erCodeBean.setEvent("CustomerRegister");
        erCodeBean.setParameter(erCodeTBean);
        String ercodestr = gson.toJson(erCodeBean);
        Log.e("jsondata", ercodestr);
        /**
         * 生成二维码
         * "{"event":"CustomerRegister","parameter":{"orderNo":"xx-xxxxxx"}}"
         */
        Bitmap bitmap = generateBitmap(ercodestr, (int) (display.getWidth() * 0.8), (int) (display.getWidth() * 0.8));
        iv_ercode.setImageBitmap(bitmap);
    }

    private Bitmap generateBitmap(String content, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            int[] pixels = new int[width * height];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (encode.get(j, i)) {
                        pixels[i * width + j] = 0x00000000;
                    } else {
                        pixels[i * width + j] = 0xffffffff;
                    }
                }
            }
            return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @OnClick(R.id.tv_huitokei)
    public void onViewClicked() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.orcode_activity, null);
        ImageView erimg = (ImageView) inflate.findViewById(R.id.activity_image);
        Glide.with(this).load("http://i.rxjy.com/Content/image/appEwm/rx_khpt.png").into(erimg);
        AutoUtils.setSize(getActivity(), false, 720, 1280);
        AutoUtils.auto(inflate);
        dialog.setView(inflate);
        alertDialog = dialog.create();
        alertDialog.show();
    }
}