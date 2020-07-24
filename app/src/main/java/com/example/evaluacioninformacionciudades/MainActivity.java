package com.example.evaluacioninformacionciudades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.evaluacioninformacionciudades.Adaptadores.AdaptadorRecycler;
import com.example.evaluacioninformacionciudades.Model.Model;
import com.example.evaluacioninformacionciudades.Retrofit.PaisesNomRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retro = new Retrofit.Builder().baseUrl(" https://restcountries.eu/").addConverterFactory(GsonConverterFactory.create()).build();

        PaisesNomRetrofit paisesNomRetrofit= retro.create(PaisesNomRetrofit.class);

        Call<Model> call=paisesNomRetrofit.getPaisesNomRetrofit();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                Model model=response.body();
                Model.Modelo[] listapaises= model.getModel();
                recy=(RecyclerView) findViewById(R.id.recyViewPaises);
                LinearLayoutManager llm= new LinearLayoutManager(getApplicationContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                recy.setLayoutManager(llm);
                AdaptadorRecycler adaptador = new AdaptadorRecycler(listapaises);
                recy.setAdapter(adaptador);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error," +t.toString(),Toast.LENGTH_LONG).show();
            }
        });



    }
}