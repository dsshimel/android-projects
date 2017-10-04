package com.davidshimel.coffeecounter;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class MainActivity extends AppCompatActivity {
    private final Counter coffeeCounter;
    private ArrayAdapter<String> coffeeArrayAdapter;

    public MainActivity() {
        coffeeCounter = new Counter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setContentView(R.layout.activity_main);
        Button drinkButton = (Button) findViewById(R.id.drink_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateTime coffeeInstant = coffeeCounter.drinkCoffee();
                String coffeeInstantString = coffeeInstant.toLocalTime().toString(DateTimeFormat.shortTime());
                updateStatsText();
                updateCoffeeList(coffeeInstantString);
            }
        });

        coffeeArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coffeeCounter.getCoffeeTimeStringArray());
        ((ListView) findViewById(R.id.drink_list)).setAdapter(coffeeArrayAdapter);
    }

    private void updateStatsText() {
        int numCoffees = coffeeCounter.getNumCoffees();
        ((TextView) findViewById(R.id.stats)).setText(
                getResources().getQuantityString(R.plurals.coffee_count, numCoffees, numCoffees));
    }

    private void updateCoffeeList(String coffeeInstantString) {
        coffeeArrayAdapter.add(coffeeInstantString);
    }
}
