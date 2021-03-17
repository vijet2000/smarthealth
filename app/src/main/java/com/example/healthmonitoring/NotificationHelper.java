package com.example.healthmonitoring;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    Intent intent=new Intent(getApplicationContext(),TabletSetter.class);
    PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    public static String a=Main2Activity.a;

    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("hey!!!")
                .setContentText("time to take your"+ " "+a)
                .setSmallIcon(android.R.drawable.star_big_on)
                .setVibrate(new long[]{1000,1000,1000,1100})
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
                //.addAction(android.R.drawable.star_on,"noo",pendingIntent);






    }
}
