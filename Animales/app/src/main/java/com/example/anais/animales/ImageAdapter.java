package com.example.anais.animales;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.String.format;

public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Animal> lista;

    public ImageAdapter(Context c, ArrayList<Animal> lista) {
        mContext = c;
        this.lista = lista;
    }

    public int getCount() {
        return lista.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setId(R.id.ivAnimal);
            imageView.setLayoutParams(new GridView.LayoutParams(280, 280));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(lista.get(position).getImagen());
        } else {
            imageView = (ImageView) convertView;
        }

        return imageView;
    }

}
