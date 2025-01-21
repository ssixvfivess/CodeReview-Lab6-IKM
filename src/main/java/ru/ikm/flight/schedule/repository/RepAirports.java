package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ikm.flight.schedule.Airports;

import java.util.List;

public interface RepAirports extends JpaRepository<Airports, Long> {
    List<Airports> findAllAirports();

    Airports SaveAirports (Airports air);

    Airports findAirportsByCode (String airoport_code);

    Airports UpdateAirports (Airports air);

    void DeleteAirports (String airoport_code);
}
