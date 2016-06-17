package br.edu.ifpb.si.pdm.pdm20161;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by admin on 17/06/16.
 */
public class DiscenteAdapter extends BaseAdapter{
    private Turma turma;
    private Context context;

    public DiscenteAdapter(Turma turma, Context context) {
        this.turma = turma;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.turma.getQuantidade();
    }

    @Override
    public Object getItem(int position) {
        return this.turma.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Discente d = this.turma.get(position);

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.layout_discente, null);
        }else{
            view = convertView;
        }

        view.setMinimumHeight(300);

        ImageView ivFoto = (ImageView) view.findViewById(R.id.ivFotoCelula);
        TextView tvNome = (TextView) view.findViewById(R.id.tvNomeCelula);

        if (d.getFoto() != null)
            ivFoto.setImageBitmap(d.getFoto());

        tvNome.setText(d.getNome());

        return view;
    }
}
