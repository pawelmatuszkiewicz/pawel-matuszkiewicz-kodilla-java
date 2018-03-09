package com.kodilla.good.patterns.Flights;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearchService implements SearchService {
    private final Set<Flight> flights;

    FlightSearchService(Set<Flight> flightSet) {
        this.flights = flightSet;
    }

    @Override
    public void searchFrom(String from) {

        flights.stream().filter(f -> f.getDepartureAirport().equals(from))
                            .forEach(System.out::println);
    }

    @Override
    public void searchTo(String to) {

        flights.stream().filter(f -> f.getDestinationAirport().equals(to))
                .forEach(System.out::println);
    }

    @Override
    public void searchFromToVia(String from, String to, String via) {

        Set<Flight> fromViaFlights;
        fromViaFlights = flights.stream().filter(f -> f.getDepartureAirport().equals(from))
                                    .filter(f -> f.getDestinationAirport().equals(via))
                                    .collect(Collectors.toSet());

        Set<Flight> viaToFlights;
        viaToFlights = flights.stream().filter(f -> f.getDepartureAirport().equals(via))
                                    .filter(f -> f.getDestinationAirport().equals(to))
                                    .collect(Collectors.toSet());

        if (fromViaFlights.size() > 0 && viaToFlights.size() > 0) {
            fromViaFlights.forEach(System.out::println);
            viaToFlights.forEach(System.out::println);
        } else {
            System.out.println("No flights found.");
        }
    }
}
