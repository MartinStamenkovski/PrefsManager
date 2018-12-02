package com.stamenkovski.prefsmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class PrefsManager {

    public static void setStringValue(Context context, String key, String value) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(key, value);
        prefEditor.apply();
    }

    public static void removeValueFromPrefs(Context context, String key) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.remove(key);
        prefEditor.apply();
    }

    public static String getStringValue(Context context, String key, String defValue) {

        if (context != null) {
            SharedPreferences settings =
                    context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            return settings.getString(key, defValue);
        } else {
            return "";
        }
    }

    public static void setIntegerValue(Context context, String key, int value) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putInt(key, value);
        prefEditor.apply();
    }

    public static int getIntegerValue(Context context, String key, int defValue) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return settings.getInt(key, defValue);
    }

    public static void setFloatValue(Context context, String key, float value) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putFloat(key, value);
        prefEditor.apply();
    }

    public static float getFloatValue(Context context, String key, float defValue) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return settings.getFloat(key, defValue);
    }

    public static void setBooleanValue(Context context, String key, boolean value) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putBoolean(key, value);
        prefEditor.apply();
    }

    public static boolean getBooleanValue(Context context, String key, boolean defValue) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);

        return settings.getBoolean(key, defValue);
    }

    public static <T> void setObject(Context context, String key, T value) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(key, new Gson().toJson(value));
        prefEditor.apply();
    }

    public static <T> T getObject(Context context, String key, Type type) {
        SharedPreferences settings =
                context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        String json = settings.getString(key, null);

        return new Gson().fromJson(json, type);
    }
}
