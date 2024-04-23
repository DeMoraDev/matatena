package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    private TextView ganador;
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


    private TextView puntosIA_Total;
    private TextView puntos_IA_columna_0;
    private TextView puntos_IA_columna_1;
    private TextView puntos_IA_columna_2;

    private ImageView rollerimageIA;
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
    int[] puntosColumnaIA;

    //Audio
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = MediaPlayer.create(this, R.raw.dicesound);

        ganador = findViewById(R.id.ganador);

        roller1 = findViewById(R.id.roller_Jugador);
        rollerFinal = findViewById(R.id.rollerimage);


        puntosJugador = findViewById(R.id.puntos_Jugador);
        puntos_Jugador_columna_0 = findViewById(R.id.puntos_Jugador_Columna_0);
        puntos_Jugador_columna_1 = findViewById(R.id.puntos_Jugador_Columna_1);
        puntos_Jugador_columna_2 = findViewById(R.id.puntos_Jugador_Columna_2);

        puntosIA_Total = findViewById(R.id.puntos_IA);
        puntos_IA_columna_0 = findViewById(R.id.puntos_IA_Columna_0);
        puntos_IA_columna_1 = findViewById(R.id.puntos_IA_Columna_1);
        puntos_IA_columna_2 = findViewById(R.id.puntos_IA_Columna_2);

        rollerimageIA = findViewById(R.id.rollerimageIA);
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
        puntosColumnaIA = new int[3];

        roller1.setOnClickListener(v -> {

            if (!rolleado) {
                rollDice();
                mediaPlayer.start();
            }
        });



        hueco_3_0.setOnClickListener(v -> {
            if (tablero[3][0] == 0) {
                if (rolleado) {
                    tablero[3][0] = tirada;
                    dice_3_0.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();

                }
            }
        });

        hueco_3_1.setOnClickListener(v -> {
            if (tablero[3][1] == 0) {
                if (rolleado) {
                    tablero[3][1] = tirada;
                    dice_3_1.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_3_2.setOnClickListener(v -> {
            if (tablero[3][2] == 0) {
                if (rolleado) {
                    tablero[3][2] = tirada;
                    dice_3_2.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_4_0.setOnClickListener(v -> {
            if (tablero[4][0] == 0) {
                if (rolleado) {
                    tablero[4][0] = tirada;
                    dice_4_0.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_4_1.setOnClickListener(v -> {
            if (tablero[4][1] == 0) {
                if (rolleado) {
                    tablero[4][1] = tirada;
                    dice_4_1.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_4_2.setOnClickListener(v -> {
            if (tablero[4][2] == 0) {
                if (rolleado) {
                    tablero[4][2] = tirada;
                    dice_4_2.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_5_0.setOnClickListener(v -> {
            if (tablero[5][0] == 0) {
                if (rolleado) {
                    tablero[5][0] = tirada;
                    dice_5_0.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_5_1.setOnClickListener(v -> {
            if (tablero[5][1] == 0) {
                if (rolleado) {
                    tablero[5][1] = tirada;
                    dice_5_1.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
                }
            }
        });

        hueco_5_2.setOnClickListener(v -> {
            if (tablero[5][2] == 0) {
                if (rolleado) {
                    tablero[5][2] = tirada;
                    dice_5_2.setImageResource(getDiceDrawable(tirada));
                    updateCounterPlayer();
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

    private void updateCounterPlayer() {
        resetRoller();

        puntosColumna[0] = getPuntosColumna(tablero, 0);
        puntosColumna[1] = getPuntosColumna(tablero, 1);
        puntosColumna[2] = getPuntosColumna(tablero, 2);

        puntos_Jugador_columna_0.setText(String.valueOf(puntosColumna[0]));
        puntos_Jugador_columna_1.setText(String.valueOf(puntosColumna[1]));
        puntos_Jugador_columna_2.setText(String.valueOf(puntosColumna[2]));

        int total = puntosColumna[0] + puntosColumna[1] + puntosColumna[2];
        puntosJugador.setText(String.valueOf(total));

        //Parte de la IA

        puntosColumnaIA[0] = getPuntosColumnaIA(tablero, 0);
        puntosColumnaIA[1] = getPuntosColumnaIA(tablero, 1);
        puntosColumnaIA[2] = getPuntosColumnaIA(tablero, 2);

        puntos_IA_columna_0.setText(String.valueOf(puntosColumnaIA[0]));
        puntos_IA_columna_1.setText(String.valueOf(puntosColumnaIA[1]));
        puntos_IA_columna_2.setText(String.valueOf(puntosColumnaIA[2]));

        int totalIA = puntosColumnaIA[0] + puntosColumnaIA[1] + puntosColumnaIA[2];
        puntosIA_Total.setText(String.valueOf(totalIA));

        if (isGameFinished()) {
            rolleado = true;

            if(total<totalIA){
                ganador.setText("Gana Vaquito");
            }else if(total>totalIA){
                ganador.setText("Gana Jugador");
            }else{
                ganador.setText("Empate");
            }
        } else {
            iaPlay();

        }
    }

    private void iaPlay() {
        if (rolleado) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Random aleatorio = new Random();
                    int dadoIa = aleatorio.nextInt(6) + 1;
                    int[] posicion = buscarNumeroEnColumnas(dadoIa);

                    tablero[posicion[0]][posicion[1]] = dadoIa;
                    rollerimageIA.setImageResource(getDiceDrawable(dadoIa));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getImageViewPosition(posicion).setImageResource(getDiceDrawable(dadoIa));
                            rollerimageIA.setImageResource(R.drawable.emptydice);
                            rolleado = false;
                            updateCounterPlayer();
                        }
                    }, 1500);
                }
            }, 1000);
        }
    }


    //eliminar repetidos en columna


    public int[] obtenerPosicionAleatoria() {
        Random rand = new Random();
        int fila, columna;

        do {
            fila = rand.nextInt(3);
            columna = rand.nextInt(3);
        } while (tablero[fila][columna] != 0);

        return new int[]{fila, columna};
    }


    public int[] buscarNumeroEnColumnas(int tiradaIA) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == tiradaIA) {
                    if (i == 0) {
                        if (tablero[1][j] == 0) {
                            return new int[]{1, j};
                        }
                        if (tablero[2][j] == 0) {
                            return new int[]{2, j};
                        }
                    }
                    if (i == 1) {
                        if (tablero[0][j] == 0) {
                            return new int[]{0, j};
                        }
                        if (tablero[2][j] == 0) {
                            return new int[]{2, j};
                        }
                    }
                    if (i == 2) {
                        if (tablero[0][j] == 0) {
                            return new int[]{0, j};
                        }
                        if (tablero[1][j] == 0) {
                            return new int[]{1, j};
                        }
                    }
                }
            }
        }

        return obtenerPosicionAleatoria();
    }

    public int[] buscarNumeroEnemigo(int tiradaIA) {
        boolean columna0Libre = false;
        boolean columna1Libre = false;
        boolean columna2Libre = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    if (i == 0)
                        columna0Libre = true;
                    if (i == 1)
                        columna1Libre = true;
                    if (i == 2)
                        columna2Libre = true;
                }
            }
        }

        for (int i = 3; i < tablero.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == tiradaIA) {
                    //donde haya hueco buscar la columna con mas puntos con ese dado
                }
            }
        }

        return obtenerPosicionAleatoria();
    }

    private ImageView getImageViewPosition(int[] posicionElegida) {
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

    private int getPuntosColumnaIA(int[][] tablero, int columna) {
        int puntosIA;

        if (tablero[0][columna] != 0 && tablero[0][columna] == tablero[1][columna] && tablero[1][columna] == tablero[2][columna]) {
            puntosIA = (tablero[0][columna] + tablero[1][columna] + tablero[2][columna]) * 3;
            getDiceDrawableFromPositionIA(0, columna).setImageResource(getDiceDrawableTriple(tablero[0][columna]));
            getDiceDrawableFromPositionIA(1, columna).setImageResource(getDiceDrawableTriple(tablero[1][columna]));
            getDiceDrawableFromPositionIA(2, columna).setImageResource(getDiceDrawableTriple(tablero[2][columna]));
        } else if (tablero[0][columna] != 0 && tablero[0][columna] == tablero[2][columna]) {
            puntosIA = ((tablero[0][columna] + tablero[2][columna]) * 2) + tablero[1][columna];
            getDiceDrawableFromPositionIA(0, columna).setImageResource(getDiceDrawableDouble(tablero[0][columna]));
            getDiceDrawableFromPositionIA(2, columna).setImageResource(getDiceDrawableDouble(tablero[2][columna]));
        } else if (tablero[1][columna] != 0 && tablero[1][columna] == tablero[2][columna]) {
            puntosIA = ((tablero[1][columna] + tablero[2][columna]) * 2) + tablero[0][columna];
            getDiceDrawableFromPositionIA(1, columna).setImageResource(getDiceDrawableDouble(tablero[1][columna]));
            getDiceDrawableFromPositionIA(2, columna).setImageResource(getDiceDrawableDouble(tablero[2][columna]));
        } else if (tablero[0][columna] != 0 && tablero[0][columna] == tablero[1][columna]) {
            puntosIA = ((tablero[0][columna] + tablero[1][columna]) * 2) + tablero[2][columna];
            getDiceDrawableFromPositionIA(0, columna).setImageResource(getDiceDrawableDouble(tablero[0][columna]));
            getDiceDrawableFromPositionIA(1, columna).setImageResource(getDiceDrawableDouble(tablero[1][columna]));
        } else {
            puntosIA = tablero[0][columna] + tablero[1][columna] + tablero[2][columna];
        }
        return puntosIA;
    }

    private ImageView getDiceDrawableFromPositionIA(int fila, int columna) {
        if (fila == 0) {
            if (columna == 0)
                return dice_0_0;
            else if (columna == 1)
                return dice_0_1;
            else
                return dice_0_2;
        } else if (fila == 1) {
            if (columna == 0)
                return dice_1_0;
            else if (columna == 1)
                return dice_1_1;
            else
                return dice_1_2;
        } else {
            if (columna == 0)
                return dice_2_0;
            else if (columna == 1)
                return dice_2_1;
            else
                return dice_2_2;
        }
    }
}
