class RunWay {
  String name;
  int time;
  boolean status;

  Flight allottedFlight;

  RunWay(String name, int time, boolean status) {
    this.name = name;
    this.time = time;
    this.status = status;
    this.allottedFlight = null;
  }

  @Override
  public String toString() {
    return name + " is " + (status ? "free" : "busy");
  }
}
