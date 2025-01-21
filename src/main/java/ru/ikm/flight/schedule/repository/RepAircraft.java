package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ikm.flight.schedule.Aircraft;

import java.util.List;

public interface RepAircraft extends JpaRepository <Aircraft, Long> {
    List<Aircraft> findAllAircraft();

    Aircraft SaveAircraft (Aircraft air);

    Aircraft findAircraftByCode (String aircraft_code);

    Aircraft UpdateAircraft (Aircraft air);

    void DeleteAircraft (String aircraft_code);
}
