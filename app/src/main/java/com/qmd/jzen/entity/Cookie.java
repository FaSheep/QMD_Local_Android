package com.qmd.jzen.entity;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

/**
 * Create by OJun on 2021/2/23.
 */
public class Cookie {

    private static SharedPreferences preferences = null;

    public static void initialize(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        if (!preferences.contains("qqmusic_key")) {
            editor.putString("qqmusic_key", "Q_H_T_XXXXXXXXXXXXXXXX");
        }
        if (!preferences.contains("qqmusic_uin")) {
            editor.putString("qqmusic_uin", "123456789");
        }
        editor.apply();
    }

    public static String getMkey() {
        return preferences.getString("qqmusic_key", "Q_H_T_XX");
    }

    public static String getQQ() {
        return preferences.getString("qqmusic_uin", "12345678");
    }

    public static void setMkey(String mkey) {
        preferences.edit().putString("qqmusic_key", mkey).apply();
    }

    public static void setQQ(String QQ) {
        preferences.edit().putString("qqmusic_uin", QQ).apply();
    }

    public static void setCookie(String key, String qq) {
        setMkey(key);
        setQQ(qq);
    }

    public static String getCookie() {
        return String.format("qqmusic_key=%s;qqmusic_uin=%s;", getMkey(), getQQ());
    }

}
