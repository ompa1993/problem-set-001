package KWayMerge;
import java.util.*;

class Node{
    int elementIndex;
    int arrayIndex;

    Node(int elementIndex, int arrayIndex){
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k){

        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null){
                minHeap.add(new Node(0, i));
            }
        }

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the array of the top element has more elements, add the next element to the heap
        int count = 0, result = 0;
        while (!minHeap.isEmpty()){
            Node currNode = minHeap.poll();
            result = lists.get(currNode.arrayIndex)[currNode.elementIndex];
            if (++count == k){
                break;
            }
            currNode.elementIndex++;
            if (lists.get(currNode.arrayIndex).length > currNode.elementIndex){
                minHeap.add(currNode);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }

}
