package SlidingWindow;

public class CharacterReplacementWrong {
    public static int findLength(String str, int k) {

        int windowStart = 0, maxLength = 0;
        int ignoreCount = k;
        int windowEnd = 0;
        while(windowEnd < str.length()){
            char rightChar = str.charAt(windowEnd);
            char leftChar = str.charAt(windowStart);
            if(rightChar != leftChar){
                if (ignoreCount > 0){
                    ignoreCount--;
                }
                else{
                    maxLength = Math.max(maxLength, windowEnd - windowStart);
                    ignoreCount = k;
                    windowStart = windowEnd - k;
                    windowEnd = windowStart;
                }
            }
            //else {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            //}
            windowEnd++;
        }
        return maxLength;

    }

    public static void main(String[] args) {
        //System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        //System.out.println(CharacterReplacement.findLength("abbcb", 1));
        //System.out.println(CharacterReplacement.findLength("abccde", 1));
        //System.out.println(CharacterReplacement.findLength("abab", 2));
        System.out.println(CharacterReplacementWrong.findLength("abbb", 2));
    }
}
