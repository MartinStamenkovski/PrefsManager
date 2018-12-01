package com.stamenkovski.prefsmanager_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.stamenkovski.prefsmanager.PrefsManager;
import com.stamenkovski.prefsmanager.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PrefsManager.removeValueFromPrefs(this, "user");

        PrefsManager.setValueToPrefs(this, "user", new User("user@example.com", "John Doe"));

        List<User> users = new ArrayList<User>();
        users.add(new User("USERMAIL", "Nmae"));
        users.add(new User("MAILUSER", "nameuser"));

        PrefsManager.setValueToPrefs(this, "users", users);

        //Log.i("USER LISTS SECOND ", PrefsManager.getValueFromPrefs(this, "users", User[].class).toString());
        Log.i("USER SECOND ", PrefsManager.getValueFromPrefs(this, "user", User.class).toString());

        //PrefsManager.removeValueFromPrefs(this,"user_key");
    }
}
