package com.example.stus.jacob.interfaces.restApiInterfaces;

import com.example.stus.jacob.models.RecomendationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by stus on 14.05.17.
 */

public interface ISendRecomendation {
    @POST("setRecomendation/{userID}/{wordIds}")
    Call<List<RecomendationModel>> sendRecomendation(
            @Path("userID") int userID,
            @Path("wordIds") List<String> wordIds);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jacob-bot.herokuapp.com:80/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
