package TopKElements;
import java.util.*;

public class SumOfElements {

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }

    private static int findSumOfElements(int[] nums, int k1, int k2) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums){
            minHeap.add(n);
        }

        for (int i = 0; i < k1; i++){
            minHeap.poll();
        }

        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++){
            elementSum += minHeap.poll();
        }
        return elementSum;
    }

    /*
    * Alternate solution
    * */
    private static int findSumOfElementsMaxHeap(int[] nums, int k1, int k2){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int i = 0; i < nums.length; i++){

            if (i < k2 - 1){
                minHeap.add(nums[i]);
            }else {
                if (nums[i] < minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }

        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++){
            elementSum += minHeap.poll();
        }
        return elementSum;
    }
}
