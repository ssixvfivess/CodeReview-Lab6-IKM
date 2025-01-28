package ru.ikm.flight.schedule.Controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Schedules;
import ru.ikm.flight.schedule.repository.RepSchedules;
import ru.ikm.flight.schedule.service.ShedulesService;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api/v1/shed")
//@AllArgsConstructor
public class shed {

    @Autowired
    private ShedulesService scheduledFlightService;


    @GetMapping("/api/schedules")
    public List<Schedules> getAllSchedules() {
        return scheduledFlightService.getAllSchedules();
    }
    @GetMapping("/api/schedules/{id}")
    public ResponseEntity<Schedules> getSchedulesById(@PathVariable Integer id) {
        Optional<Schedules> scheduledFlight = scheduledFlightService.getSchedulesById(id);
        return scheduledFlight.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/schedules")
    public ResponseEntity<Schedules> createSchedules(@RequestBody Schedules scheduledFlight) {
        Schedules createdScheduledFlight = scheduledFlightService.createSchedules(scheduledFlight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdScheduledFlight);
    }
    @PutMapping("/api/schedules/{id}")
    public ResponseEntity<Schedules> updateSchedules(@PathVariable Integer id, @RequestBody Schedules updatedScheduledFlight){
        Schedules updated =   scheduledFlightService.updateSchedules(id, updatedScheduledFlight);
        if(updated != null){
            return  ResponseEntity.ok(updated);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/api/schedules/{id}")
    public ResponseEntity<Void> deleteSchedules(@PathVariable Integer id) {
        scheduledFlightService.deleteSchedules(id);
        return ResponseEntity.noContent().build();
    }
}

    /*private final SchedulesS service;

    @GetMapping
    public List<Schedules> findAllSchedules() {
        return service.findAllSchedules();
    }

    @PostMapping("SaveSchedules")
    public Schedules SaveSchedules (@RequestBody Schedules air) {
        return service.SaveSchedules(air);
    }

    @GetMapping ("/{scheduled_date}")
    public Schedules findSchedulesByCode (@PathVariable String scheduled_date) {
        return service.findSchedulesByCode(scheduled_date);
    }

    @PutMapping ("UpdateSchedules")
    public Schedules UpdateSchedules (Schedules air) {
        return service.UpdateSchedules(air);
    }

    @DeleteMapping ("DeleteSchedules/{scheduled_date}")
    public void DeleteSchedules (@PathVariable String scheduled_date) {
        service.DeleteSchedules(scheduled_date);
    }*/
