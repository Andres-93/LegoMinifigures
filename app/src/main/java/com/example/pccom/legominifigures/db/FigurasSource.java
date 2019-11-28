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
