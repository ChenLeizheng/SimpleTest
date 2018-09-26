package com.lei.bindview;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.data.ByteArrayFetcher;
import com.lei.bindview.databinding.LayoutActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.layout_activity_main);
        User user = new User("zn", "25","http://www.landleafservice.cn:8080/pics/icon_cloudy.png");
        Progress progress = new Progress(20, 0, 36, Color.GREEN, "优");
        activityMainBinding.setUser(user);
        activityMainBinding.setProgress(progress);
    }

    @Override
    protected int setLayoutID() {
        return R.layout.layout_activity_main;
    }

    @BindingAdapter("imageUrl")
    public static void bindImage(ImageView imageView, String url){
        Log.d("ImageLoadAdaptersss", url);
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }
}
