package com.example.anais.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CDAdapter extends ArrayAdapter<CD>{

    private final ArrayList<CD> lista;
    private final LayoutInflater inflador;

    public CDAdapter(Context context, ArrayList<CD> lista) {
        super(context,R.layout.activity_cdadapter, lista);
        this.lista = lista;
        inflador = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder holder;
        if (v == null) {
            v = inflador.inflate(R.layout.activity_cdadapter, parent, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        }
        else {
            holder = (ViewHolder) v.getTag();
        }
        onBindViewHolder(holder, position);
        return v;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        CD cd = lista.get(position);
        holder.bind(cd);
    }

    static class ViewHolder {

        private  final  TextView tvGrupo, tvNCD, tvACD;
        private  final  ImageView ivCD;

        // El constructor recibe la vista-fila.
        public ViewHolder(View itemView) {
            tvGrupo = (TextView) itemView.findViewById(R.id.tvGrupo);
            tvNCD = (TextView) itemView.findViewById(R.id.tvNCD);
            tvACD = (TextView) itemView.findViewById(R.id.tvACD);
            ivCD = (ImageView) itemView.findViewById(R.id.ivCD);
        }

        // Escribe los datos del Jugador en las vistas.
        public void bind(CD cd) {
            tvNCD.setText(cd.getDisco());
            tvGrupo.setText(cd.getNombre());
            tvACD.setText(cd.getAno()+"");
            ivCD.setImageResource(cd.getImagen());

        }
    }
}


