package com.davidshimel.coffee_counter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

class Record {
    private final DateTime mTime;

    public Record(DateTime time) {
        mTime = time;
    }

    @Override
    public String toString() {
        return mTime.toString(DateTimeFormat.shortTime());
    }
}
