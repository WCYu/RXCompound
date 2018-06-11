package com.rxjy.rxcompound.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.des.adapter.TextGridviewAdapter;

import java.util.List;

/**
 * Created by hjh on 2017/12/8.
 */

public class TextGridview extends RelativeLayout {


    String selectcontent = "";

    public String getSelectcontent() {
        return selectcontent;
    }

    public void setSelectcontent(String selectcontent) {
        this.selectcontent = selectcontent;
    }

    TextView tvType;
    TextView tvSelectcontent;
    RelativeLayout rlTop;
    GridView gvOptions;
    ImageView iv_edit;
    int isgone;//GridView是否隐藏了，0未隐藏   1隐藏

    public TextGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.groupv_textgridview, this, true);
        tvType = (TextView) findViewById(R.id.tv_type);
        tvSelectcontent = (TextView) findViewById(R.id.tv_selectcontent);
        rlTop = (RelativeLayout) findViewById(R.id.rl_top);
        gvOptions = (GridView) findViewById(R.id.gv_options);
        iv_edit = (ImageView) findViewById(R.id.iv_edit);
        iv_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (isgone) {
                    case 0:
                        String content = tvSelectcontent.getText().toString();
                        if (content != null && content.length() > 0) {
                            gvOptions.setVisibility(GONE);
                            iv_edit.setVisibility(VISIBLE);
                            tvSelectcontent.setVisibility(VISIBLE);
                            isgone = 1;
                        }
                        break;
                    case 1:
                        gvOptions.setVisibility(VISIBLE);
                        iv_edit.setVisibility(GONE);
                        tvSelectcontent.setVisibility(GONE);
                        isgone = 0;
                        break;
                }
            }
        });
    }


    /**
     * 设置类型标题
     *
     * @param str
     */
    public void setTvType(String str) {
        tvType.setText(str);
    }

    /**
     * 设置选中的内容
     *
     * @param str
     */
    public void setContents(String str, int position) {
        tvSelectcontent.setText(str);
        selectcontent = str;
        gvOptions.setVisibility(GONE);
        iv_edit.setVisibility(VISIBLE);
        tvSelectcontent.setVisibility(VISIBLE);
        isgone = 1;
        if (adapter != null) {
            adapter.setSetstyle(position);
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 设置GridView的列数
     *
     * @param num
     */
    public void setGvLines(int num) {
        gvOptions.setNumColumns(num);
    }

    /**
     * 给GridView赋值
     *
     * @param context
     * @param itemdata
     */
    TextGridviewAdapter adapter;
    public void setGvData(Context context, final List<String> itemdata) {
        adapter = new TextGridviewAdapter(context, itemdata);
        gvOptions.setAdapter(adapter);
        gvOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(choos!=null){
                    choos.tochoose(position);
                }
                tvSelectcontent.setText(itemdata.get(position));
                if (itemdata.get(position) != null) {
                    selectcontent = itemdata.get(position);
                }
                adapter.setSetstyle(position);
                adapter.notifyDataSetChanged();
                gvOptions.setVisibility(GONE);
                iv_edit.setVisibility(VISIBLE);
                tvSelectcontent.setVisibility(VISIBLE);
                isgone = 1;
            }
        });
    }


    private Choose choos;

    public interface Choose{
        void tochoose(int position);
    }

    public void tochoose(Choose chooses){
        choos=chooses;
    }


}
