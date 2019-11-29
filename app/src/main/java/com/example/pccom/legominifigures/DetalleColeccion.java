package com.example.pccom.legominifigures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.pccom.legominifigures.data.Figura;
import com.example.pccom.legominifigures.db.FigurasSource;

import java.util.ArrayList;

public class DetalleColeccion extends AppCompatActivity {

    ImageView imgGeneral;

    AdapterFigura adapter;
    RecyclerView recicler;
    LinearLayoutManager miLayoutManager;
    ArrayList<Figura> listadoSerie;
    String serieEle;
    FigurasSource fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_coleccion);

        imgGeneral = findViewById(R.id.imgFondoSerieGeneral);
        fs = new FigurasSource(this);


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

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Figura fig =listadoSerie.get(recicler.getChildAdapterPosition(v));

                fs.cambioEstado(fig.getId(),fig.getEnPosesion());

                listadoSerie = fs.consultarPorSerie(serieEle);

                adapter.cambioLista(listadoSerie);
                adapter.notifyDataSetChanged();

            }
        });

    }

    private void imagenGlobal(String serieEle) {

        switch (serieEle){
            case "Serie1":imgGeneral.setImageDrawable(getDrawable(R.drawable.serie1general));break;
            case "Serie2":imgGeneral.setImageDrawable(getDrawable(R.drawable.serie2_generl));break;
            case "Serie3":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie3));break;
            case "Serie4":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie4));break;
            case "Serie5":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie5));break;
            case "Serie6":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie6));break;
            case "Serie7":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie7));break;
            case "Serie8":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie8));break;
            case "Serie9":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie9));break;
            case "Serie10":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie10));break;
            case "Serie11":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie11));break;
            case "Serie12":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie12));break;
            case "Serie13":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie13));break;
            case "Serie14":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserie14));break;
            case "SerieMovie1":imgGeneral.setImageDrawable(getDrawable(R.drawable.logomovie1));break;
            case "SerieEquipoOlimpico":imgGeneral.setImageDrawable(getDrawable(R.drawable.logoserieolymp));break;
            case "SerieSimpsons1":imgGeneral.setImageDrawable(getDrawable(R.drawable.logosimpson1));break;
            case "SerieSimpsons2":imgGeneral.setImageDrawable(getDrawable(R.drawable.logosimpsonserie2));break;

        }




    }



}
