package com.lei.simpletest.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.lei.simpletest.retrofit.bean.ResponseWeather;
import com.lei.simpletest.retrofit.bean.WuxiHongdou;
import com.lei.simpletest.retrofit.bean.Yinchaun;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    public static final String path = "http://115.28.66.148:8080/Langshi/ds/android/weather4";
    public static final String BaseUrl = "http://115.28.66.148:8080/";
    public static final String BaseUrl1 = "http://www.landleaf-tech.cn/";
    public static final String yinchuan = "http://www.landleafservice.cn:8080/WechatService/ds/air/yinchuan/xiyuntai";
    public static final String hongdou = "http://www.landleaf-tech.cn/WechatService/air/wuxi/hongdou";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        byOkHttp();
//        byRetrofit();
//        byRxjavaRetrofit();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        final Request request = new Request.Builder()
//                .url(hongdou)
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("MainActivity", e.toString());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                Log.d("MainActivity", result);
//            }
//        });

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BaseUrl1)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        WeatherService service = retrofit.create(WeatherService.class);
//        service.getWuxiData()
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Consumer<WuxiHongdou>() {
//                    @Override
//                    public void accept(WuxiHongdou yinchaun) throws Exception {
//                        Log.d("MainActivity", "yinchaun:" + yinchaun);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.d("MainActivity", "throwable:" + throwable);
//                    }
//                });
    }

    private void byRxjavaRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // 针对rxjava2.x
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        service.getRxjavaWeather("")
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseWeather>() {
                    @Override
                    public void accept(ResponseWeather responseWeather) throws Exception {
                        Log.d("MainActivity", "responseWeather:" + responseWeather);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("MainActivity", throwable.toString());
                    }
                });
    }

    /**
     * Retrofit传入对象内部转换response为对应的JavaBean
     * 引入Gson支持
     */
    private void byRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        retrofit2.Call<ResponseWeather> weather = weatherService.getWeather("");
        weather.enqueue(new retrofit2.Callback<ResponseWeather>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseWeather> call, retrofit2.Response<ResponseWeather> response) {
                ResponseWeather body = response.body();
                Log.d("MainActivity", body.toString());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseWeather> call, Throwable t) {
                Log.d("MainActivity", "onFailure");
            }
        });
    }

    /**
     * OkHttp拿到的是response.body().string()字符串，需要自行调用Gson转为JavaBean
     */
    private void byOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(path)
                .post(RequestBody.create(null,"body"))
                .build();

//        Request request = new Request.Builder()
//                .url("http://www.w3school.com.cn/xml/note.asp")
//                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("MainActivity", "onFailure"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.d("MainActivity", result);
            }
        });
    }


    private void byTest(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BaseUrl)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("MainActivity", response.body().toString());
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        retrofit2.Call<ResponseWeather> weather = weatherService.getWeather("");
        weather.enqueue(new retrofit2.Callback<ResponseWeather>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseWeather> call, retrofit2.Response<ResponseWeather> response) {
                ResponseWeather body = response.body();
                Log.d("MainActivity", "body.getWeatherModel():" + body.getWeatherModel());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseWeather> call, Throwable t) {

            }
        });


        Retrofit build = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        WeatherService weatherService1 = build.create(WeatherService.class);
        Observable<ResponseWeather> rxjavaWeather = weatherService1.getRxjavaWeather("");
        rxjavaWeather.subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseWeather>() {
                    @Override
                    public void accept(ResponseWeather responseWeather) throws Exception {
                        Log.d("MainActivity", responseWeather.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
