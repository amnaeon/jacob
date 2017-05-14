package com.example.stus.jacob.interfaces.restApiInterfaces;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by stus on 14.05.17.
 */

public interface IGetRecomendation {
    @POST("addUser/{userID}")
    Call<String> addText(
            @Path("userID") String userID);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:9000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
