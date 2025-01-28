package ru.ikm.flight.schedule.Controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Flights;
import ru.ikm.flight.schedule.repository.RepFlights;
import ru.ikm.flight.schedule.service.AircraftService;
import ru.ikm.flight.schedule.service.FlightsService;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api/v1/flight")
//@AllArgsConstructor
public class flight {

    @Autowired
    private FlightsService flightsService;

    @GetMapping("/api/flights")
    public List<Flights> getAllFlights() {
        return flightsService.getAllFlights();
    }

    @GetMapping("/api/flights/{number}")
    public ResponseEntity<Flights> getFlightsByNumber(@PathVariable String number) {
        Optional<Flights> flight = flightsService.getFlightsByNumber(number);
        return flight.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/flights")
    public ResponseEntity<Flights> createFlights(@RequestBody Flights flight) {
        Flights createdFlights = flightsService.createFlights(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlights);
    }
    @PutMapping("/api/flights/{number}")
    public ResponseEntity<Flights> updateFlights(@PathVariable String number, @RequestBody Flights updatedFlights){
        Flights updated = flightsService.updateFlights(number, updatedFlights);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/flights/{number}")
    public ResponseEntity<Void> deleteFlights(@PathVariable String number) {
        flightsService.deleteFlights(number);
        return ResponseEntity.noContent().build();
    }
}

    /*private final FlightsS service;

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
    }*/
