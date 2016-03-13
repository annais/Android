package com.example.anais.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstMusic;
    ArrayList<CD> lstCDs = new ArrayList<CD>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getVistas();

    }

    private void getVistas() {
        lstMusic = (ListView) findViewById(R.id.lvMusic);

        lstCDs.add(new CD("Estopa", "Rumba a lo desconocido", 2016, R.drawable.estopa));
        lstCDs.add(new CD("Melendi", "Lágrimas desordenadas", 2015, R.drawable.melendi));
        lstCDs.add(new CD("Dani Martin", "Mi teatro", 2013, R.drawable.danimartin));
        lstCDs.add(new CD("Monica Naranjo", "Jamas", 2015, R.drawable.monica));

        lstMusic.setAdapter(new CDAdapter(this,lstCDs));
    }
}
