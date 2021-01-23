package TopKElements;

import java.util.*;

public class RearrangeString {

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }

    private static String rearrangeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder resultString = new StringBuilder(str.length());

        while (!maxHeap.isEmpty()){

            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            if (previousEntry != null && previousEntry.getValue() > 0){
                maxHeap.offer(previousEntry);
            }
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        return resultString.length() == str.length() ? resultString.toString() : "";
    }
}
