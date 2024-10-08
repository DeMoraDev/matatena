package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton botonJugar;
    private ImageButton botonComo;
    private ImageButton botonSalir;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Base_Theme_Matatena);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SaveCoins.clearAllPreferences(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.menu_theme);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        botonJugar = findViewById(R.id.botonJugar);
        botonComo = findViewById(R.id.botonComo);
        botonSalir = findViewById(R.id.botonSalir);

        botonJugar.setOnClickListener(v -> {
            mediaPlayer.stop();
            Intent intent = new Intent(MainActivity.this, GamblingRoom.class);

            startActivity(intent);
        });

        botonSalir.setOnClickListener(v -> {
            finish();
        });

        botonComo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ComoJugar.class);
            startActivity(intent);
        });
    }
}