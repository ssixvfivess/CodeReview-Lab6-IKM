package ru.ikm.flight.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
//@Builder
@Entity
public class Airports {
    @Id
    @GeneratedValue
    private Long airoport_id;
    @Column(unique = true)
    private String airoport_code;
    private String airoport_name;
    private String city;
    private String country;
}
