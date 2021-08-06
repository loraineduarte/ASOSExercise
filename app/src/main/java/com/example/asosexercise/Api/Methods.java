package com.example.asosexercise.Api;

import com.example.asosexercise.Model.CompanyModel;
import com.example.asosexercise.Model.Launch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Methods {

    @GET("v3/info")
    Call<CompanyModel> getAllData();

    @GET("v3/launches")
    Call<List<Launch>> getAllLaunches();

    @GET("v3/launches")
    Call<List<Launch>> getFilterLaunchesByYear(@Query("launch_year") int yearInputText,
                                               @Query("order") String asc);

    @GET("v3/launches")
    Call<List<Launch>> getFilterLaunchesBySuccess(@Query("launch_success") boolean successButton,
                                                  @Query("order") String asc);

}
