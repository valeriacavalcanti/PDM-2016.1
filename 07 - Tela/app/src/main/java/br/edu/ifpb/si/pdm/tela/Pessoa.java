package br.edu.ifpb.si.pdm.tela;

import java.io.Serializable;

/**
 * Created by admin on 31/05/16.
 */
public class Pessoa implements Serializable{
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.idade = idade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", nome, idade);
    }
}
