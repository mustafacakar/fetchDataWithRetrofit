package com.example.misti.fetchdatawithretrofit;

import com.example.misti.fetchdatawithretrofit.Remote.IpService;
import com.example.misti.fetchdatawithretrofit.Remote.RetrofitClient;

public class Common {

    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService(){
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }
}
