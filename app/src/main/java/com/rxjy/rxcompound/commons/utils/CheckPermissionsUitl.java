package com.rxjy.rxcompound.commons.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr雷 on 2016/12/20.
 */
public class CheckPermissionsUitl extends Activity {

    public final static int PERMISSON_REQUESTCODE = 0;

    /**
     * *
     * * @param needRequestPermissonList
     * * @since 2.5.0 * requestPermissions方法是请求某一权限，
     */
    public static void checkPermissions(Context context, String[] needPermissions) {
        List needRequestPermissonList = findDeniedPermissions(context, needPermissions);
        if (null != needRequestPermissonList && needRequestPermissonList.size() > 0) {
            ActivityCompat.requestPermissions((Activity) context, (String[]) needRequestPermissonList.toArray(new String[needRequestPermissonList.size()]), PERMISSON_REQUESTCODE);
        }
    }

    /**
     * 获取权限集中需要申请权限的列表 *
     * * @param permissions
     * * @return
     * * @since 2.5.0
     * * checkSelfPermission方法是在用来判断是否app已经获取到某一个权限
     * * shouldShowRequestPermissionRationale方法用来判断是否
     * * 显示申请权限对话框，如果同意了或者不在询问则返回false
     */
    public static List findDeniedPermissions(Context context, String[] permissions) {
        List needRequestPermissonList = new ArrayList();
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(context, perm) != PackageManager.PERMISSION_GRANTED) {
                needRequestPermissonList.add(perm);
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, perm)) {
                    needRequestPermissonList.add(perm);
                }
            }
        }
        return needRequestPermissonList;
    }

    /**
     * * 检测是否所有的权限都已经授权
     * * @param grantResults
     * * @return
     * * @since 2.5.0
     * *
     */
    public boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * * 申请权限结果的回调方法
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
                showMissingPermissionDialog();
            }
        }
    }

    /**
     * * 显示提示信息
     * *
     * * @since 2.5.0
     */
    private void showMissingPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("当前应用缺少必要权限。请点击\"设置\"-\"权限\"-打开所需权限。");
        // 拒绝, 退出应用
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /**
     * * 启动应用的设置
     * *
     * * @since 2.5.0
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

}
