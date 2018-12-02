package com.stamenkovski.prefsmanager_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.stamenkovski.prefsmanager.PrefsManager;
import com.stamenkovski.prefsmanager.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        List<User> users = new ArrayList<User>();
        users.add(new User("user@example.com", "user"));
        users.add(new User("johndoe@gmail.com", "John Doe"));

        PrefsManager.setObject(this, "users", users);

        Log.i("USERS ", PrefsManager.getObject(this, "users", new TypeToken<List<User>>() {
        }.getType()).toString());


        PrefsManager.setBooleanValue(this, "is_on", false);

        PrefsManager.getBooleanValue(this, "is_on", false);


    }
}
