package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class heapSortTest {

    // Positive Cases
    @Test
    public void testTypicalArraySorting() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    // Negative Cases
    @Test
    public void testInvalidInputWithNullArray() {
        int[] array = null;
        assertThrows(NullPointerException.class, () -> heapSort.heapSort(array));
    }

    @Test
    public void testInvalidInputWithStringArray() {
        // Since our method only accepts int[] arrays, this test represents how we would handle invalid data types.
        // This won't compile directly, but you might consider handling such input in a more generalized implementation.
    }

    // Performance Cases
    @Test
    public void testSmallArrayPerformance() {
        int[] array = {5, 2, 9, 1};
        int[] expected = {1, 2, 5, 9};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testLargeArrayPerformance() {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i; // Creates a reverse-sorted array for testing
        }
        heapSort.heapSort(array);

        // Assert array is sorted in ascending order
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    // Boundary Cases
    @Test
    public void testEmptyArray() {
        int[] array = {};
        int[] expected = {};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSingleElementArray() {
        int[] array = {1};
        int[] expected = {1};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testArrayWithDuplicateValues() {
        int[] array = {4, 1, 3, 1, 2, 1};
        int[] expected = {1, 1, 1, 2, 3, 4};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }

    // Idempotency Cases
    @Test
    public void testIdempotencyOnMultipleRuns() {
        int[] array = {3, 5, 1, 9, 2};
        int[] expected = {1, 2, 3, 5, 9};

        heapSort.heapSort(array);
        assertArrayEquals(expected, array);

        // Run heap sort again and check consistency
        heapSort.heapSort(array);
        assertArrayEquals(expected, array);
    }
}
