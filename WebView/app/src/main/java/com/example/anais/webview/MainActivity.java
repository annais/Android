package com.example.anais.webview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        // Constantes.
        String URL = "http://www.wordreference.com/es/translation.asp?tranword=";

        // Vistas.
        private EditText txtConcepto;
        private Button btnBuscar;
        private WebView wvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wvWeb = (WebView) findViewById(R.id.wvWeb);
        wvWeb.loadUrl(URL);
        wvWeb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                wvWeb.setVisibility(View.VISIBLE);
            }

        });
        txtConcepto = (EditText) findViewById(R.id.edConcepto);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ur = (URL + txtConcepto.getText());
                wvWeb.loadUrl(ur);
            }
        });
    }

}
