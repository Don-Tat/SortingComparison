
/*
 * Main class for the application
 * ask which file to read and then reads the file abd stores the data in an array
 * ask which sort to use and then sorts the array using the chosen sort method
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Ask the user for the file name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();
        // Read the file and store the data in an array
        int[] arr = readData(fileName);

        // Ask the user for the sort method
        System.out.println("Enter the sort method (insertion, quick): ");
        String sortMethod = scanner.nextLine();
        scanner.close();

        // Sort the array using the chosen sort method
        if (sortMethod.equals("insertion")) {
            insertionSort sorter = new insertionSort();
            sorter.main(arr);
        } else if (sortMethod.equals("quick")) {
            quickSort sorter = new quickSort();
            sorter.main(arr);
        } else {
            System.out.println("Invalid sort method");
            return;
        }

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    private static int[] readData(String fileName) {
        int[] arr = null;
        try {
            // Search for the file in the data folder
            File file = new File("data/" + fileName);
            Scanner scanner = new Scanner(file);

            // Read the data from the file and store it in an array
            int n = scanner.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return arr;
    }
}
