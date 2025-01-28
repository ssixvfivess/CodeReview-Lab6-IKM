package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Schedules;

@Repository
public interface RepSchedules extends JpaRepository<Schedules, Integer> {
}
