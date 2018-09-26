package com.simpletest.rxjava;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {

    private Disposable mDisposable;
    Fragment[] mFragmenet = new Fragment[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.tv);
        final Button btTof2 = findViewById(R.id.btTof2);
        final Button btTest = findViewById(R.id.btTest);
//        test();

//        useConsumer();
        //隔多少时间重复发送
//        rxJava(tv);
        mFragmenet[1] = new Fragment1();
        mFragmenet[0] = new Fragment2();

        replaceFragment(0);
        btTof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(1);
                EventBus.getDefault().post(new TxtEvent("kao"));
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBg(btTof2);
                setBg(btTest);
            }
        });
    }

    public void setBg(Button bt){
        bt.setBackgroundResource(R.drawable.bg_psw_button_pressed);
    }

    public void replaceFragment(int index){
        getFragmentManager().beginTransaction()
                .replace(R.id.flMain,mFragmenet[index])
                .commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getText(TxtEvent text){
        Log.d("MainActivity", "text:" + text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void rxJava(final TextView tv) {
        mDisposable = Observable.interval(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("MainActivity", "timer" + aLong);
                    }
                });

        //延时发送
        Disposable disposable = Single.timer(10, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        tv.setVisibility(View.INVISIBLE);
                    }
                });
    }

    private void test() {
        Observable.create(new ObservableOnSubscribe<Long>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Long> e) throws Exception {
                e.onNext(-1L);
            }
        }).subscribeOn(Schedulers.io())
                .flatMap(new Function<Long, ObservableSource<Long>>() {
                    @Override
                    public ObservableSource<Long> apply(@NonNull Long aLong) throws Exception {
                        Log.d("MainActivity", "flatMap:" + aLong);
                        return Observable.interval(10, TimeUnit.SECONDS);
                    }
                }).subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("MainActivity", "subscribe:" + aLong);
                    }
                });
    }


    /**
     * Consumer只接收上游发送的onNext事件
     * subscribeOn(Schedulers.io())为Observable被观察者(上游发数据)所在的线程
     */
    private void useConsumer() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.d("MainActivity", "emitter");
                e.onNext(0);
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("MainActivity", "onNext: " + integer);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable!=null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }
}
