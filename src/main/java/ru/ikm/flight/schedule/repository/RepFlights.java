package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Flights;

import java.util.List;

@Repository
public interface RepFlights extends JpaRepository<Flights, String> {
}

/*public interface RepFlights extends JpaRepository<Flights, Long> {
    List<Flights> findAllFlights();

    Flights SaveFlights (Flights air);

    Flights findFlightsByCode (String flight_number);

    Flights UpdateFlights (Flights air);

    void DeleteFlights (String flight_number);
}*/
