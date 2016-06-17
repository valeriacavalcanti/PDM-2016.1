package br.edu.ifpb.si.pdm.pdm20161;

import android.graphics.Bitmap;

/**
 * Created by admin on 17/06/16.
 */
public class Discente {
    private String nome;
    private Bitmap foto;

    public Discente(String nome) {
        this.nome = nome;
        this.foto = null;
    }

    public String getNome() {
        return nome;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
