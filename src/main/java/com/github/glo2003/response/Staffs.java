package com.github.glo2003.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.ArrayList;

@Entity("staffs")
public class Staffs {

    @Id
    private ObjectId id;

    @Property("firstName")
    @JsonProperty("firstName")
    private String firstName;

    @Property("lastName")
    @JsonProperty("lastName")
    private String lastName;

    @Property("role")
    @JsonProperty("role")
    private String role;

    @Property("timeSlot")
    @JsonProperty("timeSlot")
    private String timeSlot;

    public Staffs(String firstName, String lastName, String role, String timeSlot) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.timeSlot = timeSlot;
        this.id = new ObjectId();
    }

    public Staffs() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Staffs) {
            Staffs otherStaff = (Staffs) object;
            if (this.getLastName().equals(otherStaff.getLastName()) && this.firstName.equals(otherStaff.firstName) && this.role.equals(otherStaff.role) && this.timeSlot.equals(otherStaff.timeSlot))
                return true;
        }
        return false;
    }
}
