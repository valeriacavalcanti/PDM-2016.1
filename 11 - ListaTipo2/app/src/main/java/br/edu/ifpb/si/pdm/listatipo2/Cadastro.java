package br.edu.ifpb.si.pdm.listatipo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 07/06/16.
 */
public class Cadastro{
    private List<String> dados;

    public Cadastro() {
        this.dados = new ArrayList<String>();
        this.insere();
    }

    private void insere(){
        this.dados.add("um");
        this.dados.add("dois");
        this.dados.add("três");
        this.dados.add("quatro");
        this.dados.add("cinco");
        this.dados.add("seis");
        this.dados.add("sete");
        this.dados.add("oito");
        this.dados.add("nove");
        this.dados.add("dez");
        this.dados.add("onze");
        this.dados.add("doze");
    }

    public List<String> get(){
        return this.dados;
    }

    public int quantidade(){
        return this.dados.size();
    }

    public void clear(){
        this.dados.clear();
    }

    public void delete(int pos){
        this.dados.remove(pos);
    }
}
