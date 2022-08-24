class RunWay {
  String name;
  int time;
  boolean status;

  RunWay(String name, int time, boolean status) {
    this.name = name;
    this.time = time;
    this.status = status;
  }

  @Override
  public String toString() {
    return name + " is " + (status ? "free" : "busy");
  }
}
