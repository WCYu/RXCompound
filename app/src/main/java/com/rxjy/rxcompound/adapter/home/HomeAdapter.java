package com.rxjy.rxcompound.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxjy.rxcompound.R;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/22.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    ArrayList arrayList;

    public HomeAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View headerView = LayoutInflater.from(context).inflate(R.layout.item_home_header, parent, false);
        ViewHolder viewHolder = new ViewHolder(headerView);
//        switch (viewType) {
//            case 0:
//                View headerView = LayoutInflater.from(context).inflate(R.layout.item_home_header, parent, false);
//                viewHolder = new ViewHolder(headerView);
//                break;
//            case 1:
//                View oneView = LayoutInflater.from(context).inflate(R.layout.item_home_header, parent, false);
//                viewHolder = new ViewHolder(oneView);
//                break;
//            default:
//
//                break;
//        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
