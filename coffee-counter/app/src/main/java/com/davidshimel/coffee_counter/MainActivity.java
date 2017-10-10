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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCounter = new Counter();

        Button drinkButton = (Button) findViewById(R.id.drink_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter.record();
            }
        });

        ListView coffeeList = (ListView) findViewById(R.id.coffee_times_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mCounter.getFormattedTimes());
        coffeeList.setAdapter(arrayAdapter);
    }
}
