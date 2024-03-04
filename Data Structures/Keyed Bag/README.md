# Tasks

From the book (pg 173): 

- [ ] Implement a keyed bag that stores numbers as `keys` and Strings as the data / information. 
- [ ] A boolean method that can determine if a bag contains an item with a specified key. 
- [ ] Method to remove an item using the key.  
- [ ] Method to retrieve an item using the key. 

<br> 

Instructor Comments / Notes: 

Take a look at the functions of the non-keyed bag class functions. Then determine the following: 

- Should you include the function? 
- If so, how might you change it up to fit the requirements of a keyed bag? 
- If not, why was it not included? 

<!-- TODO: Include in cover page ^^ -->

<br>

Constructors and methods from `Bag.java`: 

1. public IntArrayBag() 
2. public IntArrayBag(int InitialCapacity)
3. public void add(int element)
4. public void addMany(int... elements) 
5. public void addAll(IntArrayBag addend) 
6. public IntArrayBag clone()
7. public int countOccurrences(int target)
8. public void ensureCapacity(int minimumCapacity) 
9. public int getCapacity() 
10. public boolean remove(int target) 
11. public int size() 
12. public void trimToSize() 
13. public static IntArrayBag union(IntArrayBag b1, IntArrayBag b2)