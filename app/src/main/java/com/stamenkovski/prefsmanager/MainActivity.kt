package com.stamenkovski.prefsmanager

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.parcel.Parcelize

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValueToPrefs(this, "value", "This is some string")

        getValueFromPrefs<String>(this, "value")?.apply {
            Log.i("STRING VALUE ", this)
        }
        PrefsManager.setValueToPrefs(this, "s", false)

        val userList = mutableListOf<User>()
        userList.add(User("hh@gmail.com", "hh"))
        userList.add(User("gg@gmail.com", "gg"))

        removeValueFromPrefs(this, "user_list")

        PrefsManager.setValueToPrefs(this, "user_list", userList)

        //setValueToPrefs(this, "user_list", userList)
        /*getValueFromPrefs<MutableList<User>>(this, "user_list")?.apply {
            Log.i("USER", this.toString())
        }*/
        Log.i("USER LISTING ", PrefsManager.getValueFromPrefs(this, "user_list", MutableList::class.java).toString())

    }

    fun startSecond(v: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }
}

@Parcelize
data class User(val userEmail: String, val userName: String) : Parcelable
