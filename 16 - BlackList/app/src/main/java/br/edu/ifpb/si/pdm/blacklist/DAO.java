package br.edu.ifpb.si.pdm.blacklist;

import java.util.List;

/**
 * Created by admin on 01/07/16.
 */
public interface DAO <T> {
    public void inserir(T novo);
    public void atualizar(T obj);
    public void remover(int id);
    public void remover(T obj);
    public T get(int id);
    public List<T> get();
}
