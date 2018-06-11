package com.rxjy.rxcompound.commons;

import android.os.Environment;

import java.io.File;

/**
 * Created by hjh on 2017/11/3.
 */

public class Constants {
//---------------------------------网络状态标识-------------------------------------------------
    /**
     * Unknown network class
     */
    public static final int NETWORK_CLASS_UNKNOWN = 0;

    /**
     * wifi net work
     */
    public static final int NETWORK_WIFI = 1;

    /**
     * "2G" networks
     */
    public static final int NETWORK_CLASS_2_G = 2;

    /**
     * "3G" networks
     */
    public static final int NETWORK_CLASS_3_G = 3;

    /**
     * "4G" networks
     */
    public static final int NETWORK_CLASS_4_G = 4;

    public static final String IS_FIRST_SPLASH = "first_pref";//是否首次启动
    public static final String IS_SETALIAS = "setalias";//是否设置别名
    public static final String WEBURL_ENTRYJOB = "https://api.dcwzg.com:9191/home/ElectronicProtocol?";//入职需知，瑞祥之歌，瑞祥准则url
    public static final String WEBURL_RESPO = "https://api.dcwzg.com:9191/actionapi/AppCurrencyHome/GetaAgreeElectronicProtocol？";//岗责
    public static final String WEBURL_ANSWER = "http://edu.rx/a/rs/toAnwerQuestionPage?";//岗前答题
    public static final String WEBURL_MOREBANNER = "http://m.rxjy.com/";

    public static final String OFFICE_PUBLIC = "http://edu.rxjy.com";//办公外网域名
    public static final String OFFICE_PRIVATE = "http://edu.rx";//办公内网域名

//    public static final String IS_FIRST_SPLASH = "first_pref";//是否首次启动
//    public static final String IS_FIRST_SPLASH = "first_pref";//是否首次启动
//    public static final String IS_FIRST_SPLASH = "first_pref";//是否首次启动


    /**
     * 温特斯
     */
    public static final String ACTION_TO_MAIN_ACTIVITY = "action_to_main_activity";
    //向待量房传递客户信息
    public static final String ACTION_TO_DAI_MEASURE_CLIENT_INFO = "action_to_dai_measure_client_info";
    //教程标识
    public static final String JIAOCHENG = "jiaocheng";
    //量房获取的金额
    public static int HOUSE_MONEY = 0;

    //网络相册界面传递图片列表
    public static final String ACTION_TO_ALBUM_IMG_INFO = "action_to_album_img_info";
    //网络相册界面传递WorksID
    public static final String ACTION_TO_ALBUM_IMG_WORKS_ID = "action_to_album_img_works_id";
    //网络相册界面传递CatalogID
    public static final String ACTION_TO_ALBUM_IMG_CATALOG_ID = "action_to_album_img_catalog_id";
    //网络相册界面传递UserId
    public static final String ACTION_TO_ALBUM_IMG_USER_ID = "action_to_album_img_user_id";
    //唯一标识
    public static final int EVENT_BASE = 1000;
    // 线上
    public static String WenesImgBaseURl = "http://img0.wenes.cn/Upload/Project/";
//测试
//    public static String WenesImgBaseURl = "http://zatp.wenes.cs/Upload/Project/";
    //网络相册界面图片返回标记
    public static final int DES_ALBUM_CODE = EVENT_BASE + 101;

    //是否可传多张图片
    public static final String IS_ONLY_ONE_IMAGE = "is_only_one_image";
    //是否记录选中照片
    public static final String IS_SHOW_SELECTOR_PHOTO = "is_show_selector_photo";
    //可以选择多张图片
    public static final int UNONLY_ONE_PHOTO = EVENT_BASE + 4;
    //不显示选中照片
    public static final int HIDE_SELECTOR_PHOTO = EVENT_BASE + 7;
    //标记是从哪个界面跳转到手机相册界面
    public static final String WHERE = "where";
    //相册图片回传标识
    public static final String IMAGE_URL_LIST = "image_url_list";
    //图片增加标识
    public static final int IV_ADD = EVENT_BASE + 0;
    //图片减少标识
    public static final int IV_REMOVE = EVENT_BASE + 1;
    //只能选择一张照片
    public static final int ONLY_ONE_PHOTO = EVENT_BASE + 3;
    //显示选中照片
    public static final int SHOW_SELECTOR_PHOTO = EVENT_BASE + 6;
    //照片机返回的Code
    public static final int CAMERA_REQUEST_CODE = EVENT_BASE + 5;

    //是否存在被选中照片
    public static final String HAS_SELECTOR_PHOTO = "has_selector_photo";
    /*调用相机照片存储的路径*/
    public static final String CAMERA_PHOTO_PATH = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "DCIM" + File.separator;


    //-------------------------------------------照片界面标识-------------------------------------------

    //网络相册标记
    public static final int DES_ALBUM = 0x1001;
    //提交巡检标记
    public static final int ROUTING_INSPECTION_SUB = 0x1000;
    //开工准备标记
    public static final int READY_DETAIL_SUB = 0x1002;
    //竣工验收效果图标记
    public static final int COMPLETE_EFFECT_SUB = 0x1003;
    //竣工网络相册标记
    public static final int DES_COMPLETE_ALBUM = 0x1004;
    //工艺详情
    public static final int PM_CRAFT_DETAIL = 0x1005;
    //工序详情
    public static final int PM_PROCESS_DETAIL = 0x1006;
    //环境巡检详情
    public static final int PM_SURROUNDINGS_DETAIL = 0x1007;
//----------------------------------照片返回唯一标识--------------------------------------------

    //标记把照片回传到网络相册界面
    public static final String BACK_TO_DES_ALBUM = "back_to_des_album";
    //标记把照片回传到巡检提交界面
    public static final String BACK_TO_ROUTING_SUB = "back_to_routing_sub";
    //标记把照片回传到开工准备提交界面
    public static final String BACK_TO_READY_DETAIL = "back_to_ready_detail";
    //标记把照片回传到竣工验收(效果图)提交界面
    public static final String BACK_TO_COMPLETE_EFFECT = "back_to_complete_effect";
    //标记把照片回传到竣工网络相册界面
    public static final String BACK_TO_DES_COMPLETE_ALBUM = "back_to_des_complete_album";
    //标记把照片回传到工艺详情界面
    public static final String BACK_TO_PM_CRAFT_DETAIL = "back_to_pm_craft_detail";
    //标记把照片回传到工序详情界面
    public static final String BACK_TO_PM_PROCESS_DETAIL = "back_to_pm_process_detail";
    //标记把照片回传到环境巡检详情界面
    public static final String BACK_TO_PM_SURROUNDINGS_DETAIL = "back_to_pm_surroundings_detail";


    //查看大图标识
    public static final String IMAGE_URL = "image_url";


//----------------------------------监理App--------------------------------------------

    public static final int BASE_CODE = 1000;
    //向项目详情界面传递proInfo
    public static final String ACTION_TO_PRO_DETAIL_PRO_INFO = "action_to_pro_detail_pro_info";
    //向巡检界面传递proInfo
    public static final String ACTION_TO_ROUTING_PRO_INFO = "action_to_routing_pro_info";
    //向回访界面传递proInfo
    public static final String ACTION_TO_VISIT_PRO_INFO = "action_to_visit_pro_info";
    //向开工准备界面传递proInfo
    public static final String ACTION_TO_PREPARE_PRO_INFO = "action_to_prepare_pro_info";
    //向合同界面传递proInfo
    public static final String ACTION_TO_CONTRACT_PRO_INFO = "action_to_contract_pro_info";
    //向材料清单界面传递proInfo
    public static final String ACTION_TO_MAT_LIST_PRO_INFO = "action_to_mat_list_pro_info";
    //向审计清单界面传递proInfo
    public static final String ACTION_TO_AUDIT_PRO_INFO = "action_to_audit_pro_info";
    //向资料界面传递proInfo
    public static final String ACTION_TO_DATUM_PRO_INFO = "action_to_datum_pro_info";
    //向工序详情传递processID
    public static final String ACTION_TO_PREPARE_DETAIL_PROCESS_ID = "action_to_prepare_detail_process_id";
    //向巡检提交界面传递proInfo
    public static final String ACTION_TO_ROUTING_SUB_PRO_INFO = "action_to_routing_sub_pro_info";
    //向巡检详情传递xjID
    public static final String ACTION_TO_ROUTING_SUB_XJ_ID = "action_to_routing_sub_xj_id";
    //向巡检详情传递routingInfo
    public static final String ACTION_TO_ROUTING_DETAIL_ROUTING_INFO = "action_to_routing_detail_routing_info";
    //向巡检详情传递proInfo
    public static final String ACTION_TO_ROUTING_DETAIL_PRO_INFO = "action_to_routing_detail_pro_info";
    //回传备注信息
    public static final int REQUEST_CODE_REMARK = BASE_CODE + 2;
    //向巡检界面回传remark
    public static final String BACK_TO_ROUTING_SUB_REMARK = "back_to_routing_sub_remark";
    //向附件上传界面传递proInfo
    public static final String ACTION_TO_ATTACHMENT_PRO_INFO = "action_to_attachment_pro_info";
    //向纸质资料界面传递proInfo
    public static final String ACTION_TO_PAPER_PRO_INFO = "action_to_paper_pro_info";
    //向资料推送界面传递datumInfo
    public static final String ACTION_TO_ELECTRONIC_DATUM_INFO = "action_to_electronic_datum_info";
    //向电子资料界面传递proInfo
    public static final String ACTION_TO_ELECTRONIC_PRO_INFO = "action_to_electronic_pro_info";
    //向项目清单界面传递proInfo
    public static final String ACTION_TO_PRO_LIST_PRO_INFO = "action_to_pro_list_pro_info";


    //量房中数据的个数
    public static final int LF_NUM=100;

}
