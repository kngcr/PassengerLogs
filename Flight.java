package assignments09;

import java.util.ArrayList;

public class Flight {
    private static final int CAPACITY = 6;
    private int flightNumber;
    private ArrayList<Passenger> passengers;

    public Flight(int f) {
        this.flightNumber = f;
        this.passengers = new ArrayList<>();
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public boolean addPassenger(Passenger p) {
        if (passengers.size() < CAPACITY) {
            passengers.add(p);
            return true;
        }
        return false;
    }

    public boolean cancelPassenger(Passenger p) {
        return passengers.remove(p);
    }

    public String getPassengerManifest() {
        StringBuilder manifest = new StringBuilder();
        manifest.append("Flight ").append(flightNumber).append("\n");
        manifest.append(passengers.size()).append(" passengers\n");
        for (Passenger p : passengers) {
            manifest.append(p.toString()).append("\n");
        }
        return manifest.toString();
    }
} 