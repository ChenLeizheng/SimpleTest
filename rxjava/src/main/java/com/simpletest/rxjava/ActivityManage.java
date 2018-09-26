package com.simpletest.rxjava;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Lei on 2018/5/8.
 */

public class ActivityManage {
    private static ActivityManage instance = new ActivityManage();;

    private static ArrayList<Activity> activitys = new ArrayList<Activity>();;


    private ActivityManage() {

    }


    public static ActivityManage getInstance() {
        return instance;
    }


    public void addActivity(Activity activity) {
        activitys.add(activity);
    }


    public void deleteActivity(Activity activity) {
        activitys.remove(activity);
    }


    public void finishActivity() {
        for (Activity activity : activitys) {
            if (activity != null)
                activity.finish();
        }
    }

    public Activity getTopActivity() {
        return activitys.get(activitys.size() - 1);
    }

    public void printList() {
        for (Activity activity : activitys) {
            Log.d("ActivityManage", activity.toString());
        }
    }
}
