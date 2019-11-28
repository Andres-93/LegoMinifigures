package com.example.pccom.legominifigures.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pccom.legominifigures.R;
import com.example.pccom.legominifigures.data.Figura;

import java.util.ArrayList;

public class FigurasSQLiteHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "FigurasDB";
    static final int DATABASE_VERSION = 2;

    static final String CREATE_TABLE_ALIMENTOS = "CREATE TABLE " + FigurasContract.FigurasEntry.TABLE_NAME +"( "+
            FigurasContract.FigurasEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
            FigurasContract.FigurasEntry.COLUMN_NAME + " TEXT NOT NULL ," +
            FigurasContract.FigurasEntry.COLUMN_URL + " TEXT NOT NULL ,"+
            FigurasContract.FigurasEntry.COLUMN_ESTADO + " TEXT NOT NULL ,"+
            FigurasContract.FigurasEntry.COLUMN_SERIE +" TEXT NOT NULL ,"+
            FigurasContract.FigurasEntry.COLUMN_ANIO + " INTEGER NOT NULL ," +
            FigurasContract.FigurasEntry.COLUMN_ACCESORIOS +" TEXT)";




    public FigurasSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALIMENTOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +
                FigurasContract.FigurasEntry.TABLE_NAME);
        onCreate(db);
    }


}
