package main.java.com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeThisTime implements FilterInterface{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}
