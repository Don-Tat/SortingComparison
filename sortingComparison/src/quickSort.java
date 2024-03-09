import java.util.Arrays;
import java.util.Random;

public class quickSort {
    public void main(int[] arr) {
        /*
         * implement quick sort algorithm
         * Basic plan.
         * Check if array length is less than 10, if so use insertion sort
         * Estimate median of the array by taking the median of the first 3 elements
         * 1. Shuffle the array
         * 2. Partition so that, for some j
         * - entry a[j] is in place
         * - no larger entry to the left of j
         * - no smaller entry to the right of j
         * 3. Sort each piece recursively
         */
        if (arr.length < 10) {
            insertionSort sorter = new insertionSort();
            sorter.main(arr);
        } else {
            shuffle(arr);

            int medianIndex = medianOfThree(arr, 0, 1, 2);
            swap(arr, medianIndex, 0);

            quickSort(arr, 0, arr.length - 1);
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int medianOfThree(int[] arr, int i, int j, int k) {
        // Implement logic to find median of 3 elements
        if (arr[i] > arr[j]) {
            if (arr[j] > arr[k]) {
                return j;
            } else if (arr[i] > arr[k]) {
                return k;
            } else {
                return i;
            }
        } else {
            if (arr[i] > arr[k]) {
                return i;
            } else if (arr[j] > arr[k]) {
                return k;
            } else {
                return j;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // Implement logic to swap two elements
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
