package ru.ikm.flight.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Flights;
import ru.ikm.flight.schedule.repository.MemFlights;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplFlights implements FlightsS{

    public final MemFlights repository = new MemFlights();

    @Override
    public List<Flights> findAllFlights() {
        return repository.findAllFlights();
    }

    @Override
    public Flights SaveFlights (Flights air) {
        return repository.SaveFlights(air);
    }

    @Override
    public Flights findFlightsByCode (String flight_number) {
        return repository.findFlightsByCode(flight_number);
    }

    @Override
    public Flights UpdateFlights (Flights air) {
        return repository.UpdateFlights(air);
    }

    @Override
    public void DeleteFlights (String flight_number) {
        repository.DeleteFlights(flight_number);
    }
}
