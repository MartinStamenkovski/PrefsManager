package com.stamenkovski.prefsmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PrefsManager.setValueToPrefs(this, "key", new User("d", "d"));

        Log.i("USER SECOND ", PrefsManager.getValueFromPrefs(this, "key", User.class).toString());

        List<User> users = new ArrayList<User>();
        users.add(new User("USERMAIL", "Nmae"));
        users.add(new User("MAILUSER", "nameuser"));

        PrefsManager.setValueToPrefs(this, "users", users);

        Log.i("USER SECOND ", PrefsManager.getValueFromPrefs(this, "users", List.class).toString());
    }
}
