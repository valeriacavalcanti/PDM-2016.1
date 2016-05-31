package br.edu.ifpb.si.pdm.tela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {
    private TextView tvTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        this.tvTitulo = (TextView) findViewById(R.id.tvTituloTela2);
        Pessoa p = (Pessoa) getIntent().getSerializableExtra("PESSOA");

        this.tvTitulo.setText(p.toString());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return super.onTouchEvent(event);
    }
}
