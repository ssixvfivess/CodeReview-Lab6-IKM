package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Schedules;
import ru.ikm.flight.schedule.repository.RepSchedules;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с расписанием рейсов.
 * Реализует бизнес-логику для операций с сущностью {@link Schedules}.
 */

@Service
public class SсheduleService {

    @Autowired
    private RepSchedules scheduledFlightRepository;

    /**
     * Получает список всех записей расписания.
     * @return список объектов {@link Schedules}
     */
    public List<Schedules> getAllSchedules() {
        return scheduledFlightRepository.findAll();
    }

    /**
     * Находит запись расписания по ID.
     * @param id идентификатор записи
     * @return Optional с найденным объектом или пустой Optional
     */
    public Optional<Schedules> getSchedulesById(Integer id) {
        return scheduledFlightRepository.findById(id);
    }

    /**
     * Создает новую запись в расписании.
     * @param scheduledFlight объект для создания
     * @return сохраненный объект {@link Schedules}
     */
    @Transactional
    public Schedules createSchedules(Schedules scheduledFlight) {
        return scheduledFlightRepository.save(scheduledFlight);
    }

    /**
     * Обновляет запись в расписании.
     * @param id ID обновляемой записи
     * @param updatedScheduledFlight объект с обновленными данными
     * @return обновленный объект или null если не найден
     */
    @Transactional
    public Schedules updateSchedules(Integer id, Schedules updatedScheduledFlight) {
        Optional<Schedules> existingScheduledFlight = scheduledFlightRepository.findById(id);
        if (existingScheduledFlight.isPresent()) {
            updatedScheduledFlight.setFlightId(id);
            return scheduledFlightRepository.save(updatedScheduledFlight);
        }
        return null;
    }

    /**
     * Удаляет запись из расписания.
     * @param id ID удаляемой записи
     */
    @Transactional
    public void deleteSchedules(Integer id) {
        scheduledFlightRepository.deleteById(id);
    }
}
