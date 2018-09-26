package com.simpletest.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Lei on 2018/5/8.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManage.getInstance().addActivity(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getText(TxtEvent text){
        if (ActivityManage.getInstance().getTopActivity()==this){
            Log.d("BaseActivity", "getText");
            DialogUtils.showPwdDialog(this, this, new DialogClickCallback() {
                @Override
                public void sureClicked(String msg) {
                    Log.d("TestActivity1", "msg");
                }

                @Override
                public void cancelClicked() {

                }
            });
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManage.getInstance().deleteActivity(this);
        EventBus.getDefault().unregister(this);
    }
}
