package com.davidshimel.coffee_counter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

class Counter {
    private final List<DateTime> mCoffeeTimes = new ArrayList<>();

    DateTime record() {
        DateTime coffeeTime = DateTime.now();
        mCoffeeTimes.add(coffeeTime);
        return coffeeTime;
    }

    List<String> getFormattedTimes() {
        List<String> times = new ArrayList<>();
        for (DateTime time : mCoffeeTimes) {
            times.add(formatTime(time));
        }
        return times;
    }

    static String formatTime(DateTime time) {
        return time.toLocalTime().toString(DateTimeFormat.shortTime());
    }
}
