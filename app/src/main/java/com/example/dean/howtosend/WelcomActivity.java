package com.example.dean.howtosend;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by dean on 2015/8/7.
 */


public class WelcomActivity extends Activity {
    private boolean isFirstIn = false;
    private static final int TIME = 1300;
    private static final int GO_HOME = 1000;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();

    }

    private void goHome(){
        Intent i = new Intent(WelcomActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }


    private void init(){
        SharedPreferences perPreferences = getSharedPreferences("dean",MODE_PRIVATE);
        isFirstIn = perPreferences.getBoolean("isFirstIn",true);

        System.out.println(isFirstIn);

        if(isFirstIn){
            SharedPreferences.Editor editor =  perPreferences.edit();    //取得编辑
            editor.putBoolean("isFirstIn",false);
            mHandler.sendEmptyMessageDelayed(GO_HOME,TIME);
        }
    }
}
