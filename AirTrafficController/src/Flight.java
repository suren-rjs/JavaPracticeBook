class Flight {
  String flightName;
  int maxWeight;
  int allottedTime;

  Flight(String fName, int maxWeight, int timeHalt) {
    this.flightName = fName;
    this.maxWeight = maxWeight;
    this.allottedTime = timeHalt;
  }

  int computeTime(int weight) {
    int weightPercentage = (weight / maxWeight) * 100; // to get percentage of weight
    int compileTime;
    compileTime =
        weightPercentage >= 75
            ? allottedTime
            : (weightPercentage > 50 && weightPercentage < 75)
                ? allottedTime - (allottedTime * (10 / 100))
                : allottedTime - (allottedTime * (20 / 100));

    return compileTime + 10; // always add 10 sec extra...
  }
}
