package ru.ikm.flight.schedule.service;

import ru.ikm.flight.schedule.Schedules;

import java.util.List;

public interface SchedulesS {
    List<Schedules> findAllSchedules();

    Schedules SaveSchedules (Schedules air);

    Schedules findSchedulesByCode (String scheduled_date);

    Schedules UpdateSchedules (Schedules air);

    void DeleteSchedules (String scheduled_date);
}
