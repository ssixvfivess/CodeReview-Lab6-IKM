package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Flights;

@Repository
public interface RepFlights extends JpaRepository<Flights, String> {
}
