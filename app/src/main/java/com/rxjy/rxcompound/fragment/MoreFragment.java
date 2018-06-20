package com.rxjy.rxcompound.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.AdministrationRedActivity;
import com.rxjy.rxcompound.activity.BaseInformationActivity;
import com.rxjy.rxcompound.activity.BeforeJobActivity;
import com.rxjy.rxcompound.activity.CustomerActivity;
import com.rxjy.rxcompound.activity.IdentityInfoNewActivity;
import com.rxjy.rxcompound.activity.MoreBannerActivity;
import com.rxjy.rxcompound.activity.RXSongsActivity;
import com.rxjy.rxcompound.activity.RXlinesActivity;
import com.rxjy.rxcompound.activity.WebViewActivity;
import com.rxjy.rxcompound.activity.ZThreeActivity;
import com.rxjy.rxcompound.activity.more.AnLiActivity;
import com.rxjy.rxcompound.activity.more.BoWenActivity;
import com.rxjy.rxcompound.activity.more.CaiWuActivity;
import com.rxjy.rxcompound.activity.more.FuWuActivity;
import com.rxjy.rxcompound.activity.more.JiaMengActivity;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.activity.more.PaiDanActivity;
import com.rxjy.rxcompound.activity.more.XiaXianActivity;
import com.rxjy.rxcompound.adapter.NattenDanceAdapter;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.des.activity.LHouseMoreActivity;
import com.rxjy.rxcompound.entity.NumberPackets;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.mvp.contract.GetUserStatusContract;
import com.rxjy.rxcompound.mvp.presenter.GetUserStatusPresenter;
import com.rxjy.rxcompound.widget.MyGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 更多
 * Created by hjh on 2017/11/6.
 */
public class MoreFragment extends BaseFragment<GetUserStatusPresenter> implements GetUserStatusContract.View {

    @Bind(R.id.gv_task)
    GridView gvTask;

    @Bind(R.id.gv_data)
    GridView gvData;
    @Bind(R.id.gv_move)
    GridView gvMove;
    @Bind(R.id.gv_culture)
    GridView gvCulture;
    @Bind(R.id.rl_moretop)
    RelativeLayout rlMoretop;
    @Bind(R.id.more_one)
    RelativeLayout moreOne;
    @Bind(R.id.gv_attendance)
    MyGridView gvAttendance;
    @Bind(R.id.ly_kehu)
    LinearLayout lyKehu;
    @Bind(R.id.imageView4)
    ImageView imageView4;
    @Bind(R.id.imageView11)
    ImageView imageView11;
    @Bind(R.id.textView11)
    TextView textView11;
    @Bind(R.id.imageView12)
    ImageView imageView12;
    @Bind(R.id.textView12)
    TextView textView12;
    @Bind(R.id.imageView13)
    ImageView imageView13;
    @Bind(R.id.textView13)
    TextView textView13;
    @Bind(R.id.imageView14)
    ImageView imageView14;
    @Bind(R.id.textView14)
    TextView textView14;
    @Bind(R.id.imageView15)
    ImageView imageView15;
    @Bind(R.id.textView15)
    TextView textView15;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.textView6)
    TextView textView6;
    @Bind(R.id.imageView5)
    ImageView imageView5;
    @Bind(R.id.textView8)
    TextView textView8;
    @Bind(R.id.img_kehu)
    ImageView imgKehu;
    @Bind(R.id.tv_kehu)
    TextView tvKehu;
    @Bind(R.id.red_image)
    ImageView redImage;
    @Bind(R.id.tv_tab_wallet_state)
    TextView tvTabWalletState;
    @Bind(R.id.imageView27)
    ImageView imageView27;
    @Bind(R.id.img_touzi)
    ImageView imgTouzi;
    @Bind(R.id.tv_touzi)
    TextView tvTouzi;
    @Bind(R.id.ly_dianpu)
    LinearLayout lyDianpu;
    @Bind(R.id.ly_anli)
    LinearLayout lyAnli;
    @Bind(R.id.ly_bowen)
    LinearLayout lyBowen;
    @Bind(R.id.ly_fuwu)
    LinearLayout lyFuwu;
    @Bind(R.id.ly_paidan)
    LinearLayout lyPaidan;
    @Bind(R.id.ly_caiwu)
    LinearLayout lyCaiwu;
    @Bind(R.id.ly_jiameng)
    LinearLayout lyJiameng;
    @Bind(R.id.ly_xiaxian)
    LinearLayout lyXiaxian;
    @Bind(R.id.ly_touzi)
    LinearLayout lyTouzi;
    @Bind(R.id.ly_guwenfuwu)
    LinearLayout lyGuwenfuwu;
    @Bind(R.id.ly_zaishi)
    LinearLayout lyZaishi;

    private String TAG = "MoreFragment";
    @Bind(R.id.gv_rxculture)
    GridView gv_rxculture;
    @Bind(R.id.gv_rxbusiness)
    GridView gv_rxbusiness;
    @Bind(R.id.gv_rxyewu)
    GridView gv_rxyewu;
    @Bind(R.id.iv_morebanner)
    ImageView iv_morebanner;
    private SimpleAdapter simpleAdapter;
    private SimpleAdapter bsimpleAdapter;

    private SimpleAdapter ntaskAdapter;
    private SimpleAdapter nattendanceAdapter;
    private SimpleAdapter ndataAdapter;
    private SimpleAdapter nmoveAdapter;
    private SimpleAdapter ncultureAdapter;
    private List<Map<String, Object>> data_list;
    private List<Map<String, Object>> bdata_list;
    private List<Map<String, Object>> yewudata_list;
    private List<Map<String, Object>> ntask_list;
    private List<Map<String, Object>> nattendance_list;
    private List<Map<String, Object>> ndata_list;
    private List<Map<String, Object>> nmove_list;
    private List<Map<String, Object>> nculture_list;
    WindowManager windowManager;

    private NattenDanceAdapter nattenDanceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_more;
    }

    String phonenum, cardno;

    @Override
    protected void FragmentInitData() {

        moreOne.setVisibility(View.GONE);
        switch (App.apptype) {
            case 2:
                rlMoretop.setBackgroundColor(getResources().getColor(R.color.textorange));
                break;
            case 3:
                rlMoretop.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDes));
                break;
            case 4:
                rlMoretop.setBackgroundColor(getResources().getColor(R.color.colorPrimarys));
                break;
            default:
                break;
        }
        if (App.depart.equals("3")) {//设计师
            lyTouzi.setVisibility(View.VISIBLE);
        } else {
            lyTouzi.setVisibility(View.GONE);
        }
        if (App.depart.equals("2")) { //上午
            lyGuwenfuwu.setVisibility(View.VISIBLE);
        } else {
            lyGuwenfuwu.setVisibility(View.GONE);
        }
        initTaskData();
        initAttenData();
        initPersonData();
        initMoveData();
        //initNCultureData();

        initData();
        initBData();
        initYWData();
        SharedPreferences sp = getActivity().getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        mPresenter.getUserStatus(cardno);
        windowManager = getActivity().getWindowManager();

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getUserStatus(cardno);
    }

    @Override
    protected GetUserStatusPresenter onCreatePresenter() {
        return new GetUserStatusPresenter(this);
    }

    /**
     * 新任务管理
     */
    private String[] taskNames = new String[]{"任务", "回访", "周报", "日报"};
    private int[] taskIcon = new int[]{R.drawable.ic_more_task, R.drawable.ic_more_back, R.drawable.ic_more_week, R.drawable.ic_more_month};

    public List<Map<String, Object>> getTaskData() {
        for (int i = 0; i < taskNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", taskIcon[i]);
            map.put("text", taskNames[i]);
            ntask_list.add(map);
        }
        return ntask_list;
    }

    private void initTaskData() {

        ntask_list = new ArrayList<Map<String, Object>>();
        getTaskData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        ntaskAdapter = new SimpleAdapter(getActivity(), ntask_list, R.layout.item_moreitem, from, to);
        gvTask.setAdapter(ntaskAdapter);
        gvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }
//    private void  initTaskData(){
//        mlist=new HashMap<>();
//        mlist.put(R.mipmap.more_redenvelopes,"红包");
//        mlist.put(R.mipmap.more_returnguest,"回头客");
//        mlist.put(R.mipmap.more_joinin,"加盟");
//        mlist.put(R.mipmap.more_cost,"费用");
//        mlist.put(R.mipmap.more_moneybag,"钱袋");
//        mlist.put(R.mipmap.more_news,"消息");
//        AdministrationMoreAdapter moreAdapter=new AdministrationMoreAdapter(mlist,getContext());
//        gvTask.setAdapter(moreAdapter);
//        gvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Set<Integer> integers = mlist.keySet();
//                for (Integer key:integers) {
//                    switch (key){
//                        case R.mipmap.more_redenvelopes :
//
//                            break;
//                        case R.mipmap.more_returnguest:
//                            break;
//                        case R.mipmap.more_joinin:
//                            break;
//                        case R.mipmap.more_cost:
//                            break;
//                        case R.mipmap.more_moneybag:
//                            break;
//                        case R.mipmap.more_news:
//
//                            break;
//                        default:
//                            break;
//
//
//                    }
//                }
//
//            }
//        });
//    }

    /**
     * 新出勤管理
     */
//    private String[] attNames = new String[]{"打卡", "请假", "出差"};

    private String[] attNames = new String[]{"红包任务", "回头客", "加盟推荐"};
    private int[] attIcon = new int[]{R.mipmap.more_redenvelopes, R.mipmap.more_returnguest, R.mipmap.more_joinin};

    public List<Map<String, Object>> getAttendanceData() {
        for (int i = 0; i < attNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(attNames[i], attIcon[i]);
            nattendance_list.add(map);
        }
        return nattendance_list;
    }

    private void initAttenData() {

        nattendance_list = new ArrayList<Map<String, Object>>();
        getAttendanceData();
        Log.e("tag", App.dcid + "");
        if (App.dcid == 3 || App.dcid == 34 || App.dcid == 2) {
            mPresenter.getRedTask(App.cardNo);
        } else {
            //  Toast.makeText(getContext(), "=========", Toast.LENGTH_SHORT).show();
            gvAttendance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:

                            break;
                        case 1:
                            String depart = App.depart;
                            //判读是否是监理
                            if (depart.equals("4")) {
                                Intent intent = new Intent(getContext(), CustomerActivity.class);
                                startActivity(intent);
                            }

                            break;
                    }
                }
            });
            nattenDanceAdapter = new NattenDanceAdapter(nattendance_list, getContext(), 0);
            gvAttendance.setAdapter(nattenDanceAdapter);
        }
    }


    /**
     * 新个人资料
     */
    private String[] perNames = new String[]{"基础信息", "账户信息", "合同信息"};
    private int[] perIcon = new int[]{R.drawable.ic_more_message, R.drawable.ic_more_account, R.drawable.ic_more_hetong};

    public List<Map<String, Object>> getPersonData() {
        for (int i = 0; i < perNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", perIcon[i]);
            map.put("text", perNames[i]);
            ndata_list.add(map);
        }
        return ndata_list;
    }

    private void initPersonData() {
        ndata_list = new ArrayList<Map<String, Object>>();
        getPersonData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        ndataAdapter = new SimpleAdapter(getActivity(), ndata_list, R.layout.item_moreitem, from, to);
        gvData.setAdapter(ndataAdapter);
        gvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    /**
     * 新异动申请
     */
    private String[] moveNames = new String[]{"调职申请", "调薪申请", "离职申请"};
    private int[] moveIcon = new int[]{R.drawable.ic_more_diaozhi, R.drawable.ic_more_tiaoxin, R.drawable.ic_more_lizhi};

    public List<Map<String, Object>> getMoveData() {
        for (int i = 0; i < moveNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", moveIcon[i]);
            map.put("text", moveNames[i]);
            nmove_list.add(map);
        }
        return nmove_list;
    }

    private void initMoveData() {
        nmove_list = new ArrayList<Map<String, Object>>();
        getMoveData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        nmoveAdapter = new SimpleAdapter(getActivity(), nmove_list, R.layout.item_moreitem, from, to);
        gvMove.setAdapter(nmoveAdapter);
        gvMove.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    /**
     * 新瑞祥文化
     */
//    private String[] ncultureNames = new String[]{"瑞祥之歌", "瑞祥准则", "关于我们", "英雄榜"};
    private String[] ncultureNames = new String[]{"瑞祥之歌", "瑞祥准则"};
    //    private int[] ncultureIcon = new int[]{R.drawable.ic_more_nsongs, R.drawable.ic_more_nzhunze, R.drawable.ic_more_naboutus, R.drawable.ic_more_nhero};
    private int[] ncultureIcon = new int[]{R.drawable.ic_more_nsongs, R.drawable.ic_more_nzhunze};

    public List<Map<String, Object>> getNCultureData() {
        for (int i = 0; i < ncultureNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", ncultureIcon[i]);
            map.put("text", ncultureNames[i]);
            nculture_list.add(map);
        }
        return nculture_list;
    }

    private void initNCultureData() {
        gvCulture.setVisibility(View.GONE);
        nculture_list = new ArrayList<Map<String, Object>>();
        getNCultureData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        ncultureAdapter = new SimpleAdapter(getActivity(), nculture_list, R.layout.item_moreitem, from, to);
        gvCulture.setAdapter(ncultureAdapter);
        gvCulture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getActivity(), RXSongsActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), RXlinesActivity.class));
                        break;
                }
            }
        });
    }


    /**
     * 瑞祥文化
     */
    private String[] cultureNames = new String[]{"瑞祥之歌", "瑞祥准则"};
    private int[] cultureIcon = new int[]{R.drawable.ic_moremusic, R.drawable.ic_morelines};

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < cultureIcon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", cultureIcon[i]);
            map.put("text", cultureNames[i]);
            data_list.add(map);
        }
        return data_list;
    }

    private void initData() {
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        simpleAdapter = new SimpleAdapter(getActivity(), data_list, R.layout.item_moreitem, from, to);
        gv_rxculture.setAdapter(simpleAdapter);
        gv_rxculture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getActivity(), RXSongsActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), RXlinesActivity.class));
                        break;
                }
            }
        });
    }

    /**
     * 资料
     */
    private String[] businessNames = new String[]{"基础资料", "身份信息", "入职资料"};
    private int[] businessIcon = new int[]{R.drawable.ic_basedata, R.drawable.ic_identity, R.drawable.ic_entryjobdata};

    public List<Map<String, Object>> getBusinessData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < businessNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("images", businessIcon[i]);
            map.put("texts", businessNames[i]);
            bdata_list.add(map);
        }
        return bdata_list;
    }

    private void initBData() {
        bdata_list = new ArrayList<Map<String, Object>>();
        getBusinessData();
        String[] from = {"images", "texts"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        bsimpleAdapter = new SimpleAdapter(getActivity(), bdata_list, R.layout.item_moreitem, from, to);
        gv_rxbusiness.setAdapter(bsimpleAdapter);
        gv_rxbusiness.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getActivity(), BaseInformationActivity.class).putExtra("isback", "1").putExtra("status", status + ""));
                        break;
                    case 1:
                        if (status > 2) {
                            startActivity(new Intent(getActivity(), IdentityInfoNewActivity.class));
                        } else {
                            ShowUtils.Toastshort(getActivity(), "请完善基础资料");
                        }
//                        if(status<=2){
//                            ShowUtils.Toastshort(getActivity(),"请完善基础资料");
//                        }else if(status>=5){
//                            ShowUtils.Toastshort(getActivity(),"入职后不能修改资料,如需修改请联系人事");
//                        }else{
//                            startActivity(new Intent(getActivity(), IdentityInfoActivity.class).putExtra("status", status + ""));
//                        }
                        break;
                    case 2:
                        if (status > 2) {
                            startActivity(new Intent(getActivity(), ZThreeActivity.class));
                        } else {
                            ShowUtils.Toastshort(getActivity(), "请完善基础资料");
                        }
//                        if(status<=2){
//                            ShowUtils.Toastshort(getActivity(),"请完善基础资料");
//                        }else if(status>=5){
//                            ShowUtils.Toastshort(getActivity(),"入职后不能修改资料,如需修改请联系人事");
//                        }else{
//                            startActivity(new Intent(getActivity(), EnterJobActivity.class).putExtra("status", status + ""));
//                        }
                        break;
                }
            }
        });
    }

    /**
     * 业务
     */
    private String[] ywNames = new String[]{"申请入职"};
    private int[] ywIcon = new int[]{R.drawable.ic_moreentry};

    public List<Map<String, Object>> getYWData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < ywIcon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("imageyw", ywIcon[i]);
            map.put("textyw", ywNames[i]);
            yewudata_list.add(map);
        }
        return yewudata_list;
    }

    private void initYWData() {
        yewudata_list = new ArrayList<Map<String, Object>>();
        getYWData();
        String[] from = {"imageyw", "textyw"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        bsimpleAdapter = new SimpleAdapter(getActivity(), yewudata_list, R.layout.item_moreitem, from, to);
        gv_rxyewu.setAdapter(bsimpleAdapter);
        gv_rxyewu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (status == 4) {
                    startActivity(new Intent(getActivity(), BeforeJobActivity.class));
                } else {
                    ShowUtils.Toastshort(getActivity(), "没有权限！");
                }
            }
        });
    }


    int isclick, status;

    @Override
    public void responseUserStatus(UserStatusBean data) {
        status = data.getBody().getStage();
        switch (data.getBody().getStage()) {
            case 3:
                //不可点击
                isclick = 0;
                break;
            case 4:
                isclick = 1;
                break;
        }
    }

    @Override
    public void responseUserStatusError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void responseTaskData(NumberPackets.BodyBean mlist) {
        gvAttendance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getContext(), AdministrationRedActivity.class));
                        break;
                    case 1:
                        if (App.dcid == 3) {
                            startActivity(new Intent(getActivity(), LHouseMoreActivity.class));
                        }
                        break;
                }
            }
        });
        nattenDanceAdapter = new NattenDanceAdapter(nattendance_list, getContext(), mlist.getCount());
        gvAttendance.setAdapter(nattenDanceAdapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.iv_morebanner, R.id.ly_kehu, R.id.ly_dianpu, R.id.ly_anli, R.id.ly_bowen, R.id.ly_fuwu, R.id.ly_paidan, R.id.ly_caiwu, R.id.ly_jiameng, R.id.ly_xiaxian, R.id.ly_touzi,R.id.ly_zaishi})
    public void onViewClicked(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.iv_morebanner:
                startActivity(new Intent(getActivity(), MoreBannerActivity.class));
                break;
            case R.id.ly_kehu:
                startActivity(new Intent(getActivity(), KeHuActivity.class));
                break;
            case R.id.ly_dianpu://店铺
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/dianPu?card=1");
                intent.putExtra("name", "店铺");
                break;
            case R.id.ly_zaishi://店铺
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/zaiShi?card=1");
                intent.putExtra("name", "在施");
                break;
            case R.id.ly_anli://案例
//                intent = new Intent(getActivity(), AnLiActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/anLi?card=1");
                intent.putExtra("name", "案例");
                break;
            case R.id.ly_bowen://博文
//                intent = new Intent(getActivity(), BoWenActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/boWen?card=1");
                intent.putExtra("name", "博文");
                break;
            case R.id.ly_fuwu://服务
//                intent = new Intent(getActivity(), FuWuActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/fuWu?card=1");
                intent.putExtra("name", "服务");
                break;
            case R.id.ly_paidan://派单
//                intent = new Intent(getActivity(), PaiDanActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/paiDan?card=1");
                intent.putExtra("name", "派单");
                break;
            case R.id.ly_caiwu://财务
//                intent = new Intent(getActivity(), CaiWuActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/caiWu?card=1");
                intent.putExtra("name", "财务");
                break;
            case R.id.ly_jiameng://加盟
//                intent = new Intent(getActivity(), JiaMengActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/jiaMeng?card=1");
                intent.putExtra("name", "加盟");
                break;
            case R.id.ly_xiaxian://下线
//                intent = new Intent(getActivity(), XiaXianActivity.class);
                intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "http://c.wenes.cn/#/Personnel/App/xiaXian?card=1");
                intent.putExtra("name", "下线");
                break;
            case R.id.ly_touzi:
//                intent = new Intent(getActivity(), WebViewActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}