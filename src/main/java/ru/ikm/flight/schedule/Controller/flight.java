package ru.ikm.flight.schedule.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Flights;
import ru.ikm.flight.schedule.service.FlightsService;

import java.util.List;
import java.util.Optional;

@RestController
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