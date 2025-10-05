package com.example.meuscontatos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.meuscontatos.adapter.ContatoAdapter;
import com.example.meuscontatos.dao.ContatoDAO;
import com.example.meuscontatos.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContatoAdapter contatoAdapter;
    private List<Contato> contatos;
    private ContatoDAO contatoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contatoDAO = new ContatoDAO(this);

        // inicializa lista com dados do banco
        contatos = new ArrayList<>(contatoDAO.listarContatos());
        contatoAdapter = new ContatoAdapter(contatos, this);

        ListView lvContatos = findViewById(R.id.lvContatos);
        lvContatos.setAdapter(contatoAdapter);

        Button btnNovo = findViewById(R.id.btnNovoContato);
        btnNovo.setOnClickListener(v -> startActivity(new Intent(this, CadastroActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // sempre que voltar pra tela principal, atualiza a lista
        contatos.clear();
        contatos.addAll(contatoDAO.listarContatos());
        contatoAdapter.notifyDataSetChanged();
    }
}