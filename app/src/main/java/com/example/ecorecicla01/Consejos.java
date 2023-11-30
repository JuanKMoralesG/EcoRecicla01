package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Consejos extends AppCompatActivity {

    ImageView menu_reciclar, menu_estadisticas, menu_tips, menu_puntos,menu_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);
        menu_reciclar = findViewById(R.id.img_menu_registro);
        menu_estadisticas = findViewById(R.id.img_menu_estadistica);
        menu_tips = findViewById(R.id.img_menu_tips);
        menu_puntos = findViewById(R.id.img_menu_puntos);
        menu_home =findViewById(R.id.img_menu_home);

        Intent recicle1 = new Intent(getApplicationContext(), Categorias.class);
        Intent estadisticas = new Intent(getApplicationContext(), Estadisticas.class);
        Intent consejos1 = new Intent(getApplicationContext(), Consejos.class);
        Intent home = new Intent(getApplicationContext(), Home.class);

        Intent receive = getIntent();
        String id = receive.getStringExtra("idUser");

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