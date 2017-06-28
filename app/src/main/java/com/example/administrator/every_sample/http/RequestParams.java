package com.example.administrator.every_sample.http;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 类型：@Multipart
 * 用于POST的请求，得到Map<key, value>
 * Created by Administrator on 2016/8/29.
 */
public class RequestParams {


    private Map<String, RequestBody> params;

    public Map<String, RequestBody> getParams() {
        return params;
    }
    public RequestParams() {
        params = new HashMap<>();
    }

    public RequestParams addParams(String key, String value){
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), value);
        params.put(key, requestBody);
        return this;
    }

    public RequestParams addParams(String key, List<Object> list){//key:[value1, value2, value3]
        for (int i = 0; i < list.size(); i++) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), list.get(i).toString());
            params.put(key + "["+ i +"]", requestBody);
        }
        return this;
    }

    public RequestParams addFileParams(String key, File file){
//        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), value);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        params.put(key + "\"; filename=\""+file.getName()+"", requestBody);
        return this;
    }
}
