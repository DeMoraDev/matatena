package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton roller1;
    private ImageView rollerimage;
    private ImageButton hueco_3_0;
    private ImageButton hueco_3_1;
    private ImageButton hueco_3_2;
    private ImageButton hueco_4_0;
    private ImageButton hueco_4_1;
    private ImageButton hueco_4_2;
    private ImageButton hueco_5_0;
    private ImageButton hueco_5_1;
    private ImageButton hueco_5_2;

    private TextView puntosJugador;
    private TextView puntos_Jugador_columna_0;
    private TextView puntos_Jugador_columna_1;
    private TextView puntos_Jugador_columna_2;

    private ImageView dice_3_0;
    private ImageView dice_3_1;
    private ImageView dice_3_2;
    private ImageView dice_4_0;
    private ImageView dice_4_1;
    private ImageView dice_4_2;
    private ImageView dice_5_0;
    private ImageView dice_5_1;
    private ImageView dice_5_2;

    int[][] tablero;
    int tirada;
    boolean rolleado = false;

    int[] puntosColumna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        roller1 = findViewById(R.id.roller_Jugador);
        rollerimage = findViewById(R.id.rollerimage);

        hueco_5_1 = findViewById(R.id.hueco_5_1);
        hueco_5_0 = findViewById(R.id.hueco_5_0);
        hueco_5_2 = findViewById(R.id.hueco_5_2);
        hueco_4_1 = findViewById(R.id.hueco_4_1);
        hueco_4_0 = findViewById(R.id.hueco_4_0);
        hueco_4_2 = findViewById(R.id.hueco_4_2);
        hueco_3_1 = findViewById(R.id.hueco_3_1);
        hueco_3_0 = findViewById(R.id.hueco_3_0);
        hueco_3_2 = findViewById(R.id.hueco_3_2);

        puntosJugador = findViewById(R.id.puntos_Jugador);
        puntos_Jugador_columna_0 = findViewById(R.id.puntos_Jugador_Columna_0);
        puntos_Jugador_columna_1 = findViewById(R.id.puntos_Jugador_Columna_1);
        puntos_Jugador_columna_2 = findViewById(R.id.puntos_Jugador_Columna_2);

        dice_3_0 = findViewById(R.id.dice_3_0);
        dice_3_1 = findViewById(R.id.dice_3_1);
        dice_3_2 = findViewById(R.id.dice_3_2);
        dice_4_0 = findViewById(R.id.dice_4_0);
        dice_4_1 = findViewById(R.id.dice_4_1);
        dice_4_2 = findViewById(R.id.dice_4_2);
        dice_5_0 = findViewById(R.id.dice_5_0);
        dice_5_1 = findViewById(R.id.dice_5_1);
        dice_5_2 = findViewById(R.id.dice_5_2);

        tablero = new int[6][3];
        puntosColumna = new int[3];

        roller1.setOnClickListener(v -> {
            rollDice();
        });

        hueco_3_0.setOnClickListener(v -> {
            if (rolleado) {
                tablero[3][0] = tirada;
                dice_3_0.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_3_1.setOnClickListener(v -> {
            if (rolleado) {
                tablero[3][1] = tirada;
                dice_3_1.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_3_2.setOnClickListener(v -> {
            if (rolleado) {
                tablero[3][2] = tirada;
                dice_3_2.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_4_0.setOnClickListener(v -> {
            if (rolleado) {
                tablero[4][0] = tirada;
                dice_4_0.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_4_1.setOnClickListener(v -> {
            if (rolleado) {
                tablero[4][1] = tirada;
                dice_4_1.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_4_2.setOnClickListener(v -> {
            if (rolleado) {
                tablero[4][2] = tirada;
                dice_4_2.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_5_0.setOnClickListener(v -> {
            if (rolleado) {
                tablero[5][0] = tirada;
                dice_5_0.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_5_1.setOnClickListener(v -> {
            if (rolleado) {
                tablero[5][1] = tirada;
                dice_5_1.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
        hueco_5_2.setOnClickListener(v -> {
            if (rolleado) {
                tablero[5][2] = tirada;
                dice_5_2.setImageResource(getDiceDrawable(tirada));
                updateCounter();
            }
        });
    }

    public void rollDice() {
        Random aleatorio = new Random();
        tirada = aleatorio.nextInt(6) + 1;
        rolleado = true;
        rollerimage.setImageResource(getDiceDrawable(tirada));
    }

    private int getDiceDrawable(int tirada) {
        switch (tirada) {
            case 1:
                return R.drawable.dice1normal;
            case 2:
                return R.drawable.dice2normal;
            case 3:
                return R.drawable.dice3normal;
            case 4:
                return R.drawable.dice4normal;
            case 5:
                return R.drawable.dice5normal;
            case 6:
                return R.drawable.dice6normal;
            default:
                return R.drawable.dice1normal;
        }
    }

    private void updateCounter() {
        puntosColumna[0] = getrPuntosColumna(tablero, 0);
        puntosColumna[1] = getrPuntosColumna(tablero, 1);
        puntosColumna[2] = getrPuntosColumna(tablero, 2);


        puntos_Jugador_columna_0.setText(String.valueOf(puntosColumna[0]));
        puntos_Jugador_columna_1.setText(String.valueOf(puntosColumna[1]));
        puntos_Jugador_columna_2.setText(String.valueOf(puntosColumna[2]));
    }

    private int getrPuntosColumna(int[][] tablero, int columna) {
        return tablero[3][columna] + tablero[4][columna] + tablero[5][columna];
    }
}