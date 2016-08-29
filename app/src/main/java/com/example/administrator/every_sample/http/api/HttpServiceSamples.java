package com.example.administrator.every_sample.http.api;

import com.example.administrator.every_sample.bean.BaseBean;
import com.example.administrator.every_sample.bean.MovieBean;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface HttpServiceSamples {

    //登陆请求
    @Multipart
    @POST("/service/auth")
    Observable<BaseBean<String>> DtLogin(
            @PartMap Map<String, RequestBody> params
            );

    //普通GET请求
    @GET("top250")
    Call<MovieBean> getMovie(
            @Query("key0")int value0,
            @Query("key1")int value1
    );

    //POST普通表单提交
    @FormUrlEncoded
    @POST("user")
    Observable<BaseBean<String>> login(
            @Field("key0")String value0,
            @Field("key1")String value1
    );

    //文件上传
    @Multipart
    @POST("user")
    Observable<BaseBean<String>> upload(
            @Part("key\"; filename=\"valuename.png")RequestBody body//构造出RequestBody作为value
    );

    //POST多参数、数组提交
    @Multipart
    @POST("user")
    Observable<BaseBean<String>> array_post(
            /**
             * key: String
             * value:把value用RequestBody包装放到Map中
             */
            @PartMap Map<String, RequestBody> map
    );


    //POST多参数、Json提交
    @Multipart
    @POST("/service/auth")
    Observable<BaseBean<String>> json(
            @Query("key") String key,
            @Part("json")RequestBody body
            );


}
