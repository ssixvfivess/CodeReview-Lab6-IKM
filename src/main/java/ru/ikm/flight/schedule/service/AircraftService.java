package ru.ikm.flight.schedule.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ikm.flight.schedule.model.Aircraft;
import ru.ikm.flight.schedule.repository.RepAircraft;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с воздушными судами.
 * Обеспечивает бизнес-логику для операций CRUD с сущностью {@link Aircraft}.
 */
@Service
public class AircraftService {

    @Autowired
    private RepAircraft aircraftRepository;

    /**
     * Получает список всех воздушных судов.
     * @return список объектов {@link Aircraft}
     */
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    /**
     * Находит воздушное судно по коду.
     * @param code код воздушного судна (IATA/ICAO)
     * @return Optional с найденным объектом или пустой Optional
     */
    public Optional<Aircraft> getAircraftByCode(String code) {
        return aircraftRepository.findById(code);
    }

    /**
     * Создает новое воздушное судно.
     * @param aircraft объект для создания
     * @return сохраненный объект {@link Aircraft}
     */
    @Transactional
    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    /**
     * Обновляет данные воздушного судна.
     * @param code код обновляемого судна
     * @param updatedAircraft объект с обновленными данными
     * @return обновленный объект или null если не найден
     */
    @Transactional
    public Aircraft updateAircraft(String code, Aircraft updatedAircraft){
        Optional<Aircraft> existingAircraft = aircraftRepository.findById(code);
        if(existingAircraft.isPresent()){
            updatedAircraft.setAircraftCode(code);
            return aircraftRepository.save(updatedAircraft);
        }
        return null;
    }

    /**
     * Удаляет воздушное судно по коду.
     * @param code код удаляемого судна
     */
    @Transactional
    public void deleteAircraft(String code) {
        aircraftRepository.deleteById(code);
    }
}
