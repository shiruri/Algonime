package org.shiro.algonime;
import java.util.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class algorithms {

    private final Scanner scan = new Scanner(System.in);
    private int[] arr_numbers; // Array of numbers to sort
    private int arr_size; // Size of the array
    
    public void algoMenu() {
        System.out.println("Welcome to Algonime!");
        boolean exit = false;
		while (!exit){
        System.out.println("Enter mode (random/inserted/exit):");
        try {
            String randIns = scan.nextLine().toLowerCase();
            switch (randIns) {
                case "inserted":
                    insertedMenu();
                    break;
                case "random":
                	Randomver();
                    break;
                case "exit":
                	exit = true;
                	break;
                default:
                    System.out.println("Error: Invalid option. Please try again.");
            }
        } catch (Exception e) {
            System.err.println("Invalid option");
        }
    }
    }

        public void Randomver() {
            int min = 1;
            int max = 1000000000;
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter array size: ");
            int arr_size_rand = scan.nextInt();  // Get array size from user

            // Use a Set to store unique random numbers
            Set<Integer> uniqueNumbers = new HashSet<>();

            Random rand = new Random();

            // Generate random numbers until the set contains the desired number of unique elements
            while (uniqueNumbers.size() < arr_size_rand) {
                int randomNum = rand.nextInt(max - min + 1) + min;
                uniqueNumbers.add(randomNum);
            }

            // Convert the set to an array
            int[] arr_rand = uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();

            // Output the generated random array in one line
            System.out.print("Generated random array: ");
            for (int num : arr_rand) {
                System.out.print(num + " ");
                arr_numbers = arr_rand;
                arr_size = arr_size_rand;
            }
            System.out.println();  // Move to the next line after printing all numbers
   // Call your sorting algorithm here
         
          
            algorithmsSorts();
        }
     
    public void insertedMenu() {
        System.out.print("Enter Array Size: ");
        arr_size = scan.nextInt();
        arr_numbers = new int[arr_size];
        
        System.out.println("Enter " + arr_size + " numbers to be sorted:");
        for (int i = 0; i < arr_size; i++) {
            arr_numbers[i] = scan.nextInt();
        }
        
        algorithmsSorts();
    }

    public void algorithmsSorts() {
        System.err.println("Choose a Sorting Algorithm:");
        System.err.println("1. Bubble Sort");
        System.err.println("2. Selection Sort");
        System.err.println("3. Insertion Sort");
        System.err.println("4. Merge Sort");
        System.err.println("5. Quick Sort");
        System.err.println("6. Heap Sort");
        System.err.println("7. Counting Sort");
        System.err.println("8. Radix Sort");
        System.err.println("9. Shell Sort");
        System.err.println("10. Cocktail Sort");
        System.err.println("11. Gnome Sort");
        System.err.println("12. Bogo Sort");
        System.err.println("13. Bucket Sort");
        System.err.println("14. Comb Sort");

        int algonum = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.err.print("Enter the number of the Sorting Algorithm to use: ");
            
            if (scan.hasNextInt()) {
                algonum = scan.nextInt();
                if (algonum > 0 && algonum <= 15) {
                    isValidInput = true;
                    System.err.println("Chosen Algorithm: " + algonum);
                    SortingListCheck(algonum);
                } else {
                    System.err.println("Invalid input, please enter a number between 1 and 15.");
                }
            } else {
                System.err.println("Invalid input, please enter a valid number.");
                scan.next(); // Clear invalid input
            }
        }
    }

    public void SortingListCheck(int algonum) {
        switch (algonum) {
            case 1 -> bubbleSort(arr_numbers, arr_size);
            case 2 -> selectionSort(arr_numbers, arr_size);
            case 3 ->  insertionSort(arr_numbers, arr_size);
            case 4 ->  mergeSort(arr_numbers);
            case 5 ->  quickSort(arr_numbers, 0, arr_size - 1);       
            case 6 ->  heapSort(arr_numbers);           
            case 7 ->  countingSort(arr_numbers);       
            case 8 ->  radixSort(arr_numbers, arr_size);      
            case 9 ->  shellSort(arr_numbers, arr_size);          
            case 10 -> cocktailSort(arr_numbers, arr_size);        
            case 11 ->  gnomeSort(arr_numbers, arr_size);         
            case 12 ->  bogoSort(arr_numbers);        
            case 13 ->  bucketSort(arr_numbers);          
            case 14 ->  combSort(arr_numbers);
            default -> System.err.println("Invalid algorithm number.");
        }
    }

    public static void bubbleSort(int[] arr_numbers, int arr_size) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        for (int i = 0; i < arr_size - 1; i++) {
            for (int j = 0; j < arr_size - i - 1; j++) {
                if (arr_numbers[j] > arr_numbers[j + 1]) {
                    int temp = arr_numbers[j];
                    arr_numbers[j] = arr_numbers[j + 1];
                    arr_numbers[j + 1] = temp;

                    stepCounter++;
                    if (stepCounter <= 5) {
                        System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }
    public static void combSort(int[] arr_numbers) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        int gap = arr_numbers.length;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            // Update the gap for the next comb pass
            gap = Math.max(1, (int) (gap / 1.3)); // Shrink factor 1.3
            swapped = false;

            // Perform a "comb" pass
            for (int i = 0; i + gap < arr_numbers.length; i++) {
                if (arr_numbers[i] > arr_numbers[i + gap]) {
                    // Swap elements
                    int temp = arr_numbers[i];
                    arr_numbers[i] = arr_numbers[i + gap];
                    arr_numbers[i + gap] = temp;

                    swapped = true;
                    stepCounter++;

                    if (stepCounter <= 5) {
                        System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    public static void bucketSort(int[] arr_numbers) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        // Find the maximum value in the array for bucket range
        int maxValue = Arrays.stream(arr_numbers).max().getAsInt();
        int bucketCount = (int) Math.sqrt(arr_numbers.length);

        // Create buckets
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int number : arr_numbers) {
            int bucketIndex = (number * bucketCount) / (maxValue + 1);
            buckets[bucketIndex].add(number);
        }

        // Sort each bucket and merge
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
            for (int number : buckets[i]) {
                arr_numbers[index++] = number;

                stepCounter++;
                if (stepCounter <= 5) {
                    System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }
    public static void bogoSort(int[] arr_numbers) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        // Shuffle until sorted
        while (!isSorted(arr_numbers)) {
            shuffle(arr_numbers);
            stepCounter++;

            if (stepCounter <= 5) {
                System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    // Helper method to check if the array is sorted
    private static boolean isSorted(int[] arr_numbers) {
        for (int i = 0; i < arr_numbers.length - 1; i++) {
            if (arr_numbers[i] > arr_numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Helper method to shuffle the array
    private static void shuffle(int[] arr_numbers) {
        Random rand = new Random();
        for (int i = 0; i < arr_numbers.length; i++) {
            int randomIndex = rand.nextInt(arr_numbers.length);
            // Swap arr_numbers[i] with arr_numbers[randomIndex]
            int temp = arr_numbers[i];
            arr_numbers[i] = arr_numbers[randomIndex];
            arr_numbers[randomIndex] = temp;
        }
    }

    public static void gnomeSort(int[] arr_numbers, int arr_size) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        int index = 0;

        while (index < arr_size) {
            if (index == 0 || arr_numbers[index] >= arr_numbers[index - 1]) {
                // Move forward if in the right order or at the beginning
                index++;
            } else {
                // Swap elements if in the wrong order
                int temp = arr_numbers[index];
                arr_numbers[index] = arr_numbers[index - 1];
                arr_numbers[index - 1] = temp;

                stepCounter++;
                if (stepCounter <= 5) {
                    System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                }

                // Move back to compare previous elements
                index--;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    public static void cocktailSort(int[] arr_numbers, int arr_size) {
        long startTime = System.nanoTime();
        int stepCounter = 0;
        boolean swapped = true;

        int start = 0;
        int end = arr_size - 1;

        while (swapped) {
            // Reset the swapped flag on each new pass
            swapped = false;

            // Forward pass
            for (int i = start; i < end; i++) {
                if (arr_numbers[i] > arr_numbers[i + 1]) {
                    // Swap elements
                    int temp = arr_numbers[i];
                    arr_numbers[i] = arr_numbers[i + 1];
                    arr_numbers[i + 1] = temp;
                    swapped = true;

                    stepCounter++;
                    if (stepCounter <= 5) {
                        System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                    }
                }
            }

            // If nothing moved, then the array is sorted
            if (!swapped) {
                break;
            }

            // Decrease the end point
            end--;

            // Reset the swapped flag for the backward pass
            swapped = false;

            // Backward pass
            for (int i = end; i > start; i--) {
                if (arr_numbers[i] < arr_numbers[i - 1]) {
                    // Swap elements
                    int temp = arr_numbers[i];
                    arr_numbers[i] = arr_numbers[i - 1];
                    arr_numbers[i - 1] = temp;
                    swapped = true;

                    stepCounter++;
                    if (stepCounter <= 5) {
                        System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                    }
                }
            }

            // Increase the starting point
            start++;
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    public static void shellSort(int[] arr_numbers, int arr_size) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        // Start with a big gap, then reduce the gap
        for (int gap = arr_size / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < arr_size; i++) {
                int temp = arr_numbers[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for arr_numbers[i] is found
                for (j = i; j >= gap && arr_numbers[j - gap] > temp; j -= gap) {
                    arr_numbers[j] = arr_numbers[j - gap];
                }
                arr_numbers[j] = temp;

                stepCounter++;
                if (stepCounter <= 5) {
                    System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    public static void radixSort(int[] arr_numbers, int arr_size) {
        long startTime = System.nanoTime();
        int stepCounter = 0;

        // Find the maximum number to know the number of digits
        int max = getMax(arr_numbers, arr_size);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr_numbers, arr_size, exp);
            stepCounter++;
            if (stepCounter <= 5) {
                System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    // A utility function to get the maximum value in the array
    private static int getMax(int[] arr_numbers, int arr_size) {
        int max = arr_numbers[0];
        for (int i = 1; i < arr_size; i++) {
            if (arr_numbers[i] > max) {
                max = arr_numbers[i];
            }
        }
        return max;
    }

    // A function to do counting sort based on the digit represented by exp
    private static void countingSort(int[] arr_numbers, int arr_size, int exp) {
        int[] output = new int[arr_size]; // output array
        int[] count = new int[10]; // count array for digits 0-9

        // Store the count of occurrences of each digit
        for (int i = 0; i < arr_size; i++) {
            count[(arr_numbers[i] / exp) % 10]++;
        }

        // Change count[i] to contain the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = arr_size - 1; i >= 0; i--) {
            output[count[(arr_numbers[i] / exp) % 10] - 1] = arr_numbers[i];
            count[(arr_numbers[i] / exp) % 10]--;
        }

        // Copy the output array to arr_numbers[], so that arr_numbers[] now
        // contains sorted numbers according to the current digit
        System.arraycopy(output, 0, arr_numbers, 0, arr_size);
    }

    
    public static void countingSort(int[] arr_numbers) {
        long startTime = System.nanoTime();
        int arr_size = arr_numbers.length;
        int max = Arrays.stream(arr_numbers).max().getAsInt(); // Find the maximum value
        int[] count = new int[max + 1]; // Count array
        int stepCounter = 0;

        // Step 1: Initialize count array
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        System.out.println("Initialized count array: " + Arrays.toString(count));

        // Step 2: Store the count of each number
        for (int num : arr_numbers) {
            count[num]++;
            stepCounter++;
            if (stepCounter <= 5) {
                System.out.println("Counting: Added " + num + ", count array: " + Arrays.toString(count));
            }
        }

        // Step 3: Change count[i] so that count[i] contains the actual position of this number in output
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            stepCounter++;
            if (stepCounter <= 5) {
                System.out.println("Cumulative count: " + Arrays.toString(count));
            }
        }

        // Step 4: Build the output array
        int[] output = new int[arr_size]; // output array
        for (int i = arr_size - 1; i >= 0; i--) {
            output[count[arr_numbers[i]] - 1] = arr_numbers[i];
            count[arr_numbers[i]]--;
            stepCounter++;
            if (stepCounter <= 5) {
                System.out.println("Placing " + arr_numbers[i] + " in output: " + Arrays.toString(output));
            }
        }

        // Step 5: Copy the output array to arr_numbers
        for (int i = 0; i < arr_size; i++) {
            arr_numbers[i] = output[i];
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }
    public static void heapSort(int[] arr_numbers) {
        long startTime = System.nanoTime();
        int arr_size = arr_numbers.length;
        int stepCounter = 0;

        // Build max heap
        for (int i = arr_size / 2 - 1; i >= 0; i--) {
            heapify(arr_numbers, arr_size, i, stepCounter);
        }

        // One by one extract elements from heap
        for (int i = arr_size - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr_numbers[0];
            arr_numbers[0] = arr_numbers[i];
            arr_numbers[i] = temp;
            stepCounter++;
            if (stepCounter <= 5) {
                System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }

            // Call max heapify on the reduced heap
            heapify(arr_numbers, i, 0, stepCounter);
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr_numbers
    private static void heapify(int[] arr_numbers, int arr_size, int i, int stepCounter) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < arr_size && arr_numbers[left] > arr_numbers[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < arr_size && arr_numbers[right] > arr_numbers[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr_numbers[i];
            arr_numbers[i] = arr_numbers[largest];
            arr_numbers[largest] = swap;
            stepCounter++;

            if (stepCounter <= 5) {
                System.out.println("Heapify Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }

            // Recursively heapify the affected subtree
            heapify(arr_numbers, arr_size, largest, stepCounter);
        }
    }
  public static void mergeSort(int[] arr_numbers) {
    long startTime = System.nanoTime();
    int stepCounter = 0;

    // Call recursive merge sort function
    mergeSortHelper(arr_numbers, 0, arr_numbers.length - 1, stepCounter);

    long endTime = System.nanoTime();
    System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
    System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");
}

private static void mergeSortHelper(int[] arr, int left, int right, int stepCounter) {
    if (left < right) {
        int mid = (left + right) / 2;

        // Recursively split array into halves
        mergeSortHelper(arr, left, mid, stepCounter);
        mergeSortHelper(arr, mid + 1, right, stepCounter);

        // Merge the two halves and print the step
        stepCounter = merge(arr, left, mid, right, stepCounter);
    }
}

private static int merge(int[] arr, int left, int mid, int right, int stepCounter) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Create temporary arrays
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copy data to temp arrays
    System.arraycopy(arr, left, L, 0, n1);
    System.arraycopy(arr, mid + 1, R, 0, n2);

    int i = 0, j = 0;
    int k = left;

    // Merge the temp arrays back into the original array
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements of L[], if any
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy remaining elements of R[], if any
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }

    // Print each merge step up to 5 times
    stepCounter++;
    if (stepCounter <= 5) {
        System.out.println("Merge Step " + stepCounter + ": " + Arrays.toString(arr));
    }

    return stepCounter;
}
public static void quickSort(int[] arr_numbers, int low, int high) {
    long startTime = System.nanoTime(); // Start time measurement
    int stepCounter = 0; // Step counter for tracking sorting steps

    quickSortHelper(arr_numbers, low, high, stepCounter);

    long endTime = System.nanoTime(); // End time measurement
    System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
    System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");

    if (stepCounter > 5) {
        System.out.println("Steps exceeded 5. More sorting operations were performed.");
    }
}

private static void quickSortHelper(int[] arr_numbers, int low, int high, int stepCounter) {
    if (low < high) {
        // Partition the array and get the pivot index
        int pivotIndex = partition(arr_numbers, low, high, stepCounter);
        // Recursively sort elements before and after partition
        quickSortHelper(arr_numbers, low, pivotIndex - 1, stepCounter);
        quickSortHelper(arr_numbers, pivotIndex + 1, high, stepCounter);
    }
}

private static int partition(int[] arr_numbers, int low, int high, int stepCounter) {
    int pivot = arr_numbers[high]; // Choose the rightmost element as the pivot
    int i = low - 1; // Pointer for the smaller element

    for (int j = low; j < high; j++) {
        // If the current element is smaller than or equal to the pivot
        if (arr_numbers[j] <= pivot) {
            i++; // Increment the index of the smaller element
            // Swap arr_numbers[i] and arr_numbers[j]
            int temp = arr_numbers[i];
            arr_numbers[i] = arr_numbers[j];
            arr_numbers[j] = temp;

            stepCounter++;
            if (stepCounter <= 5) {
                System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }
        }
    }

    // Swap the pivot element with the element at i + 1
    int temp = arr_numbers[i + 1];
    arr_numbers[i + 1] = arr_numbers[high];
    arr_numbers[high] = temp;

    return i + 1; // Return the index of the pivot
}

     

    public static void selectionSort(int[] arr_numbers, int arr_size) {

        long startTime = System.nanoTime(); // Start time measurement
        int stepCounter = 0; // Initialize a step counter to keep track of each sorting step

        // Outer loop for each element in the array (excluding the last one)
        for (int i = 0; i < arr_size - 1; i++) {
            int minIndex = i; // Assume the current position has the minimum element

            // Inner loop to find the smallest element in the unsorted part of the array
            for (int j = i + 1; j < arr_size; j++) {
                if (arr_numbers[j] < arr_numbers[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr_numbers[minIndex];
            arr_numbers[minIndex] = arr_numbers[i];
            arr_numbers[i] = temp;

            stepCounter++; // Increment the step counter
            if (stepCounter <= 5) {
                // Print the array after each swap (up to 5 steps)
                System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }
        }

        long endTime = System.nanoTime(); // End time measurement
        long duration = endTime - startTime; // Calculate the duration in nanoseconds

        // Print the final sorted array and the time taken
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (duration / 1_000_000.0) + " milliseconds");

        // Check if more than 5 steps were taken
        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }
    public static void insertionSort(int[] arr_numbers, int arr_size) {
        long startTime = System.nanoTime(); // Start time measurement
        int stepCounter = 0; // Step counter to limit printed steps

        // Outer loop for iterating over each element from the second element to the end
        for (int i = 1; i < arr_size; i++) {
            int key = arr_numbers[i]; // Current element to be inserted in sorted portion
            int j = i - 1;

            // Inner loop to shift elements of the sorted portion to the right
            // until the correct position for the key is found
            while (j >= 0 && arr_numbers[j] > key) {
                arr_numbers[j + 1] = arr_numbers[j];
                j--; // Move one position to the left
            }
            
            // Insert the key at the correct position in sorted portion
            arr_numbers[j + 1] = key;

            stepCounter++; // Increment the step counter
            if (stepCounter <= 5) {
                // Print the array after each insertion step (up to 5 steps)
                System.out.println("Step " + stepCounter + ": " + Arrays.toString(arr_numbers));
            }
        }

        long endTime = System.nanoTime(); // End time measurement
        long duration = endTime - startTime; // Calculate duration in nanoseconds

        // Print the final sorted array and the time taken
        System.out.println("Final Sorted Array: " + Arrays.toString(arr_numbers));
        System.out.println("Time taken for sorting: " + (duration / 1_000_000.0) + " milliseconds");

        // Check if more than 5 steps were taken
        if (stepCounter > 5) {
            System.out.println("Steps exceeded 5. More sorting operations were performed.");
        }
    }


}
