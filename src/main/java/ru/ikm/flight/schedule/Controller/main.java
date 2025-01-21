package ru.ikm.flight.schedule.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.Aircraft;
import ru.ikm.flight.schedule.service.AircraftS;

import java.util.List;

@RestController
@RequestMapping ("api/v1/main")
@AllArgsConstructor
public class main {

    private final AircraftS service;

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
    }
}
