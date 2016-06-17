package br.edu.ifpb.si.pdm.pdm20161;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 17/06/16.
 */
public class Turma {
    private List<Discente> discentes;

    public Turma() {
        this.discentes = new ArrayList<Discente>();
    }

    public void add(Discente sh){
        this.discentes.add(sh);
    }

    public int getQuantidade(){
        return this.discentes.size();
    }

    public void delete(int index){
        this.discentes.remove(index);
    }

    public List<Discente> get(){
        return this.discentes;
    }

    public Discente get(int index){
        return this.discentes.get(index);
    }
}
