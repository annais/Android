package com.example.anais.animales;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Variables.
    private GridView gridview;
    private MediaPlayer mediaPlayer;
    private ArrayList<Animal> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getLista();
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, lista));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                }
                //usar position como id
                mediaPlayer = MediaPlayer.create(getApplication(), lista.get(position).getSonido());
                mediaPlayer.start();

                //ImageView img = (ImageView) v.findViewById(R.id.ivAnimal);
                //img.setBackgroundResource(lista.get(position).getColor());

            }
        });
    }

    private ArrayList<Animal> getLista() {
        lista = new ArrayList<Animal>();
        lista.add(new Animal(R.drawable.gallo,R.raw.gallo,R.color.amarillo));
        lista.add(new Animal(R.drawable.gato,R.raw.gato,R.color.azul));
        lista.add(new Animal(R.drawable.perro, R.raw.perro, R.color.rojo));
        lista.add(new Animal(R.drawable.vaca,R.raw.vaca,R.color.verde));

        return lista;
    }
}
