# Problem

Solution file to the [I've Been Everywhere Man](https://open.kattis.com/problems/everywhere) problem from Kattis. 

## Input 

- 1st line of input contains a positive integer indicating the number of test cases. 
- 1st line of each **Test Case** contains a single positive integer `n` that specifies the amount of flights taken. 
- The following `n` lines contains the name of a city. 
    - City names are only lowercase letters, have at least one letter and do not contain spaces. 

## Output 
An `int` value for each **Test Case** representing the number of distinct cities that have been visited. 

## Solution / Thought Process

We need to use a loop to continously output the number of distinct cities that have been visited for each test cases. Because the first line in the file specifies the amount of test cases we are going to loop over, we can use a `for loop` to iterate through each test case. Additionally, each test case specifies the amount of flights apart of it, therefore we can use another `for loop` to iterate through the flights. In other words we have a nested for loop: one to iterate through each test case, then another to iterate through each flight in their respective test case. 

For storing the distinct cities, we can use a `HashSet` because they do not allow duplicates to be added to the Set. Therefore, if the city doesn't exist, add it to the HashSet, and if it does, it won't add it. To output the number of distinct cities, we can simply output the size of the HashSet. 