package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Flights;
import ru.ikm.flight.schedule.repository.RepFlights;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с рейсами.
 * Содержит бизнес-логику для операций с сущностью {@link Flights}.
 */
@Service
public class FlightsService {

    @Autowired
    private RepFlights flightRepository;

    /**
     * Получает список всех рейсов.
     * @return список объектов {@link Flights}
     */
    public List<Flights> getAllFlights() {
        return flightRepository.findAll();
    }

    /**
     * Находит рейс по номеру.
     * @param number номер рейса
     * @return Optional с найденным объектом или пустой Optional
     */
    public Optional<Flights> getFlightsByNumber(String number) {
        return flightRepository.findById(number);
    }

    /**
     * Создает новый рейс.
     * @param flight объект для создания
     * @return сохраненный объект {@link Flights}
     */
    @Transactional
    public Flights createFlights(Flights flight) {
        return flightRepository.save(flight);
    }

    /**
     * Обновляет данные рейса.
     * @param number номер обновляемого рейса
     * @param updatedFlight объект с обновленными данными
     * @return обновленный объект или null если не найден
     */
    @Transactional
    public Flights updateFlights(String number, Flights updatedFlight){
        Optional<Flights> existingFlight = flightRepository.findById(number);
        if(existingFlight.isPresent()){
            updatedFlight.setFlightNumber(number);
            return flightRepository.save(updatedFlight);
        }
        return null;
    }

    /**
     * Удаляет рейс по номеру.
     * @param number номер удаляемого рейса
     */
    @Transactional
    public void deleteFlights(String number) {
        flightRepository.deleteById(number);
    }
}
