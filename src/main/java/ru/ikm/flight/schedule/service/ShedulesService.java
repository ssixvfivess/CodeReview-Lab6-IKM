package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Schedules;
import ru.ikm.flight.schedule.repository.RepSchedules;

import java.util.List;
import java.util.Optional;

@Service
public class ShedulesService {

    @Autowired
    private RepSchedules scheduledFlightRepository;

    public List<Schedules> getAllSchedules() {
        return scheduledFlightRepository.findAll();
    }
    public Optional<Schedules> getSchedulesById(Integer id) {
        return scheduledFlightRepository.findById(id);
    }
    @Transactional
    public Schedules createSchedules(Schedules scheduledFlight) {
        return  scheduledFlightRepository.save(scheduledFlight);
    }

    @Transactional
    public Schedules updateSchedules(Integer id, Schedules updatedScheduledFlight) {
        Optional<Schedules> existingScheduledFlight = scheduledFlightRepository.findById(id);
        if (existingScheduledFlight.isPresent()) {
            updatedScheduledFlight.setFlightId(id);
            return  scheduledFlightRepository.save(updatedScheduledFlight);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteSchedules(Integer id) {
        scheduledFlightRepository.deleteById(id);
    }
}
