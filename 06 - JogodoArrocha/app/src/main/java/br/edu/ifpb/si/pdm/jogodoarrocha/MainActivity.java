package br.edu.ifpb.si.pdm.jogodoarrocha;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvMenor, tvMaior;
    private EditText etNumero;
    private Button btApostar;
    private Arrocha arrocha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.instanciaComponentesInterface();
    }

    private void instanciaComponentesInterface(){
        this.tvMenor = (TextView) findViewById(R.id.tvMenor);
        this.tvMaior = (TextView) findViewById(R.id.tvMaior);
        this.etNumero = (EditText) findViewById(R.id.etNumero);
        this.btApostar = (Button) findViewById(R.id.btApostar);
        this.btApostar.setOnClickListener(new OnClick());
        this.btApostar.setOnLongClickListener(new OnLongClick());
    }

    private void atualizaInterface(){
        this.tvMenor.setText(Integer.toString(this.arrocha.getMenor()));
        this.tvMaior.setText(Integer.toString(this.arrocha.getMaior()));
        this.etNumero.setText("");
        Log.i("ARROCHA", String.format("%d %d", this.arrocha.getMenor(), this.arrocha.getMaior()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ARROCHA", "OnStart");

        this.arrocha = new Arrocha();
        Log.i("ARROCHA", String.format("Número gerado: %d", this.arrocha.getNumero()));

        this.atualizaInterface();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ARROCHA", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ARROCHA", "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ARROCHA", "OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ARROCHA", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ARROCHA", "OnDestroy");
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            try {
                int chute = Integer.parseInt(MainActivity.this.etNumero.getText().toString());
                MainActivity.this.arrocha.apostar(chute);
                MainActivity.this.atualizaInterface();
                Log.i("ARROCHA", "Jogo continua");
            } catch (JogoVenceuException e) {
                Log.i("ARROCHA", "Jogo ganhou");
                Intent it = new Intent(MainActivity.this, JogoGanhouActivity.class);
                startActivity(it);
            } catch (JogadorVenceuException e) {
                Log.i("ARROCHA", "Jogador ganhou");
                Intent it = new Intent(MainActivity.this, JogadorGanhouActivity.class);
                startActivity(it);
            } catch (NumberFormatException e){
                Toast.makeText(MainActivity.this, "Informe um valor", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class OnLongClick implements View.OnLongClickListener{
        @Override
        public boolean onLongClick(View v) {
            String numero = Integer.toString(MainActivity.this.arrocha.getNumero());
            //Toast.makeText(MainActivity.this, numero, Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Atenção!");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage(numero);
            builder.setPositiveButton("Ok", null);
            builder.create().show();

            return true;
        }
    }
}
