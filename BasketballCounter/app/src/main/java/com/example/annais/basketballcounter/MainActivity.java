package com.example.annais.basketballcounter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUno, btnDos, btnTres, btnPlus, btnLess;
    TextView tvHome, tvGuest;
    boolean b = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getVista();

    }

    private void getVista() {
        tvHome = (TextView) findViewById(R.id.tvcontHome);
        tvGuest = (TextView) findViewById(R.id.tvcontGuest);

        btnUno = (Button) findViewById(R.id.btnUno);
        btnDos = (Button) findViewById(R.id.btnDos);
        btnTres = (Button) findViewById(R.id.btnTres);
        btnPlus = (Button) findViewById(R.id.btnplus);
        btnLess = (Button) findViewById(R.id.btnless);

        tvHome.setOnClickListener(this);
        tvGuest.setOnClickListener(this);
        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnLess.setOnClickListener(this);

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
                if(b) {
                    tvHome.setText(""+((Integer.parseInt(tvHome.getText().toString()))+1));
                }else{
                    tvGuest.setText(""+((Integer.parseInt(tvGuest.getText().toString()))+1));
                }
                break;
            case R.id.btnplus:
                if(b) {
                    tvHome.setText(""+((Integer.parseInt(tvHome.getText().toString()))+1));
                }else{
                    tvGuest.setText(""+((Integer.parseInt(tvGuest.getText().toString()))+1));
                }
                break;
            case R.id.btnDos:
                if(b) {
                    tvHome.setText(""+((Integer.parseInt(tvHome.getText().toString()))+2));
                }else {
                    tvGuest.setText("" + ((Integer.parseInt(tvGuest.getText().toString())) + 2));
                }
                break;
            case R.id.btnTres:
                if(b) {
                    tvHome.setText(""+((Integer.parseInt(tvHome.getText().toString()))+3));
                }else{
                    tvGuest.setText(""+((Integer.parseInt(tvGuest.getText().toString()))+3));
                }
                break;
            case R.id.btnless:
                if(b) {
                    tvHome.setText(""+((Integer.parseInt(tvHome.getText().toString()))-1));
                }else{
                    tvGuest.setText(""+((Integer.parseInt(tvGuest.getText().toString()))-1));
                }
                break;
            case  R.id.tvcontHome:
                b=true;
                tvHome.setBackgroundResource(R.drawable.fondomarcado);
                tvGuest.setBackgroundResource(0);
                break;
            case  R.id.tvcontGuest:
                tvGuest.setBackgroundResource(R.drawable.fondomarcado);
                tvHome.setBackgroundResource(0);
                b=false;
                break;

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
