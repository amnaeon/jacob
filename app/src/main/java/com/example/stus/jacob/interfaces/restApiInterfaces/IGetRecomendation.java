package com.example.stus.jacob.interfaces.restApiInterfaces;

import com.example.stus.jacob.models.RecomendtionModel;

import java.util.List;

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
    Call<List<RecomendtionModel>> getRecomendation(
            @Path("userID") int userID);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jacob-bot.herokuapp.com:37801/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
