package com.devmhz.zanchemartin_tp1_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;


public class UsbConectado extends BroadcastReceiver {
private boolean mUsbConnected;
    @Override
    public void onReceive(Context context, Intent intent) {

        //En el intent de la accion que esta generando el broadcast se envia un boolean "connected" que indica si esta conectado
        //Se accede con intent.getBooleanExtra("connected",false);
        boolean conectado= intent.getBooleanExtra("connected",false);
        Log.d("conectado", ""+conectado);
        if(conectado){
            String number="113";
            Uri call = Uri.parse("tel:" + number);
            Intent i = new Intent(Intent.ACTION_CALL,call);
            context.startActivity(i);
            Toast.makeText(context, "Usted ha conectado el usb", Toast.LENGTH_LONG).show();

        }

    }

}
