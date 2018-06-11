package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.CompressUtil;
import com.rxjy.rxcompound.des.adapter.DesAlbumXJAdapter;
import com.rxjy.rxcompound.des.entity.GetXunjianXQYInfo;
import com.rxjy.rxcompound.des.entity.UpXJPicInfo;
import com.rxjy.rxcompound.des.mvp.contract.XunjianXQYContract;
import com.rxjy.rxcompound.des.mvp.presenter.XunjianXQYPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class JinduxunjianXQYActivty extends BaseActivity<XunjianXQYPresenter> implements XunjianXQYContract.View,AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_jinduxunjian_content)
    EditText etJinduxunjianContent;
    @Bind(R.id.tv_jinduxunjian_address)
    TextView tvJinduxunjianAddress;
    @Bind(R.id.gv_des_album)
    GridView gvDesAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_jinduxunjian_xqyactivty);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_jinduxunjian_xqyactivty;
    }

    String stateName;

    private List<GetXunjianXQYInfo.BodyBean.ChildListBean> imgList;

    private DesAlbumXJAdapter mDesAdapter;

    private List<GetXunjianXQYInfo.BodyBean.ChildListBean> daiImgList;

   int scid;
    int dborwcbs=0;
    @Override
    public void initData() {

        stateName = getIntent().getStringExtra("stateName");

        imgList = new ArrayList<>();
       if (stateName.equals("待办")) {
           imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean());
           dborwcbs=1;
       }

        mDesAdapter = new DesAlbumXJAdapter(this, imgList, this, -1,dborwcbs);

        gvDesAlbum.setAdapter(mDesAdapter);

        gvDesAlbum.setOnItemClickListener(this);

        scid = getIntent().getIntExtra("scid", -1);

        //if (stateName.equals("完成")) {
            mPresenter.GetScheduleCheckIno(scid + "");
        //}
        /**
         * todo
         * 百度定位
         */
//        tvJinduxunjianAddress.setText(App.city + App.district + App.street);
        tvJinduxunjianAddress.setText("城市地址" + "区" + "街道");

        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.SubmitCheckDes(scid + "", etJinduxunjianContent.getText().toString(), tvJinduxunjianAddress.getText().toString());
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected XunjianXQYPresenter onCreatePresenter() {
        return new XunjianXQYPresenter(this);
    }

    @Override
    public void responseGetXunjianXinxiData(GetXunjianXQYInfo info) {
        if (stateName.equals("完成")) {
            etJinduxunjianContent.setFocusable(false);
            etJinduxunjianContent.setFocusableInTouchMode(false);
            tvSubmit.setVisibility(View.INVISIBLE);
        }
        etJinduxunjianContent.setText(info.getBody().getDescription());
        tvJinduxunjianAddress.setText(info.getBody().getActualCheckAddress());

        daiImgList=info.getBody().getChildList();



        for (GetXunjianXQYInfo.BodyBean.ChildListBean Imginfo : daiImgList) {
            imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean(Imginfo.getSi_Id(), Imginfo.getSi_ImageUrl()));
        }
        mDesAdapter.notifyDataSetChanged();




    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (imgList != null)
        {
            if (imgList.size() > 0)
            {
                if (!(imgList.get(imgList.size() - 1).getSi_ImageUrl() == null))
                {
                    imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean());
                }
            } else
            {
                imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean());
            }
            mDesAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void responseUpXunjianXinxiData(String msg) {
        showToast(msg);
        finish();
    }

    @Override
    public void responseXunjianDataError(String msg) {
        //showToast(msg);
        imgList.remove(deletePosition);
        mDesAdapter.notifyDataSetChanged();

    }

    @Override
    public void UpKaigongPicInfo(UpXJPicInfo info) {
        imgList.remove(imgList.size() - 1);
        for (UpXJPicInfo.BodyBean Imginfo : info.getBody())
        {
            imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean(Imginfo.getSi_Id(), Imginfo.getSi_ImageUrl()));
        }
        //多添加一个作为上传照片的入口
        imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean());
        mDesAdapter.notifyDataSetChanged();
        showToast("上传成功");
    }

    @Override
    public void UpKaigongPicInfoError(UpXJPicInfo info) {
        //多添加一个作为上传照片的入口
        imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean());
        mDesAdapter.notifyDataSetChanged();
        showToast("上传失败");
    }


    private int deletePosition;
    @Override
    public void DeleteKaigongPicInfo(GetXunjianXQYInfo.BodyBean.ChildListBean img,int position) {
        deletePosition = position;
        //删除图片
        Log.e("img",img.getSi_Id()+"|"+img.getSi_ImageUrl());
        mPresenter.DeleteloadCheckImages(img.getSi_Id()+"", img.getSi_ImageUrl());
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == mDesAdapter.getCount() - 1)
        {
            if (position == imgList.size() - 1)
            {
                if (imgList.size() != 0)
                {
                    imgList.remove(imgList.size() - 1);
                }
                Intent intent = new Intent(JinduxunjianXQYActivty.this, WpsLocalPhotoActivityh.class);
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
                urllist.add(imgList.get(i).getSi_ImageUrl());
            }
            watchLargerImage(Constants.WenesImgBaseURl,urllist,position);
        }


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
                    imgList.add(new GetXunjianXQYInfo.BodyBean.ChildListBean());
                    mDesAdapter.notifyDataSetChanged();
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
                            mPresenter.UploadCheckImages(scid+"", imgList);
                        }
                    });
                }
            }
        }
    }


}
