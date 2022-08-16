import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  static int BookingId = 1;

  public static void main(String[] args) {
    print("----- Flight Reservation -----");
    boolean isUserWantedToQuite = false;
    LinkedList<Flight> AllFlights = getCreatedFlights();
    while (!isUserWantedToQuite) {
      print("1) Book Flight\n2) Cancel Booking\n3) List Passengers\n4) Exit\nEnter Choice:");
      int userChoice = getNumberInput();
      switch (userChoice) {
        case 1:
          print("Enter Flight Id");
          int flightId = getNumberInput();
          if (flightId > AllFlights.size()) {
            print("Invalid Flight Number!");
            break;
          }
          Flight currentFlight = null;
          for (Flight flight : AllFlights) {
            if (flightId == flight.FlightNumber) {
              currentFlight = flight;
              print(flight.toString());
            }
          }
          print("Enter name:");
          String name = getStringInput();
          print("How many tickets you want ?");
          int numOfTickets = getNumberInput();
          if (numOfTickets <= currentFlight.AvailableTickets
              && currentFlight.AvailableTickets > 0) {
            BookingSystem.BookTicket(new Passenger(name, BookingId++, numOfTickets), currentFlight);
          } else print("Unable to Book Ticket");
          break;
        case 2:
          print("Enter FlightNumber : ");
          int FlightNumber = getNumberInput();
          if (FlightNumber > AllFlights.size()) {
            print("Invalid Flight Number");
            break;
          }
          Flight selectedFlight = null;
          for (Flight flight : AllFlights) {
            if (flight.FlightNumber == FlightNumber) selectedFlight = flight;
          }
          print("Enter TicketNumber : ");
          int TicketNumber = getNumberInput();
          if (!(selectedFlight.ThisFlightPassengers.containsKey(TicketNumber))) {
            print("Invalid Ticket Number");
            break;
          }
          Passenger cancelRequestedPassenger =
              selectedFlight.ThisFlightPassengers.get(TicketNumber);
          selectedFlight.ThisFlightPassengers.remove(TicketNumber);
          Passenger.passengers.remove(cancelRequestedPassenger.BookingId);
          selectedFlight.AvailableTickets += cancelRequestedPassenger.NumOfTickets;
          selectedFlight.Price -= (cancelRequestedPassenger.NumOfTickets * 200);
          print("Booking Cancelled for " + cancelRequestedPassenger.name);
          break;
        case 3:
          Passenger.passengers.forEach((integer, passenger) -> print(passenger.toString()));
          break;
        case 4:
          print("Exiting...");
          isUserWantedToQuite = true;
          break;
      }
    }
  }

  private static String getStringInput() {
    Scanner input = new Scanner(System.in);
    try {
      return input.next();
    } catch (InputMismatchException e) {
      print("Invalid Input, Try again!");
      return getStringInput();
    }
  }

  private static LinkedList<Flight> getCreatedFlights() {
    LinkedList<Flight> Flights = new LinkedList<>();
    for (int i = 0; i < 2; i++) {
      Flights.add(new Flight());
    }
    return Flights;
  }

  private static int getNumberInput() {
    Scanner input = new Scanner(System.in);
    try {
      return input.nextInt();
    } catch (InputMismatchException e) {
      print("Invalid Input, Try again!");
      return getNumberInput();
    }
  }

  static void print(String s) {
    System.out.println(s);
  }
}
