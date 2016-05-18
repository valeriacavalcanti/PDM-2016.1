package br.edu.ifpb.si.pdm.meuprimeiroprojetoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.tvTexto = (TextView)findViewById(R.id.tvTitulo);
    }

    public void exibirNomeMaisLindo(View v){
        this.tvTexto.setText("Valéria");
    }
}
