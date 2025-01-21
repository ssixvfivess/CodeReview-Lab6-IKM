package ru.ikm.flight.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
//@Builder
@Entity
public class Aircraft {
    @Id
    @GeneratedValue
    private Long aircraft_id;
    @Column(unique = true)
    private String aircraft_code;
    private String model;
    private int capacity;
}
