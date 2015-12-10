package com.example.anais.basketball;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Anais on 28/11/2015.
 */
public class DialogNameTeam extends DialogFragment {
    EditText etHome,etGuest;

    // Al crear el diálogo. Retorna el diálogo configurado.
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_name_team, null);
        etHome = (EditText) v.findViewById(R.id.etHome);
        etGuest = (EditText) v.findViewById(R.id.etGuest);

        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle(R.string.action_nombre);
        b.setView(v);
        b.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                Bundle home = new Bundle();
                Bundle guest = new Bundle();

                home.putString("home", etHome.getText().toString());
                guest.putString("guest", etGuest.getText().toString());
                intent.putExtras(home);
                intent.putExtras(guest);
                startActivity(intent);
            }
        });
        b.setNeutralButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Se notifica el evento al listener.
                dismiss();
            }
        });
        return b.create();
    }

}
