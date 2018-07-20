package com.rxjy.rxcompound.fragment;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.acker.simplezxing.activity.CaptureActivity;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.CustomerActivity;
import com.rxjy.rxcompound.activity.QrLoginActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.entity.DesERLoginBean;
import com.rxjy.rxcompound.entity.QRresultWebBean;
import com.rxjy.rxcompound.supervision.fragment.ProjectFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * Created by asus on 2018/4/13.
 */

public class HomeNewFragment extends BaseFragment {


    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.lv_add)
    ImageView lvAdd;
    @Bind(R.id.ly_web)
    LinearLayout ly_web;
    @Bind(R.id.home_view)
    WebView newWeb;
   private boolean aBoolean=true;
    String url ="http://edu.rxjy.com/a/rs/curaInfo/"+App.cardNo+"/tryPostApp?appId="+App.app_id;
    private Fragment currentFragment;
    private ProjectFragment projectFragment;
    private CustomerFragment customerFragment;
    //碎片的集合
    private List<Fragment> fragmentList;
    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int MORE_FRAGMENT = 1;
    private FragmentManager manager;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new;
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

        if (projectFragment == null) {
            projectFragment = new ProjectFragment();
        }
        if (customerFragment == null) {
            customerFragment = new CustomerFragment();
        }
        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        fragmentList.add(projectFragment);
        fragmentList.add(customerFragment);
        manager = getChildFragmentManager();
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
        //showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb0:
                        aBoolean=true;
                        lvAdd.setVisibility(View.VISIBLE);
                        lvAdd.setImageResource(R.mipmap.scan_pc);
                        FragmentTransaction action = manager.beginTransaction();
                        if (!projectFragment.isAdded()) {
                            action.add(R.id.lv_home, projectFragment);
                        }
                        if (customerFragment != null) {
                            action.hide(customerFragment);
                        }
                        action.show(projectFragment);
                        action.commit();
                        break;
                    case R.id.rb1:
                        aBoolean=false;
                        //Toast.makeText(getContext(), "=======", Toast.LENGTH_SHORT).show();
                        lvAdd.setVisibility(View.VISIBLE);
                        lvAdd.setImageResource(R.mipmap.add_icon);
                        FragmentTransaction actiontwo = manager.beginTransaction();
                        if (!customerFragment.isAdded()) {
                            actiontwo.add(R.id.lv_home, customerFragment);
                        }
                        if (projectFragment != null) {
                            actiontwo.hide(projectFragment);
                        }
                        actiontwo.show(customerFragment);
                        actiontwo.commit();
                        break;

                }
            }
        });


    }

    class WebViewJump{
        @JavascriptInterface
        public void jump() {
            Log.e("tag——","进入");
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            startActivity(intent);
            getActivity().finish();
        }
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */


    private void showFragment(Fragment fragment, int position) {
        JumpFragment(fragment);

    }
    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.lv_home, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
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
    @OnClick(R.id.lv_add)
    public void onViewClicked() {
        if(aBoolean){
            QRCodeScan();
        }else {
            Intent intent=new Intent(getContext(), CustomerActivity.class);
            startActivity(intent);
        }

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
                            try {


                            if (!StringUtils.isEmpty(result)) {
                                if (result.contains("event")) {
                                    QRresultWebBean info = JSONUtils.toObject(result, QRresultWebBean.class);
                                    String biaoshi = info.getParameter().getLogin_id();
                                    if (biaoshi != null || info.getParameter().getApp_id() == 3) {
                                        startActivity(new Intent(getActivity(), QrLoginActivity.class).putExtra("appid", biaoshi));
                                    } else {
                                        showToast("请扫描正确的二维码！");
                                    }
                                }else {
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
}
