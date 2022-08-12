import java.util.Arrays;

public class PatternPrinting {
  public static void main(String[] args) {
    mergeTwoGivenSortedArray();
    convertNumToChar();
    printCharacterAndItsLength();
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
    int[] newArray = new int[array1.length + array2.length];
    int newArrIndex = 0;
    for (int i = 0; i < array1.length; i++) {
      newArray[newArrIndex++] = array1[i];
      if (i < array2.length) newArray[newArrIndex++] = array2[i];
    }
    System.out.println(Arrays.toString(insertionSor(newArray)));
  }

  private static int[] insertionSor(int[] intArray) {
    for (int i = 1; i < intArray.length; i++) {
      int previousIndex = i - 1;
      int currentValue = intArray[i];
      while ((previousIndex > 0) && intArray[previousIndex] > currentValue)
        intArray[previousIndex + 1] = intArray[previousIndex--];
      intArray[previousIndex + 1] = currentValue;
    }
    return intArray;
  }
}
