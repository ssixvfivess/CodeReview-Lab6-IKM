package ru.ikm.flight.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Schedules;
import ru.ikm.flight.schedule.repository.RepSchedules;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ImplSchedulesS implements SchedulesS{

    private final RepSchedules rep;

    @Override
    public List<Schedules> findAllSchedules() {
        return rep.findAllSchedules();
    }

    @Override
    public Schedules SaveSchedules (Schedules air) {
        return rep.SaveSchedules(air);
    }

    @Override
    public Schedules findSchedulesByCode (String scheduled_date) {
        return rep.findSchedulesByCode(scheduled_date);
    }

    @Override
    public Schedules UpdateSchedules (Schedules air) {
        return rep.UpdateSchedules(air);
    }

    @Override
    public void DeleteSchedules (String scheduled_date) {
        rep.DeleteSchedules(scheduled_date);
    }
}
