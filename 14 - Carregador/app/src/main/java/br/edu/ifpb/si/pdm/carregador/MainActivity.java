package br.edu.ifpb.si.pdm.carregador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> lista;
    private CarregadorReceiver cr;
    private CarregadorReceiverInterno cri;
    private IntentFilter itf;
    private TextToSpeech tts;

    public MainActivity() {
        this.lista = new ArrayList<String>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        this.listView.setAdapter(adapter);

        this.cr = new CarregadorReceiver();
        this.itf = new IntentFilter();
        itf.addAction(Intent.ACTION_POWER_CONNECTED);
        itf.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.cri = new CarregadorReceiverInterno();

        // Sintetizador de voz
        this.tts = new TextToSpeech(this, new OnTTS());
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(this.cr, this.itf);
        registerReceiver(this.cri, this.itf);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(this.cr);
        unregisterReceiver(this.cri);
    }

    private class CarregadorReceiverInterno extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar c = Calendar.getInstance();
            String dh = String.format("%d:%d:%d h", c.get(Calendar.HOUR_OF_DAY),
                                                        c.get(Calendar.MINUTE),
                                                        c.get(Calendar.SECOND));
            if (intent.getAction() == Intent.ACTION_POWER_CONNECTED){
                MainActivity.this.lista.add(String.format("[C] %s", dh));
                MainActivity.this.tts.speak("Conectou", TextToSpeech.QUEUE_ADD, null);
            }else{
                MainActivity.this.lista.add(String.format("[D] %s", dh));
                MainActivity.this.tts.speak("Desconectou", TextToSpeech.QUEUE_ADD, null);
            }
            ((ArrayAdapter)MainActivity.this.listView.getAdapter()).notifyDataSetChanged();
        }
    }

    private class OnTTS implements TextToSpeech.OnInitListener{
        @Override
        public void onInit(int status) {
            MainActivity.this.tts.setLanguage(new Locale("pt", "BR"));
        }
    }
}
