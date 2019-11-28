package com.example.pccom.legominifigures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.pccom.legominifigures.data.Figura;

import java.util.ArrayList;

public class DetalleColeccion extends AppCompatActivity {

    ImageView imgGeneral;

    AdapterFigura adapter;
    RecyclerView recicler;
    LinearLayoutManager miLayoutManager;
    ArrayList<Figura> listadoSerie;
    String serieEle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_coleccion);

        imgGeneral = findViewById(R.id.imgFondoSerieGeneral);



        listadoSerie = (ArrayList<Figura>) getIntent().getSerializableExtra("CLAVE_COLECT");
        serieEle = getIntent().getStringExtra("CLAVE_SERIE");


        recicler = findViewById(R.id.reciclerColect);
        recicler.setHasFixedSize(true);

        miLayoutManager = new LinearLayoutManager(this);
        adapter = new AdapterFigura(listadoSerie, this);

        recicler.setAdapter(adapter);
        recicler.setLayoutManager(miLayoutManager);
        recicler.setItemAnimator(new DefaultItemAnimator());


        imagenGlobal(serieEle);

    }

    private void imagenGlobal(String serieEle) {

        switch (serieEle){
            case "Serie1":imgGeneral.setImageDrawable(getDrawable(R.drawable.serie1general));break;
            case "Serie2":imgGeneral.setImageDrawable(getDrawable(R.drawable.serie2_generl));break;
            case "Serie3":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie3));break;
            case "Serie4":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie4));break;

        }




    }



}
