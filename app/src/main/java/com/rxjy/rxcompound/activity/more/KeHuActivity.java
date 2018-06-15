package com.rxjy.rxcompound.activity.more;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.WebViewActivity;
import com.rxjy.rxcompound.adapter.more.KeHuAdapter;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.activity.AddActivity;
import com.rxjy.rxcompound.business.activity.CustomerFollowActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.more.KeHuInfoBean;
import com.rxjy.rxcompound.entity.more.KeHuTongJiBean;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/*
* 客户列表
* */
public class KeHuActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.img_gengduo)
    ImageView imgGengduo;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    ImageView tvRight;
    @Bind(R.id.listView)
    SwipeMenuListView listView;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.rl_back)
    RelativeLayout ltBackground;

    private ArrayList<KeHuInfoBean.BodyBean> arrayList;
    public KeHuAdapter keHuAdapter;
    private PopupWindow popupWindow;

    int type = 0;
    int pager = 1;
    String key = "";
    private TextView tv_zaigen;
    private LinearLayout ly_zaigen;

    private LinearLayout ly_zaitan;
    private TextView tv_zaitan;

    private TextView tv_dahui;
    private LinearLayout ly_dahui;

    private TextView tv_weiqian;
    private LinearLayout ly_weiqian;

    private TextView tv_yiqian;
    private LinearLayout ly_yiqian;

    private LinearLayout ly_shenpi;
    private TextView tv_shenpi;

    private void initPopuView(View vicinityView) {
        tv_zaigen = (TextView) vicinityView.findViewById(R.id.tv_zaigen);
        ly_zaigen = (LinearLayout) vicinityView.findViewById(R.id.ly_zaigen);
        ly_zaigen.setOnClickListener(this);
        ly_zaitan = (LinearLayout) vicinityView.findViewById(R.id.ly_zaitan);
        tv_zaitan = (TextView) vicinityView.findViewById(R.id.tv_zaitan);
        ly_zaitan.setOnClickListener(this);
        tv_dahui = (TextView) vicinityView.findViewById(R.id.tv_dahui);
        ly_dahui = (LinearLayout) vicinityView.findViewById(R.id.ly_dahui);
        ly_dahui.setOnClickListener(this);
        tv_weiqian = (TextView) vicinityView.findViewById(R.id.tv_weiqian);
        ly_weiqian = (LinearLayout) vicinityView.findViewById(R.id.ly_weiqian);
        ly_weiqian.setOnClickListener(this);
        tv_yiqian = (TextView) vicinityView.findViewById(R.id.tv_yiqian);
        ly_yiqian = (LinearLayout) vicinityView.findViewById(R.id.ly_yiqian);
        ly_yiqian.setOnClickListener(this);
        ly_shenpi = (LinearLayout) vicinityView.findViewById(R.id.ly_shenpi);
        tv_shenpi = (TextView) vicinityView.findViewById(R.id.tv_shenpi);
        ly_shenpi.setOnClickListener(this);

        getKeHuData();

    }

    @Override
    public int getLayout() {
        return R.layout.activity_ke_hu;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        arrayList = new ArrayList<>();
        keHuAdapter = new KeHuAdapter(this, arrayList);
        listView.setAdapter(keHuAdapter);
        initList();
        initListener();
        editText.addTextChangedListener(new MyEditListener(editText));
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLoading();
        type = 0;
        pager = 1;
        key = "";
        arrayList.clear();
        getKuHuList();
        View inflate = LayoutInflater.from(this).inflate(R.layout.popu_item_kehu, null);
        popupWindow(inflate, rlTool);
    }

    private void initListener() {
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh();
                type = 0;
                pager = 1;
                key = "";
                arrayList.clear();
                getKuHuList();
            }
        });
        smartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore();
                getKuHuList();
            }
        });
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        callPhone(arrayList.get(position).getShouJiHaoYi());
                        break;
                    case 1:
                        // delete
                        startActivity(new Intent(KeHuActivity.this, CustomerFollowActivity.class)
                                .putExtra("customerid", arrayList.get(position).getKeHuBaseID() + "")
                                .putExtra("saleid", arrayList.get(position).getYeWuYuanID() + ""));
                        break;
                    case 2:
                        // delete
                        new AlertDialog.Builder(KeHuActivity.this).setTitle("放弃后此单将删除").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteKuHu(arrayList.get(position).getKeHuBaseID());
                                dialog.dismiss();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
// Left
        listView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String status = arrayList.get(position).getStatus();
                Intent intent = null;
                if (!TextUtils.isEmpty(status)) {
//                   ToastUtil.getInstance().toastCentent(status,KeHuActivity.this);
                    switch (status) {
                        case "在跟踪":
//                           intent = new Intent(KeHuActivity.this,ZaiGenActivity.class);
//                           break;
                        case "审核":
                        case "打回":
                            intent = new Intent(KeHuActivity.this, WebViewActivity.class);
                            intent.putExtra("url", "http://app.rxjy.com/customer.html?order=22-201349");
                            intent.putExtra("name", "量房");
                            break;
                        case "在谈":
                        case "已签":
                        case "未签":
                            int keHuBaseID = arrayList.get(position).getKeHuBaseID();
                            intent = new Intent(KeHuActivity.this, ZaiTanActivity.class);
                            intent.putExtra("id", keHuBaseID);
                            break;
                    }
                } else {
                    ToastUtil.getInstance().toastCentent("未获取到当前状态", KeHuActivity.this);
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    //放弃客户
    private void deleteKuHu(int id) {
        Map map = new HashMap();
        map.put("id", id);
        OkhttpUtils.doPost(ApiEngine.DELETEURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_放弃客户", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_放弃客户", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            String statusMsg = jsonObject.getString("StatusMsg");
                            if (statusCode == 0) {
                                pager = 1;
                                key = "";
                                arrayList.clear();
                                getKuHuList();
                            } else {
                                ToastUtil.getInstance().toastCentent(statusMsg, KeHuActivity.this);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }


    private void popupWindow(View vicinityView, View view) {

        popupWindow = new PopupWindow(vicinityView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initPopuView(vicinityView);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });

    }


    public void callPhone(String phoneNumber) {
        try {
            Intent Intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + phoneNumber));//跳转到拨号界面，同时传递电话号码
            startActivity(Intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initList() {

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xD7, 0xE2,
                        0x59)));
                // set item width
                openItem.setWidth(190);
                // set item title
                openItem.setTitle("电话");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xFF,
                        0xC1, 0x07)));
                // set item width
                deleteItem.setWidth(190);
                // set a icon
                deleteItem.setTitle("回访");
                deleteItem.setTitleSize(18);
                // set item title font color
                deleteItem.setTitleColor(Color.WHITE);
//                deleteItem.setIcon(R.drawable.ic_launcher_background);
                // add to menu
                menu.addMenuItem(deleteItem);

                SwipeMenuItem genZongItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                genZongItem.setBackground(new ColorDrawable(Color.rgb(0xD3,
                        0x2E, 0x2F)));
                // set item width
                genZongItem.setWidth(190);
                // set a icon
                genZongItem.setTitle("放弃");
                genZongItem.setTitleSize(18);
                // set item title font color
                genZongItem.setTitleColor(Color.WHITE);
//                deleteItem.setIcon(R.drawable.ic_launcher_background);
                // add to menu
                menu.addMenuItem(genZongItem);
            }
        };
        listView.setMenuCreator(creator);
    }

    public void getKeHuData() {
        Map map = new HashMap();
        map.put("card", App.cardNo);
        map.put("type", -1);
        OkhttpUtils.doPost("http://swb.api.cs/AppEmployee/GetAdvserCustomStatusCount", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_数据统计_失败", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_数据统计", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            int statusCode = jsonObject.getInt("StatusCode");
                            String statusMsg = jsonObject.getString("StatusMsg");
                            if (statusCode == 0) {
                                Gson gson = new Gson();
                                KeHuTongJiBean keHuTongJiBean = gson.fromJson(string, KeHuTongJiBean.class);
                                List<KeHuTongJiBean.BodyBean> body = keHuTongJiBean.getBody();
                                for (int i = 0; i < body.size(); i++) {
                                    KeHuTongJiBean.BodyBean bodyBean = body.get(i);
                                    String status = bodyBean.getStatus();
                                    switch (status) {
                                        case "在跟踪":
                                            tv_zaigen.setText("在跟/" + bodyBean.getNum());
                                            break;
                                        case "打回":
                                            tv_dahui.setText("打回/" + bodyBean.getNum());
                                            break;
                                        case "审批":
                                            tv_shenpi.setText("审批/" + bodyBean.getNum());
                                            break;
                                        case "在谈":
                                            tv_zaitan.setText("在谈/" + bodyBean.getNum());
                                            break;
                                        case "已签":
                                            tv_yiqian.setText("已签/" + bodyBean.getNum());
                                            break;
                                        case "未签":
                                            tv_weiqian.setText("未签/" + bodyBean.getNum());
                                            break;
                                    }
                                }
                            } else {
                                ToastUtil.getInstance().toastCentent(statusMsg, KeHuActivity.this);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void getKuHuList() {
        Map map = new HashMap();
        map.put("card", "02700552 ");
        map.put("pageIndex", pager);
        map.put("PageSize", 10);
        map.put("type", type);
        map.put("key", key);
//        ToastUtil.getInstance().toastCentent("--"+type+"  "+pager,KeHuActivity.this);
        OkhttpUtils.doPost(ApiEngine.KEHULISTURL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag_客户列表", e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("tag_客户列表", string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        KeHuInfoBean keHuInfoBean = gson.fromJson(string, KeHuInfoBean.class);
                        List<KeHuInfoBean.BodyBean> body = keHuInfoBean.getBody();
                        if (body.size() > 0) {
                            arrayList.addAll(body);
                            keHuAdapter.notifyDataSetChanged();
                            pager++;
                        } else {
                            keHuAdapter.notifyDataSetChanged();
                        }
                        if (arrayList.size() > 0) {
                            ltBackground.setVisibility(View.GONE);
                        } else {
                            ltBackground.setVisibility(View.VISIBLE);
                        }
                        dismissLoading();
                    }
                });
            }
        });
        setProgressDialog(3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.img_gengduo, R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_gengduo:
                popupWindow.showAsDropDown(view, 0, 0);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                startActivity(new Intent(KeHuActivity.this, AddActivity.class));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        arrayList.clear();
        switch (id) {
            case R.id.ly_zaigen:
                type = 1;
                pager = 1;
                popupWindow.dismiss();
                showLoading();
                getKuHuList();
                break;
            case R.id.ly_dahui:
                type = 2;
                pager = 1;
                popupWindow.dismiss();
                showLoading();
                getKuHuList();
                break;
            case R.id.ly_zaitan:
                type = 5;
                pager = 1;
                popupWindow.dismiss();
                showLoading();
                getKuHuList();
                break;
            case R.id.ly_weiqian:
                type = 8;
                pager = 1;
                popupWindow.dismiss();
                showLoading();
                getKuHuList();
                break;
            case R.id.ly_yiqian:
                type = 7;
                pager = 1;
                popupWindow.dismiss();
                showLoading();
                getKuHuList();
                break;
            case R.id.ly_shenpi:
                type = 3;
                pager = 1;
                popupWindow.dismiss();
                showLoading();
                getKuHuList();
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }

    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }

        @Override
        public void afterTextChanged(Editable arg0) {
            int lengths = arg0.length();
            switch (edittext.getId()) {
                case R.id.editText:
//                    ToastUtil.getInstance().toastCentent(edittext.getText().toString(),KeHuActivity.this);
                    type = 0;
                    pager = 1;
                    key = editText.getText().toString();
                    arrayList.clear();
                    getKuHuList();
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
        }
    }

}
