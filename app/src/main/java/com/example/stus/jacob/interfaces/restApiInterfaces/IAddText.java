package com.example.stus.jacob.interfaces.restApiInterfaces;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by stus on 14.05.17.
 */

public interface IAddText {
    @POST("addUser/{text}/{userID}/{chatID}/{userName}")
    Call<String> addText(
            @Path("text") String text,
            @Path("userID") String userID,
            @Path("chatID") String chatID,
            @Path("userName") String userName);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jacob-bot.herokuapp.com:37801/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
