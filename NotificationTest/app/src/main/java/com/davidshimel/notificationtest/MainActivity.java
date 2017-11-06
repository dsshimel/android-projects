package com.davidshimel.notificationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent cancelIntent = new Intent(this, CancelNotificationActivity.class);
        startActivity(cancelIntent);

        Intent scheduleIntent = new Intent(this, ScheduleNotificationActivity.class);
        startActivity(scheduleIntent);

        finish();
    }
}
