package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Flights;
import ru.ikm.flight.schedule.repository.RepFlights;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ImplFlightsS implements FlightsS{

    private final RepFlights rep;

    @Override
    public List<Flights> findAllFlights() {
        return rep.findAllFlights();
    }

    @Override
    public Flights SaveFlights (Flights air) {
        return rep.SaveFlights(air);
    }

    @Override
    public Flights findFlightsByCode (String flight_number) {
        return rep.findFlightsByCode(flight_number);
    }

    @Override
    public Flights UpdateFlights (Flights air) {
        return rep.UpdateFlights(air);
    }

    @Override
    @Transactional
    public void DeleteFlights (String flight_number) {
        rep.DeleteFlights(flight_number);
    }
}
