package br.edu.ifpb.si.pdm.tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int TELA3 = 1;

    private Button btTela2, btTela3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btTela2 = (Button) findViewById(R.id.btTela2);
        this.btTela3 = (Button) findViewById(R.id.btTela3);

        this.btTela2.setOnClickListener(new OnClick());
        this.btTela3.setOnClickListener(new OnClick());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == TELA3){
                String texto = data.getStringExtra("TEXTO_RETORNO");
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(MainActivity.this.btTela2)){
                Intent it = new Intent(MainActivity.this, Tela2Activity.class);

                Pessoa p = new Pessoa("Valéria", 15);

                it.putExtra("PESSOA", p);
                startActivity(it);
            }else{
                Intent it = new Intent(MainActivity.this, Tela3Activity.class);
                startActivityForResult(it, TELA3);
            }
        }
    }
}
