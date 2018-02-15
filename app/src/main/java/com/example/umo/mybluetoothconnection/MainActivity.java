package com.example.umo.mybluetoothconnection;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.security.PrivateKey;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Set;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    private Button bon;
    private Button boff;
    private Button won;
    private Button woff;
    private BluetoothAdapter BA;
    private BluetoothAdapter myBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bon= (Button) findViewById(R.id.btn_on);
        boff= (Button) findViewById(R.id.btn_off);
        won= (Button) findViewById(R.id.btn_wifi);
        woff= (Button) findViewById(R.id.btn_wfoff);
        BA = BluetoothAdapter.getDefaultAdapter();



        bon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BA.isEnabled()){
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);
                    Toast.makeText(getApplicationContext(),"Turned on"
                            ,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Already on",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        boff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BA.disable();
                Toast.makeText(getApplicationContext(),"Turned off" ,
                        Toast.LENGTH_LONG).show();
            }
        });
   won.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
           wifi.setWifiEnabled(true);
       }
   });
        woff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);

            }
        });
    }
}
