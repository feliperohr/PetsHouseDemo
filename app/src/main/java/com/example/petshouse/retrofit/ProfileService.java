package com.example.petshouse.retrofit;


import com.example.petshouse.model.dto.ProfileDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProfileService {

    @POST("profile")
    Call<ProfileDTO> register(@Body ProfileDTO person);

    @GET("profile/{id}")
    Call<ProfileDTO> getById(@Path("id") long id);
}
