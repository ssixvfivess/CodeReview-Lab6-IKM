package ru.ikm.flight.schedule.model;

import jakarta.persistence.*;
import lombok.*;
import ru.ikm.flight.schedule.model.Airports;

import java.time.LocalTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Data
//@Builder
//@Entity
public class Flights {

    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airports departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airports arrivalAirport;

    @Column(name = "departure_time")
    private LocalTime departureTime; // LocalTime

    @Column(name = "arrival_time")
    private LocalTime arrivalTime; // LocalTime

    /*@Id
    @GeneratedValue
    private Long flight_id;
    @Column(unique = true)
    private String flight_number;
    private int departure_airoport_id;
    private int arrival_airoport_id;
    private String departure_time;
    private String arrival_time;*/
}
