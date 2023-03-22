/*
 * Binary Search: 
 * Need >> Sorted Array in ascending/descending order 
 * 
 * Principles: 
 * 1) Find midpoint of array 
 * 2) if it is midpoint then return 
 * 3) if greater than midpoint search right half of array
 * 4) if less than midpoint search left half of array
 * 5) repeat step 1 for left or right half of array 
 * 6) If still can't be found then return false 
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8}; 
        binarySearch(array); 
    }

    public static void binarySearch(int[] array) {
        
    }
}