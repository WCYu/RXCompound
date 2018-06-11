package com.rxjy.rxcompound.des.activity;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.AutoUtils;

/**
 * Created by asus on 2018/5/23.
 */

public class TextActivity extends BaseActivity {

    private AlertDialog alertDialog;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.home_dialog, null);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(inflate);
       ImageView image= (ImageView) inflate.findViewById(R.id.delete_image);

        dialog.setView(inflate);
        alertDialog = dialog.create();
        alertDialog.show();
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
