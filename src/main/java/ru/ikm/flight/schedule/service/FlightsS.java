package ru.ikm.flight.schedule.service;

import ru.ikm.flight.schedule.Flights;

import java.util.List;

public interface FlightsS {
    List<Flights> findAllFlights();

    Flights SaveFlights (Flights air);

    Flights findFlightsByCode (String flight_number);

    Flights UpdateFlights (Flights air);

    void DeleteFlights (String flight_number);
}
