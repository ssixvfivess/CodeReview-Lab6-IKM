package ru.ikm.flight.schedule.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Aircraft;
import ru.ikm.flight.schedule.service.AircraftService;

import java.util.Optional;

import java.util.List;

@RestController
//@RequestMapping ("api/v1/main")
//@AllArgsConstructor
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
    /*@Autowired
    private RepAircraft aircraftRepository;

    @GetMapping("/api/v1/main")
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }
    @GetMapping("/api/v1/main/{code}")
    public ResponseEntity<Aircraft> getAircraftByCode(@PathVariable String code) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(code);
        return aircraft.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping("/api/v1/main")
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        Aircraft createdAircraft = aircraftRepository.save(aircraft);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAircraft);
    }

    @Transactional
    @PutMapping("/api/v1/main/{code}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable String code, @RequestBody Aircraft updatedAircraft){
        Optional<Aircraft> existingAircraft = aircraftRepository.findById(code);
        if(existingAircraft.isPresent()){
            updatedAircraft.setAircraftCode(code);
            Aircraft savedAircraft =  aircraftRepository.save(updatedAircraft);
            return ResponseEntity.ok(savedAircraft);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/api/v1/main/{code}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable String code) {
        boolean isExist = aircraftRepository.existsById(code);
        if(isExist){
            aircraftRepository.deleteById(code);
            return ResponseEntity.noContent().build();
        } else {
            return  ResponseEntity.notFound().build();
        }

    }*/

    /*private final AircraftS service;

    @GetMapping
    public List <Aircraft> findAllAircraft() {
        return service.findAllAircraft();
    }

    @PostMapping ("SaveAircraft")
    public Aircraft SaveAircraft (@RequestBody Aircraft air) {
        return service.SaveAircraft(air);
    }

    @GetMapping ("/{aircraft_code}")
    public Aircraft findAircraftByCode (@PathVariable String aircraft_code) {
        return service.findAircraftByCode(aircraft_code);
    }

    @PutMapping ("UpdateAircraft")
    public Aircraft UpdateAircraft (Aircraft air) {
        return service.UpdateAircraft(air);
    }

    @DeleteMapping ("DeleteAircraft/{aircraft_code}")
    public void DeleteAircraft (@PathVariable String aircraft_code) {
        service.DeleteAircraft(aircraft_code);
    }*/
}
