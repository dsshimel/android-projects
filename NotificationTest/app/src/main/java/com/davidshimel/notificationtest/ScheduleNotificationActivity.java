package com.davidshimel.notificationtest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ScheduleNotificationActivity extends AppCompatActivity {
    private static final long INTERVAL_MINUTES = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PendingIntent sendNotificationIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, SendNotificationActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(sendNotificationIntent);

        alarmManager.set(AlarmManager.ELAPSED_REALTIME, getMinutesInMillis(INTERVAL_MINUTES),
                sendNotificationIntent);

        Toast.makeText(this,
                "In " + INTERVAL_MINUTES
                        + " minutes you will be reminded to check if you are dreaming.",
                Toast.LENGTH_LONG).show();

        finish();
    }

    private static long getMinutesInMillis(long minutes) {
        return SystemClock.elapsedRealtime() + (minutes * 60 * 1000);
    }
}
