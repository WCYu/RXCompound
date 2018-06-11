package com.rxjy.rxcompound.mvp.model;

import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.PubLishContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by asus on 2018/5/15.
 */

public class PublishModel implements PubLishContract.Model {
    @Override
    public Observable<String> psetArticleData( String name, String cardno, String author, String cover, String content, String flag) {

        return  ApiEngine.getInstance(). getFBApiService()
                .postPublishArticle(name,cardno,author,cover,content,flag)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upLoadImg(List<String> imglist) {
        List<MultipartBody.Part> list = new ArrayList<>();
        Log.e("用来上传的图片：",imglist.toString());

        for (String url : imglist){
            //将照片路径转换为File对象
            File file = new File(url);
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("files", file.getName(), requestFile);
            list.add(body);
        }

        return ApiEngine.getInstance().getRsApiService()
                .subTzImg(list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
