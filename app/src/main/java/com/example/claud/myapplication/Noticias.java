package com.example.claud.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Noticias extends AppCompatActivity {
    static Sim sim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        sim = new Sim();
        Intent myIntent = getIntent();
        int valor = myIntent.getIntExtra("valorbc",0);
        final TextView textViewToChange = findViewById(R.id.textView4);

        if (valor == 1){
            textViewToChange.setText("Malas Noticias para la Criptomoneda! La asociación de bancos nacional ha decidido de manera unánime betar el uso de la criptomoneda, norma que se hará vigente a partir de este mismo instante");
        } else if (valor == 2){
            textViewToChange.setText("La famosa empresa de videojuegos,Ztean, ha decidido a comenzar la criptomoneda como una alternativa de pago, y esto se hará vigente a contar de este momento.");
        } else if (valor == 3){
            textViewToChange.setText("El más nuevo y famoso ransomware por_que_ejecutas_exes_mandados_por_mail_por_un_desconocido ha afectado a una gran cantidad de computadores a nivel global. Lo curioso de este virus es que ofrece como único medio de pago criptomonedas.");
        } else if (valor == 4){
            textViewToChange.setText("BlockPay, la más nueva modalidad de pago de la cual se había hablado por meses, ha comenzado su marcha blanca en distintos comercios, siendo caracterizado por tener como única modalidad de pago la criptomoneda");
        } else if (valor == 0){
            textViewToChange.setText("La nueva empresa, E.R.R.O.R (Efemérides Raras Resuelven Objetar Raciocinio), deciden comenzar a ofrecer como alternativa de pago de su subscripción la criptomoneda.");
        }else if (valor == 5){
            textViewToChange.setText("El director del SII, Armando Mercado, ha comunicado de que un impuesto se le verá aplicado al corto plazo a la criptomoneda");
        } else if (valor == 6){
            textViewToChange.setText("Se ha encontrado una vulnerabilidad grave en el sistema de blockchain de las criptomonedas, esta vulnerabilidad permitiría alterar la información y que siga siendo válida, permitiendo robar criptomonedas.");
        } else if (valor == 7){
            textViewToChange.setText("Para fomentar el uso de las nuevas tecnologías, el gobierno entregará un bono a todas las personas que posean evidencia de que poseen al menos el equivalente a 50 mil pesos chilenos en criptomonedas");
        }
    }

    public int Data(){
     Bundle params = this.getIntent().getExtras();
        if(params != null){
            int data = Integer.parseInt(params.getString("data"));
            int time = Integer.parseInt(params.getString("time"));
            sim.setData(data,time);

            }
    }
    public void volverAtras(View v){
        Intent intent = new Intent (this, Sim.class);
        Data();
        startActivity(intent);
    }
}
