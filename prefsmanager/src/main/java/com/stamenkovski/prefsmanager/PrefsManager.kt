package com.stamenkovski.prefsmanager

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.annotations.Nullable
import java.lang.reflect.Type

inline fun <reified T> Any.setValueToPrefs(context: Context, key: String, value: T) {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        when (T::class) {
            Boolean::class -> {
                this.putBoolean(key, value as Boolean)
            }
            Float::class -> {
                this.putFloat(key, value as Float)
            }
            Int::class -> {
                this.putInt(key, value as Int)
            }
            Long::class -> {
                this.putLong(key, value as Long)
            }
            String::class -> {
                this.putString(key, value as String)
            }
            else -> {
                this.putString(key, Gson().toJson(value))
            }
        }
        apply()
    }
}


@Nullable
inline fun <reified T> Any.getValueFromPrefs(context: Context, key: String, defaultValue: T? = null): T? {
    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences?.apply {
        when (T::class) {
            Boolean::class -> {
                defaultValue?.let {
                    return this.getBoolean(key, it as Boolean) as T
                }
                return this.getBoolean(key, defaultValue as Boolean) as T

            }
            Float::class -> {
                defaultValue?.let {
                    return this.getFloat(key, it as Float) as T
                }
                return this.getFloat(key, defaultValue as Float) as T
            }
            Int::class -> {
                defaultValue?.let {
                    return this.getInt(key, it as Int) as T
                }
                return this.getInt(key, defaultValue as Int) as T
            }
            Long::class -> {
                defaultValue?.let {
                    return this.getLong(key, it as Long) as T
                }
                return this.getLong(key, defaultValue as Long) as T
            }
            String::class -> {
                return this.getString(key, defaultValue as String?) as T
            }
            else -> {
                val json = this.getString(key, defaultValue as String?)
                json?.apply {
                    val type = object : TypeToken<T>() {}.type
                    return Gson().fromJson(json, type)
                }
                return json as T
            }
        }
    }
    return null
}

fun Any.removeValueFromPrefs(context: Context, key: String) {

    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    sharedPreferences.edit()?.apply {
        this.remove(key)
        this.apply()
    }
}


