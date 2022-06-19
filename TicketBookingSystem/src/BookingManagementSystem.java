import java.util.*;

public class BookingManagementSystem {
    private static int availableLowerBerth = 1;
    private static int availableMiddleBerth = 1;
    private static int availableUpperBerth = 1;

    private static int availableRAC = 1;
    private static int availableWL = 1;

    static List<Integer> LowerBerthSeats = new ArrayList<>(Arrays.asList(1));
    static List<Integer> MiddleBerthSeats = new ArrayList<>(Arrays.asList(1));
    static List<Integer> UpperBerthSeats = new ArrayList<>(Arrays.asList(1));
    static List<Integer> RACSeats = new ArrayList<>(Arrays.asList(1));
    static List<Integer> WLSeats = new ArrayList<>(Arrays.asList(1));
    static List<Integer> BookedTickets = new ArrayList<>();

    static LinkedList<Integer> RACQueue = new LinkedList<>();
    static LinkedList<Integer> WLQueue = new LinkedList<>();

    static Map<Integer, PassengerInfo> PassengerCollection = new HashMap<>();

    private static void ToBookTicket(PassengerInfo passenger) {
        if (passenger.preferredBerth.equals("U")) {
            BookTicket(passenger, passenger.preferredBerth, UpperBerthSeats.get(0));
            availableUpperBerth--;
        } else if (passenger.preferredBerth.equals("M")) {
            BookTicket(passenger, passenger.preferredBerth, MiddleBerthSeats.get(0));
            availableMiddleBerth--;
        } else if (passenger.preferredBerth.equals("L")) {
            BookTicket(passenger, passenger.preferredBerth, LowerBerthSeats.get(0));
            availableLowerBerth--;
        }
    }

    private static void BookTicket(PassengerInfo passenger, String preferredBerth, Integer seatNumber) {
        if (preferredBerth.equals("U") || preferredBerth.equals("M") || preferredBerth.equals("L")) {
            BookedTickets.add(passenger.userId);
            passenger.allotedBerth = preferredBerth;
            passenger.seatNumber = seatNumber;
        } else if (preferredBerth.equals("RAC")) {
            passenger.allotedBerth = preferredBerth;
            RACQueue.add(Integer.valueOf(passenger.userId));
        } else if (preferredBerth.equals("WL")) {
            passenger.allotedBerth = preferredBerth;
            WLQueue.add(Integer.valueOf(passenger.userId));
        }
        PassengerCollection.put(passenger.userId, passenger);
    }

    public static void BookNewTicket(PassengerInfo Passenger) {
        String userPreferences = Passenger.preferredBerth;
        if (availableWL > 0) {
            if (userPreferences.equals("L") && availableLowerBerth > 0
                    || userPreferences.equals("M") && availableMiddleBerth > 0
                    || userPreferences.equals("U") && availableUpperBerth > 0) {
                System.out.println("\n=====================================================\nPreferred Berth Available");
                ToBookTicket(Passenger);
            } else if (availableLowerBerth > 0) {
                System.out.println("\nLowerBerth Available, LowerBerth Given!");
                BookTicket(Passenger, "L", LowerBerthSeats.get(0));
                LowerBerthSeats.remove(0);
                availableLowerBerth--;
            } else if (availableMiddleBerth > 0) {
                System.out.println("\nMiddleBerth Available, MiddleBerth Given!");
                BookTicket(Passenger, "M", MiddleBerthSeats.get(0));
                MiddleBerthSeats.remove(0);
                availableMiddleBerth--;
            } else if (availableUpperBerth > 0) {
                System.out.println("\nUpperBerth Available, UpperBerth Given!");
                availableUpperBerth--;
                BookTicket(Passenger, "U", UpperBerthSeats.get(0));
                UpperBerthSeats.remove(0);
            } else if (availableRAC > 0) {
                System.out.println("\nRAC Available, RAC Given!");
                BookTicket(Passenger, "RAC", RACSeats.get(0));
                RACSeats.remove(0);
                availableRAC--;
            } else {
                System.out.println("\nYour Status is WL!");
                BookTicket(Passenger, "WL", WLSeats.get(0));
                WLSeats.remove(0);
                availableWL--;
            }
            System.out.println("\nBooking Success for " + Passenger.name + ", User Id is " + Passenger.userId + "\n=====================================================");
        } else System.out.println("\nNo Tickets Available");
    }

    public static void CancelBookedTicket(int userId) {
        if (BookedTickets.contains(Integer.valueOf(userId))) {
            PassengerInfo CancelPassenger = PassengerCollection.get(Integer.valueOf(userId));
            PassengerCollection.remove(Integer.valueOf(userId));
            BookedTickets.remove(Integer.valueOf(userId));
            System.out.println("\nBooking Cancelled for " + CancelPassenger.name);
            String availableBerth = CancelPassenger.allotedBerth;
            int availableSeatNumber = CancelPassenger.seatNumber;
            if (availableBerth.equals("U")) {
                availableUpperBerth++;
                UpperBerthSeats.add(availableSeatNumber);
            } else if (availableBerth.equals("M")) {
                availableMiddleBerth++;
                MiddleBerthSeats.add(availableSeatNumber);
            } else if (availableBerth.equals("L")) {
                availableLowerBerth++;
                LowerBerthSeats.add(availableSeatNumber);
            }
            if (RACQueue.size() > 0) {
                PassengerInfo RACPassenger = PassengerCollection.get(RACQueue.poll());
                RACQueue.remove(Integer.valueOf(RACPassenger.userId));
                RACSeats.remove(Integer.valueOf(RACPassenger.seatNumber));
                availableRAC++;
                if (WLQueue.size() > 0) {
                    PassengerInfo WLPassenger = PassengerCollection.get(WLQueue.poll());
                    WLQueue.remove(Integer.valueOf(WLPassenger.userId));
                    WLSeats.remove(Integer.valueOf(WLPassenger.seatNumber));
                    availableWL++;
                    availableRAC--;
                    BookTicket(WLPassenger, "RAC", RACPassenger.seatNumber);
                }
                BookNewTicket(RACPassenger);
            }

        } else System.out.println("\nUser Not Exist!");
    }

    public static void ShowAvailability() {
        System.out.println("\n======== Available Tickets ========\n" +
                availableLowerBerth + " LowerBerth Available\n" +
                availableMiddleBerth + " MiddleBerth Available\n" +
                availableUpperBerth + " UpperBerth Available\n" +
                availableRAC + " RAC Available\n" +
                availableWL + " WL Available\n" +
                "================================\n");
    }

    public static void ShowPassengerList() {
        for (PassengerInfo Passenger : PassengerCollection.values()) {
            System.out.println("Name : " + Passenger.name +
                    "\nAge : " + Passenger.age + "\nUserId : " + Passenger.userId + "\nTicketStatus : " + (Passenger.seatNumber != -1 ? Passenger.allotedBerth + Passenger.seatNumber : "Not Confirmed"));
            System.out.println("================================================");
        }
    }
}
