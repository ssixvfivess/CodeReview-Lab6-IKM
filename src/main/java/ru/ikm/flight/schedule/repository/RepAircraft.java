package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Aircraft;

/**
 * Базовый репозиторий для работы с сущностью {@link Aircraft} в базе данных.
 * Наследует стандартные CRUD-операции из {@link JpaRepository}.
 *
 * @param <Aircraft> тип сущности
 * @param <String> тип первичного ключа (aircraft_code)
 */
@Repository
public interface RepAircraft extends JpaRepository<Aircraft, String> {
}
