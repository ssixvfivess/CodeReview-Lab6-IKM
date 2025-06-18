package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Flights;

/**
 * Базовый репозиторий для работы с сущностью {@link Flights} в базе данных.
 * Наследует стандартные CRUD-операции из {@link JpaRepository}.
 *
 * @param <Flights> тип сущности
 * @param <String> тип первичного ключа (flight_number)
 */
@Repository
public interface RepFlights extends JpaRepository<Flights, String> {
}