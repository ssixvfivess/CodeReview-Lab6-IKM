package ru.ikm.flight.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.Schedules;
import ru.ikm.flight.schedule.repository.MemSchedules;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplSchedules implements SchedulesS{

    public final MemSchedules repository = new MemSchedules();

    @Override
    public List<Schedules> findAllSchedules() {
        return repository.findAllSchedules();
    }

    @Override
    public Schedules SaveSchedules (Schedules air) {
        return repository.SaveSchedules(air);
    }

    @Override
    public Schedules findSchedulesByCode (String scheduled_date) {
        return repository.findSchedulesByCode(scheduled_date);
    }

    @Override
    public Schedules UpdateSchedules (Schedules air) {
        return repository.UpdateSchedules(air);
    }

    @Override
    public void DeleteSchedules (String scheduled_date) {
        repository.DeleteSchedules(scheduled_date);
    }
}
