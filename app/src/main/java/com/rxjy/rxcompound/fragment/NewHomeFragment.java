package com.rxjy.rxcompound.fragment;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.acker.simplezxing.activity.CaptureActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.BannerDetailsActivity;
import com.rxjy.rxcompound.activity.QrLoginActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.GlideRoundTransform;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.entity.DesERLoginBean;
import com.rxjy.rxcompound.entity.BannerBean;
import com.rxjy.rxcompound.entity.BannerDataBean;
import com.rxjy.rxcompound.entity.EduDataBean;
import com.rxjy.rxcompound.entity.QRresultWebBean;
import com.rxjy.rxcompound.entity.TaskListBean;
import com.rxjy.rxcompound.mvp.contract.HomePageFContract;
import com.rxjy.rxcompound.mvp.model.HomePageFModel;
import com.rxjy.rxcompound.mvp.presenter.HomePageFPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewHomeFragment extends BaseFragment<HomePageFPresenter> implements HomePageFContract.View {


    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.publish)
    ImageView publish;
    @Bind(R.id.rl_findtop)
    RelativeLayout rlFindtop;
    @Bind(R.id.vp_banner)
    ViewPager vpBanner;
    @Bind(R.id.ly_web)
    LinearLayout ly_web;
    @Bind(R.id.home_view)
    WebView newWeb;

    String url = "http://edu.rxjy.com/a/rs/curaInfo/" + App.cardNo + "/tryPostApp?appId=" + App.app_id;
    int index = 0;
    int size = 0;
    String phonenum, cardno;
    private PagerAdapter pagerAdapter;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 4) {
                if (index >= size) index = 0;
                if (vpBanner != null) {
                    vpBanner.setCurrentItem(index++);
                    handler.sendEmptyMessageDelayed(4, 3000);
                } else {
                    handler.removeMessages(4);
                }
            }
        }

    };

    public NewHomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_home;
    }

    @Override
    protected void FragmentInitData() {

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

        cardno = "00001236";
        HomePageFModel mModel = new HomePageFModel();
        Subscription subscribe = mModel.getBannerList("00001236")
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
//                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
//                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取banner失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("banner数据显示。。。。", s.toString());
                        BannerBean info = JSONUtils.toObject(s, BannerBean.class);
                        ShowBanner(info.getBody());
                    }
                });
//        addSubscribe(subscribe);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QRCodeScan();
            }
        });
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
                            try {
                                String result = data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT);
                                if (!StringUtils.isEmpty(result)) {
                                    if (result.contains("event")) {
                                        QRresultWebBean info = JSONUtils.toObject(result, QRresultWebBean.class);
                                        String biaoshi = info.getParameter().getLogin_id();
                                        if (biaoshi != null || info.getParameter().getApp_id() == 3) {
                                            startActivity(new Intent(getActivity(), QrLoginActivity.class).putExtra("appid", biaoshi));
                                        } else {
                                            showToast("请扫描正确的二维码！");
                                        }
                                    } else {
                                        showToast("本平台暂不支持其他二维码扫描！");
                                    }

                                } else {
                                    showToast("请扫描正确的二维码！");
                                }
                            } catch (Exception e) {
                                showToast("本平台暂不支持其他二维码扫描！");
                                e.printStackTrace();
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

    class WebViewJump {
        @JavascriptInterface
        public void jump() {
            Log.e("tag——", "进入");
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            startActivity(intent);
            getActivity().finish();
        }
    }

    private void ShowBanner(final ArrayList<BannerDataBean> datalist) {

        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return datalist.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                View view = View.inflate(getActivity(), R.layout.vp_bannerview, null);
                ImageView iv_bannerimg = (ImageView) view.findViewById(R.id.iv_bannerimg);
                TextView tv_bannerdescribe = (TextView) view.findViewById(R.id.tv_bannerdescribe);
                TextView tv_bannertodetails = (TextView) view.findViewById(R.id.tv_bannertodetails);
                RequestOptions options = new RequestOptions();
                options.centerCrop().transform(new GlideRoundTransform(getActivity(), 10));
                Glide.with(getActivity()).load(datalist.get(position).getBanner_img()).apply(options).into(iv_bannerimg);
                tv_bannerdescribe.setText(datalist.get(position).getBanner_title());
                tv_bannertodetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), BannerDetailsActivity.class).putExtra("url", datalist.get(position).getBanner_content()));
                    }
                });
                iv_bannerimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), BannerDetailsActivity.class).putExtra("url", datalist.get(position).getBanner_content()));
                    }
                });
                container.addView(view);
                return view;
            }
        };
        vpBanner.setAdapter(pagerAdapter);
        vpBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        handler.sendEmptyMessageDelayed(4, 3000);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected HomePageFPresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void responseBannerData(BannerBean data) {

    }

    @Override
    public void responseBannerDataError(String msg) {

    }

    @Override
    public void responseEduData(EduDataBean data) {

    }

    @Override
    public void responseEduDataError(String msg) {

    }

    @Override
    public void responseTaskData(TaskListBean data) {

    }

    @Override
    public void responseTaskDataError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
