package com.bawei.liang20190218.model.util;

import android.os.Handler;
import android.os.Message;

import com.bawei.liang20190218.model.bean.JsonBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 08:50:19
 * @Description:
 */
public class HttpUtils<T> {
    public static HttpUtils httpUtils;
    private CallBackData callBackData;

    public void setCallBackData(CallBackData callBackData) {
        this.callBackData = callBackData;
    }

    private HttpUtils(){}
    public static HttpUtils getInstance(){
        if(httpUtils==null){
            httpUtils=new HttpUtils();
            return httpUtils;
        }else{
            return httpUtils;
        }
    }

    public void getData(String path, final Class<T> tClass){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder=new Request.Builder();
        Request request = builder.url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBackData.Err(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                T t = gson.fromJson(string, tClass);
                Message message=new Message();
                message.obj=t;
                handler.sendMessage(message);
            }
        });
    }
    public void postData(String path,String name,String pwd){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    public interface CallBackData<D>{
        void Err(IOException e);
        void Sueesmea(D d);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T t= (T) msg.obj;
            callBackData.Sueesmea(t);
        }
    };
}
