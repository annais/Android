package com.example.anais.basketball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class JugadoresAdapter extends ArrayAdapter<Jugador> {
    
        // Variables miembro.
        private final ArrayList<Jugador> Jugadores;
        private final LayoutInflater inflador;

        // Constructor.
        public JugadoresAdapter(Context contexto, ArrayList<Jugador> Jugadores) {
            super(contexto, R.layout.content_estadisticas, Jugadores);
            this.Jugadores = Jugadores;
            inflador = LayoutInflater.from(contexto);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            // Si no se puede reciclar.
            if (convertView == null) {
                // Se obtiene la vista-fila inflando el layout.
                convertView = inflador.inflate(R.layout.content_jugadores_adapter, parent, false);
                // Se crea el contenedor de vistas para la vista-fila.
                holder = new ViewHolder(convertView);
                // Se almacena el contenedor en la vista.
                convertView.setTag(holder);
            }
            // Si se puede reciclar.
            else {
                // Se obtiene el contenedor de vistas desde la vista reciclada.
                holder = (ViewHolder) convertView.getTag();
            }
            // Se escriben los datos en las vistas del contenedor de vistas.
            onBindViewHolder(holder, position);
            // Se retorna la vista que representa el elemento.
            return convertView;
        }

        // Cuando se deben escribir los datos en la vista del elemento.
    private void onBindViewHolder(ViewHolder holder, int position) {
        // Se obtiene el Jugador que debe mostrar el elemento.
        Jugador Jugador = Jugadores.get(position);
        // Se escriben los datos del Jugador en las vistas.
        holder.bind(Jugador);
    }

    // Contenedor de vistas para la vista-fila.
    static class ViewHolder {

        // El contenedor de vistas para un elemento de la lista contiene
        private final TextView tvCamiseta;
        private final TextView tvPuntos;

        // El constructor recibe la vista-fila.
        public ViewHolder(View itemView) {
            // Se obtienen las vistas de la vista-fila.
            tvCamiseta = (TextView) itemView.findViewById(R.id.tvCamiseta);
            tvPuntos = (TextView) itemView.findViewById(R.id.tvPuntos);
        }

        // Escribe los datos del Jugador en las vistas.
        public void bind(Jugador Jugador) {
            tvCamiseta.setText(Jugador.getCamiseta());
            tvPuntos.setText(Jugador.getPuntos()+"");

        }
    }

}
