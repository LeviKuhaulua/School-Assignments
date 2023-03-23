/*
 * Merge Sort Algorithm: 
 * Needs >> Unsorted Array 
 * 
 * Principles: 
 * Take the unsorted array 
 * Partition the array until you have 1 element in each partition 
 * Merge arrays >> this is where sorting occurs 
*/ 
public class mergeSort {
    public static void main(String[] args) {
        int[] array = {14, 91, -52, 79, 47, 86, 75, 36, -26, -44};
        MergeSort(array); 
    }

    public static void MergeSort(int[] array) {
        int[] helperArray = new int[array.length - 1]; 
        MergeSort(array, helperArray, 0, (array.length - 1)); 
    }

    private static void MergeSort(int[] array, int[] helper, int min, int max) {
        // Base Case
        if (min == max) return; 

        // Before Action
        // Partition Array
        int middleLeft = (int) Math.floor((max + min) / 2); 
        int middleRight = middleLeft + 1; 

        // Recursive Call 
        MergeSort(array, helper, 0, middleLeft); 
        MergeSort(array, helper, middleRight, max); 

        // After Action
        // Copy elements into helper array
        for (int i : array) helper[i] = i; 

        // Compare Elements
    }
}