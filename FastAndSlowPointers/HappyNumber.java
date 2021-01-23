package FastAndSlowPointers;

/*
* Problem Statement #
Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

Example 1:

Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:
2^2 + 3 ^2
*
*
* Solution #
The process, defined above, to find out if a number is a happy number or not, always ends in a cycle.
* If the number is a happy number, the process will be stuck in a cycle on number ‘1,’ and if the number
* is not a happy number then the process will be stuck in a cycle with a set of numbers. As we saw in Example-2 while
* determining if ‘12’ is a happy number or not, our process will get stuck in a cycle with the
* following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

We saw in the LinkedList Cycle problem that we can use the Fast & Slow pointers method to find a cycle among a set
* of elements. As we have described above, each number will definitely have a cycle. Therefore, we will use the same
* fast & slow pointer strategy to find the cycle and once the cycle is found, we will see if the cycle is stuck
* on number ‘1’ to find out if the number is happy or not.*/
public class HappyNumber {
    public static boolean find(int num) {

        int slow = num, fast = num;
        do{
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        }while (slow != fast);

        return slow == 1;
    }

    public static int findSquareSum(int num){
        int sum = 0, digit = 0;
        while(num > 0){
            sum += digit * digit;
            num = num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
