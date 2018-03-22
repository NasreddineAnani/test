package com.github.glo2003.response;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongodb.morphia.annotations.*;

@Entity("schedule")
public class Schedule {
    @Id
    private String startOfWeek;
    @JsonProperty("days")
    @Embedded
    public List<Day> days = new ArrayList<Day>();

    public Schedule() {
    }

    public Schedule(String startOfWeek) {
        this.startOfWeek = startOfWeek;
        for (int i = 0; i < 7; i++) {
            String date = LocalDate.parse(startOfWeek).plusDays(i).toString();
            days.add(new Day(date + "T00:00:00.000", null));
        }
    }

    public List<Day> getDays() {
        return this.days;
    }

    public void addStaff(Staffs staffs) {
        for (Day day : days) {
            for (TimeSlot timeSlot : day.getTimeSlots()) {
                if (timeSlot.getDatetime().equals(staffs.getTimeSlot())) {
                    if (!timeSlot.getListStaffs().contains(staffs))
                        timeSlot.addStaff(staffs);
                    return;
                }
            }

        }

    }

    public boolean ifStaffExist(Staffs staffs) {
        for (Day day : days) {
            if (day.getDate().equals(staffs.getTimeSlot().substring(0, 9) + "T00:00:00.000")) {
                for (TimeSlot iterTimeSlot : day.getTimeSlots()) {
                    if (iterTimeSlot.getDatetime().equals(staffs.getTimeSlot())) {
                        for (Staffs iterStaff : iterTimeSlot.getListStaffs()) {
                            if (iterStaff.equals(staffs)) {
                                return true;
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

}
