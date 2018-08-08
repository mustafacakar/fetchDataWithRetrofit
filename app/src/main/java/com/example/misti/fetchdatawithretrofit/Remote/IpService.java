package com.example.misti.fetchdatawithretrofit.Remote;

import com.example.misti.fetchdatawithretrofit.Model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {

    @GET("/")
    Call<Ip> getIp();
}
