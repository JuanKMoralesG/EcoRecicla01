package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ecorecicla01.Modelos.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ImageView reciclar,estadistica,tips,puntos;
    ImageView menu_reciclar, menu_estadisticas, menu_tips, menu_puntos,menu_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent receive = getIntent();
        String id = receive.getStringExtra("idUser");

        reciclar = findViewById(R.id.img_logo_verde);
        estadistica = findViewById(R.id.img_Estadistica);
        tips = findViewById(R.id.img_tips);
        puntos = findViewById(R.id.img_puntos);

        menu_reciclar = findViewById(R.id.img_menu_registro);
        menu_estadisticas = findViewById(R.id.img_menu_estadistica);
        menu_tips = findViewById(R.id.img_menu_tips);
        menu_puntos = findViewById(R.id.img_menu_puntos);
        menu_home =findViewById(R.id.img_menu_home);

        Intent recicle = new Intent(getApplicationContext(),Categorias.class);
        Intent datos = new Intent(getApplicationContext(), Estadisticas.class);
        Intent consejos = new Intent(getApplicationContext(), Consejos.class);

        Intent recicle1 = new Intent(getApplicationContext(), Categorias.class);
        Intent estadisticas = new Intent(getApplicationContext(), Estadisticas.class);
        Intent consejos1 = new Intent(getApplicationContext(), Consejos.class);
        Intent home = new Intent(getApplicationContext(), Home.class);

        reciclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recicle.putExtra("idUser",id);
                startActivity(recicle);
            }
        });

        estadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.putExtra("idUser",id);
                startActivity(datos);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consejos.putExtra("idUser",id);
                startActivity(consejos);
            }
        });

        menu_reciclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recicle1.putExtra("idUser",id);
                startActivity(recicle1);
            }
        });

        menu_estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estadisticas.putExtra("idUser",id);
                startActivity(estadisticas);
            }
        });

        menu_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.putExtra("idUser",id);
                startActivity(home);
            }
        });

        menu_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consejos1.putExtra("ideUser",id);
                startActivity(consejos1);
            }
        });

    }

}