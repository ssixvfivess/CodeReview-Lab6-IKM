package ru.ikm.flight.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Airports;
import ru.ikm.flight.schedule.service.AirportsService;

import java.util.List;
import java.util.Optional;

/**
 * REST контроллер для управления аэропортами.
 * Предоставляет полный набор операций CRUD для работы с данными аэропортов через REST API.
 * Все endpoints доступны по базовому пути /api/airports.
 */
@RestController
public class Airport {

    @Autowired
    private AirportsService airportService;

    /**
     * Получает список всех аэропортов в системе.
     *
     * @return список объектов Airports в формате JSON со статусом 200 OK
     * @apiNote Пример ответа:
     * [
     * {
     * "code": "SVO",
     * "name": "Шереметьево",
     * "city": "Москва",
     * "coordinates": "55.972642, 37.414589"
     * },
     * {
     * "code": "LED",
     * "name": "Пулково",
     * "city": "Санкт-Петербург",
     * "coordinates": "59.800292, 30.262503"
     * }
     * ]
     */
    @GetMapping("/api/airports")
    public List<Airports> getAllAirports() {
        return airportService.getAllAirports();
    }

    /**
     * Получает данные конкретного аэропорта по его коду.
     *
     * @param code уникальный трехбуквенный код аэропорта (IATA код)
     * @return ResponseEntity с объектом Airports (200 OK) или 404 Not Found если аэропорт не найден
     * @apiNote Пример запроса: GET /api/airports/SVO
     */
    @GetMapping("/api/airports/{code}")
    public ResponseEntity<Airports> getAirportByCode(@PathVariable String code) {
        Optional<Airports> airport = airportService.getAirportsByCode(code);
        return airport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Создает новый аэропорт в системе.
     *
     * @param airport объект Airports с данными нового аэропорта (в теле запроса JSON)
     * @return ResponseEntity с созданным объектом Airports и статусом 201 Created
     * @apiNote Пример тела запроса:
     * {
     * "code": "KZN",
     * "name": "Казань",
     * "city": "Казань",
     * "coordinates": "55.606186, 49.278728"
     * }
     */
    @PostMapping("/api/airports")
    public ResponseEntity<Airports> createAirport(@RequestBody Airports airport) {
        Airports createdAirport = airportService.createAirports(airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirport);
    }

    /**
     * Обновляет данные существующего аэропорта.
     *
     * @param code            код обновляемого аэропорта
     * @param updatedAirports объект Airports с обновленными данными
     * @return ResponseEntity с обновленным объектом Airports (200 OK) или 404 Not Found если аэропорт не найден
     * @apiNote Все поля кроме кода могут быть обновлены
     */
    @PutMapping("/api/airports/{code}")
    public ResponseEntity<Airports> updateAirport(@PathVariable String code, @RequestBody Airports updatedAirports) {
        Airports updated = airportService.updateAirports(code, updatedAirports);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет аэропорт из системы по его коду.
     *
     * @param code код удаляемого аэропорта
     * @return ResponseEntity с пустым телом и статусом 204 No Content
     * @warning Удаление аэропорта может повлиять на связанные рейсы и расписания
     */
    @DeleteMapping("/api/airports/{code}")
    public ResponseEntity<Void> deleteAirports(@PathVariable String code) {
        airportService.deleteAirports(code);
        return ResponseEntity.noContent().build();
    }
}
