class Kadane {
    public static int kadane(int[] arr) {
        int farMaxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int j : arr) {
            tempSum += j;
            if (tempSum >= farMaxSum) farMaxSum = tempSum;
            if (tempSum < 0) tempSum = 0;
        }
        return farMaxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The sum of contiguous sub-array with the " +
                "largest sum is " + kadane(arr));
    }
}