package FastAndSlowPointers;
/*
* Rearrange a LinkedList (medium) #
Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.

Your algorithm should not use any extra space and the input LinkedList should be modified in-place.

Example 1:

Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
Example 2:

Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
Solution #
This problem shares similarities with Palindrome LinkedList. To rearrange the given LinkedList we will follow the following steps:

We can use the Fast & Slow pointers method similar to Middle of the LinkedList to find the middle node of the LinkedList.
Once we have the middle of the LinkedList, we will reverse the second half of the LinkedList.
Finally, we’ll iterate through the first half and the reversed second half to produce a LinkedList in the required order.
*
* */
public class RearrangeList {

    public static void reorder(ListNode head){

        if (head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //slow has the middle node
        ListNode headOfSecondHalf = reverse(slow);
        ListNode headOfFirstHalf = head;

        while(headOfFirstHalf != null && headOfSecondHalf != null){

            ListNode temp = headOfFirstHalf.next;
            headOfFirstHalf.next = headOfSecondHalf;
            headOfFirstHalf = temp;

            temp = headOfSecondHalf.next;
            headOfSecondHalf.next = headOfFirstHalf;
            headOfSecondHalf = temp;
        }

        // Set the next of the last node to null
        if (headOfFirstHalf != null){
            headOfFirstHalf.next = null;
        }

    }

    public static ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode current = node;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
