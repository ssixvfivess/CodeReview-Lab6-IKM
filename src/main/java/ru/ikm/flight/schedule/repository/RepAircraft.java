package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Aircraft;

@Repository
public interface RepAircraft extends JpaRepository <Aircraft, String> {
}
