package com.rxjy.rxcompound.commons.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hjh on 2017/11/7.
 */

public class ShowUtils {

    /**
     * 短吐司
     * @param context
     * @param str
     */
    public static void Toastshort(Context context,String str) {
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }

    /**
     * 长吐司
     * @param context
     * @param str
     */
    public static void Toastlong(Context context,String str) {
        Toast.makeText(context,str,Toast.LENGTH_LONG).show();
    }
}
