package com.example.christian.adminsportec.io;

import com.example.christian.adminsportec.Models.Juego;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SportecApiService {
    @GET("https://sportec1.herokuapp.com/resultado/{id}")
    Call<Juego> getResultadpsById(@Path("id") int id);

    @PUT("https://sportec1.herokuapp.com/resultado/{id}")
    @FormUrlEncoded
    Call<Juego> updatePost(@Path("id") int id,
                           @Field("marcador1") String marcador1,
                            @Field("marcador2") String marcador2,
                            @Field("resultado") String resultado,
                            @Field("fecha") String fecha,
                            @Field("equipo1_nombre") String equipo1_nombre,
                            @Field("equipo2_nombre") String equipo2_nombre,
                            @Field("deporte_id") int deporte_id,
                            @Field("iniciado") int iniciado,
                            @Field("set_actual") String set_actual);

}
