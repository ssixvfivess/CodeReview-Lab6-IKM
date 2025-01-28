package ru.ikm.flight.schedule.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name = "aircrafts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Data
//@Builder
//@Entity
public class Aircraft {

    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "model")
    private String model;
    @Column(name = "capacity")
    private int capacity;

    /*@Id
    @GeneratedValue
    private Long aircraft_id;
    @Column(unique = true)
    private String aircraft_code;
    private String model;
    private int capacity;*/
}
