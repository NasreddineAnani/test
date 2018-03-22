package com.github.glo2003.handlers;

import com.github.glo2003.mongo.MongoConnect;
import com.github.glo2003.morphia.ScheduleDAO;
import com.github.glo2003.response.Schedule;
import com.github.glo2003.response.Staffs;

import spark.Request;
import spark.Response;
import spark.Route;

public class ScheduleHandler implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO(Schedule.class, MongoConnect.getInstance().getDatastore());
        Schedule weekSchedule = scheduleDAO.getScheduleFromStartOfWeek(request.params(":startOfWeek"));
        if (weekSchedule == null) {
            weekSchedule = new Schedule(request.params(":startOfWeek"));
            scheduleDAO.save(weekSchedule);
        }
        return weekSchedule;
    }

}
