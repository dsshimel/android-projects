package com.davidshimel.coffee_counter;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    private final List<DateTime> mCoffeeTimes = new ArrayList<>();

    DateTime record() {
        DateTime coffeeTime = DateTime.now();
        mCoffeeTimes.add(coffeeTime);
        return coffeeTime;
    }
}
