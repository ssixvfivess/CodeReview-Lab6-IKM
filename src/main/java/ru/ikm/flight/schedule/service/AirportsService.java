package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Airports;
import ru.ikm.flight.schedule.repository.RepAirports;

import java.util.List;
import java.util.Optional;

@Service
public class AirportsService {

    @Autowired
    private RepAirports airportRepository;

    public List<Airports> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airports> getAirportsByCode(String code) {
        return airportRepository.findById(code);
    }

    @Transactional
    public Airports createAirports(Airports airports) {
        return airportRepository.save(airports);
    }

    @Transactional
    public Airports updateAirports(String code, Airports updatedAirports) {
        Optional<Airports> existingAirports = airportRepository.findById(code);
        if (existingAirports.isPresent()) {
            updatedAirports.setAirportCode(code);
            return airportRepository.save(updatedAirports);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteAirports(String code) {
        airportRepository.deleteById(code);
    }
}
