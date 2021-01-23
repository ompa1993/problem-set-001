package TwoPointers;

public class BackspaceCompareOmkarSoln {
    public static boolean compare(String str1, String str2) {

        return getCleanString(str1).equals(getCleanString(str2));

    }

    public static String getCleanString(String str){
        String newString = "";

        int right = 0;
        int left = 0;
        while(right < str.length()){

            if (str.charAt(right) == '#'){
                int count = 1;
                int backspaces = right + 1;
                while (backspaces < str.length()){
                    if (str.charAt(backspaces) == '#'){
                        count++;
                    }
                    backspaces++;
                }
                right = right + count;
                newString += str.substring(left, right - (count * 2));
                left = right;
            }
            right++;

        }
        newString += str.substring(left);
        return newString;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompareOmkarSoln.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompareOmkarSoln.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompareOmkarSoln.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompareOmkarSoln.compare("xywrrmp", "xywrrmu#p"));
    }
}
