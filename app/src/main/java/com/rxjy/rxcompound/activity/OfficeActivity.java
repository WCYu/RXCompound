package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/4/8.
 */

public class OfficeActivity extends BaseActivity {
    @Bind(R.id.gv_administrative)
    GridView gvAdministrative;
    @Bind(R.id.gv_attendance)
    GridView gvAttendance;
    @Bind(R.id.gv_move)
    GridView gvMove;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    private List<Map<String, Object>> nculture_list;
    private SimpleAdapter ncultureAdapter;
    @Override
    public int getLayout() {
        return R.layout.activity_office;
    }

    @Override
    public void initData() {
        tvTitle.setText("办公");
      //  initAdminData();
        initAttenData();
        initMoveData();
        initNCultureData();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    String title, url;

    /**
     * 行政管理
     */
    private List<Map<String, Object>> admin_list;
    private String[] adminNames = new String[]{"环境", "形象"};
    private int[] adminIcon = new int[]{R.drawable.ic_huanjing, R.drawable.ic_xingxiang};

    public List<Map<String, Object>> getAdminData() {
        for (int i = 0; i < adminNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", adminIcon[i]);
            map.put("text", adminNames[i]);
            admin_list.add(map);
        }
        return admin_list;
    }

    private SimpleAdapter adminAdapter;
    private void initAdminData() {
        admin_list = new ArrayList<Map<String, Object>>();
        getAdminData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        adminAdapter = new SimpleAdapter(this, admin_list, R.layout.item_moreitem, from, to);
        gvAdministrative.setAdapter(adminAdapter);
        gvAdministrative.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        title = "环境";
                        url = Constants.OFFICE_PUBLIC + "/a/rs/task/rxXzApp?region=" + App.regionid + "&cardNo=" + App.cardNo + "&appFlag=1";
                        break;
                    case 1:
                        title = "形象";
                        url = Constants.OFFICE_PUBLIC + "/a/rs/task/rxXzFormApp?region=" + App.regionid + "&cardNo=" + App.cardNo + "&appFlag=1";
                        break;
                }
                startActivity(new Intent(OfficeActivity.this, OfficeWebViewActivity.class).putExtra("title", title).putExtra("url", url));
            }
        });
    }

    /**
     * 新异动申请
     */
    private List<Map<String, Object>> nmove_list;
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

    private SimpleAdapter nmoveAdapter;

    private void initMoveData() {
        nmove_list = new ArrayList<Map<String, Object>>();
        getMoveData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        nmoveAdapter = new SimpleAdapter(this, nmove_list, R.layout.item_moreitem, from, to);
        gvMove.setAdapter(nmoveAdapter);
        gvMove.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }


    /**
     * 新出勤管理
     */
    private List<Map<String, Object>> nattendance_list;
    private String[] attNames = new String[]{"请假", "出差"};
    //    private String[] attNames = new String[]{"打卡", "请假", "出差"};
    private int[] attIcon = new int[]{R.drawable.ic_more_qingjia, R.drawable.ic_more_chuchai};

    //    private int[] attIcon = new int[]{R.drawable.ic_more_daka, R.drawable.ic_more_qingjia, R.drawable.ic_more_chuchai};
    public List<Map<String, Object>> getAttendanceData() {
        for (int i = 0; i < attNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", attIcon[i]);
            map.put("text", attNames[i]);
            nattendance_list.add(map);
        }
        return nattendance_list;
    }

    private SimpleAdapter nattendanceAdapter;

    private void initAttenData() {
        nattendance_list = new ArrayList<Map<String, Object>>();
        getAttendanceData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        nattendanceAdapter = new SimpleAdapter(this, nattendance_list, R.layout.item_moreitem, from, to);
        gvAttendance.setAdapter(nattendanceAdapter);
        gvAttendance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }
    /**
     * 新瑞祥文化
     */
  //  private String[] ncultureNames = new String[]{"瑞祥之歌", "瑞祥准则", "关于我们", "英雄榜"};
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
        nculture_list = new ArrayList<Map<String, Object>>();
        getNCultureData();
        String[] from = {"image", "text"};
        int[] to = {R.id.iv_moreicon, R.id.tv_moretext};
        ncultureAdapter = new SimpleAdapter(this, nculture_list, R.layout.item_moreitem, from, to);
        gvAdministrative.setAdapter(ncultureAdapter);
        gvAdministrative.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(OfficeActivity.this, RXSongsActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(OfficeActivity.this, RXlinesActivity.class));
                        break;
                }
            }
        });
    }
}