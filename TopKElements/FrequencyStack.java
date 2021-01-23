package TopKElements;

import java.util.*;

class Element{
    int number;
    int frquency;
    int sequenceNumber;

    public Element(int number, int frqeuency, int sequenceNumber){
        this.number = number;
        this.frquency = frqeuency;
        this.sequenceNumber = sequenceNumber;
    }
}

class ElementComparator implements Comparator<Element>{

    @Override
    public int compare(Element e1, Element e2) {
        if (e1.frquency != e2.frquency){
            return e2.frquency - e1.frquency;
        }
        return e2.sequenceNumber - e1.sequenceNumber;
    }
}

public class FrequencyStack {
    int sequenceNumber = 0;
    PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
    Map<Integer, Integer> frequencyMap = new HashMap<>();


    private void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
        maxHeap.add(new Element(num, frequencyMap.get(num), sequenceNumber++));
    }

    private int pop() {
        int num = maxHeap.poll().number;
        if (frequencyMap.get(num) > 1){
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }
        else{
            frequencyMap.remove(num);
        }
        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }

}
