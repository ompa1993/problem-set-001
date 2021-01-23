package TopKElements;
import java.util.*;

public class RearrangeStringKDistanceApart {

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }

    private static String reorganizeString(String str, int k) {

        if (k <= 1){
            return str;
        }
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(charFrequencyMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder(str.length());
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> maxHeapEntry = maxHeap.poll();
            result.append(maxHeapEntry.getKey());
            maxHeapEntry.setValue(maxHeapEntry.getValue() - 1);

            queue.offer(maxHeapEntry);
            if (queue.size() == k){
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0){
                    maxHeap.add(entry);
                }
            }
        }

        return result.length() == str.length() ? result.toString() : "";
    }
}
