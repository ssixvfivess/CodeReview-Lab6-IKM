package ru.ikm.flight.schedule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Сущность, представляющая запланированный рейс.
 * Соответствует таблице 'scheduled_flights' в базе данных.
 */
@Entity
@Table(name = "scheduled_flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedules {

    /**
     * Уникальный идентификатор рейса в расписании
     * Является первичным ключом
     */
    @Id
    @Column(name = "flight_id")
    private Integer flightId;

    /**
     * Воздушное судно для рейса (связь Many-to-One)
     */
    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    private Aircraft aircraft;

    /**
     * Дата выполнения рейса
     * Формат: dd.MM.yyyy (например, "15.01.2023")
     */
    @Column(name = "scheduled_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate scheduledDate;
}