package br.edu.ifpb.si.pdm.pdm20161;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private static final int NOVO = 1;
    private ListView listView;
    private Turma turmaPDM;

    public MainActivity() {
        this.turmaPDM = new Turma();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);

        //ArrayAdapter<Discente> adapter = new ArrayAdapter<Discente>(this, android.R.layout.simple_list_item_1, this.turmaPDM.get());
        DiscenteAdapter adapter = new DiscenteAdapter(this.turmaPDM, this);
        this.listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, NOVO, 1, "Novo Discente");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case NOVO:
                Intent it = new Intent(this, DiscenteActivity.class);
                startActivityForResult(it, NOVO);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == NOVO){
                Discente d = new Discente(data.getStringExtra("NOME"));
                d.setFoto((Bitmap) data.getParcelableExtra("FOTO"));
                this.turmaPDM.add(d);
                //((ArrayAdapter)this.listView.getAdapter()).notifyDataSetChanged();
                ((DiscenteAdapter)this.listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }
}
