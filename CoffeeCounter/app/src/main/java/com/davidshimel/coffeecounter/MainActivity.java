package com.davidshimel.coffeecounter;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;

public class MainActivity extends AppCompatActivity {
    private final Counter coffeeCounter;

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
                DateTime coffeeInstant = coffeeCounter.count();
                Snackbar.make(findViewById(R.id.main_view),
                        "You drank a coffee at " + coffeeInstant.toString(),
                        Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
