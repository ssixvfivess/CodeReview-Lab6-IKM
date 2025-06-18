package ru.ikm.flight.schedule.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Сущность, представляющая аэропорт в системе.
 * Соответствует таблице 'airports' в базе данных.
 */
@Entity
@Table(name = "airports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Airports {

    /**
     * Уникальный код аэропорта (3-буквенный IATA код)
     * Является первичным ключом
     */
    @Id
    @Column(name = "airport_code")
    private String airportCode;

    /**
     * Официальное название аэропорта
     */
    @Column(name = "airport_name")
    private String airportName;

    /**
     * Город расположения аэропорта
     */
    @Column(name = "city")
    private String city;

    /**
     * Страна расположения аэропорта
     */
    @Column(name = "country")
    private String country;
}