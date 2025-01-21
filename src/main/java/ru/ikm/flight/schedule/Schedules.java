package ru.ikm.flight.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
//@Builder
@Entity
public class Schedules {
    @Id
    @GeneratedValue
    private Long schedule_id;
    @Column(unique = true)
    private int flight_id;
    @Column(unique = true)
    private int aircraft_id;
    private String scheduled_date;
}
