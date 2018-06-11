package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.CompressUtil;
import com.rxjy.rxcompound.des.adapter.DesAlbumAdapter;
import com.rxjy.rxcompound.des.entity.AlbumImgInfo;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesAlbumContract;
import com.rxjy.rxcompound.des.mvp.presenter.DesAlbumPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesAlbumActivityhd extends BaseActivity<DesAlbumPresenter> implements DesAlbumContract.View, AdapterView.OnItemClickListener
{

    public static final String TITLE = "网络相册";

    @Bind(R.id.iv_back)
    ImageView ivHeaderBack;
    @Bind(R.id.tv_title)
    TextView tvHeaderTitle;
    @Bind(R.id.gv_des_album)
    GridView gvDesAlbum;

    private List<AllImagesInfo.Album.image> imgList;

    private DesAlbumAdapter mAdapter;

    private List<AllImagesInfo.Album.image> daiImgList;

    private int worksID;
    private int catalogID;
    private String userID;

    private int deletePosition;

    @Override
    public int getLayout()
    {
        return R.layout.activity_des_album;
    }

    @Override
    public void initData()
    {
        initIntentData();
        initTitle();
        initPhotoData();
    }

    private void initIntentData()
    {
        daiImgList = (List<AllImagesInfo.Album.image>) getIntent().getSerializableExtra(Constants.ACTION_TO_ALBUM_IMG_INFO);
        worksID = getIntent().getIntExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, -1);
        catalogID = getIntent().getIntExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, -1);
        userID = getIntent().getStringExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID);
    }

    private void initTitle()
    {
        ivHeaderBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(TITLE);
    }

    private void initPhotoData()
    {
        imgList = new ArrayList<>();

        for (AllImagesInfo.Album.image info : daiImgList)
        {
            imgList.add(new AllImagesInfo.Album.image(info.getDetailID(), info.getImageUrl()));
        }

        imgList.add(new AllImagesInfo.Album.image());

        mAdapter = new DesAlbumAdapter(this, imgList, this,-1);

        gvDesAlbum.setAdapter(mAdapter);

        gvDesAlbum.setOnItemClickListener(this);
    }

    @Override
    protected DesAlbumPresenter onCreatePresenter()
    {
        return new DesAlbumPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (imgList != null)
        {
            if (imgList.size() > 0)
            {
                if (!(imgList.get(imgList.size() - 1).getImageUrl() == null))
                {
                    imgList.add(new AllImagesInfo.Album.image());
                }
            } else
            {
                imgList.add(new AllImagesInfo.Album.image());
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @OnClick(R.id.iv_back)
    public void onClick()
    {
        finish();
    }


    @Override
    public void responseSubImageData(List<AlbumImgInfo.ImgInfo> dataList)
    {
        imgList.remove(imgList.size() - 1);
        for (AlbumImgInfo.ImgInfo info : dataList)
        {
            imgList.add(new AllImagesInfo.Album.image(info.getDetailID(), info.getImageUrl()));
        }
        //多添加一个作为上传照片的入口
        imgList.add(new AllImagesInfo.Album.image());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseSubImageDataError(String msg)
    {
        showToast(msg);
        //多添加一个作为上传照片的入口
        imgList.add(new AllImagesInfo.Album.image());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseDeleteImageData()
    {
        imgList.remove(deletePosition);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseDeleteImageDataError(String msg)
    {
        showToast(msg);
    }

    @Override
    public void deletePhoto(AllImagesInfo.Album.image img, int position)
    {
        deletePosition = position;
        //删除图片
        mPresenter.deleteImage(img.getDetailID(), img.getImageUrl());
    }

    @Override
    public void deletePhoto(GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image img, int position) {

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK)
        {
            if (requestCode == Constants.DES_ALBUM_CODE)
            {
                //得到返回的照片
                List<String> imgUrls = data.getStringArrayListExtra(Constants.BACK_TO_DES_ALBUM);
                if (imgUrls.size() == 0)
                {
                    //多添加一个作为上传照片的入口
                    imgList.add(new AllImagesInfo.Album.image());
                    mAdapter.notifyDataSetChanged();
                } else
                {
                    showDialog();
                    //图片压缩
                    CompressUtil compressUtil = new CompressUtil();
                    compressUtil.compressPicture(imgUrls, new CompressUtil.CallBack()
                    {
                        @Override
                        public void callBack(List<String> imgList)
                        {
                            //上传图片
                            mPresenter.subImage(worksID, catalogID, userID, imgList);
                        }
                    });
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        AllImagesInfo.Album.image info = imgList.get(position);
        if (position == mAdapter.getCount() - 1)
        {
            if (position == imgList.size() - 1)
            {
                if (imgList.size() != 0)
                {
                    imgList.remove(imgList.size() - 1);
                }
                Intent intent = new Intent(DesAlbumActivityhd.this, WpsLocalPhotoActivityh.class);
                intent.putExtra(Constants.IS_ONLY_ONE_IMAGE, Constants.UNONLY_ONE_PHOTO);
                intent.putExtra(Constants.IS_SHOW_SELECTOR_PHOTO, Constants.HIDE_SELECTOR_PHOTO);
                intent.putExtra(Constants.WHERE, Constants.DES_ALBUM);
                startActivityForResult(intent, Constants.DES_ALBUM_CODE);
            }
        } else
        {
            int size=imgList.size();
            List<String> urllist = new ArrayList<>();
            for(int i=0;i<size;i++){
                urllist.add(imgList.get(i).getImageUrl());
            }
            watchLargerImage(Constants.WenesImgBaseURl,urllist,position);
        }
    }
}
