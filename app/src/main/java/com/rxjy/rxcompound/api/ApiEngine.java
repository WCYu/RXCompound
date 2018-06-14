package com.rxjy.rxcompound.api;

import com.rxjy.rxcompound.commons.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/1/9.
 */


public class ApiEngine {

    public static final String RS_API_HOST = "https://api.dcwzg.com:9191/";//线上
    // public static final String RS_API_HOST = "http://api.dcwzg.cs:9191/";//测试

    public static final String RXBUSIC_API_HOST = "https://api.niujingji.cn:8183/";//商务客户
    //   public static final String RXBUSIC_API_HOST_TEST = "https://api.niujingji.cn:8183/";//商务客户测试（获取地址）
    private static final String DES_API_GET = "http://api.wenes.cn/";//线上温特斯
//     private static final String DES_API_GET = "http://10.10.3.167:10030/";//测试温特斯

    // private static final String DES_API_LH="http://swb.idc.rx/";//温特斯量房单号获取
    private static final String DES_API_LH = "https://api.niujingji.cn:8183/";//温特斯量房单号获取

    // private static final String DES_API_LHSUBMIT = "http://192.168.1.192:8867/";//温特斯量房单号提交 测试
    private static final String DES_API_LHSUBMIT = "http://app.wenes.cn:8859/";//温特斯量房单号提交 线上

    private static final String DES_API_ERLOGIN = "http://192.168.1.192:8616/";//温特斯二维码登录

    private static final String GC_API_HOST = "http://api.gc.rxjy.com:/";//线上
    //  private static final String GC_API_HOST = "http://api.gc.cs/";//测试

    private static final String BAPI_HOSTMONEY = "http://idc.dcwzg.com:13207/";//线上钱包
    // private static final String BAPI_HOSTMONEY = "http://idc.dcwzg.com/";//测试

    public static final String RS_API_HOSTssssss = "http://api.p.rx/";//线上
    public static final String RX_API_HOST = "http://wpsnew.rxjy.com:9090/";


    //http://192.168.1.192:8867/order/OrderArrayByCardNo?cardNo=01013688&type=4
    public static final String FID_API_HOST = "http://wpsnew.rxjy.com:9090/";//发现模块数据线上
    // public static final String FID_API_HOST = "http://test.news.cs/";//发现模块数据测试


    public static final String RX_API_TZ = "http://h.p.rx/";//通知域名


    public static final String RXEDU_API_HOST = "http://edu.rx/a/rs/";
    public static final String RXBUSI_API_HOST = "http://swb.api.rx/";//商务
    public static final String RX_APIWPS_HOST = "http://www.rxjy.com/";//WPS登录
    private static final String DES_APIPIC_GET = "http://192.168.1.60:9998/";
    private static final String SW_API_HOST = "https://api.dcwzg.com:8182/";
    private static final String TYPE_API_HOST = "http://10.10.3.167:10030//";//项目类型
    public static final String ZA_API_HOST = "http://192.168.1.60:23456/";
//    public static final String RX_API_HOST = "http://wpsnew.rxjy.com:9090/a/sap/sapArticle/getAppArticleList";
//    //private static final String RX_API_HOST = "http://news.rx:9090/";
//    private static final String RX_API_HOST = "http://wpsnew.rxjy.com:9090/";
//    private static final String SW_API_HOST = "https://api.dcwzg.com:8182/";
//    private static final String DES_API_GET="https://api.wenes.cn/";
////    private static final String DES_API_GET="https://csapi.wenes.cn/";

    // public static final String TJ_API_HOST="http://192.168.1.192:8867/";//测试

    public static final String TJ_API_HOST = "http://192.168.1.192:8859/";//线上
    //http://192.168.1.192:8867/order/OrderArrayByCardNo?cardNo=01013688&type=4
    public static final String PD_API_HOST = "http://na.wenes.com/API/Contract/";

    public static final String FB_API_HOST = "http://wpsnew.rxjy.com/";//线上
    //public static final String FB_API_HOST= "http://wpsnew.rxjy.com/";//测试
    //http://api.p.rx/api/Join/GetNewsList?card=01012480
    public static final String NO_API_HOST = "http://nf.wenes.cn/";
    public static final String ZT_API_HOST = "http://apitz.rxjy.com:9192";

    //新增接口
    public static final String BASEURL = "http://swb.api.cs/"; // 测试
//    public static final String BASEURL = "https://api.niujingji.cn:8183/"; //线上

    //积分数据
    public static final String JIFENURL = BASEURL + "JTRenShi/APP_RS_GetIntegralPlate";
    //客户列表
    public static final String KEHULISTURL = BASEURL + "AppEmployee/GetCustomerList";
    //添加客户
    public static final String ADDKEHUURL = BASEURL + "AppEmployee/AddCustomer";
    //客户详情 AppAgent/GetKeHuInfo AppEmployee/GetCustomerDetail
    public static final String KEHUINFOURL = BASEURL + "AppAgent/GetKeHuInfo";
    //放弃客户
    public static final String DELETEURL = BASEURL + "AppEmployee/GiveUpCustomerApply";
    //
    public static final String LISTURL = BASEURL + "AppAgent/CustomerProperty";
    private Retrofit rxRetrofit;
    private Retrofit rsRetrofit;
    private Retrofit rsRetrofitsss;
    private Retrofit rseduRetrofit;
    private Retrofit rsbusiRetrofit;
    private Retrofit rsbusicRetrofit;
    private Retrofit swRetrofit;
    private Retrofit desRetrofit;
    private Retrofit rxRetrofitwps;
    private Retrofit rsbusicRetrofittest;
    private Retrofit gcRetrofit;
    private Retrofit moneyRetrofit;
    private Retrofit tzRetrofit;
    private Retrofit deslfRetrofit;
    private Retrofit deslfsubmitRetrofit;
    private Retrofit deserloginRetrofit;
    private Retrofit findRetrofit;
    private Retrofit zaRetrofit;
    private Retrofit fbRetrofit;

    private Retrofit typerxRetrofit;
    private Retrofit tjRetrofit;
    private Retrofit pdRetrofit;
    private Retrofit noRetrofit;
    private Retrofit ztRetrofit;
    //这里更好的保证单例的线程安全
    private volatile static ApiEngine apiEngine;
    private Retrofit retrofit;

    private ApiEngine() {

        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //设置查看类别
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //设置缓存位置与缓存的大小
        int size = 1024 * 1024 * 100;
        File cacheFile = new File(App.getContext().getCacheDir(), "okHttpCache");
        Cache cache = new Cache(cacheFile, size);

        //添加日志拦截器，并且添加网络缓存
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(12, TimeUnit.SECONDS)
                .writeTimeout(12, TimeUnit.SECONDS)
                .readTimeout(12, TimeUnit.SECONDS)
                .addNetworkInterceptor(new NetWorkInterceptor())
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();

        rxRetrofit = new Retrofit.Builder()
                .baseUrl(RX_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        //初始化材料的Retrofit对象
        rsRetrofit = new Retrofit.Builder()
                .baseUrl(RS_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        rsRetrofitsss = new Retrofit.Builder()
                .baseUrl(RS_API_HOSTssssss)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        rseduRetrofit = new Retrofit.Builder()
                .baseUrl(RXEDU_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        rsbusiRetrofit = new Retrofit.Builder()
                .baseUrl(RXBUSI_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        rsbusicRetrofit = new Retrofit.Builder()
                .baseUrl(RXBUSIC_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        rxRetrofitwps = new Retrofit.Builder()
                .baseUrl(RX_APIWPS_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        swRetrofit = new Retrofit.Builder()
                .baseUrl(SW_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        desRetrofit = new Retrofit.Builder()
                .baseUrl(DES_API_GET)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
//        rsbusicRetrofittest= new Retrofit.Builder()
//                .baseUrl(RXBUSIC_API_HOST_TEST)
//                .client(client)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
        gcRetrofit = new Retrofit.Builder()
                .baseUrl(GC_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        moneyRetrofit = new Retrofit.Builder()
                .baseUrl(BAPI_HOSTMONEY)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        tzRetrofit = new Retrofit.Builder()
                .baseUrl(RX_API_TZ)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        deslfRetrofit = new Retrofit.Builder()
                .baseUrl(DES_API_LH)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        deslfsubmitRetrofit = new Retrofit.Builder()
                .baseUrl(DES_API_LHSUBMIT)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        findRetrofit = new Retrofit.Builder()
                .baseUrl(FID_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        typerxRetrofit = new Retrofit.Builder()
                .baseUrl(TYPE_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        tjRetrofit = new Retrofit.Builder()
                .baseUrl(TJ_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        deserloginRetrofit = new Retrofit.Builder()
                .baseUrl(DES_API_ERLOGIN)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        zaRetrofit = new Retrofit.Builder()
                .baseUrl(ZA_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        pdRetrofit = new Retrofit.Builder()
                .baseUrl(PD_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        fbRetrofit = new Retrofit.Builder()
                .baseUrl(FB_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        noRetrofit = new Retrofit.Builder()
                .baseUrl(NO_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ztRetrofit = new Retrofit.Builder()
                .baseUrl(ZT_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    //将网络请求对象封装为单例模式
    public static ApiEngine getInstance() {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine();
                }
            }
        }
        return apiEngine;
    }

    public ApiService getRsApiService() {
        return rsRetrofit.create(ApiService.class);
    }

    public ApiService getRsApiServicess() {
        return rsRetrofitsss.create(ApiService.class);
    }

    public ApiService getRxApiService() {
        return rxRetrofit.create(ApiService.class);
    }

    public ApiService getRxeduApiHost() {
        return rseduRetrofit.create(ApiService.class);
    }

    public ApiService getRxbusiApiHost() {
        return rsbusiRetrofit.create(ApiService.class);
    }

    public ApiService getRxbusicApiHost() {
        return rsbusicRetrofit.create(ApiService.class);
    }

    public ApiService getSwApiService() {
        return swRetrofit.create(ApiService.class);
    }

    public ApiService getDesApiService() {
        return desRetrofit.create(ApiService.class);
    }

    public ApiService getDesApiWpsService() {
        return rxRetrofitwps.create(ApiService.class);
    }

    public ApiService getRxbusicApiHosttest() {
        return rsbusicRetrofittest.create(ApiService.class);
    }

    public ApiService getGcApiService() {
        return gcRetrofit.create(ApiService.class);
    }

    public ApiService getMoneyApiService() {
        return moneyRetrofit.create(ApiService.class);
    }

    public ApiService geTzApiService() {
        return tzRetrofit.create(ApiService.class);
    }

    public ApiService geDesLhApiService() {
        return deslfRetrofit.create(ApiService.class);
    }

    public ApiService geDesLhSubmitApiService() {
        return deslfsubmitRetrofit.create(ApiService.class);
    }

    public ApiService getfindApiService() {
        return findRetrofit.create(ApiService.class);
    }

    public ApiService gettypeApiService() {
        return typerxRetrofit.create(ApiService.class);
    }

    public ApiService getTjApiService() {
        return tjRetrofit.create(ApiService.class);
    }

    public ApiService getDesErLoginApiService() {
        return deserloginRetrofit.create(ApiService.class);
    }

    //zaRetrofit
    public ApiService getZAApiService() {
        return zaRetrofit.create(ApiService.class);
    }

    public ApiService getPDApiService() {
        return pdRetrofit.create(ApiService.class);
    }

    public ApiService getFBApiService() {
        return fbRetrofit.create(ApiService.class);
    }

    public ApiService getNOApiService() {
        return noRetrofit.create(ApiService.class);
    }

    public ApiService getZTApiService() {
        return ztRetrofit.create(ApiService.class);
    }
}