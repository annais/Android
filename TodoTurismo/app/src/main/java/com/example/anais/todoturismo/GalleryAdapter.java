package com.example.anais.todoturismo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Sitio> lista = MainActivity.sitios;
    private ImageView image;
    private Bitmap bitmap;
    private final LayoutInflater inflador;
    private TextView nombre;

    public GalleryAdapter(Context c) {// ArrayList<Sitio> lista
        //super(c,R.layout.gallery_adapter, lista);
        mContext = c;
        //this.lista = lista;
        inflador = LayoutInflater.from(c);
    }

    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = inflador.inflate(R.layout.gallery_adapter, parent, false);
        nombre = (TextView) convertView.findViewById(R.id.tvNombreImg);
        image = (ImageView) convertView.findViewById(R.id.img);
        Picasso.with(mContext).load(lista.get(position).getImagen()).into(image);
        nombre.setText(lista.get(position).getNombre());

        return convertView;
    }



}