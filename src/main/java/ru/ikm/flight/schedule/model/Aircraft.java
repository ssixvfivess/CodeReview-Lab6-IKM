package ru.ikm.flight.schedule.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Сущность, представляющая воздушное судно в системе.
 * Соответствует таблице 'aircrafts' в базе данных.
 */
@Entity
@Table(name = "aircrafts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    /**
     * Уникальный код воздушного судна (IATA или ICAO код)
     * Является первичным ключом
     */
    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;

    /**
     * Модель воздушного судна (например, "Boeing 737-800")
     */
    @Column(name = "model")
    private String model;

    /**
     * Вместимость пассажиров (максимальное количество)
     */
    @Column(name = "capacity")
    private int capacity;
}