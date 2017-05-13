package com.example.stus.jacob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stus.jacob.managers.UiManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiManager.getInstance().init(this);
        UiManager.showTempFragment();
    }
}
