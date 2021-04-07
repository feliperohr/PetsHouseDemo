package com.example.petshouse.retrofit;

import com.example.petshouse.model.dto.CustomerDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PetOwnerService {

    @POST("customer/petOwner/new")
    Call<Void> register(@Body CustomerDTO person);

    @POST("customer/petOwner/login")
    Call<CustomerDTO> login(@Body CustomerDTO person);

    @GET("customer/petOwner/{id}")
    Call<CustomerDTO> getById(@Path("id") long id);
}
