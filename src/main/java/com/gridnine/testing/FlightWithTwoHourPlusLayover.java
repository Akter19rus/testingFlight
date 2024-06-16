package main.java.com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightWithTwoHourPlusLayover implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> {
                            int segmentIndex = flight.getSegments().indexOf(segment);
                            if (segmentIndex < flight.getSegments().size() - 1) {
                                LocalDateTime depTime = flight.getSegments().get(segmentIndex + 1).getDepartureDate();
                                LocalDateTime arrTime = segment.getArrivalDate();
                                return depTime.isAfter(arrTime.plusHours(2));
                            }
                            return false;
                        }))
                .collect(Collectors.toList());
    }
}
