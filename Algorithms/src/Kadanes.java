class Kadanes {
    public static int kadane(int[] array) {
        int soFarMax = 0, tempMax = 0;
        for (int num : array) {
            tempMax = Integer.max(tempMax + num, 0);
            soFarMax = Integer.max(soFarMax, tempMax);
        }
        return soFarMax;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The sum of contiguous subarray with the " +
                "largest sum is " + kadane(arr));
    }
}