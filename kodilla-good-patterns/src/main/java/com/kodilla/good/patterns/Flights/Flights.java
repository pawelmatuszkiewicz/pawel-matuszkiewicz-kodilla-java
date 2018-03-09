package com.kodilla.good.patterns.Flights;

import java.util.HashSet;
import java.util.Set;

public final class Flights {
    private final Set<Flight> flightSet = new HashSet<>();

    Flights() {
        flightSet.add(new Flight("WARSZAWA", "KRAKÓW", "WA1"));
        flightSet.add(new Flight("WARSZAWA", "GDAŃSK", "WA2"));
        flightSet.add(new Flight("WARSZAWA", "WROCŁAW", "WA3"));
        flightSet.add(new Flight("WARSZAWA", "POZNAŃ", "WA4"));
        flightSet.add(new Flight("WARSZAWA", "GDAŃSK", "WA5"));
        flightSet.add(new Flight("KRAKÓW", "WARSZAWA", "K1"));
        flightSet.add(new Flight("KRAKÓW", "POZNAŃ", "K2"));
        flightSet.add(new Flight("KRAKÓW", "GDAŃSK", "K3"));
        flightSet.add(new Flight("KRAKÓW", "WROCŁAW", "K4"));
        flightSet.add(new Flight("GDAŃSK", "WARSZAWA", "G1"));
        flightSet.add(new Flight("GDAŃSK", "KRAKÓW", "G2"));
        flightSet.add(new Flight("WROCŁAW", "WARSZAWA", "WR1"));
        flightSet.add(new Flight("WROCŁAW", "POZNAŃ", "WR2"));
        flightSet.add(new Flight("POZNAŃ", "WARSZAWA", "P1"));
        flightSet.add(new Flight("POZNAŃ", "WROCŁAW", "P2"));
    }

    public Set<Flight> getFlightSet() {
        return new HashSet<>(flightSet);
    }
}
