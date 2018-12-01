package com.stamenkovski.prefsmanager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setStringValueToPrefs(this, "key", "This is value")

        getStringValueFromPrefs(this, "key")?.apply {
            Log.i("SHARED PREF", this)
        }


    }
}
