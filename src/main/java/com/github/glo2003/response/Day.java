package com.github.glo2003.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;

@Entity("day")
public class Day {
    @Id
    @JsonProperty("datetime")
    private String dateTime;

    @Embedded
    @JsonProperty("timeSlots")
    private ArrayList<TimeSlot> timeSlots;

    public Day() {
    }

    public Day(String dateTime, ArrayList<TimeSlot> timeSlots) {
        this.dateTime = dateTime;
        String date = dateTime.substring(0, 10);
        if (timeSlots == null) {
            timeSlots = new ArrayList<TimeSlot>();
            for (int i = 0; i < 12; i++) {
                int heure = i + 11;
                timeSlots.add(new TimeSlot(date + 'T' + Integer.toString(heure) + ":00:00.000"));
            }
        }
        this.timeSlots = timeSlots;
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return this.timeSlots;
    }

    public String getDate() {
        return this.dateTime.substring(0, 10);
    }
}
