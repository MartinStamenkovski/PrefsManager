package com.stamenkovski.prefsmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class PrefsManager {

    public static <T> void setValueToPrefs(Context context, String key, T value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value.equals(Float.class)) {
            editor.putFloat(key, ((Float) value));
        } else if (value.equals(Integer.class)) {
            editor.putInt(key, ((Integer) value));
        } else if (value.equals(Boolean.class)) {
            editor.putBoolean(key, ((Boolean) value));
        } else if (value.equals(Long.class)) {
            editor.putLong(key, ((Long) value));
        } else if (value.equals(String.class)) {
            editor.putString(key, ((String) value));
        } else {
            String json = new Gson().toJson(value);
            editor.putString(key, json);
        }
        editor.apply();
    }

    public static <T> Object getValueFromPrefs(Context context, String key, T typeOf) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        if (typeOf.equals(Float.class)) {
            return sharedPreferences.getFloat(key, 0f);
        } else if (typeOf.equals(Integer.class)) {
            return sharedPreferences.getInt(key, 0);
        } else if (typeOf.equals(Boolean.class)) {
            return sharedPreferences.getBoolean(key, false);
        } else if (typeOf.equals(Long.class)) {
            return sharedPreferences.getLong(key, 0);
        } else if (typeOf.equals(String.class)) {
            return sharedPreferences.getString(key, null);
        } else {
            String json = sharedPreferences.getString(key, null);
            Type type = new TypeToken<T>() {
            }.getType();
            return new Gson().fromJson(json, type);
        }
    }
}