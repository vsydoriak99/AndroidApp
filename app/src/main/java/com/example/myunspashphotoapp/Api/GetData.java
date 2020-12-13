package com.example.myunspashphotoapp.Api;


import com.example.myunspashphotoapp.models.ListPhotos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetData {


    static final String  client_id = "jdtlYDWNT6TZ-f08cWgjH88o86zx4cKHr-Dhc-ODSAg";
    @GET("search/photos")
    Call<ListPhotos> getPhotos(@Query("query")String name, @Query("client_id")String client_id, @Query("page") int pageIndex);
}
