package com.example.anais.calculator;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorMain extends AppCompatActivity implements View.OnClickListener {

    //Variables pantalla normal
    Button btnCero,btnUno,btnDos,btnTres,btnCuatro,btnCinco,btnSeis,btnSiete,btnOcho,btnNueve;
    Button btnMma,btnMc,btnMme,btnMr,btnC,btnIgual,btnBorrar,btnComa;
    Button btnSumar,btnRestar,btnDividir,btnMultiplicar;
    TextView txtContenedor;

    //Variables pantanlla land
    Button btnSin,btnCos,btnTan,btnPi,btnRaizC,btnResDivision,btnXDos,btnXTres,btnE,btnSinh,btnTanh,btnCosh;

    //Variables de programacion
    String pantalla;
    double num1=0,num2=0;
    double memoria=0;
    boolean terminar=false,punto=false,pulsado=false,MPulsada=false;
    int id,operador;
    String textbtn;
    boolean segir=false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.calculator_lasc);
            getVistasLand();
        }else{
            setContentView(R.layout.calculator_main);
        }

        getVistas();
    }

    private void getVistasLand() {
        btnSin= (Button) this.findViewById(R.id.btnSin);
        btnCos= (Button) this.findViewById(R.id.btnCos);
        btnTan= (Button) this.findViewById(R.id.btnTan);
        btnPi= (Button) this.findViewById(R.id.btnPi);
        btnRaizC= (Button) this.findViewById(R.id.btnRaizC);
        btnResDivision= (Button) this.findViewById(R.id.btnResDivision);
        btnXDos= (Button) this.findViewById(R.id.btnXDos);
        btnXTres= (Button) this.findViewById(R.id.btnXTres);
        btnE= (Button) this.findViewById(R.id.btnE);
        btnSinh= (Button) this.findViewById(R.id.btnSinh);
        btnCosh= (Button) this.findViewById(R.id.btnCosh);
        btnTanh= (Button) this.findViewById(R.id.btnTanh);

        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnPi.setOnClickListener(this);
        btnRaizC.setOnClickListener(this);
        btnResDivision.setOnClickListener(this);
        btnXDos.setOnClickListener(this);
        btnXTres.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnSinh.setOnClickListener(this);
        btnCosh.setOnClickListener(this);
        btnTanh.setOnClickListener(this);
    }


    private void getVistas() {

        txtContenedor=(TextView) this.findViewById(R.id.txtContenedor);
        txtContenedor.setText("0");//Muestro un "0" en vez de la barra.

        btnCero= (Button) this.findViewById(R.id.btnCero);
        btnUno= (Button) this.findViewById(R.id.btnUno);
        btnDos= (Button) this.findViewById(R.id.btnDos);
        btnTres= (Button) this.findViewById(R.id.btnTres);
        btnCuatro= (Button) this.findViewById(R.id.btnCuatro);
        btnCinco= (Button) this.findViewById(R.id.btnCinco);
        btnSeis= (Button) this.findViewById(R.id.btnSeis);
        btnSiete= (Button) this.findViewById(R.id.btnSiete);
        btnOcho= (Button) this.findViewById(R.id.btnOcho);
        btnNueve= (Button) this.findViewById(R.id.btnNueve);

        btnSumar=(Button)findViewById(R.id.btnSumar);
        btnRestar=(Button)findViewById(R.id.btnRestar);
        btnMultiplicar=(Button)findViewById(R.id.btnMultiplicar);
        btnDividir=(Button)findViewById(R.id.btnDividir);
        btnIgual=(Button)findViewById(R.id.btnIgual);
        btnC=(Button)findViewById(R.id.btnC);
        btnBorrar=(Button)findViewById(R.id.btnBorrar);
        btnComa = (Button) findViewById(R.id.btnComa);

        btnMme=(Button)findViewById(R.id.btnMme);
        btnMma=(Button)findViewById(R.id.btnMma);
        btnMc=(Button)findViewById(R.id.btnMc);
        btnMr=(Button)findViewById(R.id.btnMr);

        btnCero.setOnClickListener(this);
        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSiete.setOnClickListener(this);
        btnOcho.setOnClickListener(this);
        btnNueve.setOnClickListener(this);

        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnComa.setOnClickListener(this);

        btnMme.setOnClickListener(this);
        btnMma.setOnClickListener(this);
        btnMc.setOnClickListener(this);
        btnMr.setOnClickListener(this);

    }

    public void Borrar(){
        String texto=txtContenedor.getText().toString();
        if(!texto.equals("Infinity")) {
            texto = texto.substring(0, texto.length() - 1);
            if (texto.equals("")) {
                texto = "0";
                textbtn = "0";
                segir = false;
            }
            txtContenedor.setText(texto);
        }
    }

    private void Numeros(Button btn) {

            if (terminar) {
               // txtContenedor.setText("0");//Para mostrar por pantalla el numero.
                terminar = false;
            }
            if (operador < 6) {
                textbtn = btn.getText().toString();//Obtengo del texto del boton pulsado.
            }
            pantalla = txtContenedor.getText().toString();//Obtener numeros introducidos.
            if (!pulsado) {
                if(txtContenedor.getText().length()<10) {
                    if (!pantalla.equals("0")) {
                        if(!pantalla.equals("Infinity")) {
                            pantalla = pantalla.concat(textbtn);//Cadavez que yo escriba un numero se le añade al anterior.
                        }
                    } else {
                        pantalla = textbtn;
                    }
                }

            } else {
                num1 = Double.parseDouble(txtContenedor.getText().toString());
                if(textbtn==null){
                    pantalla = "0";
                }else {
                    pantalla = textbtn;
                }
                pulsado = false;
                punto = false;
            }

            txtContenedor.setText(pantalla);//Para mostrar por pantalla el numero.
    }

    public void Operar(){
        pulsado = true;

        if(operador>5){
            //comprobar si le a dad 2 veces segidas.
            Button btn = null;
            segir = true;
            Numeros(btn);
            if(num1==0){
                operador = -1;
            }
        }

        if(num1!=0){

            if(!segir) {
                num2 = Double.parseDouble(txtContenedor.getText().toString());
            }
            if (num2!=0 || operador>5) {
                switch(operador){
                    case 0:
                        num2=num1+num2;
                        break;
                    case 1:
                        num2=num1-num2;
                        break;
                    case 2:
                        num2=num1*num2;
                        break;
                    case 3:
                        if(num2==0){txtContenedor.setText("No se puede dividir entre 0");}
                        else{num2=num1/num2;}
                        break;
                    case 4:
                        num2 = num1%num2;
                        break;
                    case 6:
                        num2 = Math.sin(Math.toRadians(num1));
                        break;
                    case 7:
                        num2 = Math.cos(Math.toRadians(num1));
                        break;
                    case 8:
                        num2 = Math.tan(Math.toRadians(num1));
                        break;
                    case 9:
                        num2 = Math.sqrt(num1);
                        break;
                    case 10:
                        num2 = Math.pow(num1, 2);
                        break;
                    case 11:
                        num2 = Math.pow(num1, 3);
                        break;
                    case 12:
                        num2 = Math.sinh(num1);
                        break;
                    case 13:
                        num2 = Math.cosh(num1);
                        break;
                    case 14:
                        num2 = Math.tanh(num1);
                        break;
                }
                txtContenedor.setText(num2+"");//Para mostrar por pantalla el numero.
                num1=0;
                num2=0;
                operador = -1;
                if(terminar) {
                    pulsado = false;
                }
                num2 = Double.parseDouble(txtContenedor.getText().toString());

            }
        }
    }

    public void Memoria(int idMemoria){

        switch(idMemoria){
            case R.id.btnMma:
                memoria=memoria+Double.parseDouble(txtContenedor.getText().toString());
                pantalla="";
                break;
            case R.id.btnMme:
                memoria=memoria-Double.parseDouble(txtContenedor.getText().toString());
                pantalla="";
                break;
            case R.id.btnMr://Al usar la memoria se guarda el valor de la misma en la cadena numero
                pantalla=""+memoria;
                if (memoria==(int)memoria) {
                    txtContenedor.setText("" + (int)memoria);
                }
                else {txtContenedor.setText("" + memoria);}
                break;
            case R.id.btnMc:
                memoria=0;
                break;
        }
        MPulsada=true;

    }

    @Override
    public void onClick(View v) {
        Button btn=(Button)v;
        switch(btn.getId()){
            case R.id.btnCero:
            case R.id.btnUno:
            case R.id.btnDos:
            case R.id.btnTres:
            case R.id.btnCuatro:
            case R.id.btnCinco:
            case R.id.btnSeis:
            case R.id.btnSiete:
            case R.id.btnOcho:
            case R.id.btnNueve:
                Numeros(btn);
                break;
            case R.id.btnSumar:
                operador = 0;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnRestar:
                operador = 1;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnMultiplicar:
                operador = 2;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnDividir:
                operador = 3;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnIgual:
                terminar = true;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnResDivision:
                operador = 4;
                Operar();
                break;
            case R.id.btnComa:
                if (!punto){//Para comprovar que no se a pulsado el punto.
                    pantalla=txtContenedor.getText().toString();//Obtener numeros introducidos.
                    if(pantalla.equals("0")) {
                        pantalla="0.";
                    }
                    else {pantalla=pantalla+".";}
                    txtContenedor.setText(pantalla);
                    punto=true;
                }
                break;
            case R.id.btnMma:
            case R.id.btnMme:
            case R.id.btnMc:
            case R.id.btnMr:
                Memoria(btn.getId());//Llamada al método que maneja la memoria
                break;
            case R.id.btnC:
                getC();
                break;
            case R.id.btnBorrar:
                Borrar();
                break;
            case R.id.btnSin:
                operador  = 6;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnCos:
                operador = 7;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnTan:
                operador = 8;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnRaizC:
                operador = 9;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnPi:
                txtContenedor.setText(Math.PI + "");
                break;
            case R.id.btnXDos:
                operador = 10;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnXTres:
                operador = 11;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnE:
                txtContenedor.setText(Math.E + "");
                break;
            case R.id.btnSinh:
                operador = 12;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnCosh:
                operador = 13;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
            case R.id.btnTanh:
                operador = 14;
                Operar();//Se llama al metodo para realizar la operacion.
                break;
        }
    }

    private void getC() {
        txtContenedor.setText("0");
        textbtn = "0";
        pulsado=false;
        punto = false;
        segir = false;
        num1 = 0;
        num2 = 0;
    }
}

