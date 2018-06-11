package com.rxjy.rxcompound.widget.moneytext;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by hjh on 2018/3/22.
 */

public class Utils {
    /**
     * 格式化
     */
    private static DecimalFormat dfs = null;

    public static DecimalFormat format(String pattern) {
        if (dfs == null) {
            dfs = new DecimalFormat();
        }
        dfs.setRoundingMode(RoundingMode.FLOOR);
        dfs.applyPattern(pattern);
        return dfs;
    }
}