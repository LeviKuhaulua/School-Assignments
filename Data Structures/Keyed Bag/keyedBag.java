/**
 * Store a collection of key-value pairs. In which, data can be added to the "bag"
 * by inserting a key associated with a value. To modify an item inside the bag, 
 * the key that is associated wtih the value must be specified. 
 * 
 * @author <A HREF="MAILTO:levi.kuhaulua@outlook.com">Levi Kuhaulua</A> 
 * @version 21.0.1 
*/
public class keyedBag implements Cloneable{
    
    private int[] keys; 
    private String[] items; 
    private int currentItems; 

    /**
     * No Argument Constructor that creates a new instance of a keyed bag. 
     * @postcondition 
     *  Instantiate a new <B>EMPTY</B> keyed bag that can take in key-value pairs. 
     */
    public keyedBag() {
        final int minCapacity = 10; 
        this.keys = new int[minCapacity]; 
        this.items = new String[minCapacity];
        this.currentItems = 0; 
    }

    /**
     * Create a new instance of a keyed bag with a specified capacity. 
     * @param specCapacity 
     *  A minimum capacity specified by the program. 
     * @precondition 
     *  {@code specCapacity} should not be a negative number or 0. 
     * @postcondition 
     *  Instantiate a new <B>EMPTY</B> keyed bag wtih a specified length of key-value pairs that it can take. 
     * @exception IllegalArgumentException 
     *  if {@code specCapacity} is less than or equal to 0. 
     * @exception OutOfMemoryError
     *  If the capacity of the keyedbag is some arbitrarily large number. 
     */
    public keyedBag(int specCapacity) {
        if (specCapacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity. Cannot be less than or equal to 0.");
        }
        this.keys = new int[specCapacity]; 
        this.items = new String[specCapacity]; 
        this.currentItems = 0; 
    }

    /**
     * Clone a keyedBag object.
     * @postcondition 
     *  Returns a new keyedBag object that can be modified without changing the original as well. 
     */
    public keyedBag clone() {
        keyedBag clonedBag; 

        try {
            clonedBag = (keyedBag) super.clone(); 
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement cloneable"); 
        }

        // Clone the arrays so that we can make modifications without changing the original. 
        clonedBag.keys = keys.clone(); 
        clonedBag.items = items.clone(); 
        
        return clonedBag; 
    }

    /**
     * Add a single key-value pair to the bag. 
     * @param key
     *  An {@code int} key value that is associated with an item.  
     * @param value
     *  The {@code String} item value associated with the key. 
     * @precondition 
     *  The key being added is a valid key. Meaning that it is not less than or equal to 0. 
     *  If you add an arbitrarily large number as the key, then it may result in arithmetic overflow. Thus, 
     *  you would get the IllegalArgumentException. 
     * @exception IllegalArgumentException
     *  If the key being added is a negative number or some randomly arbitrarily large number which may result in an 
     *  arithmetic overflow thus an IllegalArgumentException. 
     */
    public void add(int key, String value) {

        if (key <= 0) {
            throw new IllegalArgumentException("Can't have a negative number for the key"); 
        }

        
        if (checkForKey(key)) {
            throw new IllegalArgumentException("Key already exists in bag: " + key); 
        }
        
        currentItems++; 
        
        // Increase the size of the bag when the current amount of elements stored inside is the same as the keys array. 
        // You could also use items.length but here keys would fit better semantically 
        // because the central idea revolves around the keys as the access point / gateway to the item
        if (currentItems == keys.length) {
            ensureCapacity(keys.length * 2); 
        }
        
        keys[currentItems - 1] = key; 
        items[currentItems - 1] = value; 
    }

    /**
     * Add multiple key-value pairs to the bags. 
     * @param keyElements
     *  {@code int} array of keys to feed to the bag 
     * @param itemsElements
     *  {@code String} array of items to feed to the bag. 
     * @postcondition
     *  Add the key-value pairs to the bags. 
     */
    public void addMany(int[] keyElements, String[] itemsElements) {
        
        if (checkForKey(keyElements)) {
            throw new IllegalArgumentException("Cannot add a key to a bag that already contains said key"); 
        }

        if (currentItems + keyElements.length > keys.length) {
            ensureCapacity((keyElements.length + currentItems) * 2); 
        }
        
        // Copy over the keys and items to their respective arrays. 
        System.arraycopy(keyElements, 0, keys, currentItems, keyElements.length); 
        System.arraycopy(itemsElements, 0, items, currentItems, itemsElements.length); 
        
        currentItems += keyElements.length; 
    }

    /**
     * Create a new bag that has all the elements from the other two bags. 
     * @param a
     *  the first keyedBag object
     * @param b
     *  the second keyedBag object
     * @preconditon
     *  Neither bag is null. 
     * @postcondition
     *  A new bag that has all the elements from the other two bags. 
     * @exception NullPointerException
     *  When one of the keyedBag objects are null. 
     */
    public static keyedBag union(keyedBag a, keyedBag b) {
        keyedBag unionBag = new keyedBag(a.getCapacity() + b.getCapacity()); 

        // Copy the keys from both bag into new bag. 
        System.arraycopy(a.keys, 0, unionBag.keys, 0, a.currentItems); 
        System.arraycopy(b.keys, 0, unionBag.keys, a.currentItems, b.currentItems); 

        // Copy the items from both bag into new bag. 
        System.arraycopy(a.items, 0, unionBag.items, 0, a.currentItems); 
        System.arraycopy(b.items, 0, unionBag.items, a.currentItems, b.currentItems);

        unionBag.currentItems = a.currentItems + b.currentItems; 
        return unionBag; 
    }

    /**
     * Add key-value pairs from another {@code keyedBag} to the current one. 
     * @param addend
     *  A {@code keyedBag} object that will be added to the current bag. 
     * @postcondition
     *  Adds all the key-value pairs from {@code addend} to the current bag. 
     * @exception NullPointerException
     *  If {@code addend} is null then it will throw a NullPointerException. 
     */
    public void addAll(keyedBag addend) {
        
        ensureCapacity((addend.currentItems + currentItems) * 2);

        // Copy keys from addend keyedBag. 
        System.arraycopy(addend.keys, 0, keys, currentItems, addend.currentItems); 

        // Copy items from addend keyedBag
        System.arraycopy(addend.items, 0, items, currentItems, addend.currentItems); 
        
        currentItems += addend.currentItems; 
    }

    /**
     * Remove a key-value pair from the bag. 
     * @param target
     *  The {@code int} search key that needs to be removed from the bag. 
     * @precondition
     *  The key being searched is a valid key. Valid meaning that it is not negative or equal to 0. 
     * @postcondition 
     *  Removes the key-value pair from the bag should that be specified. 
     * @exception IllegalArgumentException
     *  If the target search key is an invalid search key. See precondition. 
     */
    public boolean remove(int target) {
        
        if (target <= 0) {
            throw new IllegalArgumentException("Target search key cannot be less than or equal to 0."); 
        }

        int index; 

        // Iterate through the array and check if the index is equal to the target. 
        for (index = 0; (index < currentItems) && (target != keys[index]); index++) {
        }

        // If it went through the array without finding the target search key. 
        if (index == currentItems) {
            return false; 
        } else { // if it found the target search key. 

            // Remove the key-value pair from the array. 
            // For Key value replace the removed value with 0 
            // For Item value replace the removed value with null
            System.arraycopy(keys, index + 1, keys, index, keys.length - index - 1); 
            System.arraycopy(items, index + 1, items, index, items.length - index - 1); 

            currentItems--; 
            return true; 
        } 
    }

    /**
     * Retrieve an item by searching for it's key. If the key is found then return the item. Otherwise return {@code null}. 
     * @param srchKey
     *  An {@code int} key that will be searched in the array.
     * @precondition
     *  The key being searched is a valid key. Valid meaning that it is not negative or equal to 0. 
     * @postcondition
     *  Return a {@code String} value that represents the item associated with the key or {@code null} if the key was not found. 
     * @exception IllegalArgumentException
     *  If the search key is an invalid search key. See precondition. 
     */
    public String getItem(int srchKey) {

        if (srchKey <= 0) {
            throw new IllegalArgumentException("Target search key cannot be negative or equal to 0."); 
        }
       
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == srchKey) { 
                // Can return items[i] because key-value pair will always be at the same index. 
                return items[i]; 
            }
        }

        return null; 
        
    }

    /**
     * Allocate more space for the keys and items array so that it can take in more items. 
     * @param minCapacity 
     *  the new capacity of the bag. 
     * @precondition
     *  The capacity is a valid integer. Valid meaning that it is not negative or equal to 0. 
     * @postcondition 
     *  Allocate a bigger capacity for the keys and items array. 
     * @exception IllegalArgumentException
     *  If the capacity is an invalid integer. See precondition. 
     * @exception OutOfMemoryError 
     *  If the capacity of the bag is some arbitrarily large number, then it will throw an OutOfMemoryError. 
     */
    public void ensureCapacity(int minCapacity) {
        int[] destKeyArray; 
        String[] destItemsArray; 

        if (minCapacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be less than or equal to 0: " + minCapacity); 
        }
        
        // Copying the keys array to a bigger array. 
        if (keys.length < minCapacity) {
            destKeyArray = new int[minCapacity]; 
            System.arraycopy(keys, 0, destKeyArray, 0, currentItems);
            keys = destKeyArray;
        }
         
        // Copying the items array to a bigger array
        if (items.length < minCapacity) {
            destItemsArray = new String[minCapacity]; 
            System.arraycopy(items, 0, destItemsArray, 0, currentItems); 
            items = destItemsArray; 
        } 
        
    }

    /**
     * Reduce the array size to reflect the actual amount of elements within the keyed bag. 
     * @postcondition
     *  Shortens the keys and items array so that it now reflects the current size of the bag. 
     */
    public void trimToSize() {
        int[] trimmedKeysArray; 
        String[] trimmedItemsArray; 

        // Trim the keys array to the actual amount of elements inside array. 
        if (keys.length != currentItems) {
            trimmedKeysArray = new int[currentItems]; 
            System.arraycopy(keys, 0, trimmedKeysArray, 0, currentItems); 
            keys = trimmedKeysArray; 
        }

        // Trim the items array to the actual amount of elements inside array. 
        if (items.length != currentItems) {
            trimmedItemsArray = new String[currentItems]; 
            System.arraycopy(items, 0, trimmedItemsArray, 0, currentItems); 
            items = trimmedItemsArray; 
        }
    }


    /**
     * Search for the target key in the bag and return a boolean value representing the results of the search. 
     * @param 
     *  target the key to be searched for. 
     * @precondition
     *  The key being searched is a valid key. Valid meaning that it is not negative or equal to 0. 
     * @postcondition
     *  Return a {@code boolean} value that represents if the target key was found or not. 
     * @exception 
     *  IllegalArgumentException if the target key being searched in the bag is less than or equal to 0. 
     */
    public boolean checkForKey(int target) {
        if (target <= 0) {
            throw new IllegalArgumentException("Invalid target key: " + target); 
        }

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == target) {
                return true;  
            } 
        }
        // If not found in keys array then return false. 
        return false; 
    }

    /**
     * Checks if potential keys to be added to bag are already in the bag. 
     * @param target 
     *  an {@code int} array of key values. 
     * @postcondition
     *  Return a {@code boolean} value representing if any of the keys were found in the {@code keys} array. 
     * @exception IllegalArgumentException
     *  If any of the search keys in the {@code target} array are negative key values. 
     */
    public boolean checkForKey(int[] target) {

        for (int i = 0; i < target.length; i++) {
            // Checks if target search key is an invalid key. 
            if (target[i] < 0) {
                throw new IllegalArgumentException("Can't add a negative key value: " + target[i]); 
            }

            for (int j = 0; j < keys.length; j++) { 
                if (target[i] == keys[j]) {
                    return true; 
                }
            }
        }

        return false; 

    }

    /**
     * Getter method to return the size of the bag. Size means the actual amount of elements stored in the bag. 
     * @postcondition 
     *  Return an {@code int} number that represents the amount of items currently in the bag. 
     */
    public int size() {
        return currentItems; 
    }

    /**
     * Getter method to return the capacity of the bag. Capacity means the amount of elements the bag could store. 
     * @postcondition
     *  Return an {@code int} number that represents the capacity of the bag. 
     *  <P> 
     *     <B>NOTE:</B> This is different from {@code size()} because this returns the capacity that 
     *      the bag can hold, while {@code size()} will return the current amount of items in the bag. 
     *  </P> 
     * @see size
     */
    public int getCapacity() {
        return keys.length; 
    }

}