# Problem 

Solution to the [Adding Words](https://open.kattis.com/problems/addingwords) found on Kattis. 

## Input

Given a sequence of commands (up to 2000) you can be given one of the three commands: 

- `def {variable name} {value}`
- `calc {var1} {operation1} {var2} ... {varN} {operationN} {varN+1} = `
- `clear` 

<br> 

Commands in Detail 
- `def` command - Value can be from range [-1000, 1000]. If variable had been defined previously, new value will overwrite previous value. 
- `calc` command - there can be up to 15 variables ending with an `=` sign. Arithmetic operations can either be `+` or `-` 
- `clear` command - forget all of it's previous definitions. 

## Output

Output the equation and result for each `calc` command. If there is a variable with no defined value in the `calc` command or if the result does not match any of the numbers mapped with a word, the result will be `unknown`. If the result is mapped with a word, then output the word. 

Examples of Output: 

```
foo + bar = unknown 
baz + boo = Programming <-- means that Programming has the same value as baz + boo
foo + baz = unknown <-- baz was defined but result / total did not equal to any number mapped with a word. 
```

## Thought Process

Words are paired with a number, that means we can use a `HashMap` to store the Key (word) with the Value (number). See thought process below for each command. 

`clear`: If clear is called then simply reduce the size of the `HashMap` back to 0. Thing to think about: What if input includes an argument with `clear`. 

`def`: Format always follows `word value` after the `def` command, so we can add the Key-Value pair to the HashMap with the second element being the Key, and the third element being the Value. Thing to think about: What if there are multiple values for one value? 

`calc`: Format will always begin with `calc` and ending with `=`, we just need to focus on the variables and expressions within. We can do the following: 

1. Check the word and see if it exists within the `HashMap` if it does, then convert to the number mapping. If it doesn't then break out and output the equation with `unknown` at the end. 
2. Check the operation after the word, and then have something to store the operation for later use. 
3. Check the next word based on conditions of step 1 and run calculation if valid. 
4. Repeat steps 1 - 3 until we reach the end (denoted by equal sign). 
5. Check the result and see if it mapped to a word, if it is then output that, otherwise output `unknown`

Things to think about: 
- What if operations different from +/- are inputted? 
- What if result is mapped to multiple words? 

