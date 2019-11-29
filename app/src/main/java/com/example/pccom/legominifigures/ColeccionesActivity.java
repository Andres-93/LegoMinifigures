package com.example.pccom.legominifigures;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pccom.legominifigures.data.Figura;
import com.example.pccom.legominifigures.db.FigurasSource;

import java.util.ArrayList;

public class ColeccionesActivity extends AppCompatActivity {

    public static final int SERIE1_TOTAL = 16;
    public static final int SERIE2_TOTAL = 16;
    public static final int SERIE3_TOTAL = 16;
    public static final int SERIE4_TOTAL = 16;
    public static final int SERIE5_TOTAL = 16;
    public static final int SERIE6_TOTAL = 16;
    public static final int SERIE7_TOTAL = 16;
    public static final int SERIE8_TOTAL = 16;
    public static final int SERIE9_TOTAL = 16;
    public static final int SERIE10_TOTAL = 17;
    public static final int SERIE11_TOTAL = 16;
    public static final int SERIE12_TOTAL = 16;
    public static final int SERIE13_TOTAL = 16;
    public static final int SERIE14_TOTAL = 16;

    public static final int CANTIDAD_TOTAL = 30;
    TextView total;
    FigurasSource fs;
    ArrayList<Figura> listaCompleta;
    Button btnS1;
    Button btnS2;
    Button btnS3;
    Button btnS4;
    Button btnS5;
    Button btnS6;
    Button btnS7;
    Button btnS8;
    Button btnS9;
    Button btnS10;
    Button btnS11;
    Button btnS12;
    Button btnS13;
    Button btnS14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colecciones);

        fs = new FigurasSource(this);
        btnS1 = findViewById(R.id.btnSerie1);

        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie1");
            }
        });
        btnS2 = findViewById(R.id.btnSerie2);
        btnS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie2");
            }
        });
        btnS3 = findViewById(R.id.btnSerie3);
        btnS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie3");
            }
        });
        btnS4 = findViewById(R.id.btnSerie4);
        btnS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie4");
            }
        });
        btnS5 = findViewById(R.id.btnSerie5);
        btnS5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie5");
            }
        });
        btnS6 = findViewById(R.id.btnSerie6);
        btnS6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie6");
            }
        });

        btnS7 = findViewById(R.id.btnSerie7);
        btnS7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie7");
            }
        });

        btnS8 = findViewById(R.id.btnSerie8);
        btnS8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie8");
            }
        });

        btnS9 = findViewById(R.id.btnSerie9);
        btnS9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie9");
            }
        });

        btnS10 = findViewById(R.id.btnSerie10);
        btnS10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie10");
            }
        });

        btnS11 = findViewById(R.id.btnSerie11);
        btnS11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie11");
            }
        });

        btnS12 = findViewById(R.id.btnSerie12);
        btnS12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie12");
            }
        });

        btnS13 = findViewById(R.id.btnSerie13);
        btnS13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie13");
            }
        });

        btnS14 = findViewById(R.id.btnSerie14);
        btnS14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verColeccion("Serie14");
            }
        });



        listaCompleta = fs.consultarTodos();

        total = findViewById(R.id.coleccionesComID);


        contarColecciones();

    }
    public void verColeccion(String numSerie){

        ArrayList<Figura> listaFiltrada = new ArrayList<>();
        listaFiltrada = fs.consultarPorSerie(numSerie);


        Intent i = new Intent(this, DetalleColeccion.class);
        i.putExtra("CLAVE_SERIE",numSerie);
        i.putExtra("CLAVE_COLECT", listaFiltrada);
        startActivity(i);
    }

    private void contarColecciones() {

        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int s4 = 0;
        int s5 = 0;
        int s6 = 0;
        int s7 = 0;
        int s8 = 0;
        int s9 = 0;
        int s10 = 0;
        int s11 = 0;
        int s12 = 0;
        int s13 = 0;
        int s14 = 0;
        int scompletas = 0;
        for (int i = 0; i< listaCompleta.size();i++){

            switch(listaCompleta.get(i).getSerie()) {
                case "Serie1":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s1++;
                    }
                    break;

                case "Serie2":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s2++;
                    }
                    break;
                case "Serie3":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s3++;
                    }
                    break;
                case "Serie4":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s4++;
                    }
                    break;
                case "Serie5":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s5++;
                    }
                    break;
                case "Serie6":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s6++;
                    }
                    break;
                case "Serie7":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s7++;
                    }
                    break;
                case "Serie8":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s8++;
                    }
                    break;
                case "Serie9":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s9++;
                    }
                    break;
                case "Serie10":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s10++;
                    }
                    break;

                case "Serie11":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s11++;
                    }
                    break;

                case "Serie12":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s12++;
                    }
                    break;

                case "Serie13":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s13++;
                    }
                    break;
                case "Serie14":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s14++;
                    }
                    break;




            }

        }

        total.setText(String.format(getString(R.string.completadas_1_d_2_d),scompletas,CANTIDAD_TOTAL));

        btnS1.setText(String.format(getString(R.string.serie_1_1_d_2_d),s1,SERIE1_TOTAL));
        btnS2.setText(String.format(getString(R.string.serie_2_1_d_2_d),s2,SERIE2_TOTAL));
        btnS3.setText(String.format(getString(R.string.serie_3_1_d_2_d),s3,SERIE3_TOTAL));
        btnS4.setText(String.format(getString(R.string.serie_4_1_d_2_d),s4,SERIE4_TOTAL));
        btnS5.setText(String.format(getString(R.string.serie_5_1_d_2_d),s5,SERIE5_TOTAL));
        btnS6.setText(String.format(getString(R.string.serie_6_1_d_2_d),s6,SERIE6_TOTAL));
        btnS7.setText(String.format(getString(R.string.serie_7_1_d_2_d),s7,SERIE7_TOTAL));
        btnS8.setText(String.format(getString(R.string.serie_8_1_d_2_d),s8,SERIE8_TOTAL));
        btnS9.setText(String.format(getString(R.string.serie_9_1_d_2_d),s9,SERIE9_TOTAL));
        btnS10.setText(String.format(getString(R.string.serie_10_1_d_2_d),s10,SERIE10_TOTAL));
        btnS11.setText(String.format(getString(R.string.serie_11_1_d_2_d),s11,SERIE11_TOTAL));
        btnS12.setText(String.format(getString(R.string.serie_12_1_d_2_d),s12,SERIE12_TOTAL));
        btnS13.setText(String.format(getString(R.string.serie_13_1_d_2_d),s13,SERIE13_TOTAL));
        btnS14.setText(String.format(getString(R.string.serie_14_1_d_2_d),s14,SERIE14_TOTAL));
    }

    @Override public void onResume(){
        super.onResume();

        listaCompleta.clear();
        listaCompleta = fs.consultarTodos();
        contarColecciones();


    }


}
