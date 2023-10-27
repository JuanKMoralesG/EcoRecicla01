package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroUsuario extends AppCompatActivity {

    Button nuevoUsuario;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nuevoUsuario = findViewById(R.id.btnNU);

        Intent nuevousuario= new Intent(getApplicationContext(), InicioSesion.class);

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(nuevousuario);
            }
        });


    }
}