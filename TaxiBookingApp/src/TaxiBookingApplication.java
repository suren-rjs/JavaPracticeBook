/*
 *===================================================================================================
 *
 * No. of taxies (Assume 4)
 * 6 Points A B C D E F -> Each have 15Km between 2
 * one point to another it takes 60 mins
 * first 5km -> Rs.100 , then 10 for every Km
 * Time: Hrs (for Simplicity)
 * All taxies are initiated at A
 * When customer book taxi, free taxi will be allocated
 * two free taxies are same point -> one with lower earning will be allocated
 * Taxi charges only from customer pickup point to drop point
 * if no taxi available then booking rejected
 *________________________________________________
 *
 * Taxi :
 * TaxiNumber :
 * CurrentLocation :
 * IsBooked
 * TotalEarnings :
 * FreeTime :
 *________________________________________________
 *
 * BookingProcess:
 * DistanceBetweenTaxiAndCustomer -> ToFindNearestTaxi
 * DistanceBetweenPickupAndDrop -> ToCalculateFee
 * NextFreeTime -> ForNextBooking
 * NextPickupPoint -> ToAssignNextPickUpPoint
 *________________________________________________
 * (A-0)-----------(B-0)
 *  1---------------2
 * Check Taxi availability time and taxi must reach before their pickup time
 *
 *===================================================================================================
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingApplication {
  static int customerId = 1;

  public static void main(String[] args) {
    System.out.println(
        "================================\n"
            + "=== Taxi Booking Application ===\n"
            + "================================\n");

    Scanner input = new Scanner(System.in);
    boolean userWantsToContinue = true;
    //    Create No of Taxies
    List<Taxi> allTaxies = createTaxiList();

    while (userWantsToContinue) {
      System.out.println(
          "1 -> Book Taxi\n2 -> Show Taxi Details\n3 -> Exit Application\nEnter Choice :");
      int userChoice = input.nextInt();
      switch (userChoice) {
        case 1:
          System.out.println("\nService Available Locations = A, B, C, D, E, F\nPickUp Point = ");
          char pickUpLocation = input.next().toUpperCase().charAt(0);
          System.out.println("\nDrop Point = ");
          char dropLocation = input.next().toUpperCase().charAt(0);
          System.out.println("\nPickUp Time = ");
          int pickUpTime = input.nextInt();
          List<Taxi> FreeTaxies = getAllFreeTaxies(pickUpTime, pickUpLocation, allTaxies);
          if (FreeTaxies.size() == 0) {
            System.out.println("Booking Not Available!");
            break;
          }
          BookTaxi.BookNewTaxi(customerId++, pickUpLocation, dropLocation, pickUpTime, FreeTaxies);
          break;
        case 2:
          for (Taxi taxi : allTaxies) {
            BookTaxi.ShowTaxiDetails(taxi);
          }
          break;
        case 3:
          userWantsToContinue = false;
          break;
        default:
          break;
      }
    }
  }

  private static List<Taxi> getAllFreeTaxies(
      int PickUpTime, char PickUpLocation, List<Taxi> allTaxies) {
    List<Taxi> availableFreeTaxies = new ArrayList<>();
    for (Taxi currentTaxi : allTaxies) {
      if (currentTaxi.FreeTime <= PickUpTime
          && Math.abs((currentTaxi.CurrentLocation - '0') - (PickUpLocation - '0'))
              <= PickUpTime - currentTaxi.FreeTime) {
        availableFreeTaxies.add(currentTaxi);
      }
    }
    availableFreeTaxies.sort(Comparator.comparingInt(a -> a.TotalEarnings));
    return availableFreeTaxies;
  }

  private static List<Taxi> createTaxiList() {
    List<Taxi> createdTaxiList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      createdTaxiList.add(new Taxi());
    }
    return createdTaxiList;
  }
}
