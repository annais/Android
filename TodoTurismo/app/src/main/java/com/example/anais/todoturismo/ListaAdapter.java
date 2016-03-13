package com.example.anais.todoturismo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ListaAdapter extends ArrayAdapter<Sitio> {

    private final ArrayList<Sitio> lista;
    private final LayoutInflater inflador;
    private TextView nombre, descripcion;
    private ImageView imagen;

    public ListaAdapter(Context context, ArrayList<Sitio> lista) {
        super(context,R.layout.activity_list_adapter, lista);
        this.lista = lista;
        inflador = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflador.inflate(R.layout.activity_list_adapter, parent, false);
        getVistas(v);

       Picasso.with(getContext()).load(lista.get(position).getImagen()).into(imagen);


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
