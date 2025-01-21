package ru.ikm.flight.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
//@Builder
@Entity
public class Flights {
    @Id
    @GeneratedValue
    private Long flight_id;
    @Column(unique = true)
    private String flight_number;
    private int departure_airoport_id;
    private int arrival_airoport_id;
    private String departure_time;
    private String arrival_time;
}
