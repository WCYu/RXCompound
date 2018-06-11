package com.rxjy.rxcompound.des.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.adapter.WpsLocalPhotoAdapterh;
import com.rxjy.rxcompound.des.mvp.contract.IWpsLocalPhotoContract;
import com.rxjy.rxcompound.des.mvp.presenter.WpsLocalPhotoPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WpsLocalPhotoActivityh extends BaseActivity<WpsLocalPhotoPresenter> implements IWpsLocalPhotoContract.View {
    @Bind(R.id.iv_back)
    ImageView ivHeaderBack;
    @Bind(R.id.tv_title)
    TextView tvHeaderTitle;
    @Bind(R.id.gv_photo)
    GridView gvPhoto;
    @Bind(R.id.tv_selector_count)
    TextView tvSelectorCount;
    @Bind(R.id.tv_complete)
    TextView tvComplete;

    private final String TITLE = "手机相册";

    /**
     * 所有照片
     */
    private List<String> mImgs;
    /**
     * 图片列表适配器
     */
    private WpsLocalPhotoAdapterh mWpsLocalPhotoAdapter;
    /**
     * 被选择的照片的集合
     */
    private ArrayList<String> imgSelector;
    /**
     * 照片存储路径
     */
    File photoFile;
    /**
     * 标记是从哪个界面跳转过来的
     */
    private int where;

    private List<String> hasSelector = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.activity_wps_local_photo;
    }

    @Override
    public void initData() {
        initTitle();
        initPhoto();
        initSelectorPhoto();

    }

    private void initSelectorPhoto() {
        if (hasSelector.size() != 0) {
            imgSelector.addAll(hasSelector);
            mWpsLocalPhotoAdapter.setHasSelector(imgSelector);
            tvSelectorCount.setText(imgSelector.size()+"张");
        }
    }

    private void initTitle() {
        //鏄剧ず鎺т欢
        ivHeaderBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setVisibility(View.VISIBLE);
        //璁剧疆鏍囬
        tvHeaderTitle.setText(TITLE);
    }

    private void initPhoto() {

        where = getIntent().getIntExtra(Constants.WHERE, -1);

        int imgCountType = getIntent().getIntExtra(Constants.IS_ONLY_ONE_IMAGE, 0);

        int isShowSelectorPhoto = getIntent().getIntExtra(Constants.IS_SHOW_SELECTOR_PHOTO, -1);

        if (isShowSelectorPhoto == Constants.SHOW_SELECTOR_PHOTO) {
            hasSelector.addAll(getIntent().getStringArrayListExtra(Constants.HAS_SELECTOR_PHOTO));
        }

        imgSelector = new ArrayList<>();

        mImgs = new ArrayList<>();

        mWpsLocalPhotoAdapter = new WpsLocalPhotoAdapterh(this, mImgs);

        mWpsLocalPhotoAdapter.setSelectedListener(this, imgCountType);

        gvPhoto.setAdapter(mWpsLocalPhotoAdapter);

        //寮€鍚繘搴︽潯
        showLoading();
        //鑾峰彇鍥剧墖
        mPresenter.getPhotoes(this);

    }

    @Override
    protected WpsLocalPhotoPresenter onCreatePresenter() {
        return new WpsLocalPhotoPresenter(this);
    }

    @Override
    public void responsePhotoes(List<String> imgs) {
        dismissLoading();
        //娣诲姞涔嬪墠鍏堟竻闄や竴涓嬮泦鍚堬紝浠ュ厤鐓х墖閲嶅娣诲姞
        mImgs.clear();

        mImgs.addAll(imgs);

        //灏嗙涓€寮犲浘鐗囪缃负璋冪敤绯荤粺鐩告満鍥剧墖
        mImgs.add(0, String.valueOf(R.mipmap.camera));

        mWpsLocalPhotoAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseToast() {
        showToast("只能选择一张照片");
    }

    @Override
    public void responseStartCamera() {
        startCamera();
    }

    @Override
    public void responseSelectedPhotoes(String imgSelected, int type) {
        if (type == Constants.IV_ADD) {
            imgSelector.add(imgSelected);
        } else if (type == Constants.IV_REMOVE) {
            imgSelector.remove(imgSelected);
        }
        tvSelectorCount.setText(imgSelector.size() + "张");
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    private void startCamera() {
        File file = new File(Constants.CAMERA_PHOTO_PATH);
        if (!file.exists() && !file.mkdirs()) {
            Toast.makeText(this, "无法创建WPS_images文件夹", Toast.LENGTH_SHORT).show();
            return;
        }
        String photoName = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
        photoFile = new File(file, photoName);
        Uri uri = Uri.fromFile(photoFile);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, Constants.CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == Constants.CAMERA_REQUEST_CODE) {
                //灏嗘柊鎷嶆憚鐨勭収鐗囦俊鎭坊鍔犲埌绯荤粺鐩稿唽鏁版嵁搴撲腑
                MediaScannerConnection.scanFile(this, new String[]{photoFile.toString()}, null, null);
                //鑾峰彇鍥剧墖
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            Message msg = Message.obtain();
                            mHandler.sendMessage(msg);
                        } catch (Exception e) {
                            e.toString();
                        }
                    }
                }).start();
            }
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showToast("拍摄成功");
            //鑾峰彇鍥剧墖
            mPresenter.getPhotoes(WpsLocalPhotoActivityh.this);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_complete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_complete:
                switch (where) {
                    case Constants.ROUTING_INSPECTION_SUB:
                        Intent backToRoutingSub = new Intent();
                        backToRoutingSub.putExtra(Constants.BACK_TO_ROUTING_SUB, imgSelector);
                        setResult(RESULT_OK, backToRoutingSub);
                        finish();
                        break;
                    case Constants.READY_DETAIL_SUB:
                        Intent backToReadyDetail = new Intent();
                        backToReadyDetail.putExtra(Constants.BACK_TO_READY_DETAIL, imgSelector);
                        setResult(RESULT_OK, backToReadyDetail);
                        finish();
                        break;
                    case Constants.COMPLETE_EFFECT_SUB:
                        Intent completeEffect = new Intent();
                        completeEffect.putExtra(Constants.BACK_TO_COMPLETE_EFFECT, imgSelector.get(0));
                        setResult(RESULT_OK, completeEffect);
                        finish();
                        break;
                    case Constants.DES_ALBUM:
                        Intent backToDesAlbum = new Intent();
                        backToDesAlbum.putExtra(Constants.BACK_TO_DES_ALBUM, imgSelector);
                        setResult(RESULT_OK, backToDesAlbum);
                        finish();
                        break;
                    case Constants.DES_COMPLETE_ALBUM:
                        Intent backToDesCompleteAlbum = new Intent();
                        backToDesCompleteAlbum.putExtra(Constants.BACK_TO_DES_COMPLETE_ALBUM, imgSelector);
                        setResult(RESULT_OK, backToDesCompleteAlbum);
                        finish();
                        break;
                    case Constants.PM_CRAFT_DETAIL:
                        Intent craftDetail = new Intent();
                        craftDetail.putExtra(Constants.BACK_TO_PM_CRAFT_DETAIL, imgSelector.get(0));
                        setResult(RESULT_OK, craftDetail);
                        finish();
                        break;
                    case Constants.PM_PROCESS_DETAIL:
                        Intent processDetail = new Intent();
                        processDetail.putExtra(Constants.BACK_TO_PM_PROCESS_DETAIL, imgSelector.get(0));
                        setResult(RESULT_OK, processDetail);
                        finish();
                        break;
                    case Constants.PM_SURROUNDINGS_DETAIL:
                        Intent surroundingsDetail = new Intent();
                        surroundingsDetail.putExtra(Constants.BACK_TO_PM_SURROUNDINGS_DETAIL, imgSelector.get(0));
                        setResult(RESULT_OK, surroundingsDetail);
                        finish();
                        break;
//                    case Constants.ROUTING_DISBURSEMENT_DETAIL:
//                        Intent backToConfirmDeliver = new Intent();
//                        backToConfirmDeliver.putExtra(Constants.BACK_TO_CONFIRM_DELIVERY, imgSelector);
//                        setResult(RESULT_OK, backToConfirmDeliver);
//                        finish();
//                        break;
//                    case Constants.PREPARE_DETAIL:
//                        Intent backToPrepareDetail = new Intent();
//                        backToPrepareDetail.putExtra(Constants.BACK_TO_PREPARE_DETAIL, imgSelector.get(0));
//                        setResult(RESULT_OK, backToPrepareDetail);
//                        finish();
//                        break;
//                    case Constants.ROUTING_INSPECTION_SUB:
//                        Intent backToRoutingInspectionSub = new Intent();
//                        backToRoutingInspectionSub.putExtra(Constants.BACK_TO_ROUTING_INSPECTION_SUB, imgSelector);
//                        setResult(RESULT_OK, backToRoutingInspectionSub);
//                        finish();
//                        break;
//                    case Constants.CAMERA_UNINSTALLED:
//                        Intent backToCameraUninstalled = new Intent();
//                        backToCameraUninstalled.putExtra(Constants.BACK_TO_CAMERA_UNINSTALLED, imgSelector.get(0));
//                        setResult(RESULT_OK, backToCameraUninstalled);
//                        finish();
//                        break;
                }
                break;
        }
    }
}
