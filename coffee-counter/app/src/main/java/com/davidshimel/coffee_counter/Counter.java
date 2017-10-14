package com.davidshimel.coffee_counter;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

class Counter {
    private final List<Record> mCoffeeTimes = new ArrayList<>();

    Record record() {
        Record coffeeTime = new Record(DateTime.now());
        mCoffeeTimes.add(coffeeTime);
        return coffeeTime;
    }

    List<Record> getTimes() {
        return new ArrayList<>(mCoffeeTimes);
    }
}
