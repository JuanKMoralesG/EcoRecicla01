package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecorecicla01.Modelos.RegistroReciclaje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Aprovechables extends AppCompatActivity {

    EditText cantidad,peso;
    Spinner mes;
    Button registrarReciclaje;
    ImageView menu_reciclar, menu_estadisticas, menu_tips, menu_puntos,menu_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovechables);

        cantidad = findViewById(R.id.cant_aprov);
        peso = findViewById(R.id.peso_aprov);
        mes = findViewById(R.id.spinnerMonthsAprov);

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
        String idUser = receive.getStringExtra("idUser");

        registrarReciclaje = findViewById(R.id.btnRegistrar_Aprov);

        registrarReciclaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cantidad.getText().toString().isEmpty()||peso.getText().toString().isEmpty()||
                        mes.getSelectedItem().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Todos los campos deben estar diligenciados",
                            Toast.LENGTH_LONG).show();
                }else{
                    int cantidadAprovechables = Integer.parseInt(cantidad.getText().toString());
                    int pesoAprovechables = Integer.parseInt(peso.getText().toString());
                    String mesAprovechables = mes.getSelectedItem().toString();
                    RegistroReciclaje reciclado = new RegistroReciclaje(cantidadAprovechables,pesoAprovechables,mesAprovechables,idUser);
                    saveAprovechables(reciclado);
                    cleanView();
                    Toast.makeText(getApplicationContext(),"Registro Exitoso",Toast.LENGTH_LONG).show();
                }
            }
        });

        menu_reciclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recicle1.putExtra("idUser",idUser);
                startActivity(recicle1);
            }
        });

        menu_estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estadisticas.putExtra("idUser",idUser);
                startActivity(estadisticas);
            }
        });

        menu_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.putExtra("idUser",idUser);
                startActivity(home);
            }
        });

        menu_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consejos1.putExtra("ideUser",idUser);
                startActivity(consejos1);
            }
        });
    }

    public void saveAprovechables(RegistroReciclaje reciclado){
        File fileAprovechables = new File(getFilesDir(),"aprovechables.txt");

        try{
            FileWriter writer = new FileWriter(fileAprovechables,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    reciclado.getCantidad()+","+
                            reciclado.getPeso()+","+
                            reciclado.getMes()+","+
                            reciclado.getIdUsuario()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void cleanView(){
        cantidad.setText("");
        peso.setText("");
        mes.setSelection(0);
    }
}