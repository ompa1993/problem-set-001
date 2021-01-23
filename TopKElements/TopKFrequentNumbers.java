package TopKElements;
import java.util.*;


public class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k){

        //Find the frequency of each number
        Map<Integer,Integer> numFrequencyMap = new HashMap<>();
        for (int num : nums){
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num,0) + 1);
        }

        //store this map frequency wise in a PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        //go thorough all numbers and push the entries from map in minHeap. If the size of minHeap exceeds, remove the top i.e. minimum element

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<Integer> topKFreqNums = new ArrayList<>(k);
        while (!minHeap.isEmpty()){
            topKFreqNums.add(minHeap.poll().getKey());
        }
        return topKFreqNums;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
