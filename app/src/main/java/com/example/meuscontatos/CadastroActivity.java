package com.example.meuscontatos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meuscontatos.dao.ContatoDAO;
import com.example.meuscontatos.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText etNome = findViewById(R.id.etNome);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite o nome", Toast.LENGTH_SHORT).show();
                return;
            }
            Contato contato = new Contato(0, nome);
            ContatoDAO dao = new ContatoDAO(this);
            dao.inserirContato(contato);
            Toast.makeText(this, "Contato salvo", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}