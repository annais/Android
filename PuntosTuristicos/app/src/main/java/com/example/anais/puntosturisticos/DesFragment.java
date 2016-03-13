package com.example.anais.puntosturisticos;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DesFragment extends Fragment {

    ImageView imagen;
    TextView nombre, descripcion;
    Sitio sitio;


    public DesFragment(Sitio sitio) {
        this.sitio=sitio;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_des, container, false);

        getVistas(view);

        return view;
    }

    private void getVistas(View v) {
        nombre = (TextView) v.findViewById(R.id.tvNombre);
        descripcion = (TextView) v.findViewById(R.id.tvDescripcion);
        imagen = (ImageView) v.findViewById(R.id.ivSitio);

        nombre.setText(sitio.getNombre());
        descripcion.setText(sitio.getDescripción());
        imagen.setBackgroundResource(sitio.getImagen());
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
