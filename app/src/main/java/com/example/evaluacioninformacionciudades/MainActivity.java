package com.example.evaluacioninformacionciudades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.evaluacioninformacionciudades.Adaptadores.AdaptadorRecycler;
import com.example.evaluacioninformacionciudades.Model.Model;
import com.example.evaluacioninformacionciudades.Retrofit.PaisesNomRetrofit;
import com.example.evaluacioninformacionciudades.WebService.Asynchtask;
import com.example.evaluacioninformacionciudades.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://restcountries.eu/rest/v2/all",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    ArrayList<Model> lsModel = new ArrayList<Model> ();
    @Override
    public void processFinish(String result) throws JSONException {

        try {
            JSONArray JSONlistaRestaurants= new JSONArray(result);
            lsModel = Model.JsonObjectsBuild(JSONlistaRestaurants);

            //agregar datos al recyclerView
            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyViewPaises);
            recyclerView.setLayoutManager(new GridLayoutManager(this,3));

            AdaptadorRecycler adapter= new AdaptadorRecycler(lsModel);
            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    //Bundle pasar= new Bundle();
                    //pasar.putString("Mensaje", "Login Exitoso!");
                   // pasar.putString("Codi3", lsModel.get(recyclerView.getChildAdapterPosition(v)).getAlpha3Code());
                  //  intent.putExtras(pasar);
                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}