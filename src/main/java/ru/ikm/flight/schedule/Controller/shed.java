package ru.ikm.flight.schedule.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.Schedules;
import ru.ikm.flight.schedule.service.SchedulesS;

import java.util.List;

@RestController
@RequestMapping("api/v1/shed")
@AllArgsConstructor
public class shed {

    private final SchedulesS service;

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
    }
}
