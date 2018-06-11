package com.rxjy.rxcompound.des.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseFragment;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.DesAlbumActivity;
import com.rxjy.rxcompound.des.activity.DesDaiMeasureActivity;
import com.rxjy.rxcompound.des.adapter.DesDaiImgAdapter;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;
import com.rxjy.rxcompound.des.entity.NewOneInfo;
import com.rxjy.rxcompound.des.entity.UpDanHaoInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewOneContract;
import com.rxjy.rxcompound.des.mvp.presenter.NewOnePresenter;
import com.rxjy.rxcompound.des.photo.MyCameraActivity;
import com.rxjy.rxcompound.widget.TextGridview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.rxjy.rxcompound.commons.Constants.LF_NUM;

/**
 * Created by Administrator on 2017/6/16.
 */
public class NewOneFragment extends BaseFragment<NewOnePresenter> implements AdapterView.OnItemClickListener, View.OnClickListener, NewOneContract.View {

    @Bind(R.id.et_measure_ca_cargo_door_hight)
    EditText etMeasureCaCargoDoorHight;
    @Bind(R.id.et_measure_ca_cargo_door_wide)
    EditText etMeasureCaCargoDoorWide;
    @Bind(R.id.et_measure_ca_grond_elevation)
    EditText etMeasureCaGrondElevation;
    @Bind(R.id.et_measure_windowsill_height)
    EditText etMeasureWindowsillHeight;
    @Bind(R.id.et_measure_windowsill_width)
    EditText etMeasureWindowsillWidth;
    @Bind(R.id.et_measure_windows_height)
    EditText etMeasureWindowsHeight;

    @Bind(R.id.btn_des_dai_measure_sub)
    TextView btnDesDaiMeasureSub;
    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;
    @Bind(R.id.et_new_kongtiaoshebei)
    EditText etNewKongtiaoshebei;
    @Bind(R.id.et_new_qiangdianxiang)
    EditText etNewQiangdianxiang;
    @Bind(R.id.et_new_ruodianxiang)
    EditText etNewRuodianxiang;
    @Bind(R.id.et_new_shangshuidian)
    EditText etNewShangshuidian;
    @Bind(R.id.et_xiashuidian)
    EditText etNewXiashuidian;
    @Bind(R.id.et_new_xiashuidianchicun)
    EditText etNewXiashuidianchicun;
    @Bind(R.id.et_new_zhuliangxiagao)
    EditText etNewZhuliangxiagao;
    @Bind(R.id.et_new_ciliangxiagao)
    EditText etNewCiliangxiagao;
    @Bind(R.id.et_new_yuandingmiangao)
    EditText etNewYuandingmiangao;
    @Bind(R.id.et_new_penlinzuididian)
    EditText etNewPenlinzuididian;
    @Bind(R.id.et_new_fengkouzuididian)
    EditText etNewFengkouzuididian;
    @Bind(R.id.et_new_muqiangkuangjiajianju)
    EditText etNewMuqiangkuangjiajianju;
    @Bind(R.id.tgv_houseface)
    TextGridview tgv_houseface;
    @Bind(R.id.tgv_wallmaterial)
    TextGridview tgv_wallmaterial;
    @Bind(R.id.tgv_topmaterial)
    TextGridview tgv_topmaterial;
    @Bind(R.id.tgv_groundmaterial)
    TextGridview tgv_groundmaterial;
    @Bind(R.id.tgv_windowtype)
    TextGridview tgv_windowtype;
    @Bind(R.id.tgv_occupypublic)
    TextGridview tgv_occupypublic;
    @Bind(R.id.tgv_groundsmooth)
    TextGridview tgv_groundsmooth;
    @Bind(R.id.tgv_waterpath)
    TextGridview tgv_waterpath;
    @Bind(R.id.tgv_originalground)
    TextGridview tgv_originalground;

    private int caCaHousingSituation = -1;                //房屋现状
    private String caHouseOrientation = "";                 //房屋朝向..
    private int caOccupyPublicCorridor = -1;             //占用公共过道
    private double caCargoDoorHight = -1;                   //货梯们高度
    private double caCargoDoorWide = -1;                    //货梯们宽度
    private int caOriginalGround = -1;                    //原地面保存   1是
    private String caIsGroundSmooth = "";                    //原地面平整
    private String caOriginalGroundMaterial = "";           //原地面材质
    private String caOriginalWallMaterial = "";             //原墙面材质
    private String caOriginalTopMaterial = "";              //原顶面材质
    private double caGroundElevation = -1;                  //地面高度差
    private double caSpaceMaxHeight = -1;                   //空间最高点
    private double caSpaceMinHeight = -1;                   //空间最低点
    private double camainBeamHeight = -1;                   //主梁下
    private double caSecondaryHeight = -1;                  //次梁下
    private double caMinimumSprayHeight = -1;               //喷淋最低点
    private int caAirConditionerNum = -1;                   //空调设备数
    private double caTuyereMinimumHeight = -1;             //风口最低点
    private int caStrongBoxNum = -1;                        //强电箱个数
    private int caWeakBoxNum = -1;                          //弱电箱个数
    private String caWaterPath = "";                        //上下水路径
    private int caUpWaterSpot = -1;                      //上水电
    private int caDownWaterSpot = -1;                    //下水点
    private double caDownWaterSpotSize = -1;                 //下水管径
    private double caCurtainWallSpacing = -1;                //幕墙架间距
    private String caWindowType = "";                          //窗户类型
    private double caWindowSillHight = -1;                    //窗台高
    private double caWindowWidth = -1;                          //窗户宽
    private double caWindowHight = -1;                          //窗户高


    //new
    private int kongtiaoshebei;
    private int qiangdianxiang;
    private int ruodianxiang;
    private int shangshuidian;
    private int xiashuidian;
    private double xiashuidianchicun;
    private double zhuliangxiagao;
    private double ciliangxiagao;
    private double yuandingmiangao;
    private double penlinzuididian;
    private double fengkouzuididian;
    private double muqiangkuangjiajianju;


    int itemmoney = 10;//单项数据的钱（假设为10）、、、、、、、、、、、、、、、、、、、、
    int moneynum;//当前金额对应的个数


    //private MatDao md;
    private boolean hasrwdID;

    private List<AllImagesInfo.Album> albumList;

    private DesDaiImgAdapter mAdapter;

    //客户信息
//    private AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;
    private AllClientNewBean.ClientNewBean clientInfo;
    //量房详情信息
    private DesDaiMeasureABean.BodyBean lhousedata;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_one;
    }

    DesDaiMeasureActivity activity;

    @Override
    protected void FragmentInitData() {
        //md = new MatDao(getActivity());

        activity = (DesDaiMeasureActivity) getActivity();


//        itemmoney=clientInfo.getJDMoney()/94;
        etNewKongtiaoshebei.addTextChangedListener(new MyEditListener(etNewKongtiaoshebei));
        etNewQiangdianxiang.addTextChangedListener(new MyEditListener(etNewQiangdianxiang));
        etNewRuodianxiang.addTextChangedListener(new MyEditListener(etNewRuodianxiang));
        etNewShangshuidian.addTextChangedListener(new MyEditListener(etNewShangshuidian));
        etNewXiashuidian.addTextChangedListener(new MyEditListener(etNewXiashuidian));
        etNewXiashuidianchicun.addTextChangedListener(new MyEditListener(etNewXiashuidianchicun));
        etNewZhuliangxiagao.addTextChangedListener(new MyEditListener(etNewZhuliangxiagao));
        etNewCiliangxiagao.addTextChangedListener(new MyEditListener(etNewCiliangxiagao));
        etNewYuandingmiangao.addTextChangedListener(new MyEditListener(etNewYuandingmiangao));
        etNewPenlinzuididian.addTextChangedListener(new MyEditListener(etNewPenlinzuididian));
        etNewFengkouzuididian.addTextChangedListener(new MyEditListener(etNewFengkouzuididian));
        etNewMuqiangkuangjiajianju.addTextChangedListener(new MyEditListener(etNewMuqiangkuangjiajianju));
        etMeasureCaCargoDoorHight.addTextChangedListener(new MyEditListener(etMeasureCaCargoDoorHight));
        etMeasureCaCargoDoorWide.addTextChangedListener(new MyEditListener(etMeasureCaCargoDoorWide));
        etMeasureCaGrondElevation.addTextChangedListener(new MyEditListener(etMeasureCaGrondElevation));
        etMeasureWindowsillHeight.addTextChangedListener(new MyEditListener(etMeasureWindowsillHeight));
        etMeasureWindowsillWidth.addTextChangedListener(new MyEditListener(etMeasureWindowsillWidth));
        etMeasureWindowsHeight.addTextChangedListener(new MyEditListener(etMeasureWindowsHeight));
        initAddData();
        initPhotoData();
        initMeasureData();


    }

    /**
     * 要添加的数据的赋值
     */
    private List<String> housefacelist;//房屋朝向
    private List<String> wallmaterialist;//原墙面材质
    private List<String> topmaterialist;//原顶面材质
    private List<String> groundmaterialist;//原地面材质
    private List<String> windowtypeialist;//窗户类型
    private List<String> yesnolist;//占用公共过道、原地面平整、原地面保存
    private List<String> waterpathlist;//上下水路径

    private void initAddData() {
        housefacelist = new ArrayList<>();
        housefacelist.add("东");
        housefacelist.add("西");
        housefacelist.add("南");
        housefacelist.add("北");

        wallmaterialist = new ArrayList<>();
        wallmaterialist.add("水泥");
        wallmaterialist.add("刮大白");
        wallmaterialist.add("乳胶漆");
        wallmaterialist.add("墙纸");

        topmaterialist = new ArrayList<>();
        topmaterialist.add("水泥毛坯");
        topmaterialist.add("矿棉板吊顶");
        topmaterialist.add("石膏板吊顶");
        topmaterialist.add("铝方通/铝扣/格栅");

        groundmaterialist = new ArrayList<>();
        groundmaterialist.add("水泥毛坯");
        groundmaterialist.add("网格地板");
        groundmaterialist.add("地毯");
        groundmaterialist.add("地砖");
        groundmaterialist.add("木地板");
        groundmaterialist.add("塑胶地板");

        windowtypeialist = new ArrayList<>();
        windowtypeialist.add("玻璃幕墙");
        windowtypeialist.add("飘窗");
        windowtypeialist.add("普通窗");
        windowtypeialist.add("落地窗");

        yesnolist = new ArrayList<>();
        yesnolist.add("是");
        yesnolist.add("否");

        waterpathlist = new ArrayList<>();
        waterpathlist.add("板底");
        waterpathlist.add("板顶");

        initShow();
    }

    int housefacem, wallmaterialm, topmaterialm, groundmaterialm, windowtypem, occupypublicm, groundsmoothm, waterpathm, originalgroundm;//代表还没有赋值

    /**
     * 展示添加量房信息的源数据
     */
    private void initShow() {
        tgv_houseface.setTvType("房屋朝向");
        tgv_houseface.setGvLines(4);
        tgv_houseface.setGvData(getActivity(), housefacelist);
        tgv_houseface.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {
                if (housefacem != 1) {
                    housefacem = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_HouseOrientation(housefacelist.get(position));
            }
        });

        tgv_wallmaterial.setTvType("原墙面材质");
        tgv_wallmaterial.setGvLines(4);
        tgv_wallmaterial.setGvData(getActivity(), wallmaterialist);
        tgv_wallmaterial.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (wallmaterialm != 1) {
                    wallmaterialm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_OriginalWallMaterial(wallmaterialist.get(position));
            }
        });

        tgv_topmaterial.setTvType("原顶面材质");
        tgv_topmaterial.setGvLines(2);
        tgv_topmaterial.setGvData(getActivity(), topmaterialist);
        tgv_topmaterial.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (topmaterialm != 1) {
                    topmaterialm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_OriginalTopMaterial(topmaterialist.get(position));
            }
        });

        tgv_groundmaterial.setTvType("原地面材质");
        tgv_groundmaterial.setGvLines(4);
        tgv_groundmaterial.setGvData(getActivity(), groundmaterialist);
        tgv_groundmaterial.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (groundmaterialm != 1) {
                    groundmaterialm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_OriginalGroundMaterial(groundmaterialist.get(position));
            }
        });

        tgv_windowtype.setTvType("窗户类型");
        tgv_windowtype.setGvLines(4);
        tgv_windowtype.setGvData(getActivity(), windowtypeialist);
        tgv_windowtype.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (windowtypem != 1) {
                    windowtypem = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_WindowType(windowtypeialist.get(position));
            }
        });

        tgv_occupypublic.setTvType("占用公共过道");//1是  2否
        tgv_occupypublic.setGvLines(4);
        tgv_occupypublic.setGvData(getActivity(), yesnolist);
        tgv_occupypublic.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (occupypublicm != 1) {
                    occupypublicm = 1;
                    addMoney();
                }
                switch (position){
                    case 0:
                        activity.savedatabean.setCa_OccupyPublicCorridor("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_OccupyPublicCorridor("2");
                        break;
                }
            }
        });

        tgv_groundsmooth.setTvType("原地面平整");
        tgv_groundsmooth.setGvLines(4);
        tgv_groundsmooth.setGvData(getActivity(), yesnolist);
        tgv_groundsmooth.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (groundsmoothm != 1) {
                    groundsmoothm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_isGroundSmooth(yesnolist.get(position));
            }
        });

        tgv_waterpath.setTvType("上下水路径");
        tgv_waterpath.setGvLines(4);
        tgv_waterpath.setGvData(getActivity(), waterpathlist);
        tgv_waterpath.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (waterpathm != 1) {
                    waterpathm = 1;
                    addMoney();
                }
                activity.savedatabean.setCa_WaterPath(waterpathlist.get(position));
            }
        });

        tgv_originalground.setTvType("原地面保存");
        tgv_originalground.setGvLines(4);
        tgv_originalground.setGvData(getActivity(), yesnolist);
        tgv_originalground.tochoose(new TextGridview.Choose() {
            @Override
            public void tochoose(int position) {//
                if (originalgroundm != 1) {
                    originalgroundm = 1;
                    addMoney();
                }
                switch (position){
                    case 0:
                        activity.savedatabean.setCa_OriginalGround("1");
                        break;
                    case 1:
                        activity.savedatabean.setCa_OriginalGround("2");
                        break;
                }
            }
        });
    }


    /**
     * 量房列表中的数据
     * @param info
     */
//    public void setClientInfo(AllClientInfo.ClientTypeInfo.ClientInfo info) {
//        clientInfo = info;
//    }
    public void setClientInfo(AllClientNewBean.ClientNewBean info) {
        clientInfo = info;
    }

    /**
     * 获取到的量房信息
     */
    public void setLHouseData(DesDaiMeasureABean.BodyBean bean) {
        lhousedata = bean;
        Log.e("获取到。。获取到的量房信息", "并显示");
        ShowView(bean);
    }

    private void ShowView(DesDaiMeasureABean.BodyBean bean) {
        moneynum = activity.moneynum;
        //展示
        if (!StringUtils.isEmpty(bean.getCa_HouseOrientation())) {
            housefacem = 1;
            for (int i = 0; i < housefacelist.size(); i++) {
                if (housefacelist.get(i).equals(bean.getCa_HouseOrientation())) {
                    tgv_houseface.setContents(bean.getCa_HouseOrientation(), i);
                    break;
                }
            }
        }
        if (!StringUtils.isEmpty(bean.getCa_OccupyPublicCorridor())) {
            occupypublicm = 1;
            switch (bean.getCa_OccupyPublicCorridor()) {
                case "1":
                    tgv_occupypublic.setContents("是", 0);
                    break;
                case "2":
                    tgv_occupypublic.setContents("否", 1);
                    break;
            }
        }
        if (!StringUtils.isEmpty(bean.getCa_OriginalGround())) {
            originalgroundm = 1;
            switch (bean.getCa_OriginalGround()) {
                case "1":
                    tgv_originalground.setContents("是", 0);
                    break;
                case "2":
                    tgv_originalground.setContents("否", 1);
                    break;
            }
        }
        if (!StringUtils.isEmpty(bean.getCa_isGroundSmooth())) {
            groundsmoothm = 1;
            for (int i = 0; i < yesnolist.size(); i++) {
                if (yesnolist.get(i).equals(bean.getCa_isGroundSmooth())) {
                    tgv_groundsmooth.setContents(bean.getCa_isGroundSmooth(), i);
                    break;
                }
            }
        }
        if (!StringUtils.isEmpty(bean.getCa_OriginalGroundMaterial())) {
            groundmaterialm = 1;
            for (int i = 0; i < groundmaterialist.size(); i++) {
                if (groundmaterialist.get(i).equals(bean.getCa_OriginalGroundMaterial())) {
                    tgv_groundmaterial.setContents(bean.getCa_OriginalGroundMaterial(), i);
                    break;
                }
            }
        }

        if (!StringUtils.isEmpty(bean.getCa_OriginalWallMaterial())) {
            wallmaterialm = 1;
            for (int i = 0; i < wallmaterialist.size(); i++) {
                if (wallmaterialist.get(i).equals(bean.getCa_OriginalWallMaterial())) {
                    tgv_wallmaterial.setContents(bean.getCa_OriginalWallMaterial(), i);
                    break;
                }
            }
        }

        if (!StringUtils.isEmpty(bean.getCa_OriginalTopMaterial())) {
            topmaterialm = 1;
            for (int i = 0; i < topmaterialist.size(); i++) {
                if (topmaterialist.get(i).equals(bean.getCa_OriginalTopMaterial())) {
                    tgv_topmaterial.setContents(bean.getCa_OriginalTopMaterial(), i);
                    break;
                }
            }
        }

        if (!StringUtils.isEmpty(bean.getCa_WaterPath())) {
            waterpathm = 1;
            for (int i = 0; i < waterpathlist.size(); i++) {
                if (waterpathlist.get(i).equals(bean.getCa_WaterPath())) {
                    tgv_waterpath.setContents(bean.getCa_WaterPath(), i);
                    break;
                }
            }
        }

        if (!StringUtils.isEmpty(bean.getCa_WindowType())) {
            windowtypem = 1;
            for (int i = 0; i < windowtypeialist.size(); i++) {
                if (windowtypeialist.get(i).equals(bean.getCa_WindowType())) {
                    tgv_windowtype.setContents(bean.getCa_WindowType(), i);
                    break;
                }
            }
        }


//        caHouseOrientation = info.getCa_HouseOrientation();                 //房屋朝向..
//        caOccupyPublicCorridor = Integer.parseInt(info.getCa_OccupyPublicCorridor());             //占用公共过道
        if (!StringUtils.isEmpty(bean.getCa_CargoDoorHight())) {
            ca_cargo_door_hightm = 1;
//            Log.e("getCa_CargoDoorHight：,,,,",bean.getCa_CargoDoorHight());
            caCargoDoorHight = Double.parseDouble(bean.getCa_CargoDoorHight());                   //货梯们高度
            etMeasureCaCargoDoorHight.setText(caCargoDoorHight + "");
        }
        if (!StringUtils.isEmpty(bean.getCa_CargoDoorWide())) {
            ca_cargo_door_widem = 1;
            caCargoDoorWide = Double.parseDouble(bean.getCa_CargoDoorWide());                    //货梯们宽度
            etMeasureCaCargoDoorWide.setText(caCargoDoorWide + "");
        }
//        caOriginalGround = Integer.parseInt(info.getCa_OriginalGround());                    //原地面保存
//        caIsGroundSmooth = info.getCa_isGroundSmooth();                    //原地面平整
//        caOriginalGroundMaterial = info.getCa_OriginalGroundMaterial();           //原地面材质
//        caOriginalWallMaterial = info.getCa_OriginalWallMaterial();             //原墙面材质
//        caOriginalTopMaterial = info.getCa_OriginalTopMaterial();              //原顶面材质
        if (!StringUtils.isEmpty(bean.getCa_GroundElevation())) {
            ca_grond_elevationm = 1;
            caGroundElevation = Double.parseDouble(bean.getCa_GroundElevation());                  //地面高度差
            etMeasureCaGrondElevation.setText(caGroundElevation + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_SpaceMaxHeight())) {
            yuandingmiangaom = 1;
            caSpaceMaxHeight = Double.parseDouble(bean.getCa_SpaceMaxHeight());                   //空间最高点
            etNewYuandingmiangao.setText(caSpaceMaxHeight + "");
        }

//        if(!StringUtils.isEmpty(bean.getCa_SpaceMinHeight())){
//            =1;
//            caSpaceMinHeight = Double.parseDouble(bean.getCa_SpaceMinHeight());                   //空间最低点
//        }

        if (!StringUtils.isEmpty(bean.getCa_mainBeamHeight())) {
            zhuliangxiagaom = 1;
            camainBeamHeight = Double.parseDouble(bean.getCa_mainBeamHeight());                   //主梁下
            etNewZhuliangxiagao.setText(camainBeamHeight + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_SecondaryHeight())) {
            ciliangxiagaom = 1;
            caSecondaryHeight = Double.parseDouble(bean.getCa_SecondaryHeight());                  //次梁下
            etNewCiliangxiagao.setText(caSecondaryHeight + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_MinimumSprayHeight())) {
            penlinzuididianm = 1;
            caMinimumSprayHeight = Double.parseDouble(bean.getCa_MinimumSprayHeight());               //喷淋最低点
            etNewPenlinzuididian.setText(caMinimumSprayHeight + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_AirConditionerNum())) {
            kongtiaoshebeim = 1;
            caAirConditionerNum = Integer.parseInt(bean.getCa_AirConditionerNum());                   //空调设备数
            etNewKongtiaoshebei.setText(caAirConditionerNum + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_TuyereMinimumHeight())) {
            fengkouzuididianm = 1;
            caTuyereMinimumHeight = Double.parseDouble(bean.getCa_TuyereMinimumHeight());             //风口最低点
            etNewFengkouzuididian.setText(caTuyereMinimumHeight + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_StrongBoxNum())) {
            qiangdianxiangm = 1;
            caStrongBoxNum = Integer.parseInt(bean.getCa_StrongBoxNum());                        //强电箱个数
            etNewQiangdianxiang.setText(caStrongBoxNum + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_WeakBoxNum())) {
            ruodianxiangm = 1;
            caWeakBoxNum = Integer.parseInt(bean.getCa_WeakBoxNum());                          //弱电箱个数
            etNewRuodianxiang.setText(caWeakBoxNum + "");
        }

//        caWaterPath = info.getCa_WaterPath();                        //上下水路径
        if (!StringUtils.isEmpty(bean.getCa_UpWaterSpot())) {
            shangshuidianm = 1;
            caUpWaterSpot = Integer.parseInt(bean.getCa_UpWaterSpot());                      //上水电
            etNewShangshuidian.setText(caUpWaterSpot + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_DownWaterSpot())) {
            xiashuidianm = 1;
            caDownWaterSpot = Integer.parseInt(bean.getCa_DownWaterSpot());                    //下水点
            etNewXiashuidian.setText(caDownWaterSpot + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_DownWaterSpotSize())) {
            xiashuidianchicunm = 1;
            caDownWaterSpotSize = Double.parseDouble(bean.getCa_DownWaterSpotSize());                 //下水管径
            etNewXiashuidianchicun.setText(caDownWaterSpotSize + "");
        }

        if (!StringUtils.isEmpty(bean.getCa_CurtainWallSpacing())) {
            muqiangkuangjiajianjum = 1;
            caCurtainWallSpacing = Double.parseDouble(bean.getCa_CurtainWallSpacing());                //幕墙架间距
            etNewMuqiangkuangjiajianju.setText(caCurtainWallSpacing + "");
        }
//        caWindowType = info.getCa_WindowType();                          //窗户类型
        if (!StringUtils.isEmpty(bean.getCa_windowsillHight())) {
            windowsill_heightm = 1;
            caWindowSillHight = Double.parseDouble(bean.getCa_windowsillHight());                    //窗台高
            etMeasureWindowsillHeight.setText(caWindowSillHight + "");
        }
        if (!StringUtils.isEmpty(bean.getCa_WindowWidth())) {
            windowsill_widthm = 1;
            caWindowWidth = Double.parseDouble(bean.getCa_WindowWidth());                          //窗户宽
            etMeasureWindowsillWidth.setText(caWindowWidth + "");
        }
        if (!StringUtils.isEmpty(bean.getCa_WindowHight())) {
            windows_heightm = 1;
            caWindowHight = Double.parseDouble(bean.getCa_WindowHight());                          //窗户高
            etMeasureWindowsHeight.setText(caWindowHight + "");
        }

//        if (caCargoDoorHight != 0.0f && caCargoDoorHight != 0) {
//            etMeasureCaCargoDoorHight.setText(caCargoDoorHight + "");
//        }
//        if (caCargoDoorWide != 0.0f && caCargoDoorWide != 0) {
//            etMeasureCaCargoDoorWide.setText(caCargoDoorWide + "");
//        }
//        if (caGroundElevation != 0.0f && caGroundElevation != 0) {
//            etMeasureCaGrondElevation.setText(caGroundElevation + "");
//        }
        //etMeasureMinHeight.setText(caSpaceMinHeight + "");
//        if (caSpaceMaxHeight != 0.0f && caSpaceMaxHeight != 0) {
//            etNewYuandingmiangao.setText(caSpaceMaxHeight + "");
//        }
//        if (camainBeamHeight != 0.0f && camainBeamHeight != 0) {
//            etNewZhuliangxiagao.setText(camainBeamHeight + "");
//        }
//        if (caSecondaryHeight != 0.0f && caSecondaryHeight != 0) {
//            etNewCiliangxiagao.setText(caSecondaryHeight + "");
//        }
//        if (caAirConditionerNum != 0.0f && caAirConditionerNum != 0) {
//            etNewKongtiaoshebei.setText(caAirConditionerNum + "");
//        }
//        if (caTuyereMinimumHeight != 0.0f && caTuyereMinimumHeight != 0) {
//            etNewFengkouzuididian.setText(caTuyereMinimumHeight + "");
//        }
//        if (caStrongBoxNum != 0.0f && caStrongBoxNum != 0) {
//            etNewQiangdianxiang.setText(caStrongBoxNum + "");
//        }
//        if (caWeakBoxNum != 0.0f && caWeakBoxNum != 0) {
//            etNewRuodianxiang.setText(caWeakBoxNum + "");
//        }
//        if (caUpWaterSpot != 0.0f && caUpWaterSpot != 0) {
//            etNewShangshuidian.setText(caUpWaterSpot + "");
//        }
//        if (caDownWaterSpot != 0.0f && caDownWaterSpot != 0) {
//            etNewXiashuidian.setText(caDownWaterSpot + "");
//        }
//        if (caDownWaterSpotSize != 0.0f && caDownWaterSpotSize != 0) {
//            etNewXiashuidianchicun.setText(caDownWaterSpotSize + "");
//        }
//        if (caMinimumSprayHeight != 0.0f && caMinimumSprayHeight != 0) {
//            etNewPenlinzuididian.setText(caMinimumSprayHeight + "");
//        }
//        if (caWindowSillHight != 0.0f && caWindowSillHight != 0) {
//            etMeasureWindowsillHeight.setText(caWindowSillHight + "");
//        }
//        if (caWindowWidth != 0.0f && caWindowWidth != 0) {
//            etMeasureWindowsillWidth.setText(caWindowWidth + "");
//        }
//        if (caWindowHight != 0.0f && caWindowHight != 0) {
//            etMeasureWindowsHeight.setText(caWindowHight + "");
//        }
//        if (caCurtainWallSpacing != 0.0f && caCurtainWallSpacing != 0) {
//            etNewMuqiangkuangjiajianju.setText(caCurtainWallSpacing + "");
//        }
    }


    private void initPhotoData() {
        albumList = new ArrayList<>();

        mAdapter = new DesDaiImgAdapter(getActivity(), albumList);

//        gvDesDaiMeasurePhoto.setAdapter(mAdapter);
//
//        gvDesDaiMeasurePhoto.setOnItemClickListener(this);
    }

    private void initMeasureData() {
        btnDesDaiMeasureSub.setOnClickListener(this);
        //获取量房信息
        //mPresenter.getDaiMeasureData(clientInfo.getCi_rwdid());
//        mPresenter.GetNewOne(clientInfo.getCi_rwdid());
    }

    @Override
    protected NewOnePresenter onCreatePresenter() {
        return new NewOnePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取量房图片列表接口
        //mPresenter.getDaiMeasureImageData(clientInfo.getCi_rwdid(), "1", "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private int position;

    //@OnClick({R.id.tv_measure_tenancy_term_end_time, R.id.tv_measure_tenancy_term_start_time, R.id.btn_des_dai_measure_sub})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.takePhoto:
                //Toast.makeText(getActivity(),"点击了拍照",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MyCameraActivity.class);
                intent.putExtra("MYCAMERAPOS", position);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, clientInfo);
                startActivity(intent);
                dialog.dismiss();
                break;
            case R.id.choosePhoto:
                //Toast.makeText(getActivity(),"点击了选择照片",Toast.LENGTH_SHORT).show();
                AllImagesInfo.Album info = albumList.get(position);
                List<AllImagesInfo.Album.image> imageList = info.getChildList();
                Intent albumIntent = new Intent(getActivity(), DesAlbumActivity.class);
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<AllImagesInfo.Album.image>) imageList);
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, clientInfo.getWorksID());
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
                albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, clientInfo.getCustomerID());
                startActivity(albumIntent);
                dialog.dismiss();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
            case R.id.btn_des_dai_measure_sub:
                caCargoDoorWide = Double.parseDouble(etMeasureCaCargoDoorWide.getText().toString().trim().equals("") ? -1 + "" : etMeasureCaCargoDoorWide.getText().toString().trim());
                Bodyinfo.setCa_CargoDoorWide(caCargoDoorWide + "");
                kongtiaoshebei = Integer.parseInt(etNewKongtiaoshebei.getText().toString().trim().equals("") ? -1 + "" : etNewKongtiaoshebei.getText().toString().trim());
                Bodyinfo.setCa_AirConditionerNum(kongtiaoshebei + "");
                qiangdianxiang = Integer.parseInt(etNewQiangdianxiang.getText().toString().trim().equals("") ? -1 + "" : etNewQiangdianxiang.getText().toString().trim());
                Bodyinfo.setCa_StrongBoxNum(qiangdianxiang + "");
                ruodianxiang = Integer.parseInt(etNewRuodianxiang.getText().toString().trim().equals("") ? -1 + "" : etNewRuodianxiang.getText().toString().trim());
                Bodyinfo.setCa_WeakBoxNum(ruodianxiang + "");
                shangshuidian = Integer.parseInt(etNewShangshuidian.getText().toString().trim().equals("") ? -1 + "" : etNewShangshuidian.getText().toString().trim());
                Bodyinfo.setCa_UpWaterSpot(shangshuidian + "");
                xiashuidian = Integer.parseInt(etNewXiashuidian.getText().toString().trim().equals("") ? -1 + "" : etNewXiashuidian.getText().toString().trim());
                Bodyinfo.setCa_DownWaterSpot(xiashuidian + "");
                xiashuidianchicun = Double.parseDouble(etNewXiashuidianchicun.getText().toString().trim().equals("") ? -1 + "" : etNewXiashuidianchicun.getText().toString().trim());
                Bodyinfo.setCa_DownWaterSpotSize(xiashuidianchicun + "");
                zhuliangxiagao = Double.parseDouble(etNewZhuliangxiagao.getText().toString().trim().equals("") ? -1 + "" : etNewZhuliangxiagao.getText().toString().trim());
                Bodyinfo.setCa_mainBeamHeight(zhuliangxiagao + "");
                ciliangxiagao = Double.parseDouble(etNewCiliangxiagao.getText().toString().trim().equals("") ? -1 + "" : etNewCiliangxiagao.getText().toString().trim());
                Bodyinfo.setCa_SecondaryHeight(ciliangxiagao + "");
                yuandingmiangao = Double.parseDouble(etNewYuandingmiangao.getText().toString().trim().equals("") ? -1 + "" : etNewYuandingmiangao.getText().toString().trim());
                Bodyinfo.setCa_SpaceMaxHeight(yuandingmiangao + "");
                penlinzuididian = Double.parseDouble(etNewPenlinzuididian.getText().toString().trim().equals("") ? -1 + "" : etNewPenlinzuididian.getText().toString().trim());
                Bodyinfo.setCa_MinimumSprayHeight(penlinzuididian + "");
                fengkouzuididian = Double.parseDouble(etNewFengkouzuididian.getText().toString().trim().equals("") ? -1 + "" : etNewFengkouzuididian.getText().toString().trim());
                Bodyinfo.setCa_TuyereMinimumHeight(fengkouzuididian + "");
                muqiangkuangjiajianju = Double.parseDouble(etNewMuqiangkuangjiajianju.getText().toString().trim().equals("") ? -1 + "" : etNewMuqiangkuangjiajianju.getText().toString().trim());
                Bodyinfo.setCa_CurtainWallSpacing(muqiangkuangjiajianju + "");
                caCargoDoorHight = Double.parseDouble(etMeasureCaCargoDoorHight.getText().toString().trim().equals("") ? -1 + "" : etMeasureCaCargoDoorHight.getText().toString().trim());
                Bodyinfo.setCa_CargoDoorHight(caCargoDoorHight + "");
                caGroundElevation = Double.parseDouble(etMeasureCaGrondElevation.getText().toString().trim().equals("") ? -1 + "" : etMeasureCaGrondElevation.getText().toString().trim());
                Bodyinfo.setCa_GroundElevation(caGroundElevation + "");
                caWindowSillHight = Double.parseDouble(etMeasureWindowsillHeight.getText().toString().trim().equals("") ? -1 + "" : etMeasureWindowsillHeight.getText().toString().trim());
                Bodyinfo.setCa_windowsillHight(caWindowSillHight + "");
                caWindowWidth = Double.parseDouble(etMeasureWindowsillWidth.getText().toString().trim().equals("") ? -1 + "" : etMeasureWindowsillWidth.getText().toString().trim());
                Bodyinfo.setCa_WindowWidth(caWindowWidth + "");
                caWindowHight = Double.parseDouble(etMeasureWindowsHeight.getText().toString().trim().equals("") ? -1 + "" : etMeasureWindowsHeight.getText().toString().trim());
                Bodyinfo.setCa_WindowHight(caWindowHight + "");

                caHouseOrientation = tgv_houseface.getSelectcontent();
                Bodyinfo.setCa_HouseOrientation(caHouseOrientation);//房屋朝向
                String isoccupypublic = tgv_occupypublic.getSelectcontent();
                switch (isoccupypublic) {
                    case "是":
                        caOccupyPublicCorridor = 1;
                        break;
                    case "否":
                        caOccupyPublicCorridor = 2;
                        break;
                }
                Bodyinfo.setCa_OccupyPublicCorridor(caOccupyPublicCorridor + "");//占用公共过道 1是2否
                caOriginalGroundMaterial = tgv_groundmaterial.getSelectcontent();
                Bodyinfo.setCa_OriginalGroundMaterial(caOriginalGroundMaterial);//原地面材质
                caIsGroundSmooth = tgv_groundsmooth.getSelectcontent();
                Bodyinfo.setCa_isGroundSmooth(caIsGroundSmooth + "");//原地面平整
                caOriginalTopMaterial = tgv_topmaterial.getSelectcontent();
                Bodyinfo.setCa_OriginalTopMaterial(caOriginalTopMaterial + "");//原顶面材质
                caOriginalWallMaterial = tgv_wallmaterial.getSelectcontent();
                Bodyinfo.setCa_OriginalWallMaterial(caOriginalWallMaterial + "");//原墙面材质
                caWindowType = tgv_windowtype.getSelectcontent();
                Bodyinfo.setCa_WindowType(caWindowType + "");//窗户类型
                caWaterPath = tgv_waterpath.getSelectcontent();
                Bodyinfo.setCa_WaterPath(caWaterPath + "");//上下水路径
                String groundsave = tgv_originalground.getSelectcontent();
                switch (groundsave) {
                    case "是":
                        caOriginalGround = 1;
                        break;
                    case "否":
                        caOriginalGround = 2;
                        break;
                }
                Bodyinfo.setCa_OriginalGround(caOriginalGround + "");//原地面保存  1是2否
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("确认提交量房信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {
                        String info = JSONUtils.toString(Bodyinfo);
//                        mPresenter.UpXinxi(clientInfo.getCi_rwdid(), info, "量房");
                        mPresenter.UpXinxi(clientInfo.getCi_RwdId(), info, "量房");


                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private NewOneInfo.BodyBean Bodyinfo;
//    private DesDaiMeasureABean.BodyBean savedatabean;//要保存提交的数据

    @Override
    public void responseGetNewOne(NewOneInfo.BodyBean info) {

        Bodyinfo = info;
        Log.e("没有请求", "不会走这了。。。。");

//        for (int i = 0; i < housefacelist.size(); i++) {
//            if(housefacelist.get(i).equals(info.getCa_HouseOrientation())){
//                tgv_houseface.setContents(info.getCa_HouseOrientation(), i);
//                break;
//            }
//        }
//        switch (info.getCa_OccupyPublicCorridor()){
//            case "1":
//                tgv_occupypublic.setContents("是", 0);
//                break;
//            case "2":
//                tgv_occupypublic.setContents("否", 1);
//                break;
//        }
//        switch (info.getCa_OriginalGround()){
//            case "1":
//                tgv_originalground.setContents("是", 0);
//                break;
//            case "2":
//                tgv_originalground.setContents("否", 1);
//                break;
//        }
//        for (int i = 0; i < yesnolist.size(); i++) {
//            if(yesnolist.get(i).equals(info.getCa_isGroundSmooth())){
//                tgv_groundsmooth.setContents(info.getCa_isGroundSmooth(), i);
//                break;
//            }
//        }
//        for (int i = 0; i < groundmaterialist.size(); i++) {
//            if(groundmaterialist.get(i).equals(info.getCa_OriginalGroundMaterial())){
//                tgv_groundmaterial.setContents(info.getCa_OriginalGroundMaterial(), i);
//                break;
//            }
//        }
//        for (int i = 0; i < wallmaterialist.size(); i++) {
//            if(wallmaterialist.get(i).equals(info.getCa_OriginalWallMaterial())){
//                tgv_wallmaterial.setContents(info.getCa_OriginalWallMaterial(), i);
//                break;
//            }
//        }
//        for (int i = 0; i < topmaterialist.size(); i++) {
//            if(topmaterialist.get(i).equals(info.getCa_OriginalTopMaterial())){
//                tgv_topmaterial.setContents(info.getCa_OriginalTopMaterial(), i);
//                break;
//            }
//        }
//        for (int i = 0; i < waterpathlist.size(); i++) {
//            if(waterpathlist.get(i).equals(info.getCa_WaterPath())){
//                tgv_waterpath.setContents(info.getCa_WaterPath(), i);
//                break;
//            }
//        }
//        for (int i = 0; i < windowtypeialist.size(); i++) {
//            if(windowtypeialist.get(i).equals(info.getCa_WindowType())){
//                tgv_windowtype.setContents(info.getCa_WindowType(), i);
//                break;
//            }
//        }
//
////        caHouseOrientation = info.getCa_HouseOrientation();                 //房屋朝向..
////        caOccupyPublicCorridor = Integer.parseInt(info.getCa_OccupyPublicCorridor());             //占用公共过道
//        caCargoDoorHight = Double.parseDouble(info.getCa_CargoDoorHight());                   //货梯们高度
//        caCargoDoorWide = Double.parseDouble(info.getCa_CargoDoorWide());                    //货梯们宽度
////        caOriginalGround = Integer.parseInt(info.getCa_OriginalGround());                    //原地面保存
////        caIsGroundSmooth = info.getCa_isGroundSmooth();                    //原地面平整
////        caOriginalGroundMaterial = info.getCa_OriginalGroundMaterial();           //原地面材质
////        caOriginalWallMaterial = info.getCa_OriginalWallMaterial();             //原墙面材质
////        caOriginalTopMaterial = info.getCa_OriginalTopMaterial();              //原顶面材质
//        caGroundElevation = Double.parseDouble(info.getCa_GroundElevation());                  //地面高度差
//        caSpaceMaxHeight = Double.parseDouble(info.getCa_SpaceMaxHeight());                   //空间最高点
//        caSpaceMinHeight = Double.parseDouble(info.getCa_SpaceMinHeight());                   //空间最低点
//        camainBeamHeight = Double.parseDouble(info.getCa_mainBeamHeight());                   //主梁下
//        caSecondaryHeight = Double.parseDouble(info.getCa_SecondaryHeight());                  //次梁下
//        caMinimumSprayHeight = Double.parseDouble(info.getCa_MinimumSprayHeight());               //喷淋最低点
//        caAirConditionerNum = Integer.parseInt(info.getCa_AirConditionerNum());                   //空调设备数
//        caTuyereMinimumHeight = Double.parseDouble(info.getCa_TuyereMinimumHeight());             //风口最低点
//        caStrongBoxNum = Integer.parseInt(info.getCa_StrongBoxNum());                        //强电箱个数
//        caWeakBoxNum = Integer.parseInt(info.getCa_WeakBoxNum());                          //弱电箱个数
////        caWaterPath = info.getCa_WaterPath();                        //上下水路径
//        caUpWaterSpot = Integer.parseInt(info.getCa_UpWaterSpot());                      //上水电
//        caDownWaterSpot = Integer.parseInt(info.getCa_DownWaterSpot());                    //下水点
//        caDownWaterSpotSize = Double.parseDouble(info.getCa_DownWaterSpotSize());                 //下水管径
//        caCurtainWallSpacing = Double.parseDouble(info.getCa_CurtainWallSpacing());                //幕墙架间距
////        caWindowType = info.getCa_WindowType();                          //窗户类型
//        caWindowSillHight = Double.parseDouble(info.getCa_windowsillHight());                    //窗台高
//        caWindowWidth = Double.parseDouble(info.getCa_WindowWidth());                          //窗户宽
//        caWindowHight = Double.parseDouble(info.getCa_WindowHight());                          //窗户高
//
//        if (caCargoDoorHight != 0.0f && caCargoDoorHight != 0) {
//            etMeasureCaCargoDoorHight.setText(caCargoDoorHight + "");
//        }
//        if (caCargoDoorWide != 0.0f && caCargoDoorWide != 0) {
//            etMeasureCaCargoDoorWide.setText(caCargoDoorWide + "");
//        }
//        if (caGroundElevation != 0.0f && caGroundElevation != 0) {
//            etMeasureCaGrondElevation.setText(caGroundElevation + "");
//        }
//        //etMeasureMinHeight.setText(caSpaceMinHeight + "");
//        if (caSpaceMaxHeight != 0.0f && caSpaceMaxHeight != 0) {
//            etNewYuandingmiangao.setText(caSpaceMaxHeight + "");
//        }
//        if (camainBeamHeight != 0.0f && camainBeamHeight != 0) {
//            etNewZhuliangxiagao.setText(camainBeamHeight + "");
//        }
//        if (caSecondaryHeight != 0.0f && caSecondaryHeight != 0) {
//            etNewCiliangxiagao.setText(caSecondaryHeight + "");
//        }
//        if (caAirConditionerNum != 0.0f && caAirConditionerNum != 0) {
//            etNewKongtiaoshebei.setText(caAirConditionerNum + "");
//        }
//        if (caTuyereMinimumHeight != 0.0f && caTuyereMinimumHeight != 0) {
//            etNewFengkouzuididian.setText(caTuyereMinimumHeight + "");
//        }
//        if (caStrongBoxNum != 0.0f && caStrongBoxNum != 0) {
//            etNewQiangdianxiang.setText(caStrongBoxNum + "");
//        }
//        if (caWeakBoxNum != 0.0f && caWeakBoxNum != 0) {
//            etNewRuodianxiang.setText(caWeakBoxNum + "");
//        }
//        if (caUpWaterSpot != 0.0f && caUpWaterSpot != 0) {
//            etNewShangshuidian.setText(caUpWaterSpot + "");
//        }
//        if (caDownWaterSpot != 0.0f && caDownWaterSpot != 0) {
//            etNewXiashuidian.setText(caDownWaterSpot + "");
//        }
//        if (caDownWaterSpotSize != 0.0f && caDownWaterSpotSize != 0) {
//            etNewXiashuidianchicun.setText(caDownWaterSpotSize + "");
//        }
//        if (caMinimumSprayHeight != 0.0f && caMinimumSprayHeight != 0) {
//            etNewPenlinzuididian.setText(caMinimumSprayHeight + "");
//        }
//        if (caWindowSillHight != 0.0f && caWindowSillHight != 0) {
//            etMeasureWindowsillHeight.setText(caWindowSillHight + "");
//        }
//        if (caWindowWidth != 0.0f && caWindowWidth != 0) {
//            etMeasureWindowsillWidth.setText(caWindowWidth + "");
//        }
//        if (caWindowHight != 0.0f && caWindowHight != 0) {
//            etMeasureWindowsHeight.setText(caWindowHight + "");
//        }
//        if (caCurtainWallSpacing != 0.0f && caCurtainWallSpacing != 0) {
//            etNewMuqiangkuangjiajianju.setText(caCurtainWallSpacing + "");
//        }
    }

    @Override
    public void responseGetNewOneError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
        showToast(upNewXinXi.getStatusMsg());
    }

    @Override
    public void responseUpNewOneError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpDanHao(UpDanHaoInfo info) {

    }

    @Override
    public void responseUpDanHaoError(String msg) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        this.position = position;
        AllImagesInfo.Album info = albumList.get(position);
        int size = info.getChildList().size();
        if (size == 0) {


            show();

        } else {


            List<AllImagesInfo.Album.image> imageList = info.getChildList();
            Intent albumIntent = new Intent(getActivity(), DesAlbumActivity.class);
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<AllImagesInfo.Album.image>) imageList);
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, clientInfo.getWorksID());
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
            albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, clientInfo.getCustomerID());
            startActivity(albumIntent);
        }

    }

    private View inflate;
    private Button choosePhoto;
    private Button takePhoto;
    private Button cancel;
    private Dialog dialog;

    public void show() {
        dialog = new Dialog(getActivity(), R.style.ActionSheetDialogStyle);
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog, null);
        choosePhoto = (Button) inflate.findViewById(R.id.choosePhoto);
        takePhoto = (Button) inflate.findViewById(R.id.takePhoto);
        cancel = (Button) inflate.findViewById(R.id.btn_cancel);
        choosePhoto.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        cancel.setOnClickListener(this);
        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        dialog.show();
    }

    int kongtiaoshebeim, qiangdianxiangm, ruodianxiangm, shangshuidianm, xiashuidianm, xiashuidianchicunm, zhuliangxiagaom, ciliangxiagaom,
            yuandingmiangaom, penlinzuididianm, fengkouzuididianm, muqiangkuangjiajianjum, ca_cargo_door_hightm, ca_cargo_door_widem,
            ca_grond_elevationm, windowsill_heightm, windowsill_widthm, windows_heightm;
    String aircoldshebei="",strongbox="",weakbox="",topwater="",downwater="",downwatersize="",zhuliang="",cilaing="",oldtophight="",
            pinlin="",windydown="",screenwall="",windowsillhight="",windowhight="",windowwidth="",huotihight="",huotiwidth="",groundcha="";
    private class MyEditListener implements TextWatcher {

        private EditText edittext;

        public MyEditListener(EditText edittext) {
            super();
            this.edittext = edittext;
        }
        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub
            int lengths = arg0.length();
            switch (edittext.getId()){
                case R.id.et_new_kongtiaoshebei:
                    editchanges(lengths, 0);
                    if(lengths>0){
                        aircoldshebei=edittext.getText().toString().trim();
                    }else{
                        aircoldshebei="";
                    }
                    activity.savedatabean.setCa_AirConditionerNum(aircoldshebei);
                    break;
                case R.id.et_new_qiangdianxiang:
                    editchanges(lengths, 1);
                    if(lengths>0){
                        strongbox=edittext.getText().toString().trim();
                    }else{
                        strongbox="";
                    }
                    activity.savedatabean.setCa_StrongBoxNum(strongbox);
                    break;
                case R.id.et_new_ruodianxiang:
                    editchanges(lengths, 2);
                    if(lengths>0){
                        weakbox=edittext.getText().toString().trim();
                    }else{
                        weakbox="";
                    }
                    activity.savedatabean.setCa_WeakBoxNum(weakbox);
                    break;
                case R.id.et_new_shangshuidian:
                    editchanges(lengths, 3);
                    if(lengths>0){
                        topwater=edittext.getText().toString().trim();
                    }else{
                        topwater="";
                    }
                    activity.savedatabean.setCa_UpWaterSpot(topwater);
                    break;
                case R.id.et_xiashuidian:
                    editchanges(lengths, 4);
                    if(lengths>0){
                        downwater=edittext.getText().toString().trim();
                    }else{
                        downwater="";
                    }
                    activity.savedatabean.setCa_DownWaterSpot(downwater);
                    break;
                case R.id.et_new_xiashuidianchicun:
                    editchanges(lengths, 5);
                    if(lengths>0){
                        downwatersize=edittext.getText().toString().trim();
                    }else{
                        downwatersize="";
                    }
                    activity.savedatabean.setCa_DownWaterSpotSize(downwatersize);
                    break;
                case R.id.et_new_zhuliangxiagao:
                    editchanges(lengths, 6);
                    if(lengths>0){
                        zhuliang=edittext.getText().toString().trim();
                    }else{
                        zhuliang="";
                    }
                    activity.savedatabean.setCa_mainBeamHeight(zhuliang);
                    break;
                case R.id.et_new_ciliangxiagao:
                    editchanges(lengths, 7);
                    if(lengths>0){
                        cilaing=edittext.getText().toString().trim();
                    }else{
                        cilaing="";
                    }
                    activity.savedatabean.setCa_SecondaryHeight(cilaing);
                    break;
                case R.id.et_new_yuandingmiangao:
                    editchanges(lengths, 8);
                    if(lengths>0){
                        oldtophight=edittext.getText().toString().trim();
                    }else{
                        oldtophight="";
                    }
                    activity.savedatabean.setCa_SpaceMaxHeight(oldtophight);
                    break;
                case R.id.et_new_penlinzuididian:
                    editchanges(lengths, 9);
                    if(lengths>0){
                        pinlin=edittext.getText().toString().trim();
                    }else{
                        pinlin="";
                    }
                    activity.savedatabean.setCa_MinimumSprayHeight(pinlin);
                    break;
                case R.id.et_new_fengkouzuididian:
                    editchanges(lengths, 10);
                    if(lengths>0){
                        windydown=edittext.getText().toString().trim();
                    }else{
                        windydown="";
                    }
                    activity.savedatabean.setCa_TuyereMinimumHeight(windydown);
                    break;
                case R.id.et_new_muqiangkuangjiajianju:
                    editchanges(lengths, 11);
                    if(lengths>0){
                        screenwall=edittext.getText().toString().trim();
                    }else{
                        screenwall="";
                    }
                    activity.savedatabean.setCa_CurtainWallSpacing(screenwall);
                    break;
                case R.id.et_measure_ca_cargo_door_hight:
                    editchanges(lengths, 12);
                    if(lengths>0){
                        huotihight=edittext.getText().toString().trim();
                    }else{
                        huotihight="";
                    }
                    activity.savedatabean.setCa_CargoDoorHight(huotihight);
                    break;
                case R.id.et_measure_ca_cargo_door_wide:
                    editchanges(lengths, 13);
                    if(lengths>0){
                        huotiwidth=edittext.getText().toString().trim();
                    }else{
                        huotiwidth="";
                    }
                    activity.savedatabean.setCa_CargoDoorWide(huotiwidth);
                    break;
                case R.id.et_measure_ca_grond_elevation:
                    editchanges(lengths, 14);
                    if(lengths>0){
                        groundcha=edittext.getText().toString().trim();
                    }else{
                        groundcha="";
                    }
                    activity.savedatabean.setCa_GroundElevation(groundcha);
                    break;
                case R.id.et_measure_windowsill_height:
                    editchanges(lengths, 15);
                    if(lengths>0){
                        windowsillhight=edittext.getText().toString().trim();
                    }else{
                        windowsillhight="";
                    }
                    activity.savedatabean.setCa_windowsillHight(windowsillhight);
                    break;
                case R.id.et_measure_windowsill_width:
                    editchanges(lengths, 16);
                    if(lengths>0){
                        windowwidth=edittext.getText().toString().trim();
                    }else{
                        windowwidth="";
                    }
                    activity.savedatabean.setCa_WindowWidth(windowwidth);
                    break;
                case R.id.et_measure_windows_height:
                    editchanges(lengths, 17);
                    if(lengths>0){
                        windowhight=edittext.getText().toString().trim();
                    }else{
                        windowhight="";
                    }
                    activity.savedatabean.setCa_WindowHight(windowhight);
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
            // TODO Auto-generated method stub
        }
    }


    /**
     * 输入框改变后金钱的变化
     */
    private void editchanges(int length, int type) {
        Log.e("length" + length, "type" + type);
        if (length > 0) {
            switch (type) {
                case 0:
                    if (kongtiaoshebeim != 1) {
                        kongtiaoshebeim = 1;
                        addMoney();
                    }
                    break;
                case 1:
                    if (qiangdianxiangm != 1) {
                        qiangdianxiangm = 1;
                        addMoney();
                    }
                    break;
                case 2:
                    if (ruodianxiangm != 1) {
                        ruodianxiangm = 1;
                        addMoney();
                    }
                    break;
                case 3:
                    if (shangshuidianm != 1) {
                        shangshuidianm = 1;
                        addMoney();
                    }
                    break;
                case 4:
                    if (xiashuidianm != 1) {
                        xiashuidianm = 1;
                        addMoney();
                    }
                    break;
                case 5:
                    if (xiashuidianchicunm != 1) {
                        xiashuidianchicunm = 1;
                        addMoney();
                    }
                    break;
                case 6:
                    if (zhuliangxiagaom != 1) {
                        zhuliangxiagaom = 1;
                        addMoney();
                    }
                    break;
                case 7:
                    if (ciliangxiagaom != 1) {
                        ciliangxiagaom = 1;
                        addMoney();
                    }
                    break;
                case 8:
                    if (yuandingmiangaom != 1) {
                        yuandingmiangaom = 1;
                        addMoney();
                    }
                    break;
                case 9:
                    if (penlinzuididianm != 1) {
                        penlinzuididianm = 1;
                        addMoney();
                    }
                    break;
                case 10:
                    if (fengkouzuididianm != 1) {
                        fengkouzuididianm = 1;
                        addMoney();
                    }
                    break;
                case 11:
                    if (muqiangkuangjiajianjum != 1) {
                        muqiangkuangjiajianjum = 1;
                        addMoney();
                    }
                    break;
                case 12:
                    if (ca_cargo_door_hightm != 1) {
                        ca_cargo_door_hightm = 1;
                        addMoney();
                    }
                    break;
                case 13:
                    if (ca_cargo_door_widem != 1) {
                        ca_cargo_door_widem = 1;
                        addMoney();
                    }
                    break;
                case 14:
                    if (ca_grond_elevationm != 1) {
                        ca_grond_elevationm = 1;
                        addMoney();
                    }
                    break;
                case 15:
                    if (windowsill_heightm != 1) {
                        windowsill_heightm = 1;
                        addMoney();
                    }
                    break;
                case 16:
                    if (windowsill_widthm != 1) {
                        windowsill_widthm = 1;
                        addMoney();
                    }
                    break;
                case 17:
                    if (windows_heightm != 1) {
                        windows_heightm = 1;
                        addMoney();
                    }
                    break;

            }
        } else {
            switch (type) {
                case 0:
                    kongtiaoshebeim = 0;
                    noaddMoney();
                    break;
                case 1:
                    qiangdianxiangm = 0;
                    noaddMoney();
                    break;
                case 2:
                    ruodianxiangm = 0;
                    noaddMoney();
                    break;
                case 3:
                    shangshuidianm = 0;
                    noaddMoney();
                    break;
                case 4:
                    xiashuidianm = 0;
                    noaddMoney();
                    break;
                case 5:
                    xiashuidianchicunm = 0;
                    noaddMoney();
                    break;
                case 6:
                    zhuliangxiagaom = 0;
                    noaddMoney();
                    break;
                case 7:
                    ciliangxiagaom = 0;
                    noaddMoney();
                    break;
                case 8:
                    yuandingmiangaom = 0;
                    noaddMoney();
                    break;
                case 9:
                    penlinzuididianm = 0;
                    noaddMoney();
                    break;
                case 10:
                    fengkouzuididianm = 0;
                    noaddMoney();
                    break;
                case 11:
                    muqiangkuangjiajianjum = 0;
                    noaddMoney();
                    break;
                case 12:
                    ca_cargo_door_hightm = 0;
                    noaddMoney();
                    break;
                case 13:
                    ca_cargo_door_widem = 0;
                    noaddMoney();
                    break;
                case 14:
                    ca_grond_elevationm = 0;
                    noaddMoney();
                    break;
                case 15:
                    windowsill_heightm = 0;
                    noaddMoney();
                    break;
                case 16:
                    windowsill_widthm = 0;
                    noaddMoney();
                    break;
                case 17:
                    windows_heightm = 0;
                    noaddMoney();
                    break;
            }
        }
    }

    //显示金额（金额=总金额/96*个数 ）
    double allmoney;
    BigDecimal bigDecimal;
    double showmoney;
    private void addMoney() {
        moneynum = moneynum + 1;
        Log.e("个数；", moneynum + "");
        Log.e("金额是+；", lhousedata.getJDMoney() + "");
        allmoney = Double.parseDouble(lhousedata.getJDMoney());
        showmoney=allmoney / LF_NUM * moneynum;
        bigDecimal=new BigDecimal(showmoney);
        showmoney=bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
        activity.setMoneynum(moneynum);
    }

    private void noaddMoney() {
        moneynum = moneynum - 1;
        Log.e("个数；", moneynum + "");
        allmoney = Double.parseDouble(lhousedata.getJDMoney());
        showmoney=allmoney / LF_NUM * moneynum;
        bigDecimal=new BigDecimal(showmoney);
        showmoney=bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        activity.money = showmoney;
        Log.e("金额；", activity.money + "");
        activity.setMoney(activity.money);
        activity.setMoneynum(moneynum);
    }


}