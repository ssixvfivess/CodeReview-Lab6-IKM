package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Flights;
import ru.ikm.flight.schedule.repository.RepFlights;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {

    @Autowired
    private RepFlights flightRepository;

    public List<Flights> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flights> getFlightsByNumber(String number) {
        return flightRepository.findById(number);
    }

    @Transactional
    public Flights createFlights(Flights flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public Flights updateFlights(String number, Flights updatedFlight){
        Optional<Flights> existingFlight = flightRepository.findById(number);
        if(existingFlight.isPresent()){
            updatedFlight.setFlightNumber(number);
            return flightRepository.save(updatedFlight);
        } else {
            return null;
        }
    }
    @Transactional
    public void deleteFlights(String number) {
        flightRepository.deleteById(number);
    }
}
