package com.example.evaluacioninformacionciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.evaluacioninformacionciudades.Model.Model;
import com.example.evaluacioninformacionciudades.Retrofit.PaisesNomRetrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retro = new Retrofit.Builder().baseUrl(" https://restcountries.eu/").addConverterFactory(GsonConverterFactory.create()).build();

        PaisesNomRetrofit paisesNomRetrofit= retro.create(PaisesNomRetrofit.class);




    }
}