package com.example.anais.basketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class EstadisticasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        getVistas();

    }

    // Obtiene e inicializa las vistas.
    private void getVistas() {
        ListView lstJugadores = (ListView) this.findViewById(R.id.lstJugadoresh);
        // Se crea el adaptador y se asigna a la lista.
        lstJugadores.setAdapter(new JugadoresAdapter(this, MainActivity.jugadoresh));

        lstJugadores = (ListView) this.findViewById(R.id.lstJugadoresg);
        // Se crea el adaptador y se asigna a la lista.
        lstJugadores.setAdapter(new JugadoresAdapter(this, MainActivity.jugadoresg));

    }

}
