package ru.ikm.flight.schedule.repository;

import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.Aircraft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class MemAircraft {
    private final List <Aircraft> AIRCRAFT = new ArrayList<>();

    public List <Aircraft> findAllAircraft() {
        return AIRCRAFT;
    }

    public Aircraft SaveAircraft (Aircraft air) {
        AIRCRAFT.add(air);
        return air;
    }

    public Aircraft findAircraftByCode (String aircraft_code) {
        return AIRCRAFT.stream().filter(element -> element.getAircraft_code().equals(aircraft_code)).findFirst().orElse(null);
    }

    public Aircraft UpdateAircraft (Aircraft air) {
        var AircraftIndex = IntStream.range(0, AIRCRAFT.size()).filter(index -> AIRCRAFT.get(index).getAircraft_code().equals(air.getAircraft_code())).findFirst().orElse(-1);
        if (AircraftIndex > -1) {
            AIRCRAFT.set(AircraftIndex, air);
            return air;
        }
        return null;
    }

    public void DeleteAircraft (String aircraft_code) {
        var air = findAircraftByCode (aircraft_code);
        if (air != null) {
            AIRCRAFT.remove(air);
        }
    }
}
