package ru.ikm.flight.schedule.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.Flights;
import ru.ikm.flight.schedule.service.FlightsS;

import java.util.List;

@RestController
@RequestMapping("api/v1/flight")
@AllArgsConstructor
public class flight {

    private final FlightsS service;

    @GetMapping
    public List<Flights> findAllFlights() {
        return service.findAllFlights();
    }

    @PostMapping("SaveFlights")
    public Flights SaveFlights (@RequestBody Flights air) {
        return service.SaveFlights(air);
    }

    @GetMapping ("/{flight_number}")
    public Flights findFlightsByCode (@PathVariable String flight_number) {
        return service.findFlightsByCode(flight_number);
    }

    @PutMapping ("UpdateFlights")
    public Flights UpdateFlights (Flights air) {
        return service.UpdateFlights(air);
    }

    @DeleteMapping ("DeleteFlights/{flight_number}")
    public void DeleteFlights (@PathVariable String flight_number) {
        service.DeleteFlights(flight_number);
    }
}
