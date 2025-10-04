package com.example.meuscontatos.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meuscontatos.R;
import com.example.meuscontatos.model.Contato;

import java.util.List;

public class ContatoAdapter extends BaseAdapter {

    private final List<Contato> contatos;
    private final Activity activity;

    public ContatoAdapter(List<Contato> contatos, Activity activity) {
        this.contatos = contatos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int i) {
        return contatos.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = activity.getLayoutInflater().inflate(R.layout.lista_contato, viewGroup, false);

        Contato contato = contatos.get(i);
        TextView tvContatoLista = view.findViewById(R.id.tvContatoLista);
        tvContatoLista.setText(contato.getNome());

        return view;
    }
}
