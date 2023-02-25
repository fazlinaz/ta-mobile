package com.example.exampleproject.api;

import com.example.exampleproject.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterfaces {

    @FormUrlEncoded
    @POST("api/register")
    Call<ResponseLogin> dataRegister(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_comfirmation") String password_comfirmation
    );

    @FormUrlEncoded
    @POST("api/login")
    Call<ResponseLogin> dataLogin(
            @Field("email") String email,
            @Field("password") String password
    );



}
