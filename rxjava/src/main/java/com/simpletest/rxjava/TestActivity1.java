package com.simpletest.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by Lei on 2018/5/8.
 */

public class TestActivity1 extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TestActivity1", "onCreate");
        Button btToTest2 = findViewById(R.id.btTof2);
        btToTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity1.this,TestActivity2.class));
            }
        });
    }

    @Override
    public void getText(TxtEvent text) {
        super.getText(text);
        Log.d("TestActivity1", text.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TestActivity1", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TestActivity1", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TestActivity1", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TestActivity1", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TestActivity1", "onDestroy");
    }
}
