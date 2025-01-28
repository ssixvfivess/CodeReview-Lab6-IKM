package ru.ikm.flight.schedule.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Aircraft;
import ru.ikm.flight.schedule.service.AircraftService;

import java.util.Optional;

import java.util.List;

@RestController
public class main {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/api/aircrafts")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/api/aircrafts/{aircraft_code}")
    public ResponseEntity<Aircraft> getAircraftByCode(@PathVariable String aircraft_code) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftByCode(aircraft_code);
        return aircraft.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/aircrafts")
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        Aircraft createdAircraft = aircraftService.createAircraft(aircraft);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAircraft);
    }

    @PutMapping("/api/aircrafts/{aircraft_code}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable String aircraft_code, @RequestBody Aircraft updatedAircraft) {
        Aircraft updated = aircraftService.updateAircraft(aircraft_code, updatedAircraft);
        if (updated != null){
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/aircrafts/{aircraft_code}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable String aircraft_code) {
        aircraftService.deleteAircraft(aircraft_code);
        return ResponseEntity.noContent().build();
    }
}
