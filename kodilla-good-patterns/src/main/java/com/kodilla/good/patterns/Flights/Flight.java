package com.kodilla.good.patterns.Flights;

import java.util.Objects;

public final class Flight {
    private final String departureAirport;
    private final String destinationAirport;
    private final String flightNr;

    Flight(final String departureAirport, final String destinationAirport, final String flightNr) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.flightNr = flightNr;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(destinationAirport, flight.destinationAirport) &&
                Objects.equals(flightNr, flight.flightNr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(departureAirport, destinationAirport, flightNr);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", flightNr='" + flightNr + '\'' +
                '}';
    }
}
