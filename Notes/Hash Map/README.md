# Hash Maps

__How do Hash Maps work and what are some useful operations for them__

### What are Hash Maps
Hash Maps contain key-based values or a key that points to that specific value

- Search for an element via the key associated with it 

**Consider elements in a Hash Map as having some sort of relation with the key**

- Person and their ID number 
- Animal and it's type 
- A team and it's win/loss record 

### Creating a Hash Map 
Syntax >> `HashMap(key, value) name = new HashMap<>();`

- for key and value of primitive data types >> they have to be the Wrapper Class Version
    - Incorrect Syntax >> `HashMap(String, integer) score = new HashMap<>();` 
    - Correct Syntax >> `HashMap(String, Integer) score = new HashMap<>();`
- Can have key/value be of a class 
    - Example: `HashMap(BankAccount, Integer) accountNumber = new HashMap<>();`

Adding Elements >> `name.put(key, value);` 

Printing Elements >> `System.out.println(name)`

- No need for a `.toString()` method. 
- Can print just keys and values 
    - Keys >> `System.out.println(name.keySet());`
    - Values >> `System.out.println(name.values());`

Removing Elements >> `name.remove(key)` 

### Updating Hash Map Elements 
**Many different ways to do it, no particular order** 
1. `put(key, value)` method 
   
    - Update the value if the key exists otherwise add a new element to Hash Map 

2. `replace(key, value)` method
    
    - Only updates the value if the key exists otherwise it does nothing 

3. `putIfAbsent(key, value)` method
    
    - Only updates Hash Map if key doesn't exist otherwise it does nothing 

4. `putAll(HashMap)` method
   
    - adds all element of one Hash Map into Hash Map of same type 
        - same key and value 
        - will update values of existing keys 

### Getting Elements in Hash Map 

Method >> `get(key);` will find the value associated with key 

- returns `null` if key isn't there 


### Some Boolean Operations 

1. Check for Key >> `containsKey(key)`
    - true or false 
2. Check for Value >> `containsValue(value)`
    - true or false 





