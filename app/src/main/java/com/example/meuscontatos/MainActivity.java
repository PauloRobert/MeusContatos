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

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        Button btnNovo = findViewById(R.id.btnNovoContato);
        btnNovo.setOnClickListener(v -> startActivity(new Intent(this, CadastroActivity.class)));
        loadContatos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadContatos();
    }

    private void loadContatos(){
        ContatoDAO contatoDAO = new ContatoDAO(this);

        Contato c1 = new Contato(1, "Contato 1");
        Contato c2 = new Contato(2, "Contato 2");
        Contato c3 = new Contato(3, "Contato 3");
        contatoDAO.inserirContato(c1);
        contatoDAO.inserirContato(c2);
        contatoDAO.inserirContato(c3);

        List<Contato> contatos = contatoDAO.listarContatos();
        //List<Contato> contatos = fakeContatos();
        ContatoAdapter contatoAdapter = new ContatoAdapter(contatos, this);

        ListView lvContatos = findViewById(R.id.lvContatos);
        lvContatos.setAdapter(contatoAdapter);
    }

    private List<Contato> fakeContatos(){
        Contato c1 = new Contato(1, "Contato 1");
        Contato c2 = new Contato(2, "Contato 2");
        Contato c3 = new Contato(3, "Contato 3");

        List<Contato> contatos = Arrays.asList(c1, c2, c3);
        return contatos;
    }
}