package com.davidshimel.coffeecounter;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    private List<DateTime> coffees = new ArrayList<>();

    public DateTime count() {
        DateTime coffeeInstant = DateTime.now();
        coffees.add(coffeeInstant);
        return coffeeInstant;
    }
}
