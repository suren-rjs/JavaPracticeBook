import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * ===============================================================================
 *
 * <p>No. of taxis (Assume 4) 6 Points A B C D E F -> Each have 15Km between 2 one point to another
 * it takes 60 min first 5km -> Rs.100 , then 10 for every Km Time: Hrs (for Simplicity)
 *
 * <p>All taxis are initiated at A When customer book taxi, free taxi will be allocated two free
 * taxis are same point -> one with lower earning will be allocated Taxi charges only from customer
 * pickup point to drop point
 *
 * <p>if no taxi available then booking rejected
 *
 * <p>________________________________________________
 *
 * <p>Taxi : TaxiNumber : CurrentLocation : IsBooked TotalEarnings : FreeTime :
 * ________________________________________________
 *
 * <p>BookingProcess: DistanceBetweenTaxiAndCustomer -> ToFindNearestTaxi
 * DistanceBetweenPickupAndDrop -> ToCalculateFee NextFreeTime -> ForNextBooking NextPickupPoint ->
 * ToAssignNextPickUpPoint
 *
 * <p>________________________________________________
 *
 * <p>(A-0)-----------(B-0) 1---------------2
 *
 * <p>Check Taxi availability time and taxi must reach before their pickup time
 *
 * <p>===============================================================================
 */
public class TaxiBookingApplication {
  static int customerId = 1;

  public static void main(String[] args) {
    System.out.println(
        "================================\n"
            + "=== Taxi Booking Application ===\n"
            + "================================\n");

    Scanner input = new Scanner(System.in);
    boolean userWantsToContinue = true;
    //    Create No of Taxis
    List<Taxi> allTaxis =
        Arrays.stream(new int[4]).mapToObj(i -> new Taxi()).collect(Collectors.toList());

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
          List<Taxi> FreeTaxis = getAllFreeTaxis(pickUpTime, pickUpLocation, allTaxis);
          if (FreeTaxis.size() == 0) {
            System.out.println("Booking Not Available!");
            break;
          }
          BookTaxi.BookNewTaxi(customerId++, pickUpLocation, dropLocation, pickUpTime, FreeTaxis);
          break;
        case 2:
          for (Taxi taxi : allTaxis) {
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

  private static List<Taxi> getAllFreeTaxis(
      int PickUpTime, char PickUpLocation, List<Taxi> allTaxis) {
    return allTaxis.stream()
        .filter(
            taxi ->
                taxi.FreeTime <= PickUpTime
                    && (Math.abs(taxi.CurrentLocation - '0') - (PickUpLocation - '0')
                        <= PickUpTime - taxi.FreeTime))
        .sorted(Comparator.comparing(taxi -> taxi.TotalEarnings))
        .collect(Collectors.toList());
  }
}
