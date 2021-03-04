package com.example.q_cube.retrofit;



import com.example.q_cube.model.FoodData;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();

}
