package com.github.glo2003;

import com.github.glo2003.handlers.StaffsHandler;
import com.github.glo2003.mongo.MongoConnect;
import com.github.glo2003.morphia.ScheduleDAO;
import com.github.glo2003.response.Day;
import com.github.glo2003.response.Schedule;
import com.github.glo2003.response.Staffs;
import com.github.glo2003.response.TimeSlot;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mongodb.morphia.Datastore;

import static com.google.common.truth.Truth.assertThat;

public class StaffsScheduleTest {

    private final String dbName = "otto-schedule";

    private final String startOfWeek = "2018-02-07";

    private Staffs staff;

    private Staffs staff2;

    private Schedule testSchedule;

    private ScheduleDAO testScheduleDAO;

    private StaffsHandler staffsHandler;

    private MongoConnect mongoConnect;

    private MongoClient client;

    private Datastore datastore;

    private Schedule aSchedule;


    @Before
    public void init() {
        mongoConnect = new MongoConnect();
        client = mongoConnect.getClient();
        datastore = mongoConnect.getDatastore();

        testSchedule = new Schedule(startOfWeek);
        staff = new Staffs("John", "Doe", "Cook", "2018-02-11T13:00:00.000");
        staff2 = new Staffs("Riles", "boo", "Serveur", "2018-02-07T11:00:00.000");
        testScheduleDAO = new ScheduleDAO(Schedule.class, datastore);
    }

//    @Test
//    public void checkIfStaffScheduledForATimeSlot() {
//        assertThat(staff.getTimeSlot() != null);
//    }
//
//    @Test
//    public void checkIfChangeInBd() {
//        testSchedule.addStaff(staff2);
//        testScheduleDAO.getScheduleFromStartOfWeek(startOfWeek);
//        assertThat(testSchedule.days.get(0).getTimeSlots().get(0).getListStaffs().get(0).equals(staff2));
//    }
//
//    @Test
//    public void checkIfStaffExistInTimeSlot() {
//        testSchedule.addStaff(staff2);
//        testSchedule.addStaff(staff2);
//        assertThat(testSchedule.days.get(0).getTimeSlots().get(0).getListStaffs().size() == 1);
//    }
//
//    @Test
//    public void whenNoScheduleCreateSchedule() {
//        aSchedule = testScheduleDAO.getScheduleFromStartOfWeek(startOfWeek);
//        assertThat(aSchedule != null);
//    }


}
