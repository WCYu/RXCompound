package com.rxjy.rxcompound.commons.utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
public class CompressUtil
{

    public static final String CAMERA_SMALL_PHOTO_PATH = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "WPS" + File.separator + "smallPhoto" + File.separator;

    public interface CallBack
    {

        void callBack(List<String> imgList);

    }

    private CallBack callBack;

    public CompressUtil()
    {
    }

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            List<String> smallList = (List<String>) msg.obj;
            callBack.callBack(smallList);
        }
    };

    public void compressPicture(final List<String> dataList, CallBack callBack)
    {
        this.callBack = callBack;
        new Thread()
        {
            @Override
            public void run()
            {

                List<String> smallList = new ArrayList<>();

                //将图片转换为小图
                for (String imgUrl : dataList)
                {
                    smallList.add(PictureUtil.compressImage(imgUrl, CAMERA_SMALL_PHOTO_PATH, 94));
                }

                Message msg = Message.obtain();
                msg.obj = smallList;
                mHandler.sendMessage(msg);
            }
        }.start();
    }


}
