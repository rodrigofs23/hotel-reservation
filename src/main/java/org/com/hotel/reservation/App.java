package org.com.hotel.reservation;

import org.com.hotel.reservation.hotels.DefaultHotels;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {
    public static void main(String[] args) {
        String fileLocation = "input/sampleInput.txt";
        List<String> allLines = null;

        try (Stream<String> lines = Files.lines(new File(fileLocation).toPath())) {
            allLines = lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        ReservationSystem reservationSystem = new ReservationSystem(allLines, new DefaultHotels().hotels());
        System.out.println(reservationSystem.reservationResults());
    }
}
