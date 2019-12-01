package com.example.pccom.legominifigures.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pccom.legominifigures.R;
import com.example.pccom.legominifigures.data.Figura;

import java.util.ArrayList;

public class FigurasSource {

    private FigurasSQLiteHelper fhs;

    private Context contexto;

    public FigurasSource(Context contexto) {
        this.contexto = contexto;
        fhs = new FigurasSQLiteHelper(contexto);
    }

    public SQLiteDatabase openReadable(){
        return fhs.getReadableDatabase();
    }

    public SQLiteDatabase openWriteable(){
        return fhs.getWritableDatabase();
    }

    public void close(SQLiteDatabase database) {
        database.close();
    }


    public ArrayList<Figura> consultarTodos(){
        ArrayList<Figura>  lista = new ArrayList<>();

        SQLiteDatabase database = openReadable();


        String[] columnas = {FigurasContract.FigurasEntry.COLUMN_ID,
                FigurasContract.FigurasEntry.COLUMN_NAME,
                FigurasContract.FigurasEntry.COLUMN_URL,
                FigurasContract.FigurasEntry.COLUMN_ESTADO,
                FigurasContract.FigurasEntry.COLUMN_SERIE,
                FigurasContract.FigurasEntry.COLUMN_ANIO,
                FigurasContract.FigurasEntry.COLUMN_ACCESORIOS};
        Cursor cursor = database.query(FigurasContract.FigurasEntry.TABLE_NAME,columnas,null,null,null,null,null);


        int id;
        String nombre;
        String url;
        int estado;
        String serie;
        int anio;
        String accesorios;

        if(cursor.moveToFirst()){
            do{

                id = cursor.getInt(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_ID));
                nombre = cursor.getString(cursor.getColumnIndex( FigurasContract.FigurasEntry.COLUMN_NAME));
                url = cursor.getString(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_URL));
                estado = cursor.getInt(cursor.getColumnIndex( FigurasContract.FigurasEntry.COLUMN_ESTADO));
                serie = cursor.getString(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_SERIE));
                anio = cursor.getInt(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_ANIO));
                accesorios = cursor.getString(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_ACCESORIOS));
                lista.add(new Figura(id,nombre,url,estado,serie,anio,accesorios));

            }while(cursor.moveToNext());
        }

        cursor.close();
        database.close();

        return lista;
    }
    public int cambioEstado(long id,int estado){
        int resultado = 0;

        ContentValues cv = new ContentValues();

        SQLiteDatabase db = openWriteable();


        if(estado == 0){
            cv.put("enPosesion", 1);
        }else{
            cv.put("enPosesion", 0);
        }

        db.update(FigurasContract.FigurasEntry.TABLE_NAME, cv,FigurasContract.FigurasEntry.COLUMN_ID + " = " + id, null);


        db.close();
        return resultado;
    }

    public ArrayList<Figura> consultarPorSerie(String serie){
        ArrayList<Figura>  lista = new ArrayList<>();

        SQLiteDatabase database = openReadable();

        String select = "SELECT *" + " FROM " +
                FigurasContract.FigurasEntry.TABLE_NAME + " WHERE " + FigurasContract.FigurasEntry.COLUMN_SERIE+ " = ?";

        String[] args = {serie};

        Cursor cursor = database.rawQuery(select,args);


        int id;
        String nombre;
        String url;
        int estado;
        String serieF;
        int anio;
        String accesorios;

        if(cursor.moveToFirst()){
            do{

                id = cursor.getInt(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_ID));
                nombre = cursor.getString(cursor.getColumnIndex( FigurasContract.FigurasEntry.COLUMN_NAME));
                url = cursor.getString(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_URL));
                estado = cursor.getInt(cursor.getColumnIndex( FigurasContract.FigurasEntry.COLUMN_ESTADO));
                serieF = cursor.getString(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_SERIE));
                anio = cursor.getInt(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_ANIO));
                accesorios = cursor.getString(cursor.getColumnIndex(FigurasContract.FigurasEntry.COLUMN_ACCESORIOS));
                lista.add(new Figura(id,nombre,url,estado,serieF,anio,accesorios));

            }while(cursor.moveToNext());
        }

        cursor.close();
        database.close();

        return lista;
    }


    public void llenoInicial(Context cont){

        ArrayList<Figura> todos = this.consultarTodos();

        if(todos.isEmpty()) {

            ArrayList<Figura> cargaInicial = new ArrayList<>();
            //Serie1
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_cazador),"cazador", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_animadora),"animadora", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_cavernicola),"caver", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_payaso),"payaso", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_zombie),"zombie", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_skater),"skater", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_robot),"robot", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_maniqui),"maniqui", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_mago),"mago", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_luchador),"luchador", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_enfermera),"enfermera", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_ninja),"ninja", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_espacio),"espacio", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_bosque),"bosqui", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_buceador),"buceador", 0,"Serie1", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie1_cowboy),"cowboy", 0,"Serie1", 2010,"accesorios"));

            //Serie2
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_espartano),"espartano", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_bruja),"bruja", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_circo),"circo", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_disco),"disco", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_esquiador),"esquiador", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_estrellapop),"estrella", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_explorador),"explorador", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_faraon),"faraon", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_karate),"karate", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_levantamiento),"levantador", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_mex),"mexicano", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_mimo),"mimo", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_poli),"policia", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_socorrista),"socorrista", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_surfero),"surfero", 0,"Serie2", 2010,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie2_vampiro),"vampiro", 0,"Serie2", 2010,"accesorios"));


            //Serie3
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_alien),"alien", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_baseball),"baseball", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_indio),"indio", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_elfo),"elfo", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_gorila),"gorila", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_hula),"hula", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_momia),"momia", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_pesca),"pesca", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_piloto),"piloto", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_racer),"racer", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_rapero),"rapero", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_samurai),"samurai", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_snow),"snow", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_sumo),"sumo", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_tenis),"tenis", 0,"Serie3", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie3_villano),"villano", 0,"Serie3", 2011,"accesorios"));

            //Serie4
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_artista),"artista", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_chicasurfer),"chicasurfer", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_cientifico),"cientifico", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_futbol),"futbol", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_nomo),"gnomo", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_hockey),"hockey", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_loboman),"hombrelobo", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_kimono),"kimono", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_mosnter),"monster", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_mosquetero),"mosquetero", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_nave),"nave", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_nuclear),"nuclear", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_patinadora),"patinadora", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_punk),"punk", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_skater),"skater", 0,"Serie4", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie4_vik),"viking", 0,"Serie4", 2011,"accesorios"));

            //Serie5
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_boxeo),"boxeo", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_cavewoman),"cavergirl", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_cleopatra),"cleopatra", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_detec),"detec", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_enanomaligno),"enanomalo", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_fitness),"fitness", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_gangster),"gangster", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_gladiador),"gladiador", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_graduado),"graduado", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_guardiareal),"guardiareal", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_lagarto),"lagarto", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_lenador),"lenador", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_payasopeque),"payasopeque", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_pescadorhielo),"pescahielo", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_snowchico),"snowchico", 0,"Serie5", 2011,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie5_zoo),"zoo", 0,"Serie5", 2011,"accesorios"));


            //Serie6
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_alienclass),"alienclasico", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_bandido),"bandido", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_carnicero),"carnicero", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_chicaskate),"chicaskate", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_cirujano),"cirujano", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_dormilon),"dormilon", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_genio),"genio", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_lepre),"lepre", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_libertad),"libertad", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_luchador),"luchador", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_mecanico),"mecanico", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_minotauro),"minotauro", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_romano),"romano", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_chicagalactica),"chicagalactica", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_flamenco),"flamenco", 0,"Serie6", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie6_robot),"robot", 0,"Serie6", 2012,"accesorios"));

            //Serie7
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_azteca),"azteca", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_caperucita),"caperucita", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_chicavik),"chicaviking", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_conejo),"conejo", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_gaitero),"escoces", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_guerreromalo),"guerreromalo", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_hippie),"hippie", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_hombrejungla),"hombrejungla", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_motorista),"motorista", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_nadadora),"nadadora", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_novia),"novia", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_patrulla),"patrulla", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_programador),"programador", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_reyoceano),"reyoceano", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_tenista),"tenistaace", 0,"Serie7", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie7_rockera),"rockera", 0,"Serie7", 2012,"accesorios"));

            //Serie8
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_aleman),"alemanpan", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_alienvillano),"alienvillano", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_animadora),"anim", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_buzo),"buzo", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_capipirata),"capitanpirata", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_conquistador),"conquistador", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_cowgirl),"cowgirl", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_dj),"dj", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_hamlet),"espian", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_hada),"hada", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_negocio),"hombrenegocios", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_americafutbol),"jugadoramericanofutbol", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_robotmalo),"robotmalo", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_santa),"santa", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_skiadora),"skiadora", 0,"Serie8", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie8_vampiro),"vampiromur", 0,"Serie8", 2012,"accesorios"));


            //Serie9
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_pitonisa),"adivina", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_alienveng),"alienvengador", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_buenoymalo),"buenoymalo", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_camarero),"camarero", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_ciclope),"ciclope", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_disfrazpollo),"disfrazpollo", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_elfa),"elfa", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_emperadorrom),"emperadorromano", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_hollywood),"estrellahollywood", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_font),"fontaneto", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_guerrero),"guerreroheroico", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_juez),"juez", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_patin),"patinadoraderby", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_poli),"police", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_robot),"robotcombate", 0,"Serie9", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie9_sirena),"sirena", 0,"Serie9", 2013,"accesorios"));


            //Serie10
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_abu),"abuelo", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_biblio),"bibliotecaria", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_capibarco),"capitanbarco", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_abeja),"chicaabeja", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_comandanterom),"comandanteromano", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_guerreroindio),"guerreroindio", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_influn),"influencer", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_baseball),"jugadorbaseball", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_mecani),"mecanicomoto", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_medusa),"medusa", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_gold),"mrgold", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_mujguerrera),"mujerguerrera", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_paintball),"paintball", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_paraca),"paracaidista", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_payaso),"payasotriste", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_pintor),"pintor", 0,"Serie10", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie10_soldadore),"soldadorevolucionario", 0,"Serie10", 2013,"accesorios"));


            //Serie11
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_abuela),"abuela", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_barbaro),"barbaro", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_camerara),"camareraochentera", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_chiccientifica),"chicacientifica", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_chicapretz),"chicapretz", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_robotgirl),"chicarobot", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_elfo),"elfonavidad", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_espanta),"espanta", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_jengibre),"gengibre", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_guerreroisla),"guerreroisla", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_mechmalo),"mechmalo", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_montanero),"monstanero", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_poli),"poli", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_saxo),"saxo", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_soldador),"soldador", 0,"Serie11", 2013,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie11_yeti),"yeti", 0,"Serie11", 2013,"accesorios"));


            //Serie12
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_bufon),"bufon", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_chicagnio),"chicagenio", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_cerdo),"chicocerdo", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_diosa),"diosaguerrera", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_rock),"estrellarock", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_gotica),"gotica", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_guardacostas),"guardacostas", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_hechizero),"hechizero", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_huno),"huno", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_mineroespacial),"mineroespacial", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_mosquetero),"mosqueteroespada", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_princess),"princesacuento", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_prospector),"prospector", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_rastreador),"rastreador", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_pizza),"repartidorpizza", 0,"Serie12", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie12_videogamer),"videogamer", 0,"Serie12", 2014,"accesorios"));

            //Serie13
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_carpin),"carpintero", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_ciclop),"chicaciclope", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_unicor),"chicaunicornio", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_disco),"discodiva", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_serpi),"encantadorserpientes", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_esgrima),"esgrima", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_goblin),"goblin", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_egipcio),"guerreroegipcio", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_hechizer),"hechizeromaligno", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_hotdog),"hotdog", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_paleo),"paleontologa", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_rey),"reyclasico", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_samurai),"samuraichica", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_sherif),"sheriff", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_alien),"tropaalienigena", 0,"Serie13", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie13_tropaespacial),"tropaespacial", 0,"Serie13", 2014,"accesorios"));


            //Serie14
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_animzombie),"animadorazombie", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_banshee),"banshee", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_bruja),"brujita", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_tigre),"chicatigre", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_esqueleto),"chicoesqueleto", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_cientif),"cientificomonstruo", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_espect),"espectro", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_gargo),"gargola", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_lobo),"hombrelobito", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_ladyarana),"ladyarana", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_bigfoot),"piesgrande", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_pirata),"piratazombie", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_planta),"plantamonster", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_rock),"rockeromonstruo", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_volador),"voladormonster", 0,"Serie14", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie14_zomb),"zombienegocios", 0,"Serie14", 2014,"accesorios"));


            //SerieMovie1
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_badcop),"badcop", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_calamidad),"calamidad", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_emet),"emet", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_gail),"gail", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_larry),"larry", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_lincon),"lincin", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_marsha),"marsha", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_oeste),"oeste", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_panda),"panda", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_pantalon),"pants", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_presi),"presidente", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_scrachen),"scrachen", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_shakes),"shakespire", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_taco),"taco", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_velms),"velma", 0,"SerieMovie1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesmovie1_wiley),"wiley", 0,"SerieMovie1", 2014,"accesorios"));


            //SerieEquipoOlimpico
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olymparquera),"arquero", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olympbox),"boxeador", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olympcorredor),"corredor", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olympgim),"gimnasta", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olympjinete),"jinete", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olympjudo),"judo", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olymppesas),"levantar", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olympnadar),"nadador", 0,"SerieEquipoOlimpico", 2012,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie_olymptenis),"tenista", 0,"SerieEquipoOlimpico", 2012,"accesorios"));


            //SerieSimpsons1
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_abuelo),"aby", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_apu),"apu", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_bart),"bart", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_burns),"burns", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_homer),"homer", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_krusty),"krusty", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_lisa),"lisa", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_maggie),"maggie", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_marge),"marge", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_milh),"milhouse", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_nedo),"ned", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_nelson),"nelson", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_pica),"pica", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_ralph),"ralph", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_rasca),"rasca", 0,"SerieSimpsons1", 2014,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson1_wiggum),"wiggum", 0,"SerieSimpsons1", 2014,"accesorios"));



            //SerieSimpsons2
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_bartman),"bartman", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_comic),"comic", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_doctor),"doctor", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_edna),"edna", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_fallout),"fallout", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_frink),"frink", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_hans),"hans", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_homer),"homercita", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_lisa),"lisabola", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_maggie),"maggieperro", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_marge),"margecita", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_martin),"martin", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_paty),"patty", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_selma),"selma", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_smith),"smith", 0,"SerieSimpsons2", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.seriesimpson2_willy),"will", 0,"SerieSimpsons2", 2015,"accesorios"));



            //Serie15
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_animal),"animalcontrol", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_astro),"astronauta", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_bailar),"bailarina", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_conser),"conserje", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_granja),"fauno", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_fauno),"granjero", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_guerrero),"guerrerooso", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_volador),"guerrerovolador", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_herido),"herido", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_joya),"joyaladrona", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_kendo),"kendo", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_mech),"lasermech", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_lucha),"luchalibre", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_reina),"reina", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_tibu),"tiburon", 0,"Serie15", 2015,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie15_tribal),"tribalgirl", 0,"Serie15", 2015,"accesorios"));


            //Serie16
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_cybor),"cyborg", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_pingu),"chicopinguino", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_desert),"desiertoguerrero", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_foto),"fotosalvaje", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_gotic),"gotico", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_kick),"kickboxer", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_mariachi),"mariachi", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_demon),"minidemonio", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_ninera),"ninera", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_perro),"perroganador", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_pirata),"piratilla", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_platano),"platano", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_reina),"reinahielo", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_rogue),"rogue", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_sende),"senderista", 0,"Serie16", 2016,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie16_spy),"spy", 0,"Serie16", 2016,"accesorios"));


            //Serie17
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_asalt),"asaltador", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_chef),"chef", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_maiz),"chicomaiz", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_elfa),"elfamaiden", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_enano),"enanocombate", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_forzu),"forzudo", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_frances),"frances", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_gladiador),"gladiadorromano", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_heroe),"heroeespacialretro", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_mari),"mariposita", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_rocket),"ninorocket", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_profe),"profebaile", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_surf),"surferpro", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_hotdog),"vendehotdog", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_vete),"vete", 0,"Serie17", 2017,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie17_yuppie),"yuppie", 0,"Serie17", 2017,"accesorios"));

            //Serie18
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_cactus),"caxctus", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_chicacump),"chicacumple", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_chicocump),"chicocumple", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_gatof),"chicagato", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_legochica),"chicalego", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_legochico),"chicolego", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_arana),"disfrazarana", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_car),"disfrazcoche", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_cowboy),"disfrazcowboy", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_unic),"disfrazunicornio", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_dragon),"dragon", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_elefant),"elefante", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_flor),"flordisfraz", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_payaso),"payasofiesto", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_poli),"policlasico", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_cohete),"pritecnia", 0,"Serie18", 2018,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie18_tarta),"tartatio", 0,"Serie18", 2018,"accesorios"));

            //Serie19
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_bici),"bicimontana", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_bomber),"bombera", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_zorro),"chicazorro", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_ducha),"chicoducha", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_perro),"cuidadoraperros", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_pizza),"disfrazpizza", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_guerro),"guerrerosusto", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_jardin),"jardinera", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_jungla),"junglaexplorador", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_momia),"momiareina", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_oso),"osoarcoiris", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_programadora),"programadora", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_mono),"reymono", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_rugby),"rugbyplayer", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_soldado),"soldadogalactico", 0,"Serie19", 2019,"accesorios"));
            cargaInicial.add(new Figura(cont.getString(R.string.serie19_gamer),"videojugador", 0,"Serie19", 2019,"accesorios"));






            SQLiteDatabase db = openReadable();

            db.beginTransaction();

            ContentValues aliValues = null;

            for (int i = 0; i < cargaInicial.size(); i++) {
                aliValues = new ContentValues();
                aliValues.put(FigurasContract.FigurasEntry.COLUMN_NAME, cargaInicial.get(i).getNombre());
                aliValues.put(FigurasContract.FigurasEntry.COLUMN_URL, cargaInicial.get(i).getUrlImg());
                aliValues.put(FigurasContract.FigurasEntry.COLUMN_ESTADO, cargaInicial.get(i).getEnPosesion());
                aliValues.put(FigurasContract.FigurasEntry.COLUMN_SERIE, cargaInicial.get(i).getSerie());
                aliValues.put(FigurasContract.FigurasEntry.COLUMN_ANIO, cargaInicial.get(i).getAnio());
                aliValues.put(FigurasContract.FigurasEntry.COLUMN_ACCESORIOS, cargaInicial.get(i).getAccesorios());

                db.insert(FigurasContract.FigurasEntry.TABLE_NAME, null, aliValues);
            }

            db.setTransactionSuccessful();
            db.endTransaction();
        }




    }
}
