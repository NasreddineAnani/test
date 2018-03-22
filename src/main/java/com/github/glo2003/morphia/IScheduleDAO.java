package com.github.glo2003.morphia;

import com.github.glo2003.response.Schedule;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface IScheduleDAO extends DAO<Schedule, ObjectId> {
    Schedule getScheduleFromStartOfWeek(String startOfWeek);
}
