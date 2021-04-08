package com.example.petshouse.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public PetOwnerService getPetOwnerService() {
        return retrofit.create(PetOwnerService.class);
    }

    public PetSitterService getPetSitterService() {
        return retrofit.create(PetSitterService.class);
    }

    public ProfileService getProfileService() {
        return retrofit.create(ProfileService.class);
    }

    public TaskService getTaskService() {
        return retrofit.create(TaskService.class);
    }


}
