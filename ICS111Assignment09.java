package assignments09;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ICS111Assignment09 {
    public static void main(String[] args) {
        ArrayList<Passenger> passengers = readPassengerData("passengers2.csv");

        Flight flight473 = new Flight(473);
        Flight flight474 = new Flight(474);

        for (Passenger passenger : passengers) {
            if (!flight473.addPassenger(passenger)) {
                if (!flight474.addPassenger(passenger)) {
                    System.out.println(passenger.toString() + " could not be booked on any flights.");
                } else {
                    System.out.println(passenger.toString() + " is booked on flight 474");
                }
            } else {
                System.out.println(passenger.toString() + " is booked on flight 473");
            }
        }

        System.out.println(flight473.getPassengerManifest());
        System.out.println(flight474.getPassengerManifest());

        // Cancelling a passenger from flight 473 and trying to book them on flight 474
        Passenger passengerToCancel = passengers.get(0); // Change the index as needed
        if (flight473.cancelPassenger(passengerToCancel)) {
            System.out.println(passengerToCancel.toString() + " has cancelled flight 473");
            if (!flight474.addPassenger(passengerToCancel)) {
                System.out.println(passengerToCancel.toString() + " could not be booked on flight 474");
            } else {
                System.out.println(passengerToCancel.toString() + " is booked on flight 474");
            }
        }

        System.out.println(flight473.getPassengerManifest());
        System.out.println(flight474.getPassengerManifest());
    }
private static ArrayList<Passenger> readPassengerData(String fileName) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("passengers2.csv"));
            // Skipping the header line
            scanner.nextLine();

            while (scanner.hasNextLine()) {
            	int i = 0; // Index of String
            	int c = 0; // Index of first Comma
            	int d = 0; // Index of last Comma
                String[] data = scanner.nextLine().split("\\t"); // Assuming tab-separated data
                c = data[i].indexOf(",");
                d = data[i].lastIndexOf(",");
                String name = data[i].substring(0,c);
                c++;
                boolean frequentFlyer = (data[i].substring(c,d)).equalsIgnoreCase("TRUE");
                d++;
                int miles = Integer.parseInt(data[i].substring(d,data[i].length()));
                passengers.add(new Passenger(name, frequentFlyer, miles));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengers;
    }
}