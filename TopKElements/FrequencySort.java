package TopKElements;
import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }

    private static String sortCharacterByFrequency(String str) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char i : str.toCharArray()){
            charFrequencyMap.put(i, charFrequencyMap.getOrDefault(i, 0) + 1);
        }

        //Create a MaxHeap based on the frequency of words occuring
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        for (Map.Entry<Character, Integer> charFreq : charFrequencyMap.entrySet()){
            maxHeap.add(charFreq);
        }

        //maxHeap.addAll(charFrequencyMap.entrySet());

        StringBuilder output = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++){
                output.append(entry.getKey());
            }
        }
        return output.toString();
    }
}
