package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Airports;

/**
 * Базовый репозиторий для работы с сущностью {@link Airports} в базе данных.
 * Наследует стандартные CRUD-операции из {@link JpaRepository}.
 *
 * @param <Airports> тип сущности
 * @param <String> тип первичного ключа (airport_code)
 */
@Repository
public interface RepAirports extends JpaRepository<Airports, String> {
}