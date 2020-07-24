package com.example.evaluacioninformacionciudades.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.evaluacioninformacionciudades.Model.Model;
import com.example.evaluacioninformacionciudades.R;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolderDatos> {

    ArrayList<Model> listaPaises;
    Activity activity;
    RequestOptions opcion;

    public AdaptadorRecycler(ArrayList<Model> listaPaises, Activity activity) {
        this.listaPaises = listaPaises;
        this.activity = activity;
        opcion=new RequestOptions().centerCrop().placeholder(R.drawable.fondoimagen).error(R.drawable.fondoimagen);
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.galeriapaises,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolderDatos holder, int position) {
        holder.txtNombre.setText(listaPaises.get(position).getName());

        Glide.with(holder.itemView).load("//www.geognos.com/api/en/countries/flag/"+listaPaises.get(position).getAlpha2Code()+".png").into(holder.Foto);

        //http://www.geognos.com/api/en/countries/flag/{alpha2code}.png

    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView txtNombre;
        ImageView Foto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtNombre=itemView.findViewById(R.id.NomPais);
            Foto=itemView.findViewById(R.id.imgFoto);
        }
    }
}
