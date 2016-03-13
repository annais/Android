package com.example.anais.todoturismo;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;


public class DesFragment extends Fragment {

    ImageView imagen;
    TextView nombre, descripcion, horario, precio, tlf, direcion;
    Sitio sitio;
    Bitmap bitmap;

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
        horario = (TextView) v.findViewById(R.id.tvHorario);
        precio = (TextView) v.findViewById(R.id.tvPrecio);
        tlf = (TextView) v.findViewById(R.id.tvTlf);
        direcion = (TextView) v.findViewById(R.id.tvDirecion);

        nombre.setText(sitio.getNombre());
        descripcion.setText(sitio.getDescripcion());
        horario.setText(sitio.getHorario());
        precio.setText("Precio: "+sitio.getPrecio());
        tlf.setText("Tlf: "+sitio.getTlf());
        direcion.setText("Dirección: "+sitio.getDirecion());
        new LoadImage().execute(sitio.getImagen());
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap img) {

            if(img != null){
                imagen.setImageBitmap(img);
                //pDialog.dismiss();

            }
        }
    }

}
