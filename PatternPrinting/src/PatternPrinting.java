import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PatternPrinting {
    public static void main(String[] args) {
        int[] array = new int[]{8, 0, 4, 0, 2, 0, 1, 3, 55, 5001};
//        mergeTwoGivenSortedArray();
//        convertNumToChar();
//        printCharacterAndItsLength();
//        printCrossMatrix();
//        findRepeatedNumCountInGivenArray();
//        wordPattern();
//        firstMaxMin();
//        oddPositionInDescendingOrder();
//        findFirstAccusedIndexOfSecondStringInFirstString();
//        spiralPattern();
//        mergeTwoArraysWithoutDuplicates();
//        printNumberInWords();
//        slidingIndex();
//        patternPrinting();
//        System.out.println(Arrays.toString(placeZerosLast(array)));
//        HollowPrinting();
    }

    private static void HollowPrinting() {
        int num = 5, len = num * 2 - 1, start = 0;
        int[][] matrix = new int[len][len];
        while (num != 0) {
            for (int i = start; i < len; i++) {
                for (int j = start; j < len; j++) {
                    if (i == start || j == start || i == len - 1 || j == len - 1) matrix[i][j] = num;
                }
            }
            start++;
            len--;
            num--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    private static int[] placeZerosLast(int[] numbs) {
        int[] newArr = new int[numbs.length];
        int count = 0;
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] != 0) newArr[count++] = numbs[i];
        }
        return newArr;
    }

    private static void patternPrinting() {
        int num = 5;
        String start = "1";
        System.out.println(start);
        for (int i = 0; i < num - 1; i++) {
            String newString = "";
            for (int j = 0; j < start.length(); j++) {
                int count = 1;
                while (j + 1 < start.length() && start.charAt(j) == start.charAt(j + 1)) {
                    count++;
                    j++;
                }
                newString = newString + count + start.charAt(j);
            }
            System.out.println(start = newString);
        }
    }

    private static void slidingIndex() {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//        3 3 4 5 5 5 6
        int k = 3;
        for (int i = 0; i <= arr.length - k; i++) {
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                int next = arr[i + j];
                if (next > max) max = next;
            }
            System.out.print(max + " ");
        }
    }

    private static void printNumberInWords() {
        int number = 199;
        String[] one = {"Ten", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",};
        String[] two = {"Twenty", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] three = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (number == 0) System.out.print("Zero");
        else if (number < 11) System.out.print(one[number % 10]);
        else if (number < 21) System.out.print(two[number % 10]);
        else if (number < 1000) {
            int count = 0, temp = number;
            while (temp != 0) {
                count++;
                temp /= 10;
            }
            if (count == 2) {
                System.out.print(three[number / 10] + " " + one[number % 10]);
            } else if (count == 3) {
                System.out.print(one[number / 100] + " hundred and ");
                number = number - ((number / 100) * 100);
                System.out.print(three[number / 10] + " " + one[number % 10]);
            }
        }
    }

    private static void mergeTwoArraysWithoutDuplicates() {
        int[] array1 = {2, 4, 5, 6, 7, 9, 10, 13}, array2 = {2, 3, 4, 5, 6, 7, 8, 9, 11, 15};
        HashSet<Integer> newSet = new HashSet<>();
        for (int i = 0; i < Math.max(array1.length, array2.length); i++) {
            if (i < array1.length) newSet.add(array1[i]);
            if (i < array2.length) newSet.add(array2[i]);
        }
        System.out.print(newSet);
    }

    private static void findFirstAccusedIndexOfSecondStringInFirstString() {
        String str1 = "te1234st123string", str2 = "st1";
        if (!str1.contains(str2)) {
            System.out.println(false);
            return;
        }
        int index = str1.indexOf(str2.charAt(0));
        System.out.print(findSubSeqIndex(str1, str2, index));
    }

    private static boolean findSubSeqIndex(String str1, String str2, int index) {
        String newString = str1.substring(index, index + (str2.length()));
        if (!newString.equals(str2)) {
            str1 = str1.replaceFirst(newString.substring(0, 1), " ");
            if (!str1.contains(str2)) return false;
            index = str1.indexOf(str2.charAt(0));
            findSubSeqIndex(str1, str2, index);
        }
        return true;
    }

    private static void oddPositionInDescendingOrder() {
        int[] input = {13, 2, 4, 15, 12, 10, 5};
//        13, 2, 12, 10, 5, 15, 4
//        13 12 5 4
//        2 10 15
        int[] odd = new int[(input.length / 2) + 1], even = new int[input.length / 2];
        int Odd = 0, Even = 0, count = 0;
        for (int i = 0; i <= input.length / 2; i++) {
            if (i < odd.length) odd[Odd++] = input[count++];
            if (i < even.length) even[Even++] = input[count++];
        }
        descendingSort(odd);
        insertionSort(even, 1);
        count = 0;
        for (int i = 0; i < Math.max(odd.length, even.length); i++) {
            if (i < odd.length) input[count++] = odd[i];
            if (i < even.length) input[count++] = even[i];
        }
        System.out.println(Arrays.toString(input));
    }

    private static void firstMaxMin() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        insertionSort(input, 1);
        //    {7, 1, 6, 2, 5, 3, 4}
        for (int i = 0; i < (input.length / 2) + 1; i++) {
            System.out.print(input[input.length - i - 1] == input[i] ? input[input.length - i - 1] : input[input.length - i - 1] + ", " + input[i] + ", ");
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
        int[][] matrix = {{1, 2, 3, 4}, {14, 15, 16, 5}, {13, 20, 17, 6}, {12, 19, 18, 7}, {11, 10, 9, 8}};
        int rowStart = 0, rowEnd = matrix.length, colStart = 0, colEnd = matrix[0].length;
        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++)
                System.out.print(matrix[rowStart][i] + " ");
            rowStart++;
            for (int i = rowStart; i < rowEnd; i++)
                System.out.print(matrix[i][colEnd - 1] + " ");
            colEnd--;
            for (int i = colEnd - 1; i >= colStart; i--)
                System.out.print(matrix[rowEnd - 1][i] + " ");
            rowEnd--;
            for (int i = rowEnd - 1; i >= rowStart; i--)
                System.out.print(matrix[i][colStart] + " ");
            colStart++;
        }
    }

    private static void findRepeatedNumCountInGivenArray() {
        int[] input = {2, 3, 4, 2, 2, 5, 5};
        HashMap<Integer, Integer> TraceCount = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (TraceCount.containsKey(input[i])) TraceCount.put(input[i], (TraceCount.get(input[i]) + 1));
            else TraceCount.put(input[i], 1);
        }
        System.out.println(TraceCount);
    }

    private static void printCrossMatrix() {
        int num = 5;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(i == j ? (i < 3 ? num - i : i + 1) + " " : i + j == num - 1 ? (i < 3 ? i + 1 : num - i) + " " : "  ");
            }
            System.out.print("\n");
        }
    }

    private static void printCharacterAndItsLength() {
        String str = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        int Count = 0;
        for (int i = 0; i < str.length(); i++) {
            Count++;
            char current = str.charAt(i), next = i + 1 < str.length() ? str.charAt(i + 1) : (char) -1;
            if (current != next) {
                System.out.print(current + "" + Count);
                Count = 0;
            }
        }
    }

    static void convertNumToChar() {
        String str = "a1b50c10d10e1h100";
        for (int i = 0, k; i < str.length(); i = k + 1) {
            char Char = str.charAt(i);
            int Count = i + 1 < str.length() ? str.charAt(++i) - 48 : 0, next = i + 1 < str.length() ? str.charAt(i + 1) - 48 : 0;
            k = i;
            while (next > -1 && next < 10 && k + 1 < str.length()) {
                Count *= 10;
                Count += (str.charAt(++k) - 48);
                if (k + 1 < str.length()) next = str.charAt(k + 1) - 48;
            }
            for (int j = 0; j < Count; j++) {
                System.out.print(Char);
            }
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
        int[] newArr = new int[array1.length + array2.length];
        int Count = 0;
        for (int i = 0; i < Math.max(array1.length, array2.length); i++) {
            newArr[Count++] = array1[i];
            if (i < array2.length) newArr[Count++] = array2[i];
        }
        System.out.println(Arrays.toString(insertionSort(newArr, 1)));
    }

    private static int[] insertionSort(int[] intArray, int i) {
        int previousIndex = i - 1, currentValue = intArray[i];
        while (previousIndex > -1 && intArray[previousIndex] > currentValue)
            intArray[previousIndex + 1] = intArray[previousIndex--];
        intArray[previousIndex + 1] = currentValue;
        if (i + 1 < intArray.length) insertionSort(intArray, i + 1);
        return intArray;
    }

    private static void descendingSort(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            int previousIndex = i - 1, currentValue = intArray[i];
            while ((previousIndex > -1) && intArray[previousIndex] < currentValue) {
                intArray[previousIndex + 1] = intArray[previousIndex--];
            }
            intArray[previousIndex + 1] = currentValue;
        }
    }
}
