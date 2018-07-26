package com.rxjy.rxcompound.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.rxjy.rxcompound.commons.App;


/**
 * Created by 阿禹 on 2018/1/2.
 * MySharedPreferences 本地储存
 */

public class MySharedPreferences {

    private volatile static MySharedPreferences mySharedPreferences;
    private SharedPreferences sharedPreferences;

    private MySharedPreferences(){
        sharedPreferences = App.context.getSharedPreferences("user" , App.context.MODE_PRIVATE);
    }

    private MySharedPreferences(Context context){
        sharedPreferences = context.getSharedPreferences("user" , App.context.MODE_PRIVATE);
    }

    public static MySharedPreferences getInstance(){
        if(mySharedPreferences==null){
            synchronized (MySharedPreferences.class){
                if(mySharedPreferences==null){
                    mySharedPreferences=new MySharedPreferences();
                }
            }
        }
        return mySharedPreferences;
    }

    public static MySharedPreferences getInstance(Context context){
        if(mySharedPreferences==null){
            synchronized (MySharedPreferences.class){
                if(mySharedPreferences==null){
                    mySharedPreferences=new MySharedPreferences(context);
                }
            }
        }
        return mySharedPreferences;
    }

    //是否第一次登陆
    public void setLoginState(int loginState){
        sharedPreferences.edit().putInt("loginState",loginState).commit();
    }
    public int getLoginState(){
        int loginState = sharedPreferences.getInt("loginState",0);
        return loginState;
    }

    //是否在线
    public void setIsResult(int isResult){
        sharedPreferences.edit().putInt("isResult",isResult).commit();
    }
    public int getIsResult(){
        int isResult = sharedPreferences.getInt("isResult",0);
        return isResult;
    }

    //用户账号
    public void setUserPhone(String userPhone){
        sharedPreferences.edit().putString("userPhone",userPhone).commit();
    }
    public String getUserPhone(){
        String userPhone = sharedPreferences.getString("userPhone",null);
        return userPhone;
    }

    //用户密码
    public void setUserPsw(String userPsw){
        sharedPreferences.edit().putString("userPsw",userPsw).commit();
    }
    public String getUserPsw(){
        String userPsw = sharedPreferences.getString("userPsw",null);
        return userPsw;
    }

    //用户
    public void setApp_id(String app_id){
        sharedPreferences.edit().putString("app_id",app_id).commit();
    }
    public String getApp_id(){
        String app_id = sharedPreferences.getString("app_id",null);
        return app_id;
    }

    //用户
    public void setToken(String token){
        sharedPreferences.edit().putString("token",token).commit();
    }
    public String getToken(){
        String token = sharedPreferences.getString("token",null);
        return token;
    }

    //分组
    public void setIs_group(String is_group){
        sharedPreferences.edit().putString("is_group",is_group).commit();
    }
    public String getIs_group(){
        String is_group = sharedPreferences.getString("is_group",null);
        return is_group;
    }

    //卡号
    public void setCardNo(String cardNo){
        sharedPreferences.edit().putString("cardNo",cardNo).commit();
    }
    public String getCardNo(){
        String cardNo = sharedPreferences.getString("cardNo",null);
        return cardNo;
    }

    //部门
    public void setDepart(int depart){
        sharedPreferences.edit().putInt("depart",depart).commit();
    }
    public int getDepart(){
        int depart = sharedPreferences.getInt("depart",0);
        return depart;
    }

    //部门id
    public void setPostid(int postid){
        sharedPreferences.edit().putInt("postid",postid).commit();
    }
    public int getPostid(){
        int postid = sharedPreferences.getInt("postid",0);
        return postid;
    }

    //职务名称
    public void setPostName(String postName){
        sharedPreferences.edit().putString("postName",postName).commit();
    }
    public String getPostName(){
        String postName = sharedPreferences.getString("postName",null);
        return postName;
    }

    //部门名称DepartName
    public void setDepartName(String DepartName){
        sharedPreferences.edit().putString("DepartName",DepartName).commit();
    }
    public String getDepartName(){
        String postName = sharedPreferences.getString("DepartName",null);
        return postName;
    }

    //姓名
    public void setName(String name){
        sharedPreferences.edit().putString("name",name).commit();
    }
    public String getName(){
        String name = sharedPreferences.getString("name",null);
        return name;
    }

    //用户u_start
    public void setU_start(int u_start){
        sharedPreferences.edit().putInt("u_start",u_start).commit();
    }
    public int getU_start(){
        int u_start = sharedPreferences.getInt("u_start",0);
        return u_start;
    }

    //用户app_stage
    public void setApp_stage(int app_stage){
        sharedPreferences.edit().putInt("app_stage",app_stage).commit();
    }
    public int getApp_stage(){
        int app_stage = sharedPreferences.getInt("app_stage",0);
        return app_stage;
    }

    //头像
    public void setImage(String image){
        sharedPreferences.edit().putString("image",image).commit();
    }
    public String getImage(){
        String image = sharedPreferences.getString("image",null);
        return image;
    }

    //集团id
    public void setRegion_id(int region_id){
        sharedPreferences.edit().putInt("region_id",region_id).commit();
    }
    public int getRegion_id(){
        int region_id = sharedPreferences.getInt("region_id",0);
        return region_id;
    }

    //集团名称
    public void setRegion_name(String region_name){
        sharedPreferences.edit().putString("region_name",region_name).commit();
    }
    public String getRegion_name(){
        String region_name = sharedPreferences.getString("region_name",null);
        return region_name;
    }

    //证件照
    public void setPassport_photo(String passport_photo){
        sharedPreferences.edit().putString("passport_photo",passport_photo).commit();
    }
    public String getPassport_photo(){
        String passport_photo = sharedPreferences.getString("passport_photo",null);
        return passport_photo;
    }

    //性别
    public void setSex(String sex){
        sharedPreferences.edit().putString("sex",sex).commit();
    }
    public String getSex(){
        String sex = sharedPreferences.getString("sex",null);
        return sex;
    }

    //性别
    public void setAccount(String account){
        sharedPreferences.edit().putString("account",account).commit();
    }
    public String getAccount(){
        String account = sharedPreferences.getString("account",null);
        return account;
    }

    //是否同意协议
    public void setIs_exist(int is_exist){
        sharedPreferences.edit().putInt("is_exist",is_exist).commit();
    }
    public int getIs_exist(){
        int is_exist = sharedPreferences.getInt("is_exist",0);
        return is_exist;
    }

    public void empty(){
        setToken(null);
        setIs_group(null);
        setCardNo(null);
        setDepart(0);
        setPostid(0);
        setPostName(null);
        setName(null);
        setU_start(0);
        setApp_stage(0);
        setImage(null);
        setRegion_id(0);
        setRegion_name(null);
        setPassport_photo(null);
        setSex(null);
        setIs_exist(0);
        setIsResult(0);
        setUserPhone(null);
        setApp_id(null);
        setUserPsw(null);
        setDepartName(null);
    }

}
