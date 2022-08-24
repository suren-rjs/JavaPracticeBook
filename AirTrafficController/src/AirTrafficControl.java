import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class AirTrafficControl extends Thread {
  String flightName;
  int flightWeight;
  int compTime;
  int ch;
  String cho = "";
  ArrayList<Flight> flights;
  ArrayList<RunWay> runWays;
  Scanner sc = new Scanner(System.in);

  AirTrafficControl() {
    Flight atr = new Flight("atr", 12, 30); // name,max weight,time to halt
    Flight airbus = new Flight("airbus", 20, 40);
    Flight boeing = new Flight("boeing", 40, 50);
    Flight cargo = new Flight("cargo", 100, 60);
    flights = new ArrayList<>(Arrays.asList(atr, airbus, boeing, cargo));

    RunWay r1 = new RunWay("run way one", 40, true);
    RunWay r2 = new RunWay("run way two", 60, true);
    RunWay r3 = new RunWay("run way three", 80, true);
    RunWay r4 = new RunWay("run way four", 90, true);
    runWays = new ArrayList<>(Arrays.asList(r1, r2, r3, r4));
  }

  public static void main(String[] args) {
    AirTrafficControl atc = new AirTrafficControl();
    while (true) {
      atc.getChoice();
    }
  }

  public void getChoice() {
    System.out.println(
        "1.Take off\n2.Landing\n3.Emergency Landing\n4.show RunWays\n5.Exit\nEnter Your Choice :");
    ch = sc.nextInt();
    switch (ch) {
      case 1:
        cho = "Take Off";
        getAndAllocate();
        break;
      case 2:
        cho = "Landing";
        getAndAllocate();
        break;
      case 3:
        cho = "Emergency Landing";
        getAndAllocate();
        break;
      case 4:
        runWays.forEach(System.out::println);
        break;
      case 5:
        System.out.println("Exiting...");
        System.exit(0);
    }
  }

  private void getAndAllocate() {
    System.out.println("Enter name of flight:");
    flightName = sc.next();
    Flight getFlight =
        flights.stream().filter(f -> f.flightName.equals(flightName)).findFirst().orElse(null);
    if (getFlight != null) {
      if (!getFlight.isRunwayAllocated){
        System.out.println("Enter weight of flight(in tons):");
        flightWeight = sc.nextInt();
        compTime = getFlight.computeTime(flightWeight);
        checkAndAssignRunWay(getFlight);
      } else System.out.println("--> Runway already allocated for this flight\n");
    } else System.out.println("Flight doesn't authorised");
  }

  public void checkAndAssignRunWay(Flight selectedFlight) {
    RunWay selectedRunWay =
        runWays.stream().filter(r -> compTime <= r.time && r.status).findFirst().orElse(null);
    if (selectedRunWay != null) {
      Request r = new Request(flightName, flightWeight, cho, compTime, selectedRunWay, selectedFlight);
      r.start();
      try {
        Thread.sleep(500);
      } catch (Exception ignored) {
      }
    } else System.out.println("you have to wait");
  }
}
