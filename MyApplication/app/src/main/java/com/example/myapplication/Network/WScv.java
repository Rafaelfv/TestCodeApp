package com.example.myapplication.Network;

import com.example.myapplication.Models.Response.ResponseInfoCv;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface WScv {


    @Headers({"Accept: application/json", "Connection: close"})
    @GET("master/cv.json")
    Call<ResponseInfoCv> getInfoCv();
}
