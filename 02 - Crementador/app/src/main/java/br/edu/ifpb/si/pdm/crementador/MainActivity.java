package br.edu.ifpb.si.pdm.crementador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numero;
    private TextView tvNumero;
    private Button btInc, btDecr;

    public MainActivity(){
        this.numero = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.tvNumero = (TextView) findViewById(R.id.tvNumero);
        this.btInc = (Button) findViewById(R.id.btIncrementa);
        this.btDecr = (Button) findViewById(R.id.btDecrementa);

        this.btInc.setOnClickListener(new TrataClick());
        this.btDecr.setOnClickListener(new TrataClick());

        this.tvNumero.setText(Integer.toString(this.numero));
}

    public void incrementa(){
        this.numero++;
    }

    public void decrementa(){
        this.numero--;
    }

    private class TrataClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(MainActivity.this.btInc)){
                MainActivity.this.incrementa();
            }else{
                MainActivity.this.decrementa();
            }
            MainActivity.this.tvNumero.setText(Integer.toString(MainActivity.this.numero));
        }
    }
}
