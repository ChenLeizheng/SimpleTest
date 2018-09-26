package com.simpletest.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by Lei on 2018/5/8.
 */

public class TestActivity2 extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TestActivity2", "onCreate");
        Button btToTest2 = findViewById(R.id.btTof2);
        btToTest2.setOnClickListener(l->{
            EventBus.getDefault().post(new TxtEvent("22222222"));
        });
        ActivityManage.getInstance().printList();
        Activity topActivity = ActivityManage.getInstance().getTopActivity();
        Log.d("TestActivity2", "topActivity == this:" + (topActivity == this));
    }

    @Override
    public void getText(TxtEvent text) {
        super.getText(text);
        Log.d("TestActivity2", text.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TestActivity2", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TestActivity2", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TestActivity2", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TestActivity2", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TestActivity2", "onDestroy");
    }
}
