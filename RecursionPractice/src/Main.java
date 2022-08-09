public class Main {
  public static void main(String[] args) {
    //    System.out.println(factorial(3));
    //    for (int i = 0; i < 10; i++) {
    //      System.out.print(findFibonacciSeries(i) + " ");
    //    }
    //    System.out.println(reverseString("Hello"));
    //    System.out.println(reverseNumber(456));
    int[] array = {1, 2, 3, 4, 5};
    //    BinarySearch(array, 10);
    //    printAllPossibleCombinations(array, 3);
  }

  static void combinationUtil(
      int[] arr,
      int arrayLength,
      int numberOfRegs,
      int currentIndex,
      int[] data,
      int startingIndex) {
    if (currentIndex == numberOfRegs) {
      for (int j = 0; j < numberOfRegs; j++) System.out.print(data[j] + " ");
      System.out.print("\n");
      return;
    }

    if (startingIndex >= arrayLength) return;

    data[currentIndex] = arr[startingIndex];
    combinationUtil(arr, arrayLength, numberOfRegs, currentIndex + 1, data, startingIndex + 1);
    combinationUtil(arr, arrayLength, numberOfRegs, currentIndex, data, startingIndex + 1);
  }

  static void printAllPossibleCombinations(int[] arr, int numberOfIndex) {
    int[] data = new int[numberOfIndex];

    combinationUtil(arr, arr.length, numberOfIndex, 0, data, 0);
  }

  private static void BinarySearch(int[] array, int number) {
    int firstData = 0;
    int lastData = array.length - 1;
    int i = 0;
    while (firstData <= lastData) {
      System.out.println(i++);
      int middleData = (firstData + lastData) / 2;
      if (array[middleData] == number) {
        System.out.println(number + " found at " + middleData);
        return;
      } else if (array[middleData] < number) {
        firstData = middleData + 1;
      } else if (array[middleData] > number) {
        lastData = middleData - 1;
      }
    }
  }

  private static int reverseNumber(int integer) {
    int number = 0;
    while (integer != 0) {
      number *= 10;
      number += (integer % 10);
      integer /= 10;
    }
    return number;
  }

  private static String reverseString(String text) {
    String reverseString = "";
    int StringLength = text.length();
    while (StringLength > 0) reverseString += text.charAt(--StringLength);
    return reverseString;
  }

  private static int findFibonacciSeries(int number) {
    return (number == 1 || number == 2)
        ? 1
        : (number == 0) ? 0 : findFibonacciSeries(number - 1) + findFibonacciSeries(number - 2);
  }

  private static int factorial(int number) {
    if (number == 0 || number == 1) return 1;
    return number * factorial(number - 1);
  }
}
