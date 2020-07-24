package com.example.evaluacioninformacionciudades.Retrofit;

import com.example.evaluacioninformacionciudades.Model.Model;

import retrofit2.Call;
import retrofit2.http.GET;



public interface PaisesNomRetrofit {
    @GET("rest/v2/all")
    Call<Model> getPaisesNomRetrofit();
}
