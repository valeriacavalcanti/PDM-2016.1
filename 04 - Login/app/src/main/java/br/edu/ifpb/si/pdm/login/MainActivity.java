package br.edu.ifpb.si.pdm.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etLogin, etSenha;
    private Button btLogin;
    private Usuario usuario;

    public MainActivity() {
        this.usuario = new Usuario("Valeria", "1234");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loadComponents();
        this.loadListeners();
    }

    private void loadComponents(){
        this.etLogin = (EditText) findViewById(R.id.etLogin);
        this.etSenha = (EditText) findViewById(R.id.etSenha);
        this.btLogin = (Button) findViewById(R.id.btLogin);
    }

    private void loadListeners(){
        this.btLogin.setOnClickListener(new OnClick());
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String login = MainActivity.this.etLogin.getText().toString();
            String senha = MainActivity.this.etSenha.getText().toString();
            if (MainActivity.this.usuario.autenticar(login, senha)){
                Toast.makeText(MainActivity.this, "Deu certo", Toast.LENGTH_SHORT).show();
            }else{
                Toast toast = new Toast(MainActivity.this);

                ImageView imagem = new ImageView(MainActivity.this);
                imagem.setImageResource(R.mipmap.ic_launcher);

                TextView texto = new TextView(MainActivity.this);
                texto.setText("Deu erro");

                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setBackgroundResource(R.color.colorToast);
                layout.addView(imagem);
                layout.addView(texto);

                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
