package TopKElements;
import java.util.*;

public class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k){
        int distinctElementsCount = 0;
        if (nums.length <= k){
            return distinctElementsCount;
        }

        //populate a hashmap
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums){
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());

        //insert all numbers that have frequency greater than 1
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()){
            if (entry.getValue() == 1){
                distinctElementsCount++;
            }
            else {
                minHeap.add(entry);
            }
        }

        //remove least-frequent elements first
        while(k > 0 && !minHeap.isEmpty()){
            Map.Entry<Integer, Integer> entry = minHeap.poll();

            k = k - (entry.getValue() - 1);

            if (k >= 0){
                distinctElementsCount++;
            }
        }

        if (k > 0){
            distinctElementsCount -= k;
        }

    return distinctElementsCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}

