package com.example.pccom.legominifigures.db;

import android.provider.BaseColumns;

public class FigurasContract {


    public static abstract class FigurasEntry implements BaseColumns {

        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "nombre";
        public static final String COLUMN_URL = "urlImg";
        public static final String COLUMN_ESTADO = "enPosesion";
        public static final String COLUMN_SERIE = "serie";
        public static final String COLUMN_ANIO = "anio";
        public static final String COLUMN_ACCESORIOS = "accesorios";
        public static final String TABLE_NAME = "FIGURAS";


    }

}
