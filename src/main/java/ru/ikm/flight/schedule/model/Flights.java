package ru.ikm.flight.schedule.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
}
