import java.util.HashMap;

public class Flight {
  static int Id = 1;
  int AvailableTickets, TicketNumber = 1, FlightNumber, Price;
  HashMap<Integer, String> PassengerList;
  HashMap<Integer, Passenger> ThisFlightPassengers;

  public Flight() {
    this.AvailableTickets = 10;
    this.Price = 5000;
    this.FlightNumber = Id++;
    this.PassengerList = new HashMap<>();
    this.ThisFlightPassengers = new HashMap<>();
  }

  @Override
  public String toString() {
    return "Flight Id : "
        + FlightNumber
        + ", Available Seats : "
        + AvailableTickets
        + ", TicketPrice : Rs."
        + Price;
  }
}
