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
    public static final int CANTIDAD_TOTAL = 30;
    TextView total;
    FigurasSource fs;
    ArrayList<Figura> listaCompleta;
    Button btnS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colecciones);

        fs = new FigurasSource(this);
        btnS1 = findViewById(R.id.btnSerie1);

        listaCompleta = fs.consultarTodos();

        total = findViewById(R.id.coleccionesComID);


        contarColecciones();

    }
    public void verColeccion(View v){

        Intent i = new Intent(this, DetalleColeccion.class);
        i.putExtra("CLAVE_COLECT", listaCompleta);
        startActivity(i);
    }

    private void contarColecciones() {

        int s1 = 0;
        int scompletas = 0;
        for (int i = 0; i< listaCompleta.size();i++){

            switch(listaCompleta.get(i).getSerie()) {
                case "Serie1":
                    if(listaCompleta.get(i).getEnPosesion() == 1){
                        s1++;
                    }
                    break;

            }

        }

        total.setText(String.format(getString(R.string.completadas_1_d_2_d),scompletas,CANTIDAD_TOTAL));

        btnS1.setText(String.format(getString(R.string.serie_1_1_d_2_d),s1,16));
    }
}
