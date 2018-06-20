package com.rxjy.rxcompound.api;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 接口数据请求
 * Created by hjh on 2017/11/3.
 */

public interface ApiService {

    /**
     * 判断是否已经验证过
     */
//    @GET("actionapi/AppCurrencyHome/GetCheckUserInfo")
    ///actionapi/AppCurrencyHome/GetAppCheckToken
    @GET("actionapi/AppCurrencyHome/GetCheckUserInfo_RXPT")
    Observable<String> getCheckIsVerity(
            @Query("Phone") String cardNo
    );
    /**
     * 获取验证码
     */
//    @GET("actionapi/AppCurrencyHome/GetInsideVcodeLanding")
    @GET("actionapi/AppCurrencyHome/GetInsideVcodeLanding")
    Observable<String> getVerityCode(
            @Query("phone") String cardNo
    );

    /**
     * 登录
     */
//    @GET("actionapi/AppCurrencyHome/GetAppLogin")
    //POST /actionapi/AppCurrencyHome/AppLogin
    //POST
    @FormUrlEncoded
    @POST("actionapi/AppCurrencyHome/AppLogin")
    Observable<String> getLogin(
            @Field("cardNo") String cardNo,
            @Field("vCode") String verityCode,
            @Field("password") String pwd
    );
   //
    /**
     * 是否同意协议
     */
    @GET("actionapi/AppCurrencyHome/GetaIsAgreeElectronicProtocol")
    Observable<String> getIsConsent(
            @Query("CardNo") String cardNo,
            @Query("Type") String Type
    );

    /**
     * 同意协议
     */
    @GET("actionapi/AppCurrencyHome/GetaAgreeElectronicProtocol")
    Observable<String> getConsent(
            @Query("CardNo") String cardNo,
            @Query("Type") String Type
    );


    /**
     * 投资获取处罚人员列表
     */
    @GET("actionApi/TZManage/GetUserListToTZ")
    Observable<String> getPersonlist(
            @Query("CardNo") String CardNo,
            @Query("DepartId") String DepartId
    );


    /**
     * 投资上传图片
     */
    @Multipart
    @POST("ActionApi/TZManage/UploadImagesToTZ")
    Observable<String> subTzImg(
            @Part List<MultipartBody.Part> files
    );

    /**
     * 获取形象/环境主页
     */
    @GET("actionApi/TZManage/GetAreasListToTZ")
    Observable<String> getFigureList(
            @Query("CardNo") String CardNo,
            @Query("RegionId") String RegionId,
            @Query("Type") String Type
    );


    /**
     * 形象提交
     */
    @GET("ActionApi/TZManage/AddXXToTZ")
    Observable<String> getFigureUpLode(
            @Query("CardNo") String CardNo,
            @Query("Name") String Name,
            @Query("EvaluateTxt") String EvaluateTxt,
            @Query("Urls") String Urls,
            @Query("Id") String Id,
            @Query("OperatorCardNo") String OperatorCardNo,
            @Query("OperatorName") String OperatorName,
            @Query("RegionId") String RegionId,
            @Query("EduDepartId") String EduDepartId
    );

    /**
     * 环境提交
     */
    @GET("ActionApi/TZManage/AddHJToTZ")
    Observable<String> getEnvirUpLode(
            @Query("EvaluateTxt") String EvaluateTxt,
            @Query("Urls") String Urls,
            @Query("Id") String Id,
            @Query("ContentId") String ContentId,
            @Query("OperatorCardNo") String OperatorCardNo,
            @Query("OperatorName") String OperatorName,
            @Query("Type") String Type,
            @Query("RegionId") String RegionId,
            @Query("AreaName") String AreaName
    );

    /**
     * 获取环境标准图片
     */
    @GET("/actionApi/TZManage/GetAreasStandardToTZ")
    Observable<String> getEnvirImg(
            @Query("ID") String ID
    );


    /**
     * 获取个人资料
     */
    @GET("actionapi/AppCurrencyHome/GetUserData")
//    @GET("actionapi/AppPort/GetUserData")
    Observable<String> getMessage(
            @Query("Phone") String Phone,
            @Query("Type") String Type
    );

    /**
     * 获取个人资料(温特斯会员)
     */
    @GET("actionapi/MemberApp/GetMemberInfo")
    Observable<String> getMessageDes(
            @Query("cardNo") String cardNo
    );

    /**
     * 同意协议（温特斯会员）
     */
    @GET("actionapi/AppCurrencyHome/GetaAgreeElectronicProtocol")
    Observable<String> getAgreeYes(
            @Query("cardno") String cardno,
            @Query("type") String type
    );

    /**
     * 修改个人资料
     */
//    @GET("actionapi/AppCurrencyHome/GetUpdateUserData")
    @GET("actionapi/AppPort/GetUpdateUserData")
    Observable<String> getUpdateMessages(
            @Query("CardNo") String CardNo,
            @Query("Type") String Type,
            @Query("IdCardName") String IdCardName,
            @Query("IdCard") String IdCard,
            @Query("IdCardAddress") String IdCardAddress,
            @Query("NowAddress") String NowAddress,
            @Query("Birthday") String Birthday,
            @Query("Marriage") String Marriage
    );


    /**
     * 修改个人资料
     */
    @GET("actionapi/AppCurrencyHome/GetUpdateUserData")
    Observable<String> getUpdateMessagesnew(
            @Query("CardNo") String Phone,
            @Query("Type") String Type,
            @Query("IdCard") String IdCard,
            @Query("IdCardName") String IdCardName,
            @Query("Birthday") String Birthday,
            @Query("IdCardAddress") String IdCardAddress,
            @Query("NowAddress") String NowAddress,
            @Query("Marriage") String Marriage,
            @Query("Xueli") String Xueli
    );

    /**
     * 修改入职资料
     */
    @GET("actionapi/AppCurrencyHome/GetUpdateUserData")
    Observable<String> getUpdateMessageZ3new(
            @Query("CardNo") String Phone,
            @Query("Type") String Type,
            @Query("BankCard") String BankCard,
            @Query("BankName") String BankName,
            @Query("BankUserName") String BankUserName,
            @Query("UrgentPerson") String UrgentPerson,
            @Query("UrgentPhone") String UrgentPhone,
            @Query("UrgentContact") String UrgentContact,
            @Query("u_bank_branch") int bankbranch
    );


    /**
     * 修改个人资料
     */
//    @GET("actionapi/AppCurrencyHome/GetUpdateUserData")
    @GET("actionapi/AppPort/GetUpdateUserData")
    Observable<String> getUpdateMessage(
            @Query("CardNo") String Phone,
            @Query("Type") String Type,
            @Query("BankName") String BankName,
            @Query("BankCard") String BankCard,
            @Query("BankUserName") String BankUserName,
            @Query("UrgentPerson") String UrgentPerson,
            @Query("UrgentContact") String UrgentContact,
            @Query("UrgentPhone") String UrgentPhone
    );

    /**
     * 修改个人资料
     */
//    @GET("actionapi/AppCurrencyHome/GetUpdateUserData")
    @GET("actionapi/AppPort/GetUpdateUserData")
    Observable<String> getUpdateMessage(
            @Query("CardNo") String CardNo,
            @Query("Type") String Type,
            @Query("Name") String Name,
            @Query("Sex") String Sex,
            @Query("Phone") String Phone
//            @Query("Marriage") String Marriage
    );


    /**
     * 修改温特斯会员身份信息
     */
    @GET("actionapi/MemberApp/GetUpdateMemberBasic")
    Observable<String> getUpdateDesMessage(
            @Query("cardNo") String card_no,
            @Query("Type") String Type,
            @Query("phone") String phone,
            @Query("nick_name") String nick_name,
            @Query("sex") String sex,
            @Query("id_card") String id_card,
            @Query("birthday") String birthday,
            @Query("living_place") String living_place,
            @Query("education") String education,
            @Query("email") String email
    );

    /**
     * 修改温特斯会员申请资料
     */
    @GET("actionapi/MemberApp/GetUpdateMemberBasic")
    Observable<String> getUpdateDesJobMessage(
            @Query("cardNo") String card_no,
            @Query("Type") String Type,
            @Query("bank_name") String bank_name,
            @Query("bank_card") String bank_card,
            @Query("bank_user_name") String bank_user_name,
            @Query("u_bank_branch") int bankbranch
    );


    /**
     * 忘记密码获取验证码
     */
    @Multipart
    @POST("actionapi/AppCurrencyHome/GetVcodeUpdatePwd")
    Observable<String> getVCodes(
            @Part("phone") String phone
    );

    /**
     * 忘记密码修改密码
     */
    @Multipart
    @POST("actionapi/AppCurrencyHome/UpdatePassword_Vcode")
    Observable<String> postFixPwd(
            @Part("phone") String cardNo,
            @Part("newPassword") String newPassword,
            @Part("vCode") String vCode
    );


    /**
     * 首页banner数据
     */
//    @GET("actionapi/AppCurrencyHome/GetAppHomeBanner")
    @GET("actionapi/AppPort/GetAppHomeBanner")
    Observable<String> getHomeBanner(
            @Query("a_ccount") String a_ccount
    );

    /**
     * 发现的数据（banner+列表）
     */
//    @Multipart
//    @POST("a/sap/sapArticle/getAppArticleList")
//    Observable<String> postFindData(
//            @Part("cardNo") String cardNo,
//            @Part("page") int pageIndex,
//            @Part("rows") int pageSize
//    );//a/sap/sapArticle/getAppArticleList
    //http://wpsnew.rxjy.com:9090/a/sap/sapArticle/getAppArticleList?cardNo=02900672&page=1&rows=10
    @GET("a/sap/sapArticle/getAppArticleList")
    Observable<String> postFindData(
            @Query("cardNo") String cardNo,
            @Query("page") int page,
            @Query("rows") int rows
    );


    /**
     * 获取答题状态
     */
    @GET("getEduTrypostPressess")
    Observable<String> getEduProgress(
            @Query("cardno") String cardno
    );

    /**
     * 获取答题详情
     */
    @GET("getEduTrypostCurrInfo")
    Observable<String> getJobTryData(
            @Query("cardno") String cardno,
            @Query("dept") String dept,
            @Query("dayIndex") String dayIndex
    );


    /**
     * 获取银行卡列表
     */
    @GET("/actionapi/AppCurrencyHome/Getbanklist")
    Observable<String> getBankList(

    );

    /**
     * 获取用户状态
     */
//    @GET("actionapi/AppCurrencyHome/GetUserStage")
    @GET("actionapi/AppPort/GetUserStage")
    Observable<String> getUserStatus(
            @Query("CardNo") String cardno
    );


    /**
     * 获取通知列表详情
     */
    @GET("actionapi/AppCurrencyHome/GetAppNoticeList")
//    @GET("actionapi/AppPort/GetAppNoticeList")
    Observable<String> getInformListMessage(
            @Query("cardNo") String cardno,
            @Query("Group") String Group
    );

    /**
     * 获取通知列表
     */
    @GET("actionapi/AppCurrencyHome/GetAppNoticeGroup")
    Observable<String> getInformMessage(
            @Query("CardNo") String cardno
    );
//    /**
//     * 获取通知二级列表
//     */
//    @GET("actionapi/AppCurrencyHome/GetAppNoticeGroup")
//    Observable<String> getInformListMessage(
//            @Query("CardNo") String cardno,
//            @Query("Group") String Group
//    );

    /**
     * 获取通知详情
     */
    @GET("actionapi/AppCurrencyHome/GetAppNoticeDetail")
    Observable<String> getInformDetailsMessage(
            @Query("Id") String Id
    );

    /**
     * 查看通知列表
     */
//    @GET("actionapi/AppCurrencyHome/GetSeeAppNotice")
    @GET("actionapi/AppPort/GetSeeAppNotice")
    Observable<String> getToSeeDetails(
            @Query("Id") String Id
    );


    /**
     * 上传图片接口
     */
    @Multipart
    @POST("actionapi/AppCurrencyHome/entryUpdateImages")
//    @POST("actionapi/AppPort/entryUpdateImages")
    Observable<String> subImage(
            @Part("cardNo") String cardNo,
            @Part("type") String type,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 上传头像
     */
    @Multipart
    @POST("actionapi/AppCurrencyHome/UploadAvatar")
    Observable<String> upIcon(
            @Part("cardNo") String cardNo,
            @Part MultipartBody.Part file
    );


    /**
     * 上传图片接口(温特斯会员)
     */
    @Multipart
    @POST("actionapi/MemberApp/UpdateMemberImages")
    Observable<String> subDesImage(
            @Part("cardNo") String cardNo,
            @Part("type") String type,
            @Part List<MultipartBody.Part> files
    );


    /**
     * 下线
     */
    @Multipart
    @POST("actionapi/AppHome/OfflineApp")
    Observable<String> xiaxian(
            @Part("cardNo") String cardNo
    );


    /**
     * 入职申请
     */
//    @GET("actionapi/AppCurrencyHome/GetEntryExamineNew")
    @GET("actionapi/AppPort/GetEntryExamineNew")
    Observable<String> getEntryJob(
            @Query("cardNo") String cardNo
    );

    /**
     * 获取图片详情
     */
//    @GET("actionapi/AppCurrencyHome/GetImgList")
    @GET("actionapi/AppPort/GetImgList")
    Observable<String> getImagesDetails(
            @Query("card_no") String cardNo,
            @Query("img_type") String img_type
    );


    /*------------------------------------商务在职App模块-----------------------------------*/


    /**
     * 获取版本信息
     */
    @GET("actionapi/AppCurrencyHome/IsAndroidUpdated")
    Observable<String> getVCode(
            @Query("Version") int version
    );

    /**
     * 扫描二维码登录
     */
    @GET("api/values/UPWPS")
    Observable<String> getQRLoginSure(
            @Query("kahao") String kahao,
            @Query("biaoshi") String biaoshi
    );


    /**
     * 我的个人成就信息
     */
    @GET("AppMember/GetSwZaiZhiUserInfo")
    Observable<String> getMyGrade(
            @Query("kahao") String kahao
    );

    /**
     * 我的个人成就信息金额
     */
    @GET("AppMember/BenYueDianZanDetail")
    Observable<String> getMyGradeMoney(
            @Query("kahao") String kahao
    );

    /**
     * 客户信息
     */
    @GET("AppEmployee/GetCustomerList")
    Observable<String> getCustomer(
            @Query("card") String card,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize,
            @Query("key") String key
    );


    /**
     * 添加客户回访
     */
    @Multipart
    @POST("AppEmployee/AddCustomerVisit")
    Observable<String> postAddCustomerVisit(
            @Part("KeHuBaseID") int KeHuBaseID,
            @Part("salesmanid") int salesmanid,
            @Part("content") String content,
            @Part("areaid") int areaid,
            @Part("nexttime") String nexttime,
            @Part("status") int status
    );

    /**
     * 获取瑞祥币（月：1  日：0）
     */
    @Multipart
    @POST("AppMember/GetRuiXiangBiMingXi")
    Observable<String> postRXBi(
            @Part("kahao") String kahao,
            @Part("zhiwu") String zhiwu,
            @Part("type") String type
    );


    /**
     * 获取地区列表
     */
    @GET("AppEmployee/GetAreaList")
    Observable<String> getAddressList(
            @Query("name") String name
    );

    /**
     * 获取行业类型
     */
    @Multipart
    @POST("AppAgent/CustomerProperty")
    Observable<String> postIndustryType(
            @Part("type") String type
    );

    /**
     * 获取年龄
     */
    @GET("HuiYuan/XunJiaNianLingSelect")
    Observable<String> getAge(
    );

    /**
     * 获取身份
     */
    @GET("HuiYuan/XunJiaShenFenSelect")
    Observable<String> getIdentity(
    );

    /**
     * 获取注重
     */
    @GET("HuiYuan/XunJiaZhuZhongSelect")
    Observable<String> getAttention(
    );


    /**
     * 保存客户信息
     */
    @Multipart
    @POST("AppEmployee/SaveCustomer")
    Observable<String> postsavecustomer(
            @Part("FenGongSiID") int FenGongSiID,
            @Part("XingMing") String XingMing,
            @Part("ShouJiHaoYi") String ShouJiHaoYi,
            @Part("MianJi") String MianJi,
            @Part("LeiXingYi") int LeiXingYi,
            @Part("LeiXingEr") int LeiXingEr,
            @Part("Phone") String Phone,
            @Part("FangYuan") int FangYuan,
            @Part("GongSiMingCheng") String GongSiMingCheng,
            @Part("ZhuangTai") int ZhuangTai,
            @Part("KeHuBaseID") String KeHuBaseID
    );

    /**
     * 添加客户信息
     */
    @Multipart
    @POST("AppEmployee/AddCustomer")
    Observable<String> postaddcustomer(
            @Part("XingMing") String XingMing,
            @Part("ShouJiHaoYi") String ShouJiHaoYi,
            @Part("MianJi") String MianJi,
            @Part("LeiXingYi") int LeiXingYi,
            @Part("LeiXingEr") int LeiXingEr,
            @Part("FangYuan") int FangYuan,
            @Part("tb_diqu") int tb_diqu,
            @Part("card") String card,
            @Part("XinXiYuanBianHao") String XinXiYuanBianHao,
            @Part("GongSiMingCheng") String GongSiMingCheng,
            @Part("LouPanKeHu") int LouPanKeHu
    );

    /**
     * 量房信息
     */
    @Multipart
    @POST("AppEmployee/UpdateCustomer")
    Observable<String> postsavecustomer(
            @Part("ShenFenID") int ShenFenID,
            @Part("ZhuZhongDianID") int ZhuZhongDianID,
            @Part("NianLingID") int NianLingID,
            @Part("XingBie") int XingBie,
            @Part("YuJiZhuangXiu") int YuJiZhuangXiu,
            @Part("ChengJiaoLeiXing") int ChengJiaoLeiXing,
            @Part("MianZuQi") int MianZuQi,
            @Part("JiaoFangShiJian") String JiaoFangShiJian,
            @Part("LiangFangDiZhi") String LiangFangDiZhi,
            @Part("ZhuangXiuXuQiu") int ZhuangXiuXuQiu,
            @Part("XiangMuShuXing") int XiangMuShuXing,
            @Part("ZhuangXiuYuSuan") String ZhuangXiuYuSuan,
            @Part("YuJiZhuangXiuShiJian") String YuJiZhuangXiuShiJian,
            @Part("YuJiLiangFang") String YuJiLiangFang,
            @Part("QiYeGuiMoID") int QiYeGuiMoID,
            @Part("ZhuangTai") int ZhuangTai,
            @Part("KeHuBaseID") String KeHuBaseID
    );

    /**
     * 获取客户、量房信息
     */
    @GET("AppEmployee/GetCustomerDetail")
    Observable<String> getCustomerMessage(
            @Query("id") int id,
            @Query("type") int type
    );

    /**
     * 验证客户手机号
     */
    @Multipart
    @POST("AppEmployee/VerificationPhone")
    Observable<String> postCustomerPhone(
            @Part("phone") String phone
    );

    /**
     * 验证信息员手机号
     */
    @Multipart
    @POST("AppEmployee/VerificationMessengerPhone")
    Observable<String> postPersonPhone(
            @Part("phone") String phone,
            @Part("card") String card
    );


    /*------------------------------------温特斯App模块-----------------------------------*/
    @GET("actionapi/AppHome/OfflineApp")
    Observable<String> destorylistener(
    );

    /**
     * 获取钱包信息
     */
    @GET("AppAgent/GetMemBerMoney")
    Observable<String> getWalletInfo(
            @Query("MemberCard") String cardNo
    );

    /**
     * 获取收支明细数据接口
     */
    @GET("AppAgent/ShouZhiMingXiList")
    Observable<String> getWalletRecord(
            @Query("KaHao") String cardNo,
            @Query("PageIndex") int pageIndex,
            @Query("PageSize") int pageSize
    );

    /**
     * 获取量房以及量房状态列表 home首页列表项
     */

    @GET("jd/GetOrderArray/")
    Observable<String> getALLClientInfo(
            @Query("Phone") String phone
    );


    /**
     * 获取量房在谈列表（新）
     *
     * @param mobile
     * @return
     */
    @GET("order/desingerOrder")
    Observable<String> getALLClientInfoNew(
            @Query("mobile") String mobile
    );

    //************在施new
    @GET("UC/GetUCList")
    Observable<String> GetUCList(
            @Query("cardNo") String cardNo
    );

    @GET("jd/TalkingVisitingArray/")
    Observable<String> getHuiFangData(
            @Query("rwdid") String rwdId,
            @Query("pageIndex") int pageIndex
    );

    //提交回访
    @Multipart
    @POST("jd/TalkingVisitingInsert/")
    Observable<String> addHuiFangData(
            @Part("rwdid") String rwdId,
            @Part("content") String content,
            @Part("methods") int methods
    );

    //获取量房的信息
    @GET("jd/APPClientInfo")
    Observable<String> GetLHouseData(
            @Query("rwdid") String rwdid
    );

    //保存量房的信息
    @Multipart
    @POST("jd/APPClientInfoUpdate")
    Observable<String> SaveLHouseData(
            @Query("rwdid") String rwdid,
            @Part("formpars") String formpars,//jaon串
//            @Body RequestBody formpars,
            @Query("money") String money,
            @Query("valCount") String valCount//个数
    );

    //获取量房信息
    @GET("JD/GetAPPMeasureInfo")
    Observable<String> getliangfangxinxi(
            @Query("rwdid") String cardNo
    );

    //提交信息

    @GET("JD/UpdateAPPsjsJD")
    Observable<String> UpXinxi(
            @Query("rwdid") String cardNo,
            @Query("formpars") String formpars,
            @Query("type") String type

    );

    /**
     * 传单号
     */
    @GET("jd/UpdateClientAuxiliaryStatus")
    Observable<String> UpDanHao(
            @Query("rwdid") String rwdid
    );

    /**
     * 上传图片接口
     */
    @Multipart
    @POST("jd/UploadJDimages")
    Observable<String> subImage(
            @Part("WorksID") int worksID,
            @Part("CatalogID") int catalogID,
            @Part("UserId") String userID,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 删除图片接口
     */
    @Multipart
    @POST("jd/DeleteJDimages")
    Observable<String> deleteImage(
            @Part("DetailID") int detailID,
            @Part("filename") String fileName
    );

    //获取拍照类别
    @GET("JD/ProjectImgCatalogs")
    Observable<String> getCameraType(
            @Query("rwdid") String rwdId
    );

    /**
     * 上传图片接口
     */
    @Multipart
    @POST("jd/UploadJDimages")
    Observable<String> subImage2(
            @Part("WorksID") int worksID,
            @Part("CatalogID") String catalogID,
            @Part("UserId") int userID,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 量房信息上传
     */
    @Multipart
    @POST("JD/UpdateClientDetailInfo")
    Observable<String> subMeasureData(
            //单号
            @Part("ci_rwdid") String rwdID,
            //房屋现状
            @Part("ca_ca_HousingSituation") String caCaHousingSituation,//更改int
            //房屋朝向
            @Part("ca_HouseOrientation") String caHouseOrientation,
            //占用公共过道
            @Part("ca_OccupyPublicCorridor") int caOccupyPublicCorridor,
            //地面是否平整
            @Part("ca_isGroundSmooth") String caIsGroundSmooth,
            //货梯们高度
            @Part("ca_CargoDoorHight") double caCargoDoorHight,
            //货梯们宽度
            @Part("ca_CargoDoorWide") double caCargoDoorWide,
            //原地面材质
            @Part("ca_OriginalGroundMaterial") String caOriginalGroundMaterial,
            //地面高差
            @Part("ca_GroundElevation") double caGroundElevation,
            //空间最高点
            @Part("ca_SpaceMaxHeight") double caSpaceMaxHeight,
            //主梁下（主梁下高度）
            @Part("ca_mainBeamHeight") double camainBeamHeight,
            //次梁下（次梁下高度）
            @Part("ca_SecondaryHeight") double caSecondaryHeight,
            //淋喷最低点
            @Part("ca_MinimumSprayHeight") double caMinimumSprayHeight,
            //空调设备个数
            @Part("ca_AirConditionerNum") int caAirConditionerNum,
            //风口最低点
            @Part("ca_TuyereMinimumHeight") double caTuyereMinimumHeight,
            //强电箱个数
            @Part("ca_StrongBoxNum") int caStrongBoxNum,
            //弱电箱个数
            @Part("ca_WeakBoxNum") int caWeakBoxNum,
            //上水电
            @Part("ca_UpWaterSpot") int caUpWaterSpot,
            //下水点
            @Part("ca_DownWaterSpot") int caDownWaterSpot,
            //下水管径
            @Part("ca_DownWaterSpotSize") double caDownWaterSpotSize,
            //幕墙架间距
            @Part("ca_CurtainWallSpacing") double caCurtainWallSpacing,
            //窗户类型
            @Part("ca_WindowType") String caWindowType,
            //窗台高
            @Part("ca_windowsillHight") double caWindowSillHight,
            //窗户高
            @Part("ca_WindowWidth") double caWindowWidth,
            //原顶面材质
            @Part("ca_OriginalTopMaterial") String caOriginalTopMaterial,
            //原墙面材质
            @Part("ca_OriginalWallMaterial") String caOriginalWallMaterial,
            //空间最低点高度
            @Part("ca_SpaceMinHeight") double caSpaceMinHeight,
            //上下水路径
            @Part("ca_WaterPath") String caWaterPath,
            //窗户宽
            @Part("ca_WindowHight") double caWindowHight,
            //原地面保存
            @Part("ca_OriginalGround") int caOriginalGround,    //更改int
            //租金/单价
            @Part("ca_Rental") double caRental,
            //免租期
            @Part("ca_RentFreeDate") int caRentFreeDate,
            //租期开始日期
            @Part("ca_LeaseTermStart") String caLeaseTermStart,
            //租期结束日期
            @Part("ca_LeaseTermEnd") String caLeaseTermEnd,
            //客户姓名
            @Part("ci_proHead") String ciProHead,
            //量房地址
            @Part("ci_DecorationAddress") String ciDecorationAddress,
            //装修预算
            @Part("ca_DecBudgetPrice") double caDecBudgetPrice
    );

    /**
     * 获取量房信息
     */
    @GET("JD/GetClientDetailInfo")
    Observable<String> getMeasureData(
            @Query("ci_rwdid") String rwdId
    );

    /**
     * 获取所有图片信息
     */
    @GET("JD/GetAllImages")
    Observable<String> getAllImages(
            @Query("ci_rwdid") String rwdId,
            @Query("enumType") String enumType
    );

    //获取物业信息
    @GET("JD/GetAPPBasicInfo")
    Observable<String> getjibenxinxi(
            @Query("rwdid") String cardNo
    );

    //获取项目类型（属性）
    @GET("jd/ProjectCatalogArray")
    Observable<String> getProjecttype(
    );

    //获取装修需求
    @GET("JD/GetAPPDecorateInfo")
    Observable<String> getzhuangxiuxuqiu(
            @Query("rwdid") String cardNo
    );

    //获取基本信息
    @GET("JD/GetAPPPropertyInfo")
    Observable<String> getwuyexinxi(
            @Query("rwdid") String cardNo
    );

    //获取所有已量房信息
    @GET("JD/GetClientDetailMoreInfo")
    Observable<String> geYiLiangFangAllInfo(
            @Query("ci_rwdid") String rwdId
    );

    //获取房源信息
    @GET("JD/GetAPPHosingInfo")
    Observable<String> getfangyuanxinxi(
            @Query("rwdid") String cardNo
    );

    //获取楼盘信息
    @GET("JD/GetAPPBuildingInfo")
    Observable<String> getloupanxinxi(
            @Query("rwdid") String cardNo
    );

    //获取客户信息
    @GET("JD/GetAPPCustomerInfo")
    Observable<String> getkehuxinxi(
            @Query("rwdid") String cardNo
    );

    //获取客户信息
    @GET("JD/GetAPPBusinessInfo")
    Observable<String> getqiyexinxi(
            @Query("rwdid") String cardNo
    );

    //获取图片
    @GET("UC/GetAllImages")
    Observable<String> GetUCAllImages(
            @Query("rwdId") String rwdId,
            @Query("enumType") int enumType
    );

    //获取巡检列表
    @GET("UC/GetScheduleCheckList")
    Observable<String> GetScheduleCheckList(
            @Query("rwdId") String rwdId
    );

    //获取已完成巡检详情页数据
    @GET("UC/GetScheduleCheckIno")
    Observable<String> GetScheduleCheckIno(
            @Query("sc_id") String sc_id
    );

    //提交巡检
    @Multipart
    @POST("UC/SubmitCheckDes")
    Observable<String> SubmitCheckDes(
            @Part("sc_id") String sc_id,
            @Part("description") String description,
            @Part("address") String address
    );

    //巡检添加图片
    @Multipart
    @POST("UC/UploadCheckImages")
    Observable<String> UploadCheckImages(
            @Part("sc_Id") String sc_Id,
            @Part List<MultipartBody.Part> files

    );

    //删除巡检图片
    @Multipart
    @POST("UC/DeleteCheckImages")
    Observable<String> DeleteloadCheckImages(
            @Part("si_Id") String sc_Id,
            @Part("fileName") String fileName
    );

    @GET("CC/ProjectImgCatalogs")
    Observable<String> ProImgCatalogs(
            @Query("rwdId") String rwdId
    );

    @GET("CC/GetAllImages")
    Observable<String> GetAllImages(
            @Query("rwdId") String rwdId,
            @Query("enumType") int enumType
    );

    /**
     * 获取钱包总信息
     */
    @GET("RS/DesignSalary")
    Observable<String> getQianBaoInfo(
            @Query("cardNo") String cardNo,
            @Query("pageIndex") int pageIndex
    );

    /**
     * 获取钱包分信息
     */
    @GET("RS/DesignSalaryByType")
    Observable<String> getQianBaoFenInfo(
            @Query("cardNo") String cardNo,
            @Query("pageIndex") int pageIndex,
            @Query("type") int type
    );



    /*------------------------------------项目监理App模块-----------------------------------*/

    /**
     * 获取版本信息
     */
    @GET("app/version_com.rxjy.jl.json")
    Observable<String> getVersionInfo(

    );

    /**
     * 获取项目列表
     */
    @GET("api/APPProjectManger/GetWorkorderBySupervisor")
    Observable<String> getProjectList(
            @Query("supervisor_userno") String userNo
    );

    /**
     * 开工工前准备
     */
    @GET("api/APPProjectManger/GetProjectProcess")
    Observable<String> getProjectProcess(
            @Query("orderno") String orderNo,
            @Query("ptype") int pType,
            @Query("flag") int flag
    );

    /**
     * 获取工序详情接口
     */
    @GET("api/APPProjectManger/GetProcessStepDetail")
    Observable<String> getProcessDetail(
            @Query("process_id") int processID,
            @Query("ptype") int type
    );

    /**
     * 上传工序详情图片接口
     */
    @Multipart
    @POST("api/APPProjectManger/SubProcessStep")
    Observable<String> subProcessPhoto(
            @Part("step_id") int stepID,
            @Part("process_id") int processID,
            @Part("StepPhotoID") int stepPhotoID,
            @Part("ptype") int type,
            @Part MultipartBody.Part file
    );

    /**
     * 巡检信息接口
     */
    @GET("api/APPProjectManger/GetXunJianList")
    Observable<String> getRoutingList(
            @Query("orderno") String orderNo,
            @Query("ptype") int pType
    );

    /**
     * 获取巡检状态接口
     */
    @GET("api/APPProjectManger/Getxunjian")
    Observable<String> getRoutingState(
            @Query("orderno") String orderNo,
            @Query("ptype") int pType
    );

    /**
     * 提交巡检内容
     */
    @Multipart
    @POST("api/APPProjectManger/SubXunJianJLNew")
    Observable<String> subNewXJProblem(
            @Part("xj_id") int xjID,
            @Part("xj_orderno") String orderNo,
            @Part("xj_content") String xjContent,
            @Part("app_count") String count,
            @Part("xj_tag") String xjTag,
            @Part("xj_address") String xjAddress,
            @Part("xj_x") double xjX,
            @Part("xj_y") double xjY,
            @Part("Closetype") double closeType,
            @Part("xj_remark") String remarkJson,
            @Part List<MultipartBody.Part> files
    );

    /*
     * 获取问题列表
     */
    @GET("api/APPProjectManger/GetXunJianProblemTypeListNew")
    Observable<String> getNewProblemList(

    );

    /**
     * 获取巡检详情接口
     */
    @GET("api/APPProjectManger/GetXunJianTypeList")
    Observable<String> getRoutingDetail(
            @Query("orderno") String orderNo,
            @Query("xj_id") int xjID
    );

    /**
     * 获取回访记录接口
     *
     * @param orderNo
     * @return
     */
    @GET("api/PhoneSupervisor/GetSurprvisorWorkLogEntity")
    Observable<String> getWorkLog(
            @Query("orderno") String orderNo
    );

    /**
     * 新增回访接口
     */
    @Multipart
    @POST("api/PhoneSupervisor/SaveWorklog")
    Observable<String> subWorkLog(
            @Part("orderno") String orderNo,
            @Part("logcontent") String content,
            @Part("logtype") String logType,
            @Part("problemId") String problemID,
            @Part("importance") String importance
    );

    /**
     * 获取甲方合同
     */
    @GET("api/PhoneSupervisor/GetWorkOrderByOrderNo")
    Observable<String> getFirstPartyContract(
            @Query("orderNo") String orderNo
    );

    /**
     * 资料接口
     */
    @GET("api/PhoneSupervisor/GetPartInfoDistributionList")
    Observable<String> getDatumInfo(
            @Query("attr_type") int type,
            @Query("orderNo") String orderNo
    );

    /**
     * 上传纸质资料信息
     */
    @Multipart
    @POST("api/PhoneSupervisor/UploadPaperInfoImg")
    Observable<String> uploadPaperInfo(
            @Part("orderNo") String orderNo,
            @Part("attr_category") int category,
            @Part("attr_model_id") int attrId,
            @Part("orderID") int orderID,
            @Part MultipartBody.Part file
    );

    /**
     * 获取资料推送内容
     */
    @GET("api/PhoneSupervisor/GetElectroInfoDetail")
    Observable<String> getPushElectronicInfo(
            @Query("orderNo") String orderNo,
            @Query("attr_model_id") int attrId
    );

    /**
     * 保存电子资料接口
     */
    @Multipart
    @POST("api/PhoneSupervisor/SaveElectroInfo")
    Observable<String> saveElectronicInfo(
            @Part("orderNo") String orderNo,
            @Part("attr_model_id") int attrId,
            @Part("eleid") int eleId,
            @Part("content") String content
    );

    /**
     * 保存并推送电子资料接口
     */
    @Multipart
    @POST("api/PhoneSupervisor/PushElectroInfo")
    Observable<String> savePushElectronicInfo(
            @Part("orderNo") String orderNo,
            @Part("attr_model_id") int attrId
    );

    /**
     * 获取资料类型接口
     */
    @GET("api/PhoneSupervisor/GetPartInfoNameList")
    Observable<String> getAttachmentTypeInfo(

    );

    /**
     * 提交附件资料
     */
    @Multipart
    @POST("api/PhoneSupervisor/UploadPaperFileInfoImg")
    Observable<String> subAttachmentInfo(
            @Part("orderNo") String orderNo,
            @Part("yanQiDayCount") String dayCount,
            @Part("attr_model_id") int modelId,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 获取材料清单
     */
    @GET("api/APPPM/GetMaterialItemsByPMAPP")
    Observable<String> getMatList(
            @Query("orderno") String orderNo
    );

    /**
     * 获取审计列表
     */
    @GET("api/PhoneSupervisor/GetAuditResultByOrderNo")
    Observable<String> getAudit(
            @Query("orderNo") String orderNo,
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize
    );

    /**
     * 获取项目清单列表
     */
    @GET("api/PhoneSupervisor/GetArea_itemListByOrderNo")
    Observable<String> getProList(
            @Query("orderNo") String orderNo
    );


//    /**
//     * 获取钱包(瑞祥平台)
//     */
//    @GET("api/HR/GetMonthSalary")
//    Observable<String> getMoney(
//            @Query("card") String cardNo
//    );

//    https://api.dcwzg.com:9191/actionapi/AppPort/GetMonthSalary?card=00001104

    /**
     * 获取钱包(瑞祥平台)
     */
    @GET("actionapi/AppPort/GetMonthSalary")
    Observable<String> getMoney(
            @Query("card") String cardNo
    );

    /**
     * 获取钱包(商务)
     */
    @GET("bussiness/payment")
    Observable<String> getBusMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(商务新)
     */
    @GET("bussiness/personnel/payment")
    Observable<String> getBusMoneyNew(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(主案)
     */
    @GET("mainCase/payment")
    Observable<String> getDesMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(工程)
     */
    @GET("project/payment")
    Observable<String> getGcMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(投资人事)
     */
    @GET("investment/personnelSupervisor")
    Observable<String> getTzMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(投资行政经理)
     */
    @GET("investment/adminManager")
    Observable<String> getXzMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(会计)
     */
    @GET("investment/adminManager/accountantpayment")
    Observable<String> getKjMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(出纳)
     */
    @GET("investment/adminManager/tellerpayment")
    Observable<String> getCnMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(商务奖罚考勤)
     */
    @GET("bussiness/personnel/rewardPunishment")
    Observable<String> getBusJFKQMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(商务奖罚考勤以下)
     */
    @GET("bussiness/personnel/rewardPunishmentunder")
    Observable<String> getBusJFKQMoreMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取钱包(商务历史未发)
     */
    @GET("bussiness/personnel/nosentdetail")
    Observable<String> getMoneyBusHis(
            @Query("diqu") String diqu,
            @Query("KaHao") String KaHao
    );


    /**
     * 获取材料清单
     */
    @GET("actionapi/AppCurrencyHome/GetAppNoticeNoReadCount")
    Observable<String> getMsgnum(
            @Query("CardNo") String CardNo
    );

    /**
     * 获取商务工资
     */
    @GET("bussiness/payment/salary")
    Observable<String> getBussMoney(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取商务过程
     */
    @GET("bussiness/payment/process")
    Observable<String> getBusProcess(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取商务结果
     */
    @GET("bussiness/payment/result")
    Observable<String> getBusResult(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取商务奖罚
     */
    @GET("bussiness/payment/rewardPunishment")
    Observable<String> getBusReward(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );


    /**
     * 获取投资行政经理结果
     */
    @GET("investment/adminManager/result")
    Observable<String> getTzResult(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取投资行政经理过程
     */
    @GET("investment/adminManager/process")
    Observable<String> getTzProcess(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取投资行政经理分红
     */
    @GET("investment/adminManager/dividend")
    Observable<String> getTzFenhong(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取投资行政经理奖罚
     */
    @GET("investment/adminManager/rewardAndPunishment")
    Observable<String> getTzReward(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取投资人事结果
     */
    @GET("investment/supervisor/result")
    Observable<String> getTzRSResult(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 获取投资人事过程
     */
    @GET("investment/supervisor/course")
    Observable<String> getTzRSProcess(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

//    /**
//     * 主案过程
//     */
//    @GET("mainCase/payment/process")
//    Observable<String> getZaProcess(
//            @Query("year") String year,
//            @Query("month") String month,
//            @Query("cardNo") String cardNo
//    );

    /**
     * 主案过程/结果（新）
     */
    @GET("mainCase/payment/resultAndProcess")
    Observable<String> getZaProcess(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 主案结果
     */
    @GET("mainCase/payment/result")
    Observable<String> getZaResult(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 主案奖罚
     */
    @GET("mainCase/payment/event")
    Observable<String> getZaReward(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 工程绩效
     */
    @GET("project/payment/performance")
    Observable<String> getGcJixiao(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );

    /**
     * 工程创收
     */
    @GET("project/payment/income")
    Observable<String> getGcChuangshou(
            @Query("year") String year,
            @Query("month") String month,
            @Query("cardNo") String cardNo
    );


    /**
     * 登录成功后发起通知
     */
    @GET("PersonnelManagement/Opereat/UpdateDataByIds")
    Observable<String> getLoginTz(
            @Query("cardno") String cardno,
            @Query("data") String data
    );

    /**
     * 获取积分
     */
    @GET("/mainCase/payment/integral")
    Observable<String> getJiFen(
            @Query("cardNo") String cardNo
    );


    /**
     * 获取温特斯单号
     */
    @GET("IDC/GetOrderNumber")
    Observable<String> getLHouseNum(
            @Query("areaid") String areaid,
            @Query("phone") String phone
    );

    /**
     * 获取温特斯单号提交
     */
    @Multipart
    @POST("order/saveClientInfoAndAuxiliary")
    Observable<String> submitLHouseNum(
            @Part("rwdid") String rwdid,
            @Part("clientInfo") String clientInfo,
            @Part("clientAuxiliary") String clientAuxiliary
    );

    /**
     * 获取任务列表
     *///
    @GET("actionapi/AppPort/TaskList")
    Observable<String> getTaskList(
            @Query("Card") String Card
    );

    /**
     * 获取任务详情
     */
    @GET("actionapi/AppPort/GetTask")
    Observable<String> getTaskDetails(
            @Query("taskId") String taskId
    );

//    /**
//     * 提交任务
//     */
//    @Multipart
//    @POST("actionapi/AppPort/AddTask")
//    Observable<String> submitTask(
//            @Part("id") String id,
//            @Part("t_link") String t_link,
//            @Part("t_commitDescription") String t_commitDescription,
//            @Part("imgId") String imgId,
//            @Part("card") String card
//    );

    /**
     * 获取任务详情
     */
    @GET("actionapi/AppPort/AddTask")
    Observable<String> submitTask(
            @Query("id") String id,
            @Query("t_link") String t_link,
            @Query("t_commitDescription") String t_commitDescription,
            @Query("imgId") String imgId,
            @Query("card") String card
    );

    /**
     * 温特斯获取接单详情
     */
    @GET("order/orderInfo")
    Observable<String> getOrderget(
            @Query("rwdId") String rwdid
    );

    /**
     * 温特斯获取接单  ci_ReciveStatus 1:接单  2：拒单
     * http://10.10.3.167:10030/JD/UpdateAPPsjsJD?rwdid=88-9090901&formpars={"ci_ReciveStatus":"1"}&type=基本
     */
    @GET("JD/UpdateAPPsjsJD")
    Observable<String> getOrderdeal(
            @Query("rwdid") String rwdid,
            @Query("formpars") String formpars,
            @Query("type") String type
    );

    /**
     * 温特斯获取方案说明
     * http://app.wenes.cn/api/program/getProjectBrief?rwdId=55-15065
     */
    @GET("api/program/getProjectBrief")
    Observable<String> getPlanTxt(
            @Query("rwdId") String rwdid
    );

    /**
     * 温特斯获取方案图片
     * http://app.wenes.cn/api/program/getDrawingList?rwdId=26-76187
     */
    @GET("api/program/getProgrammerAPP")
    Observable<String> getPlanImage(
            @Query("rwdId") String rwdid
    );

    /**
     * 根据任务的单号获取项目列表
     */
    @GET("order/OrderArrayByCardNo")
    Observable<String> loadCustomerData(
            @Query("cardNo") String cardNo,
            @Query("type") String type

    );

    /**
     * 项目类型
     */
    @GET("jd/ProjectCatalogArray")
    Observable<String> getProTypaeData(
    );

    /**
     * 添加回头客
     */
    @Multipart
    @POST("order/submitClientInfo")
    Observable<String> postCustomersInfo(
            @Part("rwdId") String rwdId,
            @Part("cityId") String cityId,
            @Part("type") String type,
            @Part("clientInfo") String clientInfo,
            @Part("clientAuxiliary") String clientAuxiliary
    );


    /**
     * 温特斯二维码扫描登录
     *
     * @return
     */
    @GET("bloc/cduan/PhoneLoginController")
    Observable<String> getDesERLogin(
            @Query("cardno") String cardno,
            @Query("password") String password,
            @Query("uuid") String uuid
    );

    /**
     * 获取行政的红包任务列表
     *///http://idc.dcwzg.com:13207/investment/bonus?cardNo=01000690
    //actionapi/TZManage/RedPacketList
    @GET("actionapi/TZManage/RedPacketList")
    Observable<String> getRedTask(
            @Query("cardNo") String cardno

    );

    /**
     * 获取主案的红包任务
     * http://192.168.1.60:23456/api/LocalTask/GetAPPRedPacket?cardNo=03710595
     */
    @GET("api/LocalTask/GetAPPRedPacket")
    Observable<String> getMainCaseRedTask(
            @Query("cardNo") String cardno

    );


    /**
     * 根据订单id，获取项目 所有信息
     */
    @GET("order/orderInfo")
    Observable<String> getDegisInfoData(
            @Query("rwdId") String rwdId

    );

    /**
     * 获取飘单数据
     */
    @GET("GetDesignerFloatSignList")
    Observable<String> getFloatedSheet(
            @Query("diquId") String diquId

    );

    /**
     * 获取是否是管理层
     */
    @GET("actionApi/TZManage/GetIsManageUser")
    Observable<String> getMnagementLayer(
            @Query("CardNo") String CardNo

    );

    /**
     * 发表文章
     */
    @Multipart
    @POST("a/sap/sapArticle/SaveArticle")
    Observable<String> postPublishArticle(
         //   @Part("id") String id,   //文章id  （修改文章的时候必传）
            @Part("name") String name,     // 文章标题
            @Part("cardno") String cardno,       // 作者卡号
            @Part("author") String author,       // 作者名称
            @Part("cover") String cover,
            @Part("content") String content,       // 文章内容
            @Part("flag") String flag  //修改标识 0添加 1修改

    );

    /**
     * -----------------------------------商务客服------------------------------------
     */

    /**
     * 客户信息
     */
    @Multipart
    @POST("DianShang/GetDianShangKeHuListApp")
    Observable<String> getKFCustomer(
            @Part("KaHao") String KaHao,
            @Part("PageSize") String PageSize,
            @Part("PageIndex") String PageIndex
    );

    /**
     * 城市
     */
    @Multipart
    @POST("DianShang/GetDiQuListApp")
    Observable<String> getKFCity(
            @Part("KaHao") String KaHao
    );

    /**
     * 渠道
     */
    @Multipart
    @POST("DianShang/GetDiQuQuDaoApp")
    Observable<String> getKFChannel(
            @Part("FenGongSiID") String FenGongSiID,
            @Part("Type") String Type
    );

    /**
     * 新增客户
     */
    @Multipart
    @POST("DianShang/AddDianShangKeYuanApp")
    Observable<String> getKFAddCustomer(

            @Part("XingMing") String XingMing,
            @Part("ShouJiHaoYi") String ShouJiHaoYi,
            @Part("card") String card,
            @Part("Channel") String Channel,
            @Part("City") String City,
            @Part("LeiXingYi") String LeiXingYi,
            @Part("LaiYuan") String LaiYuan,
            @Part("GongSiMingCheng") String GongSiMingCheng,
            @Part("KeyWord") String KeyWord,
            @Part("MianJi") String MianJi,
            @Part("FangYuan") String FangYuan,
            @Part("LeiXingEr") String LeiXingEr,
            @Part("FromURL") String FromURL,
            @Part("LandingURL") String LandingURL,
            @Part("IsMobilePC") String IsMobilePC,
            @Part("PTLaiYuan") String PTLaiYuan

    );

    /**
     * 修改客户
     */
    @Multipart
    @POST("DianShang/EditDianShangKeYuanApp")
    Observable<String> getKFFixCustomer(
            @Part("KeHuBaseID") String KeHuBaseID,
            @Part("XingMing") String XingMing,
            @Part("ShouJiHaoYi") String ShouJiHaoYi,
            @Part("Channel") String Channel,
            @Part("City") String City,
            @Part("LeiXingYi") String LeiXingYi,
            @Part("LaiYuan") String LaiYuan,
            @Part("GongSiMingCheng") String GongSiMingCheng,
            @Part("KeyWord") String KeyWord,
            @Part("MianJi") String MianJi,
            @Part("FangYuan") String FangYuan,
            @Part("LeiXingEr") String LeiXingEr,
            @Part("FromURL") String FromURL,
            @Part("LandingURL") String LandingURL,
            @Part("ZhuangTai") String ZhuangTai,
            @Part("IsMobilePC") String IsMobilePC

    );


    /**
     * 查询客户详情
     */
    @Multipart
    @POST("DianShang/GetDianShangKeHuInfoApp")
    Observable<String> getKFCustomerDetails(
            @Part("id") String id
    );


    /**
     * ------------------------------------温特斯合同------------------------------------
     */
    /**
     * 获取在谈合同信息
     * @param rwdId
     * @return
     */
    @GET("order/orderInfo")
    Observable<String> getTalkContractData(
            @Query("rwdId") String rwdId

    );

    /**
     * 提交合同信息
     * @param ca
     * @param rwdid
     * @return
     */
    @Multipart
    @POST("order/updateClientInfoAndClientAuxiliary")
    Observable<String> submitTalkContractData(
            @Part("ca") String ca,
            @Part("rwdId") String rwdid
    );
    /**
     * 请假列表
     */
    @GET("ActionApi/TZManage/GetLeaveList")
    Observable<String> getLeaveData(
            @Query("CardNo") String CardNo,
            @Query("year") int year,
            @Query("month") int month
    );
    /**
     * 请假类型
     */
    @GET("ActionApi/TZManage/GetLeaveStateList")
    Observable<String> getLeaTypeTyData(

    );
    /**申请考勤
     * /ActionApi/TZManage/ApplicationLeave
     */
    @GET("ActionApi/TZManage/ApplicationLeave")
    Observable<String> getpplyAttendance(
            @Query("cardno") String cardno,
            @Query("beginTime") String beginTime,
            @Query("endTime") String endTime,
            @Query("days") String days,
            @Query("reason") String reason,
            @Query("vacationState") int vacationState
    );
    /**
     * 申请转正
     */
    @FormUrlEncoded
    @POST("actionapi/TZManage/ApplyFormalUser")
    Observable<String> getpplyAttendance(
            @Query("CardNo") String CardNo,
            @Query("Reason1") String Reason1,
            @Query("Reason2") String Reason2
    );
    /**
     * 转正条件
     */
    @GET("actionapi/TZManage/GetApplyFormalUserContent")
    Observable<String> getsubmitConditions(
            @Query("CardNo") String CardNo

    );
    /**
     * 获取商务的红包任务列表
     *///https://api.niujingji.cn:8183/JTRenShi/APP_RS_GetRedPackTask?kahao=01010784
    @GET("JTRenShi/APP_RS_GetRedPackTask")
    Observable<String> getBusRed(
            @Query("kahao") String cardno

    );
    /**
     * 检查token
     */ ///actionapi/AppCurrencyHome/GetAppCheckToken
    @GET("actionapi/AppCurrencyHome/GetAppCheckToken")
    Observable<String> getCheckToken(
            @Query("CardNo") String CardNo,
            @Query("Token") String Token

    );
    /**
     * 获取店铺信息
     *
     */
    @GET("api/MemberManage/ShopInfo")
    Observable<String> getShopInfo(
            @Query("cardNo") String CardNo
    );
    /**
     * 修改店铺信息
     * //api/MemberManage/UpShopInfo
     */
     @Multipart
    @POST("api/MemberManage/UpShopInfo")
    Observable<String> postUpShopInfo(
            @Part("cardNo") String cardNo,
            @Part("image") String image,
            @Part("age")int age,
            @Part("workYears") int workYears,
            @Part("english") String english,
            @Part("consultation") String consultation,
            @Part("motto") String motto
    );
    /**
     * 获取首页信息
     */
    @GET("actionapi/KGManage/GetNewsList")
    Observable<String> getNeswList(
            @Query("card") String card
    );
    /**
     * 招商答题提价接口
     */
    @FormUrlEncoded
    @POST("actionapi/KGManage/AddSalesFirstTrial")
    Observable<String> getSubmitAnswer(
            @Field("card") String card,
            @Field("arr") String arr,
            @Field("newsId") int newsId
    );
    /**
     * actionapi/KGManage/GetWelcomes
     */
    @GET("actionapi/KGManage/GetWelcomes")
    Observable<String> getHuanying(
            @Query("card") String card
    );
    /**
     * 获取商务的红包数量接口
     */ //https://api.niujingji.cn:8183/JTRenShi/APP_RS_GetRedPackTaskCount?kahao=02900672
    @GET("JTRenShi/APP_RS_GetRedPackTaskCount")
    Observable<String> getBusinessRed(
            @Query("kahao") String card
    );
    /**
     * 获取主案的红包数量接口
     */
    /**
     *
     */ //http://nf.wenes.cn/api/LocalTask/RedBagCount?cardNo=01012386
    @GET("api/LocalTask/RedBagCount")
    Observable<String> getMainCaseRed(
            @Query("cardNo") String card
    );
    /**
     * 获取行政的红包数量接口
     *///http://apitz.rxjy.com:9192/actionapi/TZManage/RedPacketNum?cardNo=00002000
    @GET("actionapi/TZManage/RedPacketNum")
    Observable<String> getAdministrationRed(
            @Query("cardNo") String card
    );
    /**
     * 获取大院得薪酬
     */
    @GET("api/HR/GetNewSalary")
    Observable<String> getHospitaldata(
            @Query("card") String card
    );
}