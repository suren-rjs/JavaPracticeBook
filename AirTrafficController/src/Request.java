class Request extends Thread {
  String requestedFlight; // flight name
  int flightWeight; // flight weight
  int coolTime;

  String requestType;
  RunWay runWay;
  Flight allottedFlight;

  public Request(String flightName, int weight, String requestType, int coolTime, RunWay runWay, Flight selectedFlight) {
    this.requestedFlight = flightName;
    this.flightWeight = weight;
    this.runWay = runWay;
    this.coolTime = coolTime;
    this.requestType = requestType;
    this.allottedFlight = selectedFlight;
  }

  public void run() {
    runWay.status = false;
    runWay.allottedFlight = allottedFlight;
    allottedFlight.isRunwayAllocated = true;
    try {
      System.out.println(
          "---------------------------------------------------------------------------------");
      System.out.println(
          requestType + " Approved for " + requestedFlight + " with " + flightWeight + " tons of weight in " + runWay.name);
      System.out.println("Touch down will happen in 15 sec");
      System.out.println("the plane will stop after " + coolTime + " sec of touch down");
      System.out.println(runWay.name + " will be ready for next request in " + coolTime + " sec");
      System.out.println(
          "---------------------------------------------------------------------------------");
      Thread.sleep(1000L * coolTime);
      runWay.status = true;
      runWay.allottedFlight = null;
      allottedFlight.isRunwayAllocated = false;
    } catch (Exception ignored) {
    }
  }
}
