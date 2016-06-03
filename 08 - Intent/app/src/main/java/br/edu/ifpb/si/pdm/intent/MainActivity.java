package br.edu.ifpb.si.pdm.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int PESSOA = 1;
    private Button btPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btPessoa = (Button) findViewById(R.id.btPessoa);
        this.btPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("NOVA_PESSOA");
                startActivityForResult(it, PESSOA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == PESSOA){
                String nome = data.getStringExtra("NOME");
                Toast.makeText(this, nome, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
