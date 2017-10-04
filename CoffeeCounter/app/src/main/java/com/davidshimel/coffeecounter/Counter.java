package com.davidshimel.coffeecounter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    private List<DateTime> coffees = new ArrayList<>();

    DateTime drinkCoffee() {
        DateTime coffeeInstant = DateTime.now();
        coffees.add(coffeeInstant);
        return coffeeInstant;
    }

    int getNumCoffees() {
        return coffees.size();
    }

    List<String> getCoffeeTimeStringArray() {
        ArrayList<String> coffeeTimes = new ArrayList<>();
        for (DateTime coffeeTime : coffees) {
            coffeeTimes.add(coffeeTime.toString(DateTimeFormat.shortTime()));
        }
        return coffeeTimes;
    }
}
