package com.example.administrator.every_sample.http;

import com.example.administrator.every_sample.bean.BaseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface HttpService {

    @GET("top250")
    Call<BaseBean> login(
            @Query("start") int start,
            @Query("count") int count);
}
