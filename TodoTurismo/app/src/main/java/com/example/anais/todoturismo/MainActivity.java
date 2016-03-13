package com.example.anais.todoturismo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ImagenFragment.OnSitioSelectedListener,GalleryFragment.OnSitioSelectedListener, ListaFragment.OnSitioSelectedListener, NavigationView.OnNavigationItemSelectedListener, InicioFragment.OnButtonSelectedListener{

    static ArrayList<Sitio> sitios;
    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;
    Fragment inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        boolean uno = verificarConexion();
        if (!uno) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet. Saliendo ... ", Toast.LENGTH_SHORT)
                    .show();
            this.finish();
        }

        getNavDrawer(savedInstanceState);



        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        inicio = new InicioFragment();
        fragmentTransaction.add(R.id.fragact, inicio);
        fragmentTransaction.commit();

        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute("https://www.zaragoza.es/api/recurso/turismo/monumento.xml");

    }

    public boolean verificarConexion() {
        ConnectivityManager connMgr =  ( ConnectivityManager )
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr . getActiveNetworkInfo ();
        if  ( networkInfo !=  null  && networkInfo . isConnected ())  {
            return true;
        } else  {
            return false;
        }

    }

    @Override
    public void onSitioSelected(Sitio sitio) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragact, new DesFragment(sitio));
        fragmentTransaction.commit();
    }

    public void getNavDrawer(Bundle savedInstanceState ) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lista) {
            fragmentTransaction = fragmentManager.beginTransaction();
            inicio = new ListaFragment(sitios);
            fragmentTransaction.replace(R.id.fragact, inicio);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_gallery) {
            fragmentTransaction = fragmentManager.beginTransaction();
            inicio = new GalleryFragment(sitios);
            fragmentTransaction.replace(R.id.fragact, inicio);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_map) {
            startActivity( new Intent(this, MapsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onImgSelected(Sitio sitio) {

    }

    @Override
    public void onItemSelected(Sitio sitio) {
        fragmentTransaction = fragmentManager.beginTransaction();

        inicio = new ImagenFragment(sitio);
        fragmentTransaction.replace(R.id.fragact, inicio);
        fragmentTransaction.commit();
    }

    //cargar XMLnav_header_main.xml
    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

        protected Boolean doInBackground(String... params) {

            RssParserDom saxparser =
                    new RssParserDom(params[0]);

            sitios = saxparser.parse();

            return true;
        }

        protected void onPostExecute(Boolean result) {

        }

    }

    @Override
    public void OnButtonSelected() {

        fragmentTransaction = fragmentManager.beginTransaction();

        inicio = new ListaFragment(sitios);
        fragmentTransaction.replace(R.id.fragact, inicio);
        fragmentTransaction.commit();

    }


}
