import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("==========================================");
        System.out.println("=========  Ticket Booking System  ========");
        System.out.println("==========================================");

        boolean isUserWantToContinue = true;
        Scanner input = new Scanner(System.in);
        while (isUserWantToContinue){
            System.out.println("1) Book New Ticket\n" +
                    "2) Cancel Ticket\n" +
                    "3) Check Ticket Availability\n" +
                    "4) Show Passengers list\n" +
                    "5) Exit\n" +
                    "Enter Choice :");
            int userChoice = input.nextInt();
            switch (userChoice){
                case 1:
                    System.out.println("\nEnter Passenger Name, Age, PreferredBerth (U/M/L)");
                    String name = input.next();
                    int age = input.nextInt();
                    String PreferredBerth =  input.next();
                    PassengerInfo passenger = new PassengerInfo(name, age, PreferredBerth.toUpperCase());
                    BookingManagementSystem.BookNewTicket(passenger);
                    break;
                case 2:
                    System.out.println("\nEnter User Id : ");
                    int userId = input.nextInt();
                    BookingManagementSystem.CancelBookedTicket(userId);
                    break;
                case 3:
                    BookingManagementSystem.ShowAvailability();
                    break;
                case 4:
                    BookingManagementSystem.ShowPassengerList();
                    break;
                case 5:
                    isUserWantToContinue = false;
                    break;
                default:
                    break;
            }
        }
    }
}