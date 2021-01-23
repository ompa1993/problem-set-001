package ModifiedBinarySearch;

public class NextLetter {

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }

    private static char searchNextLetter(char[] letters, char key) {

        int start = 0, end = letters.length - 1;
        if (key < letters[start] || key > letters[end]){
            return letters[start];
        }

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (key < letters[mid]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
