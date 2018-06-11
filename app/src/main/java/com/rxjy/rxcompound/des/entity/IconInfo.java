package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/4/12.
 */
public class IconInfo {

    private android.widget.ImageView ImageView;
    private android.widget.TextView TextView;
    private android.widget.TextView TextView2;
    public IconInfo(android.widget.ImageView imageView, android.widget.TextView textView) {
        ImageView = imageView;
        TextView = textView;
    }

    public IconInfo(android.widget.TextView textView, android.widget.TextView textView2) {
        TextView = textView;
        TextView2=textView2;

    }

    public android.widget.ImageView getImageView() {
        return ImageView;
    }

    public void setImageView(android.widget.ImageView imageView) {
        ImageView = imageView;
    }

    public android.widget.TextView getTextView() {
        return TextView;
    }

    public void setTextView(android.widget.TextView textView) {
        TextView = textView;
    }

    public android.widget.TextView getTextView2() {
        return TextView2;
    }

}
