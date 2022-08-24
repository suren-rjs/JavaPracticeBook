class Request extends Thread {
  String requestedFlight; // flight name
  int flightWeight; // flight weight
  int coolTime;

  String type;
  RunWay runWay;

  public Request(String aName, int weightA, String cho, int compTime, RunWay rw) {
    this.requestedFlight = aName;
    this.flightWeight = weightA;
    this.runWay = rw;
    this.coolTime = compTime;
    this.type = cho;
  }

  public void run() {
    runWay.status = false;
    try {
      System.out.println(
          "---------------------------------------------------------------------------------");
      System.out.println(
          type + " Approved for " + requestedFlight + " with " + flightWeight + " tons of weight in " + runWay.name);
      System.out.println("Touch down will happen in 15 sec");
      System.out.println("the plane will stop after " + coolTime + " sec of touch down");
      System.out.println(runWay.name + " will be ready for next request in " + coolTime + " sec");
      System.out.println(
          "---------------------------------------------------------------------------------");
      Thread.sleep(1000L * coolTime);
      runWay.status = true;
    } catch (Exception ignored) {
    }
  }
}
