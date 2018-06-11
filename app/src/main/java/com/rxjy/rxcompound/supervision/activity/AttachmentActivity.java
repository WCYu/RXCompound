package com.rxjy.rxcompound.supervision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.TimeUtil;
import com.rxjy.rxcompound.supervision.adapter.AttachmentAdapter;
import com.rxjy.rxcompound.supervision.entity.AttachmentTypeInfo;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.AttachmentContract;
import com.rxjy.rxcompound.supervision.mvp.presenter.AttachmentPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttachmentActivity extends BaseActivity<AttachmentPresenter> implements AttachmentContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_attachment_choice_type)
    TextView tvChoiceType;
    @Bind(R.id.tv_attachment_complete_date)
    TextView tvCompleteDate;
    @Bind(R.id.et_attachment_postpone)
    EditText etPostpone;
    @Bind(R.id.tv_attachment_choice_date)
    TextView tvChoiceDate;
    @Bind(R.id.lin_attachment_project_date)
    LinearLayout linProjectDate;
    @Bind(R.id.gv_attachment)
    GridView gvAttachment;

    public static final String TITLE = "附件资料上传";

    private List<AttachmentTypeInfo.AttachmentInfo> attList;

    private List<String> attTypeList;

    private OptionsPickerView pView;

    private List<LocalMedia> imgList;

    private AttachmentAdapter attAdapter;

    private int modelId = 0;

    private ProjectListInfo.Project proInfo;

    @Override
    public int getLayout() {
        return R.layout.activity_attachment;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initAttachmentType();
        initPostpone();
        initAttachmentImg();
    }

    private void initIntent() {
        proInfo = (ProjectListInfo.Project) getIntent().getSerializableExtra(Constants.ACTION_TO_ATTACHMENT_PRO_INFO);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initAttachmentType() {

        attList = new ArrayList<>();

        attTypeList = new ArrayList<>();

        pView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                AttachmentTypeInfo.AttachmentInfo info = attList.get(options1);
                tvChoiceType.setText(info.getAttr_name());
                modelId = info.getAttr_model_id();
                if (info.getAttr_model_id() == 93) {
                    linProjectDate.setVisibility(View.VISIBLE);
                } else {
                    linProjectDate.setVisibility(View.GONE);
                }
            }
        }).build();

        mPresenter.getAttachmentTypeInfo();

    }

    private void initPostpone() {

        tvCompleteDate.setText(TimeUtil.getNormalTime(proInfo.getEndTime()));

        etPostpone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String timeStr = etPostpone.getText().toString().trim();
                if (timeStr.equals("")) {
                    tvChoiceDate.setText("");
                } else {
                    int time = Integer.parseInt(timeStr);
                    String completeDate = tvCompleteDate.getText().toString().trim();
                    String choiceDate = getTime(completeDate, time);
                    tvChoiceDate.setText(choiceDate);
                }
            }
        });

    }

    private void initAttachmentImg() {

        imgList = new ArrayList<>();

        attAdapter = new AttachmentAdapter(this, imgList);

        gvAttachment.setAdapter(attAdapter);

        gvAttachment.setOnItemClickListener(this);

    }

    private String getTime(String createDate, int dayCount) {
        String dayDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(createDate);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            cl.add(Calendar.DATE, dayCount);
            dayDate = sdf.format(cl.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dayDate;
    }

    @Override
    protected AttachmentPresenter onCreatePresenter() {
        return new AttachmentPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (imgList != null) {
            if (imgList.size() > 0) {
                if (!(imgList.get(imgList.size() - 1).getPath() == null)) {
                    imgList.add(new LocalMedia());
                }
            } else {
                imgList.add(new LocalMedia());
            }
            attAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    imgList.clear();
                    imgList.addAll(localMedias);
                    imgList.add(new LocalMedia());
                    attAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_attachment_choice_type, R.id.btn_attachment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_attachment_choice_type:
                if (attTypeList.size() != 0) {
                    pView.show();
                }
                break;
            case R.id.btn_attachment:
                String dayCount = etPostpone.getText().toString().trim();
                if (modelId == 0) {
                    showToast("请选择类型");
                    return;
                }
                if (modelId == 93 && dayCount.equals("")) {
                    showToast("请输入延期天数");
                    return;
                }
                if (imgList.size() <= 1) {
                    showToast("请选择要添加的附件");
                    return;
                }
                if (modelId == 93 && imgList.size() != 2){
                    showToast("工程延期单只能添加单张照片");
                    return;
                }
                imgList.remove(imgList.size() - 1);
                mPresenter.subAttachmentInfo(proInfo.getOrderNo(), dayCount, modelId, imgList);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.gv_attachment:
                if (modelId == 0){
                    showToast("请先选择附件资料");
                    return;
                }
                if ((attAdapter.getCount() - 1) == position) {
                    if (imgList.size() != 0) {
                        imgList.remove(imgList.size() - 1);
                    }
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(20)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .selectionMedia(imgList)
                            .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code 
                } else {
                    imgList.remove(imgList.size() - 1);
                    PictureSelector.create(this).externalPicturePreview(position, imgList);
                }
                break;
        }
    }

    @Override
    public void responseAttachmentTypeData(List<AttachmentTypeInfo.AttachmentInfo> dataList) {
        attList.clear();
        attTypeList.clear();
        attList.addAll(dataList);
        for (AttachmentTypeInfo.AttachmentInfo info : attList) {
            attTypeList.add(info.getAttr_name());
        }
        pView.setPicker(attTypeList);
    }

    @Override
    public void responseAttachmentTypeDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSubAttachmentData() {
        showToast("提交成功");
        finish();
    }

    @Override
    public void responseSubAttachmentDataError(String msg) {
        showToast(msg);
        imgList.add(new LocalMedia());
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