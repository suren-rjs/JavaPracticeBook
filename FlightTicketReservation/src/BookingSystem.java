public class BookingSystem {
  public static void BookTicket(Passenger passenger, Flight selectedFlight) {
    Passenger.passengers.put(passenger.BookingId, passenger);
    selectedFlight.AvailableTickets -= passenger.NumOfTickets;
    String passengerDetail =
        "Booking-Id : "
            + passenger.BookingId
            + ", Ticket Number = "
            + selectedFlight.TicketNumber
            + ", Name : "
            + passenger.name
            + ", Booked Tickets : "
            + passenger.NumOfTickets
            + ", Ticket Price : "
            + selectedFlight.Price * passenger.NumOfTickets;
    passenger.PriceCost = selectedFlight.Price * passenger.NumOfTickets;
    passenger.flightNumber = selectedFlight.FlightNumber;
    passenger.ticketNumber = selectedFlight.TicketNumber;
    selectedFlight.PassengerList.put(passenger.BookingId, passengerDetail);
    selectedFlight.ThisFlightPassengers.put(selectedFlight.TicketNumber++, passenger);
    selectedFlight.Price += (passenger.NumOfTickets * 200);
    Main.print("--> Booking Success!");
    Main.print(passengerDetail);
  }
}
