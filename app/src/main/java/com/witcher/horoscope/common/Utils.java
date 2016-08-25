package com.witcher.horoscope.common;

import android.text.TextUtils;

/**
 * Created by Александр on 17.08.2016.
 */
public class Utils {
    public static boolean isValidName(String name) {
        return !TextUtils.isEmpty(name);
    }
}
