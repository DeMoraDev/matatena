package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton roller1;
    private ImageView rollerFinal;
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

    private ImageView dice_0_0;
    private ImageView dice_0_1;
    private ImageView dice_0_2;
    private ImageView dice_1_0;
    private ImageView dice_1_1;
    private ImageView dice_1_2;
    private ImageView dice_2_0;
    private ImageView dice_2_1;
    private ImageView dice_2_2;

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
        rollerFinal = findViewById(R.id.rollerimage);

        puntosJugador = findViewById(R.id.puntos_Jugador);
        puntos_Jugador_columna_0 = findViewById(R.id.puntos_Jugador_Columna_0);
        puntos_Jugador_columna_1 = findViewById(R.id.puntos_Jugador_Columna_1);
        puntos_Jugador_columna_2 = findViewById(R.id.puntos_Jugador_Columna_2);

        dice_0_0 = findViewById(R.id.dice_0_0);
        dice_0_1 = findViewById(R.id.dice_0_1);
        dice_0_2 = findViewById(R.id.dice_0_2);
        dice_1_0 = findViewById(R.id.dice_1_0);
        dice_1_1 = findViewById(R.id.dice_1_1);
        dice_1_2 = findViewById(R.id.dice_1_2);
        dice_2_0 = findViewById(R.id.dice_2_0);
        dice_2_1 = findViewById(R.id.dice_2_1);
        dice_2_2 = findViewById(R.id.dice_2_2);

        dice_3_0 = findViewById(R.id.dice_3_0);
        dice_3_1 = findViewById(R.id.dice_3_1);
        dice_3_2 = findViewById(R.id.dice_3_2);
        dice_4_0 = findViewById(R.id.dice_4_0);
        dice_4_1 = findViewById(R.id.dice_4_1);
        dice_4_2 = findViewById(R.id.dice_4_2);
        dice_5_0 = findViewById(R.id.dice_5_0);
        dice_5_1 = findViewById(R.id.dice_5_1);
        dice_5_2 = findViewById(R.id.dice_5_2);

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
            if (!rolleado)
                rollDice();
        });

        hueco_3_0.setOnClickListener(v -> {
            if (tablero[3][0] == 0) {
                if (rolleado) {
                    tablero[3][0] = tirada;
                    dice_3_0.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_3_1.setOnClickListener(v -> {
            if (tablero[3][1] == 0) {
                if (rolleado) {
                    tablero[3][1] = tirada;
                    dice_3_1.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_3_2.setOnClickListener(v -> {
            if (tablero[3][2] == 0) {
                if (rolleado) {
                    tablero[3][2] = tirada;
                    dice_3_2.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_4_0.setOnClickListener(v -> {
            if (tablero[4][0] == 0) {
                if (rolleado) {
                    tablero[4][0] = tirada;
                    dice_4_0.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_4_1.setOnClickListener(v -> {
            if (tablero[4][1] == 0) {
                if (rolleado) {
                    tablero[4][1] = tirada;
                    dice_4_1.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_4_2.setOnClickListener(v -> {
            if (tablero[4][2] == 0) {
                if (rolleado) {
                    tablero[4][2] = tirada;
                    dice_4_2.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_5_0.setOnClickListener(v -> {
            if (tablero[5][0] == 0) {
                if (rolleado) {
                    tablero[5][0] = tirada;
                    dice_5_0.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_5_1.setOnClickListener(v -> {
            if (tablero[5][1] == 0) {
                if (rolleado) {
                    tablero[5][1] = tirada;
                    dice_5_1.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });

        hueco_5_2.setOnClickListener(v -> {
            if (tablero[5][2] == 0) {
                if (rolleado) {
                    tablero[5][2] = tirada;
                    dice_5_2.setImageResource(getDiceDrawable(tirada));
                    updateCounter();
                }
            }
        });
    }

    public void rollDice() {
        Random aleatorio = new Random();
        tirada = aleatorio.nextInt(6) + 1;
        rolleado = true;
        rollerFinal.setImageResource(getDiceDrawable(tirada));
    }

    private void resetRoller() {
        rollerFinal.setImageResource(R.drawable.emptydice);
    }

    /* private void winOrLose(int [][] tablero){
         if(isFull(tablero)==true){
             //sumPoints();
         }
     }

     private void sumPoints(){
         if(puntosJugador<puntosIA){
             ganaIA
         }else if(puntosJugador>puntosIA){
             ganaJugador
         }else{
             empate
         }
     }*/
    public boolean isGameFinished() {
        return isBoardPlayerUnoFull() || isBoardPlayerDosFull();
    }

    public boolean isBoardPlayerUnoFull() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBoardPlayerDosFull() {
        for (int i = 3; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
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

    private int getDiceDrawableDouble(int tirada) {
        switch (tirada) {
            case 1:
                return R.drawable.dice1double;
            case 2:
                return R.drawable.dice2double;
            case 3:
                return R.drawable.dice3double;
            case 4:
                return R.drawable.dice4double;
            case 5:
                return R.drawable.dice5double;
            case 6:
                return R.drawable.dice6double;
            default:
                return R.drawable.dice1normal;
        }
    }

    private int getDiceDrawableTriple(int tirada) {
        switch (tirada) {
            case 1:
                return R.drawable.dice1triple;
            case 2:
                return R.drawable.dice2triple;
            case 3:
                return R.drawable.dice3triple;
            case 4:
                return R.drawable.dice4triple;
            case 5:
                return R.drawable.dice5triple;
            case 6:
                return R.drawable.dice6triple;
            default:
                return R.drawable.dice1normal;
        }
    }

    private void updateCounter() {
        resetRoller();
        rolleado = false;

        puntosColumna[0] = getPuntosColumna(tablero, 0);
        puntosColumna[1] = getPuntosColumna(tablero, 1);
        puntosColumna[2] = getPuntosColumna(tablero, 2);

        puntos_Jugador_columna_0.setText(String.valueOf(puntosColumna[0]));
        puntos_Jugador_columna_1.setText(String.valueOf(puntosColumna[1]));
        puntos_Jugador_columna_2.setText(String.valueOf(puntosColumna[2]));

        int total = puntosColumna[0] + puntosColumna[1] + puntosColumna[2];
        puntosJugador.setText(String.valueOf(total));

        if (isGameFinished()) {
            rolleado = true;
            Toast toast =
                    Toast.makeText(getApplicationContext(),
                            "Final", Toast.LENGTH_SHORT);

            toast.show();
        } else
            iaPlay();
    }

    private void iaPlay() {
        Random aleatorio = new Random();
        int dadoIa = aleatorio.nextInt(6) + 1;

        int[] posicion = obtenerPosicionAleatoria();
        tablero[posicion[0]][posicion[1]] = dadoIa;

        getIAImageViewPosition(posicion).setImageResource(getDiceDrawable(dadoIa));
    }

    public int[] obtenerPosicionAleatoria() {
        Random rand = new Random();
        int fila, columna;

        do {
            fila = rand.nextInt(3);
            columna = rand.nextInt(3);
        } while (tablero[fila][columna] != 0);

        return new int[]{fila, columna};
    }

    private ImageView getIAImageViewPosition(int[] posicionElegida) {
        if (posicionElegida[0] == 0) {
            if (posicionElegida[1] == 0) {
                return dice_0_0;
            } else if (posicionElegida[1] == 1) {
                return dice_0_1;
            } else
                return dice_0_2;
        } else if (posicionElegida[0] == 1) {
            if (posicionElegida[1] == 0) {
                return dice_1_0;
            } else if (posicionElegida[1] == 1) {
                return dice_1_1;
            } else
                return dice_1_2;
        } else {
            if (posicionElegida[1] == 0) {
                return dice_2_0;
            } else if (posicionElegida[1] == 1) {
                return dice_2_1;
            } else
                return dice_2_2;
        }
    }


    private int getPuntosColumna(int[][] tablero, int columna) {
        int puntos;

        if (tablero[3][columna] != 0 && tablero[3][columna] == tablero[4][columna] && tablero[4][columna] == tablero[5][columna]) {
            puntos = (tablero[3][columna] + tablero[4][columna] + tablero[5][columna]) * 3;
            getDiceDrawableFromPosition(3, columna).setImageResource(getDiceDrawableTriple(tablero[3][columna]));
            getDiceDrawableFromPosition(4, columna).setImageResource(getDiceDrawableTriple(tablero[4][columna]));
            getDiceDrawableFromPosition(5, columna).setImageResource(getDiceDrawableTriple(tablero[5][columna]));
        } else if (tablero[3][columna] != 0 && tablero[3][columna] == tablero[5][columna]) {
            puntos = ((tablero[3][columna] + tablero[5][columna]) * 2) + tablero[4][columna];
            getDiceDrawableFromPosition(3, columna).setImageResource(getDiceDrawableDouble(tablero[3][columna]));
            getDiceDrawableFromPosition(5, columna).setImageResource(getDiceDrawableDouble(tablero[5][columna]));
        } else if (tablero[4][columna] != 0 && tablero[4][columna] == tablero[5][columna]) {
            puntos = ((tablero[4][columna] + tablero[5][columna]) * 2) + tablero[3][columna];
            getDiceDrawableFromPosition(4, columna).setImageResource(getDiceDrawableDouble(tablero[4][columna]));
            getDiceDrawableFromPosition(5, columna).setImageResource(getDiceDrawableDouble(tablero[5][columna]));
        } else if (tablero[3][columna] != 0 && tablero[3][columna] == tablero[4][columna]) {
            puntos = ((tablero[3][columna] + tablero[4][columna]) * 2) + tablero[5][columna];
            getDiceDrawableFromPosition(3, columna).setImageResource(getDiceDrawableDouble(tablero[3][columna]));
            getDiceDrawableFromPosition(4, columna).setImageResource(getDiceDrawableDouble(tablero[4][columna]));
        } else {
            puntos = tablero[3][columna] + tablero[4][columna] + tablero[5][columna];
        }
        return puntos;
    }

    private ImageView getDiceDrawableFromPosition(int fila, int columna) {
        if (fila == 3) {
            if (columna == 0)
                return dice_3_0;
            else if (columna == 1)
                return dice_3_1;
            else
                return dice_3_2;
        } else if (fila == 4) {
            if (columna == 0)
                return dice_4_0;
            else if (columna == 1)
                return dice_4_1;
            else
                return dice_4_2;
        } else {
            if (columna == 0)
                return dice_5_0;
            else if (columna == 1)
                return dice_5_1;
            else
                return dice_5_2;
        }
    }
}
