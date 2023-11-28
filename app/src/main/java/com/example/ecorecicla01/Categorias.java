package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;

public class Categorias extends AppCompatActivity {

    ImageView menu_reciclar, menu_estadisticas, menu_tips, menu_puntos,menu_home, basura_blanca,basura_verde,basura_negra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        basura_blanca = findViewById(R.id.img_basura_blanca);
        basura_verde = findViewById(R.id.img_basura_verde);
        basura_negra = findViewById(R.id.img_basura_negra);

        menu_reciclar = findViewById(R.id.img_menu_registro);
        menu_estadisticas = findViewById(R.id.img_menu_estadistica);
        menu_tips = findViewById(R.id.img_menu_tips);
        menu_puntos = findViewById(R.id.img_menu_puntos);
        menu_home =findViewById(R.id.img_menu_home);

        Intent aprovechables = new Intent(getApplicationContext(), Aprovechables.class);
        Intent no_aprovechables = new Intent(getApplicationContext(), NoAprovechables.class);
        Intent organicos = new Intent(getApplicationContext(), Organicos.class);

        Intent recicle1 = new Intent(getApplicationContext(), Consejos.class);
        Intent estadisticas = new Intent(getApplicationContext(), Estadisticas.class);
        Intent consejos1 = new Intent(getApplicationContext(), Consejos.class);
        Intent home = new Intent(getApplicationContext(), Home.class);

        basura_blanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(aprovechables);
            }
        });

        basura_negra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(no_aprovechables);
            }
        });

        basura_verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(organicos);
            }
        });

        menu_reciclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(recicle1);
            }
        });

        menu_estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(estadisticas);
            }
        });

        menu_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(home);
            }
        });

        menu_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(consejos1);
            }
        });
    }
}