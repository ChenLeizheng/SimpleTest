package com.lei.simpletest.retrofit;

import com.lei.simpletest.retrofit.bean.Catalog;
import com.lei.simpletest.retrofit.bean.Note;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Lei on 2018/7/19.
 */

public interface XmlService {
    @GET("note.asp")
    Observable<Note> getNoteMsg();
    @GET("note.asp")
    Call<Note> getNote();

    @GET("cd_catalog.xml")
    Observable<Catalog> getCDs();

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("item/okhttp/20447138?fr=aladdin")
    Call<Note> postNote(@Body RequestBody route);
}
