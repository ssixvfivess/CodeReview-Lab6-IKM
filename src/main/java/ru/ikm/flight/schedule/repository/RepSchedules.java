package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Schedules;

import java.util.List;

@Repository
public interface RepSchedules extends JpaRepository<Schedules, Integer> {
}

/*public interface RepSchedules extends JpaRepository<Schedules, Long> {
    List<Schedules> findAllSchedules();

    Schedules SaveSchedules (Schedules air);

    Schedules findSchedulesByCode (String scheduled_date);

    Schedules UpdateSchedules (Schedules air);

    void DeleteSchedules (String scheduled_date);
}*/
