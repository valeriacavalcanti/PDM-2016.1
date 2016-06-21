package br.edu.ifpb.si.pdm.carregador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by admin on 21/06/16.
 */
public class CarregadorReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() == Intent.ACTION_POWER_CONNECTED){
            Toast.makeText(context, "Conectou", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Desconectou", Toast.LENGTH_SHORT).show();
        }

    }
}
