package com.example.meuscontatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.meuscontatos.model.Contato;
import com.example.meuscontatos.sqlite.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private final SQLiteDatabase db;

    public ContatoDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void inserirContato(Contato contato) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.CONTATOS_NOME, contato.getNome());
        values.put(DbHelper.CONTATOS_TELEFONE, contato.getTelefone());

        db.insert(DbHelper.TABLE_CONTATOS_NAME, null, values);
    }

    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<>();
        Cursor cursor = db.query(
                DbHelper.TABLE_CONTATOS_NAME,
                new String[]
                        {
                            DbHelper.CONTATOS_ID,
                            DbHelper.CONTATOS_NOME,
                            DbHelper.CONTATOS_TELEFONE
                        },null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                String telefone = cursor.getString(2);
                Contato contato = new Contato(id, nome, telefone);
                contatos.add(contato);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contatos;
    }

}
