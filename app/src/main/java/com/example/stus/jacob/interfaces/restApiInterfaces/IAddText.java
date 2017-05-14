package com.example.stus.jacob.interfaces.restApiInterfaces;

import com.example.stus.jacob.models.requestModel.AddTextRequest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by stus on 14.05.17.
 */

public interface IAddText {
    @POST("addText/")
    Call<Object> addText( @Body AddTextRequest body);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jacob-bot.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
