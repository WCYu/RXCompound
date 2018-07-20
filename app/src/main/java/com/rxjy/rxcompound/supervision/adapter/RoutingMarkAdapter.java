package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.adapter.GridViewAddImgesAdpter;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.ProblemInfo;
import com.rxjy.rxcompound.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2018/1/16.
 */

public class RoutingMarkAdapter extends SingleBaseAdapter<ProblemInfo.Problem, RoutingMarkAdapter.ViewHolder> {


    private List<Map<String, Object>> datas;
    private GridViewAddImgesAdpter mAdapter;

    public interface OnRoutingSubClickListener {

        void onRoutingSubClickListener(int position, ProblemInfo.Problem data, List<Map<String, Object>> datas);

        void onRemarkClickListener(int postion ,ProblemInfo.Problem data);

    }

    private OnRoutingSubClickListener listener;

    public RoutingMarkAdapter(Context context, List<ProblemInfo.Problem> datas) {
        super(context, datas);
    }

    public void setOnRoutingSubClickListener(OnRoutingSubClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_routing_sub_mark;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(final int position, final ProblemInfo.Problem data, final ViewHolder holder) {
        holder.tvName.setText(data.getXj_content());
        holder.tvRemark.setText(data.getRemark() == null ? "请输入工程质量问题..." : data.getRemark());
        switch (position){
            case 0:
                holder.txRout.setText("照片内容:" + "\n" + "水电、防水、地面,抹灰，吊顶，隔墙，钢结构，涂饰，裱糊，安装等各项工程施工工艺验收节点。" + "\n" + "拍照要求：\n" +
                        "各分项工程全局照1张，每个工艺验收节点至少1张，拍照清晰");
                break;
            case 1:
                holder.txRout.setText("拍照内容：\n" +
                        "各区域含墙顶地全方位照片。\n" +
                        "拍照要求：\n" +
                        "每次巡检拍摄站位及角度相同，每次巡检上传所有各区域，例如该项目有3个区域（办公室、财务室、开敞办公区），则上传3张，照片清晰。");
                break;
            case 2:
                holder.txRout.setText("拍照内容：\n" +
                        "1、灭火器；2、二、三级电箱；3、临电施工用线布局；4 、喷淋头烟感保护。\n" +
                        "拍照要求：\n" +
                        "每次巡检上传以上内容，灭火器显示压力表，电箱开门拍细节照；每个内容一张，照片清晰。");
                break;
            case 3:
                holder.txRout.setText("拍照内容：\n" +
                        "1 现场垃圾堆放区；2 操作台、人字梯；；3、安全文明施工标牌、4企业形象宣传标牌。\n" +
                        "拍照要求：\n" +
                        "每次巡检上传以上内容，每个内容一张，照片清晰。");
                break;
            case 4:
                holder.txRout.setText("拍照内容：\n" +
                        "所有到场材料的品牌标识。\n" +
                        "拍照要求：\n" +
                        "现场材料码放远照一张，现场材料品牌标识近照若干（根据到场材料拍照），照片清晰");
                break;
            case 5:
                holder.txRout.setText("拍照内容：\n" +
                        "自拍一张。\n" +
                        "拍照要求："+"\n"+"每次在固定位置拍照（前台或最大空间），含现场进度变化。");
                break;

        }
        if (data.getRemark() == null)
            holder.tvRemark.setTextColor(context.getResources().getColor(R.color.colorGrayLight));
        else
            holder.tvRemark.setTextColor(context.getResources().getColor(R.color.colorGrayDark));
        List<LocalMedia> photoListNew = new ArrayList<>();
        List<LocalMedia> photoList = new ArrayList<>();
        photoList.clear();
        if (data.getPhotoList() != null)
            photoList.addAll(data.getPhotoList());
        datas = new ArrayList<>();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();

        stringObjectHashMap .put("path",R.mipmap.camera_sub_icon);
        datas.add(stringObjectHashMap);
        for (int i = 0; i <photoList.size() ; i++) {
            photoPath(i,photoList.get(i).getCompressPath());
        }
        mAdapter = new GridViewAddImgesAdpter( datas,context);
        holder.hlv.setAdapter(mAdapter);
        holder.hlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null)
                    listener.onRoutingSubClickListener(position, data,datas);
            }
        });
        holder.tvRemark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onRemarkClickListener(position,data);
            }
        });
    }
    public void photoPath(int i ,String path) {
        Map<String,Object> map=new HashMap<>();
        map.put("path",path);
        datas.add(i+1,map);
        mAdapter.notifyDataSetChanged();
    }
    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_routing_sub_mark_name)
        TextView tvName;
        @Bind(R.id.hlv_list_item_routing_sub_mark)
        HorizontalListView hlv;
        @Bind(R.id.tv_list_item_routing_sub_remark)
        TextView tvRemark;
        @Bind(R.id.lin_list_item_routing_sub_mark_remark)
        LinearLayout linRemark;
        @Bind(R.id.tx_rout)
        TextView txRout;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
