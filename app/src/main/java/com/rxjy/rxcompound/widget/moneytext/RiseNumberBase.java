package com.rxjy.rxcompound.widget.moneytext;

/**
 * Created by hjh on 2018/3/22.
 */

public interface RiseNumberBase {
    void start();

    RiseNumberTextView withNumber(float number);

    RiseNumberTextView withNumber(float number, boolean flag);

    RiseNumberTextView withNumber(int number);

    RiseNumberTextView setDuration(long duration);

    void setOnEnd(RiseNumberTextView.EndListener callback);
}