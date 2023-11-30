package com.example.ecorecicla01;


import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecorecicla01.Modelos.User;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegistroUsuario extends AppCompatActivity {

    Button nuevoUsuario;

    TextInputLayout name, email, phone, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nuevoUsuario = findViewById(R.id.btnNU);

        name = findViewById(R.id.NombreUsuario);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.Telefono);
        password1 = findViewById(R.id.Password1);
        password2 = findViewById(R.id.Password2);

        Intent nuevousuario= new Intent(getApplicationContext(), InicioSesion.class);

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUser()){
                    User user=createUser();
                    nuevousuario.putExtra("idUser",user.getIdUser());
                    storageUser(user);
                    Toast.makeText(getApplicationContext(),"Registro Exitoso"
                            ,Toast.LENGTH_LONG).show();
                    try {
                        sleep(500);
                        startActivity(nuevousuario);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),
                            "Asegurarse de que la información esta correcta",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    public boolean validateUser(){
    boolean state= true;

        if (name.getEditText().getText().toString().isEmpty()){
        name.setBoxBackgroundColor(Color.RED);
        state=false;
    }
        if (email.getEditText().getText().toString().isEmpty()){
        email.setBoxBackgroundColor(Color.RED);
        state=false;
    }
        if (phone.getEditText().getText().toString().isEmpty()){
        phone.setBoxBackgroundColor(Color.RED);
        state=false;
    }
        if (password1.getEditText().getText().toString().isEmpty()){
        password1.setBoxBackgroundColor(Color.RED);
        state=false;
    }
        if (password2.getEditText().getText().toString().isEmpty()){
        password2.setBoxBackgroundColor(Color.RED);
        state=false;
    }
        if (!password1.getEditText().getText().toString().equals(
            password2.getEditText().getText().toString())){
        password1.setBoxBackgroundColor(Color.RED);
        password2.setBoxBackgroundColor(Color.RED);
        state=false;
    }

        return state;
}
    public User createUser(){
        String name_user=name.getEditText().getText().toString();
        String id=idGenerator(name_user);
        String email_user=email.getEditText().getText().toString();
        String phone_user=phone.getEditText().getText().toString();
        String password= password1.getEditText().getText().toString();

        User user= new User(id,name_user,email_user,phone_user,password);

        return user;
    }

    public String idGenerator(String name){
        String id="";
        for (int i=0; i<2;i++){
            int random1= (int)(Math.random()*name.length());
            int random2= (int)(Math.random()*10000);
            id+=name.charAt(random1);
            id+=random2;
        }
        return id;
    }

    public void storageUser(User user){
        File fileUser= new File(getFilesDir(),"user.txt");

        try {
            FileWriter writer= new FileWriter(fileUser,true);



            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write( user.getIdUser()+","+
                    user.getName()+","+
                    user.getEmail()+","+
                    user.getPhone()+","+
                    user.getPassword()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception error){
            error.printStackTrace();
        }
    }
}