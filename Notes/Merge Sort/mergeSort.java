/*
 * Merge Sort Algorithm: 
 * Needs >> Unsorted Array, Helper Array
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
        for (int i : array) System.out.println(i);
    }

    /**
     * MergeSort - allocates a helper array to help with sorting then calls a helper method
     * @param array - unsorted array
     */
    public static void MergeSort(int[] array) {
        int[] helperArray = new int[array.length]; 
        MergeSort(array, helperArray, 0, (array.length - 1)); 
    }
    /**
     * MergeSort - helper method that will sort the array. 
     * @param array - unsorted array
     * @param helper - helper array for sorting 
     * @param min - minimum index of the array 
     * @param max - maximum index of the array 
     */
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
        for (int i = 0; i < array.length; i++) helper[i] = array[i]; 

        // Compare Elements
        int leftIndex = min; 
        int rightIndex = middleRight; 
        int dst = min; // for sorted array

        while (leftIndex <= middleLeft && rightIndex <= max) {
            if(helper[leftIndex] < helper[rightIndex]) {
                array[dst] = helper[leftIndex]; 
                leftIndex++; 
            } else {
                array[dst] = helper[rightIndex]; 
                rightIndex++; 
            }
            dst++; 
        }

        // Add leftovers of left partition
        while (leftIndex <= middleLeft) {
            array[dst] = helper[leftIndex];
            leftIndex++;
            dst++; 
        }

        // Add leftovers of right partition
        while (rightIndex <= max) {
            array[dst] = helper[rightIndex]; 
            rightIndex++;
            dst++;  
        }
    }
}