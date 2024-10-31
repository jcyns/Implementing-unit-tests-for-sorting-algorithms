package org.example;

public class heapSort {

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // Initialize largest as root
        int left = 2 * rootIndex + 1; // Left child index
        int right = 2 * rootIndex + 2; // Right child index

        // If left child is larger than root
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != rootIndex) {
            int swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
        }
    }

    // Main method to test the heap sort
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(array);

        heapSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Helper method to print the array
    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
