package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {


    private TextView ganador;

    private ConstraintLayout mensajeGanador;
    private TextView nombreGanador;
    private Button botonReseteo;

    private ImageView bossPic;
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

    boolean turnoJugador = false;

    int[] puntosColumna;
    int[] puntosColumnaIA;

    //Audio
    private MediaPlayer musica;
    private MediaPlayer sonidoDice;

    private MediaPlayer miauVaquito;
    private int total;
    private int totalIA;
    private int tiradaIA;
    int dificultad;
    int coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Monedas
        coins = SaveCoins.getSavedInteger(this, SaveCoins.COINS);

        //Bosses
        bossPic = findViewById(R.id.bossIA);

        dificultad = getIntent().getExtras().getInt("dificultad_ia");
        if (dificultad == 0) {
            bossPic.setImageResource(R.drawable.bossvaquitofinal);
        } else if (dificultad == 1) {
            bossPic.setImageResource(R.drawable.bosssallyfinal);
        } else {
            bossPic.setImageResource(R.drawable.bosspifinal);
        }

        //Sonido
        sonidoDice = MediaPlayer.create(this, R.raw.dicesound);
        miauVaquito = MediaPlayer.create(this, R.raw.vaquitomiau);
        musica = MediaPlayer.create(this, R.raw.music);
        musica.setLooping(true);
        musica.start();

        ganador = findViewById(R.id.ganador);

        mensajeGanador = findViewById(R.id.layout_mensaje_reset);
        nombreGanador = findViewById(R.id.mensaje_ganador);
        botonReseteo = findViewById(R.id.botonReseteo);


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
                sonidoDice.start();
            }
        });


        hueco_3_0.setOnClickListener(v -> {
            if (tablero[3][0] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[3][0] = tirada;
                        dice_3_0.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(3, 0);
                    }
                }
            }
        });

        hueco_3_1.setOnClickListener(v -> {
            if (tablero[3][1] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[3][1] = tirada;
                        dice_3_1.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(3, 1);
                    }
                }
            }
        });

        hueco_3_2.setOnClickListener(v -> {
            if (tablero[3][2] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[3][2] = tirada;
                        dice_3_2.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(3, 2);
                    }
                }
            }
        });

        hueco_4_0.setOnClickListener(v -> {
            if (tablero[4][0] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[4][0] = tirada;
                        dice_4_0.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(4, 0);
                    }
                }
            }
        });

        hueco_4_1.setOnClickListener(v -> {
            if (tablero[4][1] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[4][1] = tirada;
                        dice_4_1.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(4, 1);
                    }
                }
            }
        });

        hueco_4_2.setOnClickListener(v -> {
            if (tablero[4][2] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[4][2] = tirada;
                        dice_4_2.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(4, 2);
                    }
                }
            }
        });

        hueco_5_0.setOnClickListener(v -> {
            if (tablero[5][0] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[5][0] = tirada;
                        dice_5_0.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(5, 0);
                    }
                }
            }
        });

        hueco_5_1.setOnClickListener(v -> {
            if (tablero[5][1] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[5][1] = tirada;
                        dice_5_1.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(5, 1);
                    }
                }
            }
        });

        hueco_5_2.setOnClickListener(v -> {
            if (tablero[5][2] == 0) {
                if (rolleado) {
                    if (!turnoJugador) {
                        tablero[5][2] = tirada;
                        dice_5_2.setImageResource(getDiceDrawable(tirada));
                        updateCounterPlayer(5, 2);
                    }
                }
            }
        });

        botonReseteo.setOnClickListener(v -> {
            musica.stop();
            finish();
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

    private void resetGame() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = 0;
                getDiceDrawableFromPosition(i, j).setImageResource(R.drawable.emptydice);
            }
        }
        calculoPuntos();
        rolleado = false;

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


    private void calculoPuntos() {

        //Parte jugador
        puntosColumna[0] = getPuntosColumna(tablero, 0);
        puntosColumna[1] = getPuntosColumna(tablero, 1);
        puntosColumna[2] = getPuntosColumna(tablero, 2);

        puntos_Jugador_columna_0.setText(String.valueOf(puntosColumna[0]));
        puntos_Jugador_columna_1.setText(String.valueOf(puntosColumna[1]));
        puntos_Jugador_columna_2.setText(String.valueOf(puntosColumna[2]));

        total = puntosColumna[0] + puntosColumna[1] + puntosColumna[2];
        puntosJugador.setText(String.valueOf(total));

        //Parte de la IA
        puntosColumnaIA[0] = getPuntosColumnaIA(tablero, 0);
        puntosColumnaIA[1] = getPuntosColumnaIA(tablero, 1);
        puntosColumnaIA[2] = getPuntosColumnaIA(tablero, 2);

        puntos_IA_columna_0.setText(String.valueOf(puntosColumnaIA[0]));
        puntos_IA_columna_1.setText(String.valueOf(puntosColumnaIA[1]));
        puntos_IA_columna_2.setText(String.valueOf(puntosColumnaIA[2]));

        totalIA = puntosColumnaIA[0] + puntosColumnaIA[1] + puntosColumnaIA[2];
        puntosIA_Total.setText(String.valueOf(totalIA));
    }

    private void updateCounterPlayer(int posX, int posY) {

        resetRoller();

        turnoJugador = true;

        buscarDadoEnemigo(posX, posY);

        calculoPuntos();

        checkWin();

    }

    private void checkWin() {
        if (isGameFinished()) {
            mensajeReset();
        } else {
            iaPlay();

        }
    }

    private void mensajeReset() {
        mensajeGanador.setVisibility(View.VISIBLE);

        if (total < totalIA) {
            if (dificultad == 0) {
                nombreGanador.setText("Gana Vaquito");
                coins -= 10;
            } else if (dificultad == 1) {
                nombreGanador.setText("Gana Sally");
                coins -= 20;
            } else {
                nombreGanador.setText("Gana Pi");
                coins -= 30;
            }

        } else if (total > totalIA) {
            nombreGanador.setText("Gana Jugador");
            if (dificultad == 0) {
                coins += 10;
            } else if (dificultad == 1) {
                coins += 20;
            } else {
                coins += 30;
            }

        } else {
            nombreGanador.setText("Empate");
        }
        SaveCoins.saveInteger(this, SaveCoins.COINS, coins);

    }

    private void iaPlay() {
        if (rolleado) {
            Handler handler = new Handler();
            handler.postDelayed(() -> {

                Random aleatorio = new Random();
                tiradaIA = aleatorio.nextInt(6) + 1;
                int[] posicion;
                if (dificultad == 0) {
                    posicion = obtenerPosicionAleatoria();
                } else if (dificultad == 1) {
                    posicion = buscarNumeroEnColumnas(tiradaIA);
                } else {
                    posicion = iaElimineDadoDifilDos(tiradaIA);
                }

                tablero[posicion[0]][posicion[1]] = tiradaIA;
                sonidoDice.start();
                rollerimageIA.setImageResource(getDiceDrawable(tiradaIA));

                handler.postDelayed(() -> {

                    getImageViewPosition(posicion).setImageResource(getDiceDrawable(tiradaIA));
                    rollerimageIA.setImageResource(R.drawable.emptydice);
                    rolleado = false;
                    updateCounterPlayer(posicion[0], posicion[1]);
                    turnoJugador = false;

                }, 1500);
            }, 1000);
        }
    }

    public void buscarDadoEnemigo(int posX, int posY) {
        Handler handler2 = new Handler();
        if (posX <= 2) {
            for (int i = 3; i < tablero.length; i++) {
                if (tablero[posX][posY] == tablero[i][posY]) {
                    tablero[i][posY] = 0;
                    getDiceDrawableFromPosition(i, posY).setImageResource(getDiceDrawableRed(tiradaIA));
                    int finalI = i;
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getDiceDrawableFromPosition(finalI, posY).setImageResource(R.drawable.emptydice);
                        }
                    }, 600);
                    getDiceDrawableFromPosition(i, posY).setImageResource(getDiceDrawableRed(tiradaIA));
                    miauVaquito.start();

                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (tablero[posX][posY] == tablero[i][posY]) {
                    tablero[i][posY] = 0;
                    getDiceDrawableFromPosition(i, posY).setImageResource(getDiceDrawableRed(tirada));
                    int finalI = i;
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getDiceDrawableFromPosition(finalI, posY).setImageResource(R.drawable.emptydice);
                        }
                    }, 600);
                    getDiceDrawableFromPosition(i, posY).setImageResource(getDiceDrawableRed(tirada));
                }
            }
        }
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

        return iaElimineDado(tiradaIA);
    }

    private int[] iaElimineDadoDifilDos(int dadoIA) {
        boolean[] columnaLibre = new boolean[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    columnaLibre[j] = true;
                }
            }
        }

        int[] columnaEnemigo = new int[3];
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == dadoIA && columnaLibre[j]) {
                    columnaEnemigo[j] += 1;
                }
            }
        }

        if (columnaEnemigo[0] > 1 || columnaEnemigo[1] > 1 || columnaEnemigo[2] > 1) {
            int columna;

            if (columnaEnemigo[0] > columnaEnemigo[1] && columnaEnemigo[0] > columnaEnemigo[2]) {
                columna = 0;
            } else if (columnaEnemigo[1] > columnaEnemigo[2]) {
                columna = 1;
            } else {
                columna = 2;
            }

            if (tablero[0][columna] == 0) {
                return new int[]{0, columna};
            } else if (tablero[1][columna] == 0) {
                return new int[]{1, columna};
            } else {
                return new int[]{2, columna};
            }
        } else {
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

            return iaElimineDadoDifilUno(dadoIA);
        }
    }

    private int[] iaElimineDadoDifilUno(int dadoIA) {
        boolean[] columnaLibre = new boolean[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    columnaLibre[j] = true;
                }
            }
        }

        int[] columnaEnemigo = new int[3];
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == dadoIA && columnaLibre[j]) {
                    columnaEnemigo[j] += 1;
                }
            }
        }

        if (columnaEnemigo[0] > 0 || columnaEnemigo[1] > 0 || columnaEnemigo[2] > 0) {
            int columna;

            if (columnaEnemigo[0] > columnaEnemigo[1] && columnaEnemigo[0] > columnaEnemigo[2]) {
                columna = 0;
            } else if (columnaEnemigo[1] > columnaEnemigo[2]) {
                columna = 1;
            } else {
                columna = 2;
            }

            if (tablero[0][columna] == 0) {
                return new int[]{0, columna};
            } else if (tablero[1][columna] == 0) {
                return new int[]{1, columna};
            } else {
                return new int[]{2, columna};
            }

        } else {
            return obtenerPosicionAleatoria();
        }
    }


    public int[] iaElimineDado(int dadoIA) {
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == dadoIA) {
                    int[] posicion = huecoEnColumna(j);
                    if (posicion != null)
                        return posicion;

                }
            }
        }
        return obtenerPosicionAleatoria();

    }

    private int[] huecoEnColumna(int columna) {
        if (tablero[0][columna] == 0)
            return new int[]{0, columna};
        if (tablero[1][columna] == 0)
            return new int[]{1, columna};
        if (tablero[2][columna] == 0)
            return new int[]{2, columna};
        return null;
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

    private int getPuntosColumnaIA(int[][] tablero, int columna) {
        int puntosIA;

        if (tablero[0][columna] != 0 && tablero[0][columna] == tablero[1][columna] && tablero[1][columna] == tablero[2][columna]) {
            puntosIA = (tablero[0][columna] + tablero[1][columna] + tablero[2][columna]) * 3;
            getDiceDrawableFromPosition(0, columna).setImageResource(getDiceDrawableTriple(tablero[0][columna]));
            getDiceDrawableFromPosition(1, columna).setImageResource(getDiceDrawableTriple(tablero[1][columna]));
            getDiceDrawableFromPosition(2, columna).setImageResource(getDiceDrawableTriple(tablero[2][columna]));
        } else if (tablero[0][columna] != 0 && tablero[0][columna] == tablero[2][columna]) {
            puntosIA = ((tablero[0][columna] + tablero[2][columna]) * 2) + tablero[1][columna];
            getDiceDrawableFromPosition(0, columna).setImageResource(getDiceDrawableDouble(tablero[0][columna]));
            getDiceDrawableFromPosition(2, columna).setImageResource(getDiceDrawableDouble(tablero[2][columna]));
        } else if (tablero[1][columna] != 0 && tablero[1][columna] == tablero[2][columna]) {
            puntosIA = ((tablero[1][columna] + tablero[2][columna]) * 2) + tablero[0][columna];
            getDiceDrawableFromPosition(1, columna).setImageResource(getDiceDrawableDouble(tablero[1][columna]));
            getDiceDrawableFromPosition(2, columna).setImageResource(getDiceDrawableDouble(tablero[2][columna]));
        } else if (tablero[0][columna] != 0 && tablero[0][columna] == tablero[1][columna]) {
            puntosIA = ((tablero[0][columna] + tablero[1][columna]) * 2) + tablero[2][columna];
            getDiceDrawableFromPosition(0, columna).setImageResource(getDiceDrawableDouble(tablero[0][columna]));
            getDiceDrawableFromPosition(1, columna).setImageResource(getDiceDrawableDouble(tablero[1][columna]));
        } else {
            puntosIA = tablero[0][columna] + tablero[1][columna] + tablero[2][columna];
        }
        return puntosIA;
    }


    private ImageView getDiceDrawableFromPosition(int fila, int columna) {
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
        } else if (fila == 2) {
            if (columna == 0)
                return dice_2_0;
            else if (columna == 1)
                return dice_2_1;
            else
                return dice_2_2;
        } else if (fila == 3) {
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

    private int getDiceDrawableRed(int tirada) {
        switch (tirada) {
            case 1:
                return R.drawable.dice1red;
            case 2:
                return R.drawable.dice2red;
            case 3:
                return R.drawable.dice3red;
            case 4:
                return R.drawable.dice4red;
            case 5:
                return R.drawable.dice5red;
            case 6:
                return R.drawable.dice6red;
            default:
                return R.drawable.dice1red;
        }
    }

}
