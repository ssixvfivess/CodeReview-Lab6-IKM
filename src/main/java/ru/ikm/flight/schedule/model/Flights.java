package ru.ikm.flight.schedule.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

/**
 * Сущность, представляющая маршрут полета между аэропортами.
 * Соответствует таблице 'flights' в базе данных.
 */
@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flights {

    /**
     * Номер рейса (например, "SU100")
     * Является первичным ключом
     */
    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    /**
     * Аэропорт вылета (связь Many-to-One)
     */
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airports departureAirport;

    /**
     * Аэропорт прилета (связь Many-to-One)
     */
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airports arrivalAirport;

    /**
     * Время вылета по расписанию
     */
    @Column(name = "departure_time")
    private LocalTime departureTime;

    /**
     * Время прилета по расписанию
     */
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
}