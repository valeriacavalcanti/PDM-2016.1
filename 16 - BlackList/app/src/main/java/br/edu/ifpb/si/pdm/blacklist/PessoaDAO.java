package br.edu.ifpb.si.pdm.blacklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 01/07/16.
 */
public class PessoaDAO implements DAO<Pessoa> {
    private BancoHelper banco;
    private static final String TABELA = "pessoa";

    public PessoaDAO(Context context) {
        this.banco = new BancoHelper(context);
    }

    @Override
    public void inserir(Pessoa novo) {
        ContentValues cv = new ContentValues();
        cv.put("nome", novo.getNome());
        this.banco.getWritableDatabase().insert(TABELA, null, cv);
    }

    @Override
    public void atualizar(Pessoa obj) {

    }

    @Override
    public void remover(int id) {
        String[] where = {Integer.toString(id)};
        this.banco.getWritableDatabase().delete(TABELA, "id = ?", where);
    }

    @Override
    public void remover(Pessoa obj) {
        this.remover(obj.getId());
    }

    @Override
    public Pessoa get(int id) {
        return null;
    }

    @Override
    public List<Pessoa> get() {
        String[] colunas = {"id", "nome"};
        List<Pessoa> lista = new ArrayList<Pessoa>();

        Cursor c = this.banco.getReadableDatabase().query(TABELA, colunas, null, null, null, null, "nome");
        if (c.getCount() > 0){
            c.moveToFirst();
            do{
                Pessoa p = new Pessoa();
                p.setId(c.getInt(c.getColumnIndex(colunas[0])));
                p.setNome(c.getString(1));
                lista.add(p);
            }while (c.moveToNext());
        }

        return lista;
    }
}
