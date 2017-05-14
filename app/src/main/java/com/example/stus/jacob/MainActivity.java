package com.example.stus.jacob;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stus.jacob.managers.UiManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiManager.getInstance().init(this);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        if(preferences.getString(Const.USER_CONST.USER_ID,"").equals("")){
            Editor editor = preferences.edit();
            editor.putString(Const.USER_CONST.USER_ID,"158074167");
            editor.putString(Const.USER_CONST.CHAT_ID,"243254455");
            editor.putString(Const.USER_CONST.USER_NAME,"temp temp");
            editor.commit();
        }
        UiManager.showMainFragment();
    }
}
