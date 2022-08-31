public class Main {
    public static void main(String[] args) {
        //    System.out.println(factorial(3));
        //    for (int i = 0; i < 10; i++) {
        //      System.out.print(findFibonacciSeries(i) + " ");
        //    }
//        System.out.println(reverseString("Hello"));
//        System.out.println(reverseNumber(456, 0));
        int[] array = {1, 2, 3, 4, 5};
        //    BinarySearch(array, 10);
        //    printAllPossibleCombinations(array, 3);
        int[][] mat =
                {
                        {4, 7, 1, 6},
                        {5, 7, 3, 9},
                        {3, 2, 1, 2},
                        {7, 1, 6, 3}
                };

        int cost = 25;
        int noOfPaths = findCostMatchPaths(mat, cost, mat.length - 1, mat[0].length - 1);
//        System.out.println("Path Cost : " + cost + ", Count = " + noOfPaths);
//        System.out.println(!isPrimeNumber(29, 2));
    }

    private static boolean isPrimeNumber(int num, int div) {
        if (num % div == 0) return true;
        return div + 1 < num / 2 && isPrimeNumber(num, div + 1);
    }

    private static int findCostMatchPaths(int[][] mat, int cost, int x, int y) {
        if (x > -1 && y > -1 && cost > 0) {
            if (x == 0 && y == 0) return mat[0][0] - cost == 0 ? 1 : 0;
            if (x == 0) findCostMatchPaths(mat, cost - mat[x][y], 0, y - 1);
            if (y == 0) findCostMatchPaths(mat, cost - mat[x][y], x - 1, 0);
            return findCostMatchPaths(mat, cost - mat[x][y], x - 1, y) + findCostMatchPaths(mat, cost - mat[x][y], x, y - 1);
        }
        return 0;
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

    private static int reverseNumber(int integer, int num) {
        return integer / 10 != 0 ? reverseNumber(integer / 10, (num + integer % 10) * 10) : num + integer;
    }

    private static String reverseString(String text) {
        return text.length() == 0 ? "" : reverseString(text.substring(1)) + text.charAt(0);
    }

    private static int findFibonacciSeries(int number) {
        return number != 1 && number != 2 ? (number == 0 ? 0 : findFibonacciSeries(number - 1) + findFibonacciSeries(number - 2)) : 1;
    }

    private static int factorial(int number) {
        return number != 0 && number != 1 ? number * factorial(number - 1) : 1;
    }
}
