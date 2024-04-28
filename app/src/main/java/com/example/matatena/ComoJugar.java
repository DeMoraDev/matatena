package com.example.matatena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class ComoJugar extends AppCompatActivity {

    private ImageButton botonEntendido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como_jugar);

        botonEntendido = findViewById(R.id.boton_entendido);

        botonEntendido.setOnClickListener(v->{
            onBackPressed();
        });
    }
}