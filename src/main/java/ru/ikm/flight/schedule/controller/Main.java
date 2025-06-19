package ru.ikm.flight.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Aircraft;
import ru.ikm.flight.schedule.service.AircraftService;

import java.util.Optional;

import java.util.List;

/**
 * REST контроллер для управления воздушными судами (самолетами).
 * Предоставляет CRUD-операции для работы с данными о воздушных судах через HTTP API.
 */
@RestController
public class Main {

    @Autowired
    private AircraftService aircraftService;

    /**
     * Получает список всех воздушных судов.
     *
     * @return список всех воздушных судов в формате JSON
     */
    @GetMapping("/api/aircrafts")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    /**
     * Получает информацию о воздушном судне по его коду.
     *
     * @param aircraft_code уникальный код воздушного судна
     * @return ResponseEntity с найденным воздушным судном (200 OK) или статус 404 Not Found, если судно не найдено
     */
    @GetMapping("/api/aircrafts/{aircraft_code}")
    public ResponseEntity<Aircraft> getAircraftByCode(@PathVariable String aircraft_code) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftByCode(aircraft_code);
        return aircraft.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Создает новое воздушное судно.
     *
     * @param aircraft данные воздушного судна для создания (в теле запроса в формате JSON)
     * @return ResponseEntity с созданным воздушным судном и статусом 201 Created
     */
    @PostMapping("/api/aircrafts")
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        Aircraft createdAircraft = aircraftService.createAircraft(aircraft);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAircraft);
    }

    /**
     * Обновляет информацию о воздушном судне по его коду.
     *
     * @param aircraft_code код воздушного судна для обновления
     * @param updatedAircraft обновленные данные воздушного судна (в теле запроса в формате JSON)
     * @return ResponseEntity с обновленным воздушным судном (200 OK) или статус 404 Not Found, если судно не найдено
     */
    @PutMapping("/api/aircrafts/{aircraft_code}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable String aircraft_code,
                                                   @RequestBody Aircraft updatedAircraft) {
        Aircraft updated = aircraftService.updateAircraft(aircraft_code, updatedAircraft);
        if (updated != null){
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет информацию о воздушном судне по его коду.
     *
     * @param aircraft_code код воздушного судна для удаления
     * @return ResponseEntity с пустым телом и статусом 204 No Content
     */
    @DeleteMapping("/api/aircrafts/{aircraft_code}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable String aircraft_code) {
        aircraftService.deleteAircraft(aircraft_code);
        return ResponseEntity.noContent().build();
    }
}
