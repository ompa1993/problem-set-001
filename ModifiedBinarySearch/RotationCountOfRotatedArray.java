package ModifiedBinarySearch;

public class RotationCountOfRotatedArray {

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }

    private static int countRotations(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start)/2;

            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid + 1;
            }

            if (mid > start && arr[mid - 1] > arr[mid]){
                return mid;
            }

            // this is the only difference from the previous solution
            // if numbers at indices start, mid, and end are same, we can't choose a side
            // the best we can do is to skip one number from both ends if they are not the smallest number
            /* To handle duplicate values
            if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                if (arr[start] > arr[start + 1]) // if element at start+1 is not the smallest
                    return start + 1;
                ++start;
                if (arr[end - 1] > arr[end]) // if the element at end is not the smallest
                    return end;
                --end;
                // left side is sorted, so the pivot is on right side
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }*/

            if (arr[start] < arr[mid]){//left side is sorted, pivot exists in the right side
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
