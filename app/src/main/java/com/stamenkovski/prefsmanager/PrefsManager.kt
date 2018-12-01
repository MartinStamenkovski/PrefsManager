package com.stamenkovski.prefsmanager

import android.content.Context
import org.jetbrains.annotations.Nullable

fun Any.setStringValueToPrefs(context: Context, key: String, value: String) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.putString(key, value)
        this.apply()
    }
}

fun Any.setFloatValueToPrefs(context: Context, key: String, value: Float) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.putFloat(key, value)
        this.apply()
    }
}

fun Any.setBoolValueToPrefs(context: Context, key: String, value: Boolean) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.putBoolean(key, value)
        this.apply()
    }
}

fun Any.setIntValueToPrefs(context: Context, key: String, value: Int) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.putInt(key, value)
        this.apply()
    }
}

fun Any.setLongValueToPrefs(context: Context, key: String, value: Long) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.putLong(key, value)
        this.apply()
    }
}

fun Any.setMutableStringSetToPrefs(context: Context, key: String, value: MutableSet<String>) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.putStringSet(key, value)
        this.apply()
    }
}

@Nullable
fun Any.getStringValueFromPrefs(context: Context, key: String, defaultValue: String? = null): String? {

    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences?.apply {
        return sharedPreferences.getString(key, defaultValue)
    }
    return null
}

@Nullable
fun Any.getFloatValueFromPrefs(context: Context, key: String, defaultValue: Float = 0f): Float? {

    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences?.apply {
        return sharedPreferences.getFloat(key, defaultValue)
    }
    return null
}
