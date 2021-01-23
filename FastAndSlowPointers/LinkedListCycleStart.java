package FastAndSlowPointers;

import java.util.List;

/*
* Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
* Solution #
If we know the length of the LinkedList cycle, we can find the start of the cycle through the following steps:

Take two pointers. Let’s call them pointer1 and pointer2.
Initialize both pointers to point to the start of the LinkedList.
We can find the length of the LinkedList cycle using the approach discussed in LinkedList Cycle.
* Let’s assume that the length of the cycle is ‘K’ nodes.
Move pointer2 ahead by ‘K’ nodes.
Now, keep incrementing pointer1 and pointer2 until they both meet.
As pointer2 is ‘K’ nodes ahead of pointer1, which means, pointer2 must have completed one loop in the
* cycle when both pointers meet. Their meeting point will be the start of the cycle.
* */

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head){

        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }
        return findFirst(head, cycleLength);

    }

    private static ListNode findFirst(ListNode head, int cycleLength) {
        ListNode slowOne = head;
        ListNode fastOne = head;
        for (int i = 0; i < cycleLength; i++){
            fastOne = fastOne.next;
        }

        while (fastOne != slowOne){
            fastOne = fastOne.next;
            slowOne = slowOne.next;
        }
        return fastOne;
    }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLen = 0;
        do{
            current = current.next;
            cycleLen++;
        }while (current != slow);

        return cycleLen;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
