package com.rxjy.rxcompound.supervision.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.adapter.PaperAdapter;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PaperContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.PaperPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by AAA on 2017/12/21.
 */

public class PaperFragment extends BaseFragment<PaperPresenter> implements PaperContract.View, PaperAdapter.OnPaperAdapterClickListener {
    @Bind(R.id.lv_paper)
    ListView lvPaper;

    private List<DatumListInfo.DatumInfo.Datum> datumList;

    private PaperAdapter mAdapter;

    private DatumListInfo.DatumInfo.Datum datum;

    private ProjectListInfo.Project proInfo;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_paper;
    }

    @Override
    protected void FragmentInitData() {
        initIntent();
        initPaper();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getArguments().getSerializable(Constants.ACTION_TO_PAPER_PRO_INFO);
    }

    private void initPaper() {

        datumList = new ArrayList<>();

        mAdapter = new PaperAdapter(getActivity(), datumList);

        mAdapter.setOnPaperAdapterClickListener(this);

        lvPaper.setAdapter(mAdapter);

        mPresenter.getPaperInfo(proInfo.getOrderNo());

    }

    @Override
    protected PaperPresenter onCreatePresenter() {
        return new PaperPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    String url = localMedias.get(0).getCompressPath();
                    mPresenter.uploadPaperInfo(proInfo.getOrderNo(), datum.getAttr_category(), datum.getAttr_model_id(), datum.getOrderid(), url);
                    break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void responsePaperData(DatumListInfo.DatumInfo data) {
        datumList.clear();
        if (data.getAgoInfo().size() != 0) {
            datumList.add(new DatumListInfo.DatumInfo.Datum(1, "前期资料"));
            datumList.addAll(data.getAgoInfo());
        }
        if (data.getMidInfo().size() != 0) {
            datumList.add(new DatumListInfo.DatumInfo.Datum(1, "中期资料"));
            datumList.addAll(data.getMidInfo());
        }
        if (data.getEndInfo().size() != 0) {
            datumList.add(new DatumListInfo.DatumInfo.Datum(1, "尾期资料"));
            datumList.addAll(data.getEndInfo());
        }
        if (data.getOtherInfo().size() != 0) {
            datumList.add(new DatumListInfo.DatumInfo.Datum(1, "附件资料"));
            datumList.addAll(data.getOtherInfo());
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responsePaperDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUploadPaperData() {
        showToast("上传成功");
        mPresenter.getPaperInfo(proInfo.getOrderNo());
    }

    @Override
    public void responseUploadPaperDataError(String msg) {
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

    @Override
    public void uploadListener(DatumListInfo.DatumInfo.Datum data) {
        datum = data;
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .imageSpanCount(3)// 每行显示个数 int
                .maxSelectNum(1)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .compress(true)// 是否压缩 true or fals
                .isCamera(true)// 是否显示拍照按钮 true or false
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    @Override
    public void readListener(DatumListInfo.DatumInfo.Datum data) {
        photoPreview(data.getUrl());
    }
}
