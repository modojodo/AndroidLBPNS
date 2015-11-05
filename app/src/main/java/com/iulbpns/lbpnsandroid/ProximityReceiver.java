package com.iulbpns.lbpnsandroid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Asad 15R on 11/5/2015.
 */
public class ProximityReceiver extends BroadcastReceiver {


    private static final int ID = 1234;


    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notifyIntent = new Intent(context,ProximityActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notifyIntent, 0);
        //Notification notification = createNotification();
      //  notification.setLatestEventInfo(context, "Proximity Alert!", "You are near your point of interest.", pendingIntent);

        //nManager.notify(ID, notification);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.notification_icon);
        builder.setContentTitle("Get Zinger at Rs.150");
        builder.setContentText("KFC Jumbo Zinger only for Rs. 150");
        builder.setContentIntent(pendingIntent);
        nManager.notify(ID,builder.build());

    }

  /*  private Notification createNotification() {
     /  Notification notification = new Notification();
        notification.icon = R.drawable.ic_menu_notifications;
        notification.when = System.currentTimeMillis();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notification.ledARGB = Color.WHITE;
        notification.ledOnMS = 1500;
        notification.ledOffMS = 1500;
        return notification;



    }
*/

}