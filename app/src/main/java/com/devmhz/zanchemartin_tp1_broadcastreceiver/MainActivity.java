package com.devmhz.zanchemartin_tp1_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.hardware.usb.UsbManager;
public class MainActivity extends AppCompatActivity {
    private UsbConectado usb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        usb =new UsbConectado();
        registerReceiver(usb, new IntentFilter("android.hardware.usb.action.USB_STATE"));


    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(usb);
    }


}