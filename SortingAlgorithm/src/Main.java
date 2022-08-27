import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {5, 7, 1, 15, 10, 3, 9};
        insertionSortRecursion(intArray, 1);
        System.out.println("Sorted Array :" + Arrays.toString(intArray));
        insertionSort(intArray);
        findNextGreaterNumber();
    }

    private static void insertionSortRecursion(int[] array, int startingIndex) {
        int previousIndex = startingIndex - 1, currentInt = array[startingIndex];
        while (previousIndex > -1 && array[previousIndex] > currentInt)
            array[previousIndex + 1] = array[previousIndex--];
        array[previousIndex + 1] = currentInt;
        if (startingIndex + 1 < array.length)
            insertionSortRecursion(array, startingIndex + 1);
    }

    private static void findNextGreaterNumber() {
        int[] inputArray = {4, 5, 2, 25};
        for (int i = 0; i < inputArray.length; i++) {
            int currentValue = inputArray[i], j = i, nextGreaterValues = -1;
            while (++j < inputArray.length) {
                if (currentValue < inputArray[j]) {
                    nextGreaterValues = inputArray[j];
                    break;
                }
            }
            System.out.print(nextGreaterValues + " ");
        }
    }

    private static void insertionSort(int[] intArray) {
        for (int currentIndex = 1; currentIndex < intArray.length; currentIndex++) {
            int previousIndex = currentIndex - 1;
            int currentValue = intArray[currentIndex];
            while ((previousIndex >= 0) && (intArray[previousIndex] > currentValue))
                intArray[previousIndex + 1] = intArray[previousIndex--];
            intArray[previousIndex + 1] = currentValue;
        }
        System.out.print("Sorted Array: ");
        IntStream.of(intArray).forEach(value -> System.out.print(value + " "));
    }
}
