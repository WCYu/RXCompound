package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.adapter.DesImagesAdapter;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;
import com.rxjy.rxcompound.des.mvp.contract.GetYiLiangFangAllinfoContract;
import com.rxjy.rxcompound.des.mvp.presenter.GetYiLiangFangAllinfoPresenter;
import com.rxjy.rxcompound.widget.CustomGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class YiLiangFangActivity extends BaseActivity<GetYiLiangFangAllinfoPresenter> implements GetYiLiangFangAllinfoContract.View, AdapterView.OnItemClickListener {

    //    AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;
    AllClientNewBean.ClientNewBean clientInfo;
    @Bind(R.id.iv_back)
    ImageView iv_back;
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.tv_ci_proHead)
    TextView tvCiProHead;
    @Bind(R.id.tv_ca_DecBudgetPrice)
    TextView tvCaDecBudgetPrice;
    @Bind(R.id.tv_ca_RentFreeDate)
    TextView tvCaRentFreeDate;
    @Bind(R.id.tv_ca_Rental)
    TextView tvCaRental;
    @Bind(R.id.ca_LeaseTermStart)
    TextView caLeaseTermStart;
    @Bind(R.id.ca_LeaseTermEnd)
    TextView caLeaseTermEnd;
    @Bind(R.id.tv_ci_DecorationAddress)
    TextView tvCiDecorationAddress;
    @Bind(R.id.tv_ca_HousingType)
    TextView tvCaHousingType;
    @Bind(R.id.tv_ca_HouseOrientation)
    TextView tvCaHouseOrientation;
    @Bind(R.id.tv_ca_OccupyPublicCorridor)
    TextView tvCaOccupyPublicCorridor;
    @Bind(R.id.tv_ca_CargoDoorWide)
    TextView tvCaCargoDoorWide;
    @Bind(R.id.tv_ca_isGroundSmooth)
    TextView tvCaIsGroundSmooth;
    @Bind(R.id.tv_ca_CargoDoorHight)
    TextView tvCaCargoDoorHight;
    @Bind(R.id.tv_ca_OriginalGround)
    TextView tvCaOriginalGround;
    @Bind(R.id.tv_ca_OriginalGroundMaterial)
    TextView tvCaOriginalGroundMaterial;
    @Bind(R.id.tv_ca_GroundElevation)
    TextView tvCaGroundElevation;
    @Bind(R.id.tv_ca_OriginalWallMaterial)
    TextView tvCaOriginalWallMaterial;
    @Bind(R.id.tv_ca_SpaceMaxHeight)
    TextView tvCaSpaceMaxHeight;
    @Bind(R.id.tv_ca_SpaceMinHeight)
    TextView tvCaSpaceMinHeight;
    @Bind(R.id.tv_ca_OriginalTopMaterial)
    TextView tvCaOriginalTopMaterial;
    @Bind(R.id.tv_ca_MinimumSprayHeight)
    TextView tvCaMinimumSprayHeight;
    @Bind(R.id.tv_ca_mainBeamHeight)
    TextView tvCaMainBeamHeight;
    @Bind(R.id.tv_ca_SecondaryHeight)
    TextView tvCaSecondaryHeight;
    @Bind(R.id.tv_ca_AirConditionerNum)
    TextView tvCaAirConditionerNum;
    @Bind(R.id.tv_ca_TuyereMinimumHeight)
    TextView tvCaTuyereMinimumHeight;
    @Bind(R.id.tv_ca_UpWaterSpot)
    TextView tvCaUpWaterSpot;
    @Bind(R.id.tv_ca_DownWaterSpot)
    TextView tvCaDownWaterSpot;
    @Bind(R.id.tv_ca_DownWaterSpotSize)
    TextView tvCaDownWaterSpotSize;
    @Bind(R.id.tv_ca_WaterPath)
    TextView tvCaWaterPath;
    @Bind(R.id.tv_ca_StrongBoxNum)
    TextView tvCaStrongBoxNum;
    @Bind(R.id.tv_ca_WeakBoxNum)
    TextView tvCaWeakBoxNum;
    @Bind(R.id.tv_ca_WindowType)
    TextView tvCaWindowType;
    @Bind(R.id.tv_ca_WindowHight)
    TextView tvCaWindowHight;
    @Bind(R.id.tv_ca_WindowWidth)
    TextView tvCaWindowWidth;
    @Bind(R.id.tv_ca_windowsillHight)
    TextView tvCaWindowsillHight;
    @Bind(R.id.tv_ca_CurtainWallSpacing)
    TextView tvCaCurtainWallSpacing;
//    @Bind(R.id.gv_measure_photo)
//    CustomGridView gvMeasurePhoto;
//    private DesImagesAdapter mAdapter;
//    private List<AllImagesInfo.Album> albumList;

    @Bind(R.id.tv_ca_IntentionalStyle)
    TextView tvCaIntentionalStyle;
    @Bind(R.id.tv_ca_fenshui_requirements)
    TextView tvCaFenshuiRequirements;
    @Bind(R.id.tv_ca_soft_furniture)
    TextView tvCaSoftFurniture;
    @Bind(R.id.tv_ca_intelligent_weak_current)
    TextView tvCaIntelligentWeakCurrent;


    @Bind(R.id.tv_ca_req_con_time)
    TextView tvCaReqConTime;
    @Bind(R.id.tv_ca_product_protection)
    TextView tvCaProductProtection;
    @Bind(R.id.tv_ca_protective_material)
    TextView tvCaProtectiveMaterial;
    @Bind(R.id.tv_ca_property_insurance)
    TextView tvCaPropertyInsurance;
    @Bind(R.id.tv_ca_designated_fire_company)
    TextView tvCaDesignatedFireCompany;
    @Bind(R.id.tv_ca_designated_air_company)
    TextView tvCaDesignatedAirCompany;
    @Bind(R.id.tv_ca_designated_sinotrans)
    TextView tvCaDesignatedSinotrans;
    @Bind(R.id.tv_ca_blueprint)
    TextView tvCaBlueprint;

    @Bind(R.id.gv_des_yi_surroundings_photo)
    CustomGridView gvDesYiSurroundingsPhoto;

    private List<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean> albumList2;

    private DesImagesAdapter mAdapter2;


    private String TITLE = "已量房";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_yi_liang_fang);
        onclick();
    }

    private void onclick() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.GetYiLiangFangAllinfo(clientInfo.getCi_RwdId());

        //mPresenter.GetYiLiangFangAllinfo("15-124533");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_yi_liang_fang;
    }

    @Override
    public void initData() {
        initTitle();
//        clientInfo = (AllClientInfo.ClientTypeInfo.ClientInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        clientInfo = (AllClientNewBean.ClientNewBean) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);

        //albumList = new ArrayList<>();
        //mAdapter = new DesImagesAdapter(this, albumList);
        //gvMeasurePhoto.setAdapter(mAdapter);
        //gvMeasurePhoto.setOnItemClickListener(this);

        albumList2 = new ArrayList<>();

        mAdapter2 = new DesImagesAdapter(this, albumList2);

        gvDesYiSurroundingsPhoto.setAdapter(mAdapter2);

        gvDesYiSurroundingsPhoto.setOnItemClickListener(this);


    }

    private void initTitle() {
        tv_title.setText(TITLE);
    }

    @Override
    protected GetYiLiangFangAllinfoPresenter onCreatePresenter() {
        return new GetYiLiangFangAllinfoPresenter(this);
    }

    @Override
    public void responseMeasureData(GetYiLiangFangAllInfo info) {
        tvCiProHead.setText(info.getBody().getWenZiXiangQing().getCi_proHead() + "");
        tvCaDecBudgetPrice.setText(info.getBody().getWenZiXiangQing().getCa_DecBudgetPrice() + "w");
        tvCaRental.setText(info.getBody().getWenZiXiangQing().getCa_Rental() + "元/平");
        caLeaseTermStart.setText(info.getBody().getWenZiXiangQing().getCa_LeaseTermStart().split(" ")[0]);
        caLeaseTermEnd.setText(info.getBody().getWenZiXiangQing().getCa_LeaseTermEnd().substring(0, 10));
        tvCiDecorationAddress.setText(info.getBody().getWenZiXiangQing().getCi_DecorationAddress() + "");
        tvCaHouseOrientation.setText(info.getBody().getWenZiXiangQing().getCa_HouseOrientation() + "");
        tvCaCargoDoorWide.setText(info.getBody().getWenZiXiangQing().getCa_CargoDoorWide() + " mm");
        tvCaIsGroundSmooth.setText(info.getBody().getWenZiXiangQing().getCa_isGroundSmooth() + "");
        tvCaCargoDoorHight.setText(info.getBody().getWenZiXiangQing().getCa_CargoDoorHight() + " mm");
        tvCaOriginalGroundMaterial.setText(info.getBody().getWenZiXiangQing().getCa_OriginalGroundMaterial() + "");
        tvCaGroundElevation.setText(info.getBody().getWenZiXiangQing().getCa_GroundElevation() + " mm");
        tvCaOriginalWallMaterial.setText(info.getBody().getWenZiXiangQing().getCa_OriginalWallMaterial() + "");
        tvCaSpaceMaxHeight.setText(info.getBody().getWenZiXiangQing().getCa_SpaceMaxHeight() + " mm");
        tvCaSpaceMinHeight.setText(info.getBody().getWenZiXiangQing().getCa_SpaceMinHeight() + " mm");
        tvCaOriginalTopMaterial.setText(info.getBody().getWenZiXiangQing().getCa_OriginalTopMaterial() + "");
        tvCaMinimumSprayHeight.setText(info.getBody().getWenZiXiangQing().getCa_MinimumSprayHeight() + " mm");
        tvCaMainBeamHeight.setText(info.getBody().getWenZiXiangQing().getCa_mainBeamHeight() + " mm");
        tvCaSecondaryHeight.setText(info.getBody().getWenZiXiangQing().getCa_SecondaryHeight() + " mm");
        tvCaAirConditionerNum.setText(info.getBody().getWenZiXiangQing().getCa_AirConditionerNum() + "个");
        tvCaTuyereMinimumHeight.setText(info.getBody().getWenZiXiangQing().getCa_TuyereMinimumHeight() + " mm");
        tvCaUpWaterSpot.setText(info.getBody().getWenZiXiangQing().getCa_UpWaterSpot() + "个");
        tvCaDownWaterSpot.setText(info.getBody().getWenZiXiangQing().getCa_DownWaterSpot() + "个");
        tvCaDownWaterSpotSize.setText(info.getBody().getWenZiXiangQing().getCa_DownWaterSpotSize() + " mm");
        tvCaWaterPath.setText(info.getBody().getWenZiXiangQing().getCa_WaterPath() + "");
        tvCaStrongBoxNum.setText(info.getBody().getWenZiXiangQing().getCa_StrongBoxNum() + "个");
        tvCaWeakBoxNum.setText(info.getBody().getWenZiXiangQing().getCa_WeakBoxNum() + "个");
        tvCaWindowType.setText(info.getBody().getWenZiXiangQing().getCa_WindowType() + "");
        tvCaWindowHight.setText(info.getBody().getWenZiXiangQing().getCa_WindowHight() + " mm");
        tvCaWindowWidth.setText(info.getBody().getWenZiXiangQing().getCa_WindowWidth() + " mm");
        tvCaWindowsillHight.setText(info.getBody().getWenZiXiangQing().getCa_windowsillHight() + " mm");
        tvCaCurtainWallSpacing.setText(info.getBody().getWenZiXiangQing().getCa_CurtainWallSpacing() + " mm");

        if (info.getBody().getWenZiXiangQing().getCa_RentFreeDate() == 1)
            tvCaRentFreeDate.setText("1个月内");
        else if (info.getBody().getWenZiXiangQing().getCa_RentFreeDate() == 2)
            tvCaRentFreeDate.setText("1-2个月");
        else if (info.getBody().getWenZiXiangQing().getCa_RentFreeDate() == 3)
            tvCaRentFreeDate.setText("2个月以上");
        else if (info.getBody().getWenZiXiangQing().getCa_RentFreeDate() == 4)
            tvCaRentFreeDate.setText("无");
        else
            tvCaRentFreeDate.setText("");

        if (info.getBody().getWenZiXiangQing().getCa_HousingType() == 1)
            tvCaHousingType.setText("毛坯");
        else if (info.getBody().getWenZiXiangQing().getCa_HousingType() == 2)
            tvCaHousingType.setText("清水");
        else if (info.getBody().getWenZiXiangQing().getCa_HousingType() == 3)
            tvCaHousingType.setText("旧房改造");
        else if (info.getBody().getWenZiXiangQing().getCa_HousingType() == 4)
            tvCaHousingType.setText("翻新");
        else if (info.getBody().getWenZiXiangQing().getCa_HousingType() == 5)
            tvCaHousingType.setText("精装");
        else
            tvCaHousingType.setText("");

        if (info.getBody().getWenZiXiangQing().getCa_OccupyPublicCorridor() == 1)
            tvCaOccupyPublicCorridor.setText("是");
        else if (info.getBody().getWenZiXiangQing().getCa_OccupyPublicCorridor() == 2)
            tvCaOccupyPublicCorridor.setText("否");
        else
            tvCaOccupyPublicCorridor.setText("");

        if (info.getBody().getWenZiXiangQing().getCa_OriginalGround().equals("1"))
            tvCaOriginalGround.setText("是");
        else if (info.getBody().getWenZiXiangQing().getCa_OriginalGround().equals("2"))
            tvCaOriginalGround.setText("否");
        else
            tvCaOriginalGround.setText("");


        albumList2.clear();
        albumList2.addAll(info.getBody().getHuanJingZhaoPian());
        mAdapter2.notifyDataSetChanged();


        tvCaIntentionalStyle.setText(info.getBody().getKeHuXuQiu().getCa_IntentionalStyle() + "");

        if (info.getBody().getKeHuXuQiu().getCa_FengShuiRequirements() == 1)
            tvCaFenshuiRequirements.setText("有");
        else if (info.getBody().getKeHuXuQiu().getCa_FengShuiRequirements() == 2)
            tvCaFenshuiRequirements.setText("无");
        else
            tvCaFenshuiRequirements.setText("");

        if (info.getBody().getKeHuXuQiu().getCa_SoftFurniture() == 1)
            tvCaSoftFurniture.setText("是");
        else if (info.getBody().getKeHuXuQiu().getCa_SoftFurniture() == 2)
            tvCaSoftFurniture.setText("否");
        else
            tvCaSoftFurniture.setText("");

        if (info.getBody().getKeHuXuQiu().getCa_IntelligentWeakCurrent() == 1)
            tvCaIntelligentWeakCurrent.setText("是");
        else if (info.getBody().getKeHuXuQiu().getCa_IntelligentWeakCurrent() == 2)
            tvCaIntelligentWeakCurrent.setText("否");
        else
            tvCaIntelligentWeakCurrent.setText("");

        tvCaReqConTime.setText(info.getBody().getLiangFangWuYe().getCa_ReqConTime());
        tvCaProductProtection.setText(info.getBody().getLiangFangWuYe().getCa_ProductProtection());
        tvCaProtectiveMaterial.setText(info.getBody().getLiangFangWuYe().getCa_ProtectiveMaterial());
        tvCaPropertyInsurance.setText(info.getBody().getLiangFangWuYe().getCa_PropertyInsurance());
        if (info.getBody().getLiangFangWuYe().getCa_DesignatedFireCompany() == 1)
            tvCaDesignatedFireCompany.setText("是");
        else if (info.getBody().getLiangFangWuYe().getCa_DesignatedFireCompany() == 2)
            tvCaDesignatedFireCompany.setText("否");
        else
            tvCaDesignatedFireCompany.setText("");
        if (info.getBody().getLiangFangWuYe().getCa_DesignatedAirCompany() == 1)
            tvCaDesignatedAirCompany.setText("是");
        else if (info.getBody().getLiangFangWuYe().getCa_DesignatedAirCompany() == 2)
            tvCaDesignatedAirCompany.setText("否");
        else
            tvCaDesignatedAirCompany.setText("");
        if (info.getBody().getLiangFangWuYe().getCa_DesignatedSinotrans() == 1)
            tvCaDesignatedSinotrans.setText("是");
        else if (info.getBody().getLiangFangWuYe().getCa_DesignatedSinotrans() == 2)
            tvCaDesignatedSinotrans.setText("否");
        else
            tvCaDesignatedSinotrans.setText("");
        tvCaBlueprint.setText(info.getBody().getLiangFangWuYe().getCa_Blueprint());


    }

    @Override
    public void responseMeasureError(String error) {
        showToast(error);
    }

    @Override
    public void responseAllImagesData(List<AllImagesInfo.Album> list) {
//        albumList2.clear();
//        albumList2.addAll(list);
//        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseAllImagesError(String error) {
//        showToast(error);
    }

    @Override
    public void reLogin(String msg) {

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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean info = albumList2.get(position);

        List<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image> imageList = info.getChildList();
        Log.e("yiliangfang", imageList.size() + "");
        Intent albumIntent = new Intent(YiLiangFangActivity.this, DesAlbum2Activity.class);

        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image>) imageList);
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, clientInfo.getWorksID());
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, clientInfo.getCustomerID());

        startActivity(albumIntent);
    }

}
