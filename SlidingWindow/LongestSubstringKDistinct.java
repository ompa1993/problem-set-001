package SlidingWindow;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.
Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

nput: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
* */
public class LongestSubstringKDistinct {
    public static int findLength(String str, int k){
        if(str == null || str.length() == 0 || str.length() < k){
            throw new IllegalArgumentException();
        }

        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k){
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0){
                    charFrequencyMap.remove(leftChar);
                }
                //reduce the window size
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);// remember the maximum length so far
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
