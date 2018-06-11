package com.rxjy.rxcompound.supervision.mvp.model;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.entity.ProblemInfo;
import com.rxjy.rxcompound.supervision.entity.RemarkInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.NewRoutingSubContract;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2018/1/17.
 */

public class NewRoutingSubModel implements NewRoutingSubContract.Model {
    @Override
    public Observable<String> getProblemList() {
        return ApiEngine.getInstance().getGcApiService()
                .getNewProblemList()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subXJProblem(int xjID, String orderNo, String content, String count, double xjX, double xjY, String address, int type, List<ProblemInfo.Problem> proList) {

        List<MultipartBody.Part> list = new ArrayList<>();

        List<RemarkInfo> reList = new ArrayList<>();

        String tag = "";

        for (ProblemInfo.Problem proInfo : proList) {
            if (proInfo.getPhotoList() != null)
                for (LocalMedia imgUrl : proInfo.getPhotoList()) {
                    //将照片路径转换为File对象
                    File file = new File(imgUrl.getCompressPath());
                    //创建RequestBody ,用于Retrofit2.0上传照片
                    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    // MultipartBody.Part  和后端约定好Key，这里的partName是用image
                    MultipartBody.Part body =
                            MultipartBody.Part.createFormData(proInfo.getXj_id() + "", file.getName(), requestFile);
                    list.add(body);
                }
            if (proInfo.getRemark() != null) {
                reList.add(new RemarkInfo(proInfo.getXj_id(), proInfo.getRemark()));
            }
            if (proInfo.getPhotoList() != null || proInfo.getRemark() != null)
                tag = tag + (proInfo.getXj_id() + ",");
        }

        if (!tag.equals("")) {
            tag = tag.substring(0, (tag.length() - 1));
        }

        String reJson = JSONUtils.toString(reList);

        return ApiEngine.getInstance().getGcApiService()
                .subNewXJProblem(xjID, orderNo, content, count, tag, address, xjX, xjY, type, reJson, list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
