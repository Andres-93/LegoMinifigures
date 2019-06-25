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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_coleccion);

        imgGeneral = findViewById(R.id.imgFondoSerieGeneral);

        imgGeneral.setImageDrawable(getDrawable(R.drawable.serie1general));

        listadoSerie = (ArrayList<Figura>) getIntent().getSerializableExtra("CLAVE_COLECT");

        recicler = findViewById(R.id.reciclerColect);
        recicler.setHasFixedSize(true);

        miLayoutManager = new LinearLayoutManager(this);
       adapter = new AdapterFigura(listadoSerie, this);

        recicler.setAdapter(adapter);
        recicler.setLayoutManager(miLayoutManager);
        recicler.setItemAnimator(new DefaultItemAnimator());


    }
}
