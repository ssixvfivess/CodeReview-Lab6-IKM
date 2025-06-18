package ru.ikm.flight.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Flights;
import ru.ikm.flight.schedule.service.FlightsService;

import java.util.List;
import java.util.Optional;

/**
 * REST контроллер для управления рейсами.
 * Предоставляет CRUD операции для работы с рейсами через HTTP методы.
 */
@RestController
public class Flight {

    @Autowired
    private FlightsService flightsService;

    /**
     * Получает список всех рейсов.
     *
     * @return список всех рейсов в формате JSON
     */
    @GetMapping("/api/flights")
    public List<Flights> getAllFlights() {
        return flightsService.getAllFlights();
    }

    /**
     * Получает рейс по его номеру.
     *
     * @param number номер рейса для поиска
     * @return ResponseEntity с найденным рейсом (200 OK) или статус 404 Not Found, если рейс не найден
     */
    @GetMapping("/api/flights/{number}")
    public ResponseEntity<Flights> getFlightsByNumber(@PathVariable String number) {
        Optional<Flights> flight = flightsService.getFlightsByNumber(number);
        return flight.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Создает новый рейс.
     *
     * @param flight данные рейса для создания (в теле запроса в формате JSON)
     * @return ResponseEntity с созданным рейсом и статусом 201 Created
     */
    @PostMapping("/api/flights")
    public ResponseEntity<Flights> createFlights(@RequestBody Flights flight) {
        Flights createdFlights = flightsService.createFlights(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlights);
    }

    /**
     * Обновляет существующий рейс по его номеру.
     *
     * @param number номер рейса для обновления
     * @param updatedFlights обновленные данные рейса (в теле запроса в формате JSON)
     * @return ResponseEntity с обновленным рейсом (200 OK) или статус 404 Not Found, если рейс не найден
     */
    @PutMapping("/api/flights/{number}")
    public ResponseEntity<Flights> updateFlights(@PathVariable String number, @RequestBody Flights updatedFlights){
        Flights updated = flightsService.updateFlights(number, updatedFlights);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет рейс по его номеру.
     *
     * @param number номер рейса для удаления
     * @return ResponseEntity с пустым телом и статусом 204 No Content
     */
    @DeleteMapping("/api/flights/{number}")
    public ResponseEntity<Void> deleteFlights(@PathVariable String number) {
        flightsService.deleteFlights(number);
        return ResponseEntity.noContent().build();
    }
}