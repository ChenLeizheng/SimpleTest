package com.lei.simpletest.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.TextView;

import com.lei.simpletest.retrofit.bean.Catalog;
import com.lei.simpletest.retrofit.bean.Note;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Lei on 2018/7/19.
 */

public class XmlActivity extends Activity {

    public static final String BaseUrl = "http://www.w3school.com.cn/xml/";
    public static final String BaseUrl1 = "https://www.w3cschool.cn/statics/demosource/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView content = findViewById(R.id.tv);
//        test1();
//        test2();
//        test3();
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
        sb.append("<content>");
        sb.append("<UID>");
        sb.append("C03FD56AC3240000");
        sb.append("</UID>");
        sb.append("<Expire>");
        sb.append("3000");
        sb.append("</Expire>");
        sb.append("</content>");
//        OkHttpClient okHttpClient = new OkHttpClient();
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml;charset=UTF-8"), sb.toString());
//        Request request = new Request.Builder().url("http://www.baidu.com/").post(requestBody).build();
//        okhttp3.Call call = okHttpClient.newCall(request);
//        call.enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                Log.d("XmlActivity", e.toString());
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//                Log.d("XmlActivity", "success");
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        XmlService xmlService = retrofit.create(XmlService.class);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml;charset=UTF-8"), sb.toString());
        Call<Note> call = xmlService.postNote(requestBody);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                Log.d("XmlActivity", "success");
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                Log.d("XmlActivity", t.toString());
            }
        });
//        try {
//            FileOutputStream fos = openFileOutput("msg_sb.xml", MODE_PRIVATE);
//            fos.write(sb.toString().getBytes());
//            fos.close();
//            Log.d("XmlActivity", "success");
//        } catch (IOException e) {
//            Log.d("XmlActivity", "fail");
//            e.printStackTrace();
//        }
    }

    private void test3() {
        //1获取序列化器
        XmlSerializer xmlSerializer = Xml.newSerializer();
        try {
            //openFileOutput获取一个私有文件 输出 若不存在就创建一个  data/data/files/gfs.xml
            FileOutputStream fos = openFileOutput("msg.xml", MODE_PRIVATE);

            //2设置输出的位置
            xmlSerializer.setOutput(fos, "utf-8");
            xmlSerializer.startDocument("utf-8", true);
            //开始根标签
            xmlSerializer.startTag(null, "content");
            xmlSerializer.startTag(null,"UID");
            xmlSerializer.text("C03FD56AC3240000");
            xmlSerializer.endTag(null,"UID");
            xmlSerializer.startTag(null,"Expire");
            xmlSerializer.text("3000");
            xmlSerializer.endTag(null,"Expire");
            //结束根标签
            xmlSerializer.endTag(null, "content");
            //结束文档
            xmlSerializer.endDocument();
            fos.close();
            Log.d("XmlActivity", xmlSerializer.toString());
        } catch (IOException e) {
            Log.d("XmlActivity", "failed");
            e.printStackTrace();
        }
    }

    private void test2() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl1)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        XmlService xmlService = retrofit.create(XmlService.class);
        xmlService.getCDs()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Catalog>() {
                    @Override
                    public void accept(Catalog catalog) throws Exception {
                        Log.d("XmlActivity", "catalog:" + catalog);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("XmlActivity", "throwable:" + throwable);
                    }
                });
    }

    private void test1() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        XmlService xmlService = retrofit.create(XmlService.class);
//        Call<Note> call = xmlService.getNote();
//        call.enqueue(new Callback<Note>() {
//            @Override
//            public void onResponse(Call<Note> call, Response<Note> response) {
//                Log.d("XmlActivity", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<Note> call, Throwable t) {
//                Log.d("XmlActivity", t.toString());
//            }
//        });
        xmlService.getNoteMsg()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Note>() {
                    @Override
                    public void accept(Note note) throws Exception {
                        Log.d("XmlActivity", note.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("XmlActivity", "throwable:" + throwable);
                    }
                });
    }
}
