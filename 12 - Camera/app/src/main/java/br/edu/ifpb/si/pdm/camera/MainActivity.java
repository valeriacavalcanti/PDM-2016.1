package br.edu.ifpb.si.pdm.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int FOTO = 1;
    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new OnClick());

        this.imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FOTO){
                MainActivity.this.imageView.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
            }
        }
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(it, MainActivity.this.FOTO);
        }
    }
}
