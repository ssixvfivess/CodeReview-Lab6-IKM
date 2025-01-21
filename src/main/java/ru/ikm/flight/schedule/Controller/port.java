package ru.ikm.flight.schedule.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.Airports;
import ru.ikm.flight.schedule.service.AirportsS;

import java.util.List;

@RestController
@RequestMapping("api/v1/port")
@AllArgsConstructor
public class port {

    private final AirportsS service;

    @GetMapping
    public List<Airports> findAllAirports() {
        return service.findAllAirports();
    }

    @PostMapping("SaveAirports")
    public Airports SaveAirports (@RequestBody Airports air) {
        return service.SaveAirports(air);
    }

    @GetMapping ("/{airoport_code}")
    public Airports findAirportsByCode (@PathVariable String airoport_code) {
        return service.findAirportsByCode(airoport_code);
    }

    @PutMapping ("UpdateAirports")
    public Airports UpdateAirports (Airports air) {
        return service.UpdateAirports(air);
    }

    @DeleteMapping ("DeleteAirports/{airoport_code}")
    public void DeleteAirports (@PathVariable String airoport_code) {
        service.DeleteAirports (airoport_code);
    }
}
