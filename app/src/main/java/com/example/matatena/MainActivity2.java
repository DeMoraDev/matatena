package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton roller1;
    private ImageButton hueco1;
    private ImageButton hueco2;
    private ImageButton hueco3;
    private ImageButton hueco4;
    private ImageButton hueco5;
    private ImageButton hueco6;
    private ImageButton hueco7;
    private ImageButton hueco8;
    private ImageButton hueco9;
    private ImageButton hueco11;

    private TextView puntos1;
    private TextView ptsfila1;
    private TextView ptsfila2;
    private TextView ptsfila3;
    private ImageView rollerimage;
    private ImageView dice10;
    private ImageView dice11;

    int[][] tablero;
    int tirada;
    boolean rolleado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        roller1 = findViewById(R.id.roller1);
        hueco1 = findViewById(R.id.hueco_17);
        hueco2 = findViewById(R.id.hueco_16);
        hueco3 = findViewById(R.id.hueco_18);
        hueco4 = findViewById(R.id.hueco_14);
        hueco5 = findViewById(R.id.hueco_13);
        hueco6 = findViewById(R.id.hueco_15);
        hueco11 = findViewById(R.id.hueco_11);
        hueco8 = findViewById(R.id.hueco_10);
        hueco9 = findViewById(R.id.hueco_12);
        puntos1 = findViewById(R.id.puntos1);
        ptsfila1 = findViewById(R.id.ptsfila1);
        ptsfila2 = findViewById(R.id.ptsfila2);
        ptsfila3 = findViewById(R.id.ptsfila3);
        rollerimage = findViewById(R.id.rollerimage);
        dice10 = findViewById(R.id.dice_10);
        dice11 = findViewById(R.id.dice_11);

        tablero = new int[6][3];

        roller1.setOnClickListener(v -> {
            rolldice();
        });

        hueco8.setOnClickListener(v -> {
            if (rolleado) {
                {
                    tablero[3][0] = tirada;
                    dice10.setImageResource(getDiceDrawable(tirada));
                }
            }
        });
        hueco11.setOnClickListener(v -> {
            if (rolleado) {
                {
                    tablero[3][1] = tirada;
                    dice11.setImageResource(getDiceDrawable(tirada));
                }
            }
        });
    }

    public void rolldice() {
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
}