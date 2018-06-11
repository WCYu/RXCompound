package com.rxjy.rxcompound.des.photo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/8/21.
 */

public class CustomViewPager extends ViewPager {
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    float downX = 0;
    float downY = 0;

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//
////            downX = ev.getX();
////            downY = ev.getY();
//            downX = ev.getRawX();
//            downY = ev.getY();
//        }
//        if (ev.getAction() == MotionEvent.ACTION_UP) {
//            View view = viewOfClickOnScreen(ev, downX, downY);
//            if (view != null) {
//                int index = indexOfChild(view);
//                if (getCurrentItem() != index) {
//                    setCurrentItem(indexOfChild(view));
//                }
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }
//
//    /**
//     * @param ev
//     * @return
//     */
//    private View viewOfClickOnScreen(MotionEvent ev, float downX, float downY) {
//        int childCount = getChildCount();
//        Log.e("ev","childCount = " + childCount);
//        int[] location = new int[2];
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            v.getLocationOnScreen(location);
////            v.getLocationInWindow(location);
//
//            int minX = location[0];
//            int minY = getTop();
//
//            int maxX = location[0] + v.getWidth();
//            int maxY = getBottom();
//
//            float x = ev.getX();
//            float y = ev.getY();
//            if ((x > minX && x < maxX) && (y > minY && y < maxY) && (downX > minX && downX < maxX) && (downY > minY && downY < maxY)) {
//                return v;
//            }
//        }
//        return null;
//    }
}
