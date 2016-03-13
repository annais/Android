package com.example.anais.puntosturisticos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaAdapter extends ArrayAdapter<Sitio>  {

    private final ArrayList<Sitio> lista;
    private final LayoutInflater inflador;
    private TextView nombre, descripcion;
    private ImageView imagen;

    public ListaAdapter(Context context, ArrayList<Sitio> lista) {
        super(context,R.layout.activity_lista_adapter, lista);
        this.lista = lista;
        inflador = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflador.inflate(R.layout.activity_lista_adapter, parent, false);
        getVistas(v);
       /* v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),
                        "",Toast.LENGTH_LONG).show();
            }
        });*/
        imagen.setBackgroundResource(lista.get(position).getImagen());
        nombre.setText(lista.get(position).getNombre());
        descripcion.setText(lista.get(position).getBreveDescripción());


        return v;
    }

    private void getVistas(View v) {
        nombre = (TextView) v.findViewById(R.id.tvNombre);
        imagen = (ImageView) v.findViewById(R.id.ivSitio);
        descripcion = (TextView) v.findViewById(R.id.tvDescripcion);
    }



}
