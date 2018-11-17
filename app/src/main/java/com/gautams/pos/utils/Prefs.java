package com.gautams.pos.utils;

import android.content.Context;
import android.content.SharedPreferences;


/*
 * Developer   : gautams2
 * Date        : 7/5/2018
 * Description : Utils class for Share Preferences
 */

public class Prefs {

    private final SharedPreferences mPreferences;

    private static Prefs instance;

    public static void init(Context context) {
        if (instance == null)
            instance = new Prefs(context);
    }

    public static Prefs getInstance() {
        if (instance == null)
            throw new NullPointerException("Prefs must be initialized by calling :: Prefs.init(context) ");
        return instance;
    }

    private Prefs(Context context) {
        mPreferences = context.getSharedPreferences("application_shared_preference", Context.MODE_PRIVATE);
    }

    public void put(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, long value) {
        mPreferences.edit().putLong(key, value).apply();
    }

    public void put(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    public int get(String key, int defaultValue) {
        return mPreferences.getInt(key, defaultValue);
    }

    public boolean get(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    public String get(String key, String defaultValue) {
        return mPreferences.getString(key, defaultValue);
    }

    public long get(String key, long defaultValue) {
        return mPreferences.getLong(key, defaultValue);
    }
}
