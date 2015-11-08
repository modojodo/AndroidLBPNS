package com.iulbpns.lbpnsandroid;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Asad 15R on 11/9/2015.
 */
public class GeofenceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String key = LocationManager.KEY_PROXIMITY_ENTERING;
        boolean state = intent.getBooleanExtra(key,false);

        if(state){
            Toast.makeText(context, "Welcome to my Area", Toast.LENGTH_LONG).show();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setSmallIcon(R.drawable.kfc_icon);
            builder.setContentTitle("Get Zinger at Rs.150");
            builder.setContentText("KFC Jumbo Zinger only for Rs. 150");
            //builder.build();

            NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            nManager.notify(12, builder.build());
        }

    }
}
