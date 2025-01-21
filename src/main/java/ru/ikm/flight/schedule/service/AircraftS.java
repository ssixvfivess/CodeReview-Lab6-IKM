package ru.ikm.flight.schedule.service;

import ru.ikm.flight.schedule.Aircraft;

import java.util.List;

public interface AircraftS {
    List <Aircraft> findAllAircraft();

    Aircraft SaveAircraft (Aircraft air);

    Aircraft findAircraftByCode (String aircraft_code);

    Aircraft UpdateAircraft (Aircraft air);

    void DeleteAircraft (String aircraft_code);
}
