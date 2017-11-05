package com.davidshimel.notificationtest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ScheduleNotificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent cancelIntent = new Intent(this, CancelNotificationActivity.class);
        startActivity(cancelIntent);

        PendingIntent sendNotificationIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, SendNotificationActivity.class),
                PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // Use wakeup in case the device is off when the alarm goes off. This is more intrusive
        // of course (and uses more system resources).
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, getMinutesInMillis(30),
                sendNotificationIntent);

        finish();
    }

    private static long getMinutesInMillis(long minutes) {
        return minutes * 60 * 1000;
    }
}
