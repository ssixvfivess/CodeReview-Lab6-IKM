package ru.ikm.flight.schedule.repository;

import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.Schedules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class MemSchedules {
    private final List<Schedules> AIRPORTS = new ArrayList<>();

    public List <Schedules> findAllSchedules() {
        return AIRPORTS;
    }

    public Schedules SaveSchedules (Schedules air) {
        AIRPORTS.add(air);
        return air;
    }

    public Schedules findSchedulesByCode (String scheduled_date) {
        return AIRPORTS.stream().filter(element -> element.getScheduled_date().equals(scheduled_date)).findFirst().orElse(null);
    }

    public Schedules UpdateSchedules (Schedules air) {
        var SchedulesIndex = IntStream.range(0, AIRPORTS.size()).filter(index -> AIRPORTS.get(index).getScheduled_date().equals(air.getScheduled_date())).findFirst().orElse(-1);
        if (SchedulesIndex > -1) {
            AIRPORTS.set(SchedulesIndex, air);
            return air;
        }
        return null;
    }

    public void DeleteSchedules (String scheduled_date) {
        var air = findSchedulesByCode (scheduled_date);
        if (air != null) {
            AIRPORTS.remove(air);
        }
    }
}
