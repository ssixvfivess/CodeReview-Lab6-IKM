package ru.ikm.flight.schedule.repository;

import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class MemFlights {
    private final List<Flights> FLIGHTS = new ArrayList<>();

    public List <Flights> findAllFlights() {
        return FLIGHTS;
    }

    public Flights SaveFlights (Flights air) {
        FLIGHTS.add(air);
        return air;
    }

    public Flights findFlightsByCode (String flight_number) {
        return FLIGHTS.stream().filter(element -> element.getFlight_number().equals(flight_number)).findFirst().orElse(null);
    }

    public Flights UpdateFlights (Flights air) {
        var FlightsIndex = IntStream.range(0, FLIGHTS.size()).filter(index -> FLIGHTS.get(index).getFlight_number().equals(air.getFlight_number())).findFirst().orElse(-1);
        if (FlightsIndex > -1) {
            FLIGHTS.set(FlightsIndex, air);
            return air;
        }
        return null;
    }

    public void DeleteFlights (String flight_number) {
        var air = findFlightsByCode (flight_number);
        if (air != null) {
            FLIGHTS.remove(air);
        }
    }
}
