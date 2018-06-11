package com.rxjy.rxcompound.des.photo;

import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.CompressUtil;
import com.rxjy.rxcompound.des.entity.AlbumImgInfo;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.MyCamera;
import com.rxjy.rxcompound.des.mvp.contract.MyCameraContract;
import com.rxjy.rxcompound.des.mvp.presenter.MyCameraPresenter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyCameraActivity extends BaseActivity<MyCameraPresenter> implements MyCameraContract.View, SurfaceHolder.Callback {
    private static final String TAG = "1";
    SurfaceView cameraView;
    SurfaceHolder surfaceHolder;
    Camera camera;

    public static final int LARGEST_WIDTH = 300;
    public static final int LARGEST_HEIGHT = 300;
    @Bind(R.id.mycamera_left)
    TextView mycameraLeft;
    @Bind(R.id.mycamera_right)
    TextView mycameraRight;

    //toutiao
//    private CategoryTabStrip tabs;
//    private ViewPager pager;
    private MyPagerAdapter adapter;
    @Bind(R.id.mycamera_exit)
    TextView tv_exit;
    @Bind(R.id.iv_light1)
    ImageView iv_light1;
    @Bind(R.id.iv_light2)
    ImageView iv_light2;
    @Bind(R.id.iv_light3)
    ImageView iv_light3;
    @Bind(R.id.mycamera_vp)
    CustomViewPager vp;
    @Bind(R.id.mycamera_ll)
    LinearLayout ll;
    AllClientInfo.ClientTypeInfo.ClientInfo clientInfo;

    int shanguangdengbs = 0;
    int chongfudianji = 0;
    int chongfudianji2 = 0;

    int shanguangdengtype = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.mycamera_layout);
        ButterKnife.bind(this);

        vp.setOffscreenPageLimit(3);
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return vp.dispatchTouchEvent(motionEvent);
            }
        });
        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        iv_light1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_light2.getVisibility() == View.GONE && iv_light3.getVisibility() == View.GONE) {
                    iv_light2.setVisibility(View.VISIBLE);
                    iv_light3.setVisibility(View.VISIBLE);
                } else if (iv_light2.getVisibility() == View.VISIBLE && iv_light3.getVisibility() == View.VISIBLE) {
                    iv_light2.setVisibility(View.GONE);
                    iv_light3.setVisibility(View.GONE);
                }



            }
        });
        iv_light2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (shanguangdengbs == 0) {
                    iv_light1.setImageResource(R.mipmap.shanguangdengyes);
                    iv_light2.setImageResource(R.mipmap.shanguangdengmoren);

                    shanguangdengtype = 2;

                    iv_light2.setVisibility(View.GONE);
                    iv_light3.setVisibility(View.GONE);

                } else if (shanguangdengbs == 2) {
                    if (chongfudianji == 0) {
                        iv_light1.setImageResource(R.mipmap.shanguangdengmoren);
                        iv_light2.setImageResource(R.mipmap.shanguangdengyes);

                        shanguangdengtype = 1;

                        iv_light2.setVisibility(View.GONE);
                        iv_light3.setVisibility(View.GONE);

                        chongfudianji = 1;
                    } else if (chongfudianji == 1) {
                        iv_light1.setImageResource(R.mipmap.shanguangdengyes);
                        iv_light2.setImageResource(R.mipmap.shanguangdengmoren);

                        shanguangdengtype = 2;

                        iv_light2.setVisibility(View.GONE);
                        iv_light3.setVisibility(View.GONE);

                        chongfudianji = 0;
                    }

                    shanguangdengbs = 4;
                } else if (shanguangdengbs == 3) {
                    iv_light1.setImageResource(R.mipmap.shanguangdengmoren);
                    iv_light2.setImageResource(R.mipmap.shanguangdengyes);
                    iv_light3.setImageResource(R.mipmap.shanguangdengno);

                    shanguangdengtype = 1;

                    iv_light2.setVisibility(View.GONE);
                    iv_light3.setVisibility(View.GONE);

                }
                shanguangdengbs = 2;

            }
        });
        iv_light3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shanguangdengbs == 0) {
                    iv_light1.setImageResource(R.mipmap.shanguangdengno);
                    iv_light2.setImageResource(R.mipmap.shanguangdengmoren);
                    iv_light3.setImageResource(R.mipmap.shanguangdengyes);

                    shanguangdengtype = 3;

                    iv_light2.setVisibility(View.GONE);
                    iv_light3.setVisibility(View.GONE);

                } else if (shanguangdengbs == 2) {
                    iv_light1.setImageResource(R.mipmap.shanguangdengno);
                    iv_light2.setImageResource(R.mipmap.shanguangdengmoren);
                    iv_light3.setImageResource(R.mipmap.shanguangdengyes);

                    shanguangdengtype = 3;

                    iv_light2.setVisibility(View.GONE);
                    iv_light3.setVisibility(View.GONE);

                } else if (shanguangdengbs == 3) {
                    if (chongfudianji2 == 0) {
                        chongfudianji2 = 1;
                        iv_light1.setImageResource(R.mipmap.shanguangdengyes);
                        iv_light3.setImageResource(R.mipmap.shanguangdengno);

                        shanguangdengtype = 2;

                        iv_light2.setVisibility(View.GONE);
                        iv_light3.setVisibility(View.GONE);

                    } else if (chongfudianji2 == 1) {
                        chongfudianji2 = 0;
                        iv_light1.setImageResource(R.mipmap.shanguangdengno);
                        iv_light3.setImageResource(R.mipmap.shanguangdengyes);

                        shanguangdengtype = 3;

                        iv_light2.setVisibility(View.GONE);
                        iv_light3.setVisibility(View.GONE);

                    }

                }
                shanguangdengbs = 3;
            }
        });

        cameraView = (SurfaceView) this.findViewById(R.id.CameraView);
        cameraView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera camera) {
                        camera.cancelAutoFocus();
                    }
                });
                return false;
            }
        });

        surfaceHolder = cameraView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(this);

        System.out.println("oncreate");
////toutiao
//        tabs = (CategoryTabStrip) findViewById(R.id.category_strip);
//        pager = (ViewPager) findViewById(R.id.view_pager);

    }

    @Override
    public int getLayout() {
        return R.layout.mycamera_layout;
    }

    private AllImagesInfo.Album ainfo;
    private int picbs=-1;
    @Override
    public void initData() {
        pos = getIntent().getIntExtra("MYCAMERAPOS", 0);
        picbs=getIntent().getIntExtra("PAIZHAOBIAOSHI",-1);
        ainfo= (AllImagesInfo.Album) getIntent().getSerializableExtra("AINFO");
        clientInfo = (AllClientInfo.ClientTypeInfo.ClientInfo) getIntent().getSerializableExtra(Constants.ACTION_TO_DAI_MEASURE_CLIENT_INFO);
        mPresenter.getCameraType(clientInfo.getCi_rwdid());

    }



    Camera.Parameters parameters;


    private void initCamera() {
        parameters = camera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);

        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        setDispaly(parameters, camera);
        camera.setParameters(parameters);
        camera.startPreview();
        camera.cancelAutoFocus();

    }


    private void setDispaly(Camera.Parameters parameters, Camera camera) {
        if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
            setDisplayOrientation(camera, 90);
        } else {
            parameters.setRotation(90);
        }

    }

    private void setDisplayOrientation(Camera camera, int i) {
        Method downPolymorphic;
        try {
            downPolymorphic = camera.getClass().getMethod("setDisplayOrientation", int.class);
            if (downPolymorphic != null) {
                downPolymorphic.invoke(camera, i);
            }
        } catch (Exception e) {

        }
    }

    //-----------------------------------------------
    @Override
    protected MyCameraPresenter onCreatePresenter() {
        return new MyCameraPresenter(this);
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onStart()
     */
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onstart");
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        camera.autoFocus(new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                if (success) {
                    initCamera();
                    camera.cancelAutoFocus();
                }
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("surfaceCreated");
        camera = Camera.open();

        try {
            camera.setPreviewDisplay(holder);
            Camera.Parameters parameters = camera.getParameters();
            if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                parameters.set("orientation", "portrait");
                camera.setDisplayOrientation(90);
                parameters.setRotation(90);
            } else {
                parameters.set("orientation", "landscape");
                camera.setDisplayOrientation(0);
                parameters.setRotation(0);
            }
            camera.setParameters(parameters);

            int bestWidth = 0;
            int bestHeight = 0;
            List<Camera.Size> previewSizes = parameters.getSupportedPictureSizes();
            if (previewSizes.size() > 1) {
                Iterator<Camera.Size> cei = previewSizes.iterator();
                while (cei.hasNext()) {
                    Camera.Size aSize = cei.next();
                    System.out.println(aSize.width + "," + aSize.height);
                    if (aSize.width > bestWidth && aSize.width <= LARGEST_WIDTH
                            && aSize.height > bestHeight && aSize.height <= LARGEST_HEIGHT) {
                        bestWidth = aSize.width;
                        bestHeight = aSize.height;
                    }
                    if (bestHeight != 0 && bestWidth != 0) {
                        Log.v("SNAPSHOT", "Using" + bestWidth + "x" + bestHeight);
                        parameters.setPreviewSize(bestWidth, bestHeight);
                        cameraView.setLayoutParams(new LinearLayout.LayoutParams(bestWidth, bestHeight));
                    }
                }
            }

            camera.startPreview();

        } catch (Exception e) {
            camera.release();
        }
        camera.autoFocus(null);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        System.out.println("surfaceDestroyed");
        camera.stopPreview();
        camera.release();
    }


    @OnClick(R.id.tv_pic)
    public void OnclickPaizhao(View v) {
        //Log.e("picture","paizhao");
        Camera.Parameters parameters = camera.getParameters();
        if (shanguangdengtype == 2) {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
        } else if (shanguangdengtype == 3) {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        } else if (shanguangdengtype == 1) {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
        }

        int catalogid;
        if (!CatalogID.equals("-1")){
            catalogid=Integer.parseInt(CatalogID);
        }else{
            catalogid=ainfo.getCatalogID();
        }

        int size=mc2.getBody().getCatalogList().size();
        int pos2=-1;
        for (int i=0;i<size;i++){
            if (Integer.parseInt(mc2.getBody().getCatalogList().get(i).getCatalogID())==catalogid){
                pos2=i;
            }
        }


        camera.setParameters(parameters);
        camera.takePicture(null, null, new MyPictureCallback());
        int i = Integer.parseInt(list.get(pos2).getImgCount());
        i = i + 1;
        String str = String.valueOf(i);
        list.get(pos2).setImgCount(str);
        vp.setAdapter(adapter);
        vp.setCurrentItem(pos2);
        //adapter.notifyDataSetChanged();




    }

    Bundle bundle;
    MyCamera mc2;
    String CatalogID="-1";
    int WorkID;
    int UserID;
    int pos;
    List<MyCamera.Body.CatalogList> list;

    @Override
    public void showlistitem(MyCamera mc) {

        mc2 = mc;
        list = mc.getBody().getCatalogList();
        adapter = new MyPagerAdapter(this, list);
        vp.setAdapter(adapter);

        int size=mc.getBody().getCatalogList().size();
        int pos2=-1;
        int catalogid = 0;
        if (picbs==0) {
            CatalogID = mc2.getBody().getCatalogList().get(0).getCatalogID();
        }else {
            catalogid=ainfo.getCatalogID();
            for (int i=0;i<size;i++){
                if (Integer.parseInt(mc.getBody().getCatalogList().get(i).getCatalogID())==catalogid){
                    pos2=i;
                }
            }
        }



        vp.setCurrentItem(pos2);
        //tabs.setViewPager(pager);
//        if (picbs==0) {
//            CatalogID = mc2.getBody().getCatalogList().get(0).getCatalogID();
//        }
        WorkID = mc2.getBody().getWorkID();
        UserID = mc2.getBody().getUserID();

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                CatalogID = mc2.getBody().getCatalogList().get(position).getCatalogID();
                WorkID = mc2.getBody().getWorkID();
                UserID = mc2.getBody().getUserID();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
    public void responseSubImageData(List<AlbumImgInfo.ImgInfo> dataList) {
        //showToast(String.valueOf(R.string.success));
        Toast.makeText(this, R.string.success, Toast.LENGTH_LONG).show();
    }

    @Override
    public void responseSubImageDataError(String msg) {

    }


    private final class MyPictureCallback implements Camera.PictureCallback {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                Log.e("picture2", "paizhao");
                bundle = new Bundle();
                Log.e("ccc", data.length + "");
                bundle.putByteArray("bytes", data);
                File jpgfile = saveToSDCard(data);

                List<String> list = new ArrayList<>();
                Log.e("MyCameraPresenter2", jpgfile.toString());
                list.add(jpgfile.toString());


                CompressUtil compressUtil = new CompressUtil();
                compressUtil.compressPicture(list, new CompressUtil.CallBack() {
                    @Override
                    public void callBack(List<String> imgList) {

                        mPresenter.subImage2(WorkID, CatalogID, UserID, imgList);
                    }
                });


                camera.startPreview();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     *
     * @param data
     * @throws IOException
     */
    public File saveToSDCard(byte[] data) throws IOException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String filename = format.format(date) + ".jpg";
        File fileFolder = new File(Environment.getExternalStorageDirectory()
                + "/RuixiangImg/");


        if (!fileFolder.exists()) {
            fileFolder.mkdir();
        }
        File jpgFile = new File(fileFolder, filename);
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(jpgFile));
        os.write(data);
        os.close();

        MediaScannerConnection.scanFile(MyCameraActivity.this, new String[]{jpgFile.toString()}, null, null);
        return jpgFile;

    }



    public void turnLightOn(Camera mCamera) {

        if (mCamera == null) {
            return;
        }
        Camera.Parameters parameters = mCamera.getParameters();
        if (parameters == null) {
            return;
        }
        List<String> flashModes = parameters.getSupportedFlashModes();
        // Check if camera flash exists
        if (flashModes == null) {
            // Use the screen as a flashlight (next best thing)
            return;
        }
        String flashMode = parameters.getFlashMode();
        if (!Camera.Parameters.FLASH_MODE_TORCH.equals(flashMode)) {
            // Turn on the flash
            if (flashModes.contains(Camera.Parameters.FLASH_MODE_TORCH)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(parameters);
            } else {
            }
        }
    }

    public static void turnLightOff(Camera mCamera) {
        if (mCamera == null) {
            return;
        }
        Camera.Parameters parameters = mCamera.getParameters();
        if (parameters == null) {
            return;
        }
        List<String> flashModes = parameters.getSupportedFlashModes();
        String flashMode = parameters.getFlashMode();
        // Check if camera flash exists
        if (flashModes == null) {
            return;
        }
        if (!Camera.Parameters.FLASH_MODE_OFF.equals(flashMode)) {
            // Turn off the flash
            if (flashModes.contains(Camera.Parameters.FLASH_MODE_OFF)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
            } else {
                Log.e(TAG, "FLASH_MODE_OFF not supported");
            }
        }
    }




}