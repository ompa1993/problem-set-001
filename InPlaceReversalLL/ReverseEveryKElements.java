package InPlaceReversalLL;
/*
* Problem Statement #
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
*
* The problem follows the In-place Reversal of a LinkedList pattern and is quite similar to Reverse a Sub-list.
* The only difference is that we have to reverse all the sub-lists. We can use the same approach, starting with the
* first sub-list (i.e. p=1, q=k) and keep reversing all the sublists of size ‘k’.

*/
public class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k){

        if (head == null || k <=1) return head;

        ListNode current = head, previous = null;
        while(true){

            ListNode lastNodeOfPreviousPart = previous;// points to the node at index 'p-1'

            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSublist = current;
            ListNode next = null;
            // reverse k nodes and 'q'
            for(int i =0; current != null && i < k; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            //now previous holds the start of the reversed sublist. So just attach it to the previous  part
            if (lastNodeOfPreviousPart != null){
                lastNodeOfPreviousPart.next = previous;
            } else{
                head = previous;
            }

            //connect with the last part. Current basically is the third part's start
            //thus connect it with the originally stored node i.e. nextpart
            lastNodeOfSublist.next = current;

            if (current == null){ // break, if we've reached the end of the LinkedList
                break;
            }
            //prepare for the next sub-list
            previous = lastNodeOfSublist;

            /*for (int j = 0; j<k; j++){
                previous = previous.next;
                current = current.next;
            }*/
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
