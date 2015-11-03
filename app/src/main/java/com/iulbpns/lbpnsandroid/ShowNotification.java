package com.iulbpns.lbpnsandroid;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asad 15R on 11/3/2015.
 */
public class ShowNotification extends Activity {

    Button bNotify;
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

                builder.setSmallIcon(R.drawable.notification_icon);
                builder.setContentTitle("Get Zinger at Rs.150");
                builder.setContentText("KFC Jumbo Zinger only for Rs. 150");
                //builder.build();

                NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nManager.notify(12,builder.build());
            }
        });

    }


}
