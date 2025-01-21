package ru.ikm.flight.schedule.repository;

import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.Airports;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class MemAirports {
    private final List<Airports> AIRPORTS = new ArrayList<>();

    public List <Airports> findAllAirports() {
        return AIRPORTS;
    }

    public Airports SaveAirports (Airports air) {
        AIRPORTS.add(air);
        return air;
    }

    public Airports findAirportsByCode (String airoport_code) {
        return AIRPORTS.stream().filter(element -> element.getAiroport_code().equals(airoport_code)).findFirst().orElse(null);
    }

    public Airports UpdateAirports (Airports air) {
        var AirportsIndex = IntStream.range(0, AIRPORTS.size()).filter(index -> AIRPORTS.get(index).getAiroport_code().equals(air.getAiroport_code())).findFirst().orElse(-1);
        if (AirportsIndex > -1) {
            AIRPORTS.set(AirportsIndex, air);
            return air;
        }
        return null;
    }

    public void DeleteAirports (String airoport_code) {
        var air = findAirportsByCode (airoport_code);
        if (air != null) {
            AIRPORTS.remove(air);
        }
    }
}
