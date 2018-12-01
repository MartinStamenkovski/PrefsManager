//package com.stamenkovski.prefsmanager
//
//import android.content.Context
//import com.google.gson.Gson
//import org.jetbrains.annotations.Nullable
//
//inline fun <reified T> Any.setValueToPrefs(context: Context, key: String, value: T) {
//    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
//    sharedPreferences.edit()?.apply {
//        when (T::class) {
//            Boolean::class -> {
//                this.putBoolean(key, value as Boolean)
//            }
//            Float::class -> {
//                this.putFloat(key, value as Float)
//            }
//            Int::class -> {
//                this.putInt(key, value as Int)
//            }
//            Long::class -> {
//                this.putLong(key, value as Long)
//            }
//            String::class -> {
//                this.putString(key, value as String)
//            }
//            else -> {
//                this.putString(key, Gson().toJson(value))
//            }
//        }
//        apply()
//    }
//}
//
//
//@Nullable
//inline fun <reified T> Any.getValueFromPrefs(context: Context, key: String): T? {
//    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
//    sharedPreferences?.apply {
//        when (T::class) {
//            Boolean::class -> {
//                return this.getBoolean(key, false) as T
//            }
//            Float::class -> {
//                return this.getFloat(key, 0f) as T
//            }
//            Int::class -> {
//                return this.getInt(key, 0) as T
//            }
//            Long::class -> {
//                return this.getLong(key, 0) as T
//            }
//            String::class -> {
//                return this.getString(key, null) as T
//            }
//            else -> {
//                val json = this.getString(key, null)
//                if (json == null) {
//                    throw Exception("Key doesn't exist in shared preferences")
//                } else {
//                    return Gson().fromJson(json, T::class.java)
//                }
//
//            }
//        }
//    }
//    return null
//}
//
//fun Any.removeValueFromPrefs(context: Context, key: String) {
//    val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
//
//    sharedPreferences.edit()?.apply {
//        this.remove(key)
//        this.apply()
//    }
//}
//
