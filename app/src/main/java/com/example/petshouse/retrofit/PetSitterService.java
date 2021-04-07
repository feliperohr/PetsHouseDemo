package com.example.petshouse.retrofit;

import com.example.petshouse.model.dto.CustomerDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PetSitterService {

    @POST("customer/petSitter/new")
    Call<Void> register(@Body CustomerDTO person);

    @POST("customer/petSitter/login")
    Call<CustomerDTO> login(@Body CustomerDTO person);

    @GET("customer/petSitter/{id}")
    Call<CustomerDTO> getById(@Path("id") long id);
}
