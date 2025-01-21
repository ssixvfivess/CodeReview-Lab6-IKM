package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Airports;
import ru.ikm.flight.schedule.repository.MemAirports;
import ru.ikm.flight.schedule.repository.RepAirports;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ImplAirportS implements AirportsS{

    private final RepAirports rep;

    @Override
    public List<Airports> findAllAirports() {
        return rep.findAllAirports();
    }

    @Override
    public Airports SaveAirports (Airports air) {
        return rep.SaveAirports(air);
    }

    @Override
    public Airports findAirportsByCode (String aircraft_code) {
        return rep.findAirportsByCode(aircraft_code);
    }

    @Override
    public Airports UpdateAirports (Airports air) {
        return rep.UpdateAirports(air);
    }

    @Override
    @Transactional
    public void DeleteAirports (String aircraft_code) {
        rep.DeleteAirports(aircraft_code);
    }
}
