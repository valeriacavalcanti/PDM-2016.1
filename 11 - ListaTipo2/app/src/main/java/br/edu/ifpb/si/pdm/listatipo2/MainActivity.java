package br.edu.ifpb.si.pdm.listatipo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int QUANTIDADE = 1, LIMPAR = 2;
    private ListView lvLista;
    private Cadastro cadastro;

    public MainActivity() {
        this.cadastro = new Cadastro();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvLista = (ListView) findViewById(R.id.lvLista);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.cadastro.get());
        this.lvLista.setAdapter(adapter);

        this.lvLista.setOnItemClickListener(new OnClickList());
        this.lvLista.setOnItemLongClickListener(new OnLongClickList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, QUANTIDADE, 1, "Quantidade");
        menu.add(0, LIMPAR, 2, "Limpar");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case QUANTIDADE:
                Toast.makeText(this, Integer.toString(this.cadastro.quantidade()), Toast.LENGTH_SHORT).show();
                break;
            case LIMPAR:
                this.cadastro.clear();
                ((ArrayAdapter)this.lvLista.getAdapter()).notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class OnClickList implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private class OnLongClickList implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            MainActivity.this.cadastro.delete(position);
            ((ArrayAdapter)parent.getAdapter()).notifyDataSetChanged();
            return true;
        }
    }
}
