package com.example.meuscontatos.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "contatos.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_CONTATOS_NAME = "contatos";
    public static final String CONTATOS_ID = "id";
    public static final String CONTATOS_NOME  = "nome";

    private static final String CREATE_TABLE_CONTATOS = "CREATE TABLE " + TABLE_CONTATOS_NAME + "("
            + CONTATOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CONTATOS_NOME + " TEXT NOT NULL);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }
}
