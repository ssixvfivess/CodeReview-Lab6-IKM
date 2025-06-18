package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Airports;
import ru.ikm.flight.schedule.repository.RepAirports;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с аэропортами.
 * Реализует бизнес-логику для операций с сущностью {@link Airports}.
 */
@Service
public class AirportsService {

    @Autowired
    private RepAirports airportRepository;

    /**
     * Получает список всех аэропортов.
     * @return список объектов {@link Airports}
     */
    public List<Airports> getAllAirports() {
        return airportRepository.findAll();
    }

    /**
     * Находит аэропорт по коду.
     * @param code IATA код аэропорта
     * @return Optional с найденным объектом или пустой Optional
     */
    public Optional<Airports> getAirportsByCode(String code) {
        return airportRepository.findById(code);
    }

    /**
     * Создает новый аэропорт.
     * @param airports объект для создания
     * @return сохраненный объект {@link Airports}
     */
    @Transactional
    public Airports createAirports(Airports airports) {
        return airportRepository.save(airports);
    }

    /**
     * Обновляет данные аэропорта.
     * @param code код обновляемого аэропорта
     * @param updatedAirports объект с обновленными данными
     * @return обновленный объект или null если не найден
     */
    @Transactional
    public Airports updateAirports(String code, Airports updatedAirports) {
        Optional<Airports> existingAirports = airportRepository.findById(code);
        if (existingAirports.isPresent()) {
            updatedAirports.setAirportCode(code);
            return airportRepository.save(updatedAirports);
        }
        return null;
    }

    /**
     * Удаляет аэропорт по коду.
     * @param code код удаляемого аэропорта
     */
    @Transactional
    public void deleteAirports(String code) {
        airportRepository.deleteById(code);
    }
}