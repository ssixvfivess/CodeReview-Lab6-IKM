package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Airports;

import java.util.List;

@Repository
public interface RepAirports extends JpaRepository<Airports, String> {
}

/*public interface RepAirports extends JpaRepository<Airports, Long> {
    List<Airports> findAllAirports();

    Airports SaveAirports (Airports air);

    Airports findAirportsByCode (String airoport_code);

    Airports UpdateAirports (Airports air);

    void DeleteAirports (String airoport_code);
}*/
