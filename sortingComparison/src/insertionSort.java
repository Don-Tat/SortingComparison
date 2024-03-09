
public class insertionSort {
    public void main(int[] arr) {
        /*
         * implement insertion sort algorithm
         * Basic plan.
         * For i from 1 to n-1, insert a[i] among a[i-1], a[i-2], a[i-3]... until a[i] is in the right place.
         *
         */
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public boolean confirmSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;

    }
}
