package com.davidshimel.notificationtest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

public class SendNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setContentTitle("Are you dreaming?")
                        .setContentText(
                                "Tap to be reminded again in 30 minutes or swipe to halt dream "
                                        + "notifications.")
                        .setAutoCancel(true)
                        .setContentIntent(getNotificationIntent());

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(Constants.NOTIFICATION_TAG, Constants.NOTIFICATION_ID,
                notificationBuilder.build());

        finish();
    }

    private PendingIntent getNotificationIntent() {
        // This code make it so when you tap on the notification, it launches this activity again.
        // But I want it to have two buttons instead.
        Intent resultIntent = new Intent(this, ScheduleNotificationActivity.class);
        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        return PendingIntent.getActivity(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_ONE_SHOT
        );
    }
}
