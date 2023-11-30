package com.example.ecorecicla01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecorecicla01.Modelos.RegistroReciclaje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    TextView totalBolsasBlancas,totalBolsasVerdes,totalBolsasNegras, pesoTotalBlancas,
            pesoTotalNegras, pesoTotalVerdes;

    ImageView menu_reciclar, menu_estadisticas, menu_tips, menu_puntos,menu_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        totalBolsasBlancas = findViewById(R.id.Total_Bolsas_Blancas);
        totalBolsasNegras = findViewById(R.id.Total_Bolsas_Negras);
        totalBolsasVerdes = findViewById(R.id.Total_Bolsas_Verdes);

        pesoTotalNegras = findViewById(R.id.Total_Peso_Negras);
        pesoTotalBlancas = findViewById(R.id.Total_Peso_Blancas);
        pesoTotalVerdes = findViewById(R.id.Total_Peso_Verdes);

        menu_reciclar = findViewById(R.id.img_menu_registro);
        menu_estadisticas = findViewById(R.id.img_menu_estadistica);
        menu_tips = findViewById(R.id.img_menu_tips);
        menu_puntos = findViewById(R.id.img_menu_puntos);
        menu_home =findViewById(R.id.img_menu_home);

        Intent receive= getIntent();
        String id= receive.getStringExtra("idUser");

        Intent recicle1 = new Intent(getApplicationContext(), Categorias.class);
        Intent estadisticas = new Intent(getApplicationContext(), Estadisticas.class);
        Intent consejos1 = new Intent(getApplicationContext(), Consejos.class);
        Intent home = new Intent(getApplicationContext(), Home.class);

        File aprovechablesFile = new File(getFilesDir(),"aprovechables.txt");
        File noaprovechablesFile = new File(getFilesDir(),"noaprovechables.txt");
        File organicosFile = new File(getFilesDir(),"organicos.txt");

        ArrayList<RegistroReciclaje> blancaList = listaBlanca (aprovechablesFile,id);
        ArrayList<RegistroReciclaje> negraList = listaNegra (noaprovechablesFile,id);
        ArrayList<RegistroReciclaje> verdeList = listaVerde (organicosFile,id);

        totalAprovechables(blancaList);
        totalNoAprovechables(negraList);
        totalOrganicos(verdeList);


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

    public void totalAprovechables(ArrayList<RegistroReciclaje>list){
        int totalbolsas=0;
        int totalpeso=0;
        for (RegistroReciclaje i: list){
            totalbolsas+=i.getCantidad();
            totalpeso+=i.getPeso();
        }
        System.out.println("-*-*-*-*-*");
        System.out.println("La Cantidad de Bolsas Blancas es:"+totalbolsas);
        System.out.println("El Peso de las Bolsas Blancas es:"+totalpeso);

        totalBolsasBlancas.setText(String.valueOf(totalbolsas));
        pesoTotalBlancas.setText(String.valueOf(totalpeso));

    }

    public void totalNoAprovechables(ArrayList<RegistroReciclaje>list){
        int totalbolsas=0;
        int totalpeso=0;
        for (RegistroReciclaje i: list){
            totalbolsas+=i.getCantidad();
            totalpeso+=i.getPeso();
        }
        System.out.println("-*-*-*-*-*");
        System.out.println("La Cantidad de Bolsas Negras es:"+totalbolsas);
        System.out.println("El Peso de las Bolsas Negras es:"+totalpeso);
        totalBolsasNegras.setText(String.valueOf(totalbolsas));
        pesoTotalNegras.setText(String.valueOf(totalpeso));

    }

    public void totalOrganicos(ArrayList<RegistroReciclaje>list){
        int totalbolsas=0;
        int totalpeso=0;
        for (RegistroReciclaje i: list){
            totalbolsas+=i.getCantidad();
            totalpeso+=i.getPeso();
        }
        System.out.println("-*-*-*-*-*");
        System.out.println("La Cantidad de Bolsas Verdes es:"+totalbolsas);
        System.out.println("El Peso de las Bolsas Verdes es:"+totalpeso);
        totalBolsasVerdes.setText(String.valueOf(totalbolsas));
        pesoTotalVerdes.setText(String.valueOf(totalpeso));

    }


    public ArrayList<RegistroReciclaje> listaBlanca(File aprovechablesFile,String user){
        ArrayList<RegistroReciclaje> list= new ArrayList<>();

        try {
            FileReader fileReader=new FileReader(aprovechablesFile);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String item;
            while ((item=bufferedReader.readLine())!=null){
                String [] data= item.split(",");
                int cantidad= Integer.parseInt(data[0]);
                int peso= Integer.parseInt(data[1]);
                String mes= data[2];
                String userId= data[3];
                if (userId.equals(user)){
                    RegistroReciclaje reciclajeObj= new RegistroReciclaje(cantidad,peso,mes,userId);
                    list.add(reciclajeObj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<RegistroReciclaje> listaNegra(File noaprovechablesFile,String user){
        ArrayList<RegistroReciclaje> listn= new ArrayList<>();

        try {
            FileReader fileReader=new FileReader(noaprovechablesFile);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String item;
            while ((item=bufferedReader.readLine())!=null){
                String [] data= item.split(",");
                int cantidad= Integer.parseInt(data[0]);
                int peso= Integer.parseInt(data[1]);
                String mes= data[2];
                String userId= data[3];
                if (userId.equals(user)){
                    RegistroReciclaje reciclajeObj= new RegistroReciclaje(cantidad,peso,mes,userId);
                    listn.add(reciclajeObj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listn;
    }

    public ArrayList<RegistroReciclaje> listaVerde(File organicosFile,String user){
        ArrayList<RegistroReciclaje> listO= new ArrayList<>();

        try {
            FileReader fileReader=new FileReader(organicosFile);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String item;
            while ((item=bufferedReader.readLine())!=null){
                String [] data= item.split(",");
                int cantidad= Integer.parseInt(data[0]);
                int peso= Integer.parseInt(data[1]);
                String mes= data[2];
                String userId= data[3];
                if (userId.equals(user)){
                    RegistroReciclaje reciclajeObj= new RegistroReciclaje(cantidad,peso,mes,userId);
                    listO.add(reciclajeObj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listO;
    }

}