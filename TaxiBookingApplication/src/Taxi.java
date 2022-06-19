import java.util.ArrayList;
import java.util.List;

public class Taxi {
    static int id = 1;
    int TaxiNumber;
    int BookingId;
    boolean IsBooked = false;
    char CurrentLocation;
    int FreeTime;
    int TotalEarnings;
    List<String> TaxiDetails;

    public Taxi(){
        this.TaxiNumber = id++;
        this.CurrentLocation = 'A';
        this.FreeTime = 6;
        this.IsBooked = false;
        this.TotalEarnings = 0;
        this.BookingId = 0;
        this.TaxiDetails = new ArrayList<>();
    }
}