package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GamblingRoom extends AppCompatActivity {

    private ImageButton botonVaquito;
    private ImageButton botonSally;
    private ImageButton botonPi;

    private ImageButton botonApuesta;

    private TextView nombreBoss;
    private TextView apuestaBoss;
    private TextView dificultad;

    private ConstraintLayout mensajeapuesta;

    private TextView coins;
    public int myCoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling_room);

        //Coins

        // Recuperar el entero



        //Botones Bosses

        botonVaquito = findViewById(R.id.boton_vaquito);
        botonSally = findViewById(R.id.boton_sally);
        botonPi = findViewById(R.id.boton_pi);
        botonApuesta = findViewById(R.id.boton_apuesta);

        nombreBoss = findViewById(R.id.nombreBoss);
        apuestaBoss = findViewById(R.id.apuestaBoss);
        dificultad = findViewById(R.id.dificultad);

        mensajeapuesta = findViewById(R.id.layoutmensaje);

        botonVaquito.setOnClickListener(v -> {

            if (mensajeapuesta.getVisibility() == View.GONE && botonApuesta.getVisibility() == View.GONE) {
                mensajeapuesta.setVisibility(View.VISIBLE);
                botonApuesta.setVisibility(View.VISIBLE);
                nombreBoss.setText("Vaquito");
                apuestaBoss.setText("10");
                dificultad.setText("Fácil");
            } else {
                mensajeapuesta.setVisibility(View.GONE);
                botonApuesta.setVisibility(View.GONE);
            }


        });

        botonSally.setOnClickListener(v -> {

            if (mensajeapuesta.getVisibility() == View.GONE && botonApuesta.getVisibility() == View.GONE) {
                mensajeapuesta.setVisibility(View.VISIBLE);
                botonApuesta.setVisibility(View.VISIBLE);
                nombreBoss.setText("Sally");
                apuestaBoss.setText("20");
                dificultad.setText("Medio");
            } else {
                mensajeapuesta.setVisibility(View.GONE);
                botonApuesta.setVisibility(View.GONE);
            }
        });

        botonPi.setOnClickListener(v -> {

            if (mensajeapuesta.getVisibility() == View.GONE && botonApuesta.getVisibility() == View.GONE) {
                mensajeapuesta.setVisibility(View.VISIBLE);
                botonApuesta.setVisibility(View.VISIBLE);
                nombreBoss.setText("Pi");
                apuestaBoss.setText("30");
                dificultad.setText("Difícil");
            } else {
                mensajeapuesta.setVisibility(View.GONE);
                botonApuesta.setVisibility(View.GONE);
            }
        });

        botonApuesta.setOnClickListener(v -> {

            if (nombreBoss.getText().equals("Vaquito") && (myCoins >= 10)) {


                Intent intent = new Intent(GamblingRoom.this, GameActivity.class);
                intent.putExtra("dificultad_ia", 0);
                intent.putExtra("coins", myCoins);

                startActivity(intent);

            } else if (nombreBoss.getText().equals("Sally") && (myCoins >= 20)) {


                Intent intent = new Intent(GamblingRoom.this, GameActivity.class);
                intent.putExtra("dificultad_ia", 1);
                intent.putExtra("coins", myCoins);

                startActivity(intent);

            } else if (nombreBoss.getText().equals("Pi") && (myCoins >= 30)) {


                Intent intent = new Intent(GamblingRoom.this, GameActivity.class);
                intent.putExtra("dificultad_ia", 2);
                intent.putExtra("coins", myCoins);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        myCoins = SaveCoins.getSavedInteger(this,SaveCoins.COINS);


        if(myCoins<10){
            myCoins=200;
        }

        coins = findViewById(R.id.coin_value);
        coins.setText(String.valueOf(myCoins));
    }
}