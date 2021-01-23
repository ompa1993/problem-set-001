package SlidingWindow;
/*
* Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
*
*
* This problem follows the Sliding Window pattern, and we can use a similar dynamic sliding window strategy as discussed
* in No-repeat Substring. We can use a HashMap to count the frequency of each letter.

We’ll iterate through the string to add one letter at a time in the window.
We’ll also keep track of the count of the maximum repeating letter in any window (let’s call it maxRepeatLetterCount).
So, at any time, we know that we can have a window which has one letter repeating maxRepeatLetterCount times; this means
* we should try to replace the remaining letters.
If we have more than ‘k’ remaining letters, we should shrink the window as we are not allowed to replace more than ‘k’ letters.
While shrinking the window, we don’t need to update maxRepeatLetterCount (which makes it global count; hence, it is the
* maximum count for ANY window). Why don’t we need to update this count when we shrink the window?
* The answer: In any window, since we have to replace all the remaining letters to get the longest substring having the same letter,
* we can’t get a better answer from any other window even though all occurrences of the letter with
* frequency maxRepeatLetterCount is not in the current window.*/

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k){
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        //try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if(windowEnd - windowStart + 1 - maxRepeatLetterCount > k){
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
