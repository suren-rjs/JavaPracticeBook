import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PatternPrinting {
  public static void main(String[] args) {
    mergeTwoGivenSortedArray();
    convertNumToChar();
    printCharacterAndItsLength();
    printCrossMatrix();
    findRepeatedNumCountInGivenArray();
    wordPattern();
    firstMaxMin();
    oddPositionInDescendingOrder();
    findFirstAccusedIndexOfSecondStringInFirstString();
    spiralPattern();
    mergeTwoArraysWithoutDuplicates();
    printNumberInWords();
  }

  private static void printNumberInWords() {
    int number = 199;
    String[] one = {
      "Ten", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    };
    String[] two = {
      "Twenty",
      "Eleven",
      "Twelve",
      "Thirteen",
      "Fourteen",
      "Fifteen",
      "Sixteen",
      "Seventeen",
      "Eighteen",
      "Nineteen"
    };
    String[] three = {
      "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    if (number == 0) System.out.print("Zero");
    else if (number < 11) {
      System.out.print(one[number % 10]);
    } else if (number < 21) {
      System.out.print(two[number % 10]);
    } else if (number < 1000) {
      int temp = number, count = 0;
      while (temp != 0) {
        count++;
        temp /= 10;
      }
      if (count == 2) {
        System.out.print(three[number / 10] + " " + one[number % 10]);
      } else if (count == 3) {
        System.out.print(one[number / 100] + " Hundred and ");
        number = number - (number / 100) * 100;
        System.out.print(three[number / 10] + " " + one[number % 10]);
      }
    }
  }

  private static void mergeTwoArraysWithoutDuplicates() {
    int[] array1 = {2, 4, 5, 6, 7, 9, 10, 13}, array2 = {2, 3, 4, 5, 6, 7, 8, 9, 11, 15};
    int array1Length = array1.length;
    int array2Length = array2.length;
    int maxInt = Math.max(array1Length, array2Length);
    HashSet<Integer> numArray = new HashSet<>();
    for (int i = 0; i < maxInt; i++) {
      if (i < array1Length) numArray.add(array1[i]);
      if (i < array2Length) numArray.add(array2[i]);
    }
    System.out.print(numArray);
  }

  private static void findFirstAccusedIndexOfSecondStringInFirstString() {
    String str1 = "test123string", str2 = "1234";
    if (str1.contains(str2)) {
      System.out.println(str1.indexOf(str2.charAt(0)));
    } else System.out.println("-1");
  }

  private static void oddPositionInDescendingOrder() {
    int[] input = {13, 2, 4, 15, 12, 10, 5};
    int[] oddPosition = new int[(input.length / 2) + 1];
    int[] evenPosition = new int[(input.length / 2)];
    int odd = 0, even = 0, i = 0;
    while (i < input.length) {
      if (i % 2 == 0) oddPosition[odd++] = input[i++];
      else evenPosition[even++] = input[i++];
    }
    descendingSort(oddPosition);
    insertionSort(evenPosition);
    i = 0;
    while (i < oddPosition.length) {
      System.out.print(
          i >= evenPosition.length
              ? oddPosition[i++]
              : oddPosition[i] + ", " + evenPosition[i++] + ", ");
    }
  }

  private static void firstMaxMin() {
    int[] input = {1, 2, 3, 4, 5, 6, 7};
    insertionSort(input);
    //    {7, 1, 6, 2, 5, 3, 4}
    for (int i = 0; i < (input.length / 2) + 1; i++) {
      System.out.print(
          input[input.length - i - 1] == input[i]
              ? input[input.length - i - 1]
              : input[input.length - i - 1] + ", " + input[i] + ", ");
    }
  }

  private static void wordPattern() {
    String input = "PROGRAM";
    for (int i = 0; i < input.length(); i++) {
      for (int j = 0; j < input.length(); j++) {
        System.out.print(i == j || i + j == input.length() - 1 ? input.charAt(j) + " " : "  ");
      }
      System.out.print("\n");
    }
  }

  private static void spiralPattern() {
    int matrix[][] = {
      {1, 2, 3, 4}, {14, 15, 16, 5}, {13, 20, 17, 6}, {12, 19, 18, 7}, {11, 10, 9, 8}
    };

    int rowStart = 0, rowEnd = matrix.length;
    int colStart = 0, colEnd = matrix[0].length;

    while (rowStart < rowEnd && colStart < colEnd) {
      for (int i = colStart; i < colEnd; i++) System.out.print(matrix[rowStart][i] + " ");

      rowStart += 1;
      for (int i = rowStart; i < rowEnd; i++) System.out.print(matrix[i][colEnd - 1] + " ");

      colEnd -= 1;
      for (int i = colEnd - 1; i >= colStart; i--) System.out.print(matrix[rowEnd - 1][i] + " ");

      rowEnd -= 1;
      for (int i = rowEnd - 1; i >= rowStart; i--) System.out.print(matrix[i][colStart] + " ");

      colStart += 1;
    }
  }

  private static void findRepeatedNumCountInGivenArray() {
    int[] input = {2, 3, 4, 2, 2, 5, 5};
    HashMap<Integer, Integer> TraceNumber = new HashMap<>();
    for (int currentInt : input) {
      if (TraceNumber.containsKey(currentInt)) {
        TraceNumber.put(currentInt, TraceNumber.get(currentInt) + 1);
      } else {
        TraceNumber.put(currentInt, 1);
      }
    }
    for (int key : TraceNumber.keySet()) {
      System.out.print(key + "(" + TraceNumber.get(key) + "),");
    }
  }

  private static void printCrossMatrix() {
    int num = 5;
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        System.out.print(
            i == j
                ? (i < 3 ? (num - i) : j + 1) + " "
                : i + j == num - 1 ? (j < 3 ? (num - i) : i + 1) + " " : "  ");
      }
      System.out.print("\n");
    }
  }

  private static void printCharacterAndItsLength() {
    String str =
        "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char Char = str.charAt(i);
      count++;
      char next = i + 1 < str.length() ? str.charAt(i + 1) : (char) -1;
      if (Char != next) {
        System.out.print(Char + "" + count);
        count = 0;
      }
    }
  }

  static void convertNumToChar() {
    String str = "a1b50c10d10e1h100";
    for (int i = 0, k; i < str.length(); i = k + 1) {
      char ch = str.charAt(i);
      int count = str.charAt(++i) - 48, next = i + 1 < str.length() ? str.charAt(i + 1) - 48 : -1;
      k = i;
      while (next > -1 && next < 10 && k + 1 < str.length()) {
        count *= 10;
        count += (str.charAt(++k) - 48);
        if (k + 1 < str.length()) next = str.charAt(k + 1) - 48;
      }
      printCharBaseCount(ch, count);
    }
  }

  static void printCharBaseCount(char ch, int count) {
    for (int j = 0; j < count; j++) {
      System.out.print(ch);
    }
  }

  private static void mergeTwoGivenSortedArray() {
    int[] array1 = {-1, 1, 10, 12, 20}, array2 = {1, 2, 10, 11};
    // out: -1,1,1,2,10,10,11,12,20
    int[] intArray = new int[array1.length + array2.length];
    int count = 0;
    for (int i = 0; i < array1.length; i++) {
      intArray[count++] = array1[i];
      if (i < array2.length) intArray[count++] = array2[i];
    }
    System.out.print(Arrays.toString(insertionSort(intArray)));
  }

  private static int[] insertionSort(int[] intArray) {
    for (int i = 1; i < intArray.length; i++) {
      int previousIndex = i - 1, currentValue = intArray[i];
      while ((previousIndex > -1) && intArray[previousIndex] > currentValue) {
        intArray[previousIndex + 1] = intArray[previousIndex--];
      }
      intArray[previousIndex + 1] = currentValue;
    }
    return intArray;
  }

  private static int[] descendingSort(int[] intArray) {
    for (int i = 1; i < intArray.length; i++) {
      int previousIndex = i - 1, currentValue = intArray[i];
      while ((previousIndex > -1) && intArray[previousIndex] < currentValue) {
        intArray[previousIndex + 1] = intArray[previousIndex--];
      }
      intArray[previousIndex + 1] = currentValue;
    }
    return intArray;
  }
}
