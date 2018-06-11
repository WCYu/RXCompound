package com.rxjy.rxcompound.des.activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;
import com.rxjy.rxcompound.des.entity.IconInfo;
import com.rxjy.rxcompound.des.fragment.DesDaiSurroundingsFragment;
import com.rxjy.rxcompound.des.fragment.NewEightFragment;
import com.rxjy.rxcompound.des.fragment.NewFiveFragment;
import com.rxjy.rxcompound.des.fragment.NewFourFragment;
import com.rxjy.rxcompound.des.fragment.NewOneFragment;
import com.rxjy.rxcompound.des.fragment.NewSevenFragment;
import com.rxjy.rxcompound.des.fragment.NewSixFragment;
import com.rxjy.rxcompound.des.fragment.NewThreeFragment;
import com.rxjy.rxcompound.des.fragment.NewTwoFragment;
import com.rxjy.rxcompound.des.fragment.NineFragment;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiMeasureAContract;
import com.rxjy.rxcompound.des.mvp.presenter.DesDaiMeasureAPresenter;
import com.rxjy.rxcompound.des.photo.MyCameraActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesDaiMeasureActivity extends BaseActivity<DesDaiMeasureAPresenter> implements DesDaiMeasureAContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.fl_des_dai_main)
    FrameLayout flDesDaiMain;

    //    @Bind(R.id.iv_tab_home)
//    ImageView ivMeasure;
//    @Bind(R.id.tv_tab_home)
//    TextView tvMeasure;
//    @Bind(R.id.rl_tab_home)
//    RelativeLayout rlMeasure;
//    @Bind(R.id.iv_tab_more)
//    ImageView ivSurrounding;
//    @Bind(R.id.tv_tab_more)
//    TextView tvSurrounding;
//    @Bind(R.id.rl_tab_more)
//    RelativeLayout rlSurrounding;
//    @Bind(R.id.iv_tab_find)
//    ImageView ivDemand;
//    @Bind(R.id.tv_tab_find)
//    TextView tvDemand;
//    @Bind(R.id.rl_tab_find)
//    RelativeLayout rlDemand;
//    @Bind(R.id.iv_tab_mine)
//    ImageView ivUpkeep;
//    @Bind(R.id.tv_tab_mine)
//    TextView tvUpkeep;
//    @Bind(R.id.rl_tab_mine)
//    RelativeLayout rlUpkeep;
    @Bind(R.id.liangfang_zhaoxiang)
    ImageView iv_zhaoxiang;

    @Bind(R.id.iv_add)
    TextView ivAdd;

    @Bind(R.id.tv_tab_liangfangxinxi)
    TextView tvTabLiangfangxinxi;
    @Bind(R.id.tv_tab_liangfangxinxi_line)
    TextView tvTabLiangfangxinxiLine;
    @Bind(R.id.ll_tab_liangfangxinxi)
    LinearLayout llTabLiangfangxinxi;
    @Bind(R.id.tv_tab_liangfangzhaopian)
    TextView tvTabLiangfangzhaopian;
    @Bind(R.id.tv_tab_liangfangzhaopian_line)
    TextView tvTabLiangfangzhaopianLine;
    @Bind(R.id.ll_tab_liangfangzhaopian)
    LinearLayout llTabLiangfangzhaopian;
    @Bind(R.id.tv_tab_zhuangxiuxuqiu)
    TextView tvTabZhuangxiuxuqiu;
    @Bind(R.id.tv_tab_zhuangxiuxuqiu_line)
    TextView tvTabZhuangxiuxuqiuLine;
    @Bind(R.id.ll_tab_zhuangxiuxuqiu)
    LinearLayout llTabZhuangxiuxuqiu;
    @Bind(R.id.tv_tab_wuyexinxi)
    TextView tvTabWuyexinxi;
    @Bind(R.id.tv_tab_wuyexinxi_line)
    TextView tvTabWuyexinxiLine;
    @Bind(R.id.ll_tab_wuyexinxi)
    LinearLayout llTabWuyexinxi;
    @Bind(R.id.tv_tab_jibenxinxi)
    TextView tvTabJibenxinxi;
    @Bind(R.id.tv_tab_jibenxinxi_line)
    TextView tvTabJibenxinxiLine;
    @Bind(R.id.ll_tab_jibenxinxi)
    LinearLayout llTabJibenxinxi;
    @Bind(R.id.tv_tab_fangyuanxinxi)
    TextView tvTabFangyuanxinxi;
    @Bind(R.id.tv_tab_fangyuanxinxi_line)
    TextView tvTabFangyuanxinxiLine;
    @Bind(R.id.ll_tab_fangyuanxinxi)
    LinearLayout llTabFangyuanxinxi;
    @Bind(R.id.tv_tab_loupanxinxi)
    TextView tvTabLoupanxinxi;
    @Bind(R.id.tv_tab_loupanxinxi_line)
    TextView tvTabLoupanxinxiLine;
    @Bind(R.id.ll_tab_loupanxinxi)
    LinearLayout llTabLoupanxinxi;
    @Bind(R.id.tv_tab_kehuxinxi)
    TextView tvTabKehuxinxi;
    @Bind(R.id.tv_tab_kehuxinxi_line)
    TextView tvTabKehuxinxiLine;
    @Bind(R.id.ll_tab_kehuxinxi)
    LinearLayout llTabKehuxinxi;
    @Bind(R.id.tv_tab_qiyexinxi)
    TextView tvTabQiyexinxi;
    @Bind(R.id.tv_tab_qiyexinxi_line)
    TextView tvTabQiyexinxiLine;
    @Bind(R.id.ll_tab_qiyexinxi)
    LinearLayout llTabQiyexinxi;
    @Bind(R.id.tv_tab_qiyehuanjing)
    TextView tvTabQiyehuanjing;
    @Bind(R.id.tv_tab_qiyehuanjing_line)
    TextView tvTabQiyehuanjingLine;
    @Bind(R.id.ll_tab_qiyehuanjing)
    LinearLayout llTabQiyehuanjing;
    private Fragment currentFragment;

    @Bind(R.id.tv_moneyget)
    TextView tv_moneyget;
    @Bind(R.id.btn_des_dai_measure_sub)
    TextView btn_des_dai_measure_sub;

    private int[] iconNormal = new int[]{
            R.mipmap.measureroom,
            R.mipmap.surroundings,
            R.mipmap.demand,
            R.mipmap.upkeep
    };

    private int[] iconPressed = new int[]{
            R.mipmap.measureroom_active,
            R.mipmap.surroundings_active,
            R.mipmap.demand_active,
            R.mipmap.upkeep_active
    };

//    private int[] titleArr = {
//            "量房",
//            "环境",
//            "需求",
//            "物业"
//    };

    //指定Fragment的坐标
    private final int ONE_FRAGMENT = 0;
    private final int TWO_FRAGMENT = 1;
    private final int THREE_FRAGMENT = 2;
    private final int FOUR_FRAGMENT = 3;
    private final int FIVE_FRAGMENT = 4;
    private final int SIX_FRAGMENT = 5;
    private final int SEVEN_FRAGMENT = 6;
    private final int EIGHT_FRAGMENT = 7;
    private final int NINE_FRAGMENT = 8;
    private final int TEN_FRAGMENT = 9;
    //Tab图标的集合
    private List<IconInfo> iconList;

    //碎片的集合
    private List<Fragment> fragmentList;

    //new
    private NewOneFragment newOneFragment;
    private NewTwoFragment newTwoFragment;
    private NewThreeFragment newThreeFragment;
    private NewFourFragment newFourFragment;
    private NewFiveFragment newFiveFragment;
    private NewSixFragment newSixFragment;

    /**
     * todo
     *
     */
    private NewSevenFragment newSevenFragment;
    private NewEightFragment newEightFragment;
    private NineFragment newNineFragment;
    private DesDaiSurroundingsFragment surroundingsFragment;



    //    private DesDaiMeasureFragment measureFragment;

//    private DesDaiDemandFragment demandFragment;
//    private DesDaiUpkeepFragment upkeepFragment;

    //客户信息
//    private AllClientInfo.ClientTypeInfo.ClientInfo info;
    private AllClientNewBean.ClientNewBean info;

    @Override
    public int getLayout() {
        return R.layout.activity_des_dai_measure;
    }

    @Override
    public void initData() {
        Constants.HOUSE_MONEY = 0;
        initIntentData();
        initTitle();
        initIcon();
        initFragment();
        //加载默认显示碎片
        showFragment(fragmentList.get(ONE_FRAGMENT), ONE_FRAGMENT);
        setClientInfoToFragment();
        onclick();
//        mPresenter.getLHouseData(info.getCi_rwdid());
        mPresenter.getLHouseData(info.getCi_RwdId());
    }

    @Override
    protected DesDaiMeasureAPresenter onCreatePresenter() {
        return new DesDaiMeasureAPresenter(this);
    }


    public DesDaiMeasureABean.BodyBean savedatabean;

    public void setSavedatabean(DesDaiMeasureABean.BodyBean savedatabean) {
        this.savedatabean = savedatabean;
    }

    private void onclick() {
        iv_zhaoxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DesDaiMeasureActivity.this, MyCameraActivity.class);
                intent.putExtra("MYCAMERAPOS", 0);
                intent.putExtra("PAIZHAOBIAOSHI", 0);
                intent.putExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO, info);
                startActivity(intent);
            }
        });

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//提交
//                mPresenter.UpDanHao(info.getCi_rwdid());
            }
        });

        //保存
        btn_des_dai_measure_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedatabean.setImagesArray(null);
                String saveinfo = JSONUtils.toString(savedatabean);
//                Log.e("money", money + "");
//                Log.e("moneynum", moneynum + "");
//                Log.e("要提交了。。。提交的数据是：：", saveinfo);
//                mPresenter.saveLHouseData(info.getCi_rwdid(), saveinfo, money + "", moneynum + "");
                mPresenter.saveLHouseData(info.getCi_RwdId(), saveinfo, money + "", moneynum + "");
            }
        });
    }

    public double money;
    public int moneynum;

    public void setMoney(double moneys) {
        tv_moneyget.setText("￥" + moneys);
        money=moneys;
    }

    public void setMoneynum(int mun) {
        moneynum = mun;
    }


//    {JDMoney=70.00, LFMondey=0.00, ImagesArray=ImageArrBean{LFImages=[ImageBean{CreatorID=0, WorksID=0, CatalogID=53, CatalogIDName='特殊结构', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=109, CatalogIDName='大厦外立面', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=123, CatalogIDName='量房手绘', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=124, CatalogIDName='周边环境', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=125, CatalogIDName='室内全景照片', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=129, CatalogIDName='门窗', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=130, CatalogIDName='空调', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=131, CatalogIDName='消防', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=132, CatalogIDName='强电箱', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=133, CatalogIDName='弱电箱', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=134, CatalogIDName='上下水', CatalogShowType='', CatalogCount=0, childList=[]}], QYImages=[ImageBean{CreatorID=0, WorksID=0, CatalogID=116, CatalogIDName='公司logo', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=120, CatalogIDName='企业色彩', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=121, CatalogIDName='企业环境', CatalogShowType='', CatalogCount=0, childList=[]}, ImageBean{CreatorID=0, WorksID=0, CatalogID=122, CatalogIDName='客户形象', CatalogShowType='', CatalogCount=0, childList=[]}]}, ci_ClientName='茜茜餐饮', ci_Type='4', ca_SWIndustryTypeID='null', ca_HangYeLeIXing='', ci_OfficeAddress='', ca_LeaseTermStart='2017-12-21', ca_LeaseTermEnd='2017-12-22', ca_EnterpriseNature='私企', ca_EnterprisesScale='30人以下', ca_EstablishmentTime='2017-10-12', ca_ForeignEnterprises='', ca_BusinessScope='', ca_CorporateCulture='', ci_proHead='李茜茜', ca_proHeadIdentity='7', ci_proSex='1', ci_proAge='2', ca_NoteFocus='施工人员', ca_ContractPerson='1', ca_proHeadCharacter='温和', ca_SpaceRequirement='', ca_proAttribute='1', ca_DecBudgetPrice='10.00', ca_ProjectTime='', ca_InviteTenders='否', ca_DecorationDate='2017-12-26', ci_DecorationAddress='11', ca_IntentionalStyle='', ca_FengShuiRequirements='', ca_SoftFurniture='', ca_IntelligentWeakCurrent='', ca_proLike='null', ca_zaRemarks='null', ca_HouseOrientation='', ca_OccupyPublicCorridor='', ca_CargoDoorWide='0', ca_CargoDoorHight='0', ca_OriginalGroundMaterial='', ca_isGroundSmooth='', ca_GroundElevation='0', ca_OriginalTopMaterial='', ca_OriginalWallMaterial='', ca_mainBeamHeight='0', ca_SecondaryHeight='0', ca_SpaceMinHeight='null', ca_SpaceMaxHeight='0', ca_StrongBoxNum='0', ca_WeakBoxNum='0', ca_UpWaterSpot='0', ca_DownWaterSpot='0', ca_DownWaterSpotSize='0', ca_MinimumSprayHeight='0', ca_AirConditionerNum='0', ca_TuyereMinimumHeight='0', ca_WindowType='', ca_windowsillHight='0', ca_WindowHight='0', ca_WindowWidth='0', ca_WaterPath='', ca_CurtainWallSpacing='0', ca_OriginalGround='', ca_ReqConTime='', ca_ProductProtection='', ca_PropertyInsurance='', ca_DesignatedFireCompany='', ca_DesignatedAirCompany='', ca_DesignatedSinotrans='', ca_Blueprint='', ca_ProtectiveMaterial='', ca_SpecialRequirement='', ca_Elevator='', ca_LeadName='', ca_TwoManagerTel='', ca_Maintenance='', ca_Aptitude='', ca_DrawAudit='', ca_HousingType='1', ca_AvailabilityStatus='1', ci_Area='10.00', ca_TransactionType='2', ca_RentFreeDate='2', ca_LaunchTime='2017-12-26', ca_MeasureDate='2017-10-28', ca_RealEstate='12', ca_RealEstatePeriod='12', ca_DevelopmentFloor='12


    private void initIntentData() {
//        info = (AllClientInfo.ClientTypeInfo.ClientInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        info = (AllClientNewBean.ClientNewBean) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
    }

    private void setClientInfoToFragment() {
        newOneFragment.setClientInfo(info);
        newTwoFragment.setClientInfo(info);
        newThreeFragment.setClientInfo(info);
        newFourFragment.setClientInfo(info);
        newFiveFragment.setClientInfo(info);
        newSixFragment.setClientInfo(info);
        /**
         * todo
         *
         */
        newSevenFragment.setClientInfo(info);
        newEightFragment.setClientInfo(info);
        newNineFragment.setClientInfo(info);


        //        measureFragment.setClientInfo(info);
        surroundingsFragment.setClientInfo(info);

//        demandFragment.setClientInfo(info);
//        upkeepFragment.setClientInfo(info);
    }

    private void initTitle() {
        //初始化标题
        tvTitle.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("量房");
    }

    private void initFragment() {
        if (newOneFragment == null) {
            newOneFragment = new NewOneFragment();
        }
        if (newTwoFragment == null) {
            newTwoFragment = new NewTwoFragment();
        }
        if (newThreeFragment == null) {
            newThreeFragment = new NewThreeFragment();
        }
        if (newFourFragment == null) {
            newFourFragment = new NewFourFragment();
        }
        if (newFiveFragment == null) {
            newFiveFragment = new NewFiveFragment();
        }
        if (newSixFragment == null) {
            newSixFragment = new NewSixFragment();
        }


        /**
         * todo
         *
         */
        if (newSevenFragment == null) {
            newSevenFragment = new NewSevenFragment();
        }
        if (newEightFragment == null) {
            newEightFragment = new NewEightFragment();
        }
        if (newNineFragment == null) {
            newNineFragment = new NineFragment();
        }

        //        if (measureFragment == null)
        //            measureFragment = new DesDaiMeasureFragment();
        if (surroundingsFragment == null)
            surroundingsFragment = new DesDaiSurroundingsFragment();

//        if (demandFragment == null)
//            demandFragment = new DesDaiDemandFragment();
//        if (upkeepFragment == null)
//            upkeepFragment = new DesDaiUpkeepFragment();
        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        //将碎片添加到集合中

        //new
        fragmentList.add(newOneFragment);
        fragmentList.add(newTwoFragment);
        fragmentList.add(newThreeFragment);
        fragmentList.add(newFourFragment);
        fragmentList.add(newFiveFragment);
        fragmentList.add(newSixFragment);
        /**
         * todo
         *
         */
        fragmentList.add(newSevenFragment);
        fragmentList.add(newEightFragment);
        fragmentList.add(newNineFragment);

        // fragmentList.add(measureFragment);
        fragmentList.add(surroundingsFragment);

//        fragmentList.add(demandFragment);
//        fragmentList.add(upkeepFragment);


    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(tvTabLiangfangxinxi, tvTabLiangfangxinxiLine));
        iconList.add(new IconInfo(tvTabLiangfangzhaopian, tvTabLiangfangzhaopianLine));
        iconList.add(new IconInfo(tvTabZhuangxiuxuqiu, tvTabZhuangxiuxuqiuLine));
        iconList.add(new IconInfo(tvTabWuyexinxi, tvTabWuyexinxiLine));
        iconList.add(new IconInfo(tvTabJibenxinxi, tvTabJibenxinxiLine));
        iconList.add(new IconInfo(tvTabFangyuanxinxi, tvTabFangyuanxinxiLine));
        iconList.add(new IconInfo(tvTabLoupanxinxi, tvTabLoupanxinxiLine));
        iconList.add(new IconInfo(tvTabKehuxinxi, tvTabKehuxinxiLine));
        iconList.add(new IconInfo(tvTabQiyexinxi, tvTabQiyexinxiLine));
        iconList.add(new IconInfo(tvTabQiyehuanjing, tvTabQiyehuanjingLine));
    }

//    @Override
//    protected NewOnePresenter onCreatePresenter() {
//        return new NewOnePresenter(this);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.ll_tab_liangfangxinxi, R.id.ll_tab_liangfangzhaopian, R.id.ll_tab_zhuangxiuxuqiu, R.id.ll_tab_wuyexinxi, R.id.ll_tab_jibenxinxi, R.id.ll_tab_fangyuanxinxi, R.id.ll_tab_loupanxinxi, R.id.ll_tab_kehuxinxi, R.id.ll_tab_qiyexinxi, R.id.ll_tab_qiyehuanjing})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back://返回是弹出是否保存的提示框
                ShowDialog();
//                finish();
                break;
            case R.id.ll_tab_liangfangxinxi:
                showFragment(fragmentList.get(ONE_FRAGMENT), ONE_FRAGMENT);
                break;
            case R.id.ll_tab_liangfangzhaopian:
                showFragment(fragmentList.get(TWO_FRAGMENT), TWO_FRAGMENT);
                break;
            case R.id.ll_tab_zhuangxiuxuqiu:
                showFragment(fragmentList.get(THREE_FRAGMENT), THREE_FRAGMENT);
                break;
            case R.id.ll_tab_wuyexinxi:
                showFragment(fragmentList.get(FOUR_FRAGMENT), FOUR_FRAGMENT);
                break;
            case R.id.ll_tab_jibenxinxi:
                showFragment(fragmentList.get(FIVE_FRAGMENT), FIVE_FRAGMENT);
                break;
            case R.id.ll_tab_fangyuanxinxi:
                showFragment(fragmentList.get(SIX_FRAGMENT), SIX_FRAGMENT);
                break;
            case R.id.ll_tab_loupanxinxi:
                showFragment(fragmentList.get(SEVEN_FRAGMENT), SEVEN_FRAGMENT);
                break;
            case R.id.ll_tab_kehuxinxi:
                showFragment(fragmentList.get(EIGHT_FRAGMENT), EIGHT_FRAGMENT);
                break;
            case R.id.ll_tab_qiyexinxi:
                showFragment(fragmentList.get(NINE_FRAGMENT), NINE_FRAGMENT);
                break;
            case R.id.ll_tab_qiyehuanjing:
                showFragment(fragmentList.get(TEN_FRAGMENT), TEN_FRAGMENT);
                break;
        }
    }


    /**
     * 提示保存的弹出框
     */
    Dialog dialog;
    View v;
    private TextView tv_cancle,tv_sure;
    private void ShowDialog(){
        dialog=new Dialog(this,R.style.ActionSheetDialogStyle);
        v = LayoutInflater.from(this).inflate(R.layout.dialog_lfsavetip, null);
        dialog.setContentView(v);
        Window dialogwindow = dialog.getWindow();
        dialogwindow.setGravity(Gravity.CENTER);
        WindowManager windowManager=getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogwindow.getAttributes();
        lp.height = ActionBar.LayoutParams.WRAP_CONTENT;
        lp.width = (int) (display.getWidth() * 0.7);
        dialogwindow.setAttributes(lp);
        dialog.show();
        tv_cancle= (TextView) v.findViewById(R.id.tv_cancle);
        tv_sure= (TextView) v.findViewById(R.id.tv_sure);
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */
    private void showFragment(Fragment fragment, int position) {
        JumpFragment(fragment);
        setIcon(position);
        //加载显示的标题
        //tvTitle.setText(titleArr[position]);
    }

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_des_dai_main, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
    }

    /**
     * 设置图标点击效果
     *
     * @param position
     */
    private void setIcon(int position) {
        for (int i = 0; i < iconList.size(); i++) {
            //iconList.get(i).getImageView().setImageResource(iconNormal[i]);
            //iconList.get(i).getTextView().setText(titleArr[i]);
//            iconList.get(i).getTextView().setTextColor(this.getResources().getColor(R.color.cor666));
            iconList.get(i).getTextView2().setVisibility(View.INVISIBLE);
        }
        //iconList.get(position).getImageView().setImageResource(iconPressed[position]);
//        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.cor0068b7));
        iconList.get(position).getTextView2().setVisibility(View.VISIBLE);
    }

//    @Override
//    public void responseGetNewOne(NewOneInfo.BodyBean info) {
//
//    }
//
//    @Override
//    public void responseGetNewOneError(String msg) {
//
//    }
//
//    @Override
//    public void responseUpNewOne(UpNewXinXi upNewXinXi) {
//
//    }
//
//    @Override
//    public void responseUpNewOneError(String msg) {
//
//    }
//
//    @Override
//    public void responseUpDanHao(UpDanHaoInfo info) {
//
//        if(info.getStatusCode()==0){
//            showToast("上传成功");
//        }
//
//
//    }
//
//    @Override
//    public void responseUpDanHaoError(String msg) {
//                  showToast(msg);
//    }

    /**
     * 获取到所以的量房信息并赋给fragment
     */
    public int lfphotonum,qyphotonum;
    public double getmaxmoney;
    @Override
    public void responseLHouseData(DesDaiMeasureABean.BodyBean bodyBean) {
        savedatabean = bodyBean;
        moneynum = bodyBean.getValCount();//获取到个数用于计算
        Log.e("个数。。。", moneynum + "");
        getmaxmoney= Double.parseDouble(bodyBean.getJDMoney());
        money= Double.parseDouble(bodyBean.getLFMondey());
        tv_moneyget.setText("￥" + bodyBean.getLFMondey());
        newOneFragment.setLHouseData(bodyBean);
//        newTwoFragment.setLHouseData(bodyBean.getImagesArray());
        newThreeFragment.setLHouseData(bodyBean);
        newFourFragment.setLHouseData(bodyBean);
        newFiveFragment.setLHouseData(bodyBean);
        newSixFragment.setLHouseData(bodyBean);
        /**
         * todo
         *
         */
        newSevenFragment.setLHouseData(bodyBean);
        newEightFragment.setLHouseData(bodyBean);
        newNineFragment.setLHouseData(bodyBean);

//        surroundingsFragment.setLHouseData(bodyBean.getImagesArray());
        if( bodyBean.getImagesArray().getLFImages()!=null&& bodyBean.getImagesArray().getLFImages().size()>0){
            for (int i = 0; i < bodyBean.getImagesArray().getLFImages().size(); i++) {
                if(bodyBean.getImagesArray().getLFImages().get(i).getChildList().size()>0){
                    lfphotonum=lfphotonum+1;
                }
            }
        }

        if( bodyBean.getImagesArray().getQYImages()!=null&& bodyBean.getImagesArray().getQYImages().size()>0){
            for (int i = 0; i < bodyBean.getImagesArray().getQYImages().size(); i++) {
                if(bodyBean.getImagesArray().getQYImages().get(i).getChildList().size()>0){
                    qyphotonum=qyphotonum+1;
                }
            }
        }
        Log.e("lfphotonum:"+lfphotonum,"qyphotonum:"+qyphotonum);

    }

    @Override
    public void responseLHouseDataError(String msg) {

    }

    @Override
    public void responsesaveLHouseData(String msg) {
        showToast(msg);
        finish();
    }

    @Override
    public void responsesaveLHouseDataError(String msg) {
        showToast(msg);
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
