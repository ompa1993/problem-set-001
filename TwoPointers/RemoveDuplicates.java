package TwoPointers;
/*
* */
public class RemoveDuplicates {
    public static int remove(int[] arr) {

        int origLength = arr.length;
        int prev = 0;

        for(int curr = 1; curr < arr.length; curr++){

            if(arr[prev] == arr[curr]){
                origLength--;
            }
            prev ++;
        }
        return origLength;
    }

    public static int removeInPlace(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    /*
    * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

        Example 1:

        Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
        Output: 4
        Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
        Example 2:

        Input: [2, 11, 2, 2, 1], Key=2
        Output: 2
        Explanation: The first two elements after removing every 'Key' will be [11, 1].
*/
    public static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    public static void main(String[] args){

        System.out.println(RemoveDuplicates.remove(new int[] {2, 3, 3, 3, 6, 9, 9}));
    }
}
