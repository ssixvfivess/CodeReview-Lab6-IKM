package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Aircraft;
import ru.ikm.flight.schedule.repository.RepAircraft;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private RepAircraft aircraftRepository;

    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftByCode(String code) {
        return aircraftRepository.findById(code);
    }

    @Transactional
    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Transactional
    public Aircraft updateAircraft(String code, Aircraft updatedAircraft){
        Optional<Aircraft> existingAircraft = aircraftRepository.findById(code);
        if(existingAircraft.isPresent()){
            updatedAircraft.setAircraftCode(code);
            return  aircraftRepository.save(updatedAircraft);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteAircraft(String code) {
        aircraftRepository.deleteById(code);
    }
}
