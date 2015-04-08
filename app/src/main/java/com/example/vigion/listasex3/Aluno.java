package com.example.vigion.listasex3;

/**
 * Created by a48991 on 18-03-2015.
 */
public class Aluno {

    int numero;
    int id;
    String nome;

    public Aluno(int numero, String nome, int id) {
        this.numero = numero;
        this.id = id;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
