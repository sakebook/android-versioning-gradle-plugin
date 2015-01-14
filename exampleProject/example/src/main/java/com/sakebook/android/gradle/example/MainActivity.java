package com.sakebook.android.gradle.example;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.text)).setText(BuildConfig.VERSION_NAME+"\n"+BuildConfig.VERSION_CODE);
    }
}
