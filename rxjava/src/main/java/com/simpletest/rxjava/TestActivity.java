package com.simpletest.rxjava;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lei on 2018/8/29.
 */

public class TestActivity extends Activity {

    int currentTemp = 0;
    boolean flag = true;
    Handler mHandler = new Handler();
    Fragment[] mFragmenet = new Fragment[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmenet[1] = new Fragment1();
        mFragmenet[0] = new Fragment2();
        Button btTof2 = findViewById(R.id.btTof2);
        Button btTest = findViewById(R.id.btTest);
        Button btSend = findViewById(R.id.btSend);
        replaceFragment(0);

        btTof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(0);
            }
        });

        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(1);
            }
        });

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new TxtEvent("It's not ok!"));
            }
        });
    }

    public void replaceFragment(int index){
        getFragmentManager().beginTransaction()
                .replace(R.id.flMain,mFragmenet[index])
                .commit();
    }
}
