package com.example.anais.puntosturisticos;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements ListaFragment.OnSitioSelectedListener, InicioFragment.OnButtonSelectedListener{

    ArrayList<Sitio> lstSitios;
    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;
    Fragment inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLista();

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        inicio = new InicioFragment();
        fragmentTransaction.add(R.id.fragact, inicio);
        fragmentTransaction.commit();

    }


    public static void cambiarFragment(Sitio sitio){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragact, new DesFragment(sitio));
        fragmentTransaction.commit();
    }

    private void getLista(){
        lstSitios = new ArrayList<Sitio>();
        lstSitios.add(new Sitio("Puerta del Puente","La puerta del Puente es una de las tres únicas puertas que se conservan de la ciudad de Córdoba (España), junto a la Puerta de Almodóvar y la Puerta de Sevilla. La actual puerta se sitúa en un enclave donde antaño también se localizaron puertas romanas así como musulmanas (Bab al-Qantara, Bab al-Wadi, Bab al-Yazira o Bab al-Sura). En época romana unía la ciudad con el Puente Romano y la Vía Augusta.\n" +
                "Desde 1931, la puerta, conjuntamente con el puente romano y la torre de la Calahorra está declarada Bien de Interés Cultural en la categoría de monumento.",R.drawable.puerta_puente));
        lstSitios.add(new Sitio("Mezquita","La Mezquita-catedral de Córdoba, antes «Santa María Madre de Dios» o «Gran Mezquita de Córdoba», actualmente conocida como la Catedral de la Asunción de Nuestra Señora de forma eclesiástica, o simplemente Mezquita de Córdoba de forma general, es un edificio de la ciudad de Córdoba, España. Se trata de uno de los monumentos más importantes de la arquitectura islámica en España, así como del más emblemático ejemplo de arte omeya hispanomusulmán. Desde el siglo XIII y hasta la actualidad es un templo católico, la iglesia catedral de la diócesis de Córdoba. Está declarado Patrimonio Cultural de la Humanidad como parte del centro histórico de la ciudad. Se empezó a construir como mezquita en el año 785, tras la invasión musulmana de la península Ibérica, en el lugar que ocupaba la basílica visigótica de San Vicente Mártir, el templo cristiano más importante de la ciudad. El edificio fue objeto de ampliaciones durante el Emirato de Córdoba y el Califato de Córdoba. En 1238, tras la Reconquista, se llevó a cabo su consagración como catedral con la ordenación episcopal de su primer obispo, Lope de Fitero.4 En 1523 se realizó la mayor alteración del monumento con la construcción de una basílica cruciforme renacentista de estilo plateresco en el centro del edificio musulmán. Hoy todo el conjunto constituye el monumento más importante de Córdoba, y también de toda la arquitectura andalusí, junto con la Alhambra.",R.drawable.mezquita_cordoba));
        lstSitios.add(new Sitio("Puente Romano", "El puente romano de Córdoba está situado sobre el río Guadalquivir a su paso por Córdoba, y une el barrio del Campo de la Verdad con el Barrio de la Catedral. También conocido como \"el Puente Viejo\" fue el único puente con que contó la ciudad durante 20 siglos, hasta la construcción del puente de San Rafael, a mediados del siglo XX. El 9 de enero de 2008 se inauguró la mayor y discutida remodelación que el puente Romano ha tenido en su historia.\n" +
                "Desde 1931, el puente, conjuntamente con la puerta del puente y la torre de la Calahorra está declarado Bien de interés cultural en la categoría de monumento. Forma parte del centro histórico de Córdoba que fue declarado Patrimonio de la Humanidad por la Unesco en 1994.", R.drawable.cordoba_puente_romano));
        lstSitios.add(new Sitio("Alcázar de los Resyes Cristianos", "El Alcázar de los Reyes Cristianos, es un edificio de carácter militar ordenado construir por el rey Alfonso XI de Castilla en el año 1328, sobre construcciones anteriores (el Alcázar andalusí, antes residencia del Gobernador Romano y la Aduana, ubicada en uno de los márgenes del río Guadalquivir), en Córdoba, España. El conjunto arquitectónico tiene un carácter sobrio en su exterior y espléndido en su interior, con los magníficos jardines y patios que mantienen una inspiración mudéjar.\n" +
                "El Alcázar está declarado Bien de interés cultural desde el año 1931. Forma parte del centro histórico de Córdoba que fue declarado Patrimonio de la Humanidad por la Unesco en 1994.", R.drawable.alcazar_reyes_cristianos));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragact, new ListaFragment(lstSitios));
            fragmentTransaction.commit();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onSitioSelected(Sitio sitio) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragact, new DesFragment(sitio));
        fragmentTransaction.commit();
    }

    @Override
    public void OnButtonSelected() {
        fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragact, new ListaFragment(lstSitios));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
