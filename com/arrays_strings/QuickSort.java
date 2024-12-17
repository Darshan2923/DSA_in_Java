package com.arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] { 4, 6, 2, 5, 7, 9, 1, 3 });
        int n = arr.size();

        System.out.println("Before Using Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        quickSort(arr, 0, arr.size() - 1);

        System.out.println("After Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    // QuickSort function
    private static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Partition function
    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low); // Choose the first element as the pivot
        int i = low;
        int j = high;

        while (i < j) {
            // Increment i until we find an element greater than the pivot
            while (i <= high && arr.get(i) <= pivot) {
                i++;
            }
            // Decrement j until we find an element smaller than the pivot
            while (arr.get(j) > pivot) {
                j--;
            }
            if (i < j) {
                Collections.swap(arr, i, j); // Swap elements at i and j
            }
        }
        // Place the pivot at the correct position
        Collections.swap(arr, low, j);
        return j; // Return the index of the pivot
    }
}
