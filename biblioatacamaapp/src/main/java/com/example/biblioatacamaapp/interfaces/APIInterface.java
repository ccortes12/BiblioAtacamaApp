package com.example.biblioatacamaapp.interfaces;

import com.example.biblioatacamaapp.models.Libro;
import com.example.biblioatacamaapp.models.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/books-")
    Call<List<Libro>> getListaLibros();

    @FormUrlEncoded
    @POST("/app/login")
    Call<User> validarCredenciales(@Field("username") String username, @Field("password") String password);

    @GET("/user/books")
    Call<List<Libro>> getlistaLibrosComprados(@Query("userId") int userId);
}
