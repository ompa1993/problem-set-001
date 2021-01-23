package TopKElements;
import java.util.*;


public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }

    private static int scheduleTasks(char[] tasks, int k) {
        int intervalCount = 0;
        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char chr : tasks) {
            taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(taskFrequencyMap.entrySet());

        while (!maxHeap.isEmpty()){
            List<Map.Entry<Character, Integer>> waitingList = new ArrayList<>();
            int n = k + 1;
            for (; n > 0 && !maxHeap.isEmpty(); n--){
                intervalCount++;
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                if (entry.getValue() > 1){
                    entry.setValue(entry.getValue() - 1);
                    waitingList.add(entry);
                }
            }

            maxHeap.addAll(waitingList);
            if (!maxHeap.isEmpty()){
                intervalCount += n;
            }
        }
        return intervalCount;
    }
}
