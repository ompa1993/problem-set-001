package SlidingWindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeKOmkar {

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeKOmkar.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }

    private static double[] findAverages(int K, int[] arr) {

        if(arr.length < K) return null;

        double sum = 0;
        for(int i=0; i<K; i++){
            sum = sum + arr[i];
        }

        if(arr.length == K) {
            return new double[]{sum/K};
        }

        double[] avgResults = new double[arr.length - K + 1];
        avgResults[0] = sum/K;
        double newAvg = 0;
        for(int i = 1; i <= arr.length - K; i++){
            int j = i + K - 1;
            sum = sum - arr[i - 1] + arr[j];
            newAvg = sum/K;
            avgResults[i] = newAvg;
        }
        return avgResults;
    }
}
