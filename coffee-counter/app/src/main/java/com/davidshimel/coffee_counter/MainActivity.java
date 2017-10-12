package com.davidshimel.coffee_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.joda.time.DateTime;

public class MainActivity extends AppCompatActivity {

    private Counter mCounter;
    private ArrayAdapter<String> mRecordListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCounter = new Counter();
        mRecordListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                mCounter.getFormattedTimes());
        ListView coffeeList = (ListView) findViewById(R.id.coffee_times_list);
        coffeeList.setAdapter(mRecordListAdapter);

        Button drinkButton = (Button) findViewById(R.id.drink_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateTime time = mCounter.record();
                mRecordListAdapter.add(Counter.formatTime(time));
            }
        });
    }
}
