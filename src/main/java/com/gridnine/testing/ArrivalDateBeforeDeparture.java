package main.java.com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalDateBeforeDeparture implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.parallelStream().filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
