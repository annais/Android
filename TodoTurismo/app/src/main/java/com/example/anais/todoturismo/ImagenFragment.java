package com.example.anais.todoturismo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ImagenFragment extends Fragment {

    private Sitio sitio;
    private ImageView imagen;
    private TextView nombre;

    public ImagenFragment(Sitio sitio) {
       this.sitio = sitio;
    }

    private OnSitioSelectedListener mListener;

    public interface OnSitioSelectedListener {
        public void onImgSelected(Sitio sitio);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_imagen, container, false);
        imagen = (ImageView) v.findViewById(R.id.ivImagenMax);
        nombre = (TextView) v.findViewById(R.id.tvImgNombre);

        Picasso.with(getActivity()).load(sitio.getImagen()).into(imagen);
        nombre.setText(sitio.getNombre());

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSitioSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
