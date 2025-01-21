package ru.ikm.flight.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Aircraft;
import ru.ikm.flight.schedule.repository.MemAircraft;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplAircraft implements AircraftS {

    public final MemAircraft repository = new MemAircraft();

    @Override
    public List <Aircraft> findAllAircraft() {
        return repository.findAllAircraft();
    }

    @Override
    public Aircraft SaveAircraft (Aircraft air) {
        return repository.SaveAircraft(air);
    }

    @Override
    public Aircraft findAircraftByCode (String aircraft_code) {
        return repository.findAircraftByCode(aircraft_code);
    }

    @Override
    public Aircraft UpdateAircraft (Aircraft air) {
        return repository.UpdateAircraft(air);
    }

    @Override
    public void DeleteAircraft (String aircraft_code) {
        repository.DeleteAircraft(aircraft_code);
    }
}
