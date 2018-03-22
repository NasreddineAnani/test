package com.github.glo2003.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.ArrayList;

@Entity("timeSlot")
public class TimeSlot {

    @Id
    @JsonProperty("datetime")
    private String dateTime;

    @Embedded("scheduledStaff")
    @JsonProperty("scheduledStaffs")
    private ArrayList<Staffs> listStaffs;

    public TimeSlot() {
        listStaffs = new ArrayList<Staffs>();
    }

    public TimeSlot(String dateTime) {
        this.dateTime = dateTime;
        listStaffs = new ArrayList<Staffs>();

    }

    public String getDatetime() {
        return this.dateTime;
    }

    public void addStaff(Staffs staff) {
        listStaffs.add(staff);
    }

    public ArrayList<Staffs> getListStaffs() {
        return listStaffs;
    }
}
