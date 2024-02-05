# Statistician Homework

## From the book

Implement a class called `Statistician` that when initialized, can be given a sequence of double numbers.

Methods:

- `nextNumber` is used to feed numbers to the Statistician instance
- A method to get the length of the sequence
- A method to get the last number of the sequence
- A method to get the sum of all the numbers in the sequence
- A method to get the mean of the numbers in the sequence
- smallest number in the sequence
- largest number in the sequence
- methods should return `Double.NaN` if the sequence is empty except for `sum` and `length` which should return `0` if sequence is empty. 

<br>

Notes from the book:

- store only necessary information about the sequence (**NOT THE SEQUENCE ITSELF**) such as `Sequence Length`, `Sum of numbers in sequence`, `variables for last, smallest, and largest number in sequence`. `nextNumber` should update the private instance variable(s) when called.
