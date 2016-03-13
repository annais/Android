package com.example.anais.animales20;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnClickListener{

    ArrayList<Animal> lista;
    MediaPlayer mediaPlayer;
    ImageButton ibGallo,ibPerro,ibVaca,ibGato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getVistas();

    }

    private ArrayList<Animal> getLista() {
        lista = new ArrayList<Animal>();
        lista.add(new Animal(R.drawable.gallo, R.raw.gallo, R.color.amarillo));
        lista.add(new Animal(R.drawable.gato, R.raw.gato, R.color.azul));
        lista.add(new Animal(R.drawable.perro, R.raw.perro, R.color.rojo));
        lista.add(new Animal(R.drawable.vaca, R.raw.vaca, R.color.verde));

        return lista;
    }

    public void getVistas() {
        ibVaca = (ImageButton) findViewById(R.id.ibVaca);
        ibPerro = (ImageButton) findViewById(R.id.ibPerro);
        ibGallo = (ImageButton) findViewById(R.id.ibGallo);
        ibGato = (ImageButton) findViewById(R.id.ibGato);

        ibPerro.setOnClickListener(this);
        ibVaca.setOnClickListener(this);
        ibGato.setOnClickListener(this);
        ibGallo.setOnClickListener(this);

        getLista();
        ibGato.setImageResource(lista.get(1).getImagen());
        ibGallo.setImageResource(lista.get(0).getImagen());
        ibPerro.setImageResource(lista.get(2).getImagen());
        ibVaca.setImageResource(lista.get(3).getImagen());
    }

    @Override
    public void onClick(View v) {
        inicializar();

        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        switch (v.getId()){
            case R.id.ibGallo:
                mediaPlayer = MediaPlayer.create(getApplication(), lista.get(0).getSonido());
                ibGallo.setBackgroundResource(lista.get(0).getColor());
                break;
            case R.id.ibGato:
                mediaPlayer = MediaPlayer.create(getApplication(), lista.get(1).getSonido());
                ibGato.setBackgroundResource(lista.get(1).getColor());
                break;
            case R.id.ibPerro:
                mediaPlayer = MediaPlayer.create(getApplication(), lista.get(2).getSonido());
                ibPerro.setBackgroundResource(lista.get(2).getColor());
                break;
            case R.id.ibVaca:
                mediaPlayer = MediaPlayer.create(getApplication(), lista.get(3).getSonido());
                ibVaca.setBackgroundResource(lista.get(3).getColor());
                break;
        }

        mediaPlayer.start();

    }

    private void inicializar() {
        ibGallo.setBackgroundResource(R.color.white);
        ibGato.setBackgroundResource(R.color.white);
        ibPerro.setBackgroundResource(R.color.white);
        ibVaca.setBackgroundResource(R.color.white);
    }
}
