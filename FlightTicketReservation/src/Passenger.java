import java.util.HashMap;

public class Passenger {
  static HashMap<Integer, Passenger> passengers = new HashMap<>();
  String name;
  int BookingId, NumOfTickets, PriceCost, flightNumber, ticketNumber;

  public Passenger(String name, int bookingId, int numOfTickets) {
    this.name = name;
    BookingId = bookingId;
    NumOfTickets = numOfTickets;
  }

  @Override
  public String toString() {
    return "Name : "
        + name
        + ", Booked Tickets : "
        + NumOfTickets
        + ", Flight Number : "
        + flightNumber
        + ", Ticket Number :"
        + ticketNumber
        + ", Ticket Cost : "
        + PriceCost;
  }
}
