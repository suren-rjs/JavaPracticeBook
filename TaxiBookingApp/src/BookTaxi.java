import java.util.List;

public class BookTaxi {

    public static void BookNewTaxi(
            int customerId,
            char pickUpLocation,
            char dropLocation,
            int pickUpTime,
            List<Taxi> freeTaxies) {
        int min = 999;
        int DistanceBetweenTaxiAndCustomer;
        int DistanceBetweenPickupAndDrop;
        int dropTime = 0;
        int tripEarning = 0;
        String tripDetails = null;
        Taxi BookedTaxi = null;

        for (Taxi currentTaxi : freeTaxies) {
            DistanceBetweenTaxiAndCustomer =
                    Math.abs((currentTaxi.CurrentLocation - '0') - (pickUpLocation - '0')) * 15;
            DistanceBetweenPickupAndDrop = Math.abs((dropLocation - '0') - (pickUpLocation - '0')) * 15;
            if (DistanceBetweenTaxiAndCustomer < min) {
                BookedTaxi = currentTaxi;
                dropTime = pickUpTime + DistanceBetweenPickupAndDrop / 15;
                tripEarning = ((DistanceBetweenPickupAndDrop - 5) * 10 + 100);
                tripDetails =
                        customerId
                                + "            "
                                + customerId
                                + "            "
                                + pickUpLocation
                                + "            "
                                + dropLocation
                                + "            "
                                + pickUpTime
                                + "            "
                                + dropTime
                                + "            "
                                + tripEarning;
                min = DistanceBetweenTaxiAndCustomer;
            }
        }
        assert BookedTaxi != null;
        BookedTaxi.BookingId = customerId;
        BookedTaxi.CurrentLocation = dropLocation;
        BookedTaxi.TotalEarnings += tripEarning;
        BookedTaxi.FreeTime = dropTime;
        BookedTaxi.TaxiDetails.add(tripDetails);
        System.out.println("Taxi -> " + BookedTaxi.TaxiNumber + " Booked !");
    }

    public static void ShowTaxiDetails(Taxi taxi) {
        System.out.println(
                "BookingId  CustomerId     From         To      PickUpTime     DropTime     TripEarning\n");
        for (String detail : taxi.TaxiDetails) System.out.println(detail);
        System.out.println(
                "Taxi " + taxi.TaxiNumber + " : Earning -> Rs. " + taxi.TotalEarnings);
        System.out.println("==================================================================================");
    }
}
