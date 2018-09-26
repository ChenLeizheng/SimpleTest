package com.simpletest.rxjava;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Lei on 2018/4/17.
 */

public class Fragment2 extends Fragment{

    private TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        textview = view.findViewById(R.id.textview);
        textview.setText("22222");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Log.d("Fragment2", "onStart");
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        Log.d("Fragment2", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment2", "onDestroy");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getText(TxtEvent text){
        Log.d("Fragment2", "text:" + text);
        textview.setText(text.toString());
    }
}
