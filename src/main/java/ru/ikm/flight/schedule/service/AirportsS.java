package ru.ikm.flight.schedule.service;

import ru.ikm.flight.schedule.Airports;

import java.util.List;

public interface AirportsS {
    List<Airports> findAllAirports();

    Airports SaveAirports (Airports air);

    Airports findAirportsByCode (String airoport_code);

    Airports UpdateAirports (Airports air);

    void DeleteAirports (String airoport_code);
}
