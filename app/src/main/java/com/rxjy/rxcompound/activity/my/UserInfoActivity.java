package com.rxjy.rxcompound.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.riv_head_photo)
    ImageView rivHeadPhoto;
    @Bind(R.id.rl_icon)
    RelativeLayout rlIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.rl_name)
    RelativeLayout rlName;
    @Bind(R.id.tv_gender)
    TextView tvGender;
    @Bind(R.id.rl_sex)
    RelativeLayout rlSex;
    @Bind(R.id.tv_birthday)
    TextView tvBirthday;
    @Bind(R.id.rl_time)
    RelativeLayout rlTime;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_mailbox)
    TextView tvMailbox;
    @Bind(R.id.rl_youxiang)
    RelativeLayout rlYouxiang;
    @Bind(R.id.tv_erweima)
    ImageView tvErweima;
    @Bind(R.id.rl_erweima)
    RelativeLayout rlErweima;
    @Bind(R.id.tv_area)
    TextView tvArea;
    private ArrayList<Object> sexList;
    private OptionsPickerView sexPicker;
    private String key;
    private String mSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_icon, R.id.rl_name, R.id.rl_sex, R.id.rl_time, R.id.rl_youxiang, R.id.rl_erweima})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_icon://选择头像
                break;
            case R.id.rl_name://修改名字
                break;
            case R.id.rl_sex://修改性别

                break;
            case R.id.rl_time://修改生日
                break;
            case R.id.rl_youxiang://修改邮箱
                break;
            case R.id.rl_erweima://二维码
                break;
        }
    }

    private void initSexData() {

        sexList = new ArrayList<>();

        sexList.add("男");
        sexList.add("女");

        sexPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                key = "sex";
                tvGender.setText(sexList.get(options1).toString());
                mSex = sexList.get(options1).toString();
            }
        }).build();

        sexPicker.setPicker(sexList);

    }

}
