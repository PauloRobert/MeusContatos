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
        EditText etTelefone = findViewById(R.id.etTelefone);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();
            String telefone = etTelefone.getText().toString().trim();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite o nome", Toast.LENGTH_SHORT).show();
                return;
            }
            if (telefone.length() < 10 || telefone.length() > 11) {
                Toast.makeText(this, "Telefone deve ter 10 ou 11 dígitos", Toast.LENGTH_SHORT).show();
                return;
            }
            Contato contato = new Contato(0, nome, telefone);
            ContatoDAO dao = new ContatoDAO(this);
            dao.inserirContato(contato);
            Toast.makeText(this, "Contato salvo", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}