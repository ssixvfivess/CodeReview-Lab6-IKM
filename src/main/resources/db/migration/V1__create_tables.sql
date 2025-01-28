CREATE TABLE aircrafts (
                           aircraft_code VARCHAR(255) PRIMARY KEY,
                           model VARCHAR(255),
                           capacity INTEGER
);

CREATE TABLE airports (
                          airport_code VARCHAR(255) PRIMARY KEY,
                          airport_name VARCHAR(255),
                          city VARCHAR(255),
                          country VARCHAR(255)
);

CREATE TABLE scheduled_flights (
                                   flight_id INTEGER PRIMARY KEY ,
                                   aircraft_code VARCHAR(255) REFERENCES aircrafts(aircraft_code),
                                   scheduled_date DATE
);

CREATE TABLE flights (
                         flight_number VARCHAR(255) PRIMARY KEY,
                         departure_airport_id VARCHAR(255) REFERENCES airports(airport_code),
                         arrival_airport_id VARCHAR(255) REFERENCES airports(airport_code),
                         departure_time TIME,
                         arrival_time TIME
);
