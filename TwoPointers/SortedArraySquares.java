package TwoPointers;

/*
* Problem Statement #
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]
* */
public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int left = 0 , right = arr.length - 1;
        int index = arr.length - 1;
        while (left  < right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare){
                squares[index--]  = leftSquare;
                squares[index--] = rightSquare;
            }
            else {
                squares[index--]  = rightSquare;
                squares[index--] = leftSquare;
            }
            left++;
            right--;
        }
        if (index == 0){
            squares[index] = arr[left] * arr[left];
        }

        return squares;
    }

    public static void main(String[] args){
        int[] result = (SortedArraySquares.makeSquares(new int[] {-4, -1, 0, 2, 3}));
        for (int number : result){
            System.out.print(number + ", ");
        }
    }
}
