package ru.ikm.flight.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Schedules;
import ru.ikm.flight.schedule.service.SсheduleService;

import java.util.List;
import java.util.Optional;

/**
 * REST контроллер для управления расписанием рейсов.
 * Предоставляет API для работы с расписанием полетов, включая создание, чтение,
 * обновление и удаление записей расписания.
 * Базовый путь для всех endpoints: /api/schedules
 */
@RestController
public class Schedule {

    @Autowired
    private SсheduleService scheduledFlightService;

    /**
     * Получает полное расписание всех рейсов.
     *
     * @return список всех записей расписания в формате JSON со статусом 200 OK
     * @apiNote Пример ответа:
     * [
     *   {
     *     "id": 1,
     *     "flightNumber": "SU100",
     *     "departureAirport": "SVO",
     *     "arrivalAirport": "LED",
     *     "departureTime": "2023-12-01T08:00:00",
     *     "arrivalTime": "2023-12-01T09:30:00"
     *   },
     *   {
     *     "id": 2,
     *     "flightNumber": "SU200",
     *     "departureAirport": "LED",
     *     "arrivalAirport": "SVO",
     *     "departureTime": "2023-12-01T18:00:00",
     *     "arrivalTime": "2023-12-01T19:30:00"
     *   }
     * ]
     */
    @GetMapping("/api/schedules")
    public List<Schedules> getAllSchedules() {
        return scheduledFlightService.getAllSchedules();
    }

    /**
     * Получает запись расписания по уникальному идентификатору.
     *
     * @param id уникальный идентификатор записи расписания
     * @return ResponseEntity с объектом расписания (200 OK) или 404 Not Found если запись не найдена
     * @throws NumberFormatException если переданный ID имеет неверный формат
     */
    @GetMapping("/api/schedules/{id}")
    public ResponseEntity<Schedules> getSchedulesById(@PathVariable Integer id) {
        Optional<Schedules> scheduledFlight = scheduledFlightService.getSchedulesById(id);
        return scheduledFlight.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Создает новую запись в расписании рейсов.
     *
     * @param scheduledFlight объект Schedules с данными нового рейса (в теле запроса JSON)
     * @return ResponseEntity с созданным объектом Schedules и статусом 201 Created
     * @apiNote Пример тела запроса:
     * {
     *   "flightNumber": "SU300",
     *   "departureAirport": "KZN",
     *   "arrivalAirport": "SVO",
     *   "departureTime": "2023-12-01T12:00:00",
     *   "arrivalTime": "2023-12-01T13:30:00"
     * }
     */
    @PostMapping("/api/schedules")
    public ResponseEntity<Schedules> createSchedules(@RequestBody Schedules scheduledFlight) {
        Schedules createdScheduledFlight = scheduledFlightService.createSchedules(scheduledFlight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdScheduledFlight);
    }

    /**
     * Обновляет существующую запись в расписании рейсов.
     *
     * @param id уникальный идентификатор обновляемой записи
     * @param updatedScheduledFlight объект Schedules с обновленными данными рейса
     * @return ResponseEntity с обновленным объектом Schedules (200 OK) или 404 Not Found если запись не найдена
     * @warning Обновление времени рейса может повлиять на связанные бронирования
     */
    @PutMapping("/api/schedules/{id}")
    public ResponseEntity<Schedules> updateSchedules(@PathVariable Integer id,
                                                     @RequestBody Schedules updatedScheduledFlight) {
        Schedules updated = scheduledFlightService.updateSchedules(id, updatedScheduledFlight);
        if(updated != null){
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет запись из расписания рейсов.
     *
     * @param id уникальный идентификатор удаляемой записи
     * @return ResponseEntity с пустым телом и статусом 204 No Content
     * @warning Удаление записи расписания может повлиять на существующие бронирования
     */
    @DeleteMapping("/api/schedules/{id}")
    public ResponseEntity<Void> deleteSchedules(@PathVariable Integer id) {
        scheduledFlightService.deleteSchedules(id);
        return ResponseEntity.noContent().build();
    }
}