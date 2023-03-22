/*
 * Quicksort Algorithm: 
 * 
 * Principles: 
 * 1) Choose a pivot element - beginning, middle, random, or ending element 
 * 2) Have two indexes that sort the array based on the pivot 
 *  - Everything to the left is less than pivot, and everything on right is greater than pivot 
 * 3) Do the same for left and right parts of array 
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] integerArray = {0, 5, 1, 9, 2, 6, 3, 8, 4, 7}; 
        System.out.println("Unsorted Array: ");
        for (int i : integerArray) System.out.print(i + " ");
        quickSort(integerArray); 
        System.out.println("\nSorted Array: ");
        for (int i : integerArray) System.out.print(i + " ");
        
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int min, int max) {
        // Base Case: 
        if (min >= max) return; 

        // Before Recursive Call >> Sort elements around pivot
        int pivot, minIndex, maxIndex, temp; 
        pivot = array[max]; 
        minIndex = min; 
        maxIndex = max; 
        // Sort elements based on pivot 
        while(minIndex < maxIndex) {
            while (array[minIndex] <= pivot && minIndex < maxIndex) minIndex++; 
            while (array[maxIndex] >= pivot && minIndex < maxIndex) maxIndex--; 

            temp = array[minIndex]; 
            array[minIndex] = array[maxIndex];
            array[maxIndex] = temp; 
        }
        
        // Put pivot in final location
        temp = array[minIndex]; 
        array[minIndex] = pivot; 
        array[max] = temp; 

        // Recursive Call
        quickSort(array, min, minIndex - 1); 
        quickSort(array, minIndex + 1, max); 
    }
}