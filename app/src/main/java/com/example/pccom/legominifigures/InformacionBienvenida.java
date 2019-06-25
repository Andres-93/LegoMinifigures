package com.example.pccom.legominifigures;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pccom.legominifigures.db.FigurasSource;

public class InformacionBienvenida extends AppCompatActivity {
    FigurasSource fs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_bienvenida);
        fs = new FigurasSource(this);
        fs.llenoInicial(this);
    }


    public void acceder(View v){
        Intent i = new Intent(this,ColeccionesActivity.class);
        startActivity(i);
    }

}
