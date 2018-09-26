package com.lei.simpletest.retrofit;

import com.lei.simpletest.retrofit.bean.ResponseWeather;
import com.lei.simpletest.retrofit.bean.WuxiHongdou;
import com.lei.simpletest.retrofit.bean.Yinchaun;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Lei on 2017/12/26.
 */

public interface WeatherService {
    @POST("Langshi/ds/android/weather4")
    Call<ResponseWeather> getWeather(@Body String deviceId);

    @POST("Langshi/ds/android/weather4")
    Observable<ResponseWeather> getRxjavaWeather(@Body String devicedId);

    @GET("WechatService/ds/air/yinchuan/xiyuntai")
    Observable<Yinchaun> getServiceData();

    @GET("WechatService/air/wuxi/hongdou")
    Observable<WuxiHongdou> getWuxiData();
}
