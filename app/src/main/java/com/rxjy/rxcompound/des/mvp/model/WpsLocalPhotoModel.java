package com.rxjy.rxcompound.des.mvp.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.rxjy.rxcompound.des.mvp.contract.IWpsLocalPhotoContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/9.
 */
public class WpsLocalPhotoModel implements IWpsLocalPhotoContract.Model {

    /**
     * 临时的辅助类，用于防止同一个文件夹的多次扫描
     */
    private HashSet<String> mDirPaths;

    List<String> ivlist = new ArrayList<>();

    @Override
    public Observable<List<String>> getPhotoes(final Context context) {

        Observable<List<String>> photoes = Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                mDirPaths = new HashSet<String>();
                //清空集合释放资源，避免重复添加
                ivlist.clear();

                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver = context.getContentResolver();

                // 只查询jpeg和png的图片
                Cursor mCursor = mContentResolver.query(mImageUri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or "
                                + MediaStore.Images.Media.MIME_TYPE + "=? ",
                        new String[]{"image/jpeg", "image/png"},
                        MediaStore.Images.Media.DATE_MODIFIED);

                while (mCursor.moveToNext()) {
                    // 获取图片的路径
                    String path = mCursor.getString(mCursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));

                    //获取图片大小
                    int size = mCursor.getInt(mCursor.getColumnIndex(MediaStore.Images.Media.SIZE));
                    //把照片路径添加到集合中
                    if (size > 10000)
                        ivlist.add(path);

                    // 获取该图片的父路径名
                    File parentFile = new File(path).getParentFile();
                    if (parentFile == null)
                        continue;
                    String dirPath = parentFile.getAbsolutePath();
                    // 利用一个HashSet防止多次扫描同一个文件夹（不加这个判断，图片多起来还是相当恐怖的~~）
                    if (mDirPaths.contains(dirPath)) {
                        continue;
                    } else {
                        mDirPaths.add(dirPath);
                    }

                }
                mCursor.close();

                //将集合倒序
                Collections.reverse(ivlist);

                subscriber.onNext(ivlist);
                //subscriber.onCompleted();

                // 扫描完成，辅助的HashSet也就可以释放内存了
                mDirPaths = null;
            }
        }).compose(RxSchedulers.<List<String>>switchThread());

        return photoes;
    }
}
