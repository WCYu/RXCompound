package com.rxjy.rxcompound.des.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.des.activity.DesAlbumActivity;
import com.rxjy.rxcompound.des.activity.DesDaiMeasureActivity;
import com.rxjy.rxcompound.des.adapter.DesDaiImgAdapter;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiSurroundingsContract;
import com.rxjy.rxcompound.des.mvp.presenter.DesDaiSurroundingsPresenter;
import com.rxjy.rxcompound.des.photo.MyCameraActivity;
import com.rxjy.rxcompound.widget.CustomGridView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;

/**
 * Created by Administrator on 2017/6/16.
 */
public class DesDaiSurroundingsFragment extends BaseFragment<DesDaiSurroundingsPresenter> implements View.OnClickListener, AdapterView.OnItemClickListener, DesDaiSurroundingsContract.View {
    int position;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.takePhoto:
                //Toast.makeText(getActivity(),"点击了拍照",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MyCameraActivity.class);
                intent.putExtra("MYCAMERAPOS", position + 14);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, clientInfo);
                intent.putExtra("AINFO", ainfo);
                startActivity(intent);
                dialog.dismiss();
                break;
            case R.id.choosePhoto:
                //Toast.makeText(getActivity(),"点击了选择照片",Toast.LENGTH_SHORT).show();

                AllImagesInfo.Album info = albumList.get(position);
                List<AllImagesInfo.Album.image> imageList = info.getChildList();
                Intent albumIntent = new Intent(getActivity(), DesAlbumActivity.class);
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<AllImagesInfo.Album.image>) imageList);
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, clientInfo.getWorksID());
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, clientInfo.getCustomerID());
                startActivity(albumIntent);
                dialog.dismiss();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }

    }

    @Bind(R.id.gv_des_dai_surroundings_photo)
    CustomGridView gvDesDaiSurroundingsPhoto;

    private List<AllImagesInfo.Album> albumList;

    private DesDaiImgAdapter mAdapter;

    //客户信息
    private AllClientNewBean.ClientNewBean clientInfo;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_des_dai_surrongdings;
    }


    DesDaiMeasureActivity activity;
    @Override
    protected void FragmentInitData() {
        activity = (DesDaiMeasureActivity) getActivity();
        initPhotoData();
    }

    public void setClientInfo(AllClientNewBean.ClientNewBean info) {
        clientInfo = info;
    }

    private void initPhotoData() {
        albumList = new ArrayList<>();

        mAdapter = new DesDaiImgAdapter(getActivity(), albumList);

        gvDesDaiSurroundingsPhoto.setAdapter(mAdapter);

        gvDesDaiSurroundingsPhoto.setOnItemClickListener(this);
    }

    @Override
    protected DesDaiSurroundingsPresenter onCreatePresenter() {
        return new DesDaiSurroundingsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //请求环境图片列表
        mPresenter.getDaiSurroundingsData(clientInfo.getCi_RwdId(), "2", "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    double allmoney;
    BigDecimal bigDecimal;
    double showmoney;
    int nowphotonum;
    int moneynum;
    @Override
    public void responseDaiSurroundingsData(List<AllImagesInfo.Album> dataList) {
        Log.e("dataList==",dataList.toString());
        albumList.clear();
        albumList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
        //设置钱数。。个数
        nowphotonum=0;
        for (int i = 0; i < dataList.size(); i++) {
            if(dataList.get(i).getChildList().size()>0){
                nowphotonum=nowphotonum+1;
            }
        }
        Log.e("nowphotonum",nowphotonum+"");
        Log.e("当前个数总：",activity.moneynum+"");
        Log.e("提交的个数总：",activity.moneynum-activity.qyphotonum+nowphotonum+"");
        activity.setMoneynum(activity.moneynum-activity.qyphotonum+nowphotonum);
        moneynum=activity.moneynum-activity.qyphotonum+nowphotonum;
        allmoney = activity.getmaxmoney;
        showmoney=allmoney / LF_NUM * moneynum;
        bigDecimal=new BigDecimal(showmoney);
        showmoney=bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
    }

    @Override
    public void responseDaiSurroundingsError(String msg) {
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

    private AllImagesInfo.Album ainfo;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        this.position = position;
        AllImagesInfo.Album info = albumList.get(position);
        ainfo = info;
        int size = info.getChildList().size();
        if (size == 0) {
            show();
        } else {
            List<AllImagesInfo.Album.image> imageList = info.getChildList();
            Intent albumIntent = new Intent(getActivity(), DesAlbumActivity.class);
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<AllImagesInfo.Album.image>) imageList);
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, clientInfo.getWorksID());
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, clientInfo.getCustomerID());
            startActivity(albumIntent);
        }
    }

    private View inflate;
    private Button choosePhoto;
    private Button takePhoto;
    private Button cancel;
    private Dialog dialog;
    public void show() {
        dialog = new Dialog(getActivity(), R.style.ActionSheetDialogStyle);
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog, null);
        choosePhoto = (Button) inflate.findViewById(R.id.choosePhoto);
        takePhoto = (Button) inflate.findViewById(R.id.takePhoto);
        cancel = (Button) inflate.findViewById(R.id.btn_cancel);
        choosePhoto.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        cancel.setOnClickListener(this);
        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;
        dialogWindow.setAttributes(lp);
        dialog.show();
    }

}
