package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Aircraft;

import java.util.List;

@Repository
public interface RepAircraft extends JpaRepository <Aircraft, String> {
}

/*public interface RepAircraft extends JpaRepository <Aircraft, Long> {
    List<Aircraft> findAllAircraft();

    Aircraft SaveAircraft (Aircraft air);

    Aircraft findAircraftByCode (String aircraft_code);

    Aircraft UpdateAircraft (Aircraft air);

    void DeleteAircraft (String aircraft_code);
}*/
