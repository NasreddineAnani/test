package com.github.glo2003.morphia;

import com.github.glo2003.response.Schedule;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class ScheduleDAO extends BasicDAO<Schedule, ObjectId> implements IScheduleDAO {

    public ScheduleDAO(Class<Schedule> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    @Override
    public Schedule getScheduleFromStartOfWeek(String startOfWeek) {
        return getDatastore().get(Schedule.class, startOfWeek);
    }
}
