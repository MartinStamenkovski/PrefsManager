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
        Log.i("USERS adding ", userList.toString())

        val user = User("user", "user")
        setValueToPrefs(this, "user_one", user)

        val json = Gson().toJson(user)
        val gson = Gson().fromJson(json, User::class.java)
        getValueFromPrefs<User>(this, "user_one")?.apply {
            Log.i("JSON ", this.toString())
        }


        removeValueFromPrefs(this, "user_list")

        setValueToPrefs(this, "user_list", userList)

        getValueFromPrefs<MutableList<User>>(this, "user_list")?.apply {
            //Do something with the users list
            Log.i("USER", this[0].toString())
        }

    }

    fun startSecond(v: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }
}

@Parcelize
data class User(val userEmail: String, val userName: String) : Parcelable
