package com.example.anais.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class TabFragment extends Fragment {

    private static final String ARG_COLOR = "color";

    EditText[]  etjuego = new EditText[5];
    EditText[]  etreserva = new EditText[4];
    String[] juegoh = new String[5];
    String[] reservah = new String[4];
    String[] juegog = new String[5];
    String[] reservag = new String[4];
    Button btnCancelar;
    Button btnAceptar;
    Button btnGuardar;


    private int mColor;

    // Retorna una nueva intancia del fragmento.
    public static TabFragment newInstance (int color) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    public TabFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Se obtienen los argumentos.
        if (getArguments() != null) {
            mColor = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tag, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getView() != null) {
            getVistas(getView());

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TeamActivity.pestaña == 0){
                        getTextoh();
                    }else {
                        getTextog();
                    }
                }
            });

            btnAceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intencion = new Intent(getContext(), MainActivity.class);
                    intencion.putExtra("juegoh", juegoh);
                    intencion.putExtra("reservah", reservah);
                    intencion.putExtra("juegog", juegog);
                    intencion.putExtra("reservag", reservag);
                    getContext().startActivity(intencion);
                }
            });

            btnCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intencion = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(intencion);
                }
            });
        }
    }

  private void getTextoh() {
        juegoh[0] = etjuego[0].getText().toString();
        juegoh[1] = etjuego[1].getText().toString();
        juegoh[2] = etjuego[2].getText().toString();
        juegoh[3] = etjuego[3].getText().toString();
        juegoh[4] = etjuego[4].getText().toString();

        reservah[0] = etreserva[0].getText().toString();
        reservah[1] = etreserva[1].getText().toString();
        reservah[2] = etreserva[2].getText().toString();
        reservah[3] = etreserva[3].getText().toString();
    }

    private void getTextog() {
        juegog[0] = etjuego[0].getText().toString();
        juegog[1] = etjuego[1].getText().toString();
        juegog[2] = etjuego[2].getText().toString();
        juegog[3] = etjuego[3].getText().toString();
        juegog[4] = etjuego[4].getText().toString();

        reservag[0] = etreserva[0].getText().toString();
        reservag[1] = etreserva[1].getText().toString();
        reservag[2] = etreserva[2].getText().toString();
        reservag[3] = etreserva[3].getText().toString();
    }

    // Obtiene e inicializa las vistas.
    private void getVistas(View view) {
        etjuego[0]= (EditText) view.findViewById(R.id.eth1);
        etjuego[1]= (EditText) view.findViewById(R.id.eth2);
        etjuego[2]= (EditText) view.findViewById(R.id.eth3);
        etjuego[3]= (EditText) view.findViewById(R.id.eth4);
        etjuego[4]= (EditText) view.findViewById(R.id.eth5);

        etreserva[0]= (EditText) view.findViewById(R.id.etr1);
        etreserva[1]= (EditText) view.findViewById(R.id.etr2);
        etreserva[2]= (EditText) view.findViewById(R.id.etr3);
        etreserva[3]= (EditText) view.findViewById(R.id.etr4);

        btnAceptar = (Button) view.findViewById(R.id.btnAceptar);
        btnCancelar = (Button) view.findViewById(R.id.btnCancelar);
        btnGuardar = (Button) view.findViewById(R.id.btnGuardar);
    }

}