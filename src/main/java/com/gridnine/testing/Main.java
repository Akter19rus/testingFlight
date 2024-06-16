package main.java.com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Все перелеты");
        fullDeparture(flights);
        delimiter();

        FilterInterface filter = new DepartureBeforeThisTime();
        System.out.println("Вылет до текущего момента времени\n" + filter.filter(flights));
        delimiter();

        FilterInterface filter1 = new ArrivalDateBeforeDeparture();
        System.out.println("Сегменты с датой прилёта раньше даты вылета\n" + filter1.filter(flights));
        delimiter();

        FilterInterface filter2 = new FlightWithTwoHourPlusLayover();
        System.out.println("Перелеты, где общее время, проведённое на земле, превышает два часа\n" + filter2.filter(flights));
        delimiter();
    }

    private static void delimiter() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void fullDeparture (List<Flight> flights) {
        flights.parallelStream().forEach(System.out::println);
    }
}