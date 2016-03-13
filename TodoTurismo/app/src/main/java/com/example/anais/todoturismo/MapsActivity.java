package com.example.anais.todoturismo;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Sitio> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        getLista();
        LatLng zaragoza = new LatLng(41.648607, -0.888973);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(zaragoza));

        for (int i = 0; i< lista.size(); i++) {
            LatLng punto = new LatLng(lista.get(i).getCord1(),lista.get(i).getCord2());
            mMap.addMarker(new MarkerOptions().position(punto).title(lista.get(i).getNombre()));
        }
    }

    private void getLista() {
        lista = new ArrayList<Sitio>();
        lista.add(new Sitio("Museo del Foro de Caesaraugusta",41.655197, -0.875839));
        lista.add(new Sitio("Centro de Historias de Zaragoza. Antiguo Convento de San Agustín",41.650879, -0.870731));
        lista.add(new Sitio("Casa de los Morlanes",41.651636, -0.875201));
        lista.add(new Sitio("Azud del Río Ebro",41.650529, -0.860698));
        lista.add(new Sitio("Arco y casa del Deán",41.654493, -0.874855));
        lista.add(new Sitio("Monasterio de la Resurrección de canonesas del Santo Sepulcro",41.653672, -0.871825));
        lista.add(new Sitio("Auditorio - Palacio de Congresos",41.668799, -0.906409));
        lista.add(new Sitio("Casa Solans",41.660866, -0.867292));
        lista.add(new Sitio("Plaza de Toros de la Misericordia",41.654502, -0.890976));
        lista.add(new Sitio("Museo del Puerto Fluvial de Caesaraugusta",41.655162, -0.873436));
        lista.add(new Sitio("Iglesia Parroquial de Santa Maria Magdalena",41.652432, -0.873201));

        lista.add(new Sitio("Mercado Central",41.656144, -0.882961));
        lista.add(new Sitio("Torreón de la Zuda",41.657550, -0.881246));
        lista.add(new Sitio("Baños Judíos",41.651244, -0.875146));
        lista.add(new Sitio("Torre Santa Engracia",41.649031, -0.882447));
        lista.add(new Sitio("Fuente de la Hispanidad",41.657135, -0.880114));
        lista.add(new Sitio("Galacho de Juslibol",41.703899, -0.930469));
        lista.add(new Sitio("Casa Retuerta",41.643033, -0.884787));
        lista.add(new Sitio("Quiosco de la Música",41.635816, -0.888304));

    }
}
