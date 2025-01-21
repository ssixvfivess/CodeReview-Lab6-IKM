package ru.ikm.flight.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Airports;
import ru.ikm.flight.schedule.repository.MemAirports;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplAirport implements AirportsS {

    public final MemAirports repository = new MemAirports();

    @Override
    public List<Airports> findAllAirports() {
        return repository.findAllAirports();
    }

    @Override
    public Airports SaveAirports (Airports air) {
        return repository.SaveAirports(air);
    }

    @Override
    public Airports findAirportsByCode (String aircraft_code) {
        return repository.findAirportsByCode(aircraft_code);
    }

    @Override
    public Airports UpdateAirports (Airports air) {
        return repository.UpdateAirports(air);
    }

    @Override
    public void DeleteAirports (String aircraft_code) {
        repository.DeleteAirports(aircraft_code);
    }
}
