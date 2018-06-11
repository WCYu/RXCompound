package com.rxjy.rxcompound.des.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.rxjy.rxcompound.des.activity.DesAlbumActivityh;
import com.rxjy.rxcompound.des.activity.DesAlbumActivityhd;
import com.rxjy.rxcompound.des.adapter.DesDaiImgAdapter;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.HetongCatalogsInfo;
import com.rxjy.rxcompound.des.mvp.contract.HetongContract;
import com.rxjy.rxcompound.des.mvp.presenter.HetongPresenter;
import com.rxjy.rxcompound.des.photo.MyCameraActivity;
import com.rxjy.rxcompound.widget.CustomGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HetongFragment extends BaseFragment<HetongPresenter> implements HetongContract.View,View.OnClickListener,AdapterView.OnItemClickListener {


    @Bind(R.id.gv_des_dai_measure_photo)
    CustomGridView gvDesDaiMeasurePhoto;

    private boolean hasrwdID;

    private List<AllImagesInfo.Album> albumList;

    private DesDaiImgAdapter mAdapter;

    //客户信息
    private AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;

    @Override
    protected int getFragmentLayout()
    {
        return R.layout.fragment_new_two;
    }

    @Override
    protected void FragmentInitData()
    {
        initPhotoData();
    }

    public void setClientInfo(AllClientInfo.ClientTypeInfo.ClientInfo info)
    {
        clientInfo = info;
    }

    private void initPhotoData()
    {
        albumList = new ArrayList<>();

        mAdapter = new DesDaiImgAdapter(getActivity(), albumList);

        gvDesDaiMeasurePhoto.setAdapter(mAdapter);

        gvDesDaiMeasurePhoto.setOnItemClickListener(this);
    }


    @Override
    protected HetongPresenter onCreatePresenter()
    {
        return new HetongPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //获取量房图片列表接口
        //mPresenter.getDaiMeasureImageData(clientInfo.getCi_rwdid(), "1", "");
        mPresenter.GetAllImages(clientInfo.getCi_rwdid(),1);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    private int position;
    //@OnClick({R.id.tv_measure_tenancy_term_end_time, R.id.tv_measure_tenancy_term_start_time, R.id.btn_des_dai_measure_sub})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.takePhoto:
                //Toast.makeText(getActivity(),"点击了拍照",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), MyCameraActivity.class);
                intent.putExtra("MYCAMERAPOS", position);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO,clientInfo);
                intent.putExtra("AINFO",ainfo);
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


    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    @Override
    public void responsePicImgCatalogs() {

    }

    @Override
    public void responsedataerror(HetongCatalogsInfo info) {

    }

    @Override
    public void responseAllImg(List<AllImagesInfo.Album> dataList) {
        albumList.clear();
        albumList.addAll(dataList);
        //  Log.e("data",dataList.size());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDialog()
    {
        showLoading();
    }

    @Override
    public void hideDialog()
    {
        dismissLoading();
    }

    private AllImagesInfo.Album ainfo;
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        this.position=position;
        AllImagesInfo.Album info = albumList.get(position);
        ainfo=info;
        int size=info.getChildList().size();
//        if (size==0) {
//            show();
//        }else {


            List<AllImagesInfo.Album.image> imageList = info.getChildList();
        Intent albumIntent;
        if (info.getCatalogID()==98){
            albumIntent = new Intent(getActivity(), DesAlbumActivityhd.class);
        }else {
            albumIntent = new Intent(getActivity(), DesAlbumActivityh.class);
        }
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<AllImagesInfo.Album.image>) imageList);
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, clientInfo.getWorksID());
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, clientInfo.getCustomerID());
            startActivity(albumIntent);
    //    }

    }
    private View inflate;
    private Button choosePhoto;
    private Button takePhoto;
    private Button cancel;
    private Dialog dialog;

    public void show(){
        dialog = new Dialog(getActivity(),R.style.ActionSheetDialogStyle);
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog, null);
        choosePhoto = (Button) inflate.findViewById(R.id.choosePhoto);
        takePhoto = (Button) inflate.findViewById(R.id.takePhoto);
        cancel = (Button) inflate.findViewById(R.id.btn_cancel);
        choosePhoto.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        cancel.setOnClickListener(this);
        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity( Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);



        dialog.show();
    }

}
