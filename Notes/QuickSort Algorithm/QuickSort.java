/*
 * Quicksort Algorithm: 
 * 
 * Principles: 
 * 1) Choose a pivot element - beginning, middle, random, or ending element 
 * 2) Have two indexes that sort the array based on the pivot 
 *  - Everything to the left is less than pivot, and everything on right is greater than pivot 
 * 3) Do the same for left and right parts of array 
 */
import java.util.*; 
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
        int pivot = array.length - 1; // Sets the last element of the array as the pivot
        int max = pivot - 1; // Ignores the pivot element
        quickSort(array, 0, max, pivot); 
    }

    private static void quickSort(int[] array, int min, int max, int pivot) {
        // Base Case: 
        if (min == max) return; 

        // Sort elements around pivot
        int temp; // for swapping
        while (min < max) {
            if (array[min] < array[pivot]) min++; 
            if (array[max] > array[pivot]) max--; 
            temp = array[min]; 
            array[min] = array[max]; 
            array[max] = temp; 
        }
        
        // Put pivot into right place
        temp = array[pivot]; 
        array[pivot] = array[++max]; 
        array[max] = temp; 
        
        
       

    

    }
}