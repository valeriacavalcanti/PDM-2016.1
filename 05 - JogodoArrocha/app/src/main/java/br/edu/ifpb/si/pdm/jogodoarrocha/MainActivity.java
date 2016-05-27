package br.edu.ifpb.si.pdm.jogodoarrocha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMenor, tvMaior;
    private EditText etNumero;
    private Button btApostar;
    private Arrocha arrocha;

    public MainActivity() {
        this.arrocha = new Arrocha();
        Log.i("ARROCHA", String.format("Número gerado: %d", this.arrocha.getNumero()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.instanciaComponentesInterface();
        this.atualizaInterface();
    }

    private void instanciaComponentesInterface(){
        this.tvMenor = (TextView) findViewById(R.id.tvMenor);
        this.tvMaior = (TextView) findViewById(R.id.tvMaior);
        this.etNumero = (EditText) findViewById(R.id.etNumero);
        this.btApostar = (Button) findViewById(R.id.btApostar);
        this.btApostar.setOnClickListener(new OnClick());
    }

    private void atualizaInterface(){
        this.tvMenor.setText(Integer.toString(this.arrocha.getMenor()));
        this.tvMaior.setText(Integer.toString(this.arrocha.getMaior()));
        this.etNumero.setText("");
        Log.i("ARROCHA", String.format("%d %d", this.arrocha.getMenor(), this.arrocha.getMaior()));
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int chute = Integer.parseInt(MainActivity.this.etNumero.getText().toString());
            try {
                MainActivity.this.arrocha.apostar(chute);
                MainActivity.this.atualizaInterface();
                Log.i("ARROCHA", "Jogo continua");
            } catch (JogoVenceuException e) {
                Log.i("ARROCHA", "Jogo ganhou");
            } catch (JogadorVenceuException e) {
                Log.i("ARROCHA", "Jogador ganhou");
            }
        }
    }
}
