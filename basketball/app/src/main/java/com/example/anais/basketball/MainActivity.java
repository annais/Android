package com.example.anais.basketball;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button[] btnCanastas = new Button[3];
    Button[] btnJuegoh = new Button[5];
    Button[] btnReservah = new Button[4];
    Button[] btnJuegog = new Button[5];
    Button[] btnReservag = new Button[4];
    static String[] nameTeam = new String[2];
    static String[] juegoh,reservah, juegog,reservag;
    static int[] puntosh = new int[9], puntosg = new int[9];
    static ArrayList<Jugador> jugadoresh = new ArrayList<Jugador>();
    static ArrayList<Jugador> jugadoresg = new ArrayList<Jugador>();
    TextView tvHome, tvGuest, tvNHome, tvNGuest;
    int pulsadoJH=-1 ,pulsadoJG=-1 , pulsadoRH=-1 , pulsadoRG=1;
    Button btnMenosH,btnMasH,btnMasG,btnMenosG;
    boolean b = true;
    boolean[] canastas;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getVista();
        getIntentNameTeam();//obtengo los nombres de los equipos
        getIntentTeam();//obtengo el equipo
        getTeam();//si tengo el equipo y su nombre lo imprimo

    }

    private void getTeam() {
        //nombres de los equipos
        if(nameTeam[0]!=null) {
            if (nameTeam[0].equals("") && nameTeam[1].equals("")) {
                tvNHome.setText(getText(R.string.home));
                tvNGuest.setText(getText(R.string.guest));
            } else {
                tvNHome.setText(nameTeam[0]);
                tvNGuest.setText(nameTeam[1]);
            }
        }

        //Equipos
        if(juegog!=null) {
            //Jugadores
            for (int i=0; i < 5;i++) {
                btnJuegoh[i].setText(juegoh[i]);
                btnJuegog[i].setText(juegog[i]);
                if(!existeJugador(juegoh[i],0)) {
                    jugadoresh.add(new Jugador(juegoh[i], 0));
                }
                if(!existeJugador(juegog[i],1)) {
                    jugadoresg.add(new Jugador(juegog[i], 0));
                }
            }

            //Reservas
            for (int i=0; i < 4;i++) {
                btnReservah[i].setText(reservah[i]);
                btnReservag[i].setText(reservag[i]);
                if(!existeJugador(reservah[i],0)) {
                    jugadoresh.add(new Jugador(reservah[i], 0));
                }
                if(!existeJugador(reservag[i],1)) {
                    jugadoresg.add(new Jugador(reservag[i], 0));
                }

            }

        }

    }

    private boolean existeJugador(String nombre, int equipo) {
        if(equipo==0){
            for (int i = 0; i < jugadoresh.size();i++) {
                if (jugadoresh.get(i).getCamiseta().equals(nombre)) {
                    return true;
                }
            }
        }else if (equipo==1){
            for (int i = 0; i < jugadoresg.size() ;i++) {
                if (jugadoresg.get(i).getCamiseta().equals(nombre)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void getIntentTeam() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle msge = intent.getExtras();
            if (msge != null) {
                if (intent.hasExtra("juegoh")) {
                    juegoh = msge.getStringArray("juegoh");
                    for (int i = 0; i < 5;i++) {
                        btnJuegoh[i].setText(juegoh[i]);
                    }
                }
                if (intent.hasExtra("reservah")) {
                    reservah = msge.getStringArray("reservah");
                    for (int i = 0; i < 4;i++) {
                        btnReservah[i].setText(reservah[i]);
                    }
                }
                if (intent.hasExtra("juegog")) {
                    juegog = msge.getStringArray("juegog");
                    for (int i = 0; i < 5;i++) {
                        btnJuegog[i].setText(juegog[i]);
                    }
                }
                if (intent.hasExtra("reservag")) {
                    reservag = msge.getStringArray("reservag");
                    for (int i = 0; i < 4;i++) {
                        btnReservag[i].setText(reservag[i]);
                    }
                }
            }
        }
    }

    private void getIntentNameTeam() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle msge = intent.getExtras();
            if (msge != null) {
                if (intent.hasExtra("home")) {
                    nameTeam[0] = msge.getString("home");
                    tvNHome.setText(nameTeam[0]);
                }
                if (intent.hasExtra("guest")) {
                    nameTeam[1] = msge.getString("guest");
                    tvNGuest.setText(nameTeam[1]);
                }
            }
        }
    }

    private void getVista() {
        canastas = new boolean[]{false, false, false};

        tvNHome = (TextView) findViewById(R.id.tvNHome);
        tvNGuest = (TextView) findViewById(R.id.tvNGuest);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvGuest = (TextView) findViewById(R.id.tvGuest);

        btnCanastas[0] = (Button) findViewById(R.id.btnUno);
        btnCanastas[1] = (Button) findViewById(R.id.btnDos);
        btnCanastas[2] = (Button) findViewById(R.id.btnTres);

        tvHome.setOnClickListener(this);
        tvGuest.setOnClickListener(this);
        btnCanastas[0].setOnClickListener(this);
        btnCanastas[1].setOnClickListener(this);
        btnCanastas[2].setOnClickListener(this);

        btnJuegoh[0] = (Button) findViewById(R.id.btnH1);
        btnJuegoh[1] = (Button) findViewById(R.id.btnH2);
        btnJuegoh[2] = (Button) findViewById(R.id.btnH3);
        btnJuegoh[3] = (Button) findViewById(R.id.btnH4);
        btnJuegoh[4] = (Button) findViewById(R.id.btnH5);

        btnReservah[0] = (Button) findViewById(R.id.btnH1s);
        btnReservah[1] = (Button) findViewById(R.id.btnH2s);
        btnReservah[2] = (Button) findViewById(R.id.btnH3s);
        btnReservah[3] = (Button) findViewById(R.id.btnH4s);

        btnJuegog[0] = (Button) findViewById(R.id.btnG1);
        btnJuegog[1] = (Button) findViewById(R.id.btnG2);
        btnJuegog[2] = (Button) findViewById(R.id.btnG3);
        btnJuegog[3] = (Button) findViewById(R.id.btnG4);
        btnJuegog[4] = (Button) findViewById(R.id.btnG5);

        btnReservag[0] = (Button) findViewById(R.id.btnG1s);
        btnReservag[1] = (Button) findViewById(R.id.btnG2s);
        btnReservag[2] = (Button) findViewById(R.id.btnG3s);
        btnReservag[3] = (Button) findViewById(R.id.btnG4s);

        for (int i = 0; i< 4;i++){
            btnReservah[i].setOnClickListener(this);
            btnReservag[i].setOnClickListener(this);
        }

        for (int i = 0; i< 5;i++){
            btnJuegoh[i].setOnClickListener(this);
            btnJuegog[i].setOnClickListener(this);
        }

        btnMasH = (Button) findViewById(R.id.btnmash);
        btnMasG = (Button) findViewById(R.id.btnmasg);
        btnMenosH = (Button) findViewById(R.id.btnmenosh);
        btnMenosG = (Button) findViewById(R.id.btnmenosg);

        btnMasG.setOnClickListener(this);
        btnMasH.setOnClickListener(this);
        btnMenosG.setOnClickListener(this);
        btnMenosH.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnUno:
                marcarCanastas(0);
                break;
            case R.id.btnDos:
                marcarCanastas(1);
                break;
            case R.id.btnTres:
                marcarCanastas(2);
                break;
            case  R.id.tvHome:
                b=true;
                //tvHome.setBackgroundResource(R.drawable.fondomarcado);
                tvGuest.setBackgroundResource(0);
                break;
            case  R.id.tvGuest:
                //tvGuest.setBackgroundResource(R.drawable.fondomarcado);
                tvHome.setBackgroundResource(0);
                b=false;
                break;
            case R.id.btnH1:
                if(pulsadoRH!=-1){
                    pulsadoJH = 0;
                    cambioJugador(0);
                }else {
                    sumarCanastas(0, btnJuegoh[0].getText().toString());
                }
            case R.id.btnH2:
                if(pulsadoRH!=-1){
                    pulsadoJH = 1;
                    cambioJugador(0);
                }else {
                    sumarCanastas(0, btnJuegoh[1].getText().toString());
                }
            case R.id.btnH3:
                if(pulsadoRH!=-1){
                    pulsadoJH = 2;
                    cambioJugador(0);
                }else {
                    sumarCanastas(0, btnJuegoh[2].getText().toString());
                }
                break;
            case R.id.btnH4:
                if(pulsadoRH!=-1){
                    pulsadoJH = 3;
                    cambioJugador(0);
                }else {
                    sumarCanastas(0, btnJuegoh[3].getText().toString());
                }
                break;
            case R.id.btnH5:
                if(pulsadoRH!=-1){
                    pulsadoJH = 4;
                    cambioJugador(0);
                }else {
                    sumarCanastas(0, btnJuegoh[4].getText().toString());
                }
                break;
            case R.id.btnG1:
                if(pulsadoRG!=-1){
                    pulsadoJG = 0;
                    cambioJugador(1);
                }else {
                    sumarCanastas(1, btnJuegog[0].getText().toString());
                }
                break;
            case R.id.btnG2:
                if(pulsadoRG!=-1){
                    pulsadoJG = 1;
                    cambioJugador(1);
                }else {
                    sumarCanastas(1, btnJuegog[1].getText().toString());
                }
                break;
            case R.id.btnG3:
                if(pulsadoRG!=-1){
                    pulsadoJG = 2;
                    cambioJugador(1);
                }else {
                    sumarCanastas(1, btnJuegog[2].getText().toString());
                }
                break;
            case R.id.btnG4:
                if(pulsadoRG!=-1){
                    pulsadoJG = 3;
                    cambioJugador(1);
                }else {
                    sumarCanastas(1, btnJuegog[3].getText().toString());
                }
                break;
            case R.id.btnG5:
                if(pulsadoRG!=-1){
                    pulsadoJG = 4;
                    cambioJugador(1);
                }else {
                    sumarCanastas(1, btnJuegog[4].getText().toString());
                }
                break;
            case R.id.btnH1s:
                pulsadoRH = 0;
                break;
            case R.id.btnH2s:
                pulsadoRH = 1;
                break;
            case R.id.btnH3s:
                pulsadoRH = 2;
                break;
            case R.id.btnH4s:
                pulsadoRH = 3;
                break;
            case R.id.btnG1s:
                pulsadoRG = 0;
                break;
            case R.id.btnG2s:
                pulsadoRG = 1;
                break;
            case R.id.btnG3s:
                pulsadoRG = 2;
                break;
            case R.id.btnG4s:
                pulsadoRG = 3;
                break;
        }

    }

    private void cambioJugador(int i) {
        String j = "";
        if(i==0){
            j = juegoh[pulsadoJH];
            juegoh[pulsadoJH] = reservah[pulsadoRH];
            reservah[pulsadoRH] = j;
            pulsadoJH = -1;
            pulsadoRH = -1;
        }else if(i==1) {
            j = juegog[pulsadoJG];
            juegog[pulsadoJG] = reservag[pulsadoRG];
            reservag[pulsadoRG] = j;
            pulsadoJG = -1;
            pulsadoRG = -1;
        }

        getTeam();
    }

    private void sumarCanastas(int id,String num) {

        if (canastas[0]){
            guardarPuntos(1,num,id);
        }else if(canastas[1]){
            guardarPuntos(2,num,id);
        }else if (canastas[2]){
            guardarPuntos(3,num,id);
        }
    }

    private void guardarPuntos(int canasta, String num, int id) {

        if(id==0){
            contador = Integer.parseInt(tvHome.getText().toString());
            tvHome.setText((contador + canasta) + "");
            for (int i = 0; i < 9; i++) {
                if (jugadoresh.get(i).getCamiseta().equals(num)) {
                    jugadoresh.get(i).setPuntos(jugadoresh.get(i).getPuntos() + canasta);
                }
            }
        }else if(id==1){
            contador = Integer.parseInt(tvGuest.getText().toString());
            tvGuest.setText((contador + canasta) + "");
            for (int i = 0; i < 9; i++) {
                if (jugadoresg.get(i).getCamiseta().equals(num)) {
                    jugadoresg.get(i).setPuntos(jugadoresg.get(i).getPuntos() + canasta);
                }
            }
        }
    }

    private void marcarCanastas(int num) {
        for (int i = 0; i < 3 ;i++) {
            if (i==num) {
                canastas[i] = true;
                btnCanastas[i].setText("x");
            }else {
                canastas[i] = false;
                btnCanastas[i].setText(""+(i+1));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        Intent i;
        switch (id){
            case R.id.action_nombre:
                DialogNameTeam d = new DialogNameTeam();
                d.show(getFragmentManager(), "DialogNameTeam");
                break;
            case R.id.action_equipo:
                i = new Intent(this, TeamActivity.class );
                startActivity(i);
                break;
            case R.id.action_estadistica:
                i = new Intent(this, EstadisticasActivity.class );
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
