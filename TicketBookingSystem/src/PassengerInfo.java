public class PassengerInfo {
    static int id = 1;
    String name;
    int age;
    String preferredBerth;
    int seatNumber = -1;
    int userId;
    String allotedBerth;

    public PassengerInfo(String name, int age, String preferredBerth){
        this.name = name;
        this.age = age;
        this.userId = id++;
        this.preferredBerth = preferredBerth;
    }
}
