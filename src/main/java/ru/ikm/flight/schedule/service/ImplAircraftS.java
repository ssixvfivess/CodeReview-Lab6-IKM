package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Aircraft;
import ru.ikm.flight.schedule.repository.RepAircraft;
import ru.ikm.flight.schedule.service.AircraftS;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ImplAircraftS implements AircraftS{

    private final RepAircraft rep;

    @Override
    public List<Aircraft> findAllAircraft() {
        return rep.findAllAircraft();
    }

    @Override
    public Aircraft SaveAircraft (Aircraft air) {
        return rep.SaveAircraft(air);
    }

    @Override
    public Aircraft findAircraftByCode (String aircraft_code) {
        return rep.findAircraftByCode(aircraft_code);
    }

    @Override
    public Aircraft UpdateAircraft (Aircraft air) {
        return rep.UpdateAircraft(air);
    }

    @Override
    @Transactional
    public void DeleteAircraft (String aircraft_code) {
        rep.DeleteAircraft(aircraft_code);
    }
}
