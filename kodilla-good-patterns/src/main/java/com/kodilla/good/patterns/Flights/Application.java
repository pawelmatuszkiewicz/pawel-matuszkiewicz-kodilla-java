package com.kodilla.good.patterns.Flights;

import java.util.Set;

public class Application {
    public static void main(String[] args) {

        Set<Flight> flights = (new Flights()).getFlightSet();

        FlightSearchService flightSearchService = new FlightSearchService(flights);

        System.out.println("\t\t Flights from WARSZAWA");
        flightSearchService.searchFrom("WARSZAWA");

        System.out.println("\t\t Flights to POZNAŃ");
        flightSearchService.searchTo("POZNAŃ");

        System.out.println("\t\t Flights from WARSZAWA to POZNAŃ via KRAKÓW");
        flightSearchService.searchFromToVia("WARSZAWA", "POZNAŃ", "KRAKÓW");

        System.out.println("\t\t Flights from WROCŁAW to GDAŃSK via WARSZAWA");
        flightSearchService.searchFromToVia("WROCŁAW", "GDAŃSK", "WARSZAWA");
    }
}
