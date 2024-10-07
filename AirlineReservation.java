import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String destination;
    private int capacity;          //Capacity:Available seats
    private List<Passenger> passengers;        //Generic Type that holds object of class Passenger

    public Flight(String flightNumber, String destination, int capacity) {       //Constructor
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;                  //To store the available seats in a flight
        this.passengers = new ArrayList<>();        
    }

    public String getFlightNumber() {            //To get the Flight Number
        return flightNumber;
    }

    public String getDestination() {              //To get the Destination of Passenger
        return destination;
    }

    public boolean bookSeat(Passenger passenger) {
        if (passengers.size() < capacity) {        //To maintain the no.of seats 
            passengers.add(passenger);
            return true;
        }
        return false;          
    }

    public int availableSeats() {              //To check the available seats  //Called in displayFlight()
        return capacity - passengers.size();
    }

    // public void printPassengerList() {          //To display the passenger Names
    //     System.out.println("Passengers on flight " + flightNumber + ":");
    //     for (Passenger passenger : passengers) {            //Enhanced For loop for printing Passenger
    //         System.out.println("- " + passenger.getName());
    //     }
    // }
}

class Passenger {      //To get the details of an individual passenger
    private String name;

    public Passenger(String name) {     //Constructor
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class AirlineReservationSystem {
    private List<Flight> flights;         

    public AirlineReservationSystem() {
        flights = new ArrayList<>();
        initializeFlights();
    }

    private void initializeFlights() {
        flights.add(new Flight("AA101", "New York", 3));        //flights is an object for class Flight
        flights.add(new Flight("BA202", "London", 2));
        flights.add(new Flight("CA303", "Paris", 4));
    }

    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight.getFlightNumber() + " to " + flight.getDestination() + 
                               " - Available seats: " + flight.availableSeats());
        }
    }

    public Flight findFlight(String flightNumber) {            //We declare Flight instead of (any datatype) because we need to return variable of type object to the flight class
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {          //Compares the user input and avail flights ignoring the case
                return flight;
            }
        }
        return null;
    }
}

public class AirlineReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirlineReservationSystem airline = new AirlineReservationSystem();

        while (true) {
            airline.displayFlights();
            System.out.print("Enter flight number to book (or 'exit' to quit): ");
            String flightNumber = scanner.nextLine();

            if (flightNumber.equalsIgnoreCase("exit")) {  //Exit to get outside of reservation
                break;
            }

            Flight flight = airline.findFlight(flightNumber);        //Object for Flight class
            if (flight == null) {
                System.out.println("Flight not found!");
                continue;                                            //To make the user to try again if the value is null
            }

            System.out.print("Enter passenger name: ");
            String passengerName = scanner.nextLine();
            Passenger passenger = new Passenger(passengerName);

            if (flight.bookSeat(passenger)) {    //Checks if bookSeat in class Flight returns true or false
                System.out.println("Seat booked successfully for " + passengerName);
            } else {
                System.out.println("No available seats on this flight.");
            }
        }
    }
}