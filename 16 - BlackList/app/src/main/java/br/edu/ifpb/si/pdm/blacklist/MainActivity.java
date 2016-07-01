package br.edu.ifpb.si.pdm.blacklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ListView listView;
    private PessoaDAO pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.instanciaComponentesInterface();
        this.defineListeners();

        this.pd = new PessoaDAO(this);

        PessoaAdapter adapter = new PessoaAdapter(this.pd.get(), this);
        this.listView.setAdapter(adapter);

        this.atualizaAdapter();
    }

    private void atualizaAdapter(){
        this.listView.setAdapter(new PessoaAdapter(this.pd.get(), this));
    }

    private void instanciaComponentesInterface(){
        this.editText = (EditText) findViewById(R.id.etNome);
        this.button = (Button) findViewById(R.id.btAdd);
        this.listView = (ListView) findViewById(R.id.lvPessoas);
    }

    private void defineListeners(){
        this.button.setOnClickListener(new OnClickBotao());
        this.listView.setOnItemLongClickListener(new OnLongClickList());
    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String nome = MainActivity.this.editText.getText().toString();
            MainActivity.this.pd.inserir(new Pessoa(nome));
            MainActivity.this.atualizaAdapter();
            Log.i("BLACKLIST", MainActivity.this.pd.get().toString());
        }
    }

    private class OnLongClickList implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Pessoa p = (Pessoa) parent.getAdapter().getItem(position);
            MainActivity.this.pd.remover(p);
            MainActivity.this.atualizaAdapter();
            return true;
        }
    }
}
