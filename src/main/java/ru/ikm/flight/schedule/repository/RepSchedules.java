package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ikm.flight.schedule.Schedules;

import java.util.List;

public interface RepSchedules extends JpaRepository<Schedules, Long> {
    List<Schedules> findAllSchedules();

    Schedules SaveSchedules (Schedules air);

    Schedules findSchedulesByCode (String scheduled_date);

    Schedules UpdateSchedules (Schedules air);

    void DeleteSchedules (String scheduled_date);
}
