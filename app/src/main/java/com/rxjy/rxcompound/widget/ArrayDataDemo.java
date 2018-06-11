package com.rxjy.rxcompound.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by asus on 2018/4/14.
 */

public class ArrayDataDemo {

    private static final Map<String, Map<String, List<String>>> DATAs = new LinkedHashMap<>();

    private static void init() {
        if (!DATAs.isEmpty()) {
            return;
        }

        for (int i = 0; i < 30; i++) {
            Map<String, List<String>> city = new HashMap<>();
            for (int j = 0; j < 30; j++) {
                List<String> data = new ArrayList<>();
                for (int k = 0; k < 30; k++) {
                    data.add(getRandomText() + k);
                }
                city.put("一二三四五六七八九" + j, data);
            }
            DATAs.put("一二三四五六七八九" + i, city);
        }
    }

    private static Random random = new Random();

    private static String getRandomText() {
        int num = random.nextInt(20);
        String str = "五";
        for (int i = 0; i < num; i++) {
            str += "五";
        }
        return str;
    }

    public static Map<String, Map<String, List<String>>> getAll() {
        init();
        return new HashMap<>(DATAs);
    }

}
