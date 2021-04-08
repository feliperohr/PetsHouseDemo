package com.example.petshouse.retrofit;

import com.example.petshouse.model.dto.ProfileDTO;
import com.example.petshouse.model.dto.TaskDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TaskService {

    @POST("task")
    Call<Void> register(@Body TaskDTO taskDTO);

    @GET("task")
    Call<TaskDTO> getAll();

    @GET("task/{id}")
    Call<TaskDTO> getById(@Path("id") long id);

    @GET("task/filter/{filter}")
    Call<TaskDTO> getByFilter(@Path("filter") String filter);

}
