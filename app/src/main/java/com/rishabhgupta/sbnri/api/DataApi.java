package com.rishabhgupta.sbnri.api;

import com.rishabhgupta.sbnri.model.Data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
//import retrofit2.http.Query;

public interface DataApi {
    @GET("repos?page=1&per_page=10")
    Call<ArrayList<Data>> getDataList();

}