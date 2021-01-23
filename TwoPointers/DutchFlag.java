package TwoPointers;
/*
* Problem Statement #
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

Example 1:

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]
Example 2:

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]
*
*
* Solution #
The brute force solution will be to use an in-place sorting algorithm like Heapsort which will take O(N*logN)O(N∗logN).
* Can we do better than this? Is it possible to sort the array in one iteration?

We can use a Two Pointers approach while iterating through the array. Let’s say the two pointers are called low and high
*  which are pointing to the first and the last element of the array respectively. So while iterating, we will move all
* 0s before low and all 2s after high so that in the end, all 1s will be between low and high.
* Pseudocode
The following pseudocode for three-way partitioning which assumes zero-based array indexing was proposed by Dijkstra himself.
* [2] It uses three indices i, j and k, maintaining the invariant that i ≤ j ≤ k.

Entries from 0 up to (but not including) i are values less than mid,
entries from i up to (but not including) j are values equal to mid,
entries from j up to (but not including) k are values not yet sorted, and
entries from k to the end of the array are values greater than mid.
procedure three-way-partition(A : array of values, mid : value):
    i ← 0
    j ← 0
    k ← size of A

    while j < k:
        if A[j] < mid:
            swap A[i] and A[j]
            i ← i + 1
            j ← j + 1
        else if A[j] > mid:
            swap A[j] and A[k]
            k ← k - 1
        else:
            j ← j + 1
*/
public class DutchFlag {
    public static void sort(int[] arr) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1/*
        int low = 0;
        int high = arr.length - 1;

        for (int i = 0; i <= high;){

            if (arr[i] == 0){
                swap(arr, i, low);
                //increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1){
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
