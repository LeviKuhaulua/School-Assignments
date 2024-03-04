/**
 * Store a collection of key-value pairs. In which, data can be added to the "bag"
 * by inserting a key associated with a value. To modify an item inside the bag, 
 * the key that is associated wtih the value must be specified. 
 * 
 * @author <A HREF="MAILTO:levi.kuhaulua@outlook.com">Levi Kuhaulua</A> 
 * @version 21.0.1 
*/

public class KeyedBag {
    
    private int[] keys; 
    private String[] items; 
    private int currentItems; 

    /**
     * No Argument Constructor that creates a new instance of a keyed bag. 
     * @postcondition 
     *  Instantiate a new <B>EMPTY</B> keyed bag that can take in key-value pairs. 
     */
    public KeyedBag() {
        final int minCapacity = 10; 
        this.keys = new int[minCapacity]; 
        this.items = new String[minCapacity];
        this.currentItems = 0; 
    }

    /**
     * Create a new instance of a keyed bag with a specified capacity. 
     * @param specCapacity A minimum capacity specified by the program. 
     * @precondition 
     *  {@code specCapacity} should not be a negative number or 0. 
     * @postcondition 
     *  Instantiate a new <B>EMPTY</B> keyed bag wtih a specified length of key-value pairs that it can take. 
     * @exception IllegalArgumentException 
     *  if {@code specCapacity} is less than or equal to 0. 
     */
    public KeyedBag(int specCapacity) {
        if (specCapacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity. Cannot be less than or equal to 0.");
        }
        this.keys = new int[specCapacity]; 
        this.items = new String[specCapacity]; 
        this.currentItems = 0; 
    }

    // Problems: Consider where array would be out of bounds from currentItems. 
    // Problems: Consider where key matches another key? 
    public void add(int key, String value) {
        currentItems++; 
        keys[currentItems] = key; 
        items[currentItems] = value; 
    }


    /**
     * Returns the size of the Keyed Bag. 
     * @postcondition 
     *  Return an {@code int} number that represents the size of the bag. 
     */
    public int size() {
        return currentItems; 
    }

    /**
     * Return the capacity of items that the Keyed Bag instance can hold. 
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