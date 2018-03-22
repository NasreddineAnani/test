/**
 * Copyright (c) 2013 - 2015, Coveo Solutions Inc.
 */
package com.github.glo2003;

import static com.google.common.truth.Truth.*;

import com.github.glo2003.response.Day;
import com.github.glo2003.response.Schedule;
import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {
    private final String startOfWeek = "2018-01-01";
    private Schedule testSchedule;

    @Before
    public void init() {
        testSchedule = new Schedule(startOfWeek);
    }

//    @Test
//    public void schedulesShouldStartAtGivenDate() {
//        assertThat(testSchedule.getDays().get(0).getDate().equals(startOfWeek));
//    }
//
//    @Test
//    public void givenStartOfWeekSchedulesShouldReturnSevenDays() {
//        assertThat(testSchedule.getDays().size()).isEqualTo(7);
//    }
//
//    @Test
//    public void restaurantIsOpenForTwelvesHoursByDefault() {
//        Day testDay = new Day(startOfWeek, null);
//
//        assertThat(testDay.getTimeSlots().size()).isEqualTo(12);
//    }
//
//    @Test
//    public void restaurantOpensAtElevenByDefault() {
//        Day testDay = new Day(startOfWeek, null);
//        String expected = startOfWeek + "T11:00:00.000";
//
//        assertThat(testDay.getTimeSlots().get(0).getDatetime()).isEqualTo(expected);
//    }
//
//    @Test
//    public void restaurantClosesAtTenByDefault() {
//        Day testDay = new Day(startOfWeek, null);
//        String expected = startOfWeek + "T22:00:00.000";
//
//        assertThat(testDay.getTimeSlots().get(11).getDatetime()).isEqualTo(expected);
//    }

}
