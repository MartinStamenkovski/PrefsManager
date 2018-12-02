package com.stamenkovski.prefsmanager_example

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize
import com.stamenkovski.prefsmanager.R
import com.stamenkovski.prefsmanager.getValueFromPrefs
import com.stamenkovski.prefsmanager.removeValueFromPrefs
import com.stamenkovski.prefsmanager.setValueToPrefs
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = mutableListOf<User>()
        userList.add(User("user@gmail.com", "user"))
        userList.add(User("johndoe@gmail.com", "John Doe"))


        removeValueFromPrefs(this, "user_list")

        //setValueToPrefs(this, "user_list", userList)

        getValueFromPrefs<MutableList<User>?>(this, "user_list", null).apply {
            //Do something with the users list
            Log.i("USER", "$this")
        }

        setValueToPrefs(this, "is", false)

        getValueFromPrefs(this, "is", false)?.apply {
            Log.i("BOOLEAN", "$this")
        }

        getValueFromPrefs<String?>(this, "string", null).apply {

        }

    }

    fun startSecond(v: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }
}

@Parcelize
data class User(val userEmail: String, val userName: String) : Parcelable
