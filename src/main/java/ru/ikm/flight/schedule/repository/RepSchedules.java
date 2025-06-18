package ru.ikm.flight.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikm.flight.schedule.model.Schedules;

/**
 * Базовый репозиторий для работы с сущностью {@link Schedules} в базе данных.
 * Наследует стандартные CRUD-операции из {@link JpaRepository}.
 *
 * @param <Schedules> тип сущности
 * @param <Integer> тип первичного ключа (flight_id)
 */
@Repository
public interface RepSchedules extends JpaRepository<Schedules, Integer> {
}