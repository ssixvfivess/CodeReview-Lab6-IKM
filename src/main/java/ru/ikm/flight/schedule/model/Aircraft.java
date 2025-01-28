package ru.ikm.flight.schedule.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name = "aircrafts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Aircraft {

    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "model")
    private String model;
    @Column(name = "capacity")
    private int capacity;
}
