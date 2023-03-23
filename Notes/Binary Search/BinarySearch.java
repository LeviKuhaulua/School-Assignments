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
        int wantedValue = 10; 
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8}; 
        // Iterative Method
        // int index = ItBinarySearch(array, wantedValue); 
        // if (index == -1) System.out.println("Value not found");
        // else System.out.println("Value is at index: " + index);

        // Recursive Method 
        int index = RecBinarySearch(array, wantedValue, 0, array.length - 1); 
        if (index == -1) System.out.println("Value not found");
        else System.out.println("Value is at index: " + index);
    }

    /**
     * IbinarySearch is the iterative method to the binary search to find the index of a specified value. 
     * @param array - array we are searching for the value 
     * @param value - value that we want to find
     * @return the position of the value or -1 if not found at all. 
     */
    public static int ItBinarySearch(int[] array, int value) {
        int max, min, midpoint, position; 
        max = array.length - 1; 
        min = 0; 
        position = -1; // Initialized to -1 in case not found

        // To isolate the possible locations of the value
        while (min <= max) {
            midpoint = (max + min) / 2; 
            // Checks to see if the midpoint value is the target value 
            if (array[midpoint] == value) {
                position = midpoint; 
                return position; 
            }  
            else if (array[midpoint] > value) {
                max = midpoint - 1; // Set max to be the index right before midpoint
            } else {
                min = midpoint + 1; // Set min to be the index right after midpoint 
            }
        }
       
        return position; // Returns the index of value or -1 if not found. 
        
    }

    /**
     * RecBinarySearch is the recursive method to doing a binary search to find the index of a specified value. 
     * @param array - array that we need to search
     * @param value - target value 
     * @param min - the minimum index of the array
     * @param max - the maximum of the array. 
     * @return the index that the value is found or -1 if not found in array. 
     */
    public static int RecBinarySearch(int[] array, int value, int min, int max) {
        int midpoint, position; 
        position = -1; // Initializing position in case value isn't found 

        while (min <= max) {
            midpoint = (max + min) / 2; 
            
            if (array[midpoint] == value) {
                position = midpoint; 
                return position; 
            } 
            else if (array[midpoint] > value) {
                return RecBinarySearch(array, value, min, (midpoint - 1));
            } else {
                return RecBinarySearch(array, value, (midpoint + 1), max); 
            }
        }

        return position; 
    }

    
}

