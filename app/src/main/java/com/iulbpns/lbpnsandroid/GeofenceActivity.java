package com.iulbpns.lbpnsandroid;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Asad 15R on 11/9/2015.
 */
public class GeofenceActivity extends Activity{

    private static final double LATITUDE = 25.020588;
    private static final double LONGITUDE = 67.132638;
    private static final float RADIUS = 10;
    private static final long EXPIRATION_TIME = -1;

    Button btnProximity,bNotify;
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_notification);

        bNotify  = (Button) findViewById(R.id.btnNotify);
        bNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

                //Opening Google Maps for Specific Restaurant

               // Uri mapIntent  = Uri.parse("geo:"+LATITUDE+","+LONGITUDE);
                Uri mapIntent = Uri.parse("google.navigation:q=" +LATITUDE + "," +LONGITUDE );
                Intent intent = new Intent(Intent.ACTION_VIEW,mapIntent);
                intent.setPackage("com.google.android.apps.maps");

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,0);


                Bitmap icon = BitmapFactory.decodeResource(getResources(),
                        R.drawable.kfc_icon);
                builder.setTicker("Mighty Zinger Combo!");
                builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                builder.setLargeIcon(icon);
                builder.setSmallIcon(R.drawable.kfc_icon);
                builder.setContentTitle("Mighty Zinger Combo");
                builder.setContentText("Mighty zinger, regular fries &");
                builder.setSubText("300 ml drink at Rs.580");
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                //builder.build();

                NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nManager.notify(12, builder.build());
            }
        });

        btnProximity  = (Button) findViewById(R.id.btnProximity);
        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Welcome to my Area", Toast.LENGTH_LONG).show();

                LocationManager lManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Intent intent = new Intent("com.iulbpns.lbpnsandroid");

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),-1,intent,0);

                if(lManager != null){
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        lManager.addProximityAlert(LATITUDE,LONGITUDE, RADIUS, EXPIRATION_TIME, pendingIntent);
                    }                }
            }
        });
    }
}
