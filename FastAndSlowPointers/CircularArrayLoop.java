package FastAndSlowPointers;
/*
* Cycle in a Circular Array (hard) #
We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index.
* Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
* You should assume that the array is circular which means two things:

If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one
* direction which means the cycle should not contain both forward and backward movements.

Example 1:

Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
Example 2:

Input: [2, 2, -1, 2]
Output: true
Explanation: The array has a cycle among indices: 1 -> 3 -> 1
Example 3:

Input: [2, 1, -1, -2]
Output: false
Explanation: The array does not have any cycle.
Solution #
This problem involves finding a cycle in the array and, as we know, the Fast & Slow pointer method is an efficient way
* to do that. We can start from each index of the array to find the cycle. If a number does not have a cycle we will
* move forward to the next element. There are a couple of additional things we need to take care of:

As mentioned in the problem, the cycle should have more than one element. This means that when we move a pointer forward,
* if the pointer points to the same element after the move, we have a one-element cycle. Therefore, we can finish our
* cycle search for the current element.

The other requirement mentioned in the problem is that the cycle should not contain both forward and backward movements.
* We will handle this by remembering the direction of each element while searching for the cycle. If the number is positive,
* the direction will be forward and if the number is negative, the direction will be backward.
* So whenever we move a pointer forward, if there is a change in the direction, we will finish our cycle search right there for the current element.*/
public class CircularArrayLoop {

    public static boolean loopExists(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean isForward = arr[i] >= 0; // if we are moving in the forward direction or not
            int slow = i, fast = i;

            // if slow or fast becomes '-1', this means we can't find cycle for this number
            do {
                slow = findNextIndex(arr, isForward, slow); //move one step for the slow pointer
                fast = findNextIndex(arr, isForward, fast); //move one step for the fast pointer
                if (fast != -1){
                    fast = findNextIndex(arr, isForward, fast); //move another step for the fast pointer
                }
            }while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast){
                return true;
            }
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction){
            return -1;
        }

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0){//wrap around for a negative numbers
            nextIndex = nextIndex + arr.length;
        }

        //One element cycle, return -1
        if (nextIndex == currentIndex){
            nextIndex = -1;
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
