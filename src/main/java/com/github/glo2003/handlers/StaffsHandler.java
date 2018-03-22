package com.github.glo2003.handlers;

import com.github.glo2003.mongo.MongoConnect;
import com.github.glo2003.morphia.ScheduleDAO;
import com.github.glo2003.response.Schedule;
import com.github.glo2003.response.Staffs;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;


public class StaffsHandler {

    public static String addStaff(Staffs staff, String startOfWeek) {

//        DBCollection scheduleCollection = MongoConnect.getInstance().getDatastore().getCollection(Schedule.class);
//        BasicDBObject query = new BasicDBObject();
//        query.put("days.timeSlots._id", startOfWeek);
//        BasicDBObject data = new BasicDBObject();
//        data.put("days.timeSlots.scheduledStaffs",  staff);
//        BasicDBObject command = new BasicDBObject();
//        command.put("$addToSet", data);
//        scheduleCollection.update(query, command);
        ScheduleDAO scheduleDAO = new ScheduleDAO(Schedule.class, MongoConnect.getInstance().getDatastore());
        Schedule weekSchedule = scheduleDAO.getScheduleFromStartOfWeek(startOfWeek);
        if (startOfWeek != null) {
            if (!(weekSchedule.ifStaffExist(staff))) {
                weekSchedule.addStaff(staff);
                scheduleDAO.save(weekSchedule);
                return "Successfully added staff";
            }
        }
        return "Error: no schedule for specified period";

    }


}
