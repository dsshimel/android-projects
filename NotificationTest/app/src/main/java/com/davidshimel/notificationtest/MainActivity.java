package com.davidshimel.notificationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// 1. Run the app
// 2. It schedules a notification to be sent in the next 25-35 minutes (randomized).
// 3. When the notification is sent, user either
//    a. taps a button on it to schedule the next notification
//    b. taps a button to cease further notifications
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent scheduleIntent = new Intent(this, ScheduleNotificationActivity.class);
        startActivity(scheduleIntent);

        finish();
    }
}
