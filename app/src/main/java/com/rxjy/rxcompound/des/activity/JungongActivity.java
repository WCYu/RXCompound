package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.des.adapter.DesDaiImgAdapter;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.GetZaishiInfo;
import com.rxjy.rxcompound.des.mvp.contract.KaiGongContract;
import com.rxjy.rxcompound.des.mvp.presenter.KaigongPresenter;
import com.rxjy.rxcompound.widget.CustomGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class JungongActivity extends BaseActivity<KaigongPresenter> implements KaiGongContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    TextView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_kaigong_xiangmuname)
    TextView tvKaigongXiangmuname;
    @Bind(R.id.tv_kaigong_xiangmuaddress)
    TextView tvKaigongXiangmuaddress;
    @Bind(R.id.gv_des_dai_measure_photo)
    CustomGridView gvDesDaiMeasurePhoto;
    @Bind(R.id.tv_kaigongor_jungong)
    TextView tvKaigongorJungong;
    @Bind(R.id.jiedan_jiantou)
    ImageView jiedanJiantou;
    @Bind(R.id.ll_jiedan)
    LinearLayout llJiedan;


    private List<AllImagesInfo.Album> albumList;

    private DesDaiImgAdapter mAdapter;

    GetZaishiInfo.BodyBean bodyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_kaigongjiaodi);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_kaigongjiaodi;
    }

    @Override
    public void initData() {
        tvKaigongorJungong.setText("竣工验收");
        albumList = new ArrayList<>();

        mAdapter = new DesDaiImgAdapter(this, albumList);

        gvDesDaiMeasurePhoto.setAdapter(mAdapter);
        gvDesDaiMeasurePhoto.setOnItemClickListener(this);

        initTitle();
        bodyBean = (GetZaishiInfo.BodyBean) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);

        tvKaigongXiangmuname.setText(bodyBean.getCi_ClientName());
        tvKaigongXiangmuaddress.setText(bodyBean.getCi_DecorationAddress());


    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.GetUCAllImages(bodyBean.getCi_RwdId(), 3);
    }

    private void initTitle() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle.setText("竣工验收");

    }

    private int position;
    private AllImagesInfo.Album ainfo;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        this.position = position;
        AllImagesInfo.Album info = albumList.get(position);
        ainfo = info;
        List<AllImagesInfo.Album.
                image> imageList = info.getChildList();
        Intent albumIntent = new Intent(this, DesAlbumActivityhd.class);
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_INFO, (ArrayList<AllImagesInfo.Album.image>) imageList);
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_WORKS_ID, info.getWorksID());
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_CATALOG_ID, info.getCatalogID());
        /**
         * todo
         */
//        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, App.baseInfo.getUserId());
        albumIntent.putExtra(Constants.ACTION_TO_ALBUM_IMG_USER_ID, "01012694");
        startActivity(albumIntent);

    }


    @Override
    protected KaigongPresenter onCreatePresenter() {
        return new KaigongPresenter(this);
    }


    @Override
    public void responseKaigongInfo(List<AllImagesInfo.Album> info) {
        albumList.clear();
        albumList.addAll(info);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseKaigongInfoError(String error) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
}
