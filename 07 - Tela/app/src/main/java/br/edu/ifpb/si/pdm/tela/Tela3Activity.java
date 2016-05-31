package br.edu.ifpb.si.pdm.tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela3Activity extends AppCompatActivity {
    private EditText etTexto;
    private Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        this.etTexto = (EditText) findViewById(R.id.etTextoTela3);
        this.btOk = (Button) findViewById(R.id.btOkTela3);
        this.btOk.setOnClickListener(new OnClick());
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String texto = Tela3Activity.this.etTexto.getText().toString();
            Intent it = new Intent();
            it.putExtra("TEXTO_RETORNO", texto);
            setResult(RESULT_OK, it);
            finish();
        }
    }
}
