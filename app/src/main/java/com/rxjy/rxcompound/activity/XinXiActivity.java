package com.rxjy.rxcompound.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.gson.Gson;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.guwen.TongJiInfo;
import com.rxjy.rxcompound.activity.guwen.XinXiAdapter;
import com.rxjy.rxcompound.activity.guwen.XinXiYuanInfo;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.utils.OkhttpUtils;
import com.rxjy.rxcompound.utils.OkhttpUtils2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XinXiActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.lv_xinxiyuan)
    SwipeMenuListView lvXinxiyuan;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.img_gengduo)
    ImageView imgGengduo;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    ImageView tvRight;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;
    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.rl_back)
    RelativeLayout rlBack;
    @Bind(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @Bind(R.id.root_main)
    LinearLayout rootMain;

    private PopupWindow popupWindow;
    private List<XinXiYuanInfo.BodyBean> body;
    private TextView tv_xinxiyuan;
    private LinearLayout ly_xinxiyuan;
    private TextView tv_jingjiren;
    private LinearLayout ly_jingjiren;
    private TextView tv_zhuangji;
    private LinearLayout ly_zhuangji;
    private List<TongJiInfo.BodyBean> tongjidata;
    private Button zhiliang;
    private Button hezuo;
    private Button konghao;
    private Button zhuanhang;
    private Button btn_cancle;
    private View popView;
    private PopupWindow popupWindow1;
    private XinXiAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_xinxi;
    }

    @Override
    public void initData() {
        tvTitle.setText("信息员");
        ivBack.setOnClickListener(this);
        imgGengduo.setOnClickListener(this);
        tvRight.setOnClickListener(this);
//        zhiliang.setOnClickListener(this);
//        hezuo.setOnClickListener(this);
//        konghao.setOnClickListener(this);
//        zhuanhang.setOnClickListener(this);
        getData();
        initList();
        initListener();
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
                genZongItem.setTitle("拉黑");
                genZongItem.setTitleSize(18);
                // set item title font color
                genZongItem.setTitleColor(Color.WHITE);
//                deleteItem.setIcon(R.drawable.ic_launcher_background);
                // add to menu
                menu.addMenuItem(genZongItem);
            }
        };
        lvXinxiyuan.setMenuCreator(creator);
    }

    public void callPhone(String phoneNumber) {
        try {
            Intent Intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + phoneNumber));//跳转到拨号界面，同时传递电话号码
            startActivity(Intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int laheiPostion;

    private void initListener() {
        lvXinxiyuan.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                laheiPostion = position;
                Log.i("tag", "index" + index);
                switch (index) {
                    case 0:
                        //打电话
                        callPhone(body.get(position).getShouJiHaoYi());
                        break;
                    case 1:
                        //回访
                        Intent intent = new Intent(XinXiActivity.this, HuiFangActivity.class);
                        intent.putExtra("xinxiyuanid", body.get(position).getXinXiYuanBaseID());
                        intent.putExtra("yewuyuanid", body.get(position).getYeWuYuanID());
                        Log.i("tag", "phone>>>>>>>>>>>>" + "'" + body.get(position).getShouJiHaoYi() + "','"
                                + body.get(position).getShouJiHaoEr() + "','" + body.get(position).getShouJiHaoSan() + "'");
                        if (!TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {

                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoYi() + "','"
                                    + body.get(position).getShouJiHaoEr() + "','" + body.get(position).getShouJiHaoSan() + "'");
                        } else if (!TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {
                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoYi() + "','"
                                    + body.get(position).getShouJiHaoEr() + "'");
                        } else if (!TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {
                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoYi() + "','"
                                    + body.get(position).getShouJiHaoSan() + "'");
                        } else if (TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {
                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoEr() + "','"
                                    + body.get(position).getShouJiHaoSan() + "'");
                        } else if (!TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {
                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoYi() + "'");
                        } else if (TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {
                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoEr() + "'");
                        } else if (TextUtils.isEmpty(body.get(position).getShouJiHaoYi()) &&
                                TextUtils.isEmpty(body.get(position).getShouJiHaoEr()) &&
                                !TextUtils.isEmpty(body.get(position).getShouJiHaoSan())) {
                            intent.putExtra("phone", "'" + body.get(position).getShouJiHaoSan() + "'");
                        }
                        startActivity(intent);
                        break;
                    case 2:
                        //拉黑
                        openPop();
                        break;
                }
                return false;
            }
        });
        lvXinxiyuan.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        lvXinxiyuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int xinXiYuanBaseID = body.get(position).getXinXiYuanBaseID();
                Intent intent = new Intent(XinXiActivity.this, XinXiYuanDetialActivity.class);
                intent.putExtra("id", xinXiYuanBaseID);
                startActivity(intent);
            }
        });
    }

    /**
     * 弹出底部对话框
     */
    public void openPop() {
        initView();
        View rootView = findViewById(R.id.root_main); // 當前頁面的根佈局
        popupWindow1 = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ActionMenuView.LayoutParams.WRAP_CONTENT);

        setBackgroundAlpha(0.5f);//设置屏幕透明度

        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow1.showAtLocation(rootView, Gravity.BOTTOM | Gravity.LEFT, 0, 0);

        popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    private void getData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("card", App.cardNo);
        map.put("type", 0);
        map.put("key", "");
        map.put("pageIndex", 1);
        map.put("pageSize", 10);
        OkhttpUtils.doGet(this, ApiEngine.BASEURL + "AppEmployee/GetMessengerList", map, new OkhttpUtils.MyCall() {
            @Override
            public void success(String data) {
                Log.e("信息员data>>>>>>>>>", data);
                Gson gson = new Gson();
                XinXiYuanInfo xinXiYuanInfo = gson.fromJson(data, XinXiYuanInfo.class);
                body = xinXiYuanInfo.getBody();
                initAdapter();
            }

            @Override
            public void error(String message) {
                Log.e("信息员data>>>>错误信息>>>>>", message);
            }
        });
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("card", App.cardNo);
        OkhttpUtils.doGet(this, ApiEngine.BASEURL + "AppEmployee/GetMessengerCount", maps, new OkhttpUtils.MyCall() {
            @Override
            public void success(String data) {
                Log.e("统计data>>>>>>>>>", data);
                Gson gson = new Gson();
                TongJiInfo tongJiInfo = gson.fromJson(data, TongJiInfo.class);
                tongjidata = tongJiInfo.getBody();
                int agent = tongjidata.get(0).getAgent();
                int install = tongjidata.get(0).getIsInstall();
                int messenger = tongjidata.get(0).getMessenger();
                int tatal = tongjidata.get(0).getTatal();

                tv_jingjiren.setText("经纪人/" + agent);
                tv_xinxiyuan.setText("信息员/" + messenger);
                tv_zhuangji.setText("装机/" + install);
            }

            @Override
            public void error(String message) {
                Log.e("统计data>>>>错误信息>>>>>", message);
            }
        });
    }

    private void initAdapter() {
        adapter = new XinXiAdapter(body, XinXiActivity.this);
        lvXinxiyuan.setAdapter(adapter);
        popupWindow.dismiss();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    String tag;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                Intent intent = new Intent(XinXiActivity.this, XinXiYuanXinZengActivity.class);
//                intent.putExtra("xinxiyuanbaseid")
                startActivity(intent);
                break;
            case R.id.img_gengduo:
                popupWindow.showAsDropDown(rlTool, 0, 0);
                break;
            case R.id.ly_xinxiyuan:
                getxinxiyuanData();
                break;
            case R.id.ly_jingjiren:
                getjingjirenData();
                break;
            case R.id.ly_zhuangji:
                getzhuangjiData();
                break;
            case R.id.zhiliang:
                tag = "1";
                lahei(tag, laheiPostion);
                break;
            case R.id.hezuo:
                tag = "2";
                lahei(tag, laheiPostion);
                break;
            case R.id.konghao:
                tag = "3";
                lahei(tag, laheiPostion);
                break;
            case R.id.zhuanhang:
                tag = "4";
                lahei(tag, laheiPostion);
                break;
            case R.id.btn_cancle:
                break;
        }
    }

    private void lahei(final String tag, final int position) {
        new AlertDialog.Builder(XinXiActivity.this).setTitle("确认拉黑").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteKuHu(tag, position);

                dialog.dismiss();
                popupWindow1.dismiss();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();

    }

    private void deleteKuHu(String tag, int position) {
        Map<String, Object> map = new HashMap<String, Object>();
        Log.e("tag", "xinxiyuanid" + body.get(position).getXinXiYuanBaseID());
        Log.e("tag", "tag" + tag);
        map.put("id", body.get(position).getXinXiYuanBaseID());
        map.put("BeiZhu", tag);
        OkhttpUtils2.doPost(ApiEngine.BASEURL + "AppEmployee/LaHeiXinXiYuan", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                    }
                });
            }
        });
    }

    private void getzhuangjiData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("card", App.cardNo);
        map.put("type", 3);
        map.put("key", "");
        map.put("pageIndex", 1);
        map.put("pageSize", 10);
        OkhttpUtils.doGet(this, ApiEngine.BASEURL + "AppEmployee/GetMessengerList", map, new OkhttpUtils.MyCall() {
            @Override
            public void success(String data) {
                Log.e("装机data>>>>>>>>>", data);
                Gson gson = new Gson();
                XinXiYuanInfo xinXiYuanInfo = gson.fromJson(data, XinXiYuanInfo.class);
                body = xinXiYuanInfo.getBody();
                initAdapter();
            }

            @Override
            public void error(String message) {
                Log.e("信息员data>>>>错误信息>>>>>", message);
            }
        });
    }

    private void getjingjirenData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("card", App.cardNo);
        map.put("type", 2);
        map.put("key", "");
        map.put("pageIndex", 1);
        map.put("pageSize", 10);
        OkhttpUtils.doGet(this, ApiEngine.BASEURL + "AppEmployee/GetMessengerList", map, new OkhttpUtils.MyCall() {
            @Override
            public void success(String data) {
                Log.e("经纪人data>>>>>>>>>", data);
                Gson gson = new Gson();
                XinXiYuanInfo xinXiYuanInfo = gson.fromJson(data, XinXiYuanInfo.class);
                body = xinXiYuanInfo.getBody();
                initAdapter();
            }

            @Override
            public void error(String message) {
                Log.e("信息员data>>>>错误信息>>>>>", message);
            }
        });
    }

    private void getxinxiyuanData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("card", App.cardNo);
        map.put("type", 1);
        map.put("key", "");
        map.put("pageIndex", 1);
        map.put("pageSize", 10);
        OkhttpUtils.doGet(this, ApiEngine.BASEURL + "AppEmployee/GetMessengerList", map, new OkhttpUtils.MyCall() {
            @Override
            public void success(String data) {
                Log.e("信息员2data>>>>>>>>>", data);
                Gson gson = new Gson();
                XinXiYuanInfo xinXiYuanInfo = gson.fromJson(data, XinXiYuanInfo.class);
                body = xinXiYuanInfo.getBody();
                initAdapter();
            }

            @Override
            public void error(String message) {
                Log.e("信息员data>>>>错误信息>>>>>", message);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
        initList();
        initListener();
        View inflate = LayoutInflater.from(this).inflate(R.layout.pop_xinxiyuan_layout, null);
        popupWindow(inflate, rlTool);
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

    private void initPopuView(View vicinityView) {
        tv_xinxiyuan = (TextView) vicinityView.findViewById(R.id.tv_xinxiyuan);
        ly_xinxiyuan = (LinearLayout) vicinityView.findViewById(R.id.ly_xinxiyuan);
        ly_xinxiyuan.setOnClickListener(this);
        tv_jingjiren = (TextView) vicinityView.findViewById(R.id.tv_jingjiren);
        ly_jingjiren = (LinearLayout) vicinityView.findViewById(R.id.ly_jingjiren);
        ly_jingjiren.setOnClickListener(this);
        tv_zhuangji = (TextView) vicinityView.findViewById(R.id.tv_zhuangji);
        ly_zhuangji = (LinearLayout) vicinityView.findViewById(R.id.ly_zhuangji);
        ly_zhuangji.setOnClickListener(this);
    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = this.getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        this.getWindow().setAttributes(lp);
    }

    private void initView() {
        popView = LayoutInflater.from(this).inflate(R.layout.pop_lahei_layout, null);
        zhiliang = (Button) popView.findViewById(R.id.zhiliang);
        hezuo = (Button) popView.findViewById(R.id.hezuo);
        konghao = (Button) popView.findViewById(R.id.konghao);
        zhuanhang = (Button) popView.findViewById(R.id.zhuanhang);
        btn_cancle = (Button) popView.findViewById(R.id.btn_cancle);

        zhiliang.setOnClickListener(this);
        hezuo.setOnClickListener(this);
        konghao.setOnClickListener(this);
        zhuanhang.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);
    }
}
