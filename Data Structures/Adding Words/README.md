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
- `calc` command - there can be up to 15 variables ending with an `=` sign. 
- `clear` command - forget all of it's previous definitions. 

## Output

Output the equation and result for each `calc` command. If there is a variable with no defined value in the `calc` command, the result will be `unknown`. Also note that if the result is equal to a variable, the variable should be outputted. 

Examples of Output: 

```
foo + bar = unknown 
baz + boo = Programming <-- means that Programming has the same value as baz + boo
foo + baz = 5
```

## Thought Process

- Variables will be defined with some integer value. In other words, we can use a Key-Value Pair or `HashMap`. 
- `calc`: need to consider if variables were defined before being used. 
- `calc`: Also need to consider how we will do the arithmetic operations. 
- `calc`: Need to consider if result is equal to a variable. 
- Output: Make sure it follows format of `expression = result`. 

