package com.iulbpns.lbpnsandroid;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Asad 15R on 11/5/2015.
 */
public class ProximityActivity extends Activity{

    Button bNotify,btnProximity;
    LocationManager lManager;
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
    private static final String PROXIMITY_INTENT = "com.iulbpns.lbpnsandroid";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_notification);

        //Button for simply showing Notification
        bNotify = (Button) findViewById(R.id.btnNotify);

        bNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

                builder.setSmallIcon(R.drawable.notification_icon);
                builder.setContentTitle("Get Zinger from KFC");
                builder.setContentText("KFC Jumbo Zinger only for Rs. 150");
                //builder.build();
                Toast.makeText(ProximityActivity.this, "Alert in bNotify", Toast.LENGTH_LONG).show();

                NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nManager.notify(12, builder.build());
            }
        });

        //Button for adding proximity alert at specific Location

        btnProximity = (Button) findViewById(R.id.btnProximity);
        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Alert before calling proximity method", Toast.LENGTH_LONG).show();
                Intent i = new Intent(PROXIMITY_INTENT);
                PendingIntent proximity = PendingIntent.getBroadcast(getApplicationContext(),0,i,0);
                if (lManager != null) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            || ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        lManager.addProximityAlert(25.020593, 67.132643, 30, -1, proximity);
                        IntentFilter filter = new IntentFilter(PROXIMITY_INTENT);
                        registerReceiver(new ProximityReceiver(), filter);
                        Toast.makeText(getApplicationContext(), "Alert Added", Toast.LENGTH_SHORT).show();
                    }
                }
                //proximityAlert();

            }
        });
    }


       private void proximityAlert(){

           Intent i = new Intent(PROXIMITY_INTENT);
        PendingIntent proximity = PendingIntent.getBroadcast(getApplicationContext(),0,i,0);
           if (lManager != null) {
               if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                       || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                   lManager.addProximityAlert(25.020593, 67.132643, 30, -1, proximity);
                   IntentFilter filter = new IntentFilter(PROXIMITY_INTENT);
                   registerReceiver(new ProximityReceiver(), filter);
                   Toast.makeText(this, "Alert Added", Toast.LENGTH_SHORT).show();
               }
           }



    }
    }
