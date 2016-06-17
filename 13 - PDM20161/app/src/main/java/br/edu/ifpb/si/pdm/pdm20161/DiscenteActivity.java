package br.edu.ifpb.si.pdm.pdm20161;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DiscenteActivity extends AppCompatActivity {
    private static final int FOTO = 1;
    private EditText etNome;
    private ImageView ivFoto;
    private Button btSalvar, btCancelar, btFoto;
    private Bitmap foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discente);

        this.instanciaComponentesInterface();
        this.listeners();
    }

    private void instanciaComponentesInterface(){
        this.etNome = (EditText) findViewById(R.id.etNomeDiscente);
        this.ivFoto = (ImageView) findViewById(R.id.ivFotoDiscente);
        this.btFoto = (Button) findViewById(R.id.btFotoDiscente);
        this.btSalvar = (Button) findViewById(R.id.btSalvarDiscente);
        this.btCancelar = (Button) findViewById(R.id.btCancelarDiscente);
    }

    private void listeners(){
        OnClick oc = new OnClick();
        this.btFoto.setOnClickListener(oc);
        this.btSalvar.setOnClickListener(oc);
        this.btCancelar.setOnClickListener(oc);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FOTO){
                this.foto = data.getParcelableExtra("data");
                this.ivFoto.setImageBitmap(this.foto);
            }
        }
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(DiscenteActivity.this.btFoto)){
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it, FOTO);
            }else if (v.equals(DiscenteActivity.this.btSalvar)){
                Intent it = new Intent();
                it.putExtra("NOME", DiscenteActivity.this.etNome.getText().toString());
                it.putExtra("FOTO", DiscenteActivity.this.foto);
                setResult(RESULT_OK, it);
                finish();
            }else{
                finish();
            }
        }
    }
}
