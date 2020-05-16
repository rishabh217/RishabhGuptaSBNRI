package com.rishabhgupta.sbnri.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRetrofit {

    private static final String BASE_URL="https://api.github.com/orgs/octokit/";
    private static DataRetrofit dataRetrofit;
    private Retrofit retrofit;

    private DataRetrofit () {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized DataRetrofit getInstance(){
        if (dataRetrofit == null){
            dataRetrofit = new DataRetrofit();
        }
        return dataRetrofit;
    }

    public DataApi getDataApi(){
        return retrofit.create(DataApi.class);
    }
}
