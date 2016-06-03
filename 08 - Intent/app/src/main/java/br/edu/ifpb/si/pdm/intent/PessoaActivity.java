package br.edu.ifpb.si.pdm.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class PessoaActivity extends AppCompatActivity {
    private EditText etNome, etIdade;
    private Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);

        this.instanciaComponentesInterface();
    }

    private void instanciaComponentesInterface(){
        this.etNome = (EditText) findViewById(R.id.etNomePessoa);
        this.etIdade = (EditText) findViewById(R.id.etIdadePessoa);
        this.btOk = (Button) findViewById(R.id.btOkPessoa);

        this.btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = PessoaActivity.this.etNome.getText().toString();
                int idade = Integer.parseInt(PessoaActivity.this.etIdade.getText().toString());

                Intent it = new Intent();
                it.putExtra("NOME", nome);
                it.putExtra("IDADE", idade);
                it.putExtra("DATAHORA", Calendar.getInstance());

                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}
