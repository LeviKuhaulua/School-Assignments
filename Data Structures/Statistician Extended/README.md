# Homework 3 

# Task (from the book)

> Write a new static method to allow you to "add" two Statisticians. If `s1` and `s2` are two statisticians, then the result of adding them should be a new statistician that behaves as if it had all of the numbers of `s1` followed by all of the numbers of `s2`. 


# Note from the instructor 

The **add** method should not print anything nor should this method **<u>modify</u>** the two Statisticians objects. 

# Thought Process for Each Method

Last Number: 
- Is `s2` empty? If yes, then the last number will be determined by `s1.lastNumber`
- Is `s2` not empty? If yes, then the last number will be determined by `s2.lastNumber`
    - This will also be the case should `s1` and `s2` be non-empty Statisticians 

Sum:  <br> 
The `sum` of the new Statistician will be the result of `s1.sum` + `s2.sum`

Length: <br> 
The `length` of the new Statistician will be the sum of `s1.length` + `s2.length` 

Mean: <br> 
The `mean` can be calculated by the following formula: `(s1.sum + s2.sum) / (s1.length + s2.length)`

Maximum: <br> 
The `maximum` of the new Statistician can be determined by comparing `s1.maximum` with `s2.maximum`

Minimum: <br> 
The `minimum` of the new Statistician can be determined by comparing `s1.minimum` with `s2.minimum`

## Cases to Consider: 

What if `s1` is empty? <br> 
- Sum = `s2.sum` 
- Length = `s2.length` 
- Mean = `s2.sum / s2.length` 
- Maximum = `s2.maximum` 
- Minimum = `s2.minimum`

<br> 

What if `s2` is empty? <br> 
- Sum = `s1.sum`
- Length = `s1.sum` 
- Mean = `s1.sum / s1.length` 
- Maximum = `s1.maximum` 
- Minimum = `s1.minimum` 

<br> 

What if both are empty? <br> 

* Length and Sum will be 0
* Everything else should return `Double.NaN` 