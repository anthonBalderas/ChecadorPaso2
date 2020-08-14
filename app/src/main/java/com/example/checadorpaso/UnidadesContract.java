package com.example.checadorpaso;

import android.provider.BaseColumns;

public class UnidadesContract {


    private UnidadesContract(){

    }


    public static final class UnidadesEntry implements BaseColumns {
        public static final String TABLE_NAME = "registroList";
        public static final String COLUMN_UNIDAD = "unidad";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_RUTA = "ruta";
        public static final String COLUMN_TIMESTAMP = "timestamp";


    }

    public static final class UnidadesEntry2 implements BaseColumns {
        public static final String TABLE_NAME = "registro2List";
        public static final String COLUMN_UNIDAD = "unidad";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_RUTA = "ruta";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }

    public static final class UnidadesEntry3 implements BaseColumns {
        public static final String TABLE_NAME = "registro3List";
        public static final String COLUMN_UNIDAD = "unidad";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_RUTA = "ruta";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }

    public static final class UnidadesEntry4 implements BaseColumns {
        public static final String TABLE_NAME = "registroHistList";
        public static final String COLUMN_UNIDAD = "unidad";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_RUTA = "ruta";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }
    public static final class UnidadesEntry5 implements BaseColumns {
        public static final String TABLE_NAME = "registroHist2List";
        public static final String COLUMN_UNIDAD = "unidad";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_RUTA = "ruta";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }
    public static final class UnidadesEntry6 implements BaseColumns {
        public static final String TABLE_NAME = "registroHist3List";
        public static final String COLUMN_UNIDAD = "unidad";
        public static final String COLUMN_HORA = "hora";
        public static final String COLUMN_RUTA = "ruta";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }

}


