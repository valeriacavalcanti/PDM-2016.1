package br.edu.ifpb.si.pdm.blacklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 01/07/16.
 */
public class PessoaAdapter extends BaseAdapter {
    private List<Pessoa> lista;
    private Context context;

    public PessoaAdapter(List<Pessoa> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }
    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Pessoa p = this.lista.get(position);

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.pessoa_layout, null);
        }else view = convertView;

        TextView tv = (TextView) view.findViewById(R.id.tvNomePessoaLayout);
        tv.setText(p.getNome());

        return view;
    }
}
