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
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.acker.simplezxing.activity.CaptureActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.BannerDetailsActivity;
import com.rxjy.rxcompound.activity.EnvironmentActivity;
import com.rxjy.rxcompound.activity.FigureActivity;
import com.rxjy.rxcompound.activity.JobTryAnswer;
import com.rxjy.rxcompound.activity.QRLoginSureActivity;
import com.rxjy.rxcompound.activity.TaskActivity;
import com.rxjy.rxcompound.activity.TaskNewActivity;
import com.rxjy.rxcompound.adapter.TaskAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.GlideRoundTransform;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.BannerBean;
import com.rxjy.rxcompound.entity.BannerDataBean;
import com.rxjy.rxcompound.entity.EduDataBean;
import com.rxjy.rxcompound.entity.QRResultBean;
import com.rxjy.rxcompound.entity.TaskListBean;
import com.rxjy.rxcompound.mvp.contract.HomePageFContract;
import com.rxjy.rxcompound.mvp.presenter.HomePageFPresenter;
import com.rxjy.rxcompound.widget.CircleProgressView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * 首页
 * Created by hjh on 2017/11/6.
 */
public class HomePageFragment extends BaseFragment<HomePageFPresenter> implements HomePageFContract.View {

    @Bind(R.id.cpv_cirone)
    CircleProgressView cpv_cirone;
    @Bind(R.id.cpv_cirtwo)
    CircleProgressView cpv_cirtwo;
    @Bind(R.id.cpv_cirthree)
    CircleProgressView cpv_cirthree;
    @Bind(R.id.vp_banner)
    ViewPager vp_banner;
    @Bind(R.id.tv_scoresone)
    TextView tv_scoresone;
    @Bind(R.id.tv_scorestwo)
    TextView tv_scorestwo;
    @Bind(R.id.tv_time)
    TextView tv_time;
    @Bind(R.id.tv_scoresthree)
    TextView tv_scoresthree;
    @Bind(R.id.iv_tryimg)
    ImageView iv_tryimg;
    @Bind(R.id.ll_dayone)
    LinearLayout ll_dayone;
    @Bind(R.id.ll_daytwo)
    LinearLayout ll_daytwo;
    @Bind(R.id.ll_daythree)
    LinearLayout ll_daythree;
    @Bind(R.id.tv_qrscan)
    TextView tv_qrscan;
    @Bind(R.id.lv_task)
    ListView lvTask;
    @Bind(R.id.rl_envir)
    RelativeLayout rlEnvir;
    @Bind(R.id.rl_xingxiang)
    RelativeLayout rlXingxiang;
    private PagerAdapter pagerAdapter;
    int index = 0;
    int size = 0;
    int day;
    String part;

    @Override
    protected HomePageFPresenter onCreatePresenter() {
        return new HomePageFPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_homepage;
    }

    String phonenum, cardno;

    @Override
    protected void FragmentInitData() {
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
//        cardno = sp.getString("rxdy_cardno", null);
        cardno = App.cardNo;
        mPresenter.getBannerList(cardno);
//        mPresenter.getEduData(cardno);

        //获取进度===
        cpv_cirone.setProgress(0);
        cpv_cirtwo.setProgress(0);
        cpv_cirthree.setProgress(0);
        Date curDate = new Date(System.currentTimeMillis());
        tv_time.setText(getDateToString(curDate, "yyyy-MM-dd"));
        ll_dayone.setEnabled(false);
        ll_daytwo.setEnabled(false);
        ll_daythree.setEnabled(false);

        if(App.apptype==34){
            rlEnvir.setVisibility(View.VISIBLE);
            rlXingxiang.setVisibility(View.VISIBLE);
            lvTask.setVisibility(View.GONE);
        }else{
            rlEnvir.setVisibility(View.GONE);
            rlXingxiang.setVisibility(View.GONE);
        }

        Test();
    }


    /**
     * 测试时间
     */
    private void Test(){
    }


    @Override
    public void onResume() {
        super.onResume();
//        mPresenter.getEduData(cardno);
        mPresenter.getTaskData(cardno);
    }

    @Override
    public void responseBannerData(BannerBean data) {
        size = data.getBody().size();
        ShowBanner(data.getBody());
    }

    @Override
    public void responseBannerDataError(String msg) {
    }

    @Override
    public void responseEduData(EduDataBean data) {//请求教育资源
        part = data.getDept();
        day = data.getDayIndex();
        ll_dayone.setEnabled(true);
        ll_daytwo.setEnabled(true);
        ll_daythree.setEnabled(true);
        switch (data.getDayIndex()) {
            case 1:
                if (data.getFlag().equals("未答完")) {
                    cpv_cirone.setProgress((int) data.getPressess1());
                } else {
                    cpv_cirone.setVisibility(View.GONE);
                    tv_scoresone.setVisibility(View.VISIBLE);
                    tv_scoresone.setText(data.getScore1() + "分");
                }
                cpv_cirtwo.setProgress((int) data.getPressess2());
                cpv_cirthree.setProgress((int) data.getPressess3());
                break;
            case 2:
                if (data.getFlag().equals("未答完")) {
                    cpv_cirtwo.setProgress((int) data.getPressess2());
                } else {
                    cpv_cirtwo.setVisibility(View.GONE);
                    tv_scorestwo.setVisibility(View.VISIBLE);
                    tv_scorestwo.setText(data.getScore2() + "分");
                }
                cpv_cirone.setVisibility(View.GONE);
                tv_scoresone.setVisibility(View.VISIBLE);
                tv_scoresone.setText(data.getScore1() + "分");
                cpv_cirthree.setProgress((int) data.getPressess3());
                break;
            case 3:
                if (data.getFlag().equals("未答完")) {
                    cpv_cirthree.setProgress((int) data.getPressess3());
                } else {
                    cpv_cirthree.setVisibility(View.GONE);
                    tv_scoresthree.setVisibility(View.VISIBLE);
                    tv_scoresthree.setText(data.getScore3() + "分");
                    iv_tryimg.setImageResource(R.drawable.ic_hometrytip);
                }
                cpv_cirone.setVisibility(View.GONE);
                tv_scoresone.setVisibility(View.VISIBLE);
                tv_scoresone.setText(data.getScore1() + "分");
                cpv_cirtwo.setVisibility(View.GONE);
                tv_scorestwo.setVisibility(View.VISIBLE);
                tv_scorestwo.setText(data.getScore2() + "分");
                break;
        }
    }

    @Override
    public void responseEduDataError(String msg) {

    }

    TaskAdapter taskAdapter;

    @Override
    public void responseTaskData(final TaskListBean data) {
        Log.e("dddddd","显示");
        taskAdapter = new TaskAdapter(getActivity(), data.getBody());
        lvTask.setAdapter(taskAdapter);
        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(getActivity(), TaskActivity.class).putExtra("taskid", data.getBody().get(position).getTaskId() + ""));
                startActivity(new Intent(getActivity(), TaskNewActivity.class).putExtra("task", data.getBody().get(position)));
            }
        });
    }

    @Override
    public void responseTaskDataError(String msg) {
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

    @OnClick({R.id.ll_dayone, R.id.ll_daytwo, R.id.ll_daythree, R.id.tv_qrscan,R.id.rl_envir, R.id.rl_xingxiang})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_dayone:
                if (StringUtils.isEmpty(part)) {
                    part = "0";
                }
                if (day >= 1) {
                    startActivity(new Intent(getActivity(), JobTryAnswer.class).putExtra("part", part).putExtra("day", "1"));
                } else {
                    ShowUtils.Toastshort(getActivity(), "未开启");
                }
                break;
            case R.id.ll_daytwo:
                if (day >= 2) {
                    startActivity(new Intent(getActivity(), JobTryAnswer.class).putExtra("part", part).putExtra("day", "2"));
                } else {
                    ShowUtils.Toastshort(getActivity(), "未开启");
                }
                break;
            case R.id.ll_daythree:
                if (day >= 3) {
                    startActivity(new Intent(getActivity(), JobTryAnswer.class).putExtra("part", part).putExtra("day", "3"));
                } else {
                    ShowUtils.Toastshort(getActivity(), "未开启");
                }
                break;
            case R.id.tv_qrscan://扫一扫
                QRCodeScan();
                break;
            case R.id.rl_envir:
                startActivity(new Intent(getActivity(), EnvironmentActivity.class));
                break;
            case R.id.rl_xingxiang:
                startActivity(new Intent(getActivity(), FigureActivity.class));
                break;
        }
    }


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 4) {
                if (index >= size) index = 0;
                if (vp_banner != null) {
                    vp_banner.setCurrentItem(index++);
                    handler.sendEmptyMessageDelayed(4, 3000);
                } else {
                    handler.removeMessages(4);
                }
            }
        }

    };

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
        vp_banner.setAdapter(pagerAdapter);
        vp_banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }

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
                            Log.e("RESULT_OK=====", data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));
                            String result = data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT);
                            QRResultBean info = JSONUtils.toObject(result, QRResultBean.class);
                            String biaoshi = info.getParameters();
                            if (biaoshi != null) {
                                biaoshi = biaoshi.substring(10, biaoshi.length() - 2);
                                Log.e("标识：：==", biaoshi);
                                startActivity(new Intent(getActivity(), QRLoginSureActivity.class).putExtra("sign", biaoshi));
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

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case CaptureActivity.REQ_CODE:
//                switch (resultCode) {
//                    case RESULT_OK:
//                        tvResult.setText(data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));  //or do sth
//                        break;
//                    case RESULT_CANCELED:
//                        if (data != null) {
//                            // for some reason camera is not working correctly
//                            tvResult.setText(data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));
//                        }
//                        break;
//                }
//                break;
//        }
//    }


    public static String getDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
