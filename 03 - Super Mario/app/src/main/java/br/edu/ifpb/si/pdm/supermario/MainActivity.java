package br.edu.ifpb.si.pdm.supermario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    private Tamanho tamanho;

    public MainActivity(){
        Log.i("VALERIA", "Construtor");
        this.tamanho = Tamanho.PEQUENO;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("VALERIA", "OnCreate");
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new TrataClick());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("VALERIA", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("VALERIA", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("VALERIA", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("VALERIA", "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("VALERIA", "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("VALERIA", "OnDestroy");
    }

    private class TrataClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.i("VALERIA", "Botão clicado");
            if (MainActivity.this.tamanho == Tamanho.PEQUENO){
                MainActivity.this.tamanho = Tamanho.GRANDE;
                MainActivity.this.imageView.setImageResource(R.drawable.mario_grande);
            }else{
                MainActivity.this.tamanho = Tamanho.PEQUENO;
                MainActivity.this.imageView.setImageResource(R.drawable.mario_pequeno);
            }
        }
    }
}
