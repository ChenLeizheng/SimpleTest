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

public class Fragment1 extends Fragment{

    private TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        textview = view.findViewById(R.id.textview);
        return view;
    }
    public void replaceFragment(){
        getFragmentManager().beginTransaction()
                .replace(R.id.fl,new Fragment2())
                .commit();
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Log.d("Fragment1", "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        Log.d("Fragment1", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment1", "onDestroy");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getText(TxtEvent text){
        Log.d("Fragment1", "text:" + text);
        textview.setText(text.toString());
    }
}
