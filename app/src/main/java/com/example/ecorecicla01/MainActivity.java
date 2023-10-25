package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bienvenidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bienvenidos=findViewById(R.id.btn_bienvenidos);

        Intent bienvenida = new Intent(getApplicationContext(),InicioSesion.class);

        bienvenidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bienvenida);
            }
        });

    }
}