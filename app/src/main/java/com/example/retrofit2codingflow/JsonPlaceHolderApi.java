package com.example.retrofit2codingflow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JsonPlaceHolderApi {

    @Headers("Content-Type: application/json")
    @GET("workers") //relative url
    Call<Post> getPost();

}
