package com.example.ecorecicla01;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla01.Modelos.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InicioSesion extends AppCompatActivity {

    TextView registrarse;
    Button login;

    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        registrarse=findViewById(R.id.textViewCrearUsuario);
        login=findViewById(R.id.button);
        user=findViewById(R.id.editTextUserLogin);
        password=findViewById(R.id.editTextPassword);

        File fileReader = new File(getFilesDir(), "user.txt");

        ArrayList<User> usersList = listUsers(fileReader);
        Intent home= new Intent(getApplicationContext(), Home.class);

        Intent register= new Intent(getApplicationContext(), RegistroUsuario.class);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = false;
                if(user.getText().toString().isEmpty() ||
                password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ambos campos deben estar completos",
                            Toast.LENGTH_LONG).show();
                }else{
                    for(User u: usersList){
                        if(u.getName().equals(user.getText().toString())||
                        u.getEmail().equals(user.getText().toString())||
                        u.getPhone().equals(user.getText().toString())){
                            state=true;
                            if(u.getPassword().equals(password.getText().toString())){
                                home.putExtra("idUser",u.getIdUser());

                                Toast.makeText(getApplicationContext(), "La información son correcto",
                                        Toast.LENGTH_SHORT).show();
                                try{
                                    sleep(500);
                                }catch (InterruptedException e){
                                    throw new RuntimeException(e);
                                }

                                startActivity(home);
                                break;
                            }else{
                                Toast.makeText(getApplicationContext(), "La contraseña es incorrecta.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }           if(!state){
                                Toast.makeText(getApplicationContext(), "Este Usuario no está registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(register);
            }
        });
    }
    public ArrayList<User> listUsers(File fileUser){
        ArrayList<User> list= new ArrayList<>();
        try {
            FileReader fileReader= new FileReader(fileUser);
            BufferedReader reader= new BufferedReader(fileReader);
            String user;

            while ((user=reader.readLine())!=null){
                String[] userArray = user.split(",");
                String id= userArray[0];
                String name= userArray[1];
                String password= userArray[2];
                String email= userArray[3];
                String phone= userArray[4];


                User userObj= new User(id, name, password, email, phone);
                list.add(userObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}