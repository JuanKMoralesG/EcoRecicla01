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

public class Organicos extends AppCompatActivity {

    EditText cantidad,peso;

    Spinner mes;

    Button registrarReciclaje;
    ImageView menu_reciclar, menu_estadisticas, menu_tips, menu_puntos,menu_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organicos);

        cantidad = findViewById(R.id.cant_organicos);
        peso = findViewById(R.id.peso_organicos);
        mes = findViewById(R.id.spinnerMonthsOrg);

        menu_reciclar = findViewById(R.id.img_menu_registro);
        menu_estadisticas = findViewById(R.id.img_menu_estadistica);
        menu_tips = findViewById(R.id.img_menu_tips);
        menu_puntos = findViewById(R.id.img_menu_puntos);
        menu_home =findViewById(R.id.img_menu_home);

        Intent receive = getIntent();
        String idUser = receive.getStringExtra("idUser");

        Intent recicle1 = new Intent(getApplicationContext(), Categorias.class);
        Intent estadisticas = new Intent(getApplicationContext(), Estadisticas.class);
        Intent consejos1 = new Intent(getApplicationContext(), Consejos.class);
        Intent home = new Intent(getApplicationContext(), Home.class);

        registrarReciclaje = findViewById(R.id.btnRegistrar_Organicos);

        registrarReciclaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cantidad.getText().toString().isEmpty()||peso.getText().toString().isEmpty()||
                        mes.getSelectedItem().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Todos los campos deben estar diligenciados",
                            Toast.LENGTH_LONG).show();
                }else{
                    int cantidadOrganicos = Integer.parseInt(cantidad.getText().toString());
                    int pesoOrganicos = Integer.parseInt(peso.getText().toString());
                    String mesOrganicos = mes.getSelectedItem().toString();
                    RegistroReciclaje reciclado = new RegistroReciclaje(cantidadOrganicos,pesoOrganicos,mesOrganicos,idUser);
                    saveOrganicos(reciclado);
                    cleanView2();
                    Toast.makeText(getApplicationContext(),"Registro Exitoso",Toast.LENGTH_LONG).show();
                }
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

    public void saveOrganicos(RegistroReciclaje reciclado){
        File fileOrganicos = new File(getFilesDir(),"organicos.txt");

        try{
            FileWriter writer = new FileWriter(fileOrganicos,true);
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

    public void cleanView2(){
        cantidad.setText("");
        peso.setText("");
        mes.setSelection(0);
    }
}