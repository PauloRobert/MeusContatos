package com.example.meuscontatos.model;

public class Contato {

    private int id;
    private String nome;
    private String telefone;

    public Contato(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = this.telefone;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

}

